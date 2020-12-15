<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/15/2020
  Time: 10:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Simple Dictionary</title>
    <meta charset="UTF-8">
</head>
<body>
<%
    Map<String, String> pic = new HashMap<>();
%>

<%
    pic.put("hello","chao xìn");
    pic.put("bye","tạm biệt");
    pic.put("map","bản đồ");
    pic.put("good","tốt");

    String name = request.getParameter("name");

    String result = pic.get(name);
    if(result != null) {
        out.println("Word: " + name);
        out.println("Result: " + result);
    }else {
        out.println("Not found");
    }

%>
</body>
</html>
