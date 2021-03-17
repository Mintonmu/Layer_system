<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="inc/inc_css.jsp" %>
<body>
	<%@include file="inc/inc_head.jsp" %>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="product well">
					<c:forEach items="${orderList }" var="lists">
					<div class="col-md-12">
						<div class="caption">
							<div class="name"><h3><a href="#">咨询律师：${lists.name }</a></h3></div>
							<div class="info">	
								<ul>
									<li>简单说明: ${lists.title }</li>
									<li>状态: ${lists.status }</li>
									<li>详细说明: ${lists.content }</li>
									<li>附件: <a  href="${ctx }/${lists.pic}" id="aaaaaImg0" >附件</a></li>
								</ul>
							</div>
							<hr>
							<p>评价：${lists.pj }</p>
							
							<a href="#" onclick="deleteOne('${lists.id}');" class="btn btn-default pull-right">删除</a>
							<c:if test="${lists.status=='接单'&&lists.pj==null }">
								<a href="#" onclick="pj('${lists.id}');" class="btn btn-default pull-right">评价</a>
							</c:if>
						</div>
					</div>
						
					</c:forEach>
					
					<div class="clear"></div>
				</div>	
			</div>
		</div>
	</div>	
<%@include file="inc/inc_foot.jsp" %>
</body>

<script type="text/javascript">
function deleteOne(id) {
		if (!confirm("确定要删除吗?")) {
			return false;
		}
		var params = {
			id : id
		};
		$.post("deleteOneOrder.html", params, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.location.reload();
			}
		});
	}
	
	
	function pj(id) {
		var pj = prompt("请输入评价内容:","");
		var params = {
			id : id,pj:pj
		};
		$.post("pjSave.html", params, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.location.reload();
			}
		});
	}

</script>


</html>
