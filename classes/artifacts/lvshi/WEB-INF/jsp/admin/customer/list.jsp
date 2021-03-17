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
			<display:column title="账号" property="username"/>
			<display:column title="密码" property="password"/>
			<display:column title="姓名" property="customerName"/>
			<display:column title="性别" property="sex"/>
			<display:column title="地址" property="address"/>
			<display:column title="手机" property="phone"/>
			<%--<display:column title="金额" property="account"/>
			
			<display:column title="积分" property="jf"/> --%>
						<c:choose>
							<c:when test="${param.flag==1 }"></c:when>
							<c:when test="${param.flag==2 }"></c:when>
							<c:when test="${param.flag==3 }"></c:when>
							<c:otherwise>
							
							</c:otherwise>
						</c:choose>
			<display:column title="修改" style="width:40px;">
				<img src="${ctx}/resource/admin/images/pencil.png"
					onclick="return modifyOne('${row.id}');" style="cursor:hand;"/>
			</display:column>
			<display:column title="删除" style="width:40px;">
				<img src="${ctx}/resource/admin/images/delete.png"
					onclick="return deleteOne('${row.id}');" style="cursor:hand;"/>
			</display:column>
		<c:if test="${1==1 }"></c:if>
		</display:table>
	</body>
	<script type="text/javascript">
	function updateColumnsex(sex,id){
		if(!confirm("确定要更新为"+sex+"吗?")){
			return false;
		}
		var params={id:id,sex:sex};
		$.post("updateColumnsex.html",params,function(
				result){
			result=eval("("+result+")");
			if(result.status=="true"||result.status==true){
				alert('成功');
			window.parent.form1.submit();
			}
		});
	}
	function deleteOne(id){
		if(!confirm("确定要删除吗?")){
			return false;
		}
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
	function modifyOne(id){
			MyWindow.OpenCenterWindow('edit.html?id='+id+'&flag=${param.flag}','modify',500,600);
	}
</script>
</html>
