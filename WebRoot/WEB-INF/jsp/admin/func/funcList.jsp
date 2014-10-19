<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/common/taglibs.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
<script type="text/javascript" src="${resRoot}/js/func/funcList.js"></script>
</head>
<body class="easyui-layout">
<div data-options="region:'north',split:false,border:false" style="overflow:hidden;padding:5px;">
    <fieldset>
    
    <legend>查询条件</legend>
    	<table>
    		<tr>
		    		<td>功能名称：</td>
    				<td><input id="search_funcName" name="funcName" type="text"  class="textbox"/></td>
		    		<td>代码，唯一：</td>
    				<td><input id="search_funcCode" name="funcCode" type="text"  class="textbox"/></td>
		    		<td>路径：</td>
    				<td><input id="search_url" name="url" type="text"  class="textbox"/></td>
    			
    			<td><a id="func_query" href="javascript:void(0)" class="easyui-linkbutton">查 询</a></td>
    		</tr>
    	</table>
          
    </fieldset>
    
    </div>
    
 
    <div data-options="region:'center',border:'false'"  style="padding-top:0px;">
    
	  <table id="func_table">
	  </table>
	</div>
	<div id="toolbar_func" style="padding:3px;"> 
	  <a href="javascript:void(-1);" id="func_add" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true">新增</a> 
	  <a href="javascript:void(-1);" id="func_edit"  class="easyui-linkbutton" data-options="iconCls:'icon-edit',plain:true">修改</a>
	  <a href="javascript:void(-1);" id="func_detail" class="easyui-linkbutton" data-options="iconCls:'icon-detail',plain:true">明细</a>
	  <a href="javascript:void(-1);" id="func_delete" class="easyui-linkbutton" data-options="iconCls:'icon-remove',plain:true">删除</a> 
	</div>
</body>
</html>