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
	    <form id="menuForm" method="post">
	    	<input type="hidden" id="code" name="code">
	    	<table cellpadding="5">
	    		<tr>
	    			<td  align="right">上级菜单ID:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="parentId" name="parentId" data-options="required:true,validType:['digit']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">图标样式:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="iconCls" name="iconCls" data-options="validType:['maxLength[128]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">桌面图标:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="picUrl" name="picUrl" data-options="validType:['maxLength[128]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">菜单路径:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="menuPath" name="menuPath" data-options="validType:['maxLength[256]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">菜单层级:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="mlevel" name="mlevel" data-options="validType:['digit']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">菜单名称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="mname" name="mname" data-options="required:true,validType:['maxLength[128]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">菜单路径:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="url" name="url" data-options="validType:['maxLength[256]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">菜单编码:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="deCode" name="deCode" data-options="validType:['maxLength[256]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">菜单排序字段：越小越靠前:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="menuSort" name="menuSort" data-options="validType:['digit']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">菜单类型：N，一般菜单；S，系统菜单；D,数据监控菜单:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="menuType" name="menuType" data-options="validType:['maxLength[2]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">Y 可用，N 不可用:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="avaliable" name="avaliable" data-options="required:true,validType:['maxLength[1]']"></input></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_edit();">提交</a>
	    </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="${resRoot}/js/menu/menuEdit.js"></script>
	<script>
		$(document).ready(function(){
			<c:if test="${!empty id}">
				var id='${id}';
				$.formLoad('menuForm',contextPath+'/admin/menu/getMenuById.json?id='+id,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>