<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/20/2020
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customers?action=customers">List All Customers</a>
    </h2>
</center>
<div align="center">
    <form method="post" >
        <caption>
            <h2>Add New Customer</h2>
        </caption>
        <table class="table table-hover table-dark">
            <tr>
                <th>Customers Type Id:</th>
                <td>
                    <input class="form-control" type="text" required name="customer_type_id" id="customer_type_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Name:</th>
                <td>
                    <input class="form-control" type="text" required name="customer_name" id="customer_name" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Birthday:</th>
                <td>
                    <input class="form-control" type="text" required name="customer_birthday" id="customer_birthday" size="45"/>
                    <small style="margin-left: 16%; font-size: 100%; color: red">
                        <c:if test="${messageBirthday != null}">${messageBirthday}</c:if>
                    </small>
                </td>
            </tr>
            <tr>
                <th>Gender:</th>
                <td>
                    <label for="customer_gender"></label>
                    <select class="form-control" name="customer_birthday" id="customer_gender">
                        <option>Male</option>
                        <option>Female</option>
                    </select>
                </td>
            </tr>
            <tr>
                <th>Id Card:</th>
                <td>
                    <input class="form-control" type="text" required name="customer_id_card" id="customer_id_card" size="45"/>
                    <small style="margin-left: 16%; font-size: 100%; color: red">
                        <c:if test="${messageIdCard != null}">${messageIdCard}</c:if>
                    </small>
                </td>
            </tr>
            <tr>
                <th>Phone:</th>
                <td>
                    <input class="form-control" type="text" required name="customer_phone" id="customer_phone" size="45"/>
                    <small style="margin-left: 16%; font-size: 100%; color: red">
                        <c:if test="${phoneNumber != null}">${phoneNumber}</c:if>
                    </small>
                </td>
            </tr>
            <tr>
                <th>Email:</th>
                <td>
                    <input class="form-control" type="text" required name="customer_email" id="customer_email" size="45"/>
                    <small style="margin-left: 16%; font-size: 100%; color: red">
                        <c:if test="${messageEmail != null}">${messageEmail}</c:if>
                    </small>
                </td>
            </tr>
            <tr>
                <th>Address:</th>
                <td>
                    <input class="form-control" type="text" required name="customer_address" id="customer_address" size="45"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input class="btn btn-primary" type="submit" value="Save"/>
                    <a class="btn btn-danger" href="/customers">Back</a>
                </td>
            </tr>
        </table>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
