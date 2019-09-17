<%--
  Created by IntelliJ IDEA.
  User: ldolin
  Date: 2019/8/19
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  errorPage="500.jsp" language="java"  buffer="16kb" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--<% response.getWriter().write("response");%>--%>  //尽量不用，用out输出
  <%
    System.out.println("hello jsp1"); //在service方法中
    int i=5;
    String contextPath = request.getContextPath();
    out.print(contextPath);
  %>

  <%!
    int i=3; //定义成员，变量加方法，静态代码块，较少使用，在jsp或servlet中尽量不定义成员，可能引发线程安全问题
  %>

  <%=
    "hello" //定义输出语句

  %>

  <c:catch>1</c:catch>

  </body>
</html>
