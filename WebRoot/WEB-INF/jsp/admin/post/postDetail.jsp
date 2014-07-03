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
	    <form id="postForm" method="post">
	    	<input type="hidden" id="id" name="id">
	    	<table cellpadding="5">
				  	<tr>
		    			<td>岗位名称:</td>
		    			<td><input class="textbox" type="text" id="postName" name="postName" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>岗位描述:</td>
		    			<td><input class="textbox" type="text" id="postDesc" name="postDesc" readonly="readonly"></input></td>
		    		</tr>
				  	<tr>
		    			<td>状态:</td>
		    			<td>
		    			<select id="avaliable" name="avaliable" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" disabled>
		    				<option value="Y">有效</option>
		    				<option  value="N">无效</option>
		    			</select>
		    			</td>
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
				$.formLoad('postForm',contextPath+'/admin/post/getPostById.json?id='+id,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>