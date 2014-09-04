<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/jsp/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
</head>
<body>
	
	<div class="easyui-panel" title="&nbsp;" style="width:500px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="dictForm" method="post">
	    	<input type="hidden" id="id" name="id">
	    	<table cellpadding="5">
				  	<tr>
		    			<td>字典明细编号:</td>
		    			<td><input class="textbox" type="text" id="typeCode" name="typeCode" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>代码:</td>
		    			<td><input class="textbox" type="text" id="code" name="code" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>显示名称:</td>
		    			<td><input class="textbox" type="text" id="displayname" name="displayname" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>字典类型名称:</td>
		    			<td><input class="textbox" type="text" id="typeName" name="typeName" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>排序：数字越小排位越靠前:</td>
		    			<td><input class="textbox" type="text" id="sortId" name="sortId" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>是否可编辑：1，是；0，否:</td>
		    			<td><input class="textbox" type="text" id="editable" name="editable" disabled></input></td>
		    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="closeWindow();">返回</a>
	    </div>
	    </div>
	</div>
	
	<script>
		$(document).ready(function(){
			<c:if test="${!empty id}">
				var id='${id}';
				$.formLoad('dictForm',contextPath+'/admin/dict/getDictById.json?id='+id,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>