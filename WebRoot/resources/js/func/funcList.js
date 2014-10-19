var dataTable;
	$(function(){
		$("#func_query").on("click",function(){
			funcSearch();
		});
		$("#func_add").on("click",function(){
			funcAdd();		
		});
		$("#func_edit").on("click",function(){
			funcEidt();
		});
		$("#func_detail").on("click",function(){
			funcDetail();
		});
		$("#func_delete").on("click",function(){
			funcDelete();
		});
		$(document).on("keypress",function(event){
			if(event){
	   			if(event.keyCode==13 || event.keyCode==0){
	   			    setTimeout(funcSearch,300); 
	  		 	}
	  		}
		});
	});
	$(document).ready(function(){
		initFuncDatagrid(contextPath+'/admin/func/getListData.json');
	});
	/*查询菜单功能*/
	function funcSearch(){
		var queryParams = $('#func_table').datagrid('options').queryParams;  
        /* 此处添加自己的查询条件，类似
        queryParams.lgName = $("#search_lgName").val();  
        */
        //重新加载datagrid的数据  
        $("#func_table").datagrid('reload');  
	}
	
	/*点击菜单功能新增按钮*/
	function funcAdd(){
		openWindow(contextPath+"/admin/func/toAddFunc.htm",'菜单功能新增');
	}
	/*点击菜单功能编辑按钮*/
	function funcEidt(){
		var sel=isFuncSelected();
		if(sel){
			openWindow(contextPath+"/admin/func/toEditFunc.htm?id="+sel.id,'菜单功能编辑');
		}
	}
	/*点击菜单功能明细按钮*/
	function funcDetail(){
		var sel=isFuncSelected();
		if(sel){
			openWindow(contextPath+"/admin/func/viewFuncDetail.htm?id="+sel.id,'菜单功能明细');
		}
	}
	/*点击菜单功能删除按钮*/
	function funcDelete(){
		var sel=isFuncSelected();
		if(sel){
		    $.messager.confirm('删除菜单功能', '您确认要删除该菜单功能吗?', function(r){
                if (r){
                	$.ajax({
        				url:contextPath+"/admin/func/deleteFunc.json?id="+sel.id,
        				dataType:"json",
        				success:function(data){
        					//清除所有选择
        					$('#func_table').datagrid('clearSelections');
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
	/*是否有菜单功能记录被选中*/
	function isFuncSelected(){
		var sel=$.selected("func_table");
		if(null == sel){
			$.ALERT('请选择菜单功能记录');
			return false;
		}
		return sel;
	}
	/*初始化菜单功能datagrid*/
	function initFuncDatagrid(_url){
		dataTable=$("#func_table").datagrid({
			fit:true,
			title:'菜单功能信息',
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
				  	{field:'funcName',title:'功能名称',align:'center',resizable:false,width:'100'},
				  	{field:'funcCode',title:'代码，唯一',align:'center',resizable:false,width:'100'},
				  	{field:'url',title:'路径',align:'center',resizable:false,width:'100'},
				  	{field:'menuId',title:'menuId',align:'center',resizable:false,width:'100'},
				  	{field:'createUser',title:'创建人',align:'center',resizable:false,width:'100'},
				  	{field:'updateUser',title:'更新人',align:'center',resizable:false,width:'100'},
				  	{field:'createTime',title:'创建时间',align:'center',resizable:false,width:'100'},
				  	{field:'updateTime',title:'更新时间',align:'center',resizable:false,width:'100'},
				  	{field:'deleteMark',title:'删除标记：0，未删除；1，已删除',align:'center',resizable:false,width:'100'}
			]],
			toolbar:'#toolbar_func',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	}