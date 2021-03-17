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
<!-- 内容开始 -->
<div class="content">
    <div class="portfolio-one">
        <div class="portfolio-one-item full-bottom">
            <div class="portfolio-one-text">
            	<c:forEach items="${list }" var="lists">
            		<h3 class="title">
            		<c:if test="${lists.types=='1' }">我：</c:if>
            		<c:if test="${lists.types=='2' }">客服：</c:if>
            		${lists.messageContent}(${lists.insertDate })</h3>
            	</c:forEach>
                
            </div>       
        </div>
        <textarea class="login-username" rows="4" name="messageContent" id="messageContent" cols="50"></textarea>
        <a href="javascript:saveMessageContent();" class="center-button button-3d button-red red-3d full-bottom">提交</a>
        <div class="decoration"></div>
    </div>
</div>
<!-- 内容结束 -->
<jsp:include page="inc/inc_foot.jsp"></jsp:include>
<script type="text/javascript">
	function saveMessageContent(){
		if(!checkIsLogin()){
			//alert('请先登录');
			window.location.href='${ctx}/app/login.html';
			return false;
		}
		var messageContent = $("#messageContent").val();
		$.post("saveMessageContent.html", {messageContent:messageContent}, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
			} else {
				
			}
		});
	}
	
	function checkIsLogin(){
		var out =false;
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: "${ctx}/app/checkIsLogin.html",
				data:{id:1},
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
					out=true;
				}else{
					out=false;
				}
		      }
			});
			return out;
	}
</script>
</body>