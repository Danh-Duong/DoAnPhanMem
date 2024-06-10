<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script src="https://kit.fontawesome.com/e3729928c9.js"
	crossorigin="anonymous"></script>

<title>QUẢN LÝ NHÂN KHẨU</title>

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
<link rel="stylesheet" href="css/ChiTietNhanKhau.css">
</head>

<body>
		<jsp:include page="banner.jsp"></jsp:include>

		<div id="page-wrapper" style="min-height: 279px;">
			<div class="container-fluid">
				<form action="nhan-khau" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
					<div class="title-img">
						<!-- <h1 class="title">NHÂN KHẨU</h1> -->
						<div>
							<c:if test="${nhankhau.image==null}">
								<img class="nk-img" alt="" src="img/avatar.jpg"
									id="avatar-preview">
								<input id="avatar-upload" type="file" id="avatar-upload"
									name="avatar" accept="image/*">
							</c:if>
							<c:if test="${nhankhau.image!=null}">
								<img id="avatar-preview" class="nk-img" alt=""
									src="img/${nhankhau.image}">
								<input id="avatar-upload" type="file" id="avatar-upload"
									name="avatar" accept="image/*">
							</c:if>
						</div>


					</div>
					<div class="section">
						<div class="info-detail">
							<c:if test="${nhankhau.idNhanKhau!=null}">
								<div class="row">
									<div class="col-md-12">
										<p class="info-title1">Mã nhân khẩu :</p>
										<input type="text" class="info-value" name=mank name="hoten"
											value="${nhankhau.idNhanKhau}">
									</div>
								</div>
							</c:if>




							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Họ tên :</p>
									<input type="text" class="info-value" name="tenCongDan"
										name="hoten" value="${nhankhau.tenCongDan}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<p class="info-title1">Mã số CCCD:</p>
									<input type="text" id="soCCCD" name="cccd"
										value="${nhankhau.cccd}">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Mã hộ khẩu:</p>
									<select class="form-select" aria-label="Default select example"
										name="mahk">
										<option value="" selected>Choose</option>
										<c:forEach items="${hokhaus}" var="hk">
											<option value="${hk.idHoKhau}"
												<c:if test="${hk.idHoKhau eq nhankhau.idHoKhau}">selected</c:if>>${hk.idHoKhau}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Quan hệ với chủ hộ:</p>
									<input type="text" class="info-value" name="quanHe"
										value="${nhankhau.quanHe}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<p class="info-title1">Ngày sinh:</p>
									<input type="date" id="ngaysinh" name="ngaySinh"
										value="${nhankhau.ngaySinh}">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Giới tính:</p>
									<select class="form-select" aria-label="Default select example"
										name="gioiTinh">
										<option selected>Chọn giới tính</option>
										<option <c:if test="${nhankhau.gioiTinh=='M'}">selected</c:if>
											value="M">Nam</option>
										<option <c:if test="${nhankhau.gioiTinh=='F'}">selected</c:if>
											value="F">Nữ</option>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-md-4">
									<p class="info-title1">Quốc tịch:</p>
									<select class="form-select" aria-label="Default select example"
										name="quocTich">
										<option selected="selected">Chọn quốc tịch</option>
										<c:forEach items="${COUNTRY}" var="c">
											<option value="${c}"
												<c:if test="${c eq nhankhau.quocTich}">selected</c:if>>${c}</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-md-4">
									<p class="info-title1">Dân tộc:</p>
									<select class="form-select" aria-label="Default select example"
										name="danToc">
										<option selected="selected">Chọn dân tộc</option>
										<c:forEach items="${ETHNIC}" var="e">
											<option value="${e}"
												<c:if test="${e eq nhankhau.danToc}">selected</c:if>>${e}</option>
										</c:forEach>
									</select>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Nơi ở hiện tại:</p>
									<input class="info-value" name="noiOHienTai" type="text"
										value="${nhankhau.noiOHienTai}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Quê quán:</p>
									<input class="info-value" name="noiSinh" type="text"
										value="${nhankhau.noiSinh}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Trình độ học vấn:</p>
									<input class="info-value" name="tinhTrangHocVan" type="text"
										value="${nhankhau.tinhTrangHocVan}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Tình trạng hôn nhân:</p>
									<input class="info-value" name="tinhTrangHonNhan" type="text"
										value="${nhankhau.tinhTrangHonNhan}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Nghề nghiệp:</p>
									<input class="info-value" name="ngheNghiep" type="text"
										value="${nhankhau.ngheNghiep}">
								</div>
							</div>
						</div>
					</div>
					<div class="sys-button">
						<button class="sub-button" type="button"
							onclick="window.location.href='nhankhau'"
							style="background-color: #F49560">Trở về</button>
						<button class="sub-button" type="submit"
							style="background-color: #049323">Lưu</button>
					</div>
				</form>

			</div>

		</div>

	</div>
	<script>
		document
				.getElementById('avatar-upload')
				.addEventListener(
						'change',
						function(event) {
							const file = event.target.files[0];
							if (file) {
								const reader = new FileReader();
								reader.onload = function(e) {
									document.getElementById('avatar-preview').src = e.target.result;
								}
								reader.readAsDataURL(file);
							}
						});
	</script>


</body>
</html>