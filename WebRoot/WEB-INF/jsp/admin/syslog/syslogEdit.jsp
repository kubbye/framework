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
	    			<td  align="right">模块代码:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="moduleCode" name="moduleCode" data-options="validType:['maxLength[50]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">模块名称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="moduleName" name="moduleName" data-options="validType:['maxLength[100]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">操作类型：增删改查:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="actType" name="actType" data-options="required:true,validType:['digit']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">数据id:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="detailId" name="detailId" data-options="validType:['maxLength[100]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">备注:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="memo" name="memo" data-options="validType:['maxLength[65,535]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">操作人ID:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="operatorId" name="operatorId" data-options="required:true,validType:['digit']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">操作人姓名:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="operatorName" name="operatorName" data-options="validType:['maxLength[100]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td  align="right">操作日期:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="operateDate" name="operateDate" data-options="required:true"></input></td>
	    		</tr>
	    		
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_edit();">提交</a>
	    </div>
	    </div>
	</div>
	
	<script type="text/javascript" src="${resRoot}/js/syslog/syslogEdit.js"></script>
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