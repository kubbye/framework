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
	    <form id="dictForm" method="post">
	    	<input type="hidden" id="id" name="id">
	    	<table cellpadding="5">
	    		<tr>
	    			<td  align="right">字典明细编号:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="typeCode" name="typeCode" data-options="required:true,validType:['maxLength[32]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">代码:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="code" name="code" data-options="validType:['maxLength[32]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">显示名称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="displayname" name="displayname" data-options="validType:['maxLength[300]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">字典类型名称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="typeName" name="typeName" data-options="validType:['maxLength[100]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">排序：数字越小排位越靠前:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="sortId" name="sortId" data-options="validType:['digit']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">是否可编辑：1，是；0，否:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="editable" name="editable" data-options="required:true,validType:['digit']"></input></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_edit();">提交</a>
	    </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="${resRoot}/js/dict/dictEdit.js"></script>
	<script>
		$(document).ready(function(){
			<c:if test="${!empty id}">
				var id='${id}';
				$.formLoad('dictForm',contextPath+'/admin/dict/getDictById.json?id='+id,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>