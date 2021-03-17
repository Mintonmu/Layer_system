package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.ScDao;
import com.sxl.model.Sc;
import com.sxl.util.PageTool;

@Service("ScService")
public class ScService extends BaseService{
	
	@Autowired
	public ScDao scDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param sc
	 * @return
	 */
	public List<Sc> getScList(HttpServletRequest request,Sc sc){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =scDao.countAll(sc);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		sc.setBegin(begin);
		sc.setPage_num(page_num);
		List<Sc> list = scDao.queryForList(sc);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return scDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Sc getSc(HttpServletRequest request,Long id){
		return scDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Sc sc){
		return scDao.insert(sc);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param sc
	 * @return
	 */
	public int update(HttpServletRequest request,Sc sc){
		return scDao.update(sc);
	}
}
