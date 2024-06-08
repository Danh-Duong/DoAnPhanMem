<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chi Tiết Nhân Khẩu</title>
    <link rel="stylesheet" href="css/style_header.css">
    <link rel="stylesheet" href="css/style_footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://kit.fontawesome.com/e3729928c9.js" crossorigin="anonymous"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            display: flex;
            margin: 20px auto;
            width: 90%;
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        .sidebar {
            width: 20%;
            background: #fff;
            border-right: 1px solid #ddd;
            padding: 20px;
        }

        .content {
            width: 80%;
            padding: 20px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
        }

        .table th, .table td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        .table th {
            background-color: #f2f2f2;
            color: black;
        }

        .table tbody tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        .table tbody tr:hover {
            background-color: #f1f1f1;
        }

        .button-group {
            text-align: center;
            margin-top: 20px;
        }

        button {
            padding: 10px 20px;
            margin: 5px;
            border: none;
            background-color: #ff4500;
            color: white;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #e03e00;
        }

        a {
            color: #ff4500;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>

    <div class="container">
        <div class="sidebar">
            <%@ include file="banner.jsp" %>
        </div>
        <div class="content">
            <h2>Chi tiết nhân khẩu</h2> 
            <div>
                <a href="/demo/account/create">Thêm thông tin nhân khẩu mới</a>
            </div>
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">ID Hộ Khẩu</th>
                        <th scope="col">Tên Công Nhân</th>
                        <th scope="col">CCCD</th>
                        <th scope="col">Ngày Sinh</th>
                        <th scope="col">Email</th>
                        <th scope="col">Giới Tính</th>
                        <th scope="col">SDT</th>
                        <th scope="col">Thường Trú</th>
                        <th scope="col">Nơi Ở Hiện Tại</th>
                        <th scope="col">Nơi Sinh</th>
                        <th scope="col">Quan Hệ</th>
                        <th scope="col">Quốc Tịch</th>
                        <th scope="col">Dân Tộc</th>
                        <th scope="col">Nghề Nghiệp</th>
                        <th scope="col">Tình Trạng Cư Trú</th>
                        <th scope="col">Học Vấn</th>
                        <th scope="col">Hôn Nhân</th>
                        <th scope="col">Ngày Cập Nhật</th>
                        <th scope="col">Ghi Chú</th>
                        <th scope="col">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="x" items="${sessionScope.listUser}">
                        <tr>
                            <td>${x.idNhanKhau }</td>
                            <td>${x.hoKhau.idHoKhau }</td>
                            <td>${x.tenCongDan }</td>
                            <td>${x.cccd }</td>
                            <td>
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${x.ngaySinh }" />
                            </td>
                            <td>${x.email }</td>
                            <td>${x.gioiTinh }</td>
                            <td>${x.sdt }</td>
                            <td>${x.diaChiThuongTru }</td>
                            <td>${x.noiOHienTai }</td>
                            <td>${x.noiSinh }</td>
                            <td>${x.quanHe }</td>
                            <td>${x.quocTich }</td>
                            <td>${x.danToc }</td>
                            <td>${x.ngheNghiep }</td>
                            <td>${x.tinhTrangCuTru }</td>
                            <td>${x.tinhTrangHocVan }</td>
                            <td>${x.tinhTrangHonNhan }</td>
                            <td>
                                <fmt:formatDate pattern="yyyy-MM-dd" value="${x.ngayCapNhat }" />
                            </td>
                            <td>${x.ghiChu }</td>
                            <td>
                                <c:url value="/account/edit" var="edit">
                                    <c:param name="idNhanKhau" value="${x.idNhanKhau }" />
                                </c:url>
                                
                                <c:url value="/account/delete" var="delete">
                                    <c:param name="idNhanKhau" value="${x.idNhanKhau }" />
                                </c:url>
                                <a href="${edit }">Chỉnh</a>
                                <a href="${delete }">Xóa</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
