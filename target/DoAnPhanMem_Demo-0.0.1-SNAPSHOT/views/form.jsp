<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Thêm nhân khẩu mới</title>
    <link rel="stylesheet" href="css/style_header.css">
    <link rel="stylesheet" href="css/style_footer.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <script src="https://kit.fontawesome.com/e3729928c9.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/style_form.css"> <!-- CSS riêng cho trang form.jsp -->
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
        .form-group input[type="email"],
        .form-group select,
        .form-group textarea {
            flex: 1 0 70%;
            padding: 8px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .form-group textarea {
            height: 100px;
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
        <h2>Tạo Nhân Khẩu</h2>

        <form action="/demo/account/add" autocomplete="off" method="post">
            <div class="form-section">
                <div class="form-group">
                    <label for="idNhanKhau">ID</label>
                    <input type="text" class="form-control" id="idNhanKhau" name="idNhanKhau" value="${edit.idNhanKhau}" required="required" placeholder="Id">
                </div>
                <div class="form-group">
                    <label for="idHoKhau">Hộ Khẩu</label>
                    <select class="form-select" name="idHoKhau" aria-label="Default select example">
                        <option disabled selected="selected">Chọn</option>
                        <c:forEach var="x" items="${sessionScope.listHoKhau}">
                            <option value="${x.idHoKhau}" ${edit.hoKhau.idHoKhau.equals(x.idHoKhau) ? 'selected="selected"' : ''}>${x.idHoKhau}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="tenCongDan">Họ Tên</label>
                    <input type="text" class="form-control" id="tenCongDan" name="tenCongDan" value="${edit.tenCongDan}" required="required" placeholder="Họ Tên">
                </div>
                <div class="form-group">
                    <label for="cccd">CCCD</label>
                    <input type="text" class="form-control" id="cccd" name="cccd" value="${edit.cccd}" required="required" placeholder="CCCD">
                </div>
                <fmt:formatDate var="date" pattern="yyyy-MM-dd" value="${edit.ngaySinh}" />
                <div class="form-group">
                    <label for="ngaySinh">Ngày sinh</label>
                    <input type="date" class="form-control" id="ngaySinh" name="ngaySinh" value="${date}" required="required" placeholder="Ngày Sinh">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="${edit.email}" required="required" placeholder="Email">
                </div>
                <div class="form-group">
                    <label>Giới tính</label>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="nam" name="gioiTinh" value="M" ${edit.gioiTinh.equals('M') ? 'checked="checked"' : ''}>
                        <label class="form-check-label" for="nam">Nam</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" id="nu" name="gioiTinh" value="F" ${edit.gioiTinh.equals('F') ? 'checked="checked"' : ''}>
                        <label class="form-check-label" for="nu">Nữ</label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="sdt">SDT</label>
                    <input type="text" class="form-control" id="sdt" name="sdt" value="${edit.sdt}" required="required" placeholder="SDT">
                </div>
                <div class="form-group">
                    <label for="diaChiThuongTru">Địa chỉ thường trú</label>
                    <input type="text" class="form-control" id="diaChiThuongTru" name="diaChiThuongTru" value="${edit.diaChiThuongTru}" required="required" placeholder="Địa chỉ thường chú">
                </div>
                <div class="form-group">
                    <label for="noiOHienTai">Nơi ở hiện tại</label>
                    <input type="text" class="form-control" id="noiOHienTai" name="noiOHienTai" value="${edit.noiOHienTai}" required="required" placeholder="Nơi ở hiện tại">
                </div>
                <div class="form-group">
                    <label for="noiSinh">Nơi sinh</label>
                    <input type="text" class="form-control" id="noiSinh" name="noiSinh" value="${edit.noiSinh}" required="required" placeholder="Nơi sinh">
                </div>
                <div class="form-group">
                    <label for="quanHe">Quan Hệ</label>
                    <input type="text" class="form-control" id="quanHe" name="quanHe" value="${edit.quanHe}" required="required" placeholder="Quan Hệ">
                </div>
                <div class="form-group">
                    <label for="quocTich">Quốc Tịch</label>
                    <input type="text" class="form-control" id="quocTich" name="quocTich" value="${edit.quocTich}" required="required" placeholder="Quốc Tịch">
                </div>
                <div class="form-group">
                    <label for="danToc">Dân Tộc</label>
                    <input type="text" class="form-control" id="danToc" name="danToc" value="${edit.danToc}" required="required" placeholder="Dân Tộc">
                </div>
                <div class="form-group">
                    <label for="ngheNghiep">Nghề Nghiệp</label>
                    <input type="text" class="form-control" id="ngheNghiep" name="ngheNghiep" value="${edit.ngheNghiep}" required="required" placeholder="Nghề Nghiệp">
                </div>
                <div class="form-group">
                    <label for="tinhTrangCuTru">Tình trạng cư trú</label>
                    <input type="text" class="form-control" id="tinhTrangCuTru" name="tinhTrangCuTru" value="${edit.tinhTrangCuTru}" required="required" placeholder="Tình trạng cư trú">
                </div>
                <div class="form-group">
                    <label for="tinhTrangHocVan">Tình trạng học vấn</label>
                    <input type="text" class="form-control" id="tinhTrangHocVan" name="tinhTrangHocVan" value="${edit.tinhTrangHocVan}" required="required" placeholder="Tình trạng học vấn">
                </div>
                <div class="form-group">
                    <label for="tinhTrangHonNhan">Tình trạng hôn nhân</label>
                    <input type="text" class="form-control" id="tinhTrangHonNhan" name="tinhTrangHonNhan" value="${edit.tinhTrangHonNhan}" required="required" placeholder="Tình trạng hôn nhân">
                </div>
                <div class="form-group">
                    <label for="ghiChu">Ghi chú</label>
                    <textarea type="text" class="form-control" id="ghiChu" name="ghiChu" placeholder="Ghi Chú">${edit.ghiChu}</textarea>
                </div>
            </div>
            <div class="button-group">
                <button class="btn btn-primary btn-login text-uppercase m-2 fw-bold" type="submit">Tạo</button>
                <button formaction="/demo/account/update" class="btn btn-primary btn-login text-uppercase m-2 fw-bold" type="submit">Cập nhật</button>
            </div>
        </form>
        <div class="button-group">
            <a href="/demo/account/list" class="btn btn-secondary">Xem danh sách</a>
        </div>
        ${mess}
    </div>

    <%@ include file="footer.jsp" %>
</body>
</html>
