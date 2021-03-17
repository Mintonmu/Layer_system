package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.OrderlistDao;
import com.sxl.model.Orderlist;
import com.sxl.util.PageTool;

@Service("OrderlistService")
public class OrderlistService extends BaseService{
	
	@Autowired
	public OrderlistDao orderlistDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param orderlist
	 * @return
	 */
	public List<Orderlist> getOrderlistList(HttpServletRequest request,Orderlist orderlist){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =orderlistDao.countAll(orderlist);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		orderlist.setBegin(begin);
		orderlist.setPage_num(page_num);
		List<Orderlist> list = orderlistDao.queryForList(orderlist);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return orderlistDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Orderlist getOrderlist(HttpServletRequest request,Long id){
		return orderlistDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Orderlist orderlist){
		return orderlistDao.insert(orderlist);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param orderlist
	 * @return
	 */
	public int update(HttpServletRequest request,Orderlist orderlist){
		return orderlistDao.update(orderlist);
	}
}
