<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE HTML>
<jsp:include page="inc/inc_css.jsp"></jsp:include>
<body> 
<jsp:include page="inc/inc_head.jsp"></jsp:include>
    
<div class="login-page bg1">
        <div class="login-page-overlay"></div>
        <div class="login-page-wrapper">
            <a href="#" class="login-logo" style="background: none;font-size: 20px;color: white;width: auto;height: auto;">登录</a>
            <input type="text" class="login-username" id="login_username" name="username" placeholder="账号">
            <input type="password" class="login-password" id="login_password" name="password" placeholder="密码">
            <div class="one-half">
                <a href="javascript:loginCheck();" class="button button-green">登录</a>
            </div>
            <div class="one-half last-column">
                <a href="${ctx }/app/register.html" class="button button-blue">注册</a>
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
	function loginCheck(){
		var username = $("#login_username").val();
		var password = $("#login_password").val();
		var type = $("#type").val();
		if(username==''||password==''){
			alert('用户名和密码必须填写');
			return false;
		}
		var aa="";
		var bb="";
		if(1==2){
			aa="${ctx}/adminLogin/save.html";
			bb="${ctx}/admin/index.html";
		}else{
			
			aa="${ctx}/app/save.html";
			bb="${ctx}/app/index.html";
		}
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: aa,
				data:{username:username,password:password},
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
					if(result.msg=='1'){
						alert('登录成功');
						window.location.href=bb;
					}else if(result.msg=='0'){
						alert('密码或用户名错误');
					}
				}
		      }
			});
	}
</script>
</body>