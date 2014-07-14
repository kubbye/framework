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
     <input id="search_orgId" name="orgId" type="hidden" value="${orgId }"/>
    	<table>
    		<tr>
		    		<td>角色名称：</td>
    				<td><input id="search_roleName" name="roleName" type="text"  class="textbox"/></td>
		    		<td>状态：</td>
    				<td>
						<select id="search_avaliable" name="avaliable" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
		    				<option value="">--全部--</option>
		    				<option value="Y">有效</option>
		    				<option value="N">无效</option>
		    			</select>
					</td>
    			<td><a id="role_query" href="javascript:void(0)" class="easyui-linkbutton">查 询</a></td>
    		</tr>
    	</table>
          
    </fieldset>
    
    </div>
    
 
    <div data-options="region:'center',border:'false'"  style="padding-top:0px;">
    
	  <table id="role_table">
	  </table>
	</div>
	<div id="toolbar_role" style="padding:3px;"> 
	  <a href="javascript:void(-1);" id="role_add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a> 
	  <a href="javascript:void(-1);" id="role_edit"  class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	  <a href="javascript:void(-1);" id="role_detail" class="easyui-linkbutton" data-options="iconCls:'icon-detail',plain:true">明细</a>
	  <a href="javascript:void(-1);" id="role_delete" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a>
	  <a href="javascript:void(-1);" id="role_auth" class="easyui-linkbutton" data-options="iconCls:'icon-ok',plain:true">授权</a> 
	</div>
</body>
</html>