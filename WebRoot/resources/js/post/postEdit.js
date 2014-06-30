//jquery ajax param value get
function getJqueryAjaxParamValue(value){
	 value=encodeURIComponent(value);
     value.replace(/\+/g, "%2B"); 
     value.replace(/\&/g, "%26");
     return value;
}
/*新增岗位*/
function submitForm_add(){
	$.messager.progress();	// display the progress bar
	$('#postForm').form('submit', {
		url: contextPath+"/admin/post/savePost.htm",
		onSubmit: function(){
			var isValid = $(this).form('validate');
			if (!isValid){
				$.messager.progress('close');	// hide progress bar while the form is invalid
			}
			return isValid;	// return false will stop the form submission
		},
		success: function(data){
			$.messager.progress('close');	// hide progress bar while submit successfully
			$.INFO(data.message,closeWindow);
		},
		error:function(data){
			$.ERROR(ajaxError+JSON.stringify(data));
		}
	});
	/*
	if($("#postForm").form("validate")){
		var params = $("#postForm").serialize();
		params = decodeURIComponent(params,true);
		alert(params);
		//params = getJqueryAjaxParamValue(params);
		alert(params);
		 $('#ff').form('submit');
		$.ajax({
			url:contextPath+"/admin/post/savePost.htm",
			dataType:"json",
			data:params,
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
	*/
}

/*修改岗位*/
function submitForm_edit(){
	if($("#postForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/post/editPost.htm",
			dataType:"json",
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