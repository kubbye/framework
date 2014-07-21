var dataTable;
$(document).ready(function(){
	initUserDatagrid(contextPath+'/admin/user/getListData.json?orgId='+$("#assigned_orgId").val());
});
/* 初始化用户datagrid */
function initUserDatagrid(_url) {
	dataTable = $("#user_table").datagrid({
		fit : false,
		url : _url,
		iconCls : 'icon-ok',
		nowrap : true,
		autoRowHeight : false,
		resizable : true,
		striped : true,
		collapsible : true,
		remoteSort : true,
		singleSelect : true,
		idField : 'userId',
		collapsible : false,
		pagination : false,
		pageSize : 100,
		rownumbers : true,
		columns : [ [ {
			field : 'lgName',
			title : '登录名称',
			resizable : false,
			width : '90',
			align : 'center'
		}, {
			field : 'userName',
			title : '用户昵称',
			resizable : false
		},
		/*
		 * {field:'loginId',title:'用户登录号',resizable:false},
		 * {field:'defaultRoleName',title:'默认角色名称',resizable:false,width:'90'},
		 */
		{
			field : 'userType',
			title : '用户类型',
			resizable : false,
			width : '90',
			formatter : function(data) {
				return 'A' == data ? '管理员' : '应用用户';
			}
		}, {
			field : 'sex',
			title : '性别',
			resizable : false,
			width : '90',
			formatter : function(data) {
				return '1' == data ? '男' : '女';
			}
		}, {
			field : 'avaliable',
			title : '状态',
			resizable : false,
			width : '90',
			formatter : function(data) {
				return 'Y' == data ? '有效' : '无效';
			}
		}, {
			field : 'createTime',
			title : '创建时间',
			resizable : 'false',
			width : '90'
		}, {
			field : 'updateTime',
			title : '更新时间',
			resizable : 'false',
			width : '90'
		}] ],
		onBeforeLoad : function(data) {
		},
		onLoadError : function(data) {
			alert(JSON.stringify(data));
		}
	});
}
