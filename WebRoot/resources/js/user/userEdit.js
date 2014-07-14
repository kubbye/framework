
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
/*提交用户岗位*/
function submitRel(){
	if($("#userPostForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/user/saveUserPostRel.htm",
			dataType:"json",
			data:$("#userPostForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

/*提交用户岗位*/
function orgExchange(){
	if($("#userOrgForm").form("validate")){
		//如果机构没变，不允许修改
		if($("#select_orgId").val()==$("#oldOrgId").val()){
			$.ALERT('请选择与原机构不同的机构');
			return;
		}
		$.CONFIRM('机构调整','调整机构后用户的岗位和角色会全部失去，确认调整吗?',function(){
			$.ajax({
				url:contextPath+"/admin/user/saveNewOrg.htm",
				dataType:"json",
				data:$("#userOrgForm").serialize(),
				success:function(data){
					$('#user_table').datagrid('clearSelections');
					$.INFO(data.message,closeWindow);
				},
				error:function(data){
					$.ERROR(ajaxError+JSON.stringify(data));
				}
			});
		});
	}
}