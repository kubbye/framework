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
<body class="easyui-layout" scroll="no">
	<div data-options="region:'north',border:false" style="height:60px;background:#B3DFDA;padding:10px">north region</div>
	<div data-options="region:'west',split:true,title:'功能菜单'" style="width:150px;padding:10px;">
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="changeTitle('菜单管理');">菜单</a><br>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="changeTitle('机构管理');">机构</a><br>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="changeTitle('角色管理');">角色</a><br>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="changeTitle('用户管理');">用户管理</a><br>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="changeTitle('岗位管理');">岗位管理</a><br>
	<a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="changeTitle('字典管理');">字典管理</a><br>
	</div>
	
	<div data-options="region:'south',border:false" style="height:30px;padding:10px;">copyright</div>
	<div id="center" data-options="region:'center'" style="overflow:hidden">
		<div id="tt" class="easyui-tabs" fit="true" border="false" plain="true">
			<div title="Welcome"  data-options="closable:true">welcome</div>
			<div title="Welcome" >welcome2</div>
		</div>
		
	</div>
	<script>
	function changeTitle(name){
		var _url;
		if('菜单管理'==name){
			_url=contextPath+'/admin/menu/list.htm';
		}
		if('角色管理'==name){
			_url=contextPath+'/admin/role/roleTree.htm';
		}
		if('用户管理'==name){
			_url=contextPath+'/admin/user/userTree.htm';
		}
		if('岗位管理'==name){
			_url=contextPath+'/admin/post/postTree.htm';
		}
		if('机构管理'==name){
			_url=contextPath+'/admin/org/orgTree.htm';
		}
		if('字典管理'==name){
			_url=contextPath+'/admin/dict/list.htm';
		}
		openTab(name,_url);
	}
	</script>
</body>
</html>