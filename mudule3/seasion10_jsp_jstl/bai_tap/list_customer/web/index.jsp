<%@ page import="model.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="model.CustomerDAO" %><%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/15/2020
  Time: 11:10 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
    <meta charset="UTF-8">
  </head>
  <body>
  <%
      List<Customer> list = CustomerDAO.getCustomerList();
      request.setAttribute("list",list);
  %>
  <table>
        <tr>
          <th>Tên</th>
          <th>Ngày Sinh</th>
          <th>Địa Chỉ</th>
          <th>Ảnh</th>
        </tr>
    <tbody>
        <c:forEach var="customer" items="${list}">
            <tr>
                <td><c:out value="${customer.name}"/></td>
                <td><c:out value="${customer.birthday}"/></td>
                <td><c:out value="${customer.address}"/></td>
                <td><img <c:out value="${customer.birthday}"/> ></td>
            </tr>
        </c:forEach>
    </tbody>
  </table>
  </body>
</html>
