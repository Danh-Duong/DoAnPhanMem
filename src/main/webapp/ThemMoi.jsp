<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

		<jsp:include page="banner.jsp"></jsp:include>

		<div id="page-wrapper" style="min-height: 279px;">
			<div class="container-fluid">
			<div class="title-img">
			<h1 class="title" >THÊM MỚI NHÂN KHẨU</h1>
			<div>
			<img alt="" src="img/avatar.jpg">
			<input type="file" id="avatar-upload" name="avatar" accept="image/*">
			</div>
			</div>
			<form action="themmoi" method="post">
				<div class="section">
				<div class="info-detail">
				<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Họ tên :</p>
								<input type="text" class="info-value" name="tenCongDan" >
							</div>
						</div>
                    <div class="row">
							<div class="col-md-4">
								<p class="info-title1">Mã số CCCD:</p>
								<input type="text" id="soCCCD" name="cccd">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Mã hộ khẩu:</p>
								<select class="form-select" aria-label="Default select example"
									name="gioiTinh">
									<option selected>Chọn</option>
									<option ></option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Quan hệ với chủ hộ:</p>
								<input type="text" class="info-value" name="quanHe">
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<p class="info-title1">Ngày sinh:</p>
								<input type="date" id="ngaysinh" name="ngaySinh">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Giới tính:</p>
								<select class="form-select" aria-label="Default select example"
									name="gioiTinh">
									<option selected>Chọn giới tính</option>
									<option value="M">Nam</option>
									<option value="F">Nữ</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<p class="info-title1">Quốc tịch:</p>
								<select class="form-select" aria-label="Default select example"
									name="quocTich">
									<option selected="selected">Chọn quốc tịch</option>
									<option></option>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Dân tộc:</p>
								<select class="form-select" aria-label="Default select example"
									name="danToc">
									<option selected="selected">Chọn dân tộc</option>
									<option></option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Nơi ở hiện tại:</p>
								<input class="info-value" name="noiOHienTai" type="text">
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Quê quán:</p>
								<input class="info-value" name="noiSinh" type="text">
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Trình độ học vấn:</p>
								<input class="info-value" name="tinhTrangHocVan" type="text">
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Tình trạng hôn nhân:</p>
								<input class="info-value" name="tinhTrangHonNhan" type="text">
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Nghề nghiệp:</p>
								<input class="info-value" name="ngheNghiep" type="text">
							</div>
						</div>
                </div>
                </div>
                <div class="section">
                <p>THÔNG TIN LIÊN LẠC</p>
				<div class="info-detail">
				
				<div class="row1">
							<div class="col-md-4">
								<p class="info-title1" style="margin-left:50px">Email:</p>
								<input type="text" id="email" name="email" style="margin-left:50px">
							</div>
							<div class="col-md-4">
								<p class="info-title1" >Số liên lạc:</p>
								<input type="text" id="sdt" name="sdt">
							</div>
						</div>
				</div>
				</div>
                </form>
                
                </div>
                <div class="sys-button">
                <button class="sub-button" onclick="window.location.href='QuanLyNhanKhau.jsp'" style="background-color:#F49560">Trở về</button>
                <button class="sub-button" onclick="" style="background-color:#049323">Lưu</button>
                </div>
                </div>
                
                </div>
                
					

</body>
</html>