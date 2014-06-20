<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户管理</title>
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
</head>
<body>
	
	<div class="easyui-panel" title="用户新增" style="width:500px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="userForm" method="post">
	    	<input type="hidden" id="userId" name="userId">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>机构:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgId" name="orgId" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>登录名:</td>
	    			<td><input type="text" class="textbox" id="lgName" name="lgName"></input></td>
	    		</tr>
	    		<tr>
	    			<td>员工名:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="userName" name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>AVALILABLE:</td>
	    			<td><input class="textbox" id="available" name="available"></input></td>
	    		</tr>
	    	
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_add();">提交</a>
	    </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="/framework/resources/js/user/userEdit.js"></script>
</body>
</html>