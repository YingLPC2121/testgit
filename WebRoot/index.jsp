<%@ page language="java" import="java.util.*,com.beans.*,com.dao.*,com.dao.impl.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
  <%
  	 TestDao testDao = new TestDaoImpl();
  	 List<UserInfo> userList = testDao.queryAll();
  	 request.setAttribute("userList", userList);
   %>
  
    <table border="1" width="80%">
   	<tr>
   		<th>序号</th><th>姓名</th><th>操作</th>
   	</tr>
   	<c:forEach items="${userList}" var="user" varStatus="s">
   		<tr>
   			<td>${s.count }</td>
   			<td>${user.userName }</td>
   			<td>
   				<a href="query.jsp?id=${user.id }&userName=${user.userName }versionNo=${user.versionNo}">修改</a>
   			</td>
   		</tr>
   	</c:forEach>
   </table>
  </body>
</html>
