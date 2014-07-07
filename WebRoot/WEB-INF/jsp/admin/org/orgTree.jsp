<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>

</head>
<body class="easyui-layout">
	<div data-options="region:'west',border:false" style="width:220px;">
		<ul id="treeDemo" class="ztree"></ul>
		<inpub type="button" value="fdasf" onclick="addTreeNode();">
	</div>
	<div data-options="region:'center'" style="overflow:hidden;padding-left:3px">
		<iframe id="org_frame" src=""  style="height:100%;width:100%;" scrolling="no"></iframe>
	</div>
	<SCRIPT type="text/javascript">
		<!--
		var setting = {
			view: {
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
			//(treeNode.click != false && treeNode.parentId!=0)
			return (treeNode.click != false);
		}
		function onClick(event, treeId, treeNode, clickFlag) {
			var _url=contextPath+'/admin/org/list.htm';
			$("#org_frame").attr("src",_url+"?parentId="+treeNode.id);
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
					zNodes.push($.extend(item,{pId:item.parentId,open:bopen}));
				});
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			},'json'); 
		}
		/*增加一个节点*/
		function addTreeNode(nodeid,NodeObj){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var node = zTree.getNodeByParam("id", nodeid, null);
			zTree.addNodes(node, {id:NodeObj.id, pId:nodeid, name:NodeObj.name});
		}
		/*删除一个节点*/
		function removeTreeNode(id){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var node = zTree.getNodeByParam("id", id, null);
			zTree.removeNode(node,false);
		}
		/*更改节点名称*/
		function updateNodeName(id,name){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo");
			var node = zTree.getNodeByParam("id", id, null);
			node.name = name;
			zTree.updateNode(node);
		}
		//-->
	</SCRIPT>
</body>
</html>