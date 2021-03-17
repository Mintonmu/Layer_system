
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("shopcarController")
@RequestMapping(value = "/admin/shopcar")
public class ShopcarController extends MyController {
	

	@RequestMapping(value = "/frame")
	public String frame(Model model, HttpServletRequest request)throws Exception {
		return "/admin/shopcar/frame";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model, HttpServletRequest request)throws Exception {
		String sql="select a.*,(select productName from t_product b where a.productId=b.id) productName  from t_shopcar a where 1=1";
		sql+=" order by id desc";
		List list = db.queryForList(sql);
		request.setAttribute("list", list);
		return "/admin/shopcar/list";
	}
	
	@RequestMapping(value = "/editSave")
	public ResponseEntity<String> editSave(Model model,HttpServletRequest request,Long id
		,Integer productId,Integer num) throws Exception{
		int result = 0;
		if(id!=null){
			String sql="update t_shopcar set productId=?,num=? where id=?";
			result = db.update(sql, new Object[]{productId,num,id});
		}else{
			String sql="insert into t_shopcar(productId,num) values(?,?)";
			result = db.update(sql, new Object[]{productId,num});
		}
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
	}
	
	@RequestMapping(value = "/editDelete")
	public ResponseEntity<String> editDelete(Model model,HttpServletRequest request,Long id) throws Exception {
		
		String sql="delete from t_shopcar where id=?";
		int result = db.update(sql, new Object[]{id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	@RequestMapping(value = "/updateColumnproductId")
	public ResponseEntity<String> updateColumnproductId(Model model,HttpServletRequest request,Long id,String productId) throws Exception {
		
		String sql="update t_shopcar set productId=?   where id=?";
		int result = db.update(sql, new Object[]{productId,id});
		if(result==1){
			return renderData(true,"操作成功",null);
		}else{
			return renderData(false,"操作失败",null);
		}
		
	}
	
	@RequestMapping(value = "/edit")
	public String edit(Model model, HttpServletRequest request,Long id)throws Exception {
		if(id!=null){
			//修改
			String sql="select * from t_shopcar where id=?";
			Map map = db.queryForMap(sql,new Object[]{id});
			model.addAttribute("map", map);
		}String sql="";

 sql="select * from t_product";
model.addAttribute("productList", db.queryForList(sql));

		return "/admin/shopcar/edit";
	}
}
