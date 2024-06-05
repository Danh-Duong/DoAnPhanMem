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

<title>SmartPhone Store - Admin</title>

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

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<a class="navbar-brand" href="admin">Phường Thanh Bình - Hải
					Châu</a>
			</div>

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>


			<ul class="nav navbar-right navbar-top-links">
				<li class="dropdown navbar-inverse"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>
						<b class="caret"></b>
				</a>
					<ul class="dropdown-menu dropdown-alerts">
						<li><a href="#">
								<div>
									<i class="fa fa-comment fa-fw"></i> New Comment <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li><a href="#">
								<div>
									<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
										class="pull-right text-muted small">12 minutes ago</span>
								</div>
						</a></li>
						<li><a href="#">
								<div>
									<i class="fa fa-envelope fa-fw"></i> Message Sent <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li><a href="#">
								<div>
									<i class="fa fa-tasks fa-fw"></i> New Task <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li><a href="#">
								<div>
									<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>See
									All Alerts</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						admin <b class="caret"></b>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> User
								Profile</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
					</ul></li>
			</ul>
			<!-- /.navbar-top-links -->
		</nav>

		<aside class="sidebar navbar-default" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav in" id="side-menu">
					<li class="sidebar-search">
						<div class="input-group custom-search-form">
							<input type="text" class="form-control" placeholder="Search...">
							<span class="input-group-btn">
								<button class="btn btn-primary" type="button"
									style="padding: 9px 12px;">
									<i class="fa fa-search"></i>
								</button>
							</span>
						</div> <!-- /input-group -->
					</li>
					<li><a href="admin"><i class="fa-solid fa-house"
							style="color: #337ab7; margin: 0 4px;"></i> Trang chủ</a></li>
					<li class="active"><a href="#"><i
							class="fa-regular fa-file-lines"
							style="color: #337ab7; margin: 0 8px 0 6px; font-size: 17px;"></i>
							Hồ sơ<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li style="background-color: #eee;"><a href="duyetKhaiSinh">Đăng
									ký khai sinh</a></li>
							<li><a href="morris.html">Đăng ký khai tử</a></li>
						</ul> <!-- /.nav-second-level --></li>
					<li><a href="hokhau"><i class="fa-solid fa-people-roof"
							style="color: #337ab7; margin: 0 4px;"></i> Hộ khẩu</a></li>
					<li><a href="catalogs"><i class="fa-solid fa-user"
							style="color: #337ab7; margin: 0 7px;"></i> Nhân khẩu</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</aside>
		<!-- /.sidebar -->

		<div id="page-wrapper" style="min-height: 279px;">
			<div class="container-fluid">

				<div
					style="padding: 45px 45px 10px; background-color: #f8f8f8; margin: 0 165px;">
					<p class="title">TỜ KHAI ĐĂNG KÍ KHAI SINH</p>

					<div class="info">
						<p class="info-title">
							Mã hồ sơ: <span style="font-size: 20px; font-weight: 600">
								${khaisinh.maDangKiKhaiSinh}</span>
						</p>
					</div>

					<div>
						<p style="margin-top: 10px;">Thông tin khai sinh:</p>
						<div class="info-detail">
							<div class="row">
								<div class="col-md-6">
									<p class="info-title1">Họ, chữ đệm, tên</p>
									<input readonly="readonly" class="info-value" name="hoTen"
										value="${khaisinh.hoTen}">
								</div>
								<div class="col-md-6">
									<p class="info-title1">Ngày, tháng, năm sinh</p>
									<input readonly="readonly" class="info-value" name="ngaySinh"
										value="${ngaysinh}">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Nơi sinh:</p>
									<input readonly="readonly" class="info-value" name="noiSinh"
										value="${khaisinh.noiSinh}">
								</div>
							</div>

							<div class="row">
								<div class="col-md-4">
									<p class="info-title1">Giới tính:</p>
									<c:if test="${khaisinh.gioiTinh=='M'}">
										<input readonly="readonly" class="info-value" name="gioiTinh"
											value="Nam">
									</c:if>
									<c:if test="${khaisinh.gioiTinh!='M'}">
										<input readonly="readonly" class="info-value" name="gioiTinh"
											value="Nữ">
									</c:if>

								</div>
								<div class="col-md-4">
									<p class="info-title1">Dân tộc:</p>
									<input readonly="readonly" class="info-value" name=danToc
										value="${khaisinh.danToc}">
								</div>
								<div class="col-md-4">
									<p class="info-title1">Quốc tịch:</p>
									<input readonly="readonly" class="info-value" name=quocTich
										value="${khaisinh.quocTich}">
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Quê quán:</p>
									<input readonly="readonly" class="info-value" name="queQuan"
										value="${khaisinh.queQuan}">
								</div>
							</div>
						</div>


						<div class="info-detail">

							<div class="row">
								<div class="col-md-6">
									<p class="info-title1" style="width: 400px;">Họ, chữ đệm,
										tên mẹ:</p>
									<input readonly="readonly" class="info-value"
										value="${me.tenCongDan}">
								</div>
								<div class="col-md-6">
									<p class="info-title1" style="width: 400px;">CCCD:</p>
									<input readonly="readonly" class="info-value" name="cccdMe"
										value="${me.cccd}">
								</div>
							</div>

							<div class="row">
								<div class="col-md-6">
									<p class="info-title1">Dân tộc:</p>
									<input readonly="readonly" class="info-value"
										value="${me.danToc}">
								</div>
								<div class="col-md-6">
									<p class="info-title1">Quốc tịch:</p>
									<input readonly="readonly" class="info-value"
										value="${me.quocTich}">
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Nơi cư trú:</p>
									<input readonly="readonly" class="info-value"
										value="${me.noiOHienTai}">
								</div>
							</div>
						</div>

						<div class="info-detail">

							<div class="row">
								<div class="col-md-6">
									<p class="info-title1" style="width: 400px;">Họ, chữ đệm,
										tên cha:</p>
									<input readonly="readonly" class="info-value"
										value="${cha.tenCongDan}">
								</div>
								<div class="col-md-6">
									<p class="info-title1" style="width: 400px;">CCCD:</p>
									<input readonly="readonly" class="info-value" name="cccdCha"
										value="${cha.cccd}">
								</div>
							</div>

							<div class="row">

								<div class="col-md-6">
									<p class="info-title1">Dân tộc:</p>
									<input readonly="readonly" class="info-value"
										value="${cha.danToc}">
								</div>
								<div class="col-md-6">
									<p class="info-title1">Quốc tịch:</p>
									<input readonly="readonly" class="info-value"
										value="${cha.quocTich}">
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<p class="info-title1">Nơi cư trú:</p>
									<input readonly="readonly" class="info-value"
										value="${cha.noiOHienTai}">
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
								window.location.href = "duyetKhaiSinh?type=yes&mahs=${khaisinh.maDangKiKhaiSinh}";
							}

							function remove() {
								window.location.href = "duyetKhaiSinh?type=no&mahs=${khaisinh.maDangKiKhaiSinh}";
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