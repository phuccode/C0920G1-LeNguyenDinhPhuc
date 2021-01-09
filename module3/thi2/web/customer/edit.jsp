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
<div align="center">
    <form method="post">
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    Chỉnh sửa bệnh án
                </h2>
            </caption>
            <c:if test="${benhNhan != null}">
                <input type="hidden" name="ma_benh_nhan" value="<c:out value='${benhNhan.getMaBenhNhan()}' />"/>
            </c:if>
            <tr>
                <th>Tên:</th>
                <td>
                    <input type="text" name="ten_benh_nhan" size="45"
                           value="<c:out value='${benhNhan.getTenBenhNhan()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngày nhập:</th>
                <td>
                    <input type="text" name="ngay_nhap_vien" size="45"
                           value="<c:out value='${benhNhan.getNgayNhapVien()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ngày ra:</th>
                <td>
                    <input type="text" name="ngay_ra_vien" size="45"
                           value="<c:out value='${benhNhan.getNgayRaVien()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Ly do nhập viện:</th>
                <td>
                    <input type="text" name="ly_do_nhap_vien" size="45"
                           value="<c:out value='${benhNhan.getLyDoNhapVien()}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Mã bệnh án:</th>
                <td>
                    <input type="text" name="ma_benh_an" size="45"
                           value="<c:out value='${benhNhan.getMaBenhAn()}' />"
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
