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
	    	<table cellpadding="5">
				  	<tr>
		    			<td>登录名称:</td>
		    			<td><input class="textbox" type="text" id="lgName" name="lgName" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>用户昵称:</td>
		    			<td><input class="textbox" type="text" id="userName" name="userName" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>密码:</td>
		    			<td><input class="textbox" type="text" id="passWord" name="passWord" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>性别:</td>
		    			<td><select id="sex" name="sex" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" disabled>
	    				<option value="1">男</option>
	    				<option value="0">女</option>
	    			</select></input></td>
		    		</tr>
				  	<tr>
		    			<td>照片:</td>
		    			<td><input class="textbox" type="text" id="photo" name="photo" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>备注:</td>
		    			<td><input class="textbox" type="text" id="memo" name="memo" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>状态:</td>
		    			<td><select id="avaliable" name="avaliable" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" disabled>
	    				<option value="Y">有效</option>
	    				<option  value="N">无效</option>
	    			</select></td>
		    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="closeWindow();">返回</a>
	    </div>
	    </div>
	</div>
	
	<script>
		$(document).ready(function(){
			<c:if test="${!empty userId}">
				var userId='${userId}';
				$.formLoad('userForm',contextPath+'/admin/user/getUserById.json?userId='+userId,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>