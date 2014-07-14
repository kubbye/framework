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
	    <form id="syslogForm" method="post">
	    	<input type="hidden" id="id" name="id">
	    	<table cellpadding="5">
				  	<tr>
		    			<td>模块代码:</td>
		    			<td><input class="textbox" type="text" id="moduleCode" name="moduleCode" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>模块名称:</td>
		    			<td><input class="textbox" type="text" id="moduleName" name="moduleName" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>操作类型：增删改查:</td>
		    			<td><input class="textbox" type="text" id="actType" name="actType" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>数据id:</td>
		    			<td><input class="textbox" type="text" id="detailId" name="detailId" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>备注:</td>
		    			<td><input class="textbox" type="text" id="memo" name="memo" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>操作人ID:</td>
		    			<td><input class="textbox" type="text" id="operatorId" name="operatorId" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>操作人姓名:</td>
		    			<td><input class="textbox" type="text" id="operatorName" name="operatorName" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>操作日期:</td>
		    			<td><input class="textbox" type="text" id="operateDate" name="operateDate" disabled></input></td>
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
				$.formLoad('syslogForm',contextPath+'/admin/syslog/getSyslogById.json?id='+id,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>