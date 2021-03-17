<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE HTML>
<jsp:include page="inc/inc_css.jsp"></jsp:include>
<body> 
<jsp:include page="inc/inc_head.jsp"></jsp:include>
    
<div class="container no-bottom">
        <h3>信息反馈</h3>
        <div class="one-half-responsive">
        	<form id="registerFormcustomer">
            <input type="text" class="text-input-one good-value" id="phone"  name="phone" placeholder="联系电话">
            <textarea cols="3" rows="50"  class="text-input-one good-value"  name="content" placeholder="反馈内容"></textarea>
            <a href="javascript:mineSave();" class="button center-button button-green full-bottom detected-button">提交</a>
            </form>
        </div>
    </div>
<c:forEach items="${list }" var="lists">
            	
</c:forEach>
<c:choose>
	<c:when test="${1==1 }"></c:when>
	<c:otherwise>
	
	</c:otherwise>
</c:choose>
<c:if test="${1==1 }"></c:if>
<jsp:include page="inc/inc_foot.jsp"></jsp:include>
<script type="text/javascript">
function mineSave(){
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: "${ctx}/app/contactSave.html",
				data:$("#registerFormcustomer").serializeArray(),
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
						alert('反馈成功');
						window.location.reload();
				}
		      }
			});
	}
</script>
</body>