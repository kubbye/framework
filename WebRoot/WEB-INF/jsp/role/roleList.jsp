<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/common/taglibs.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
<script type="text/javascript" src="${resRoot}/js/role/roleList.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:false,border:false" style="overflow:hidden;padding:5px;">
    <fieldset>
    
    <legend>查询条件</legend>
    	<table>
    		<tr>
		    		<td>roleName：</td>
    				<td><input id="search_roleName" name="roleName" type="text" value=""/></td>
		    		<td>类型：R 角色，P 部门岗位：</td>
    				<td><input id="search_roleType" name="roleType" type="text" value=""/></td>
		    		<td>公共角色：D 默认角色,C 通用角色,P 部门私有角色，S 系统级角色：</td>
    				<td><input id="search_roleScope" name="roleScope" type="text" value=""/></td>
    			
    			<td><a id="role_query" href="javascript:void(0)" class="easyui-linkbutton">查 询</a></td>
    		</tr>
    	</table>
          
    </fieldset>
    
    </div>
    
 
    <div data-options="region:'center',border:'false'"  style="padding-top:10px;">
    
	  <table id="role_table">
	  </table>
	</div>
	<div id="toolbar_role" style="padding:3px;"> 
	  <a href="javascript:void(-1);" id="role_add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a> 
	  <a href="javascript:void(-1);" id="role_edit"  class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	  <a href="javascript:void(-1);" id="role_detail" class="easyui-linkbutton" data-options="iconCls:'icon-detail',plain:true">明细</a>
	  <a href="javascript:void(-1);" id="role_delete" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a> 
	</div>
</body>
</html>