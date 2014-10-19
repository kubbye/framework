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
	    <form id="funcForm" method="post">
	    	<input type="hidden" id="id" name="id">
	    	<table cellpadding="5">
	    		<tr>
	    			<td align="right">功能名称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="funcName" name="funcName" data-options="required:true,validType:['maxLength[128]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">代码，唯一:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="funcCode" name="funcCode" data-options="required:true,validType:['maxLength[32]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">路径:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="url" name="url" data-options="required:true,validType:['maxLength[256]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">menuId:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="menuId" name="menuId" data-options="validType:['digit']"></input></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_add();">提交</a>
	    </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="${resRoot}/js/func/funcEdit.js"></script>
</body>
</html>