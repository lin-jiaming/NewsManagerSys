<%--
  Created by IntelliJ IDEA.
  User: linjiaming
  Date: 2017/11/1
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>用户登录</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="stylesheet" type="text/css" href="../lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="../stylesheets/theme.css">
    <link rel="stylesheet" href="../lib/font-awesome/css/font-awesome.css">
    <script src="../lib/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="../lib/bootstrap/js/bootstrap.js"></script>
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
    </style>
    </head>
<body>

<div class="navbar">
    <div class="navbar-inner">
        <ul class="nav pull-right">

        </ul>
        <a class="brand" href="index.html"><span class="second">新闻管理系统</span></a>
    </div>
</div>
<div class="row-fluid">
    <div class="dialog">
        <div class="block">
            <p class="block-heading">登录</p>
            <div class="block-body">
                    <div style="color:red">${message}</div>
                <form action="${pageContext.request.contextPath}/loginAction/doLogin" method="post">
                    <label>用户名</label>
                    <input type="text" name="uname" class="span12">
                    <label>密码</label>
                    <input type="password" name="upwd" class="span12">
                    <input type="submit" class="btn btn-primary pull-right" value="登录">
                    <div class="clearfix"></div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
