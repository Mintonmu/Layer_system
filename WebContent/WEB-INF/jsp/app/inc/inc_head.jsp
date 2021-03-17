<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<script>
	var ctx = '${ctx}';
</script>
<div id="preloader">
	<div id="status">
    	<p class="center-text">
			加载中...
            <em>加载时间取决于你的网络速度!</em>
        </p>
    </div>
</div>
<ul class="menu-top">
    <li class="active-menu"><a href="index.html"><i class="fa fa-home"></i>首页<i class="fa fa-circle"></i></a></li>
    <c:if test="${customerBean!=null }">
    	<li class="active-menu"><a href="${ctx }/app/shopcar.html"><i class="fa fa-home"></i>我的购物车<i class="fa fa-circle"></i></a></li>
    	<li class="active-menu"><a href="${ctx }/app/myOrder.html"><i class="fa fa-home"></i>我的订单<i class="fa fa-circle"></i></a></li>
    	<li class="active-menu"><a href="${ctx }/app/message.html"><i class="fa fa-home"></i>与客服交流<i class="fa fa-circle"></i></a></li>
    	<li class="active-menu"><a href="${ctx }/app/test.html"><i class="fa fa-home"></i>增删改查例子<i class="fa fa-circle"></i></a></li>
    	<li class="active-menu"><a href="${ctx }/app/contact.html"><i class="fa fa-home"></i>app建议<i class="fa fa-circle"></i></a></li>
    	<li class="active-menu"><a href="${ctx }/app/doneppIndexApp.html"><i class="fa fa-home"></i>苦瓜<i class="fa fa-circle"></i></a></li>
		<li class="active-menu"><a href="${ctx }/app/xiangjiaoIndexApp.html"><i class="fa fa-home"></i>香蕉<i class="fa fa-circle"></i></a></li>	
    	<li class="active-menu"><a href="${ctx }/app/mine.html"><i class="fa fa-home"></i>我的信息<i class="fa fa-circle"></i></a></li>
    	<li class="active-menu"><a href="${ctx }/app/password.html"><i class="fa fa-home"></i>修改密码<i class="fa fa-circle"></i></a></li>
    	<li class="active-menu"><a href="${ctx }/app/out.html"><i class="fa fa-home"></i>注销<i class="fa fa-circle"></i></a></li>
    </c:if>
    <c:if test="${customerBean==null }">
    	<li class="active-menu"><a href="${ctx }/app/login.html"><i class="fa fa-home"></i>登录<i class="fa fa-circle"></i></a></li>
    	<li class="active-menu"><a href="${ctx }/app/register.html"><i class="fa fa-home"></i>注册<i class="fa fa-circle"></i></a></li>
    </c:if>
    <li><a class="close-menu" href="#"><i class="fa fa-times"></i>Close<i class="fa fa-circle"></i></a></li>
</ul>
<div class="header">
    <a href="index.html" class="header-logo" style="background: none;font-size: 15px;color: white;width: auto;height: auto;">法律咨询管理系统</a>
    <a href="#" class="header-navigation show-navigation"><i class="fa fa-navicon"></i></a>
</div>
<div class="header-clear"></div>