package com.sxl.controller.admin;

import com.sxl.controller.MyController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * 消息
 *
 * @author Administratorxxxx
 * @date2019-03-04
 */
@Controller("xiaoxiController")
@RequestMapping(value = "/admin/xiaoxi")
public class XiaoxiController extends MyController {


    /**
     * 查询frame
     */
    @RequestMapping(value = "/frame")
    public String frame(Model model, HttpServletRequest request, String flag) throws Exception {
        return "/admin/xiaoxi/frame";
    }

    /**
     * 查询列表
     */
    @RequestMapping(value = "/list")
    public String list(Model model, HttpServletRequest request, String flag, String title) throws Exception {
        //select date_format(insertDate, '%Y-%m-%d %H:%i:%s')
        //CONVERT(varchar, insertDate, 120 )
        //to_char(insertDate,'yyyy-mm-dd,hh24:mi:ss')

        String sql = "select a.*,(select customerName from t_customer b where a.customerId=b.id) customerName  from t_xiaoxi a where 1=1 ";


        if (title != null && !"".equals(title)) {
            sql += " and title like '%" + title + "%'";
        }
        sql += " order by id desc";
        List list = db.queryForList(sql);
        request.setAttribute("list", list);
        return "/admin/xiaoxi/list";
    }

    /**
     * 编辑保存（包含修改和添加）
     */
    @RequestMapping(value = "/editSave")
    public ResponseEntity<String> editSave(Model model, HttpServletRequest request, Long id, String flag
            , Integer customerId, String title, String content, String insertDate) throws Exception {
        int result = 0;
        if (id != null) {
            String sql = "update t_xiaoxi set customerId=?,title=?,content=? where id=?";
            result = db.update(sql, new Object[]{customerId, title, content, id});
        } else {
            String sql = "insert into t_xiaoxi(customerId,title,content,insertDate) values(?,?,?,now())";
            result = db.update(sql, new Object[]{customerId, title, content});
        }
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }
    }

    /**
     * 删除信息
     */
    @RequestMapping(value = "/editDelete")
    public ResponseEntity<String> editDelete(Model model, HttpServletRequest request, Long id, String flag) throws Exception {

        String sql = "delete from t_xiaoxi where id=?";
        int result = db.update(sql, new Object[]{id});
        if (result == 1) {
            return renderData(true, "操作成功", null);
        } else {
            return renderData(false, "操作失败", null);
        }

    }

    /**
     * 跳转到编辑页面
     */
    @RequestMapping(value = "/edit")
    public String edit(Model model, HttpServletRequest request, Long id, String flag) throws Exception {
        if (id != null) {
            //修改
            String sql = "select * from t_xiaoxi where id=?";
            Map map = db.queryForMap(sql, new Object[]{id});
            model.addAttribute("map", map);
        }
        String sql = "";

        sql = "select * from t_customer a where exists(select 1 from t_wdxx b where b.customerId=a.id and b.userId=" + getUser(request).get("id") + ")";
        model.addAttribute("customerList", db.queryForList(sql));

        return "/admin/xiaoxi/edit";
    }
}
