<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<script>
var ctx='${ctx}';
</script>
<!DOCTYPE HTML>
<jsp:include page="inc/inc_css.jsp"></jsp:include>
<body> 
<jsp:include page="inc/inc_head.jsp"></jsp:include>
<!-- 内容开始 -->
<div class="content">
    <div class="portfolio-one">
        <div class="portfolio-one-item full-bottom">
            <div class="portfolio-one-image">
                <a href="${ctx }/${bean.productPic}" class="swipebox" title="Caption Here">
                    <i class="fa fa-plus"></i>
                </a>
                <img src="${ctx }/${bean.productPic}" class="responsive-image">
            </div>
            <div class="portfolio-one-text">
                <h3 class="title">${bean.productName}</h3>
                <em class="subtitle">${bean.price}</em>
                <p class="half-bottom">
                    ${bean.content }
                </p>
            </div>       
        </div>
        数量：<select class="text-input-one good-value" name="num">
        	<option>1</option>
        	<option>2</option>
        	<option>3</option>
        	<option>4</option>
        	<option>5</option>
        </select>
        <a href="javascript:addShopCar();" class="center-button button-3d button-red red-3d full-bottom">加入购物车</a>
        <a href="${ctx }/app/shopcar.html" class="center-button button-3d button-green green-3d full-bottom">去结算</a>
        <div class="decoration"></div>
    </div>
</div>
<!-- 内容结束 -->
<jsp:include page="inc/inc_foot.jsp"></jsp:include>
<script type="text/javascript">
	function addShopCar(){
		if(!checkIsLogin()){
			//alert('请先登录');
			window.location.href='${ctx}/app/login.html';
			return false;
		}
		var id = '${bean.id}';
		var num = $("select[name='num']").val();
		$.post("addShopcar.html", {id:id,num:num}, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('添加成功');
			} else {
				
			}
		});
	}
	
	function checkIsLogin(){
		var out =false;
		$.ajax({
		      type: "POST",
		      async:false,  // 设置同步方式
		      cache:false,
		      url: "${ctx}/app/checkIsLogin.html",
				data:{id:1},
				success:function(result){
				result = eval("("+result+")");
				if(result.status=='true'||result.status==true){
					out=true;
				}else{
					out=false;
				}
		      }
			});
			return out;
	}
</script>
</body>