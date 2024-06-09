<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hồ Sơ Khai Báo Tạm Vắng</title>
    <link rel="stylesheet" href="css/style_header.css">
    <link rel="stylesheet" href="css/style_footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://kit.fontawesome.com/e3729928c9.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style_tamvang.css"> <!-- CSS riêng cho trang tamvang.jsp -->
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            width: 80%;
            margin: 20px auto;
            background: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #ff4500;
        }

        .form-section {
            margin-bottom: 20px;
        }

        .form-section h3 {
            margin-bottom: 15px;
            color: #333;
        }

        .form-group {
            margin-bottom: 15px;
            display: flex;
            flex-wrap: wrap;
        }

        .form-group label {
            flex: 1 0 25%;
            padding-right: 10px;
            box-sizing: border-box;
        }

        .form-group input[type="text"],
        .form-group input[type="date"],
        .form-group select {
            flex: 1 0 70%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
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
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>
    <%@ include file="banner.jsp" %>

    <div class="container">
        <h2>HỒ SƠ KHAI BÁO TẠM VẮNG</h2>

        <form action="/demo/account/tamvang" method="post">
            <div class="form-section">
                <div class="form-group">
                    <label for="maTamVang">Mã tạm vắng:</label>
                    <input type="text" id="maTamVang" name="maTamVang" required>
                </div>
                <div class="form-group">
                    <label for="ngayDangKi">Ngày đăng ký:</label>
                    <input type="date" id="ngayDangKi" name="ngayDangKi" required>
                </div>
                
                <div class="form-group">
                    <label for="diaChiDen">Địa chỉ đến:</label>
                    <input type="text" id="diaChiDen" name="diaChiDen" required>
                </div>
                <div class="form-group">
                    <label for="lyDo">Lý do:</label>
                    <input type="text" id="lyDo" name="lyDo" required>
                </div>
                <div class="form-group">
                    <label for="idNhanKhau">ID nhân khẩu:</label>
                     <select class="form-select" name="idNhanKhau" aria-label="Default select example" required>
                        <option disabled selected="selected" value="">Chọn</option>
                        <c:forEach var="x" items="${sessionScope.listNhanKhau}">
                            <option value="${x.idNhanKhau}">${x.idNhanKhau}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="ngayBatDau">Ngày bắt đầu:</label>
                    <input type="date" id="ngayBatDau" name="ngayBatDau" required>
                </div>
                <div class="form-group">
                    <label for="ngayKetThuc">Ngày kết thúc:</label>
                    <input type="date" id="ngayKetThuc" name="ngayKetThuc" required>
                </div>
                <div class="form-group">
                    <label for="trangThaiDuyet">Trạng thái duyệt:</label>
                    <select id="trangThaiDuyet" name="trangThaiDuyet" required>
                        <option value="cho_duyet">Chờ duyệt</option>
                        <option value="da_duyet">Đã duyệt</option>
                        <option value="tu_choi">Từ chối</option>
                    </select>
                </div>
            </div>

            <div class="button-group">
                <button type="submit">Gửi</button>
                <button type="reset">Nhập lại</button>
            </div>
        </form>
        ${mess }
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
