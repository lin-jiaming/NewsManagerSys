<%--
  Created by IntelliJ IDEA.
  User: linjiaming
  Date: 2017/11/15
  Time: 19:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sibebar-nav</title>
</head>
<body>
<!--判断是否为管理员，如果是就显示管理员该有的功能-->
<c:if test="${LoginUser.role.rno==1}">
    <a href="#role-menu" class="nav-header collapsed" data-toggle="collapse"><i class="icon-user"></i>用户管理</a>
    <ul id="role-menu" class="nav nav-list collapse">
        <li ><a href="${pageContext.request.contextPath}/userAction/toAddUser">添加用户</a></li>
        <li ><a href="${pageContext.request.contextPath}/userAction/findUserList">用户管理</a></li>
    </ul>

    <a href="#new-menu" class="nav-header" data-toggle="collapse"><i class="icon-list"></i>版块管理</a>
    <ul id="new-menu" class="nav nav-list collapse">
        <li><a href="${pageContext.request.contextPath}/pages/addSection.jsp">新增版块</a></li>
        <li ><a href="${pageContext.request.contextPath}/sectionAction/doFindSectionList">版块管理</a></li>
    </ul>
</c:if>

<a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-book"></i>新闻管理</a>
<ul id="accounts-menu" class="nav nav-list collapse">
    <li ><a href="${pageContext.request.contextPath}/newsAction/toAddNews">添加新闻</a></li>
    <li ><a href="${pageContext.request.contextPath}/newsAction/doFindNewsPageList">新闻中心</a></li>

</ul>



<a href="#legal-menu" class="nav-header" data-toggle="collapse"><i class="icon-cog"></i>个人设置</a>
<ul id="legal-menu" class="nav nav-list collapse">
    <li ><a href="${pageContext.request.contextPath}/userAction/getUserInfoById?uno=${LoginUser.uno}">个人信息</a></li>
    <li ><a href="${pageContext.request.contextPath}/userAction/toUpdateUserPwd?uno=${LoginUser.uno}">修改密码</a></li>
</ul>
</body>
</html>
