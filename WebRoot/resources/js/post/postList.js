var dataTable;
	$(function(){
		$("#post_query").on("click",function(){
			postSearch();
		});
		$("#post_add").on("click",function(){
			postAdd();		
		});
		$("#post_edit").on("click",function(){
			postEidt();
		});
		$("#post_detail").on("click",function(){
			postDetail();
		});
		$("#post_delete").on("click",function(){
			postDelete();
		});
		$("#post_users").on("click",function(){
			viewAssignUsers();
		});
		$(document).on("keypress",function(event){
			if(event){
	   			if(event.keyCode==13 || event.keyCode==0){
	   			    setTimeout(postSearch,300); 
	  		 	}
	  		}
		});
	});
	$(document).ready(function(){
		initPostDatagrid(contextPath+'/admin/post/getListData.json?orgId='+$("#search_orgId").val());
	});
	/*查询岗位*/
	function postSearch(){
		var queryParams = $('#post_table').datagrid('options').queryParams;  
        /* 此处添加自己的查询条件，类似
        queryParams.lgName = $("#search_lgName").val();  
        */
		queryParams.orgId = $("#search_orgId").val();
		queryParams.postName=$("#search_postName").val();
		queryParams.avaliable=$("#search_avaliable").combobox('getValue');
        //重新加载datagrid的数据  
        $("#post_table").datagrid('reload');  
	}
	
	/*点击岗位新增按钮*/
	function postAdd(){
		openWindow(contextPath+"/admin/post/toAddPost.htm",'岗位新增');
	}
	/*点击岗位编辑按钮*/
	function postEidt(){
		var sel=isPostSelected();
		if(sel){
			openWindow(contextPath+"/admin/post/toEditPost.htm?id="+sel.id,'岗位编辑');
		}
	}
	/*点击岗位明细按钮*/
	function postDetail(){
		var sel=isPostSelected();
		if(sel){
			openWindow(contextPath+"/admin/post/viewPostDetail.htm?id="+sel.id,'岗位明细');
		}
	}
	/*点击岗位删除按钮*/
	function postDelete(){
		var sel=isPostSelected();
		if(sel){
		    $.messager.confirm('删除岗位', '您确认要删除该岗位吗?', function(r){
                if (r){
                	$.ajax({
        				url:contextPath+"/admin/post/deletePost.json?id="+sel.id,
        				dataType:"json",
        				success:function(data){
        					//清除所有选择
        					$('#post_table').datagrid('clearSelections');
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
	/*查看岗位的已分配人员*/
	function viewAssignUsers(){
		var sel=isPostSelected();
		if(sel){
			openWindow(contextPath+"/admin/post/viewAssignUsers.htm?id="+sel.id+"&orgId="+sel.orgId,'已分配用户');
		}
	}
	/*是否有岗位记录被选中*/
	function isPostSelected(){
		var sel=$.selected("post_table");
		if(null == sel){
			$.ALERT('请选择岗位记录');
			return false;
		}
		return sel;
	}
	/*初始化岗位datagrid*/
	function initPostDatagrid(_url){
		dataTable=$("#post_table").datagrid({
			fit:true,
			title:'岗位信息',
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
			        /*
				  	{field:'orgId',title:'机构ID'},
				  	{field:'postPath',title:'岗位路径'},
				  	*/
			        {field:'postName',title:'岗位名称'},
			        {field:'parentPost',title:'上级岗位',formatter:function(data){return (null==data)?'':data.postName;}},
				  	{field:'postDesc',title:'岗位描述'},
				  	{field:'avaliable',title:'状态',formatter:function(data){return 'Y'==data?'有效':'无效';}},
				  	{field:'createTime',title:'创建时间'},
				  	{field:'updateTime',title:'更新时间'},
			]],
			toolbar:'#toolbar_post',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	}