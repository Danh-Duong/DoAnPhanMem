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
<script src="https://kit.fontawesome.com/e3729928c9.js"
	crossorigin="anonymous"></script>

<title>Chi tiết khai sinh</title>

<!-- Bootstrap Core CSS -->
<link href="css/report/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="css/report/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="css/report/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="css/report/dataTables/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="css/report/startmin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="css/report/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="css/report/table.css">
<link rel="stylesheet" href="css/report/index.css">
<link rel="stylesheet" href="css/dangkykhaisinh.css">

</head>

<body>

	<jsp:include page="banner.jsp"></jsp:include>

	<div id="page-wrapper" style="min-height: 279px;">
		<div class="container-fluid">

			<div
				style="padding: 24px 45px 22px; background-color: #f8f8f8; margin: 48px 165px 30px;">
				<p class="title">HỒ SƠ ĐĂNG KÍ TẠM TRÚ</p>

				<div class="info">
					<p class="info-title">
						Mã hồ sơ: <span style="font-size: 20px; font-weight: 600">
							${tamtru.maTamTru}</span>
					</p>
				</div>

				<div>
					<div class="section">
						<div class="info-detail">
							<p class="subtitle">CƠ QUAN THỰC HIỆN</p>
							<div class="line"></div>
							<div class="row">
								<div class="col-md-4">
									<p class="info-title1">Tỉnh/Thành phố:</p>
									<input type="text" id="thanhpho" value="Đà Nẵng"
										name="thanhPho">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Quận/Huyện:</p>
									<input type="text" id="thanhpho" value="Hải Châu"
										name="thanhPho">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Phường/Xã:</p>
									<input type="text" id="thanhpho" value="Thanh Bình"
										name="thanhPho">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Cơ quan thực hiện:</p>
									<input class="info-value" name="coQuanThucHien" type="text"
										value="Công an phường Thanh Bình">
								</div>
							</div>
						</div>
					</div>
					<div class="section">
						<div class="info-detail">
							<p class="subtitle">THÔNG TIN NGƯỜI KHAI BÁO TẠM TRÚ</p>
							<div class="line"></div>
							<div class="row">
								<div class="col-md-4">
									<p class="info-title1">Họ tên</p>
									<input class="info-value" name="hoTen" type="text" value="${tamtru.hoten}">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Ngày, tháng, năm sinh</p>
									<input class="info-value" name="ngaySinh" value="${ns}">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Giới tính:</p>
									<input class="info-value" name="gioiTinh" type="text" value="${tamtru.gioiTinh}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<p class="info-title1">Số CCCD:</p>
									<input class="info-value" name="cccd" type="text" value="${tamtru.cccd}">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Quốc tịch:</p>
									<input class="info-value" name="quocTich" type="text" value="${tamtru.quocTinh}">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Số điện thoại:</p>
									<input class="info-value" name="soDT" type="text" value="${tamtru.soDt}">
								</div>
							</div>
							<!-- <div class="row">
							<div class="col-md-4">
								<p class="info-title1">Tỉnh/Thành phố:</p>
								<input type="text" id="thanhpho" value="Đà Nẵng" name="thanhPho">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Quận/Huyện:</p>
								<select class="form-select" aria-label="Default select example"
									name="quanHuyen">
									<option selected>Chọn quận/huyện</option>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Phường/Xã:</p>
								<select class="form-select" aria-label="Default select example"
									name="phuongXa">
									<option selected>Chọn phường/xã</option>
								</select>
							</div>
						</div> -->
							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Địa chỉ cụ thể:</p>
									<input class="info-value" name="diaChiCuThe" type="text" value="${tamtru.diaChi}">
								</div>
							</div>
						</div>
					</div>
					<div class="section">
						<div class="info-detail">
							<p class="subtitle">THÔNG TIN ĐĂNG KÍ TẠM VẮNG</p>
							<div class="line"></div>
							<!-- <div class="radio-select">
							<p>Trường hợp đăng kí:</p>

							 
							<div class="radio-item">
								<input type="radio" id="old" name="tamtru" value="old">
								<label for="old">Đăng kí tạm trú vào hộ đã có</label>
							</div>
							<div class="radio-item">
								<input type="radio" id="new" name="tamtru" value="new">
								<label for="new">Đăng kí lập hộ mới</label>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<p class="info-title1">Tỉnh/Thành phố:</p>
								<input type="text" id="thanhpho" value="Đà Nẵng" name="thanhPho">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Quận/Huyện:</p>
								<select class="form-select" aria-label="Default select example"
									name="quanHuyen">
									<option selected>Chọn quận/huyện</option>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Phường/Xã:</p>
								<select class="form-select" aria-label="Default select example"
									name="phuongXa">
									<option selected>Chọn phường/xã</option>
								</select>
							</div>
						</div> -->
							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Địa chỉ cụ thể:</p>
									<input class="info-value" name="diaChiTamTru" type="text" value="${tamtru.diaChiDangKi}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<p class="info-title1">Họ tên chủ hộ:</p>
									<input class="info-value" name="hoTenChuHo" type="text" value="${tamtru.hoTenChuho}">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Quan hệ với chủ hộ:</p>
									<input class="info-value" name="quanHeChuHo" type="text" value="${tamtru.quanHeChuHo}">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Số CCCD chủ hộ:</p>
									<input class="info-value" name="socccdChuHo" type="text" value="${tamtru.cccdChuHo}">
								</div>
							</div>

						</div>
					</div>

					<div class="action">
						<a href="duyetKhaiSinh"><button class="cancel"
								style="margin: 0 8px; background: #db3d3d;">Trở lại</button></a>
						<c:if test="${trangthai=='0'}">
							<button class="cancel" onclick="remove()" style="margin: 0 8px">Hủy
								hồ sơ</button>
							<button style="margin: 0 8px" class="submit" onclick="submit()">Duyệt
								hồ sơ</button>
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

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/report/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/report/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/report/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="js/report/dataTables/jquery.dataTables.min.js"></script>
	<script src="js/report/dataTables/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/report/startmin.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>



</body>
</html>