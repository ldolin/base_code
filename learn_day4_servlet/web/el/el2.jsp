<%@ page import="club.ldolin.web.domain.User" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: ldolin
  Date: 2019/8/23
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el获取数据</title>
</head>
<body>
    <%
        User user = new User();
        user.setName("张三");
        user.setAge(12);
        user.setBirthday(new Date());

        request.setAttribute("u","user");

        List list = new ArrayList();
        list.add("aaa");
        list.add("bbb");
        list.add(user);

        request.setAttribute("list",list);

        Map map = new HashMap();
        map.put("sname","杨");
        map.put("gender","男");
        map.put("user",user);

        request.setAttribute("map",map);
    %>

    <%--el获取对象中的值--地址值--%>
    ${requestScope.u}<br>
    ${requestScope.u.name}<br>
    ${requestScope.u.age}<br>
    ${requestScope.u.birthday}<br>
    ${requestScope.u.birthday.month}<br>

    ${requestScope.u.birStr}<br>

    <%--el获取list值--%>
    ${requestScope.list}<br>
    ${requestScope.list[0]}<br>
    ${requestScope.list[1]}<br>
    ${requestScope.list[10]}<br>

    ${requestScope.list[2].name}<br>
    ${list[2].age}<br>
    ${list[2].birthday}<br>
    ${empty list}<br>
    ${not empty list}<br>

    <%--el获取map值--%>
    ${map.gender}<br>
    ${map["gender"]}<br>
    ${map.user.name}<br>
    ${not empty map}<br>

    <%--隐式对象--%>
    ${pageContext.request}<br>
    <%--隐式对象-在jsp页面动态获取虚拟目录--%>
    ${pageContext.request.contextPath}<br>
</body>
</html>
