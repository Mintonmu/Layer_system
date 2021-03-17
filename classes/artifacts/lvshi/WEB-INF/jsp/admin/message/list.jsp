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
			<display:column title="用户" property="name"/>
			<display:column title="进入交流" style="width:40px;">
				<img src="${ctx}/resource/admin/images/pencil.png"
					onclick="return modifyOne('${row.customerId}');" style="cursor:hand;"/>
			</display:column>
		</display:table>
	</body>
	<script type="text/javascript">
	function updateColumncustomerId(customerId,id){
		if(!confirm("确定要更新为"+customerId+"吗?")){
			return false;
		}
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
			MyWindow.OpenCenterWindow('jiaoliu.html?customerId='+id+'&flag=${param.flag}','modify',500,600);
	}
</script>
</html>
