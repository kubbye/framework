
/*新增角色*/
function submitForm_add(){
	if($("#roleForm").form("validate")){
		$.ajax({
			url:contextPath+"//admin/role/saveRole.htm",
			dataType:"json",
			data:$("#roleForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

/*修改角色*/
function submitForm_edit(){
	if($("#roleForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/role/editRole.htm",
			dataType:"json",
			data:$("#roleForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}