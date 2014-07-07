
/*新增机构*/
function submitForm_add(){
	if($("#orgForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/org/saveOrg.htm",
			dataType:"json",
			data:$("#orgForm").serialize(),
			success:function(data){
				var node={};
				node.id=data.org.orgId;
				node.parentId=data.org.parentId;
				node.name=(data.org.orgSimpleName==null || data.org.orgSimpleName=='')?data.org.orgFullName:data.org.orgSimpleName;
				parent.addTreeNode($("#parentId").val(),$.extend(data.org,node));
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

/*修改机构*/
function submitForm_edit(){
	if($("#orgForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/org/editOrg.htm",
			dataType:"json",
			data:$("#orgForm").serialize(),
			success:function(data){
				parent.updateNodeName($("#orgId").val(),$("#orgSimpleName").val());
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

if ($.fn.validatebox){
	$.fn.validatebox.defaults.rules.remote.message = '机构代码已存在';
}