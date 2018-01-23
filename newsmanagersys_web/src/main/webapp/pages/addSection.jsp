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
    <title>添加版块</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/js/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/mynews.js"></script>
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
        <li><a href="../main.jsp">首页</a> <span class="divider">/</span></li>
        <li class="active">添加版块</li>
    </ul>
    <c:if test="${param.res==1}">
        <div class="alert alert-success" id="success">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>添加成功
        </div>
    </c:if>
    <c:if test="${param.res==-1}">
        <div class="alert alert-danger" id="danger">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>
            添加失败</div>
    </c:if>
    <div class="row-fluid">
        <div class="dialog">
            <div class="block">
                <p class="block-heading">添加版块</p>
                <div class="block-body">
                    <form method="post" action="${pageContext.request.contextPath}/sectionAction/doAddSection" onsubmit="return addSection()">
                        <label>版块名</label>
                        <input type="text" name="sname" id="sname" class="span12">
                        <input type="button" class="btn btn-primary pull-right" value="添加" >
                        <div class="clearfix"></div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function addSection(){
        var sname=document.forms[0].sname;
        if(sname.value.length==0){
            alert("版块名不能为空");
            name.focus();
            return false;
        }
        return true;
    }

</script>
