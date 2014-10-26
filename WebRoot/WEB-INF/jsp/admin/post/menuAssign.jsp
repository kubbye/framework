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
	<input type="hidden" id="postId" value="${postId }">
	<div data-options="region:'west',border:false" style="width:420px;">
		<ul id="treeDemo" class="ztree"></ul>
		<div style="position: absolute;padding-left: 80px;">
			<input type="button" value="确定" onclick="submitAuths();"/>
		</div>
	</div>
	<SCRIPT type="text/javascript">
		<!--
		var zTree;
		var setting = {
			view: {
				dblClickExpand: dblClickExpand,
				selectedMulti: false
			},
			check: {
				enable: true,
				chkboxType:{"Y":"ps","N":"s"}
			},
			async: {
				enable: true,
				url:contextPath+"/common/tree/menu.json",
				autoParam:["id"]
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				beforeClick: beforeClick,
				onClick: onClick
			}
		};

		function dblClickExpand(treeId, treeNode) {
			return treeNode.level > 0;
		}
		function beforeClick(treeId, treeNode, clickFlag) {
			return (treeNode.click != false && treeNode.parentId!=0 && 'org'==treeNode._type);
		}
		
		function onClick(event, treeId, treeNode, clickFlag) {
			var _url=contextPath+'/admin/post/list.htm';
			$("#post_frame").attr("src",_url+"?orgId="+treeNode.id);
			return false;
		}	
		$(document).ready(function(){
			initMenuTree();
		});
		/*初始化机构树*/
		function initMenuTree(){
			var zNodes =[];
			
			$.ajax({
				url:contextPath+"/common/tree/menu.json",
				dataType:"json",
				type:"post",
				async:false,
				success:function(data){
					$.each(data,function(i,item){
						var bopen=item.value.parentId==0 ? true : false;
						zNodes.push($.extend(item.value,{pId:item.value.parentId,name:item.value.mname,open:bopen,_type:'menu'}));
					});
				}
			});
			$.ajax({
				url:contextPath+"/common/tree/func.json",
				dataType:"json",
				type:"post",
				async:false,
				success:function(data){
					$.each(data,function(i,item){
						var pid= item.key;
						$.each(item.value,function(j,func){
							zNodes.push($.extend(func.value,{pId:pid,name:func.value.funcName,open:false,_type:'func',icon:"${resRoot}/plugin/zTree_v3/css/zTreeStyle/img/diy/9.png"}));
						});
					});
				}
			});
			
			zTree = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
		}
		
		/*提交选择的菜单和按钮*/
		function submitAuths(){
			var postId=$("#postId").val();
			var nodes=zTree.getCheckedNodes();
			if(nodes.length==0){
				$.ALERT('请选择授权菜单');
				return;
			}
			var menuids='';
			var funcids='';
			$.each(nodes,function(i,item){
				if(item._type=='menu'){
					menuids+=item.id+",";
				}
				if(item._type=='func'){
					funcids+=item.id+",";
				}
			});
			$.ajax({
				url:contextPath+'/admin/auth/savePostAuth.json',
				type:'post',
				dataType:'json',
				data:"postId="+postId+"&menuIds="+menuids+"&funcIds="+funcids,
				success:function(data){
					$.ALERT('操作成功',closeWindow);
				}
			});
		}
		//-->
	</SCRIPT>	
</body>
</html>