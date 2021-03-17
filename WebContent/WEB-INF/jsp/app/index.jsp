<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
var ctx='${ctx}';
</script>
<!DOCTYPE HTML>
<jsp:include page="inc/inc_css.jsp"></jsp:include>
<body> 
<jsp:include page="inc/inc_head.jsp"></jsp:include>
<div class="header-clear-big"></div>
<!-- 内容开始 -->
<div class="content">
    <div class="portfolio-two">
    	<c:forEach items="${list }" var="lists">
    		<div class="portfolio-two-item full-bottom">
	            <div class="portfolio-two-image">
	                <a href="${ctx}/${lists.productPic}" class="swipebox">
	                    <i class="fa fa-plus"></i>
	                </a>
	                <img src="${ctx}/${lists.productPic}" class="responsive-image">
	            </div>
	            <div class="portfolio-two-text">
	                <h3 class="title">${lists.productName}</h3>
	                <em class="subtitle">${lists.price}</em>
	                <p class="half-bottom">
	                    ${lists.content}
	                </p>            
	                <div class="portfolio-two-links">
	                    <a href="${ctx }/app/detail.html?id=${lists.id}"><i class="fa fa-arrow-right"></i>点击购买</a>
	                </div> 
	            </div>       
	        </div>
    	</c:forEach>
    </div>
    <div class="decoration"></div>
</div>

<!-- 内容结束 -->
<jsp:include page="inc/inc_foot.jsp"></jsp:include>

</body>



















