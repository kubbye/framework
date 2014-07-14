
/*新增授权*/
function submitForm_add(){
	if($("#authForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/auth/saveAuth.htm",
			dataType:"json",
			data:$("#authForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

/*修改授权*/
function submitForm_edit(){
	if($("#authForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/auth/editAuth.htm",
			dataType:"json",
			data:$("#authForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}