var dataTable;
	$(function(){
		$("#menu_query").on("click",function(){
			menuSearch();
		});
		$("#menu_add").on("click",function(){
			menuAdd();		
		});
		$("#menu_edit").on("click",function(){
			menuEidt();
		});
		$("#menu_detail").on("click",function(){
			menuDetail();
		});
		$("#menu_delete").on("click",function(){
			menuDelete();
		});
	});
	$(document).ready(function(){
		initMenuDatagrid(contextPath+'/menu/getListData.json');
	});
	/*查询菜单*/
	function menuSearch(){
		var queryParams = $('#menu_table').datagrid('options').queryParams;  
        /* 此处添加自己的查询条件，类似
        queryParams.lgName = $("#search_lgName").val();  
        */
        //重新加载datagrid的数据  
        $("#menu_table").datagrid('reload');  
	}
	
	/*点击菜单新增按钮*/
	function menuAdd(){
		openWindow(contextPath+"/menu/toAddMenu.htm",'菜单新增');
	}
	/*点击菜单编辑按钮*/
	function menuEidt(){
		var sel=isMenuSelected();
		if(sel){
			openWindow(contextPath+"/menu/toEditMenu.htm?menuId="+sel.menuId,'菜单编辑');
		}
	}
	/*点击菜单明细按钮*/
	function menuDetail(){
		var sel=isMenuSelected();
		if(sel){
			openWindow(contextPath+"/menu/viewMenuDetail.htm?menuId="+sel.menuId,'菜单明细');
		}
	}
	/*点击菜单删除按钮*/
	function menuDelete(){
		var sel=isMenuSelected();
		if(sel){
		    $.messager.confirm('删除菜单', '您确认要删除该菜单吗?', function(r){
                if (r){
                	$.ajax({
        				url:contextPath+"/menu/deleteMenu.json?menuId="+sel.menuId,
        				dataType:"json",
        				success:function(data){
        					//清除所有选择
        					$('#menu_table').datagrid('clearSelections');
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
	/*是否有菜单记录被选中*/
	function isMenuSelected(){
		var sel=$.selected("menu_table");
		if(null == sel){
			$.ALERT('请选择菜单记录');
			return false;
		}
		return sel;
	}
	/*初始化菜单datagrid*/
	function initMenuDatagrid(_url){
		dataTable=$("#menu_table").datagrid({
			fit:true,
			title:'菜单信息',
			url:_url,
			iconCls:'icon-ok',
			nowrap: false,
			autoRowHeight: false,
			resizable:true,
			striped: true,
			collapsible:true,
			remoteSort: true,
			singleSelect:true,
			idField:'menuId',				
			collapsible:false,
			pagination:true,pageSize:10,
			rownumbers:true,
			columns:[[
				  	{field:'upMenuId',title:'upMenuId'},
				  	{field:'iconCls',title:'图标样式'},
				  	{field:'picUrl',title:'桌面图标'},
				  	{field:'menuPath',title:'menuPath'},
				  	{field:'level',title:'菜单层级'},
				  	{field:'name',title:'name'},
				  	{field:'url',title:'url'},
				  	{field:'deCode',title:'deCode'},
				  	{field:'menuSort',title:'menuSort'},
				  	{field:'sysMenu',title:'sysMenu'},
				  	{field:'openType',title:'IFRAME,PANEL'},
				  	{field:'available',title:'Y 可用，N 不可用'},
				  	{field:'delFlag',title:'Y 已删除，N 未删除'},
				  	{field:'createUser',title:'createUser'},
				  	{field:'updateUser',title:'updateUser'},
				  	{field:'createTime',title:'createTime'},
				  	{field:'updateTime',title:'updateTime'}
			]],
			toolbar:'#toolbar_menu',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	}