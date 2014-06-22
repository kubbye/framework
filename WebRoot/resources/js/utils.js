
jQuery.extend({
	ALERT:function(msg,fn){
		$.messager.alert('提示信息',msg,'',fn);
	},
	ERROR:function(msg,fn){
		$.messager.alert('提示信息',msg,'error',fn);
	},
	INFO:function(msg,fn){
		$.messager.alert('提示信息',msg,'info',fn);
	},
	QUESTION:function(msg,fn){
		$.messager.alert('提示信息',msg,'question',fn);
	},
	WARNING:function(msg,fn){
		$.messager.alert('提示信息',msg,'warning',fn);
	},
	selected:function(tableid){
		var sel=$("#"+tableid).datagrid('getSelected');
		return sel;
	}
});


jQuery.extend({
	formLoad:function(formId,_url,callback){
		$.ajax({
			url:_url,
			type:'post',
			dataType:'json',
			success:function(data){
				$("#"+formId).form('load',data);
				if(callback){
					callback(data);
				}
			},
			error:function(data){
				$.ALERT('加载数据失败！');
			}
		});
	},
	formClear:function(formId){
		$('#'+formId).form('clear');
	}
});

/*打开一个新窗口*/
function openWindow(_url,_title,icons){
	var win = "<div id=\"innerWindow\" class=\"easyui-window\">dfasfds</div>";
	$("body").append(win);
	$('#innerWindow').window({
		modal:true,
		title:_title,
		height:300,
		width:600,
		minimizable:false,
		maximizable:false,
		maximized:true,
		resizable:false,
		collapsible:false,
		draggable:false,
		iconCls:'icon-save',
		inline:true
	});
	$('#innerWindow').window('refresh', _url);
}
/*关闭新窗口*/
function closeWindow(){
	$('#innerWindow').window('close');
	if(dataTable){
		refreshParentTable();
	}
}
/*刷新父页面datagrid表格数据*/
function refreshParentTable(){
	dataTable.datagrid('reload');
}