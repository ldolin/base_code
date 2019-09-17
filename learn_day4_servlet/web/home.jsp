<%--
  Created by IntelliJ IDEA.
  User: ldolin
  Date: 2019/8/23
  Time: 9:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="top.jsp"%>
<html>
<head>
    <title>yang</title>
</head>
<body>
    <h3>主界面</h3>
    <%
        pageContext.setAttribute("msg","hello");
    %>
    <%= pageContext.getAttribute("msg") %>
</body>
</html>
