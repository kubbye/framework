
/*新增岗位*/
function submitForm_add(){
	if($("#postForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/post/savePost.htm",
			dataType:"json",
			type:"post",
			//contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			data:$("#postForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

/*修改岗位*/
function submitForm_edit(){
	if($("#postForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/post/editPost.htm",
			dataType:"json",
			type:"post",
			//contentType: "application/x-www-form-urlencoded; charset=utf-8",
			data:$("#postForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}