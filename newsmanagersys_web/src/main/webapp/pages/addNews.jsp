<%--
  Created by IntelliJ IDEA.
  User: linjiaming
  Date: 2017/11/1
  Time: 08:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>添加新闻</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/js/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/mynews.js"></script>
    <style>
        .pic{
            width: 150px;
            height:150px;
            margin-bottom: 5px;
            cursor: pointer;
        }
        #addNews{
            margin: 30px auto;
            width: 500px;
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
        <li><a href="../main.jsp">首页</a><span class="divider">/</span></li>
        <li class="active">添加新闻</li>
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
    <div id="addNews">
        <form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/newsAction/doAddNews">
            标题:
            <input class="span3" name="ntitle"> <br>
            版快:
            <select class="span1" style="margin-top: 5px;" name="section.sno"> <br>
                <option value="">请选择</option>
                <c:forEach var="sec" items="${sectionList}" varStatus="ids">
                    <option value="${sec.sno}">${sec.sname}</option>
                </c:forEach>
            </select> <br>
            正文:
            <textarea class="span5" rows="8" name="ncontent"></textarea> <br>
            图片:
            <img src="${pageContext.request.contextPath}/images/upload.png" class="pic" >
            <input type="file" class="nimg" name="sfile"> <br>
            日期:
            <input type="date" class="span2" name="nintime"> <br>
            作者:
            <input class="span2" name="nauthor"> <br>
            <hr>
            <input type="submit" style="margin-top: 5px;float: right" value="添加">
        </form>
    </div>
</div>
</body>
</html>
<script type="text/javascript">

</script>
