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
    <title>首页</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/js/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/mynews.js"></script>
</head>
    <style>
        #topmenu{
            margin: 10px auto;
            width: 80%;
            height:30px;
        }
        #topmenu ul{
            margin: 0 auto;
        }
        #topmenu ul li{
            float:left; /* 向左漂移，将竖排变为横排 */
            list-style:none; /* 将默认的列表符号去掉 */
            margin:5px 25px;
            font-size: 15px;
        }

        #bottomcontext{
            margin: 10px auto;
            width: 80%;
        }
        .shownews{
            height:120px;
            margin-bottom: 5px;
            border-bottom: dashed 1px #fff;
        }
        .shownews  a{
            color: #000;
        }
        .shownews  a:hover{
            color: #2383cd;
        }
    </style>
<body>
<div class="navbar">
    <div class="navbar-inner">
        <ul class="pull-right" style="color: #fff;margin-top: 10px;">
        <a href="${pageContext.request.contextPath}/main.jsp" style="color: #fff;">
            管理员登录
        </a>
        </ul>
    <a class="brand" href="${pageContext.request.contextPath}/newsAction/doFindNewsList"><span class="second">新闻管理系统</span></a>
</div>
</div>
<div id="allcontent">
    <div id="topmenu">
        <ul id="sectionul">
            <li id="sectionli0">
                <a href="${pageContext.request.contextPath}/newsAction/doFindNewsList">全部</a>
            </li>
        </ul>
    </div>
    <div id="bottomcontext">
        <form method="post" action="${pageContext.request.contextPath}/newsAction/doFindNewsList" id="seachFrm" >
            <input type="hidden" name="cpage" value="1"/>
        </form>
        <c:forEach var="news" items="${pageBean.result}" varStatus="ids">
            <div class="shownews">
                <h2><a href="${pageContext.request.contextPath}/newsAction/doGetNewsById?nno=${news[0].nno}">${news[0].ntitle}</a></h2>
                <p style="overflow:hidden; height: 22px;text-overflow: ellipsis;width: 700px;"><a href="${pageContext.request.contextPath}/newsAction/doGetNewsById?nno=${news[0].nno}">${news[0].ncontent}</a></p>
                <div style="float: right;margin-top: -70px" >
                    <a href="${pageContext.request.contextPath}/newsAction/doGetNewsById?nno=${news[0].nno}">
                        <img src="${pageContext.request.contextPath}/newsImages/${news[0].nimages}" width="110px" height="110px">
                    </a>
                </div>
                ${news[1].sname}-
                ${news[0].nauthor}-
                ${news[0].nintime}
            </div>
        </c:forEach>
    </div>
</div>
    <c:if test="${pageBean.allPage>=2}">
<div style="text-align: center;margin-bottom: 10px">
            <a href="javascript:doPage(1);" id="topPage">首页</a>|
            <a href="javascript:doPage(${pageBean.cpage-1>0?pageBean.cpage-1:1});">上一页</a>|
            当前第${pageBean.cpage }页,共有${pageBean.allPage}页|
            <a href="javascript:doPage(${pageBean.cpage+1>pageBean.allPage?pageBean.allPage:pageBean.cpage+1});">下一页</a>|
            <a href="javascript:doPage(${pageBean.allPage});">尾页</a>
</div>
    </c:if>
</body>
</html>
<script type="text/javascript">
        window.onload=function loadSection(){
        $.get("${pageContext.request.contextPath}/sectionAction/dofindAllSectionList","",function(data){
            $.each(data,function(i,v){
                var li = "<li id='sectionli"+(i+1)+"'><a href='${pageContext.request.contextPath}/newsAction/dofindNewsPageListBySection?sno="+v.sno+"'>"+v.sname+"</a></li>";
                $("#sectionul ").append(li);
            })
        },"json");
    }

</script>
