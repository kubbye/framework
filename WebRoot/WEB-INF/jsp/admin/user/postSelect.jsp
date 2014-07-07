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
			<form id="userPostForm" method="post">
			<input type="hidden" id="select_userId" name="userId" >
			<input type="hidden" id="select_postId" name="postId" >
			<ul class="list">
				<li class="title">&nbsp;&nbsp;岗位：<input id="select_postName" name="postName" type="text" readonly value="" style="width:120px;" class="easyui-validatebox textbox" data-options="required:true"/>
			&nbsp;&nbsp;&nbsp;<a id="menuBtn" class="easyui-linkbutton" href="#" onclick="submitRel(); return false;">确&nbsp;定</a></li>
			</ul>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="${resRoot}/js/user/userEdit.js"></script>
	<SCRIPT type="text/javascript">
		<!--
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
				onClick: onClick
			}
		};
		
		function onClick(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes();
		    $("#select_postName").val(nodes[0].name);
			$("#select_postId").val(nodes[0].id);
			$("#select_postName").validatebox('validate');
		}

		function showMenu() {
			var postNameObj = $("#select_postName");
			var postOffset = $("#select_postName").offset();
			$("#menuContent").css({left:postOffset.left + "px", top:postOffset.top + postNameObj.outerHeight()+5 + "px"}).slideDown("fast");
		}

		$(document).ready(function(){
			$("#select_userId").val('${userId}');
			initOrgTree();
			showMenu();
			//如果已有岗位，显示已有岗位
			<c:if test="${!empty post}">
				$("#select_postId").val('${post.id}');
				$("#select_postName").val('${post.postName}');
				setTimeout(function(){selectedPost(${post.id})},333);
			</c:if>
		});
		
		function selectedPost(postId){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var node = zTree.getNodeByParam("id", postId, null);
			zTree.selectNode(node);
		}
		/*初始化机构树*/
		function initOrgTree(){
		 	$.post(contextPath+"/common/tree/post.json?orgId="+$("#search_orgId").val(),function(data){
				var zNodes =[];
				$.each(data,function(i,item){
					var bopen=item.parentId==0?true:false;
					zNodes.push($.extend(item,{pId:item.parentId,open:bopen}));
				});
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			},'json'); 
		}
		//-->
	</SCRIPT>
</body>
</html>