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
	    <form id="roleForm" method="post">
	    	<input type="hidden" id="roleId" name="roleId">
	    	<table cellpadding="5">
				  	<tr>
		    			<td>角色名称:</td>
		    			<td><input class="textbox" type="text" id="roleName" name="roleName" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>类型：R 角色，P 部门岗位:</td>
		    			<td><input class="textbox" type="text" id="roleType" name="roleType" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>公共角色：D 默认角色,C 通用角色,P 部门私有角色，S 系统级角色:</td>
		    			<td><input class="textbox" type="text" id="roleScope" name="roleScope" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>机构ID:</td>
		    			<td><input class="textbox" type="text" id="orgId" name="orgId" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>备注:</td>
		    			<td><input class="textbox" type="text" id="memo" name="memo" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>Y 可用，N 不可用:</td>
		    			<td><input class="textbox" type="text" id="avaliable" name="avaliable" readonly="readonly"></input></td>
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
			<c:if test="${!empty roleId}">
				var roleId='${roleId}';
				$.formLoad('roleForm',contextPath+'/admin/role/getRoleById.json?roleId='+roleId,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>