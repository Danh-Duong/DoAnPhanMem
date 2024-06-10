<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script src="https://kit.fontawesome.com/e3729928c9.js" crossorigin="anonymous"></script>

<title>Chi tiết tạm trú</title>

<!-- Bootstrap Core CSS -->
<link href="css/report/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="css/report/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="css/report/dataTables/dataTables.bootstrap.css" rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="css/report/dataTables/dataTables.responsive.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/report/startmin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="css/report/font-awesome.min.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/report/table.css">
<link rel="stylesheet" href="css/report/index.css">
<link rel="stylesheet" href="css/dangkykhaisinh.css">

</head>

<body>

    <jsp:include page="banner.jsp"></jsp:include>

    <div id="page-wrapper" style="min-height: 279px;">
        <div class="container-fluid">

            <div style="padding: 24px 45px 22px; background-color: #f8f8f8; margin: 48px 165px 30px;">
                <p class="title">HỒ SƠ ĐĂNG KÍ TẠM TRÚ</p>

                <div class="info">
                    <p class="info-title">
                        Mã hồ sơ: <span style="font-size: 20px; font-weight: 600">${tamtru.maTamTru}</span>
                    </p>
                </div>

                <div>
                    <div class="section">
                        <div class="info-detail">
                            <p class="subtitle" style="margin: 10px 0 0; font-weight: 600;">CƠ QUAN THỰC HIỆN</p>
                            <div class="line"></div>
                            <div class="row">
                                <div class="col-md-4">
                                    <p class="info-title1">Tỉnh/Thành phố:</p>
                                    <input type="text" id="thanhpho" value="Đà Nẵng" name="thanhPho">
                                </div>
                                <div class="col-md-4">
                                    <p class="info-title1">Quận/Huyện:</p>
                                    <input type="text" id="quanHuyen" value="Hải Châu" name="quanHuyen">
                                </div>
                                <div class="col-md-4">
                                    <p class="info-title1">Phường/Xã:</p>
                                    <input type="text" id="phuongXa" value="Thanh Bình" name="phuongXa">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <p class="info-title1">Cơ quan thực hiện:</p>
                                    <input class="info-value" name="coQuanThucHien" value="Công an phường Thanh Bình">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="section">
                        <div class="info-detail">
                            <p class="subtitle" style="margin: 10px 0 0; font-weight: 600;">THÔNG TIN NGƯỜI KHAI BÁO TẠM TRÚ</p>
                            <div class="line"></div>
                            <div class="row">
                                <div class="col-md-4">
                                    <p class="info-title1">Họ tên:</p>
                                    <input class="info-value" name="hoTen" value="${nhankhau.tenCongDan}">
                                </div>
                                <div class="col-md-4">
                                    <p class="info-title1">Ngày, tháng, năm sinh:</p>
                                    <input class="info-value" name="ngaySinh" value="${ns}">
                                </div>
                                <div class="col-md-4">
                                    <p class="info-title1">Giới tính:</p>
                                    <c:if test="${nhankhau.gioiTinh=='F'}">
                                        <input class="info-value" name="gioiTinh" value ="Nữ">
                                    </c:if>
                                    <c:if test="${nhankhau.gioiTinh=='M'}">
                                        <input class="info-value" name="gioiTinh" value ="Nam">
                                    </c:if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <p class="info-title1">Số CCCD:</p>
                                    <input class="info-value" name="soCCCD" value= "${nhankhau.cccd}">
                                </div>
                                <div class="col-md-4">
                                    <p class="info-title1">Quốc tịch:</p>
                                    <input class="info-value" name="quocTich" value="${nhankhau.quocTich}">
                                </div>
                                <div class="col-md-4">
                                    <p class="info-title1">Số điện thoại:</p>
                                    <input class="info-value" name="soDT" value="${nhankhau.sdt}">
                                </div>
                            </div>

                            <div class="row">
                                <div class="col-md-12">
                                    <p class="info-title1">Địa chỉ cụ thể hiện tại:</p>
                                    <input class="info-value" name="diaChiCuTheHienTai" value="${nhankhau.noiOHienTai}">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="section">
                        <div class="info-detail">
                            <p class="subtitle" style="margin: 10px 0 0; font-weight: 600;">THÔNG TIN ĐĂNG KÍ TẠM TRÚ</p>
                            <div class="line"></div>

                            <div class="row">
                                <div class="col-md-12">
                                    <p class="info-title1">Địa chỉ cụ thể tạm trú:</p>
                                    <input class="info-value" name="diaChiTamTru" value="${tamtru.diaChiTamTru}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-4">
                                    <p class="info-title1">Tạm trú từ ngày:</p>
                                    <input class="info-value" name="ngayBatDauTru" value="${ngayBatDau}">
                                </div>
                                <div class="col-md-4">
                                    <p class="info-title1">Đến ngày:</p>
                                    <input class="info-value" name="ngayKetThucTru" value="${ngayKetThuc}">
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <p class="info-title1">Lý do tạm trú:</p>
                                    <input class="info-value" name="lyDo" value="${tamtru.lyDo}">
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="action">
                        <a href="duyetTamTru"><button class="cancel" style="margin: 0 8px; background: #db3d3d;">Trở lại</button></a>
                        <c:if test="${trangthai=='0'}">
                            <button class="cancel" onclick="remove()" style="margin: 0 8px">Hủy hồ sơ</button>
                            <button style="margin: 0 8px" class="submit" onclick="submit()">Duyệt hồ sơ</button>
                        </c:if>
                    </div>

                    <script>
                        function submit() {
                            window.location.href = "duyetTamTru?type=yes&mahs=${tamtru.maTamTru}";
                        }

                        function remove() {
                            window.location.href = "duyetTamTru?type=no&mahs=${tamtru.maTamTru}";
                        }
                    </script>

                </div>

            </div>

        </div>
        <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->

    <!-- jQuery -->
    <script src="js/report/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/report/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="js/report/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="js/report/dataTables/jquery.dataTables.min.js"></script>
    <script
