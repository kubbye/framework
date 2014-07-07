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
	    	<table cellpadding="5">
				  	<tr>
		    			<td align="right">机构代码:</td>
		    			<td><input class="textbox" type="text" id="orgCode" name="orgCode" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">简称:</td>
		    			<td><input class="textbox" type="text" id="orgSimpleName" name="orgSimpleName" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">机构全称:</td>
		    			<td><input class="textbox" type="text" id="orgFullName" name="orgFullName" disabled></input></td>
		    		</tr>
		    		
				  	<tr>
		    			<td align="right">机构地址:</td>
		    			<td><input class="textbox" type="text" id="orgAddress1" name="orgAddress1" disabled></input></td>
		    		</tr>
		    		<!-- 
				  	<tr>
		    			<td align="right">机构地址2:</td>
		    			<td><input class="textbox" type="text" id="orgAddress2" name="orgAddress2" disabled></input></td>
		    		</tr>
		    		 -->
				  	<tr>
		    			<td align="right">机构电话:</td>
		    			<td><input class="textbox" type="text" id="orgTel1" name="orgTel1" disabled></input></td>
		    		</tr>
		    		<!-- 
				  	<tr>
		    			<td align="right">机构电话2:</td>
		    			<td><input class="textbox" type="text" id="orgTel2" name="orgTel2" disabled></input></td>
		    		</tr>
		    		 -->
				  	<tr>
		    			<td align="right">机构注册日期:</td>
		    			<td><input class="textbox" type="text" id="orgRegDate" name="orgRegDate" disabled></input></td>
		    		</tr>
		    		<!-- 
				  	<tr>
		    			<td align="right">类型::</td>
		    			<td><input class="textbox" type="text" id="orgType" name="orgType" disabled></input></td>
		    		</tr>
		    		 -->
				  	<tr>
		    			<td align="right">机构传真:</td>
		    			<td><input class="textbox" type="text" id="orgFax" name="orgFax" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">机构邮编:</td>
		    			<td><input class="textbox" type="text" id="orgPostal" name="orgPostal" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">法人:</td>
		    			<td><input class="textbox" type="text" id="orgLegal" name="orgLegal" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">税号:</td>
		    			<td><input class="textbox" type="text" id="orgTaxNo" name="orgTaxNo" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">注册登记号:</td>
		    			<td><input class="textbox" type="text" id="orgRegNo" name="orgRegNo" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">所在地区:</td>
		    			<td><input class="textbox" type="text" id="orgBelongDist" name="orgBelongDist" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">主页:</td>
		    			<td><input class="textbox" type="text" id="webUrl" name="webUrl" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">微信号:</td>
		    			<td><input class="textbox" type="text" id="weichat" name="weichat" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">微博:</td>
		    			<td><input class="textbox" type="text" id="weiblog" name="weiblog" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">备注:</td>
		    			<td><input class="textbox" type="text" id="memo" name="memo" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td align="right">机构状态:</td>
		    			<td>
		    			<select id="orgState" name="orgState" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" disabled>
		    				<option value="Y">营业中</option>
		    				<option value="N">停业</option>
		    			</select>
		    			</td>
		    		</tr>
				  	<tr>
		    			<td align="right">状态:</td>
		    			<td>
		    			<select id="avaliable" name="avaliable" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" disabled>
		    				<option value="Y">有效</option>
		    				<option value="N">无效</option>
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
			<c:if test="${!empty orgId}">
				var orgId='${orgId}';
				$.formLoad('orgForm',contextPath+'/admin/org/getOrgById.json?orgId='+orgId,function(data){
					
				});
			</c:if>
		});
	</script>
</body>
</html>