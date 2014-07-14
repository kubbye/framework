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
				selectedMulti: false
			},
			
			async: {
				enable: true,
				url:contextPath+"/common/tree/post.json",
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
			initOrgTree();
		});
		/*初始化机构树*/
		function initOrgTree(){
		 	$.post(contextPath+"/common/tree/org.json",function(data){
				var zNodes =[];
				$.each(data,function(i,item){
					var bopen=item.parentId==0?true:false;
					zNodes.push($.extend(item,{pId:item.parentId,open:bopen,_type:'org'}));
				});
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			},'json'); 
		}
		//-->
	</SCRIPT>
</body>
</html>