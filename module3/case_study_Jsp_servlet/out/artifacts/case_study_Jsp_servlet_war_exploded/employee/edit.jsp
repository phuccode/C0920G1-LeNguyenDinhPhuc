<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/22/2020
  Time: 9:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employees?action=employees">List All Employees</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Employee
                </h2>
            </caption>
            <c:if test="${employee != null}">
                <input type="hidden" name="employee_id" value="<c:out value='${employee.getEmployeeId()}' />"/>
            </c:if>
            <tr>
                <th>Employee Name:</th>
                <td>
                    <input type="text" name="employee_name" size="45"
                           value="<c:out value='${employee.getEmployeeName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Birthday:</th>
                <td>
                    <input type="text" name="employee_birthday" size="45"
                           value="<c:out value='${employee.getEmployeeBirthday()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Id Card:</th>
                <td>
                    <input type="text" name="employee_id_card" size="45"
                           value="<c:out value='${employee.getEmployeeIdCard()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Salary:</th>
                <td>
                    <input type="text" name="employee_salary" size="45"
                           value="<c:out value='${employee.getEmployeeSalary()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Phone:</th>
                <td>
                    <input type="text" name="employee_phone" size="45"
                           value="<c:out value='${employee.getEmployeePhone()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Email:</th>
                <td>
                    <input type="text" name="employee_email" size="45"
                           value="<c:out value='${employee.getEmployeeEmail()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Employee Address:</th>
                <td>
                    <input type="text" name="employee_address" size="45"
                           value="<c:out value='${employee.getEmployeeAddress()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Position Id:</th>
                <td>
                    <input type="number" name="position_id" size="45"
                           value="<c:out value='${employee.getPositionId()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Education Degree Id:</th>
                <td>
                    <input type="number" name="education_degree_id" size="45"
                           value="<c:out value='${employee.getEducationDegree()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Division Id:</th>
                <td>
                    <input type="number" name="division_id" size="45"
                           value="<c:out value='${employee.getDivisionId()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>User Name:</th>
                <td>
                    <input type="text" name="user_name" size="45"
                           value="<c:out value='${employee.getUsername()}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
