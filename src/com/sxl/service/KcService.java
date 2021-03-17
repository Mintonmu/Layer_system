package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.KcDao;
import com.sxl.model.Kc;
import com.sxl.util.PageTool;

@Service("KcService")
public class KcService extends BaseService{
	
	@Autowired
	public KcDao kcDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param kc
	 * @return
	 */
	public List<Kc> getKcList(HttpServletRequest request,Kc kc){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =kcDao.countAll(kc);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		kc.setBegin(begin);
		kc.setPage_num(page_num);
		List<Kc> list = kcDao.queryForList(kc);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return kcDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Kc getKc(HttpServletRequest request,Long id){
		return kcDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Kc kc){
		return kcDao.insert(kc);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param kc
	 * @return
	 */
	public int update(HttpServletRequest request,Kc kc){
		return kcDao.update(kc);
	}
}
