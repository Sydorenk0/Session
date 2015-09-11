<%--
  Created by IntelliJ IDEA.
  User: Alex
  Date: 09.09.2015
  Time: 12:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String val = (String) session.getAttribute("userName");
%>
<html>
<head>
    <title></title>
</head>
<body>
PAGE 2 <font color="green"><%= val %>
</font><br>
<a href=${pageContext.servletContext.contextPath}"index.jsp">index</a>
</body>
</html>
