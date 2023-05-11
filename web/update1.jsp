<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>修改学生记录</title>
</head>
<body>
<h1>修改学生记录!</h1>
<p style="color:red;">${updatetInfo}</p>
<form id="updateForm" name="insertForm" method="post"
      action="<%=request.getContextPath()%>/InsertServlet?type=update">
    <p>学生学号：<input id="sno" name="sno" type="text" value="${student.sno}" readonly/></p>
    <p>学生姓名：<input id="sname" name="sname" type="text" value="${student.sname}"/></p>

    <p>学生性别：
        <c:if test="${student.ssex=='男'}">
            <input id="ssex" name="ssex" type="radio" checked="checked" value="男"/>男&nbsp;&nbsp;
            <input id="ssex" name="ssex" type="radio" value="女"/>女
        </c:if>

        <c:if test="${student.ssex=='女'}">
            <input id="ssex" name="ssex" type="radio" value="男"/>男&nbsp;&nbsp;
            <input id="ssex" name="ssex" type="radio" checked="checked" value="女"/>女
        </c:if>
    </p>
    <p>学生年龄：<input id="sage" name="sage" type="text" value="${student.sage}"/></p>
<%--    <p>学生系部：<input id="sdept" name="sdept" type="text" value="${student.sdept}"/></p>--%>
    <p>学生系部：
        <select name="sdept">
            <option value="请选择">---请选择---</option>
            <c:forEach items="${dept_list}" var="list">
                <option value='${list}' <c:if
                        test="${student.sdept==list}"> selected="selected" </c:if>>
                        ${list}</option>
            </c:forEach>
        </select>
    </p>

    <p><input type="submit" value="提交"/></p>
</form>
</body>
</html>
