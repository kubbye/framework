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
	    <form id="orgForm" method="post">
	    	<input type="hidden" id="orgId" name="orgId">
	    	<input type="hidden" id="parentId" name="parentId"></input>
	    	<input class="textbox" type="hidden" id="orgPath" name="orgPath"></input>
	    	<table cellpadding="5">
	    		<tr>
	    			<td align="right">机构代码:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgCode" name="orgCode" 
	    					data-options="required:true,validType:{maxLength:[32],remote:[contextPath+'/admin/org/isCodeExists.json','orgCode']}"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">简称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgSimpleName" name="orgSimpleName" data-options="required:true,validType:['maxLength[128]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">机构全称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgFullName" name="orgFullName" data-options="required:true,validType:['maxLength[200]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">机构地址:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgAddress1" name="orgAddress1" data-options="validType:['maxLength[120]']"></input></td>
	    		</tr>
	    		<!-- 
	    		<tr>
	    			<td align="right">机构地址2:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgAddress2" name="orgAddress2" data-options="validType:['maxLength[120]']"></input></td>
	    		</tr>
	    		 -->
	    		<tr>
	    			<td align="right">机构电话:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgTel1" name="orgTel1" data-options="validType:['maxLength[120]']"></input></td>
	    		</tr>
	    		<!-- 
	    		<tr>
	    			<td align="right">机构电话2:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgTel2" name="orgTel2" data-options="validType:['maxLength[120]']"></input></td>
	    		</tr>
	    		 -->
	    		<tr>
	    			<td align="right">机构注册日期:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgRegDate" name="orgRegDate"></input></td>
	    		</tr>
	    		<!-- 
	    		<tr>
	    			<td align="right">类型:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgType" name="orgType"></input></td>
	    		</tr>
	    		 -->
	    		<tr>
	    			<td align="right">机构传真:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgFax" name="orgFax" data-options="validType:['maxLength[120]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">机构邮编:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgPostal" name="orgPostal" data-options="validType:['maxLength[120]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">法人:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgLegal" name="orgLegal" data-options="validType:['maxLength[120]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">税号:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgTaxNo" name="orgTaxNo" data-options="validType:['maxLength[120]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">注册登记号:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgRegNo" name="orgRegNo" data-options="validType:['maxLength[120]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">所在地区:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgBelongDist" name="orgBelongDist" data-options="validType:['maxLength[120]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">主页:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="webUrl" name="webUrl" data-options="validType:['maxLength[512]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">微信号:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="weichat" name="weichat" data-options="validType:['maxLength[56]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">微博:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="weiblog" name="weiblog" data-options="validType:['maxLength[56]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">备注:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="memo" name="memo" data-options="validType:['maxLength[1024]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">机构状态:</td>
	    			<td>
	    				<select id="orgState" name="orgState" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
		    				<option value="Y">营业中</option>
		    				<option value="N">停业</option>
		    			</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td align="right">状态:</td>
	    			<td>
	    				<select id="avaliable" name="avaliable" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
		    				<option value="Y">有效</option>
		    				<option value="N">无效</option>
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
	
	<script type="text/javascript" src="${resRoot}/js/org/orgEdit.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#parentId").val($("#search_parentId").val());
		});
	</script>
</body>
</html>