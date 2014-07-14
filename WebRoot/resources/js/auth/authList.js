var dataTable;
	$(function(){
		$("#auth_query").on("click",function(){
			authSearch();
		});
		$("#auth_add").on("click",function(){
			authAdd();		
		});
		$("#auth_edit").on("click",function(){
			authEidt();
		});
		$("#auth_detail").on("click",function(){
			authDetail();
		});
		$("#auth_delete").on("click",function(){
			authDelete();
		});
	});
	$(document).ready(function(){
		initAuthDatagrid(contextPath+'/admin/auth/getListData.json');
	});
	/*查询授权*/
	function authSearch(){
		var queryParams = $('#auth_table').datagrid('options').queryParams;  
        /* 此处添加自己的查询条件，类似
        queryParams.lgName = $("#search_lgName").val();  
        */
        //重新加载datagrid的数据  
        $("#auth_table").datagrid('reload');  
	}
	
	/*点击授权新增按钮*/
	function authAdd(){
		openWindow(contextPath+"/admin/auth/toAddAuth.htm",'授权新增');
	}
	/*点击授权编辑按钮*/
	function authEidt(){
		var sel=isAuthSelected();
		if(sel){
			openWindow(contextPath+"/admin/auth/toEditAuth.htm?id="+sel.id,'授权编辑');
		}
	}
	/*点击授权明细按钮*/
	function authDetail(){
		var sel=isAuthSelected();
		if(sel){
			openWindow(contextPath+"/admin/auth/viewAuthDetail.htm?id="+sel.id,'授权明细');
		}
	}
	/*点击授权删除按钮*/
	function authDelete(){
		var sel=isAuthSelected();
		if(sel){
		    $.messager.confirm('删除授权', '您确认要删除该授权吗?', function(r){
                if (r){
                	$.ajax({
        				url:contextPath+"/admin/auth/deleteAuth.json?id="+sel.id,
        				dataType:"json",
        				success:function(data){
        					//清除所有选择
        					$('#auth_table').datagrid('clearSelections');
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
	/*是否有授权记录被选中*/
	function isAuthSelected(){
		var sel=$.selected("auth_table");
		if(null == sel){
			$.ALERT('请选择授权记录');
			return false;
		}
		return sel;
	}
	/*初始化授权datagrid*/
	function initAuthDatagrid(_url){
		dataTable=$("#auth_table").datagrid({
			fit:true,
			title:'授权信息',
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
				  	{field:'resourceId',title:'资源ID',align:'center',resizable:false,width:'100'},
				  	{field:'authId',title:'授权对象ID',align:'center',resizable:false,width:'100'},
				  	{field:'authType',title:'授权类型：1，岗位；2，角色',align:'center',resizable:false,width:'100'},
				  	{field:'restype',title:'权限类型：1，菜单；2，功能code',align:'center',resizable:false,width:'100'},
				  	{field:'createUser',title:'创建人',align:'center',resizable:false,width:'100'},
				  	{field:'updateUser',title:'更新人',align:'center',resizable:false,width:'100'},
				  	{field:'createTime',title:'创建时间',align:'center',resizable:false,width:'100'},
				  	{field:'updateTime',title:'更新时间',align:'center',resizable:false,width:'100'},
				  	{field:'deleteMark',title:'删除标记：0，未删除；1，已删除',align:'center',resizable:false,width:'100'}
			]],
			toolbar:'#toolbar_auth',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	}