<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/style_header.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script src="https://kit.fontawesome.com/e3729928c9.js"
	crossorigin="anonymous"></script>
<header>
	<div class="logo">
		<img src="img/logo.png" />
		<h1 style="margin-bottom: 10px;">QUẢN LÝ NHÂN KHẨU, HỘ GIA ĐÌNH
			PHƯỜNG THANH BÌNH</h1>
	</div>

	<div class="header_top_right">

		<c:if test="${cookie.cccd != null}">
			<div class="login-check" style="width:190px; border-radius: 38px">
				<i style="font-size: 30px" class="fa-solid fa-circle-user"></i>
				<p style="margin: 0 0 0 5px">${cookie.cccd.value}</p>

				<div class="login-menu" style="z-index: 99999;">
					<a href="#"><p>Hồ sơ</p></a>
					<a href="logout"><p>Đăng xuất</p></a>
				</div>
			</div>

		</c:if>

		<c:if test="${cookie.cccd == null}">
			<a class="login" href="login"><i style="margin-right: 6px"
				class="fa-solid fa-right-to-bracket"></i>ĐĂNG NHẬP</a>
			<a class="signup" href="register"><i style="margin-right: 6px"
				class="fa fa-user"></i>ĐĂNG KÍ</a>
		</c:if>

	</div>
</header>
<main>
	<nav>
		<ul>
			<li><a href="http://localhost:8080/DoAnPhanMem"><i
					class="fa-solid fa-house-user fa-2x"></i></a></li>
			<li><a href="#">THỦ TỤC HÀNH CHÍNH</a></li>
			<li><a href="#">TRA CỨU HỒ SƠ</a></li>
			<li><a href="#">NỘP HỒ SƠ TRỰC TUYẾN</a></li>
			<li><a href="#">HỎI ĐÁP</a></li>
			<li><a href="#">HỖ TRỢ</a></li>
		</ul>
	</nav>
	<section class="search">
		<form action="#">
			<input type="text" placeholder="Nhập thông tin tìm kiếm">
			<button type="submit">
				<i class="fa-solid fa-magnifying-glass"></i>
			</button>
		</form>
	</section>
</main>
