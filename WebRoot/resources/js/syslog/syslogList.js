var dataTable;
	$(function(){
		$("#syslog_query").on("click",function(){
			syslogSearch();
		});
		$("#syslog_add").on("click",function(){
			syslogAdd();		
		});
		$("#syslog_edit").on("click",function(){
			syslogEidt();
		});
		$("#syslog_detail").on("click",function(){
			syslogDetail();
		});
		$("#syslog_delete").on("click",function(){
			syslogDelete();
		});
	});
	$(document).ready(function(){
		initSyslogDatagrid(contextPath+'/admin/syslog/getListData.json');
	});
	/*查询系统日志*/
	function syslogSearch(){
		var queryParams = $('#syslog_table').datagrid('options').queryParams;  
        /* 此处添加自己的查询条件，类似
        queryParams.lgName = $("#search_lgName").val();  
        */
        //重新加载datagrid的数据  
        $("#syslog_table").datagrid('reload');  
	}
	
	/*点击系统日志新增按钮*/
	function syslogAdd(){
		openWindow(contextPath+"/admin/syslog/toAddSyslog.htm",'系统日志新增');
	}
	/*点击系统日志编辑按钮*/
	function syslogEidt(){
		var sel=isSyslogSelected();
		if(sel){
			openWindow(contextPath+"/admin/syslog/toEditSyslog.htm?id="+sel.id,'系统日志编辑');
		}
	}
	/*点击系统日志明细按钮*/
	function syslogDetail(){
		var sel=isSyslogSelected();
		if(sel){
			openWindow(contextPath+"/admin/syslog/viewSyslogDetail.htm?id="+sel.id,'系统日志明细');
		}
	}
	/*点击系统日志删除按钮*/
	function syslogDelete(){
		var sel=isSyslogSelected();
		if(sel){
		    $.messager.confirm('删除系统日志', '您确认要删除该系统日志吗?', function(r){
                if (r){
                	$.ajax({
        				url:contextPath+"/admin/syslog/deleteSyslog.json?id="+sel.id,
        				dataType:"json",
        				success:function(data){
        					//清除所有选择
        					$('#syslog_table').datagrid('clearSelections');
        					$.INFO(data.message,closeWindow);
        				},
        				error:function(data){
        					$.ERROR(ajaxError+JSON.stringify(data));
        				}
        			});
                }
            });
		}
	}
	/*是否有系统日志记录被选中*/
	function isSyslogSelected(){
		var sel=$.selected("syslog_table");
		if(null == sel){
			$.ALERT('请选择系统日志记录');
			return false;
		}
		return sel;
	}
	/*初始化系统日志datagrid*/
	function initSyslogDatagrid(_url){
		dataTable=$("#syslog_table").datagrid({
			fit:true,
			title:'系统日志信息',
			url:_url,
			iconCls:'icon-ok',
			nowrap: true,
			autoRowHeight: false,
			resizable:true,
			striped: true,
			collapsible:true,
			remoteSort: true,
			singleSelect:true,
			idField:'id',				
			collapsible:false,
			pagination:true,pageSize:10,
			rownumbers:true,
			columns:[[
				  	{field:'moduleCode',title:'模块代码',align:'center',resizable:false,width:'111'},
				  	{field:'moduleName',title:'模块名称',align:'center',resizable:false,width:'111'},
				  	{field:'actType',title:'操作类型：增删改查',align:'center',resizable:false,width:'111'},
				  	{field:'detailId',title:'数据id',align:'center',resizable:false,width:'111'},
				  	{field:'memo',title:'备注',align:'center',resizable:false,width:'111'},
				  	{field:'operatorId',title:'操作人ID',align:'center',resizable:false,width:'111'},
				  	{field:'operatorName',title:'操作人姓名',align:'center',resizable:false,width:'111'},
				  	{field:'operateDate',title:'操作日期',align:'center',resizable:false,width:'111'}
			]],
			toolbar:'#toolbar_syslog',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	}