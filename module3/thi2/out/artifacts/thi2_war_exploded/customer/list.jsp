<%--
  Created by IntelliJ IDEA.
  User: PC
  Date: 12/18/2020
  Time: 4:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
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
    <h1>Quản lý Bệnh án</h1>
</center>
<div align="center">
    <caption><h2>Danh sách Bệnh Án</h2></caption>
    <table id="tableCustomer" class="table table-striped table-bordered table-hover table-dark" style=" width: 100% ">
        <thead>
            <tr>
                <th>Mã bệnh nhân</th>
                <th>Tên bệnh nhân</th>
                <th>Ngày nhập viện</th>
                <th>Ngày ra viện</th>
                <th>lý do nhập viện</th>
                <th>Mã bệnh án</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="benhnhan" items="${benhNhanList}">
                <tr>
                    <td scope="row"><c:out value="${benhnhan.getMaBenhNhan()}"/></td>
                    <td><c:out value="${benhnhan.getTenBenhNhan()}"/></td>
                    <td><c:out value="${benhnhan.getNgayNhapVien()}"/></td>
                    <td><c:out value="${benhnhan.getNgayRaVien()}"/></td>
                    <td><c:out value="${benhnhan.getLyDoNhapVien()}"/></td>
                    <td><c:out value="${benhnhan.getMaBenhAn()}"/></td>
                    <td>
                        <a class="btn btn-warning" href="/customers?action=edit&ma_benh_nhan=${benhnhan.getMaBenhNhan()}">Edit</a>
<%--                        <a class="btn btn-danger" href="/customers?action=delete&customer_id=${customer.getCustomerId()}">Delete</a>--%>
                        <a class="btn btn-danger" href="#"
                           onclick="customerSetId('${benhnhan.getMaBenhNhan()}','${benhnhan.getTenBenhNhan()}')"
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

<form action="/customers" id="deleteCus">
    <input type="hidden" name="action" value="delete">
    <input type="hidden" name="ma_benh_nhan" id="customerId">
</form>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script src="/jquery/jquery-3.5.1.min.js"></script>
<script src="/bootstrap413/js/popper.min.js"></script>
<script src="/datatables/js/jquery.dataTables.min.js"></script>
<script src="/datatables/js/dataTables.bootstrap4.min.js"></script>
<script>
    $(document).ready(function () {
        $('#tableCustomer').dataTable({
            "dom" : 'lrtip',
            "lengthChange": false,
            "pageLength": 3
        });
    });
</script>
<script>
    function submitDelete() {
        document.getElementById("deleteCus").submit();
    }

    function customerSetId(id, name) {
        document.getElementById("customerId").value = id;
        document.getElementById("modelId").value = "bạn muốn xóa bệnh án của bệnh nhân " + name;
    }
</script>
</body>
</html>