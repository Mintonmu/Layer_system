<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/taglibs.jsp"%>
<!DOCTYPE HTML>
<jsp:include page="inc/inc_css.jsp"></jsp:include>
<body> 
<jsp:include page="inc/inc_head.jsp"></jsp:include>
    
<div class="container no-bottom">
       <h3>购物车</h3>
       <table cellspacing="0" class="table">
            <tbody><tr>
                <th>历史案件名称</th>
                <th class="table-title">数量</th>
                <th class="table-title">总价</th>
            </tr>
            <c:forEach items="${list }" var="lists">
            	<tr>
	                <td class="table-sub-title"> ${lists.productName }(${lists.price })</td>
	                <td>${lists.num }</td>
	                <td>${lists.price*lists.num }</td>
	            </tr>
            </c:forEach>
            <tr class="even">
                <td class="table-sub-title">总计</td>
                <td class="price"></td>
                <td class="price">${total }</td>
            </tr>       
        </tbody></table>
    </div>
	<a href="javascript:pay();" class="center-button button-3d button-green green-3d full-bottom">付款</a>
<jsp:include page="inc/inc_foot.jsp"></jsp:include>
<script type="text/javascript">
	function pay(){
		$.post("pay.html", {id:1}, function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('付款成功');
				window.location.href="${ctx}/app/myOrder.html";
			} else {
				
			}
		});
	}
</script>
</body>