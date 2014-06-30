
/*新增用户*/
function submitForm_add(){
	if($("#userForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/user/saveUser.htm",
			dataType:"json",
			data:$("#userForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

/*修改用户*/
function submitForm_edit(){
	if($("#userForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/user/editUser.htm",
			dataType:"json",
			data:$("#userForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}