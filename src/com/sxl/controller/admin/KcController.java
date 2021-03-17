
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("kcController")
@RequestMapping(value = "/admin/kc")
public class KcController extends MyController {
	

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/kc/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag)throws Exception {
		String sql="select a.*,(select productName from t_product b where a.productId=b.id) productName  from t_kc a where 1=1";


		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/kc/list";
	}
	
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id,String flag
		,Integer productId,Integer kcNum,String insertDate) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_kc set productId=?,kcNum=? where id=?";
			result = db.update(sql, new Object[]{productId,kcNum,id});
		}else{
			String sql="insert into t_kc(productId,kcNum,insertDate) values(?,?,now())";
			result = db.update(sql, new Object[]{productId,kcNum});
			sql="update t_product set nums=nums+"+kcNum+" where id="+productId;
			db.update(sql);
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model,HttpServletRequest request,Long id,String flag) throws Exception {
		
		String sql="delete from t_kc where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request,Long id,String flag)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_kc where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

 sql="select * from t_product";
model.addAttribute("productList", db.queryForList(sql));

		return "/admin/kc/edit";
	}
}
