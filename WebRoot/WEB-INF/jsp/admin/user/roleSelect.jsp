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
	<div  style="position: absolute;">
		<ul id="treeDiv" class="ztree"></ul>
		<div style="position: absolute;padding-left: 80px;">
			<input type="button" value="确定" onclick="submitRoles();"/>
		</div>
	</div>
	<SCRIPT type="text/javascript">
		<!--
		var zTree;
		var setting = {
			check:{
				enable:true
			},
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
			nodes = zTree.getSelectedNodes();
		}
		var arr=',';
		<c:forEach items="${hasSelectList}"  var="role">
			arr += '${role.roleId}'+',';
		</c:forEach>
		$(document).ready(function(){
			
			initOrgTree();
		});
		
		
		/*初始化机构树*/
		function initOrgTree(){
			var zNodes =[];
		    $.post(contextPath+"/common/tree/role.json?orgId="+${orgId},function(data){
				$.each(data,function(i,item){
					var bopen=item.parentId==0?true:false;
					bopen=true;
					bchecked=false;
					if(arr.indexOf(','+item.id+',')!=-1){
						bchecked=true;
					}
					zNodes.push($.extend(item,{checked:bchecked}));
				});
				zTree=$.fn.zTree.init($("#treeDiv"), setting, zNodes);
			},'json'); 
		}
		function submitRoles(){
			var nodes=zTree.getCheckedNodes();
			if(nodes.length==0){
				$.ALERT('请选择角色');
				return;
			}
			var roleids='';
			$.each(nodes,function(i,item){
				roleids+=item.id+",";
			});
			 $.post(contextPath+"/admin/user/saveUserRole.json?userId="+${userId}+"&roleids="+roleids,function(data){
					$.ALERT(data.message);
					closeWindow();
				},'json');
		}
		//-->
	</SCRIPT>
</body>
</html>