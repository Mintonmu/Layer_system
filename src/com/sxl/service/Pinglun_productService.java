package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.Pinglun_productDao;
import com.sxl.model.Pinglun_product;
import com.sxl.util.PageTool;

@Service("Pinglun_productService")
public class Pinglun_productService extends BaseService{
	
	@Autowired
	public Pinglun_productDao pinglun_productDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param pinglun_product
	 * @return
	 */
	public List<Pinglun_product> getPinglun_productList(HttpServletRequest request,Pinglun_product pinglun_product){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =pinglun_productDao.countAll(pinglun_product);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		pinglun_product.setBegin(begin);
		pinglun_product.setPage_num(page_num);
		List<Pinglun_product> list = pinglun_productDao.queryForList(pinglun_product);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return pinglun_productDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Pinglun_product getPinglun_product(HttpServletRequest request,Long id){
		return pinglun_productDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Pinglun_product pinglun_product){
		return pinglun_productDao.insert(pinglun_product);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param pinglun_product
	 * @return
	 */
	public int update(HttpServletRequest request,Pinglun_product pinglun_product){
		return pinglun_productDao.update(pinglun_product);
	}
}
