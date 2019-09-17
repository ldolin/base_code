<%--
  Created by IntelliJ IDEA.
  User: ldolin
  Date: 2019/8/23
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>yang</title>
</head>
<body>
    ${3 < 4}
    \${3 < 4}

    <h1>在域中存储数据</h1>
    <%
        request.setAttribute("name","zhangsan");
        session.setAttribute("msg","hello");
    %>
    <h3>获取值</h3>
    ${requestScope.name}
    ${sessionScope.msg}
    ${sessionScope.haha}
</body>
</html>
