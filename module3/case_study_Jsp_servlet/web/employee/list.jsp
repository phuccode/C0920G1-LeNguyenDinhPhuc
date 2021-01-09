<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/22/2020
  Time: 9:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="bootstrap413/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap4.min.css"/>
    <script src="https://kit.fontawesome.com/a076d05399.js"></script>
</head>
<body>
<a class="navbar-brand" style="margin-left: 20px" href="/index.jsp">
    <img src="https://furamavietnam.com/wp-content/uploads/2018/10/logo.png" width="65" height="80"
         class="d-inline-block align-top" alt="1">
</a>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employees?action=create">Add New Employee</a>
    </h2>
</center>
<form class="form-inline my-2 my-lg-0" action="/employees" style="margin-left: 550px">
    <input type="hidden" name="action" value="search"/>
    <input class="form-control mr-sm-2" type="text" name="employee_name" placeholder="Search Name" aria-label="Search">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit"><i class="fas fa-search " style="font-size:24px;"></i></button>
</form>
<div align="center">
    <caption><h2>List of Employees</h2></caption>
    <table id="tableEmployee" class="table table-striped table-bordered table-hover table-dark" style=" width: 100% ">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Birthday</th>
                <th>Id Card</th>
                <th>Salary</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Position Id</th>
                <th>Education Degree</th>
                <th>Division Id</th>
                <th>User Name</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="employee" items="${employeeList}">
                <tr>
                    <td><c:out value="${employee.getEmployeeId()}"/></td>
                    <td><c:out value="${employee.getEmployeeName()}"/></td>
                    <td><c:out value="${employee.getEmployeeBirthday()}"/></td>
                    <td><c:out value="${employee.getEmployeeIdCard()}"/></td>
                    <td><c:out value="${employee.getEmployeeSalary()}"/></td>
                    <td><c:out value="${employee.getEmployeePhone()}"/></td>
                    <td><c:out value="${employee.getEmployeeEmail()}"/></td>
                    <td><c:out value="${employee.getEmployeeAddress()}"/></td>
                    <td><c:out value="${employee.getPositionId()}"/></td>
                    <td><c:out value="${employee.getEducationDegree()}"/></td>
                    <td><c:out value="${employee.getDivisionId()}"/></td>
                    <td><c:out value="${employee.getUsername()}"/></td>
                    <td>
                        <a class="btn btn-warning" href="/employees?action=edit&employee_id=${employee.getEmployeeId()}">Edit</a>
<%--                        <a class="btn btn-danger" href="/employees?action=delete&employee_id=${employee.getEmployeeId()}">Delete</a>--%>
                        <a class="btn btn-danger" href="#"
                           onclick="customerSetId('${employee.getEmployeeId()}','${employee.getEmployeeName()}')"
                           data-toggle="modal" data-target="#deleteModel">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<div class="modal fade" id="deleteModel" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <input type="text" id="modelId" size="50" disabled style="border: none;background: white">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" onclick="submitDelete()">Delete</button>
            </div>
        </div>
    </div>
</div>

<form action="/employees" id="deleteEmp">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="employee_id" id="employeeId">
</form>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>

<script>
    $(document).ready(function () {
        $('#tableEmployee').dataTable({
            "dom" : 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });
</script>
<script>
    function submitDelete() {
        document.getElementById("deleteEmp").submit();
    }

    function customerSetId(id, name) {
        document.getElementById("employeeId").value = id;
        document.getElementById("modelId").value = "Do you want delete employee name: " + name;
    }
</script>
</body>
</html>
