<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE HTML>
<jsp:include page="inc/inc_css.jsp"></jsp:include>
<body> 
<jsp:include page="inc/inc_head.jsp"></jsp:include>
    
<div class="login-page bg1">
        <div class="login-page-overlay"></div>
        <div class="login-page-wrapper">
            <a href="#" class="login-logo" style="background: none;font-size: 20px;color: white;width: auto;height: auto;">修改密码</a>
            <form action="" id="form1">
            <input type="password" class="login-password" id="oldPassword" name="oldPassword" placeholder="旧密码">
            <input type="password" class="login-password" id="newPassword" name="newPassword" placeholder="新密码">
            <input type="password" class="login-password" id="newPasswordConfirm" name="newPasswordConfirm" placeholder="确认密码">
            </form>
            <div class="one-half">
                <a href="javascript:save();" class="button button-green">确认</a>
            </div>
            <div class="clear"></div>
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
	function save(src) {
		var oldPassword = $("#oldPassword").val();
		var newPassword = $("#newPassword").val();
		var newPasswordConfirm = $("#newPasswordConfirm").val();
		if(oldPassword==''){
			alert('旧密码不能为空');
			return false;
		}
		if(newPassword==''){
			alert('新密码不能为空');
			return false;
		}
		if(newPasswordConfirm==''){
			alert('确认密码不能为空');
			return false;
		}
		if(newPasswordConfirm!=newPassword){
			alert('两次密码输入不一致');
			return false;
		}
		$.post("changePassword.html", $("#form1").serializeArray(), function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('修改成功');
				window.location.href="${ctx}/app/index.html";
			} else {
				alert('旧密码不对，请重新输入');
			}
		});
	}
</script>
</body>