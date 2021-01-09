<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/21/2020
  Time: 11:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="customers?action=customers">List All Customers</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Edit Customer
                </h2>
            </caption>
            <c:if test="${customer != null}">
                <input type="hidden" name="customer_id" value="<c:out value='${customer.getCustomerId()}' />"/>
            </c:if>
            <tr>
                <th>Customer Type Id:</th>
                <td>
                    <input type="text" name="customer_type_id" size="45"
                           value="<c:out value='${customer.getCustomerTypeId()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Name:</th>
                <td>
                    <input type="text" name="customer_name" size="45"
                           value="<c:out value='${customer.getCustomerName()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Birthday:</th>
                <td>
                    <input type="text" name="customer_birthday" size="45"
                           value="<c:out value='${customer.getCustomerBirthday()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Gender:</th>
                <td>
                    <input type="text" name="customer_gender" size="45"
                           value="<c:out value='${customer.getCustomerGender()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Id Card:</th>
                <td>
                    <input type="text" name="customer_id_card" size="45"
                           value="<c:out value='${customer.getCustomerIdCard()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Phone:</th>
                <td>
                    <input type="text" name="customer_phone" size="45"
                           value="<c:out value='${customer.getCustomerPhone()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Email:</th>
                <td>
                    <input type="text" name="customer_email" size="45"
                           value="<c:out value='${customer.getCustomerEmail()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Customer Address:</th>
                <td>
                    <input type="text" name="customer_address" size="45"
                           value="<c:out value='${customer.getCustomerAddress()}' />"
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
