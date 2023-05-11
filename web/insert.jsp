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
                <h2 class="text-main text-center">插入学生记录</h2>
    <hr class="bg-main">
    <p style="color: red">${message}</p>

                <form method="post" action="<%=request.getContextPath()%>/InsertServlet?type=insert" id="insertForm" name="insertForm"
                      onsubmit="return checksubmit()" enctype="multipart/form-data">
                    <div class="form-group">
                        <div class="label">
                            <label for="sno">
                                学号</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input" id="sno" name="sno" size="50" placeholder="学生学号" data-validate="required:必填,length#=7:学号长度为7位,
                            ajax#CheckSnoServlet?sno=:学号已存在"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="sname">
                                姓名</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input" id="sname" name="sname" size="50" placeholder="学生姓名" data-validate="required:必填"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="label">
                            <label for="ssex">
                                性别</label>
                        </div>
                        <div class="field">
                            <div class="button-group radio">
                                <label class="button active">
                                    <input name="ssex" value="男" checked="checked" type="radio"><span class="icon icon-male"></span> 男
                                </label>
                                <label class="button">
                                    <input name="ssex" value="女" type="radio"><span class="icon icon-female"></span> 女
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="label">
                            <label for="sage">
                                年龄</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input" id="sage" name="sage" size="50" placeholder="学生年龄" data-validate="required:必填,number:年龄只能填写数字,compare#<25:年龄介于0-150之间"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="label">
                            <label for="sdept">
                                    系部</label>
                        </div>
                        <div class="field">
                            <input type="text" class="input" id="sdept" name="sdept" size="50" placeholder="系部" data-validate="required:必填"/>
                        </div>
                    </div>


                    <div class="form-group">
                        <div class="label">
                            <label for="photo">
                                照片</label>
                        </div>
                        <div class="field">
                            <a class="button input-file" href="javascript:void(0);">+ 浏览文件<input size="100" type="file" id="photo" name="photo" onchange="upload(this)"/></a>
                            <input type="hidden" name="oldfilename" value="${student.photo_url}">
                        </div>
                        <div class="photo">
                            <img width="150" height="150" id="showPhoto" class="img-border radius">
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


<script type="text/javascript">
    var showPhoto = document.getElementById("showPhoto")
    var photo = document.getElementById("photo")
    function upload(obj){
        showPhoto.src = window.URL.createObjectURL(obj.files[0])
    }
    function checksubmit(){
        if(!photo.files[0]){
            return true
        }else {
            if (photo.files[0].size > 65000){
                alert("图片大于65k,请重新选择")
                return false
            }
        }
    }

    // function send(){
    //     $("#ajaxForm").ajaxSubmit(function() {
    //         alert('在没有成功验证前你是看不到我滴...');
    //     });
    // }

</script>

</body>
</html>
