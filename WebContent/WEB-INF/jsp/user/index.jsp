<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
var ctx='${ctx}';
</script>
<!DOCTYPE>
<html>
<head>
<title>法律咨询管理系统</title>
<link type="text/css" rel="stylesheet" href="${ctx }/resource/index/one/css/style.css" />
<script type="text/javascript" src="${ctx }/resource/index/one/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${ctx }/resource/index/one/js/menu.js"></script>
</head>

<body>
<div class="top"></div>
<div id="header">
	<div class="logo">法律咨询管理系统</div>
	<div class="navigation">
		<ul>
		 	<li>欢迎您！</li>
			<li><a href="">${userBean.username }</a></li>
			<%--
			<li><a href="">修改密码</a></li>
			<li><a href="">设置</a></li> --%>
			<li><a href="${ctx }/userLogin/out.html">退出</a></li>
		</ul>
	</div>
</div>
<div id="content">
	<div class="left_menu">
	<ul id="nav_dot">
			<li>
	          <h4 class="M1"><span></span>个人中心</h4>
	          <div class="list-item none">
	            <a href='${ctx}/user/mine.html' target="page">修改个人信息</a>
	            <a href='${ctx}/user/password.html' target="page">修改密码</a>
	          </div>
	        </li>
			 <li>
	          <h4 class="M1"><span></span>我的案件咨询管理</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/wdxx/frame.html' target="page">案件咨询管理</a>
	          </div>
	        </li>
	         <li>
	          <h4 class="M1"><span></span>我的留言管理</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/contact/frame.html' target="page">我的留言管理</a>
	          </div>
	        </li>
	          <li>
	          <h4 class="M1"><span></span>发送消息</h4>
	          <div class="list-item none">
	            <a href='${ctx}/admin/xiaoxi/frame.html' target="page">发送消息</a>
	          </div>
	        </li> 
 	 </ul>
		</div>
		<div class="m-right">
			<div class="main">
				<iframe src="${ctx }/user/main.html" width="100%" height="100%" frameborder="0" scrolling="yes" name="page"></iframe>
			</div>
		</div>
</div>
<div class="bottom"></div>
<div id="footer"><p>法律咨询管理系统</p></div>
<script>navList(12);</script>
</body>
</html>

