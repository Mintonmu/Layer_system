<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@include file="inc/inc_css.jsp" %>
<body>
	<!--Top-->
	<%@include file="inc/inc_head.jsp" %>
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div id="sidebar" class="col-md-12">
					<div class="widget wid-categories">
						<div class="heading"><h4>我的收货地址</h4>
    							<a class="btn btn-primary" href="mineaddressEdit.html"  role="button">添加收货地址</a>
						</div>
						<div class="content">
							<ul>
								<c:forEach items="${list }" var="lists">
									<li>
									<a href="mineaddressEdit.html?id=${lists.id }">${lists.lxr }:${lists.phone },${lists.xxdz }</a>
										<a class="btn btn-danger" href="#" onclick="deleteOne('${lists.id}');" role="button">删除</a>
										<a class="btn btn-default" href="mineaddressEdit.html?id=${lists.id }" role="button">修改</a>
									</li>
                                </c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
</body>
<script type="text/javascript">
	function addShopCar(){
		if(!checkIsLogin()){
			alert('请先登录');
			window.location.href='${ctx}/front/register.html';
			return false;
		}
		var id = '${map.id}';
		var num = $("input[name='numbs']").val();
		$.post("addShopcar.html", {id:id,num:num}, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('添加成功');
				window.location.reload();
			} else {
				
			}
		});
	}

	function deleteOne(id){
		if(!confirm("确定要删除吗?")){
			return false;
		}
		var params={id:id};
		$.post("addressDelete.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.location.reload();
			}
		});
	}
</script>
</html>
