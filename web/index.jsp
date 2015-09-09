<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
Выбрать страницу<br>
  <table>
    <tr>
      <th><a href =${pageContext.servletContext.contextPath}"page1.jsp?url=/page1.jsp">Page1"CAT"</a></th>
    </tr>
      <tr>
    <th><a href =${pageContext.servletContext.contextPath}"page2.jsp">Page2"DOG"</a></th>
      </tr>
      <tr>
          <th><a href =${pageContext.servletContext.contextPath}"registration.jsp">reg</a></th>
      </tr>

  </table>
          c:redirect url="registration.jsp"/>
  </body>
</html>
