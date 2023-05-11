<%--
  Created by IntelliJ IDEA.
  User: yhq
  Date: 2023/5/11
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container padding-big-top padding-big-bottom">
    <div class="line">
        <div class="xl12 xs3 xm3 xb3">
            <button class="button icon-navicon float-right" data-target="#header-demo1">
            </button>
            <a href="DisplayServlet">
                <h2 class="icon-paper-plane-o ring-hover">学生信息管理系统</h2>
            </a>
        </div>
        <div class="xl12 xs9 xm9 xb9 padding-small-top">
            <ul class="nav nav-menu nav-inline nav-navicon text-center" id="header-demo1">
                <li class="active"><a href="DisplayServlet">学生信息管理<span class="arrow"></span></a>
                    <ul class="drop-menu">
                        <li><a href="insert.jsp">添加学生记录</a></li>
                    </ul>
                </li>
<%--                <li><a href="<%request.getContextPath();%>/CourseManagerServlet">课程信息管理</a></li>--%>
                <li><a href="<%request.getContextPath();%>/CourseManage">课程信息管理</a>
                    <ul class="drop-menu">
                        <li><a href="insertCourse.jsp">添加课程信息</a></li>
                    </ul>
                </li>
                <li><a href="#">选课信息管理</a></li>
            </ul>
        </div>
    </div>
    <hr>
</div>