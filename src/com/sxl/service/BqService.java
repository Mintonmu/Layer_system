package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.BqDao;
import com.sxl.model.Bq;
import com.sxl.util.PageTool;

@Service("BqService")
public class BqService extends BaseService{
	
	@Autowired
	public BqDao bqDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param bq
	 * @return
	 */
	public List<Bq> getBqList(HttpServletRequest request,Bq bq){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =bqDao.countAll(bq);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		bq.setBegin(begin);
		bq.setPage_num(page_num);
		List<Bq> list = bqDao.queryForList(bq);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return bqDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Bq getBq(HttpServletRequest request,Long id){
		return bqDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Bq bq){
		return bqDao.insert(bq);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param bq
	 * @return
	 */
	public int update(HttpServletRequest request,Bq bq){
		return bqDao.update(bq);
	}
}
