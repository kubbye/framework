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
	    <form id="userForm" method="post">
	    	<input type="hidden" id="userId" name="userId">
	    	<input type="hidden" id="orgId" name="orgId" value="1"></input>
	    	<input type="hidden" id="loginId" name="loginId"></input>
	    	<input type="hidden" id="userType" name="userType" value="P"></input>
	    	<table cellpadding="5">
	    		<tr>
	    			<td align="right">登录名称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="lgName" name="lgName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">用户昵称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="userName" name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">性别:</td>
	    			<td>
	    			<select id="sex" name="sex" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'">
	    				<option value="1">男</option>
	    				<option  value="0">女</option>
	    			</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td align="right">照片:</td>
	    			<td><input class="textbox" type="text" id="photo" name="photo"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">备注:</td>
	    			<td><input class="textbox" type="text" id="memo" name="memo"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">状态:</td>
	    			<td>
	    			<select id="avaliable" name="avaliable" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
	    				<option value="Y">有效</option>
	    				<option  value="N">无效</option>
	    			</select>
	    			</td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_add();">提交</a>
	    </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="${resRoot}/js/user/userEdit.js"></script>
	<script type="text/javascript">
		$(document).ready(function(data){
			$("#orgId").val($("#search_orgId").val());
		});
	</script>
</body>
</html>