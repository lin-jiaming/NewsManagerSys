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
    <title>版块管理</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/font-awesome/css/font-awesome.css">
    <script src="${pageContext.request.contextPath}/lib/js/jquery-1.8.1.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/lib/bootstrap/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/vue.js"></script>
    <script src="${pageContext.request.contextPath}/lib/js/mynews.js"></script>
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
        <li class="active">版块管理</li>
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
    <form style="display: none" method="post" action="${pageContext.request.contextPath}/sectionAction/doFindSectionList" id="seachFrm" >
        <input type="hidden" name="cpage" value="1">
    </form>
    <table class="table table-striped" id="tab">
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
            <td><a href="javascript:toUpdate(${section.sno});">修改</a>&nbsp;
                <a href="${pageContext.request.contextPath}/sectionAction/doDeleteSection?sno=${section.sno}">删除</a></td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="3" style="text-align: center">
            <a href="javascript:doPage(1);">首页</a>|
            <a href="javascript:doPage(${pageBean.cpage-1>0?pageBean.cpage-1:1});">上一页</a>|
            当前第${pageBean.cpage }页,共有${pageBean.allPage}页|
            <a href="javascript:doPage(${pageBean.cpage+1>pageBean.allPage?pageBean.allPage:pageBean.cpage+1});">下一页</a>|
            <a href="javascript:doPage(${pageBean.allPage});">尾页</a>
        </td>
    </tr>
    </thead>
    </table>
        <%--<table class="table table-striped" id="tab">--%>
            <%--<thead>--%>
            <%--<tr>--%>
                <%--<td>编号</td>--%>
                <%--<td >版块名</td>--%>
                <%--<td>操作</td>--%>
            <%--</tr>--%>
            <%--<tr v-for="(s,index) in info.result">--%>
                <%--<td>{{index + 1}}</td>--%>
                <%--<td>{{s.sname}}</td>--%>
                    <%--<td><a href="" data-toggle="modal" data-target="#myModal">修改</a>&nbsp;--%>
                    <%--<a v-bind:href="'${pageContext.request.contextPath}/sectionAction/doDeleteSection?sno='+s.sno">删除</a></td>--%>
            <%--</tr>--%>
            <%--<tr>--%>
                <%--<td colspan="3">--%>
                    <%--<a href='javascript:;' v-on:click="changePage('1')">首页</a>--%>
                    <%--| <a href='javascript:;' v-on:click="changePage(info.cpage>1?info.cpage-1:info.cpage)">上一页</a>--%>
                    <%--| <span>当前<b>{{info.cpage}}</b>页</span> <span>共有<b>{{info.allPage}}</b>页</span>--%>
                    <%--| <a href='javascript:;' v-on:click="changePage(info.cpage&lt;info.allPage?info.cpage+1:info.allPage)">下一页</a>--%>
                    <%--| <a href='javascript:;' v-on:click="changePage(info.allPage)">尾页</a>--%>
                <%--</td>--%>
            <%--</tr>--%>
            <%--</thead>--%>
        <%--</table>--%>
    <!-- 模态框（Modal） -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" >
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">修改版块</h4>
                </div>
                <form method="post" action="${pageContext.request.contextPath}/sectionAction/doUpdateSection">
                <div class="modal-body">
                    <input name="sno" hidden value="">
                    版块名:<input name="sname" value="" >
                </div>
                <div class="modal-footer">
                    <input type="button" class="btn btn-default" data-dismiss="modal" value="关闭">
                    <input type="submit" class="btn btn-primary" value="修改">
                </div>
                </form>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div>
    <!-- /.modal -->
</div>
</body>
</html>
<script type="text/javascript">
    //vue.js版的分页操作
    <%--var model = {--%>
        <%--info : {--%>
            <%--"cpage" : 1,--%>
            <%--"showNum" : 5,--%>
            <%--"allPage" : 0,--%>
            <%--"result" : []--%>
        <%--}--%>
    <%--};--%>

    <%--var model2 = {--%>
        <%--"cpage" : 1,--%>
        <%--"showNum" : 5--%>
    <%--};--%>

    <%--var vm = new Vue({--%>
        <%--el : '#tab',--%>
        <%--data : model,--%>
        <%--methods : {--%>
            <%--changePage : function(p) {--%>
                <%--model2.cpage = p;--%>
            <%--},--%>
            <%--queryInfo : function(pageInfo) {--%>
                <%--$.ajax({--%>
                    <%--url : "${pageContext.request.contextPath}/sectionAction/doFindSectionList",--%>
                    <%--data : pageInfo,--%>
                    <%--type : 'post',--%>
                    <%--dataType : 'json',--%>
                    <%--timeout : 3000,--%>
                    <%--success : function(result) {--%>
                        <%--model.info = result;--%>
                    <%--},--%>
                    <%--error : function() {--%>
                        <%--alert("服务器繁忙，请稍候再试！");--%>
                    <%--}--%>
                <%--});--%>
            <%--}--%>
        <%--},--%>
        <%--created : function() {--%>
            <%--this.queryInfo(model2);--%>
        <%--}--%>
    <%--});--%>

    <%--var vm2 = new Vue({--%>
        <%--data : model2--%>
    <%--});--%>

    <%--vm2.$watch('cpage', function(newValue, oldValue) {--%>
        <%--vm.queryInfo(model2);--%>
    <%--});--%>


    //打开修改版块的对话框
    function toUpdate(sno){
        $('#myModal').modal('show');
        $.get("${pageContext.request.contextPath}/sectionAction/toUpdateSection?sno="+sno,"",function(data){
            $("input[name='sno']").val(data.sno);
            $("input[name='sname']").val(data.sname);

        });
    }
</script>
