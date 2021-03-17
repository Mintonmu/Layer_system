package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.PinglunDao;
import com.sxl.model.Pinglun;
import com.sxl.util.PageTool;

@Service("PinglunService")
public class PinglunService extends BaseService{
	
	@Autowired
	public PinglunDao pinglunDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param pinglun
	 * @return
	 */
	public List<Pinglun> getPinglunList(HttpServletRequest request,Pinglun pinglun){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =pinglunDao.countAll(pinglun);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		pinglun.setBegin(begin);
		pinglun.setPage_num(page_num);
		List<Pinglun> list = pinglunDao.queryForList(pinglun);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return pinglunDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Pinglun getPinglun(HttpServletRequest request,Long id){
		return pinglunDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Pinglun pinglun){
		return pinglunDao.insert(pinglun);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param pinglun
	 * @return
	 */
	public int update(HttpServletRequest request,Pinglun pinglun){
		return pinglunDao.update(pinglun);
	}
}
