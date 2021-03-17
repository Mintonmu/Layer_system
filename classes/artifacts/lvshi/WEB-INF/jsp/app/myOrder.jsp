<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE HTML>
<jsp:include page="inc/inc_css.jsp"></jsp:include>
<body> 
<jsp:include page="inc/inc_head.jsp"></jsp:include>
    
<div class="content">
<div class="container no-bottom">
        <div class="one-half-responsive">
            <c:forEach items="${orderList }" var="lists" varStatus="vs">
            	<p><span class="text-highlight highlight-turqoise">${vs.index+1}、订单号[${lists.orderNum}]${lists.productDetail },总价：${lists.allPrice },状态：${lists.status }</span></p>
            	<c:if test="${lists.status=='订单完成' }">
            		<c:choose>
            			<c:when test="${lists.pl!=null&&lists.pl!='' }">
            				评论：${lists.pl }
            			</c:when>
            			<c:otherwise>
            				<input class="text-input-one good-value" name="pl" id="pl" placeholder="评论内容"/><a href="javascript:plSave('${lists.id}');" class="center-button button-3d button-red red-3d full-bottom">提交评论</a><br>
            			</c:otherwise>
            		</c:choose>
            		
            		
            	</c:if>
            	
            	
            </c:forEach>
        </div>
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
	function plSave(id){
		var pl = $("#pl").val();
		if(pl==''){
			alert('评论内容不能为空');
			return false;
		}
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: "${ctx}/app/plSave.html",
				data:{pl:pl,id:id},
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
						alert('评论成功');
						window.location.reload();
				}
		      }
			});
	}
</script>
</body>