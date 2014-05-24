<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/common/taglibs.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>系统</title>
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
</head>
<body>
	<div class="easyui-panel" title="New Topic" style="width:500px">
		<div style="padding:10px 60px 20px 60px">
	    <form id="userForm" method="post">
	    <input type="hidden" id="userId" name="userId" value="17">
	    	<table cellpadding="5">
	    		<tr>
	    			<td>机构:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="orgId" name="orgId" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>登录名:</td>
	    			<td><input class="textbox" type="text" id="lgName" name="lgName" data-options="required:true,validType:'email'"></input></td>
	    		</tr>
	    		<tr>
	    			<td>员工名:</td>
	    			<td><input class="easyui-validatebox textbox" type="text" id="userName" name="userName" data-options="required:true"></input></td>
	    		</tr>
	    		<tr>
	    			<td>AVALILABLE:</td>
	    			<td><input class="textbox" id="available" name="available"></input></td>
	    		</tr>
	    	</table>
	    </form>
	    <div style="text-align:center;padding:5px">
	    	<a href="javascript:void(0)" id="submitForm" class="easyui-linkbutton">Submit</a>
	    	<a href="javascript:void(0)" id="clearForm" class="easyui-linkbutton">Clear</a>
	    </div>
	    </div>
	</div>
	
	<script>
		$(function(){
			$("#submitForm").on("click",submitForm);
			$("#clearForm").on("click",clearForm);
			$("#submitForm").linkbutton({disabled:false});
		});
		function submitForm(){
			var surl;
			if(null!=$("#userId").val() && ''!=$("#userId").val()){
				surl="${pageContext.request.contextPath}/admin/user/editUser.htm";
			}else{
				surl="http://localhost:8080/framework/admin/user/saveUser.htm";
			}
			if($("#userForm").form("validate")){
				$.ajax({
					url:surl,
					dataType:"json",
					data:$("#userForm").serialize(),
					success:function(data){
						messageAlert(data.message);
					},
					error:function(data){
						messageAlert("发生异常:"+JSON.stringify(data));
					}
				});
			}
			/*
			$('#userForm').form('submit',{
				url:surl,
				onSubmit:function(){
					// $.messager.alert('Url',surl,'info');
					alert($("#userForm").serialize());
					if($("#userForm").form("validate"))   
                        return true;
                    else  
                        return false;   
				},
				success:function(data){
					alert(data);
				}
			});
			*/
		}
		function clearForm(){
			$('#userForm').form('clear');
		}
	</script>
</body>
</html>