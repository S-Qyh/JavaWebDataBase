<%@ page import="com.stu.util.DaoFactory" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.stu.dao.IDeptDao" %>
<%@ page import="com.stu.impl.DeptDaoImpl" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>插入学生记录</title>
</head>
<body>
<div>
<h1>插入学生记录!</h1>
<p style="color:red;">${insertInfo}</p>
<form id="insertForm" name="insertForm" method="post"
      action="<%=request.getContextPath()%>/InsertServlet?type=insert">
    <p>学生学号：<input id="sno" name="sno" type="text"/></p>
    <p>学生姓名：<input id="sname" name="sname" type="text"/></p>
    <p>学生性别：
        <input id="ssex" name="ssex" type="radio" checked="checked" value="男"/>男&nbsp;&nbsp;
        <input id="ssex" name="ssex" type="radio" value="女"/>女
    </p>
    <p>学生年龄：<input id="sage" name="sage" type="text"/></p>
    <%--    <p>学生系部：<input id="sdept" name="sdept" type="text"/></p>--%>
    <%
        ArrayList<String> allDept = DaoFactory.getDeptDao().getAllDept();
    %>
    <p>学生系部：
        <select id="sdept" name="sdept">
            <option value="请选择">----请选择----</option>
            <% for ( String dept : allDept) { %>
            <option value="<%= dept %>"><%= dept %></option>
            <% } %>
        </select>
    </p>
    <p><input type="submit" value="提交"/></p>
</form>
</div>
</body>
</html>
