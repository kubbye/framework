<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/common/taglibs.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
<script type="text/javascript" src="${resRoot}/js/user/userList.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:false,border:false" style="overflow:hidden;padding:5px;">
    <fieldset>
    
    <legend>查询条件</legend>
    <input id="search_orgId" name="orgId" type="hidden" value="${orgId }"/>
    	<table>
    		<tr>
		    		<td>用户登录号：</td>
    				<td><input id="search_loginId" name="loginId" type="text"  class="textbox"/></td>
		    		<td>登录名称：</td>
    				<td><input id="search_lgName" name="lgName" type="text"  class="textbox"/></td>
    			
    			<td><a id="user_query" href="javascript:void(0)" class="easyui-linkbutton">查 询</a></td>
    		</tr>
    	</table>
          
    </fieldset>
    
    </div>
    
 
    <div data-options="region:'center',border:'false'"  style="padding-top:0px;width:98%">
    
	  <table id="user_table">
	  </table>
	</div>
	<div id="toolbar_user" style="padding:3px;"> 
	  <a href="javascript:void(-1);" id="user_add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a> 
	  <a href="javascript:void(-1);" id="user_edit"  class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	  <a href="javascript:void(-1);" id="user_detail" class="easyui-linkbutton" data-options="iconCls:'icon-detail',plain:true">明细</a>
	  <a href="javascript:void(-1);" id="user_delete" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a> 
	  <a href="javascript:void(-1);" id="user_auth" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">授权</a>
	</div>
</body>
</html>