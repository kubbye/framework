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
		<iframe id="user_frame" src=""  style="height:100%;width:100%;"></iframe>
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
		var isNoOrg=true;
		var setting = {
			view: {
				showLine:false,
				selectedMulti: false,
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

		function beforeClick(treeId, treeNode, clickFlag) {
			return (treeNode.click != false && treeNode.parentId!=0);
		}
		
		function onClick(event, treeId, treeNode, clickFlag) {
			var _url=contextPath + '/admin/user/list.htm';
			$("#user_frame").attr("src",_url+"?orgId="+treeNode.id);
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
				if(isNoOrg){
					zNodes.push({id:-1, pId:0, name:"无组织",open:true});
				}
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			},'json'); 
		}
		//-->
	</SCRIPT>
</body>
</html>