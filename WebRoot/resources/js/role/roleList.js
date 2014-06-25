var dataTable;
	$(function(){
		$("#role_query").on("click",function(){
			roleSearch();
		});
		$("#role_add").on("click",function(){
			roleAdd();		
		});
		$("#role_edit").on("click",function(){
			roleEidt();
		});
		$("#role_detail").on("click",function(){
			roleDetail();
		});
		$("#role_delete").on("click",function(){
			roleDelete();
		});
	});
	$(document).ready(function(){
		initRoleDatagrid(contextPath+'/admin/role/getListData.json');
	});
	/*查询角色*/
	function roleSearch(){
		var queryParams = $('#role_table').datagrid('options').queryParams;  
        /* 此处添加自己的查询条件，类似
        queryParams.lgName = $("#search_lgName").val();  
        */
        //重新加载datagrid的数据  
        $("#role_table").datagrid('reload');  
	}
	
	/*点击角色新增按钮*/
	function roleAdd(){
		openWindow(contextPath+"/admin/role/toAddRole.htm",'角色新增');
	}
	/*点击角色编辑按钮*/
	function roleEidt(){
		var sel=isRoleSelected();
		if(sel){
			openWindow(contextPath+"/admin/role/toEditRole.htm?roleId="+sel.roleId,'角色编辑');
		}
	}
	/*点击角色明细按钮*/
	function roleDetail(){
		var sel=isRoleSelected();
		if(sel){
			openWindow(contextPath+"/admin/role/viewRoleDetail.htm?roleId="+sel.roleId,'角色明细');
		}
	}
	/*点击角色删除按钮*/
	function roleDelete(){
		var sel=isRoleSelected();
		if(sel){
		    $.messager.confirm('删除角色', '您确认要删除该角色吗?', function(r){
                if (r){
                	$.ajax({
        				url:contextPath+"/admin/role/deleteRole.json?roleId="+sel.roleId,
        				dataType:"json",
        				success:function(data){
        					//清除所有选择
        					$('#role_table').datagrid('clearSelections');
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
	/*是否有角色记录被选中*/
	function isRoleSelected(){
		var sel=$.selected("role_table");
		if(null == sel){
			$.ALERT('请选择角色记录');
			return false;
		}
		return sel;
	}
	/*初始化角色datagrid*/
	function initRoleDatagrid(_url){
		dataTable=$("#role_table").datagrid({
			fit:true,
			title:'角色信息',
			url:_url,
			iconCls:'icon-ok',
			nowrap: false,
			autoRowHeight: false,
			resizable:true,
			striped: true,
			collapsible:true,
			remoteSort: true,
			singleSelect:true,
			idField:'roleId',				
			collapsible:false,
			pagination:true,pageSize:10,
			rownumbers:true,
			columns:[[
				  	{field:'roleName',title:'角色名称'},
				  	{field:'roleType',title:'类型：R 角色，P 部门岗位'},
				  	{field:'roleScope',title:'公共角色：D 默认角色,C 通用角色,P 部门私有角色，S 系统级角色'},
				  	{field:'orgId',title:'机构ID'},
				  	{field:'memo',title:'备注'},
				  	{field:'avaliable',title:'Y 可用，N 不可用'},
				  	{field:'createUser',title:'创建人'},
				  	{field:'updateUser',title:'更新人'},
				  	{field:'createTime',title:'创建时间'},
				  	{field:'updateTime',title:'更新时间'},
				  	{field:'deleteMark',title:'删除标记：0，未删除；1，已删除'}
			]],
			toolbar:'#toolbar_role',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	}