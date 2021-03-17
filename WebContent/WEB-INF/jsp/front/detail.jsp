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
						<div class="col-md-6">
							<div class="image">
								<img src="${ctx}/${map.productPic1}" />
								<div class="image-more">
									 <ul class="row">
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive" src="${ctx}/${map.productPic1}"></a>
										</li>
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive" src="${ctx}/${map.productPic2}"></a>
										</li>
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive" src="${ctx}/${map.productPic3}"></a>
										</li>
										 <li class="col-lg-3 col-sm-3 col-xs-4">
											<a href="#"><img class="img-responsive" src="${ctx}/${map.productPic4}"></a>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="caption">
								<div class="name"><h3>${map.productName }</h3></div>
								<div class="info">
									<ul>
										<li>分类: ${map.typesName }</li>
										<li>访问量：${map.djl }</li>
									</ul>
								</div>
						
								<%--百度分享开始 --%>
									<div class="bdsharebuttonbox">
										<a href="#" class="bds_more" data-cmd="more"></a><a href="#"
											class="bds_qzone" data-cmd="qzone" title="分享到QQ空间"></a><a
											href="#" class="bds_tsina" data-cmd="tsina" title="分享到新浪微博"></a><a
											href="#" class="bds_tqq" data-cmd="tqq" title="分享到腾讯微博"></a><a
											href="#" class="bds_weixin" data-cmd="weixin" title="分享到微信"></a><a
											href="#" class="bds_tieba" data-cmd="tieba" title="分享到百度贴吧"></a><a
											href="#" class="bds_sqq" data-cmd="sqq" title="分享到QQ好友"></a>
									</div>
									<script>
										window._bd_share_config = {
											"common" : {
												"bdSnsKey" : {},
												"bdText" : "",
												"bdMini" : "2",
												"bdMiniList" : false,
												"bdPic" : "",
												"bdStyle" : "1",
												"bdSize" : "32"
											},
											"share" : {}
										};
										with (document)
											0[(getElementsByTagName('head')[0] || body)
													.appendChild(createElement('script')).src = 'http://bdimg.share.baidu.com/static/api/js/share.js?v=0.js?cdnversion='
													+ ~(-new Date() / 36e5)];
									</script>
									<%--百度分享结束 --%>
							</div>
						</div>
						<div class="clear"></div>
					</div>	
					<div class="product-desc">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#description">描述</a></li>
							<%----%><li><a href="#review">评论</a></li> 
						</ul>
						<div class="tab-content">
							<div id="description" class="tab-pane fade in active">
								<p>${map.content }</p>
							</div>
							<div id="review" class="tab-pane fade">
							  <div class="review-text">
								
								<c:forEach items="${list }" var="lists">
									<p>${lists.customerName }:${lists.content }(<fmt:formatDate value="${lists.insertDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>)</p>
								</c:forEach>
							  </div>
							  <div class="review-form">
								<form name="form1" id="form1" method="post">
								<input type="hidden" name="productId" value="${map.id }"/>
									<label>
									<span>评论内容:</span>
									<textarea name="content" id="content"></textarea>
									</label>
									<div class="text-right">
										<input class="btn btn-default" type="reset" name="reset" value="清空">
										<input class="btn btn-default" onclick="save(this);" type="button" name="Submit" value="发表评论">
									</div>
								</form>
							  </div>
							</div>
						</div>
					</div>
					<%--
					<%@include file="inc/inc_tj.jsp" %> --%>
				</div>
				<%@include file="inc/inc_right.jsp" %>
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

function save(src) {
  		if(!checkIsLogin()){
			alert('请先登录');
			window.location.href='${ctx}/front/register.html';
			return false;
		}
		$.post("productPinglunSave.html", $("#form1").serializeArray(), function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.location.reload();
			} else {
				alert('保存失败，请重试');
			}
		});
	}
	
	
function sc(src) {
  		if(!checkIsLogin()){
			alert('请先登录');
			window.location.href='${ctx}/front/register.html';
			return false;
		}
		$.post("scSave.html", {id:'${map.id}'}, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('收藏成功');
			} else {
				alert('保存失败，请重试');
			}
		});
	}
</script>
</html>
