package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.AddressDao;
import com.sxl.model.Address;
import com.sxl.util.PageTool;

@Service("AddressService")
public class AddressService extends BaseService{
	
	@Autowired
	public AddressDao addressDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param address
	 * @return
	 */
	public List<Address> getAddressList(HttpServletRequest request,Address address){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =addressDao.countAll(address);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		address.setBegin(begin);
		address.setPage_num(page_num);
		List<Address> list = addressDao.queryForList(address);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return addressDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Address getAddress(HttpServletRequest request,Long id){
		return addressDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Address address){
		return addressDao.insert(address);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param address
	 * @return
	 */
	public int update(HttpServletRequest request,Address address){
		return addressDao.update(address);
	}
}
