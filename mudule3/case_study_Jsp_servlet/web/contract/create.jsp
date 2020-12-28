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
</head>
<body>
<center>
    <h1>Contract Management</h1>
    <h2>
        <a href="/contracts?action=contracts">List All Contracts</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>Add New Contract</h2>
            </caption>
            <tr>
                <th>Contract Start Date:</th>
                <td>
                    <input type="text" name="contract_start_date" id="contract_start_date" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Contract End Date:</th>
                <td>
                    <input type="text" name="contract_end_date" id="contract_end_date" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Contract Deposit:</th>
                <td>
                    <input type="text" name="contract_deposit" id="contract_deposit" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Contract Total Money:</th>
                <td>
                    <input type="text" name="contract_total_money" id="contract_total_money" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Employee Id:</th>
                <td>
                    <input type="text" name="employee_id" id="employee_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Customer Id:</th>
                <td>
                    <input type="text" name="customer_id" id="customer_id" size="45"/>
                </td>
            </tr>
            <tr>
                <th>Service Id:</th>
                <td>
                    <input type="text" name="service_id" id="service_id" size="45"/>
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
