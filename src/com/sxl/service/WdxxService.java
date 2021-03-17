package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.WdxxDao;
import com.sxl.model.Wdxx;
import com.sxl.util.PageTool;

@Service("WdxxService")
public class WdxxService extends BaseService{
	
	@Autowired
	public WdxxDao wdxxDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param wdxx
	 * @return
	 */
	public List<Wdxx> getWdxxList(HttpServletRequest request,Wdxx wdxx){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =wdxxDao.countAll(wdxx);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		wdxx.setBegin(begin);
		wdxx.setPage_num(page_num);
		List<Wdxx> list = wdxxDao.queryForList(wdxx);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return wdxxDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Wdxx getWdxx(HttpServletRequest request,Long id){
		return wdxxDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Wdxx wdxx){
		return wdxxDao.insert(wdxx);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param wdxx
	 * @return
	 */
	public int update(HttpServletRequest request,Wdxx wdxx){
		return wdxxDao.update(wdxx);
	}
}
