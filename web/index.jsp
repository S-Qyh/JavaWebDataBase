<%--
  Created by IntelliJ IDEA.
  User: yhq
  Date: 2023/3/28
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生信息</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/pintuer.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script type="text/javascript">
        function ConfDel() {
            var tip = " 确定要删除指定学生信息吗？"
            return confirm(tip);
        }
    </script>

    <style>
        .table td{
            vertical-align: middle;
            text-align: center;
        }
    </style>
</head>
<body>
<%--头部页面开始--%>
<%@include file="WEB-INF/jspf/doc_header.jsp"%>

<%--页面头部开始--%>


<%--页面内容开始--%>
<div class="container padding-big-top padding-big-bottom">
    <div class="line">
        <div class="xl12 xs3 xm3 xb3">
            <%@include file="WEB-INF/jspf/doc_link.jsp"%>
        </div>
        <div class="xl12 xs9 xm9 xb9">

            <div class="line padding-large-left">
                <%--            轮播图开始--%>
                <div class="banner">
                    <div class="carousel">
                        <div class="item">
                            <img src="images/1.jpg" style="width: 100%" class="img-border radius">
                        </div>
                        <div class="item">
                            <img src="images/2.jpg" style="width: 100%" class="img-border radius">
                        </div>
                        <div class="item">
                            <img src="images/3.jpg" style="width: 100%" class="img-border radius">
                        </div>
                        <div class="item">
                            <img src="images/4.jpg" style="width: 100%" class="img-border radius">
                        </div>
                        <div class="item">
                            <img src="images/5.jpg" style="width: 100%" class="img-border radius">
                        </div>
                        <div class="item">
                            <img src="images/6.jpg" style="width: 100%" class="img-border radius">
                        </div>
                        <div class="item">
                            <img src="images/7.jpg" style="width: 100%" class="img-border radius">
                        </div>
                        <div class="item">
                            <img src="images/8.jpg" style="width: 100%" class="img-border radius">
                        </div>
                    </div>
                </div>
                <%--轮播图结束--%>

                <%--学生表格开始--%>
                <div class="line">
                    <form name="searchForm" action="<%request.getContextPath();%>/DisplayServlet" align="center" class="margin-big-top">
                        <div class="form-group">
                            <div class="field">
                                <div class="input-group">
                                    <input type="text" class="input" name="sno" size="50"
                                           placeholder="请输入要查询的学生学号"
                                    /><span class="addbtn">
            <input type="submit" class="button" value="查询"></span>
                                </div>
                            </div>
                        </div>

                    </form>
                    <p style="color:red;">${Info}</p>
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <td>学生照片</td>
                            <td>学生学号</td>
                            <td>学生姓名</td>
                            <td>学生性别</td>
                            <td>学生年龄</td>
                            <td>学生系部</td>
                            <td>功能选项</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${students}" var="stu">
                            <tr>
                                <td><img width="50" height="50" src="photo/${stu.photo_url}"></td>
                                <td>${stu.sno}</td>
                                <td>${stu.sname}</td>
                                <td>${stu.ssex}</td>
                                <td>${stu.sage}</td>
                                <td>${stu.sdept}</td>
                                <td>
                                    <a class="button border-main" href="<%request.getContextPath();%>/UpdateServlet?sno=${stu.sno}"><span class="icon-edit"></span>修改</a>
                                    <a class="button border-red" href="<%request.getContextPath();%>/DeleteServlet?sno=${stu.sno}"
                                       onclick="return ConfDel()"><span class="icon-trash-o"></span>删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                    <div class="height-big text-center margin-big-top">
                        ${pagination.pageBar}&nbsp;&nbsp;&nbsp;&nbsp;
                        ${pagination.numPageBar}
                    </div>
                    <%--                <center><a href="insert.jsp">插入学生记录</a></center>--%>

                </div>
                <%--学生表格结束--%>
            </div>


        </div>
    </div>
</div>

<%--页面内容结束--%>


<%--页面尾部开始--%>
<%@include file="WEB-INF/jspf/doc_footer.jsp"%>


</body>
</html>
