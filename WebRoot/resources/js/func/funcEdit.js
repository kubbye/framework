
/*新增菜单功能*/
function submitForm_add(){
	if($("#funcForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/func/saveFunc.htm",
			dataType:"json",
			data:$("#funcForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

/*修改菜单功能*/
function submitForm_edit(){
	if($("#funcForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/func/editFunc.htm",
			dataType:"json",
			data:$("#funcForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}