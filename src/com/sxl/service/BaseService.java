package com.sxl.service;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.sxl.dao.PublicDao;

public class BaseService {
	
	@Autowired
	public PublicDao publicDao;
	public String geturl(HttpServletRequest request) {

		String strBackUrl = "http://" + request.getServerName() // 服务器地址
				+ ":" + request.getServerPort() // 端口号
				+ request.getContextPath() // 项目名称
				+ request.getServletPath(); // 请求页面或其他地址
		Enumeration enu = request.getParameterNames();
		String out = "";
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			if (!"offset".equals(paraName)) {
				out += "&" + paraName + "=" + request.getParameter(paraName);
			}
		}
		if (out != null && !"".equals(out)) {
			strBackUrl += "?" + out.substring(1, out.length());
		}
		return strBackUrl;
	}
}
