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
    <title>用户管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
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
        <li class="active">版块管理</li>
    </ul>
    <c:if test="${param.res==1}">
        <div class="alert alert-success">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>操作成功
        </div>
    </c:if>
    <c:if test="${param.res==-1}">
        <div class="alert alert-danger">
            <a href="#" class="close" data-dismiss="alert">
                &times;
            </a>
            操作失败</div>
    </c:if>
    <form method="post" action="${pageContext.request.contextPath}/sectionAction/doFindSectionList" id="seachFrm" >
        <input type="hidden" name="pageBean.cpage" value="1">
    </form>
        <table class="table table-striped">
            <thead>
            <tr>
                <td>编号</td>
                <td>版块名</td>
                <td>操作</td>
            </tr>
            <c:forEach var="section" items="${pageBean.result}" varStatus="ids">
                <tr>
                    <td>${(pageBean.cpage-1)*pageBean.showNum+ids.count}</td>
                    <td>${section.sname}</td>
                    <td><a href="">删除</a></td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="3" style="text-align: center">
                    <a href="javascript:doPage(1);">首页</a>|
                    <a href="javascript:doPage(${pageBean.cpage-1>0?pageBean.cpage-1:1});">上一页</a>|
                    当前第${pageBean.cpage }页,共有${pageBean.allPage }页|
                    <a href="javascript:doPage(${pageBean.cpage+1>pageBean.allPage?pageBean.allPage:pageBean.cpage+1});">下一页</a>|
                    <a href="javascript:doPage(${pageBean.allPage});">尾页</a>
                </td>
            </tr>
            </thead>
        </table>
</div>
</body>
</html>
<script type="text/javascript">
    function doPage(num){
        $("input[name='pageBean.cpage']").val(num);
        $("#seachFrm")[0].submit();
    }
</script>
