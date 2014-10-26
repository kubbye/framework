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
	    <form id="userForm" method="post">
		<div style="padding:10px 60px 20px 60px">
	    	<input type="hidden" id="userId" name="userId">
	    	<input type="hidden" id="orgId" name="orgId"></input>
	    	<input type="hidden" id="loginId" name="loginId"></input>
	    	<input type="hidden" id="userType" name="userType"></input>
	    	<table cellpadding="5">
	    		<tr>
	    			<td align="right">登录名称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="lgName" name="lgName" data-options="required:true" style="disabled:true" disabled></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">用户昵称:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="userName" name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">性别:</td>
	    			<td><select id="sex" name="sex" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'">
	    				<option value="1">男</option>
	    				<option value="0">女</option>
	    			</select></td>
	    		</tr>
	    		<tr>
	    			<td align="right">照片:</td>
	    			<td><input class="textbox" type="text" id="photo" name="photo"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">备注:</td>
	    			<td><input class="textbox" type="text" id="memo" name="memo"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">状态:</td>
	    			<td><select id="avaliable" name="avaliable" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'">
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
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_empName" name="emply.empName" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">证件类型:</td>
	    				<td>
	    				<select id="emply_certType" name="emply.certType" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
		    				<option value="1">--请选择--</option>
		    				<option value="1">居民身份证</option>
		    				<option  value="2">士官证</option>
		    				<option  value="3">学生证</option>
		    				<option  value="4">驾驶证</option>
		    				<option  value="5">护照</option>
		    				<option  value="6">港澳通行证</option>
		    			</select>
	    				</td>
	    		</tr>
	    		<tr>
	    			<td align="right">证件号码:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_certNo" name="emply.certNo" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">籍贯:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_nativePlace" name="emply.nativePlace" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">户籍地址:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_nativeLocation" name="emply.nativeLocation" data-options="validType:['maxLength[256]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">联系地址:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_address" name="emply.address" data-options="validType:['maxLength[256]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">邮政编码:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_zipCode" name="emply.zipCode" data-options="validType:['maxLength[32]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">职位:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_position" name="emply.position" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">部门:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_department" name="emply.department" data-options="validType:['maxLength[50]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">手机:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_mobile" name="emply.mobile" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">手机2:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_mobile2" name="emply.mobile2" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">家庭电话:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_homeTel" name="emply.homeTel" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">办公电话:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_officeTel" name="emply.officeTel" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">公司电话:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_compTel" name="emply.compTel" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">联系电话:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_linkTel" name="emply.linkTel" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">家庭住址:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_homeAddress" name="emply.homeAddress" data-options="validType:['maxLength[128]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">邮件:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_email" name="emply.email" data-options="validType:['maxLength[128]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">微信号:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_weichat" name="emply.weichat" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">MSN号码:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_msn" name="emply.msn" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">QQ号码:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_qq" name="emply.qq" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">微博:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_weiblog" name="emply.weiblog" data-options="validType:['maxLength[64]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">生日:</td>
	    			<td><input class="Wdate" type="text" id="emply_birthday" name="emply.birthday" onClick="WdatePicker()"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">血型:</td>
	    				<td>
	    				<select id="emply_bloodType" name="emply.bloodType" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
		    				<option value="">--请选择--</option>
		    				<option value="O">O</option>
		    				<option  value="A">A</option>
		    				<option  value="B">B</option>
		    				<option  value="AB">AB</option>
		    			</select>
	    				</td>
	    		</tr>
	    		<tr>
	    			<td align="right">学历:</td>
	    			<td>
	    			<select id="emply_eduLevel" name="emply.eduLevel" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
		    				<option value="">--请选择--</option>
		    				<option value="1">高中</option>
		    				<option  value="2">专科</option>
		    				<option  value="3">本科</option>
		    				<option  value="4">研究生</option>
		    			</select>
		    			</td>
	    		</tr>
	    		<tr>
	    			<td align="right">上岗日期:</td>
	    			<td><input class="Wdate" type="text" id="emply_assumeDate" name="emply.assumeDate" onClick="WdatePicker()"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">离职日期:</td>
	    			<td><input class="Wdate" type="text" id="emply_leaveDate" name="emply.leaveDate" onClick="WdatePicker()"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">政治面貌:</td>
	    			<td>
	    			<select id="emply_political" name="emply.political" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
		    				<option value="">--请选择--</option>
		    				<option value="1">党员</option>
		    				<option  value="2">团员</option>
		    				<option  value="3">群众</option>
		    				<option  value="4">无党派人士</option>
		    			</select>
	    			</td>
	    		</tr>
	    		<tr>
	    			<td align="right">民族:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_nation" name="emply.nation" data-options="validType:['maxLength[32]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">技术职称:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_techLevel" name="emply.techLevel" data-options="validType:['maxLength[32]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">计算机能力:</td>
	    				<td><input class="easyui-validatebox textbox" type="text" id="emply_computer" name="emply.computer" data-options="validType:['maxLength[32]']"></input></td>
	    		</tr>
	    		<tr>
	    			<td align="right">专职/兼职:</td>
	    				<td>
	    				<select id="emply_fullJob" name="emply.fullJob" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
		    				<option value="1">全职</option>
		    				<option  value="2">兼职</option>
		    			</select>
	    				</td>
	    		</tr>
	    		<tr>
	    			<td align="right">是否有驾照:</td>
	    				<td>
	    				<select id="emply_driverLic" name="emply.driverLic" class="easyui-combobox"  data-options="width:140,panelHeight:'auto'" >
		    				<option value="">--请选择--</option>
		    				<option value="0">无</option>
		    				<option  value="1">有</option>
		    			</select>
	    				</td>
	    				
	    		</tr>
	    		<tr>
	    			<td align="right">其他:</td>
	    				<td>
	    				<input class="easyui-validatebox textbox" type="text" id="emply_other" name="emply.other" data-options="validType:['maxLength[512]']"></input></td>
	    		</tr>
	    		
	    	</table>
	        </div>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton" onclick="submitForm_edit();">提交</a>
	    </div>
	    
	</div>
	
	<script type="text/javascript" src="${resRoot}/js/user/userEdit.js"></script>
	<script>
		$(document).ready(function(){
			<c:if test="${!empty userId}">
				var userId='${userId}';
				$.formLoad('userForm',contextPath+'/admin/user/getUserById.json?userId='+userId,function(data){
					var emply=data.emply;
					$.each(emply,function(key,item){
						if(null!=$("#emply_"+key).get(0) && "INPUT"==$("#emply_"+key).get(0).tagName.toUpperCase()){
							$("#emply_"+key).val(item);
						}else if(null!=$("#emply_"+key).get(0) && "SELECT"==$("#emply_"+key).get(0).tagName.toUpperCase()){
							$("#emply_"+key).combobox('setValue',item);
						}
					});
				});
			</c:if>
		});
	</script>
</body>
</html>