package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.JfdhDao;
import com.sxl.model.Jfdh;
import com.sxl.util.PageTool;

@Service("JfdhService")
public class JfdhService extends BaseService{
	
	@Autowired
	public JfdhDao jfdhDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param jfdh
	 * @return
	 */
	public List<Jfdh> getJfdhList(HttpServletRequest request,Jfdh jfdh){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =jfdhDao.countAll(jfdh);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		jfdh.setBegin(begin);
		jfdh.setPage_num(page_num);
		List<Jfdh> list = jfdhDao.queryForList(jfdh);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return jfdhDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Jfdh getJfdh(HttpServletRequest request,Long id){
		return jfdhDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Jfdh jfdh){
		return jfdhDao.insert(jfdh);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param jfdh
	 * @return
	 */
	public int update(HttpServletRequest request,Jfdh jfdh){
		return jfdhDao.update(jfdh);
	}
}
