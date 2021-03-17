
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("jfdhController")
@RequestMapping(value = "/admin/jfdh")
public class JfdhController extends MyController {
	

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/jfdh/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag,String jfName)throws Exception {
		String sql="select a.* from t_jfdh a where 1=1";


	if(jfName!=null&&!"".equals(jfName)){
			sql+=" and jfName like '%"+jfName+"%'";
		}
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/jfdh/list";
	}
	
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id,String flag
		,String jfName,Integer jfCost,String jfPic) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_jfdh set jfName=?,jfCost=?,jfPic=? where id=?";
			result = db.update(sql, new Object[]{jfName,jfCost,jfPic,id});
		}else{
			String sql="insert into t_jfdh(jfName,jfCost,jfPic) values(?,?,?)";
			result = db.update(sql, new Object[]{jfName,jfCost,jfPic});
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model,HttpServletRequest request,Long id,String flag) throws Exception {
		
		String sql="delete from t_jfdh where id=?";
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
			String sql="select * from t_jfdh where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

		return "/admin/jfdh/edit";
	}
}
