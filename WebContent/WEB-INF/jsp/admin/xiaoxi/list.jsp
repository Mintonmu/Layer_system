<%@page language="java" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@include file="/taglibs.jsp"%>
<%@taglib uri="http://displaytag.sf.net/el" prefix="display"%>
<style type="text/css">
@import url("${ctx}/resource/admin/displaytag/zdisplaytag.css");
@import url("${ctx}/resource/admin/displaytag/alternative.css");
</style>
<html>
	<body>
		<display:table name="list"
			requestURI="list.html" class="list"
			id="row" cellspacing="0" cellpadding="0" pagesize="5">
			<display:column style="width:60px;" media="html" title="编号">
				<c:out value="${row_rowNum}"/>
			</display:column>
			<display:column title="用户" property="customerName"/>
			<display:column title="标题" property="title"/>
			<display:column title="内容" property="content"/>
			<display:column title="日期">
				<fmt:formatDate value="${row.insertDate}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/>	</display:column>
						<c:choose>
							<c:when test="${param.flag==1 }"></c:when>
							<c:when test="${param.flag==2 }"></c:when>
							<c:when test="${param.flag==3 }"></c:when>
							<c:otherwise>
							
							</c:otherwise>
						</c:choose>
			<display:column title="删除" style="width:40px;">
				<img src="${ctx}/resource/admin/images/delete.png"
					onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
			</display:column>
		<c:if test="${1==1 }"></c:if>
		</display:table>
	</body>
	<script type="text/javascript">
		//更新字段内容
	function updateColumncustomerId(customerId,id){
		if(!confirm("确定要更新为"+customerId+"吗?")){
			return false;
		}
		//var aaa = prompt("请输入操作意见或说明：","");
		var params={id:id,customerId:customerId};
		$.post("updateColumncustomerId.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	//删除确定
	function deleteOne(id){
		if(!confirm("确定要删除吗?")){
			return false;
		}
  //var aaa = prompt("请输入操作意见或说明：","");
		var params={id:id};
		$.post("editDelete.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	//修改信息
	function modifyOne(id,method){
			MyWindow.OpenCenterWindow('edit.html?id='+id+'&flag=${param.flag}&method='+method,'modify',800,800);
	}
</script>
</html>
