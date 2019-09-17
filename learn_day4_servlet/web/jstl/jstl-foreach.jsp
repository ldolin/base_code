<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ldolin
  Date: 2019/8/23
  Time: 11:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl-foreach</title>
</head>
<body>
    <c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
        ${i}
        ${s.index} <%--index容器元素的索引--%>
        ${s.count}<br> <%--count循环次数--%>
    </c:forEach>
    <hr>
    <%
        List list = new ArrayList();
        list.add("aaaa");
        list.add("bbbb");
        list.add("ccc");

        request.setAttribute("list",list);
    %>
    <c:forEach items="${list}" var="str" varStatus="s">
        ${s.index}${s.count}${str}<br>

    </c:forEach>
</body>
</html>
