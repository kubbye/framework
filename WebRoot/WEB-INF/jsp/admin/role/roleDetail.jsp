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
	    	<input class="textbox" type="hidden" id="orgId" name="orgId" disabled></input>
	    	<table cellpadding="5">
				  	<tr>
		    			<td>角色名称:</td>
		    			<td><input class="textbox" type="text" id="roleName" name="roleName" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>备注:</td>
		    			<td><textarea id="memo" name="memo" rows="3" cols="18" disabled>
	    			</textarea></td>
		    		</tr>
				  	<tr>
		    			<td>状态:</td>
		    			<td>
		    			<select id="avaliable" name="avaliable" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" disabled>
		    				<option value="Y">有效</option>
		    				<option  value="N">无效</option>
		    			</select>
		    			</td>
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