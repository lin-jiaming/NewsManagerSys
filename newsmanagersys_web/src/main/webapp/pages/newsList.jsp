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
    <title>新闻中心</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/js/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/mynews.js" type="text/javascript"></script>
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
        <li class="active">新闻中心</li>
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
    <div id="seachdiv" style="height: 30px;" align="center">
        <form method="post" action="${pageContext.request.contextPath}/newsAction/doFindNewsPageForondition" id="seachFrm" >
        <input type="hidden" name="cpage" value="1"/>
            标题: <input type="text" class="span2" name="querys" value="${pageBean.querys[0]}">
            作者: <input type="text" class="span2" name="querys" value="${pageBean.querys[1]}">
            版块: <select  id="secList" class="span1" name="querys" value="${pageBean.querys[2]}">
            <option value="">不限</option>
            <c:forEach var="secList" items="${sectionList}" varStatus="ids">
                <option value="${secList.sno}">${secList.sname}</option>
            </c:forEach>
            </select>
            日期:<input type="date" class="span2" name="querys" value="${pageBean.querys[3]}">
            <input type="submit" value="搜索" style="margin-bottom: 10px">
    </form>
    </div>
    <table class="table table-striped" id="tab" width="100%">
        <thead>
        <tr>
            <td>编号</td>
            <td >标题</td>
            <td>版块</td>
            <td>作者</td>
            <td>发布日期</td>
            <td>操作</td>
        </tr>
        <c:forEach var="news" items="${pageBean.result}" varStatus="ids">
            <tr>
                <td>${(pageBean.cpage-1)*pageBean.showNum+ids.count}</td>
                <td >${news[0].ntitle}</td>
                <td >${news[1].sname}</td>
                <td >${news[0].nauthor}</td>
                <td >${news[0].nintime}</td>
                <td><a href="javascript:getNewsById(${news[0].nno});">查看详细</a>&nbsp;
                    <%--判断是否是管理员，如果是就显示修改和删除，如果不是就不显示--%>
                    <c:if test="${LoginUser.role.rno==1}">
                    <a href="${pageContext.request.contextPath}/newsAction/toUpdateNews?nno=${news[0].nno}">修改</a>&nbsp;
                    <a href="${pageContext.request.contextPath}/newsAction/doDeleteNews?nno=${news[0].nno}">删除</a></td>
                    </c:if>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="6" style="text-align: center">
                <a href="javascript:doPage(1);" id="topPage">首页</a>|
                <a href="javascript:doPage(${pageBean.cpage-1>0?pageBean.cpage-1:1});">上一页</a>|
                当前第${pageBean.cpage }页,共有${pageBean.allPage}页|
                <a href="javascript:doPage(${pageBean.cpage+1>pageBean.allPage?pageBean.allPage:pageBean.cpage+1});">下一页</a>|
                <a href="javascript:doPage(${pageBean.allPage});">尾页</a>
            </td>
        </tr>
        </thead>
    </table>
    <!-- 新闻详细 -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">新闻详细</h4>
                </div>
                <form method="post" action="${pageContext.request.contextPath}/sectionAction/doUpdateSection">
                    <div class="modal-body">
                    </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    //打开新闻详细对话框
    function getNewsById(nid){
        $('#myModal').modal('show');
        $('.modal-title').html("新闻详细");
        $(".modal-body :not(first)").remove();
        $.get("${pageContext.request.contextPath}/newsAction/getNewsById?nno="+nid,"",function(data){
            var context="<h2>"+data.ntitle+"</h2>" +
                "<p style='text-align: center;'>"+data.nauthor+"-"+data.nintime+"</p>" +
                "<h3 style='text-indent: 2em;'>"+data.ncontent+"</h3>" +
                "<p><img src='${pageContext.request.contextPath}/newsImages/"+data.nimages+"'></p>" +
                "<a href='${pageContext.request.contextPath}/newsAction/downloadFile?fileName="+data.nimages+"'>下载新闻图片</a>";
            $(".modal-body").append(context);
        });
    }
    $(".close").click(function(){
    $("#myModal").css("display","none");
    });
</script>
