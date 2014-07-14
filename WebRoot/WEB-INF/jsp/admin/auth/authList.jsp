<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/common/taglibs.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
<script type="text/javascript" src="${resRoot}/js/auth/authList.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:false,border:false" style="overflow:hidden;padding:5px;">
    <fieldset>
    
    <legend>查询条件</legend>
    	<table>
    		<tr>
		    		<td>资源ID：</td>
    				<td><input id="search_resourceId" name="resourceId" type="text"  class="textbox"/></td>
		    		<td>授权对象ID：</td>
    				<td><input id="search_authId" name="authId" type="text"  class="textbox"/></td>
		    		<td>授权类型：1，岗位；2，角色：</td>
    				<td><input id="search_authType" name="authType" type="text"  class="textbox"/></td>
    			
    			<td><a id="auth_query" href="javascript:void(0)" class="easyui-linkbutton">查 询</a></td>
    		</tr>
    	</table>
          
    </fieldset>
    
    </div>
    
 
    <div data-options="region:'center',border:'false'"  style="padding-top:0px;">
    
	  <table id="auth_table">
	  </table>
	</div>
	<div id="toolbar_auth" style="padding:3px;"> 
	  <a href="javascript:void(-1);" id="auth_add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a> 
	  <a href="javascript:void(-1);" id="auth_edit"  class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	  <a href="javascript:void(-1);" id="auth_detail" class="easyui-linkbutton" data-options="iconCls:'icon-detail',plain:true">明细</a>
	  <a href="javascript:void(-1);" id="auth_delete" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a> 
	</div>
</body>
</html>