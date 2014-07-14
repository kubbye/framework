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
	<div id="menuContent" class="menuContent"  style="display:none; position: absolute;">
		<ul id="treeDemo" class="ztree"></ul>
	</div>
	<div class="content_wrap">
		<div class="zTreeDemoBackground left" style="padding:10px">
			<form id="userOrgForm" method="post">
			<input type="hidden" id="select_userId" name="userId" >
			<input type="hidden" id="select_orgId" name="orgId" >
			<input type="hidden" id="oldOrgId" name="oldOrgId" >
			<ul class="list">
				<li class="title">&nbsp;&nbsp;岗位：<input id="select_orgName" name="orgName" type="text" readonly value="" style="width:120px;" class="easyui-validatebox textbox" data-options="required:true"/>
			&nbsp;&nbsp;&nbsp;<a id="menuBtn" class="easyui-linkbutton" href="#" onclick="orgExchange(); return false;">提&nbsp;交</a></li>
			</ul>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="${resRoot}/js/user/userEdit.js"></script>
	<SCRIPT type="text/javascript">
		<!--
		var zTree;
		var setting = {
			view: {
				dblClickExpand: false,
				showLine:false,
				selectedMulti: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick:beforeClick,
				onClick: onClick
			}
		};
		function beforeClick(treeId, treeNode, clickFlag) {
			return (treeNode.click != false && treeNode.parentId!=0);
		}
		function onClick(e, treeId, treeNode) {
			nodes = zTree.getSelectedNodes();
		    $("#select_orgName").val(nodes[0].name);
			$("#select_orgId").val(nodes[0].id);
			$("#select_orgName").validatebox('validate');
		}

		function showMenu() {
			var orgNameObj = $("#select_orgName");
			var orgOffset = $("#select_orgName").offset();
			$("#menuContent").css({left:orgOffset.left + "px", top:orgOffset.top + orgNameObj.outerHeight()+5 + "px"}).slideDown("fast");
		}

		$(document).ready(function(){
			$("#select_userId").val('${userId}');
			$("#oldOrgId").val('${orgId}');
			initOrgTree();
			showMenu();
		});
		
		function selectedOrg(orgId){
			var node = zTree.getNodeByParam("id", orgId, null);
			zTree.selectNode(node);
		}
		/*初始化机构树*/
		function initOrgTree(){
		 	$.post(contextPath+"/common/tree/org.json?",function(data){
				var zNodes =[];
				$.each(data,function(i,item){
					var bopen=item.parentId==0?true:false;
					bopen=true;
					zNodes.push($.extend(item,{pId:item.parentId,open:bopen}));
				});
				zTree=$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			},'json'); 
		}
		//-->
	</SCRIPT>
</body>
</html>