
/*新增系统日志*/
function submitForm_add(){
	if($("#syslogForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/syslog/saveSyslog.htm",
			dataType:"json",
			data:$("#syslogForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}

/*修改系统日志*/
function submitForm_edit(){
	if($("#syslogForm").form("validate")){
		$.ajax({
			url:contextPath+"/admin/syslog/editSyslog.htm",
			dataType:"json",
			data:$("#syslogForm").serialize(),
			success:function(data){
				$.INFO(data.message,closeWindow);
			},
			error:function(data){
				$.ERROR(ajaxError+JSON.stringify(data));
			}
		});
	}
}