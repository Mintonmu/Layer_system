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
			requestURI="tj4.html" class="list"
			id="row" cellspacing="0" cellpadding="0" >
			<display:column style="width:60px;" media="html">
				<c:out value="${row_rowNum}"/>
			</display:column>
			<display:column title="历史案件名称" property="productName"/>
			<display:column title="图片1">
				<img style="width:100px;" src="${ctx}/${row.productPic1}"/>
			</display:column>
			<display:column title="收藏量" property="scl"/>
			
		</display:table>
	</body>
</html>
