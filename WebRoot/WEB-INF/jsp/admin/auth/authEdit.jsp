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
	    <form id="authForm" method="post">
	    	<input type="hidden" id="id" name="id">
	    	<table cellpadding="5">
	    		<tr>
	    			<td  align="right">资源ID:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="resourceId" name="resourceId" data-options="validType:['digit']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">授权对象ID:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="authId" name="authId" data-options="validType:['digit']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">授权类型：1，岗位；2，角色:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="authType" name="authType" data-options="validType:['digit']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">权限类型：1，菜单；2，功能code:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="restype" name="restype" data-options="required:true,validType:['maxLength[1]']"></input></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_edit();">提交</a>
	    </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="${resRoot}/js/auth/authEdit.js"></script>
	<script>
		$(document).ready(function(){
			<c:if test="${!empty id}">
				var id='${id}';
				$.formLoad('authForm',contextPath+'/admin/auth/getAuthById.json?id='+id,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>