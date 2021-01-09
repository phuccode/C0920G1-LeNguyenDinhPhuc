<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/22/2020
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contract Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Contract Management</h1>
    <h2>
        <a href="/contracts?action=create">Add New Contract</a>
    </h2>
</center>
<div align="center">
    <caption><h2>List of Contracts</h2></caption>
    <table class="table table-hover table-dark">
        <tr>
            <th scope="col">Contract Id</th>
            <th scope="col">Contract Start Date</th>
            <th scope="col">Contract End Date</th>
            <th scope="col">Contract Deposit</th>
            <th scope="col">Contract Total Money</th>
            <th scope="col">Employee Id</th>
            <th scope="col">Customer Id</th>
            <th scope="col">Service Id</th>
        </tr>
        <c:forEach var="contract" items="${contractList}">
            <tr>
                <th scope="row"><c:out value="${contract.getContractId()}"/></th>
                <td><c:out value="${contract.getContractStartDate()}"/></td>
                <td><c:out value="${contract.getContractEndDate()}"/></td>
                <td><c:out value="${contract.getContractDeposit()}"/></td>
                <td><c:out value="${contract.getContractTotalMoney()}"/></td>
                <td><c:out value="${contract.getEmployeeId()}"/></td>
                <td><c:out value="${contract.getCustomerId()}"/></td>
                <td><c:out value="${contract.getServiceId()}"/></td>
            </tr>
        </c:forEach>
    </table>
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
