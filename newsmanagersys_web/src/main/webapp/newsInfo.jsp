<%--
  Created by IntelliJ IDEA.
  User: linjiaming
  Date: 2017/11/1
  Time: 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>详细新闻</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/js/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    </head>
<body>
<div class="navbar">
    <div class="navbar-inner">

        <a class="brand" href="${pageContext.request.contextPath}/newsAction/doFindNewsList"><span class="second">新闻管理系统</span></a>
    </div>
</div>
<div align="center">
    <h2>${newsInfo.ntitle}</h2>
    <span>${newsInfo.nauthor}-${newsInfo.nintime}</span>
    <p style="width: 500px; font-size: 16px">${newsInfo.ncontent}</p>
    <img src="${pageContext.request.contextPath}//newsImages/${newsInfo.nimages}" width="500px" height="500px">
</div>
</body>
</html>
<script type="text/javascript">

</script>



