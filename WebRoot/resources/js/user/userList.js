var dataTable;
	$(function(){
		$("#user_query").on("click",function(){
			userSearch();
		});
		$("#user_add").on("click",function(){
			userAdd();		
		});
		$("#user_edit").on("click",function(){
			userEidt();
		});
		$("#user_detail").on("click",function(){
			userDetail();
		});
		$("#user_delete").on("click",function(){
			userDelete();
		});
	});
	$(document).ready(function(){
		initUserDatagrid(contextPath+'/admin/user/getListData.json');
	});
	function userSearch(){
		var queryParams = $('#user_table').datagrid('options').queryParams;  
        queryParams.lgName = $("#search_lgName").val();  
        //重新加载datagrid的数据  
        $("#user_table").datagrid('reload');  
	}
	function userAdd(){
		openWindow(contextPath+"/admin/user/toAddUser.htm",'用户新增');
	}
	function userEidt(){
		var sel=isUserSelected();
		if(sel){
			openWindow(contextPath+"/admin/user/toEditUser.htm?userId="+sel.userId,'用户编辑');
		}
	}
	function userDetail(){
		var sel=isUserSelected();
		if(sel){
			openWindow(contextPath+"/admin/user/viewUserDetail.htm?userId="+sel.userId,'用户明细');
		}
	}
	function userDelete(){
		var sel=isUserSelected();
		if(sel){
		    $.messager.confirm('删除用户', '您确认要删除该用户吗?', function(r){
                if (r){
                	$.ajax({
        				url:contextPath+"/admin/user/deleteUser.json?userId="+sel.userId,
        				dataType:"json",
        				success:function(data){
        					//清除所有选择
        					$('#user_table').datagrid('clearSelections');
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
	function isUserSelected(){
		var sel=$.selected("user_table");
		if(null == sel){
			$.ALERT('请选择用户记录');
			return false;
		}
		return sel;
	}

	function initUserDatagrid(_url){
		dataTable=$("#user_table").datagrid({
			fit:true,
			title:'用户信息',
			url:_url,
			iconCls:'icon-ok',
			nowrap: false,
			autoRowHeight: false,
			resizable:true,
			striped: true,
			collapsible:true,
			remoteSort: true,
			singleSelect:true,
			idField:'userId',				
			collapsible:false,
			pagination:true,pageSize:10,
			rownumbers:true,
			columns:[[
				{field:'orgId',title:'机构'},
				{field:'lgName',title:'登录名称'},
				{field:'userName',title:'用户名称'},
				{field:'available',title:'启用/禁用'}
			]],
			toolbar:'#toolbar_user',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	}