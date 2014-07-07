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
	    <form id="userForm" method="post">
	    	<input type="hidden" id="userId" name="userId">
	    	<table cellpadding="5">
				  	<tr>
		    			<td>登录名称:</td>
		    			<td><input class="textbox" type="text" id="lgName" name="lgName" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>用户昵称:</td>
		    			<td><input class="textbox" type="text" id="userName" name="userName" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>密码:</td>
		    			<td><input class="textbox" type="text" id="passWord" name="passWord" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>性别:</td>
		    			<td><select id="sex" name="sex" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" disabled>
	    				<option value="1">男</option>
	    				<option value="0">女</option>
	    			</select></input></td>
		    		</tr>
				  	<tr>
		    			<td>照片:</td>
		    			<td><input class="textbox" type="text" id="photo" name="photo" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>备注:</td>
		    			<td><input class="textbox" type="text" id="memo" name="memo" disabled></input></td>
		    		</tr>
				  	<tr>
		    			<td>状态:</td>
		    			<td><select id="avaliable" name="avaliable" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" disabled>
	    				<option value="Y">有效</option>
	    				<option  value="N">无效</option>
	    			</select></td>
		    		</tr>
	    	</table>
	    	</div>
	    	
	    	
	    	<div class="easyui-panel" title="详细信息" style="width:490px;padding:10px 60px 20px 60px;"
	                data-options="iconCls:'icon-save',collapsed:true,collapsible:true,minimizable:false,maximizable:false,closable:false">
	                <input  type="hidden" id="emply_empId" name="emply.empId">
	                <input  type="hidden" id="emply_userId" name="emply.userId">
	           <table cellpadding="5">
	    		<tr>
	    			<td align="right">雇员姓名:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_empName" name="emply.empName" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">证件类型:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_certType" name="emply.certType" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">证件号码:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_certNo" name="emply.certNo" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">籍贯:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_nativePlace" name="emply.nativePlace" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">户籍地址:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_nativeLocation" name="emply.nativeLocation" data-options="validType:['maxLength[256]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">联系地址:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_address" name="emply.address" data-options="validType:['maxLength[256]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">邮政编码:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_zipCode" name="emply.zipCode" data-options="validType:['maxLength[32]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">职位:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_position" name="emply.position" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">部门:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_department" name="emply.department" data-options="validType:['maxLength[50]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">手机:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_mobile" name="emply.mobile" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">手机2:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_mobile2" name="emply.mobile2" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">家庭电话:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_homeTel" name="emply.homeTel" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">办公电话:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_officeTel" name="emply.officeTel" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">公司电话:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_compTel" name="emply.compTel" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">联系电话:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_linkTel" name="emply.linkTel" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">家庭住址:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_homeAddress" name="emply.homeAddress" data-options="validType:['maxLength[128]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">邮件:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_email" name="emply.email" data-options="validType:['maxLength[128]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">微信号:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_weichat" name="emply.weichat" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">MSN号码:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_msn" name="emply.msn" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">QQ号码:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_qq" name="emply.qq" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">微博:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_weiblog" name="emply.weiblog" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">生日:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="emply_birthday" name="emply.birthday" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">血型:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_bloodType" name="emply.bloodType" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">学历:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="emply_eduLevel" name="emply.eduLevel" data-options="validType:['maxLength[64]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">上岗日期:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="emply_assumeDate" name="emply.assumeDate" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">离职日期:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="emply_leaveDate" name="emply.leaveDate" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">政治面貌:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="emply_political" name="emply.political" data-options="validType:['maxLength[32]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">民族:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_nation" name="emply.nation" data-options="validType:['maxLength[32]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">技术职称:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_techLevel" name="emply.techLevel" data-options="validType:['maxLength[32]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">计算机能力:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_computer" name="emply.computer" data-options="validType:['maxLength[32]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">专职/兼职:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_fullJob" name="emply.fullJob" data-options="validType:['maxLength[32]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">是否有驾照:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_driverLic" name="emply.driverLic" data-options="validType:['maxLength[32]']" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">其他:</td>
	    				<td>
	    				<input class="easyui-validatebox textbox" type="text" id="emply_other" name="emply.other" data-options="validType:['maxLength[512]']" disabled></input></td>
	    		</tr>
	    		
	    	</table>
	        </div>
	        
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="closeWindow();">返回</a>
	    </div>
	    
	</div>
	
	<script>
		$(document).ready(function(){
			<c:if test="${!empty userId}">
				var userId='${userId}';
				$.formLoad('userForm',contextPath+'/admin/user/getUserById.json?userId='+userId,function(data){
					var emply=data.emply;
					$.each(emply,function(key,item){
						if("INPUT"==$("#emply_"+key).get(0).tagName.toUpperCase()){
							$("#emply_"+key).val(item);
						}else if("SELECT"==$("#emply_"+key).get(0).tagName.toUpperCase()){
							$("#emply_"+key).searchbox('setValue',item);
						}
					});
				});
			</c:if>
		});
	</script>
</body>
</html>