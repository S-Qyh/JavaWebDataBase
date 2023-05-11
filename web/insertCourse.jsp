<%--
  Created by IntelliJ IDEA.
  User: yhq
  Date: 2023/5/11
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加课程信息</title>
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
            <div class="line padding-large border margin-big-left">
                <%--                表单开始--%>
                <h2 class="text-main text-center">插入课程信息</h2>
                <hr class="bg-main">
                <p style="color: red">${message}</p>

                <form method="post" action="<%=request.getContextPath()%>/InsertCourseServlet?type=insert" id="insertForm" name="insertForm"
                      onsubmit="return checksubmit()" enctype="multipart/form-data">
                    <div class="form-group">
                        <div class="label">
                            <label for="cno">
                                课程号</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input" id="cno" name="cno" size="50" placeholder="课程号" data-validate="required:必填,length#=1:课程号长度为1位,
                            ajax#CheckCourseSnoServlet?cno=:课程号已存在"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="label">
                            <label for="cname">
                                课程名</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input" id="cname" name="cname" size="50" placeholder="课程名" data-validate="required:必填"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="label">
                            <label for="ccredit">
                                学分</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input" id="ccredit" name="ccredit" size="50" placeholder="学分" data-validate="required:必填"/>
                        </div>
                    </div>


                    <div class="form-button">
                        <button class="button" type="submit">
                            提交</button>
                    </div>
                </form>
            </div>

        </div>

    </div>


</div>
</div>
</div>

<%--页面内容结束--%>


<%--页面尾部开始--%>
<%@include file="WEB-INF/jspf/doc_footer.jsp" %>

</body>
</html>
