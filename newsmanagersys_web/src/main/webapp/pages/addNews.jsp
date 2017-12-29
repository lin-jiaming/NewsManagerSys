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
    <script src="${pageContext.request.contextPath}/lib/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <style>
        .pic{
            width:100px;
            height:100px;
            margin:20px auto;
            cursor: pointer;
        }
        #addNews{
            margin: 50px auto;
            width: 600px;
            height: 400px;
            border: solid 1px #1a1a1a;
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
        <li class="active">添加新闻</li>
    </ul>
            <%--新闻图片:--%>
                <%--<img src="" alt="" class="pic">--%>
            <%--<input type="hidden" type="file" name="ufile" class="uimg"><br>--%>
            <%--新闻标题: <input type="text" name="urealname"><form:errors path="urealname" cssStyle="color:red"/><br>--%>
            <%--新闻正文: --%>
            <%--用户性别: <input type="radio" name="usex" value="男" checked> 男--%>
            <%--<input type="radio" name="usex" value="女">女<br>--%>
            <%--用户住址: <input type="text" name="uaddree"> <br>--%>
            <%--手机号码: <input type="text" name="utel"><form:errors path="utel" cssStyle="color:red"/><br>--%>
            <%--用户邮箱: <input type="text" name="uemail"><form:errors path="uemail" cssStyle="color:red"/><br>--%>
            <%--注册时间: <input type="date" name="ucreatetime"> <br>--%>
                <div class="row-fluid">
                    <div class="dialog">
                        <div class="block">
                            <div class="block-body">
                                <form role="form" action="${pageContext.request.contextPath}/userAction/addUserInfo" method="post" enctype="multipart/form-data">
                                    <label>标题</label>
                                    <input type="text" name="uname" class="span12">
                                    <label>正文</label>
                                    <textarea name="" id="" rows="5" class="span12"></textarea>
                                    <label>角色</label>
                                    <select class="span12" name="role.rno">
                                        <option value="">请选择</option>
                                        <c:forEach var="obj" varStatus="ids" items="${roleList}">
                                            <option value="${obj.rno}">${obj.rname}</option>
                                        </c:forEach>
                                    </select>
                                    <input type="submit" class="btn btn-primary pull-right" value="添加">

                                    <div class="clearfix"></div>
                                </form>

                        </div>
                    </div>
            </div>
    </div>
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
</script>
