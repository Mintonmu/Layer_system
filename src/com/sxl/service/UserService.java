package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.UserDao;
import com.sxl.model.User;
import com.sxl.util.PageTool;

@Service("UserService")
public class UserService extends BaseService{
	
	@Autowired
	public UserDao userDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param user
	 * @return
	 */
	public List<User> getUserList(HttpServletRequest request,User user){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =userDao.countAll(user);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		user.setBegin(begin);
		user.setPage_num(page_num);
		List<User> list = userDao.queryForList(user);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return userDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public User getUser(HttpServletRequest request,Long id){
		return userDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,User user){
		return userDao.insert(user);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param user
	 * @return
	 */
	public int update(HttpServletRequest request,User user){
		return userDao.update(user);
	}
}
