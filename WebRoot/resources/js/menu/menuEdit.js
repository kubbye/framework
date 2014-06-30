
/*新增菜单*/
function submitForm_add(){
	if($("#menuForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/menu/saveMenu.htm",
			dataType:"json",
			data:$("#menuForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

/*修改菜单*/
function submitForm_edit(){
	if($("#menuForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/menu/editMenu.htm",
			dataType:"json",
			data:$("#menuForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}