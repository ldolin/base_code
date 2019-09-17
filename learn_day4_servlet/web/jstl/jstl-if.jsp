<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ldolin
  Date: 2019/8/23
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl-if</title>
</head>
<body>
    <%--test必须属性，接收bool表达式，为true显示if标签体内容，false不显示
    一般test属性结合el表达式一起用
    注意：没有else语句
    --%>
    <c:if test="true">
        <h1>我是真...</h1>
    </c:if>
    <br>

    <%
        List list = new ArrayList();
        list.add("aaa");

        request.setAttribute("list" , list);
        request.setAttribute("number" , 3);
    %>
    <c:if test="${not empty list}">
        遍历集合...
    </c:if>
    <c:if test="${number%2!=0}">
        ${number}是奇数...
    </c:if>
    <c:if test="${number%2=0}">
        ${number}是偶数...
    </c:if>

</body>
</html>
