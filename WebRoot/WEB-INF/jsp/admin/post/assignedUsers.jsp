<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/jsp/common/taglibs.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
<jsp:include page="/WEB-INF/jsp/common/style.jsp"></jsp:include>
</head>
<body>
	   <div data-options="region:'north',border:'false'"  style="padding:5px;">
   <input type="hidden" id="assigned_postId" name="postId" value="${postId }">
	<input type="hidden" id="assigned_orgId" name="orgId" value="${orgId }">
	</div>
    <div data-options="region:'center',border:'false'"  style="padding:5px;">
   
	  <table id="user_table">
	  </table>
	</div>
<script type="text/javascript" src="${resRoot}/js/post/assignedUsers.js"></script>
</body>
</html>