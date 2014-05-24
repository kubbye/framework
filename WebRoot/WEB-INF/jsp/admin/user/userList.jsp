<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/common/taglibs.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>系统</title>
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
</head>
<body class="easyui-layout">

    
 
    <div data-options="region:'center',border:'false'">
    <div data-options="region:'north',split:false,border:false" style="overflow:hidden;">
    <fieldset>
    
    <legend>查询条件</legend>
           <label>字典名称：<input id="dictName" name="dictName" type="text" value=""/></label>
           &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <label>是否系统配置：
            <select id="isSys" name="isSys"  class="easyui-combobox">
            	<option value="">全部</option>
            	<option value="1">是</option>
            	<option value="0">否</option>
            </select>									
            </label>
           <label>
           <a href="javascript:void(0)" class="easyui-linkbutton">查 询</a>
           </label>
    </fieldset>
    
    </div>
	  <table id="user_table">
	  </table>
	</div>
	<div id="toolbar_user" style="padding:3px;"> 
	  <a href="javascript:void(-1);" id="userAdd" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a> 
	  <a href="javascript:void(-1);" id="userEdit"  class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	  <a href="javascript:void(-1);" id="userDetail" class="easyui-linkbutton" data-options="iconCls:'icon-detail',plain:true">明细</a>
	  <a href="javascript:void(-1);" id="userDelete" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a> 
	</div>
<script type="text/javascript">
	$(document).ready(function(){
		$("#user_table").datagrid({
			fit:true,
			title:'用户信息',
			url:'/framework/admin/user/getListData.json',
			iconCls:'icon-ok',
			nowrap: false,
			autoRowHeight: false,
			resizable:true,
			striped: true,
			collapsible:true,
			remoteSort: true,
			singleSelect:true,
			idField:'userId',				
			collapsible:false,
			pagination:true,pageSize:10,
			rownumbers:true,
			columns:[[
				{field:'orgId',title:'机构'},
				{field:'lgName',title:'登录名称'},
				{field:'userName',title:'用户名称'},
				{field:'available',title:'启用/禁用'}
			]],
			toolbar:'#toolbar_user',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	});
</script>
</body>
</html>