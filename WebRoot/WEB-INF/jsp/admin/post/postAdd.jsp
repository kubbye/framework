<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
<style type="text/css">
ul.ztree {height:100px;}
</style>
</head>
<body>
	<div class="easyui-panel" title="&nbsp;" style="width:500px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="postForm" method="post">
	    	<input type="hidden" id="id" name="id">
	    	<input type="hidden" id="orgId" name="orgId"></input>
	    	<input type="hidden" id="parentId" name="parentId" value="0"></input>
	    	<input type="hidden" id="postPath" name="postPath"></input>
	    	<table cellpadding="5">
	    		<tr>
	    			<td>岗位名称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="postName" name="postName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>岗位描述:</td>
	    			<td><input class="textbox" type="text" id="postDesc" name="postDesc"></input></td>
	    		</tr>
	    		<tr>
	    			<td>上级岗位:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="parentName" readonly="readonly" ></input>
	    			<a  id="menuBtn" href="#" onclick="showMenu();return false;">选择</a>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>状态:</td>
	    			<td>
	    				<select id="avaliable" name="avaliable" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
		    				<option value="Y">有效</option>
		    				<option  value="N">无效</option>
		    			</select>
	    			</td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_add();">提交</a>
	    </div>
	    </div>
	</div>
	
	
	<div id="menuContent" class="menuContent" style="display:none; position: absolute;">
		<ul id="select_tree" class="ztree" style="margin-top:0; width:160px;"></ul>
	</div>

	<script type="text/javascript" src="${resRoot}/js/post/postEdit.js"></script>
	<SCRIPT type="text/javascript">
		<!--
		$(document).ready(function(){
			$("#orgId").val($("#search_orgId").val());
		});
	
		var setting_add = {
			view: {
				dblClickExpand: false,
				selectedMulti: false
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				//beforeClick: beforeClick_add,
				onClick: onClick_add
			}
		};

		var zNodes_add =[
			{id:1, pId:0, name:"组长",open:true},
			{id:2, pId:1, name:"组员"}
		 ];
		
		function onClick_add(e, treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("select_tree"),
			nodes = zTree.getSelectedNodes();
			var cityObj = $("#parentName");
			cityObj.attr("value", nodes[0].name);
			$("#parentId").val(nodes[0].id);
		}

		function showMenu() {
			var parentObj = $("#parentName");
			var offset = $("#parentName").offset();
			$("#menuContent").css({left:offset.left + "px", top:offset.top + parentObj.outerHeight() + "px"}).slideDown("fast");

			$("body").bind("mousedown", onBodyDown);
		}
		function hideMenu() {
			$("#menuContent").fadeOut("fast");
			$("body").unbind("mousedown", onBodyDown);
		}
		function onBodyDown(event) {
			if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
				hideMenu();
			}
		}

		$(document).ready(function(){
			$.fn.zTree.init($("#select_tree"), setting_add, zNodes_add);
		});
		//-->
	</SCRIPT>
</body>
</html>