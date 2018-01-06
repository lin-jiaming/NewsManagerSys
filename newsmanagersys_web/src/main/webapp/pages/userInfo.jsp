<%--
  Created by IntelliJ IDEA.
  User: linjiaming
  Date: 2017/11/1
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/js/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/mynews.js"></script>
    <style>
        .pic{
            width:100px;
            height:100px;
            margin:20px auto;
            cursor: pointer;
        }
    </style>
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
        <li><a href="../index.jsp">首页</a><span class="divider">/</span></li>
        <li class="active">个人信息</li>
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
    <div style="margin-left: 10px;"id="userInfo">
    <p><img src="${pageContext.request.contextPath}/userimg/${userinfo[0].uimg}" width=100px" height="100px">
    </p>
    <p>真实姓名:${userinfo[0].urealname}</p>
    <p>性别:${userinfo[0].usex}</p>
    <p> 年龄:${userinfo[0].uage}</p>
    <p>邮箱:${userinfo[0].uemail}</p>
    <p>手机号码:${userinfo[0].utel}</p>
    <p>用户地址:${userinfo[0].uaddree}</p>
    <p>用户注册时间:${userinfo[0].ucreatetime}</p>
    <c:if test="${userinfo[0]==null}">
        <a href="${pageContext.request.contextPath}/pages/addUserInfo.jsp">完善信息</a>
    </c:if>
    <c:if test="${userinfo[0].urealname!=null}">
        <a href="${pageContext.request.contextPath}/userAction/toUpdateUserInfo?uno=${LoginUser.uno}">修改信息</a>
    </c:if>
    </div>
</div>
</body>
</html>
<script type="text/javascript">

</script>
