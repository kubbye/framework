<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
	<style type="text/css">
.ztree li span.button.switch.level0 {visibility:hidden; width:1px;}
.ztree li ul.level0 {padding:0; background:none;}
	</style>
</head>
<body class="easyui-layout">
	<div data-options="region:'west',border:false" style="width:220px;">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div data-options="region:'center'" style="overflow:hidden;padding-left:3px">
		<iframe id="post_frame" src=""  style="height:100%;width:100%;"></iframe>
	</div>
	<!-- 
	<div class="easyui-panel" title="&nbsp;" data-options="region:'west'" style="height:500px;overflow-y:no;">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="easyui-panel" title="&nbsp;" data-options="region:'center'" style="height:500px;overflow-y:no;">
		aaaa
	</div>
	 -->
	<SCRIPT type="text/javascript">
		<!--
		var setting = {
			view: {
				dblClickExpand: dblClickExpand,
				showIcon: showIconForTree
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				//beforeClick: beforeClick,
				onClick: onClick
			}
		};

		var zNodes =[
			{ id:100, pId:0, name:"集团公司", open:true},        
			{ id:1, pId:100, name:"总公司", open:true},
			{ id:11, pId:1, name:"北京分公司",_url:'/framework/admin/post/list.htm?orgId=1'},
			{ id:12, pId:1, name:"上海分公司",_url:'/framework/admin/post/list.htm?orgId=2'},
			{ id:111, pId:11, name:"组长",_url:'/framework/admin/post/list.htm?orgId=1'},
			{ id:112, pId:11, name:"组员",_url:'/framework/admin/post/list.htm?orgId=1'},
			{ id:121, pId:12, name:"组长",_url:'/framework/admin/post/list.htm?orgId=1'},
			{ id:122, pId:12, name:"组员",_url:'/framework/admin/post/list.htm?orgId=1'},
			
		];
		function dblClickExpand(treeId, treeNode) {
			return treeNode.level > 0;
		}
		function beforeClick(treeId, treeNode, clickFlag) {
			//alert("treeId="+treeId+",treeNode.name="+treeNode.name+",treeNode.click="+treeNode.click);
			return (treeNode.click != false);
		}
		
		function onClick(event, treeId, treeNode, clickFlag) {
			//alert("treeNode.url="+treeNode._url+",treeNode.name="+treeNode.name+",treeNode.click="+treeNode.click);
			$("#post_frame").attr("src",treeNode._url);
			return false;
		}	
		function showIconForTree(treeId, treeNode) {
			return !treeNode.isParent;
		};
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
		});
		//-->
	</SCRIPT>
</body>
</html>