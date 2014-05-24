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
	菜单<br>
	<a href="#" id="openmenu" class="easyui-linkbutton" data-options="iconCls:'icon-add'">改变title</a>
	</div>
	
	<div data-options="region:'south',border:false" style="height:30px;background:#A9FACD;padding:10px;">south region</div>
	<div id="center" data-options="region:'center',title:'Center'" style="overflow:hidden">
		<iframe id="centerIfrmae" frameborder="0" style="border:0;width:100%;height:100%" scrolling="auto"></iframe>
	</div>
	<script>
	$(function(){
		$("#openmenu").on("click",function(data){
			changeTitle(data);
		});
	});

	function changeTitle(id){
		$("#centerIfrmae").attr("src","/framework/admin/user/list.htm");
		$("#center").panel({title:'用户管理'});
	}
	</script>
</body>
</html>