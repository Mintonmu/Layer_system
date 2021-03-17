package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.ShopcarDao;
import com.sxl.model.Shopcar;
import com.sxl.util.PageTool;

@Service("ShopcarService")
public class ShopcarService extends BaseService{
	
	@Autowired
	public ShopcarDao shopcarDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param shopcar
	 * @return
	 */
	public List<Shopcar> getShopcarList(HttpServletRequest request,Shopcar shopcar){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =shopcarDao.countAll(shopcar);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		shopcar.setBegin(begin);
		shopcar.setPage_num(page_num);
		List<Shopcar> list = shopcarDao.queryForList(shopcar);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return shopcarDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Shopcar getShopcar(HttpServletRequest request,Long id){
		return shopcarDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Shopcar shopcar){
		return shopcarDao.insert(shopcar);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param shopcar
	 * @return
	 */
	public int update(HttpServletRequest request,Shopcar shopcar){
		return shopcarDao.update(shopcar);
	}
}
