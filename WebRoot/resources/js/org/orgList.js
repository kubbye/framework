var dataTable;
	$(function(){
		$("#org_query").on("click",function(){
			orgSearch();
		});
		$("#org_add").on("click",function(){
			orgAdd();		
		});
		$("#org_edit").on("click",function(){
			orgEidt();
		});
		$("#org_detail").on("click",function(){
			orgDetail();
		});
		$("#org_delete").on("click",function(){
			orgDelete();
		});
		$(document).on("keypress",function(event){
			if(event){
	   			if(event.keyCode==13 || event.keyCode==0){
	   			    setTimeout(orgSearch,300); 
	  		 	}
	  		}
		});
	});
	$(document).ready(function(){
		initOrgDatagrid(contextPath+'/admin/org/getListData.json?parentId='+$("#search_parentId").val());
	});
	/*查询机构*/
	function orgSearch(){
		var queryParams = $('#org_table').datagrid('options').queryParams;  
        /* 此处添加自己的查询条件，类似
        queryParams.lgName = $("#search_lgName").val();  
        */
		 queryParams.parentId = $("#search_parentId").val();  
		 queryParams.orgCode = $("#search_orgCode").val();
		 queryParams.orgFullName = $("#search_orgFullName").val(); 
		 queryParams.avaliable = $("#search_avaliable").combobox('getValue'); 
        //重新加载datagrid的数据  
        $("#org_table").datagrid('reload');  
	}
	
	/*点击机构新增按钮*/
	function orgAdd(){
		openWindow(contextPath+"/admin/org/toAddOrg.htm",'机构新增');
	}
	/*点击机构编辑按钮*/
	function orgEidt(){
		var sel=isOrgSelected();
		if(sel){
			openWindow(contextPath+"/admin/org/toEditOrg.htm?orgId="+sel.orgId,'机构编辑');
		}
	}
	/*点击机构明细按钮*/
	function orgDetail(){
		var sel=isOrgSelected();
		if(sel){
			openWindow(contextPath+"/admin/org/viewOrgDetail.htm?orgId="+sel.orgId,'机构明细');
		}
	}
	/*点击机构删除按钮*/
	function orgDelete(){
		var sel=isOrgSelected();
		if(sel){
			if(window.parent.isParent(sel.orgId)){
				$.ALERT("请先删除子机构才能删除父机构");
				return;
			}
		    $.messager.confirm('删除机构', '您确认要删除该机构吗，与机构相关的角色、岗位、用户都将被删除？', function(r){
                if (r){
                	$.ajax({
        				url:contextPath+"/admin/org/deleteOrg.json?orgId="+sel.orgId,
        				dataType:"json",
        				success:function(data){
        					parent.removeTreeNode(sel.orgId);
        					//清除所有选择
        					$('#org_table').datagrid('clearSelections');
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
	/*是否有机构记录被选中*/
	function isOrgSelected(){
		var sel=$.selected("org_table");
		if(null == sel){
			$.ALERT('请选择机构记录');
			return false;
		}
		return sel;
	}
	/*初始化机构datagrid*/
	function initOrgDatagrid(_url){
		dataTable=$("#org_table").datagrid({
			fit:true,
			title:'机构信息',
			url:_url,
			iconCls:'icon-ok',
			nowrap: true,
			autoRowHeight: false,
			resizable:true,
			striped: true,
			collapsible:true,
			remoteSort: true,
			singleSelect:true,
			idField:'orgId',				
			collapsible:false,
			pagination:true,pageSize:10,
			rownumbers:true,
			columns:[[
				  	{field:'orgCode',title:'机构代码',align:'center',resizable:false,width:'80'},
				  	{field:'orgSimpleName',title:'简称',align:'center',resizable:false,width:'80'},
				  	{field:'orgFullName',title:'机构全称',align:'center',resizable:false,width:'80'},
				  	/*
				  	{field:'parentId',title:'上级机构ID',align:'center',resizable:false,width:'80'},
				  	{field:'orgPath',title:'机构路径',align:'center',resizable:false,width:'80'},
				  	{field:'orgAddress1',title:'机构地址1',align:'center',resizable:false,width:'80'},
				  	{field:'orgAddress2',title:'机构地址2',align:'center',resizable:false,width:'80'},
				  	*/
				  	{field:'orgTel1',title:'机构电话',align:'center',resizable:false,width:'80'},
				  	/*
				  	{field:'orgTel2',title:'机构电话2',align:'center',resizable:false,width:'34'},
				  	{field:'orgRegDate',title:'机构注册日期',align:'center',resizable:false,width:'34'},
				  	{field:'orgType',title:'类型:',align:'center',resizable:false,width:'34'},
				  	{field:'orgFax',title:'机构传真',align:'center',resizable:false,width:'34'},
				  	{field:'orgPostal',title:'机构邮编',align:'center',resizable:false,width:'34'},
				  	{field:'orgLegal',title:'法人',align:'center',resizable:false,width:'34'},
				  	{field:'orgTaxNo',title:'税号',align:'center',resizable:false,width:'34'},
				  	{field:'orgRegNo',title:'注册登记号',align:'center',resizable:false,width:'34'},
				  	{field:'orgBelongDist',title:'所在地区',align:'center',resizable:false,width:'34'},
				  	{field:'webUrl',title:'主页',align:'center',resizable:false,width:'34'},
				  	{field:'weichat',title:'微信号',align:'center',resizable:false,width:'34'},
				  	{field:'weiblog',title:'微博',align:'center',resizable:false,width:'34'},
				  	*/
				  	{field:'memo',title:'备注',align:'center',resizable:false,width:'80'},
				  	{field:'orgState',title:'机构状态',align:'center',
				  		resizable:false,width:'80',formatter:function(data){return "Y"==data?'营业中':'停业';}},
				  	{field:'avaliable',title:'状态',align:'center',resizable:false,width:'80',formatter:function(data){return "Y"==data?'有效':'无效';}}
			]],
			toolbar:'#toolbar_org',
			onBeforeLoad:function(data){
			},
			onLoadError:function(data){
				alert(JSON.stringify(data));
			}
		});
	}