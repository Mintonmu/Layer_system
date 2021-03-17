<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
    var ctx = '${ctx}';
</script>
<nav id="top">
    <div class="container">
        <div class="row">

            <div class="col-xs-12">
                <ul class="top-link">

                    <c:if test="${customerBean!=null }">
                        <li><a href="${ctx }/front/myOrder.html">我的咨询</a></li>
                        <li><a href="${ctx }/front/minexiaoxi.html">我的消息</a></li>
                        <li><a href="${ctx }/front/mine.html">我的信息</a></li>
                        <li><a href="contact.html"><span class="glyphicon glyphicon-envelope"></span>发送给律师</a></li>
                        <%--
                        <li><a href="${ctx }/front/password.html">修改密码</a></li> --%>
                        <li><a href="${ctx }/front/out.html">注销</a></li>
                    </c:if>
                    <c:if test="${customerBean==null }">
                        <li><a href="login.html"><span class="glyphicon"></span>登录</a></li>
                        <li><a href="register.html"><span class="glyphicon"></span>注册</a></li>
                    </c:if>

                </ul>
            </div>
        </div>
    </div>
</nav>
<header class="container">
    <div class="row">
        <div class="col-md-12" style=" display: flex;align-items: center;">
            <img width="80" height="90" src="${ctx}/resource/front4/images/logo.png">
            <div id="logo" style="font-size: 30px;">法律咨询管理系统</div>
        </div>
    </div>
</header>
<!--Navigation-->
<nav id="menu" class="navbar">
    <div class="container">
        <div class="navbar-header"><span id="heading" class="visible-xs">菜单</span>
            <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
        </div>
        <div class="collapse navbar-collapse navbar-ex1-collapse">
            <ul class="nav navbar-nav">
                <li><a href="index.html">首页</a></li>
                <li><a href="all.html">经典案例</a></li>
                <li><a href="zxList.html">事务所新闻</a></li>
                <li><a href="govzxlist.html">国家法律新闻</a></li>
                <li><a href="govfvlist.html">国家法律条规</a></li>
                <li><a href="lt.html">律师团队</a></li>
                <%--<li><a href="jfdh.html">积分兑换</a></li> --%>
                <%--
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">PC Computers</a>
                    <div class="dropdown-menu">
                        <div class="dropdown-inner">
                            <ul class="list-unstyled">
                                <li><a href="category.html">Window</a></li>
                                <li><a href="category.html">MacBook</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Laptops &amp; Notebooks</a>
                    <div class="dropdown-menu">
                        <div class="dropdown-inner">
                            <ul class="list-unstyled">
                                <li><a href="category.html">Dell</a></li>
                                <li><a href="category.html">Asus</a></li>
                                <li><a href="category.html">Samsung</a></li>
                                <li><a href="category.html">Lenovo</a></li>
                                <li><a href="category.html">Acer</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">Mobiles &amp; Tablet</a>
                    <div class="dropdown-menu" style="margin-left: -203.625px;">
                        <div class="dropdown-inner">
                            <ul class="list-unstyled">
                                <li><a href="category.html">Iphone</a></li>
                                <li><a href="category.html">Samsung</a></li>
                                <li><a href="category.html">Nokia</a></li>
                                <li><a href="category.html">Lenovo</a></li>
                                <li><a href="category.html">Google</a></li>
                            </ul>
                            <ul class="list-unstyled">
                                <li><a href="category.html">Nexus</a></li>
                                <li><a href="category.html">Dell</a></li>
                                <li><a href="category.html">Oppo</a></li>
                                <li><a href="category.html">Blackberry</a></li>
                                <li><a href="category.html">HTC</a></li>
                            </ul>
                            <ul class="list-unstyled">
                                <li><a href="category.html">LG</a></li>
                                <li><a href="category.html">Q-Mobiles</a></li>
                                <li><a href="category.html">Sony</a></li>
                                <li><a href="category.html">Wiko</a></li>
                                <li><a href="category.html">T&T</a></li>
                            </ul>
                        </div>
                    </div>
                </li>
                <li><a href="category.html">Software</a></li> --%>
            </ul>
        </div>
    </div>
</nav>