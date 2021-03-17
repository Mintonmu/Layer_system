package com.sxl.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sxl.dao.MyBatiesPublic;
import com.sxl.util.JacksonJsonUtil;

public class MyController extends BaseController {
	@Autowired
	public MyBatiesPublic db;
	
	public Map getAdmin(HttpServletRequest request){
		Map customerBean = (Map)request.getSession().getAttribute("adminBean");
		return customerBean;
	}
	
	
	public Map getCustomer(HttpServletRequest request){
		Map customerBean = (Map)request.getSession().getAttribute("customerBean");
		return customerBean;
	}
	
	public Map getUser(HttpServletRequest request){
		Map customerBean = (Map)request.getSession().getAttribute("userBean");
		return customerBean;
	}
	
	
	public ResponseEntity<String> renderMsg(Boolean status, String msg) {
		if (StringUtils.isEmpty(msg)) {
			msg = "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"status\":\"" + status + "\",\"msg\":\"" + msg + "\"");
		sb.append("}");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				sb.toString(), initHttpHeaders(), HttpStatus.OK);
		return responseEntity;
	}
	
	
	
	public ResponseEntity<String> renderData(Boolean status, String msg,
			Object obj) {
		if (StringUtils.isEmpty(msg)) {
			msg = "";
		}
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append("\"status\":\"" + status + "\",\"msg\":\"" + msg + "\",");
		sb.append("\"data\":" + JacksonJsonUtil.toJson(obj) + "");
		sb.append("}");
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				sb.toString(), initHttpHeaders(), HttpStatus.OK);
		return responseEntity;
	}
	
	public ResponseEntity<String> renderComboBoxAjax(Object obj) {
		ResponseEntity<String> responseEntity = new ResponseEntity<String>(
				JacksonJsonUtil.toJson(obj), initHttpHeaders(), HttpStatus.OK);
		return responseEntity;
	}
}
