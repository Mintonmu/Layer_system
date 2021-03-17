
package com.sxl.controller.admin;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxl.controller.MyController;

@Controller("TjController")
@RequestMapping(value = "/admin/tj")
public class TjController extends MyController {
	

	@RequestMapping(value = "/tj1")
	public String frame(Model model, HttpServletRequest request,String flag)throws Exception {
		String sql="select date_format(insertDate,'%y-%m-%d') days,sum(allPrice) price from t_order group by date_format(insertDate,'%y-%m-%d')";
		List<Map> list = db.queryForList(sql);
		String aa="";
		String bb="";
		if(list!=null&&list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				if(i==0){
					aa="'"+list.get(i).get("days")+"'";
					bb = list.get(i).get("price")+"";
				}else{
					aa+=",'"+list.get(i).get("days")+"'";
					bb +=","+ list.get(i).get("price")+"";
				}
			}
		}
		model.addAttribute("aa", aa);
		model.addAttribute("bb", bb);
		return "/admin/tj/tj1";
	}
	
	@RequestMapping(value = "/tj2")
	public String tj2(Model model, HttpServletRequest request,String flag)throws Exception {
		
		
		
		return "/admin/tj/tj2";
	}
	
	@RequestMapping(value = "/tj3")
	public String tj3(Model model, HttpServletRequest request,String flag)throws Exception {
		String sql="select * from t_product order by djl desc";
		List<Map> list = db.queryForList(sql);
		model.addAttribute("list", list);
		
		return "/admin/tj/tj3";
	}
	
	@RequestMapping(value = "/tj4")
	public String tj4(Model model, HttpServletRequest request,String flag)throws Exception {
		String sql="select a.*,(select  count(1) from t_sc b where b.productId=a.id) scl from t_product a order by scl desc";
		List<Map> list = db.queryForList(sql);
		model.addAttribute("list", list);
		return "/admin/tj/tj4";
	}
	 
	 
}
