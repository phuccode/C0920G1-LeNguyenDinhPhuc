<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 1/4/2021
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form action="/save">
    <input type="checkbox" id="vehicle1" name="condiment" value="Lettuce">
    <label for="vehicle1"> Lettuce </label><br>
    <input type="checkbox" id="vehicle2" name="condiment" value="Lettuce">
    <label for="vehicle2"> Lettuce</label><br>
    <input type="checkbox" id="vehicle3" name="condiment" value="Mustard">
    <label for="vehicle3"> Mustard</label><br><br>
    <input type="checkbox" id="vehicle4" name="condiment" value="Sprouts">
    <label for="vehicle3"> Sprouts</label><br><br>
    <input type="submit" value="Submit">
</form>
</body>
</html>
