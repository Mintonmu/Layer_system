<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE HTML>
<jsp:include page="inc/inc_css.jsp"></jsp:include>
<body> 
<jsp:include page="inc/inc_head.jsp"></jsp:include>

<div class="login-page bg1" >
        <div class="login-page-overlay"></div>
        <div class="login-page-wrapper" style="height: 600px;">
            <a href="#" class="login-logo" style="background: none;font-size: 20px;color: white;width: auto;height: auto;">注册</a>
            <form id="registerFormcustomer">
            <input type="text" class="login-username" id="customer_username" name="username" placeholder="账号">
            <input type="password" class="login-password" id="customer_password" name="password" placeholder="密码">
            <input type="text" class="login-username" id="customer_name" name="name" placeholder="姓名">
            <select name="sex" id="customer_sex" class="login-username">
            	<option value="男">男</option>
            	<option value="女">女</option>
            </select>
            <input type="text" class="login-username" id="customer_address" name="address" placeholder="地址">
            <input type="text" class="login-username" id="customer_mobile" name="mobile" placeholder="手机">
            </form>
            <div class="one-half">
                <a href="javascript:registerSave();" class="button button-green">注册</a>
            </div>
            <div class="one-half last-column">
                <a href="${ctx }/app/login.html" class="button button-blue">登录</a>
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
function registerSave(){
		var username = $("#customer_username").val();
		var password = $("#customer_password").val();
		if(username==''||password==''){
			alert('用户名和密码必须填写');
			return false;
		}
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: "${ctx}/app/registerSave.html",
				data:$("#registerFormcustomer").serializeArray(),
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
						alert('注册成功');
						window.location.href="${ctx}/app/index.html";
				}
		      }
			});
	}
</script>
</body>