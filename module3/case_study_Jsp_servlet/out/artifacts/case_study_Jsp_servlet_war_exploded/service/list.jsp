<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/22/2020
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Service Management</h1>
    <h2>
        <a href="/services?action=create">Add New Service</a>
    </h2>
</center>
<div align="center">
    <caption><h2>List of Services</h2></caption>
    <table  class="table table-hover table-dark">
        <tr>
            <th scope="col">Service Id</th>
            <th scope="col">Service Name</th>
            <th scope="col">Service Area</th>
            <th scope="col">Service Cost</th>
            <th scope="col">Service Max People</th>
            <th scope="col">Rent Type Id</th>
            <th scope="col">Service Type Id</th>
            <th scope="col">Standard Room</th>
            <th scope="col">Description Other Convenience</th>
            <th scope="col">Pool Area</th>
            <th scope="col">Number Of Floors</th>
        </tr>
        <c:forEach var="service" items="${serviceList}">
            <tr>
                <th scope="row"><c:out value="${service.getServiceId()}"/></th>
                <td><c:out value="${service.getServiceName()}"/></td>
                <td><c:out value="${service.getServiceArea()}"/></td>
                <td><c:out value="${service.getServiceCost()}"/></td>
                <td><c:out value="${service.getServiceMaxPeople()}"/></td>
                <td><c:out value="${service.getRentTypeId()}"/></td>
                <td><c:out value="${service.getServiceTypeId()}"/></td>
                <td><c:out value="${service.getStandardRoom()}"/></td>
                <td><c:out value="${service.getDescriptionOtherConvenience()}"/></td>
                <td><c:out value="${service.getPoolArea()}"/></td>
                <td><c:out value="${service.getNumberOfFloors()}"/></td>
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
