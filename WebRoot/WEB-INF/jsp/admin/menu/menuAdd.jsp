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
	    	<input type="hidden" id="id" name="id">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>上级菜单ID:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="parentId" name="parentId" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>图标样式:</td>
	    			<td><input class="textbox" type="text" id="iconCls" name="iconCls"></input></td>
	    		</tr>
	    		<tr>
	    			<td>桌面图标:</td>
	    			<td><input class="textbox" type="text" id="picUrl" name="picUrl"></input></td>
	    		</tr>
	    		<tr>
	    			<td>菜单路径:</td>
	    			<td><input class="textbox" type="text" id="menuPath" name="menuPath"></input></td>
	    		</tr>
	    		<tr>
	    			<td>菜单层级:</td>
	    			<td><input class="textbox" type="text" id="mlevel" name="mlevel"></input></td>
	    		</tr>
	    		<tr>
	    			<td>菜单名称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="mname" name="mname" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>菜单路径:</td>
	    			<td><input class="textbox" type="text" id="url" name="url"></input></td>
	    		</tr>
	    		<tr>
	    			<td>菜单编码:</td>
	    			<td><input class="textbox" type="text" id="deCode" name="deCode"></input></td>
	    		</tr>
	    		<tr>
	    			<td>菜单排序字段：越小越靠前:</td>
	    			<td><input class="textbox" type="text" id="menuSort" name="menuSort"></input></td>
	    		</tr>
	    		<tr>
	    			<td>是否系统菜单：N，否；Y，是:</td>
	    			<td><input class="textbox" type="text" id="sysMenu" name="sysMenu"></input></td>
	    		</tr>
	    		<tr>
	    			<td>Y 可用，N 不可用:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="avaliable" name="avaliable" data-options="required:true"></input></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_add();">提交</a>
	    </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="${resRoot}/js/menu/menuEdit.js"></script>
</body>
</html>