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
    <meta charset="utf-8">
    <title>修改密码</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/js/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/mynews.js"></script>
    <style>

    </style>
    <!--页面样式-->
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
        <li><a href="../index.jsp">首页</a> <span class="divider">/</span></li>
        <li class="active">修改密码</li>
    </ul>
    <c:if test="${param.res==1}">
        <div class="alert alert-success" id="success">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>修改成功
        </div>
    </c:if>
    <c:if test="${param.res==-1}">
        <div class="alert alert-danger" id="danger">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>
            修改失败</div>
    </c:if>
    <div class="row-fluid">
        <div class="dialog">
            <div class="block1">
                <p class="block-heading">修改密码</p>
                <div class="block-body">
                    <form method="post" id="addFrm" action="${pageContext.request.contextPath}/userAction/doUpdateUserPwd" onsubmit="return updateUserPwd()">
                        <input type="hidden" name="uno" value="${LoginUser.uno}">
                        <label>旧密码</label>
                        <input type="password" name="oldPwd" id="oldPwd" class="span12" placeholder="请输入旧密码">
                        <label>新密码</label>
                        <input type="password" name="upwd" class="span12" placeholder="请输入密码">
                        <label>重复密码</label>
                        <input type="password" name="newPwd" class="span12"  placeholder="请重复输入密码">
                        <input type="submit" class="btn btn-primary pull-right" value="修改" >
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">

</script>
