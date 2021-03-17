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
				<div class="col-md-12">
					<div class="heading"><h2>编辑地址</h2></div>
					<form id="form1">
    
    <input type="hidden" value="${param.flag }" name="flag" /> <input
			type="hidden" value="${map.id }" name="id" id="id" />
    
    <table class="mobile" style="width: 95%;">
				<tr height="25">
					<td class="outDetail" style="width: 30%">联系人： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input  class="form-control" type="text" id="lxr"
						value="${map.lxr }" name="lxr" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">联系电话： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input  class="form-control" type="text" id="phone"
						value="${map.phone }" name="phone" /></td>
				</tr>
				<tr height="25">
					<td class="outDetail" style="width: 30%">详细地址： <label
						style="font-weight: bold; color: red"> </label></td>
					<td class="outDetail2"><input  class="form-control" type="text" id="xxdz"
						value="${map.xxdz }" name="xxdz" /></td>
				</tr>
			</table>
    <input type="button" class="btn btn-default" value="保  存"
				onclick="save(this);" /> <input type="button" 
				value="返回" class="btn btn-default" onclick="window.history.go(-1)" />
    
    </form>
					
				</div>
		
			</div>
		</div>
	</div>
<%@include file="inc/inc_foot.jsp" %>
</body>
<script type="text/javascript">
	function save(src) {
		$.post("mineaddressEditSave.html", $("#form1").serializeArray(), function(result) {
			result = eval("(" + result + ")");
			if (result.status == "true" || result.status == true) {
				alert('成功');
				window.location.reload();
			} else {
				alert('保存失败，请重试');
			}
		});
	}
	function triggerUploadImg0(src) {
		$
				.ajaxFileUpload({
					url : '${ctx}/file/upload.json',
					secureuri : false,
					fileElementId : 'f_fileImg0',
					dataType : 'json',
					data : {
						fileloc : 'upload/',
						dir : 'temp'
					},
					success : function(data, status) {
						$("#bbbbbImg0").val(data.data.filepath);
						$("#aaaaaImg0").remove();
						$("#bbbbbImg0")
								.after(
										"<img  id='aaaaaImg0' style='width:100px;' src='${ctx}/"+data.data.filepath+"' />");
					},
					error : function(data, status, e) {
						alert('文件上传失败');
					}
				});
	}
</script>
</html>