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
					<c:forEach items="${list }" var="lists">
					<div class="col-md-12">
						<div class="caption">
							<div class="name"><h3>标题：<a href="#">${lists.title }</a></h3></div>
							<p>内容：${lists.content }</p>
							<a href="#" onclick="deletesc('${lists.id}');" class="btn btn-default pull-right">删除</a>
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
function deletesc(id) {
		if (!confirm("确定要删除吗?")) {
			return false;
		}
		var params = {
			id : id
		};
		$.post("deletexiaoxi.html", params, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.location.reload();
			}
		});
	}

</script>


</html>
