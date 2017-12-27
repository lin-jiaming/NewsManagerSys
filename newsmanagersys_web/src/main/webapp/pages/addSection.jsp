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
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
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
        <li class="active">添加版块</li>
    </ul>
    <c:if test="${param.res==1}">
        <div class="alert alert-success">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>
            添加成功
        </div>
    </c:if>
    <c:if test="${param.res==-1}">
        <div class="alert alert-danger">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>
            添加失败
        </div>
    </c:if>
    <div class="row-fluid">
        <div class="dialog">
            <div class="block">
                <p class="block-heading">添加版块</p>
                <div class="block-body">
                    <form method="post" action="${pageContext.request.contextPath}/sectionAction/doAddSection">
                        <label>版块名</label>
                        <input type="text" name="sname" class="span12">
                        <input type="submit" class="btn btn-primary pull-right" value="添加" >
                        <div class="clearfix"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>