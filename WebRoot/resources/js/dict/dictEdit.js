
/*新增数据字典*/
function submitForm_add(){
	if($("#dictForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/dict/saveDict.htm",
			dataType:"json",
			data:$("#dictForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

/*修改数据字典*/
function submitForm_edit(){
	if($("#dictForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/dict/editDict.htm",
			dataType:"json",
			data:$("#dictForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}