package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.XiaoxiDao;
import com.sxl.model.Xiaoxi;
import com.sxl.util.PageTool;

@Service("XiaoxiService")
public class XiaoxiService extends BaseService{
	
	@Autowired
	public XiaoxiDao xiaoxiDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param xiaoxi
	 * @return
	 */
	public List<Xiaoxi> getXiaoxiList(HttpServletRequest request,Xiaoxi xiaoxi){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =xiaoxiDao.countAll(xiaoxi);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		xiaoxi.setBegin(begin);
		xiaoxi.setPage_num(page_num);
		List<Xiaoxi> list = xiaoxiDao.queryForList(xiaoxi);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return xiaoxiDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Xiaoxi getXiaoxi(HttpServletRequest request,Long id){
		return xiaoxiDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Xiaoxi xiaoxi){
		return xiaoxiDao.insert(xiaoxi);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param xiaoxi
	 * @return
	 */
	public int update(HttpServletRequest request,Xiaoxi xiaoxi){
		return xiaoxiDao.update(xiaoxi);
	}
}
