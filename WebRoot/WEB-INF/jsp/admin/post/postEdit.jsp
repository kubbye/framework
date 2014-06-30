<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
</head>
<body>
	
	<div class="easyui-panel" title="&nbsp;" style="width:500px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="postForm" method="post">
	    	<input type="hidden" id="id" name="id">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>机构ID:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgId" name="orgId" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>上级岗位ID:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="parentId" name="parentId" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>岗位路径:</td>
	    			<td><input class="textbox" type="text" id="postPath" name="postPath"></input></td>
	    		</tr>
	    		<tr>
	    			<td>岗位名称:</td>
	    			<td><input class="textbox" type="text" id="postName" name="postName"></input></td>
	    		</tr>
	    		<tr>
	    			<td>岗位描述:</td>
	    			<td><input class="textbox" type="text" id="postDesc" name="postDesc"></input></td>
	    		</tr>
	    		<tr>
	    			<td>状态：Y 可用，N 不可用:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="avaliable" name="avaliable" data-options="required:true"></input></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_edit();">提交</a>
	    </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="${resRoot}/js/post/postEdit.js"></script>
	<script>
		$(document).ready(function(){
			<c:if test="${!empty id}">
				var id='${id}';
				$.formLoad('postForm',contextPath+'/admin/post/getPostById.json?id='+id,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>