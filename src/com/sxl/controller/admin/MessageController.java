
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("messageController")
@RequestMapping(value = "/admin/message")
public class MessageController extends MyController {
	

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		return "/admin/message/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request,String flag)throws Exception {
		String sql="select customerId,(select max(name) from t_customer b where a.customerId=b.id) name from t_message a group by customerId";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/message/list";
	}
	
	@RequestMapping(value = "/jiaoliu")
	public String detail123(Model model, HttpServletRequest request,String flag,Long customerId)throws Exception {
		String sql="select a.*  from t_message a where 1=1";
		sql+=" and customerId="+customerId;
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		System.out.println(sql);
		request.setAttribute("list", list);
		return "/admin/message/jiaoliu";
	}
	
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id,String flag
		,Integer customerId,String messageContent,String insertDate) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_message set messageContent=? where id=?";
			result = db.update(sql, new Object[]{messageContent,id});
		}else{
			String sql="insert into t_message(customerId,messageContent,insertDate) values(?,?,now())";
			result = db.update(sql, new Object[]{getCustomer(request).get("id"),messageContent});
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/messageSave")
	public ResponseEntity<String> messageSave(Model model,HttpServletRequest request,Long id,String flag
		,Integer customerId,String messageContent,String insertDate) throws Exception{
		int result = 0;
		String sql="insert into t_message(customerId,messageContent,insertDate,types) values(?,?,now(),2)";
		result = db.update(sql, new Object[]{customerId,messageContent});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model,HttpServletRequest request,Long id,String flag) throws Exception {
		
		String sql="delete from t_message where id=?";
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
			String sql="select * from t_message where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

		return "/admin/message/edit";
	}
}
