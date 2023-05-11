<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.util.regex.Matcher" %>

<%--
  Created by IntelliJ IDEA.
  User: yhq
  Date: 2023/3/30
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String thisname, thispwd, reqMethod, reqParam;
    String[] param;
    thisname = "";
    thispwd = "";
    reqMethod = request.getMethod();

    if (reqMethod.equals("GET")) {
        reqParam = request.getQueryString();
        if (reqParam != null) {
            param = reqParam.split("&");
            thisname = param[0].substring("name".length() + 1);
            thispwd = param[1].substring("pwd".length() + 1);
        }
    } else if (reqMethod.equals("POST")) {
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String jsonStr = sb.toString();
//        System.out.println(jsonStr);
        Pattern pattern = Pattern.compile("\"name\":\"(.*?)\",\"pwd\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(jsonStr);
        String name = null,pwd = null;
        if (matcher.find()) {
            name = matcher.group(1); // 获取第一个捕获组的值
            pwd = matcher.group(2); // 获取第二个捕获组的值
        }
        thisname = name;
        thispwd = pwd;
    }
    if (thisname.equals("wwh") && thispwd.equals("123456")) {
        out.println(reqMethod + " was used hello, " + thisname);
    } else {
        out.println("Failed to sign in");
    }
%>
</body>
</html>
