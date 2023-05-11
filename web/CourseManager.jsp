<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yhq
  Date: 2023/5/11
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        课程信息管理
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/pintuer.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<%--头部页面开始--%>
<%@include file="WEB-INF/jspf/doc_header.jsp" %>

<%--页面头部开始--%>


<%--页面内容开始--%>
<div class="container padding-big-top padding-big-bottom">
    <div class="line">
        <div class="xl12 xs3 xm3 xb3">
            <%@include file="WEB-INF/jspf/doc_link.jsp" %>
        </div>
        <div class="xl12 xs9 xm9 xb9">

            <div class="line padding-large-left">


                <%--学生表格开始--%>
                <div class="line">
                    <p style="color:red;">${message}</p>
                    <table class="table table-hover table-bordered">
                        <thead>
                        <tr>
                            <td>课程号</td>
                            <td>课程名</td>
                            <td>学分</td>
                            <td>操作</td>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${allCourses}" var="course">
                            <tr>
                                <td>${course.cno}</td>
                                <td>${course.cname}</td>
                                <td>${course.ccredit}</td>
                                <td>
                                    <a class="button border-main"
                                       href="<%request.getContextPath();%>/UpdateCourseServlet?cno=${course.cno}"><span
                                            class="icon-edit"></span>修改</a>
                                    <a class="button border-red"
                                       href="<%request.getContextPath();%>/DeleteCourseServlet?cno=${course.cno}"
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
<%@include file="WEB-INF/jspf/doc_footer.jsp" %>

</body>
</html>
