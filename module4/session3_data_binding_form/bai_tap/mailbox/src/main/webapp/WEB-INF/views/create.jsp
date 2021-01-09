<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/5/2021
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="mailbox">
    <h1>Settings</h1>
    <div>
        <label>languages:  </label>
        <form:select path="languages">
            <form:option value="Thailand"/>
            <form:option value="VietNam"/>
        </form:select>
    </div>
    <div>
        <label>Page Size: </label>
        <form:select path="size">
            <form:option value="25"/>
            <form:option value="1"/>
        </form:select>
    </div>
    <div>
        <label>Spam filter: </label>
        <form:checkbox path="filter" value="Enabel" accesskey="ddddddd" />
    </div>
    <div>
        <label>Signature: </label>
        <form:textarea path="signature"/>
    </div>
    <input type="submit" value="create">
</form:form>
</body>
</html>
