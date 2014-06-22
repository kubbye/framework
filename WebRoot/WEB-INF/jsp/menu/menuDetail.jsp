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
	
	<div class="easyui-panel" title="菜单明细" style="width:500px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="menuForm" method="post">
	    	<input type="hidden" id="menuId" name="menuId">
	    	<table cellpadding="5">
				  	<tr>
		    			<td>upMenuId:</td>
		    			<td><input class="textbox" type="text" id="upMenuId" name="upMenuId" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>图标样式:</td>
		    			<td><input class="textbox" type="text" id="iconCls" name="iconCls" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>桌面图标:</td>
		    			<td><input class="textbox" type="text" id="picUrl" name="picUrl" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>menuPath:</td>
		    			<td><input class="textbox" type="text" id="menuPath" name="menuPath" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>菜单层级:</td>
		    			<td><input class="textbox" type="text" id="level" name="level" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>name:</td>
		    			<td><input class="textbox" type="text" id="name" name="name" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>url:</td>
		    			<td><input class="textbox" type="text" id="url" name="url" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>deCode:</td>
		    			<td><input class="textbox" type="text" id="deCode" name="deCode" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>menuSort:</td>
		    			<td><input class="textbox" type="text" id="menuSort" name="menuSort" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>sysMenu:</td>
		    			<td><input class="textbox" type="text" id="sysMenu" name="sysMenu" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>IFRAME,PANEL:</td>
		    			<td><input class="textbox" type="text" id="openType" name="openType" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>Y 可用，N 不可用:</td>
		    			<td><input class="textbox" type="text" id="available" name="available" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>Y 已删除，N 未删除:</td>
		    			<td><input class="textbox" type="text" id="delFlag" name="delFlag" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>createUser:</td>
		    			<td><input class="textbox" type="text" id="createUser" name="createUser" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>updateUser:</td>
		    			<td><input class="textbox" type="text" id="updateUser" name="updateUser" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>createTime:</td>
		    			<td><input class="textbox" type="text" id="createTime" name="createTime" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>updateTime:</td>
		    			<td><input class="textbox" type="text" id="updateTime" name="updateTime" readonly="readonly"></input></td>
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
			<c:if test="${!empty menuId}">
				var menuId='${menuId}';
				$.formLoad('menuForm',contextPath+'/menu/getMenuById.json?menuId='+menuId,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>