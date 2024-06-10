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

<title>Chi tiết khai tử</title>

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
					style="padding: 24px 45px 22px;
    background-color: #f8f8f8;
    margin: 48px 165px 30px;">
					<p class="title">HỒ SƠ ĐĂNG KÍ KHAI TỬ</p>
					
					<div class="info">
						<p class="info-title">
							Mã hồ sơ: <span style="font-size: 20px; font-weight: 600">
								${khaitu.maKhaiTu}</span>
						</p>
					</div>
					
					<div>
						<div class="info">
							<p class="info-title">Họ, chữ đệm, tên người yêu cầu:</p>
							<input name="hoTenNguoiKhai" value="${khaitu.hoTenNguoiKhai}">
						</div>
						<div class="info">
							<p class="info-title">Nơi cư trú</p>
							<input name="noiCuTruNguoiKhai" value="${khaitu.noiCuTruNguoiKhai}">
						</div>
						<div class="info">
							<p class="info-title">Quan hệ với người mất</p>
							<input name="quanHeVoiNguoiMat" value="${khaitu.quanHeVoiNguoiMat}">
						</div>
						<div>
							<p style="margin-top: 10px;">Thông tin khai tử:</p>
							<div class="info-detail">
								<div class="row">
									<div class="col-md-6">
										<p class="info-title1">Họ, chữ đệm, tên</p>
										<input class="info-value" name="hoTenNguoiMat" value="${khaitu.hoTenNguoiMat}">
									</div>
									<div class="col-md-6">
										<p class="info-title1">Ngày, tháng, năm sinh</p>
										<input class="info-value" name="ngaySinh" value="${ngaysinh}">
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<p class="info-title1">Nơi sinh:</p>
										<input class="info-value" name="noiSinh" value="${khaitu.noiSinh}">
									</div>
								</div>

								<div class="row">
								<div class="col-md-4">
									<p class="info-title1">Giới tính:</p>
									<c:if test="${khaitu.gioiTinh=='M'}">
										<input readonly="readonly" class="info-value" name="gioiTinh"
											value="Nam">
									</c:if>
									<c:if test="${khaitu.gioiTinh!='M'}">
										<input readonly="readonly" class="info-value" name="gioiTinh"
											value="Nữ">
									</c:if>

								</div>
								<div class="col-md-4">
									<p class="info-title1">Dân tộc:</p>
									<input readonly="readonly" class="info-value" name=danToc
										value="${khaitu.danToc}">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Quốc tịch:</p>
									<input readonly="readonly" class="info-value" name=quocTich
										value="${khaitu.quocTich}">
								</div>
							</div>

								<div class="row">
									<div class="col-md-12">
										<p class="info-title1">Nơi cư trú cuối cùng:</p>
										<input class="info-value" name="noiCuTruCuoiCung" value="${khaitu.noiCuTruCuoiCung}">
									</div>
								</div>

								<div class="row">
									<p class="info-title1" style="width: 400px; margin-left: 15px; margin-bottom: 0px;">Đã mất vào
										lúc:</p>
									<div class="col-md-6">
										<p class="info-title1">Ngày</p>
										<input class="info-value" name="ngayMat" value="${ngaymat}">
									</div>
									<div class="col-md-6">
										<p class="info-title1">Giờ</p>
										<input class="info-value" name="gioMat" value="${khaitu.gioMat}">
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<p class="info-title1">Nơi mất</p>
										<input class="info-value" name="noiMat" value="${khaitu.noiCuTruCuoiCung}">
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<p class="info-title1">Nguyên nhân</p>
										<input class="info-value" name="nguyenNhan" value="${khaitu.nguyenNhan}">
									</div>
								</div>

							</div>
							<div class="info-detail">
								<div class="row">
									<div class="col-md-12">
										<p class="info-title1">Đăng kí khai tử tại</p>
										<input class="info-value" name="noiDangKi" value="${khaitu.noiDangKi}"s>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<p class="info-title1">Ngày đăng kí</p>
										<input class="info-value" name="ngayDangKi" value="${ngaydangky}">
									</div>
								</div>
							</div>

						

							<div class="action">
							<a href="duyetKhaiTu"><button class="cancel"
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
								window.location.href = "duyetKhaiTu?type=yes&mahs=${khaitu.maKhaiTu}";
							}

							function remove() {
								window.location.href = "duyetKhaiTu?type=no&mahs=${khaitu.maKhaiTu}";
							}
						</script>
						</div>
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