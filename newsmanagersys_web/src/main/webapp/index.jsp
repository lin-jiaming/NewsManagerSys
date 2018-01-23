<%--
  Created by IntelliJ IDEA.
  User: linjiaming
  Date: 2018/1/23
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <%--转发到一个方法--%>
        <%
        request.getRequestDispatcher("/newsAction/doFindNewsList").forward(request,response);
        %>
</body>
</html>
