<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE HTML>
<jsp:include page="inc/inc_css.jsp"></jsp:include>
<body> 
<jsp:include page="inc/inc_head.jsp"></jsp:include>
    
<div class="container no-bottom">
        <h3>我的个人信息</h3>
        <div class="one-half-responsive">
        	<form id="registerFormcustomer">
        	<input type="hidden" value="${bean.id }" name="id"/>
            <input type="text" class="text-input-one good-value" id="name" value="${bean.name }" name="name" placeholder="姓名">
            <select name="sex" id="sex" class="login-username">
            	<option value="男" ${bean.sex=='男'?'selected':'' }>男</option>
            	<option value="女" ${bean.sex=='女'?'selected':'' }>女</option>
            </select>
            <input type="text" class="text-input-one good-value" value="${bean.address }" name="address" placeholder="地址">
            <input type="text" class="text-input-one good-value" value="${bean.mobile }" name="mobile" placeholder="手机">
            <a href="javascript:mineSave();" class="button center-button button-green full-bottom detected-button">修改保存</a>
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
		      url: "${ctx}/app/mineSave.html",
				data:$("#registerFormcustomer").serializeArray(),
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
						alert('修改成功');
						window.location.reload();
				}
		      }
			});
	}
</script>
</body>