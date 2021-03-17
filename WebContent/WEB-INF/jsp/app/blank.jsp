<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE HTML>
<jsp:include page="inc/inc_css.jsp"></jsp:include>
<body> 
<jsp:include page="inc/inc_head.jsp"></jsp:include>
    

<c:forEach items="${list }" var="lists">
            	
</c:forEach>
<c:choose>
	<c:when test="${1==1 }"></c:when>
	<c:otherwise>
	
	</c:otherwise>
</c:choose>
<c:if test="${1==1 }"></c:if>
<jsp:include page="inc/inc_foot.jsp"></jsp:include>

</body>