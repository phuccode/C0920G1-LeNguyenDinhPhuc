<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/26/2020
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <div class="loginbox">
        <img src="img/avatar.png" class="avatar">
        <h1>Welcome</h1>
        <form action="/account?action=login" method="post">
            <p>User Name</p>
            <input type="text" name="txtusername" placeholder="Enter Username" required>
            <p>Password</p>
            <input type="password" name="txtpassword" placeholder="Enter Password" required>
            <input type="submit" name="" value="Login">
            <a href="#">Lost your password?</a><br>
            <a href="#">Don't have an account?</a>
        </form>
    </div>
</body>
</html>
