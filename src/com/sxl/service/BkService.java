package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.BkDao;
import com.sxl.model.Bk;
import com.sxl.util.PageTool;

@Service("BkService")
public class BkService extends BaseService{
	
	@Autowired
	public BkDao bkDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param bk
	 * @return
	 */
	public List<Bk> getBkList(HttpServletRequest request,Bk bk){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =bkDao.countAll(bk);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		bk.setBegin(begin);
		bk.setPage_num(page_num);
		List<Bk> list = bkDao.queryForList(bk);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return bkDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Bk getBk(HttpServletRequest request,Long id){
		return bkDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Bk bk){
		return bkDao.insert(bk);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param bk
	 * @return
	 */
	public int update(HttpServletRequest request,Bk bk){
		return bkDao.update(bk);
	}
}
