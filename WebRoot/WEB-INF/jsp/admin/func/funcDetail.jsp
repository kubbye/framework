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
	    <form id="funcForm" method="post">
	    	<input type="hidden" id="id" name="id">
	    	<table cellpadding="5">
				  	<tr>
		    			<td>功能名称:</td>
		    			<td><input class="textbox" type="text" id="funcName" name="funcName" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>代码，唯一:</td>
		    			<td><input class="textbox" type="text" id="funcCode" name="funcCode" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>路径:</td>
		    			<td><input class="textbox" type="text" id="url" name="url" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>menuId:</td>
		    			<td><input class="textbox" type="text" id="menuId" name="menuId" disabled></input></td>
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
				$.formLoad('funcForm',contextPath+'/admin/func/getFuncById.json?id='+id,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>