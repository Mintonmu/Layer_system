package com.sxl.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxl.dao.MessageDao;
import com.sxl.model.Message;
import com.sxl.util.PageTool;

@Service("MessageService")
public class MessageService extends BaseService{
	
	@Autowired
	public MessageDao messageDao;
	
	/**
	 * 分页查询
	 * @param request
	 * @param message
	 * @return
	 */
	public List<Message> getMessageList(HttpServletRequest request,Message message){
		Integer page_num=5;
		String page_nums = request.getParameter("page_num");
		if(page_nums!=null&&!"".equals(page_nums)){
			page_num =Integer.parseInt(page_nums);
		}
		int pageIndex = request.getParameter("offset")==null?1:Integer.parseInt(request.getParameter("offset"));
		int size =messageDao.countAll(message);
		int begin = page_num*(pageIndex-1);
		PageTool page = new PageTool(pageIndex, page_num,size);
		page.setHref(geturl(request));
		request.setAttribute("page", page);
		message.setBegin(begin);
		message.setPage_num(page_num);
		List<Message> list = messageDao.queryForList(message);
		return list;
	}
	
	/**
	 * 删除一条记录
	 * @param request
	 * @param id
	 * @return
	 */
	public int deleteOne(HttpServletRequest request,Long id){
		return messageDao.delete(id);
	}
	
	/**
	 * 根据id获取记录
	 * @param request
	 * @param id
	 * @return
	 */
	public Message getMessage(HttpServletRequest request,Long id){
		return messageDao.getById(id);
	}
	
	/**
	 * 新增一条记录
	 * @param request
	 * @param book
	 * @return
	 */
	public int save(HttpServletRequest request,Message message){
		return messageDao.insert(message);
	}
	
	/**
	 * 更新记录
	 * @param request
	 * @param message
	 * @return
	 */
	public int update(HttpServletRequest request,Message message){
		return messageDao.update(message);
	}
}
