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
				<div id="main-content" class="col-md-8">
					<div class="product">
						<div class="clear"></div>
					</div>
					<div class="product-desc">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#description">${map.name }</a></li>
							<li><a href="#review">评价</a></li>
						</ul>
						<div class="tab-content">
							<div id="description" class="tab-pane fade in active">
							<div class="post-meta clearfix">
						</div>
							<c:if test="${map.headPic!=null&&map.headPic!=''}">
								<img height="100" src="${ctx }/${map.headPic}"
								class="attachment-std-thumbnail wp-post-image" >
							</c:if>
							<br>
								擅长领域：<p>${map.gh }</p>
								
								<br>
								<a href="wdxxEdit.html?id=${map.id }"  class="btn btn-2 ">案件咨询</a>
								
							</div>
							<div id="review" class="tab-pane fade">
							  <div class="review-text">
								<c:forEach items="${list }" var="lists">
									<p>${lists.customerName }:${lists.pj }</p>
								</c:forEach>
							  </div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>	
<%@include file="inc/inc_foot.jsp" %>
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

function zan(id) {
		if(!checkIsLogin()){
			alert('请先登录');
			window.location.href='${ctx}/front/register.html';
			return false;
		}
		$.post("zanSave.html", {id:id}, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('点赞成功');
				window.location.reload();
			} else {
				alert('保存失败，请重试');
			}
		});
	}
	
	
	  	function save(src) {
  		if(!checkIsLogin()){
			alert('请先登录');
			window.location.href='${ctx}/front/register.html';
			return false;
		}
		$.post("pinglunSave.html", $("#form1").serializeArray(), function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.location.reload();
			} else {
				alert('保存失败，请重试');
			}
		});
	}
	
</script>
</html>
