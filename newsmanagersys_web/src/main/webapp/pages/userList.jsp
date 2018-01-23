<%--
  Created by IntelliJ IDEA.
  User: linjiaming
  Date: 2017/11/1
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/js/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/mynews.js"></script>
</head>
<body>
<div class="navbar">
    <%@include file="/navbar.jsp"%>
</div>
<!--左边功能列表-->
<div class="sidebar-nav">
    <%@include file="/sidebar-nav.jsp"%>
</div>
<!--右边操作-->
<div class="content" id="content">
    <ul class="breadcrumb">
        <li><a href="../main.jsp">首页</a> <span class="divider">/</span></li>
        <li class="active">用户管理</li>
    </ul>
    <c:if test="${param.res==1}">
        <div class="alert alert-success" id="success">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>操作成功
        </div>
    </c:if>
    <c:if test="${param.res==-1}">
        <div class="alert alert-danger" id="danger">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>
            操作失败</div>
    </c:if>
        <table class="table table-striped">
            <thead>
            <tr>
                <td>编号</td>
                <td>用户名</td>
                <td>密码</td>
                <td>用户状态</td>
                <td>用户角色</td>
                <td>操作</td>
            </tr>
            <c:forEach var="user" items="${userList}" varStatus="ids">
                <tr>
                    <td>${ids.count}</td>
                    <td>${user[0].uname}</td>
                    <td>${user[0].upwd}</td>
                    <td>${user[0].ustate==0?"已锁定":"未锁定"}</td>
                    <td>${user[1].rname}</td>
                    <td>
                        <c:if test="${user[0].ustate==0}">
                            <a href="${pageContext.request.contextPath}/userAction/lockDownUser?uno=${user[0].uno}">解锁</a>
                        </c:if>
                        <c:if test="${user[0].ustate==1}">
                            <a href="${pageContext.request.contextPath}/userAction/lockUpUser?uno=${user[0].uno}">锁定</a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
            </thead>
        </table>
</div>


</body>
</html>
<script type="text/javascript">

</script>
