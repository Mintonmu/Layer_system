<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
    var ctx = '${ctx}';
</script>
<!DOCTYPE>
<html>
<head>
    <title>法律咨询管理系统</title>
    <link type="text/css" rel="stylesheet" href="${ctx }/resource/index/one/css/style.css"/>
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
            <li><a href="">${adminBean.username }</a></li>
            <%--
            <li><a href="">修改密码</a></li>
            <li><a href="">设置</a></li> --%>
            <li><a href="${ctx }/adminLogin/out.html">退出</a></li>
        </ul>
    </div>
</div>
<div id="content">
    <div class="left_menu">
        <ul id="nav_dot">
            <li>
                <h4 class="M1"><span></span>个人中心</h4>
                <div class="list-item none">
                    <a href='${ctx}/admin/password.html' target="page">修改密码</a>
                </div>
            </li>
            <li>
                <h4 class="M1"><span></span>首页轮播管理</h4>
                <div class="list-item none">
                    <a href='${ctx}/admin/lbt/frame.html?flag=1' target="page">首页轮播列表</a>
                </div>
            </li>
            <li>
                <h4 class="M1"><span></span>事务所新闻管理</h4>
                <div class="list-item none">
                    <a href='${ctx}/admin/zx/frame.html?flag=1' target="page">事务所新闻列表</a>
                </div>
            </li>
            <li>
                <h4 class="M1"><span></span>国家新闻管理</h4>
                <div class="list-item none">
                    <a href='${ctx}/admin/govzx/frame.html?flag=1' target="page">国家新闻列表</a>
                </div>
            </li>
            <li>
                <h4 class="M1"><span></span>客户管理</h4>
                <div class="list-item none">
                    <a href='${ctx}/admin/customer/frame.html?flag=1' target="page">客户列表</a>
                </div>
            </li>
            <li>
                <h4 class="M1"><span></span>历史案件管理</h4>
                <div class="list-item none">
                    <a href='${ctx}/admin/types/frame.html?flag=1' target="page">历史案件分类列表</a>
                    <a href='${ctx}/admin/product/frame.html?flag=1' target="page">历史案件列表</a>
                </div>
            </li>


            <li>
                <h4 class="M1"><span></span>律师管理</h4>
                <div class="list-item none">
                    <a href='${ctx}/admin/user/frame.html?flag=1' target="page">律师列表</a>
                </div>
            </li>


        </ul>
    </div>
    <div class="m-right">
        <div class="main">
            <iframe src="${ctx }/admin/main.html" width="100%" height="100%" frameborder="0" scrolling="yes"
                    name="page"></iframe>
        </div>
    </div>
</div>
<div class="bottom"></div>
<div id="footer"><p>法律咨询管理系统</p></div>
<script>navList(12);</script>
</body>
</html>

