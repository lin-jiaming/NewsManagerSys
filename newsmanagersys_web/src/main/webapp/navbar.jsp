<%--
  Created by IntelliJ IDEA.
  User: linjiaming
  Date: 2017/11/15
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>navber</title>
</head>
<body>
<div class="navbar-inner">
    <ul class="nav pull-right">
        <li id="fat-menu" class="dropdown">
            <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                <i class="icon-user"></i>
                <c:if test="${LoginUser.ustate==1}">
                    ${LoginUser.uname}
                </c:if>
                <c:if test="${LoginUser==null}">
                    <c:redirect url="${pageContext.request.contextPath}/pages/userlogin.jsp"/>
                </c:if>
                <i class="icon-caret-down"></i>
            </a>

            <ul class="dropdown-menu">
                <li><a tabindex="-1" href="${pageContext.request.contextPath}/userAction/getUserInfoById?uno=${LoginUser.uno}">个人信息</a></li>
                <li class="divider"></li>
                <li class="divider visible-phone"></li>
                <li><a href="${pageContext.request.contextPath}/pages/userlogin.jsp">退出</a></li>
            </ul>
        </li>
    </ul>
    <a class="brand" href="${pageContext.request.contextPath}/index.jsp"><span class="second">新闻管理系统</span></a>
</div>
</body>
</html>
