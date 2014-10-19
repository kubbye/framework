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
		$("#user_auth_post").on("click",function(){
			var sel=isUserSelected();
			if(sel){
				openWindow(contextPath+"/admin/user/postSelect.htm?userId="+sel.userId,'岗位授权');
			}
		});
		$("#user_auth_role").on("click",function(){
			var sel=isUserSelected();
			if(sel){
				openWindow(contextPath+"/admin/user/roleSelect.htm?userId="+sel.userId+"&orgId="+sel.orgId,'角色授权');
			}
		});
		$("#user_org_change").on("click",function(){
			userOrgChange();
		});
	});
	$(document).ready(function(){
		//初始化下拉列表
		$.post(contextPath+"/common/tree/post.json?orgId="+$("#search_orgId").val(),function(data){
			var options=[];
			options.push({text:"--全部--",value:""});
			$.each(data,function(i,item){
				options.push($.extend(item,{text:item.name,value:item.id}));
			});
			options.push({text:"--无岗--",value:"-1"});
			$("#search_postId").combobox('loadData',options);
		},'json');
		initUserDatagrid(contextPath+'/admin/user/getListData.json?orgId='+$("#search_orgId").val());
	});
	/*查询用户*/
	function userSearch(){
		var queryParams = $('#user_table').datagrid('options').queryParams;  
        /* 此处添加自己的查询条件，类似
        */
		queryParams.orgId = $("#search_orgId").val();  
		queryParams.lgName = $("#search_lgName").val();  
		queryParams.userName = $("#search_userName").val();  
		queryParams.postId = $("#search_postId").combobox('getValue');  
        //重新加载datagrid的数据  
        $("#user_table").datagrid('reload');  
	}
	
	/*点击用户新增按钮*/
	function userAdd(){
		openWindow(contextPath+"/admin/user/toAddUser.htm",'用户新增');
	}
	/*点击用户编辑按钮*/
	function userEidt(){
		var sel=isUserSelected();
		if(sel){
			openWindow(contextPath+"/admin/user/toEditUser.htm?userId="+sel.userId,'用户编辑');
		}
	}
	/*点击用户明细按钮*/
	function userDetail(){
		var sel=isUserSelected();
		if(sel){
			openWindow(contextPath+"/admin/user/viewUserDetail.htm?userId="+sel.userId,'用户明细');
		}
	}
	/*点击用户删除按钮*/
	function userDelete(){
		var sel=isUserSelected();
		if(sel){
			$.CONFIRM('删除用户', '您确认要删除该用户吗?',function(){
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
			});
		}
	}
	/*是否有用户记录被选中*/
	function isUserSelected(){
		var sel=$.selected("user_table");
		if(null == sel){
			$.ALERT('请选择用户记录');
			return false;
		}
		return sel;
	}
	/*初始化用户datagrid*/
	function initUserDatagrid(_url){
		dataTable=$("#user_table").datagrid({
			fit:true,
			title:'用户信息',
			url:_url,
			iconCls:'icon-ok',
			nowrap: true,
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
				  	{field:'lgName',title:'登录名称',resizable:false,width:'90',align:'center'},
				  	{field:'userName',title:'用户昵称',resizable:false},
				  	/*
				  	{field:'loginId',title:'用户登录号',resizable:false},
				  	{field:'defaultRoleName',title:'默认角色名称',resizable:false,width:'90'},
				  	*/
				  	{field:'userType',title:'用户类型',resizable:false,width:'90',formatter:function(data){return 'A'==data?'管理员':'应用用户';}},
				  	{field:'sex',title:'性别',resizable:false,width:'90',formatter:function(data){return '1'==data?'男':'女';}},
				  	{field:'defaultRoleName',title:'岗位',resizable:false,width:'90',formatter:getUserPost},
				  	{field:'avaliable',title:'状态',resizable:false,width:'90',formatter:function(data){return 'Y'==data?'有效':'无效';}},
				  	{field:'createTime',title:'创建时间',resizable:'false',width:'90'},
				  	{field:'updateTime',title:'更新时间',resizable:'false',width:'90'}
			]],
			toolbar:'#toolbar_user',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	}
	/*得到用户的岗位信息*/
	function getUserPost(item,row){
		var postName='';
		$.ajax({
			type : "post",
			url : contextPath+"/admin/user/getUserPost.json?userId="+row.userId,
			cache : false,
			async : false,
			dataType : "json",
			success : function(data) {
				if(data){
					postName=data.postName;
				}
			}
		});
		return postName;
	}
	/*调整用户机构*/
	function userOrgChange(){
		var sel=isUserSelected();
		if(sel){
			$.CONFIRM('机构调整','调整机构后用户的岗位和角色会全部失去，确认调整吗?',function(){
				/*$.ajax({
    				url:contextPath+"/admin/user/orgExchange.json?userId="+sel.userId+"&orgId="+sel.orgId,
    				dataType:"json",
    				success:function(data){
    					$.INFO(data.message,closeWindow);
    				},
    				error:function(data){
    					$.ERROR(ajaxError+JSON.stringify(data));
    				}
    			});*/
				openWindow(contextPath+"/admin/user/orgExchange.htm?userId="+sel.userId+"&orgId="+sel.orgId,'机构调整');
			});
		}
	}