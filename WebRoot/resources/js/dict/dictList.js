var dataTable;
	$(function(){
		$("#dict_query").on("click",function(){
			dictSearch();
		});
		$("#dict_add").on("click",function(){
			dictAdd();		
		});
		$("#dict_edit").on("click",function(){
			dictEidt();
		});
		$("#dict_detail").on("click",function(){
			dictDetail();
		});
		$("#dict_delete").on("click",function(){
			dictDelete();
		});
	});
	$(document).ready(function(){
		initDictDatagrid(contextPath+'/admin/dict/getListData.json');
	});
	/*查询数据字典*/
	function dictSearch(){
		var queryParams = $('#dict_table').datagrid('options').queryParams;  
        /* 此处添加自己的查询条件，类似
        queryParams.lgName = $("#search_lgName").val();  
        */
        //重新加载datagrid的数据  
        $("#dict_table").datagrid('reload');  
	}
	
	/*点击数据字典新增按钮*/
	function dictAdd(){
		openWindow(contextPath+"/admin/dict/toAddDict.htm",'数据字典新增');
	}
	/*点击数据字典编辑按钮*/
	function dictEidt(){
		var sel=isDictSelected();
		if(sel){
			openWindow(contextPath+"/admin/dict/toEditDict.htm?id="+sel.id,'数据字典编辑');
		}
	}
	/*点击数据字典明细按钮*/
	function dictDetail(){
		var sel=isDictSelected();
		if(sel){
			openWindow(contextPath+"/admin/dict/viewDictDetail.htm?id="+sel.id,'数据字典明细');
		}
	}
	/*点击数据字典删除按钮*/
	function dictDelete(){
		var sel=isDictSelected();
		if(sel){
		    $.messager.confirm('删除数据字典', '您确认要删除该数据字典吗?', function(r){
                if (r){
                	$.ajax({
        				url:contextPath+"/admin/dict/deleteDict.json?id="+sel.id,
        				dataType:"json",
        				success:function(data){
        					//清除所有选择
        					$('#dict_table').datagrid('clearSelections');
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
	/*是否有数据字典记录被选中*/
	function isDictSelected(){
		var sel=$.selected("dict_table");
		if(null == sel){
			$.ALERT('请选择数据字典记录');
			return false;
		}
		return sel;
	}
	/*初始化数据字典datagrid*/
	function initDictDatagrid(_url){
		dataTable=$("#dict_table").datagrid({
			fit:true,
			title:'数据字典信息',
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
				  	{field:'typeCode',title:'字典明细编号',align:'center',resizable:false,width:'83'},
				  	{field:'code',title:'代码',align:'center',resizable:false,width:'83'},
				  	{field:'displayname',title:'显示名称',align:'center',resizable:false,width:'83'},
				  	{field:'typeName',title:'字典类型名称',align:'center',resizable:false,width:'83'},
				  	{field:'sortId',title:'排序：数字越小排位越靠前',align:'center',resizable:false,width:'83'},
				  	{field:'editable',title:'是否可编辑：1，是；0，否',align:'center',resizable:false,width:'83'},
				  	{field:'createUser',title:'创建人',align:'center',resizable:false,width:'83'},
				  	{field:'updateUser',title:'更新人',align:'center',resizable:false,width:'83'},
				  	{field:'createTime',title:'创建时间',align:'center',resizable:false,width:'83'},
				  	{field:'updateTime',title:'更新时间',align:'center',resizable:false,width:'83'},
				  	{field:'deleteMark',title:'删除标记：0，未删除；1，已删除',align:'center',resizable:false,width:'83'}
			]],
			toolbar:'#toolbar_dict',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	}