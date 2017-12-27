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
    <script src="${pageContext.request.contextPath}/lib/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
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
        <li><a href="${pageContext.request.contextPath}/userAction/getUserInfoById?uno=${LoginUser.uno}">个人信息</a></li>
        <span class="divider">/</span></li>
        <li class="active">修改信息</li>
    </ul>

        <form action="${pageContext.request.contextPath}/userAction/doUpdateUserInfo" method="post" enctype="multipart/form-data">

            <input type="hidden" name="fno" value="${userinfo[0].fno}">
            <input type="hidden" name="uno" value="${LoginUser.uno}">
            头像:
            <img src="${pageContext.request.contextPath}/userimg/${userinfo[0].uimg}" alt="" class="pic">
            <input type="file" name="ufile" class="uimg" value="${pageContext.request.contextPath}/userimg/${userinfo[0].uimg}" style="display: block"><br>
            真实姓名: <input type="text" name="urealname" value="${userinfo[0].urealname}"><form:errors path="*" cssStyle="color:red"/><br>
            用户年龄: <input type="text" name="uage" value="${userinfo[0].uage}"><br>
            用户性别: <input type="radio" name="usex" value="男" checked> 男
            <input type="radio" name="usex" value="女"> 女<br><br>
            用户住址: <input type="text" name="uaddree" value="${userinfo[0].uaddree}"> <br>
            手机号码: <input type="text" name="utel" value="${userinfo[0].utel}"><form:errors path="utel" cssStyle="color:red"/><br>
            用户邮箱: <input type="text" name="uemail" value="${userinfo[0].uemail}"><form:errors path="uemail" cssStyle="color:red"/><br>
            注册时间: <input type="date" name="ucreatetime" value="${userinfo[0].ucreatetime}"> <br>
            <input type="submit" value="修改" class="btn">
        </form>
</div>
</body>
</html>
<script type="text/javascript">
    //图像预览
    $(function() {
        $(".pic").click(function () {
            $(".uimg").click(); //隐藏了input:file样式后，点击头像就可以本地上传
            $(".uimg").on("change",function(){
                var objUrl = getObjectURL(this.files[0]) ; //获取图片的路径，该路径不是图片在本地的路径
                if (objUrl) {
                    $(".pic").attr("src", objUrl) ; //将图片路径存入src中，显示出图片
                }
            });
        });
    });

    //建立一個可存取到該file的url
    function getObjectURL(file) {
        var url = null ;
        if (window.createObjectURL!=undefined) { // basic
            url = window.createObjectURL(file) ;
        } else if (window.URL!=undefined) { // mozilla(firefox)
            url = window.URL.createObjectURL(file) ;
        } else if (window.webkitURL!=undefined) { // webkit or chrome
            url = window.webkitURL.createObjectURL(file) ;
        }
        return url ;
    }
    //取出用户的性别
    var sex = document.forms[0].usex; //先取出名称为esex的单选框
    if(sex[0].value=='${userinfo[0].usex}') {
        sex[0].checked = true;
    }
    else {
        sex[1].checked = true;
    }
</script>
