<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Phường Thanh Binh</title>
<link rel="stylesheet" href="css/index/grid.css">
<link rel="stylesheet" href="css/index/main.css">
<link rel="stylesheet" href="css/index/responsive.css">

<!-- <link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css"
	integrity="sha512-DTOQO9RWCH3ppGqcWaEA1BIZOC6xxalwEsw9c2QQeAIftl+Vegovlnee1c9QX4TctnWMn13TZye+giMm8e2LwA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" /> -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap"
	rel="stylesheet">
</head>
<style>
/* .app {
	padding: 0px !important;
	word-spacing: 0.5px !important;
	font-size: 62.5% !important;
	line-height: 1.6rem !important;
} */
</style>
<body>
	<script src="js/index/index.js"></script>
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>
	<div class="app" style="margin-top: -30px;">
		<!--begin container-->
		<div class="grid wide" style="position: relative; top: -115px;">
			<div class="container">
				<div class="row">
					<div class="col l-9 m-8">
						<div class="content">
							<div class="row">
								<div class="col l-10 l-o-1 m-12">
									<div class="content_title">
										<h4>Tin tức nổi bật</h4>
										<input type="hidden" id="hide" value="${Eror}" />
									</div>
								</div>
								<div class="col l-5 l-o-1 m-6">
									<div class="content_1">
										<!-- begin slide-->
										<div class="block_slider">
											<ul class="list_item_slider">
												<li><a href="https://www.youtube.com/"
													class="content_1_image"> <img
														src="https://static.kinhtedothi.vn/images/upload/2022/04/22/toan-canh.jpg"
														alt="Hinh Anh">
												</a> <a href="https://www.youtube.com/" class="content_1_title">
														<h4>ĐẢNG ỦY PHƯỜNG THANH KHÊ TÂY TỔ CHỨC LỄ TRAO HUY
															HIỆU ĐẢNG ĐỢT 7/11</h4>
												</a></li>
												<li><a href="https://www.youtube.com/"
													class="content_1_image"> <img
														src="https://bcp.cdnchinhphu.vn/334894974524682240/2023/11/15/14-11tc2-17000170340751942618966.jpg"
														alt="Hinh Anh">
												</a> <a href="https://www.youtube.com/" class="content_1_title">
														<h4>giám đốc công an tp. đà nẵng khen thưởng đột xuất
															công an quân thanh khê</h4>
												</a></li>
												<li><a href="https://www.youtube.com/"
													class="content_1_image"> <img
														src="https://dienbientv.vn/dataimages/201904/original/images2763672_Untitled_1.jpg"
														alt="Hinh Anh">
												</a> <a href="https://www.youtube.com/" class="content_1_title">
														<h4>tuyên truyền phổ biến, giáo dục pháp luật cho cán
															bộ, nhân dân phường thanh khê tây</h4>
												</a></li>
												<li><a href="https://www.youtube.com/"
													class="content_1_image"> <img
														src="https://th.bing.com/th/id/R.e4b351fc8f7f6b2ebcda68365a3dd648?rik=EXhEzzMC%2fvFuNw&riu=http%3a%2f%2fhoisinhvien.com.vn%2fpic%2fNew%2fimages%2fTSMT+2019%2f65302975_2473424222703627_5094334188086099968_o.jpg&ehk=3A07jmwwRTcZ%2fKS3eCmb4q2166ZBaiOc%2bqQxsTlzn0k%3d&risl=&pid=ImgRaw&r=0"
														alt="Hinh Anh">
												</a> <a href="https://www.youtube.com/" class="content_1_title">
														<h4>thanh niên phường thanh khê tây trong chuyến
															thiện nguyện đầu năm</h4>
												</a></li>
											</ul>
										</div>
										<ul class="content_number--img">
											<li class="number--img--item chooseimg"></li>
											<li class="number--img--item"></li>
											<li class="number--img--item"></li>
											<li class="number--img--item"></li>
										</ul>
										<!--end slide-->
										<div class="content_1_logo">
											<div class="logo_1">
												<img src="img/logo_chuyendoiso.png" alt="chuyem doi so">
											</div>
											<div class="logo_title_1">
												<h2>10.10.2023</h2>
												<p>NGÀY CHUYỂN ĐỔI SỐ QUỐC GIA</p>
											</div>
										</div>
									</div>
								</div>
								<div class="col l-5 m-6">
									<div class="content_2">
										<ul class="content_2_list">
											<li><a href="#" class="content_2list--item">
													<h3>Ngày hội đại đoàn kêt tại khu dân cư</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Ra mắt mô hình "Tổ liên kết dịch vụ đặc sản sạch
														ban mai xanh"</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Hội nghị đối thoại giữa bí thư đảng ủy và chủ tịch
														UBND phường với nhân dân trước kỳ họp thường kỳ cuối năm
														củ hđnd thành phố khóa x, nhiệm kỳ 2021-2026</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Ngày hội đại đoàn kêt tại khu dân cư</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Ra mắt mô hình "Tổ liên kết dịch vụ đặc sản sạch
														ban mai xanh"</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Hội nghị đối thoại giữa bí thư đảng ủy và chủ tịch
														UBND phường với nhân dân trước kỳ họp thường kỳ cuối năm
														củ hđnd thành phố khóa x, nhiệm kỳ 2021-2026</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Ngày hội đại đoàn kêt tại khu dân cư</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Ra mắt mô hình "Tổ liên kết dịch vụ đặc sản sạch
														ban mai xanh"</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Hội nghị đối thoại giữa bí thư đảng ủy và chủ tịch
														UBND phường với nhân dân trước kỳ họp thường kỳ cuối năm
														củ hđnd thành phố khóa x, nhiệm kỳ 2021-2026</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>

										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col l-3 m-4">
						<div class="row">
							<div class="col l-10">
								<div class="sidebar">
									<div class="sidebar_title">
										<h4>THÔNG BÁO</h4>
									</div>
									<ul class="sidebar_listinfo">
										<li><a href="#" class="sidebar_listinfo_item">
												<h4>TUYÊN TRUYỀN MỘT SỐ NHIỆM VỤ, NỘI DUNG TRONG TUẦN
													45</h4>
												<p>Ngày đăng: 02/11/2023</p>
										</a></li>
										<li><a href="#" class="sidebar_listinfo_item">
												<h4>TUYÊN TRUYỀN MỘT SỐ NHIỆM VỤ, NỘI DUNG TRONG TUẦN
													45</h4>
												<p>Ngày đăng: 02/11/2023</p>
										</a></li>
										<li><a href="#" class="sidebar_listinfo_item">
												<h4>TUYÊN TRUYỀN MỘT SỐ NHIỆM VỤ, NỘI DUNG TRONG TUẦN
													45</h4>
												<p>Ngày đăng: 02/11/2023</p>
										</a></li>
										<li><a href="#" class="sidebar_listinfo_item">
												<h4>TUYÊN TRUYỀN MỘT SỐ NHIỆM VỤ, NỘI DUNG TRONG TUẦN
													45</h4>
												<p>Ngày đăng: 02/11/2023</p>
										</a></li>
										<li><a href="#" class="sidebar_listinfo_item">
												<h4>TUYÊN TRUYỀN MỘT SỐ NHIỆM VỤ, NỘI DUNG TRONG TUẦN
													45</h4>
												<p>Ngày đăng: 02/11/2023</p>
										</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col l-9 m-8">
						<div class="content">
							<div class="row">
								<div class="col l-10 l-o-1 m-12">
									<div class="content_title">
										<h4>đảng bộ phường</h4>
									</div>
								</div>
								<div class="col l-5 l-o-1 m-6">
									<div class="content_1">
										<!-- begin slide-->
										<div class="block_slider">
											<ul class="list_item_slider">
												<li><a href="https://www.youtube.com/"
													class="content_1_image"> <img
														src="https://static.kinhtedothi.vn/images/upload/2022/04/22/toan-canh.jpg"
														alt="Hinh Anh">
												</a> <a href="https://www.youtube.com/" class="content_1_title">
														<h4>ĐẢNG ỦY PHƯỜNG THANH KHÊ TÂY TỔ CHỨC LỄ TRAO HUY
															HIỆU ĐẢNG ĐỢT 7/11</h4>
												</a></li>
												<li><a href="https://www.youtube.com/"
													class="content_1_image"> <img
														src="https://bcp.cdnchinhphu.vn/334894974524682240/2023/11/15/14-11tc2-17000170340751942618966.jpg"
														alt="Hinh Anh">
												</a> <a href="https://www.youtube.com/" class="content_1_title">
														<h4>giám đốc công an tp. đà nẵng khen thưởng đột xuất
															công an quân thanh khê</h4>
												</a></li>
												<li><a href="https://www.youtube.com/"
													class="content_1_image"> <img
														src="https://dienbientv.vn/dataimages/201904/original/images2763672_Untitled_1.jpg"
														alt="Hinh Anh">
												</a> <a href="https://www.youtube.com/" class="content_1_title">
														<h4>tuyên truyền phổ biến, giáo dục pháp luật cho cán
															bộ, nhân dân phường thanh khê tây</h4>
												</a></li>
												<li><a href="https://www.youtube.com/"
													class="content_1_image"> <img
														src="https://th.bing.com/th/id/R.e4b351fc8f7f6b2ebcda68365a3dd648?rik=EXhEzzMC%2fvFuNw&riu=http%3a%2f%2fhoisinhvien.com.vn%2fpic%2fNew%2fimages%2fTSMT+2019%2f65302975_2473424222703627_5094334188086099968_o.jpg&ehk=3A07jmwwRTcZ%2fKS3eCmb4q2166ZBaiOc%2bqQxsTlzn0k%3d&risl=&pid=ImgRaw&r=0"
														alt="Hinh Anh">
												</a> <a href="https://www.youtube.com/" class="content_1_title">
														<h4>thanh niên phường thanh khê tây trong chuyến
															thiện nguyện đầu năm</h4>
												</a></li>
											</ul>
										</div>
										<ul class="content_number--img">
											<li class="number--img--item index2 chooseimg2"></li>
											<li class="number--img--item index2"></li>
											<li class="number--img--item index2"></li>
											<li class="number--img--item index2"></li>
										</ul>
										<!--end slide-->
										<div class="content_1_logo">
											<div class="logo_1">
												<img src="img/logo_chuyendoiso.png" alt="chuyem doi so">
											</div>
											<div class="logo_title_1">
												<h2>10.10.2023</h2>
												<p>NGÀY CHUYỂN ĐỔI SỐ QUỐC GIA</p>
											</div>
										</div>
									</div>
								</div>
								<div class="col l-5 m-6">
									<div class="content_2">
										<ul class="content_2_list">
											<li><a href="#" class="content_2list--item">
													<h3>Ngày hội đại đoàn kêt tại khu dân cư</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Ra mắt mô hình "Tổ liên kết dịch vụ đặc sản sạch
														ban mai xanh"</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Hội nghị đối thoại giữa bí thư đảng ủy và chủ tịch
														UBND phường với nhân dân trước kỳ họp thường kỳ cuối năm
														củ hđnd thành phố khóa x, nhiệm kỳ 2021-2026</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Ngày hội đại đoàn kêt tại khu dân cư</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Ra mắt mô hình "Tổ liên kết dịch vụ đặc sản sạch
														ban mai xanh"</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Hội nghị đối thoại giữa bí thư đảng ủy và chủ tịch
														UBND phường với nhân dân trước kỳ họp thường kỳ cuối năm
														củ hđnd thành phố khóa x, nhiệm kỳ 2021-2026</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Ngày hội đại đoàn kêt tại khu dân cư</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Ra mắt mô hình "Tổ liên kết dịch vụ đặc sản sạch
														ban mai xanh"</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>
											<li><a href="#" class="content_2list--item">
													<h3>Hội nghị đối thoại giữa bí thư đảng ủy và chủ tịch
														UBND phường với nhân dân trước kỳ họp thường kỳ cuối năm
														củ hđnd thành phố khóa x, nhiệm kỳ 2021-2026</h3>
													<p>Ngày đăng: 07/11/2023</p>
											</a></li>

										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col l-3 m-4">
						<div class="row">
							<div class="col l-10">
								<div class="sidebar">
									<div class="sidebar_title">
										<h4>LỊCH CÔNG TÁC</h4>
									</div>
									<ul class="sidebar_listinfo">
										<li><a href="#" class="sidebar_listinfo_item">
												<h4>TUYÊN TRUYỀN MỘT SỐ NHIỆM VỤ, NỘI DUNG TRONG TUẦN
													45</h4>
												<p>Ngày đăng: 02/11/2023</p>
										</a></li>
										<li><a href="#" class="sidebar_listinfo_item">
												<h4>TUYÊN TRUYỀN MỘT SỐ NHIỆM VỤ, NỘI DUNG TRONG TUẦN
													45</h4>
												<p>Ngày đăng: 02/11/2023</p>
										</a></li>
										<li><a href="#" class="sidebar_listinfo_item">
												<h4>TUYÊN TRUYỀN MỘT SỐ NHIỆM VỤ, NỘI DUNG TRONG TUẦN
													45</h4>
												<p>Ngày đăng: 02/11/2023</p>
										</a></li>
										<li><a href="#" class="sidebar_listinfo_item">
												<h4>TUYÊN TRUYỀN MỘT SỐ NHIỆM VỤ, NỘI DUNG TRONG TUẦN
													45</h4>
												<p>Ngày đăng: 02/11/2023</p>
										</a></li>
										<li><a href="#" class="sidebar_listinfo_item">
												<h4>TUYÊN TRUYỀN MỘT SỐ NHIỆM VỤ, NỘI DUNG TRONG TUẦN
													45</h4>
												<p>Ngày đăng: 02/11/2023</p>
										</a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--end container-->
		<!--begin footer-->
		<div class="grid wide">
			<!-- <div class="footer">
				<div class="row">
					<div class="col l-4 m-4">
						<div class="footer_item">
							<p class="footer_title">UBND P.Thanh Khê Tây</p>
							<p class="footer_info">© Bản quyền Website: UBND phường Thanh
								Khê Tây - quận Thanh Khê - Tp Đà Nẵng</p>
						</div>
					</div>
					<div class="col l-4 m-4">
						<div class="footer_item">
							<p class="footer_title">Trụ sở cơ quan</p>
							<p class="footer_info">300 Dũng Sĩ Thanh Khê - Quận Thanh Khê
								- Tp Đà Nẵng</p>
						</div>
					</div>
					<div class="col l-4 m-4">
						<div class="footer_item">
							<p class="footer_title">Điện thoại</p>
							<p class="footer_info">0236. 3760.174</p>
						</div>
					</div>
				</div>
			</div> -->

			<%-- 					<div class="footer">
		<%@ include file="footer.jsp"%>
	</div> --%>
		</div>
	</div>

	<div class="applogin close">
		<div class="login_box">
			<h1 class="title_login">đăng nhập</h1>

			<form action="loginCheckProcess" class="box_input">
				<div id="input_id">
					<input type="text" placeholder="Số CMND/CCCD" name="cmnd">
					<i class="fa-solid fa-user" id="loginuser"></i>
				</div>
				<div id="input_password">
					<input type="password" placeholder="Mật khẩu" name="password">
					<i class="fa-solid fa-key" id="loginkey"></i> <i
						class="fa-regular fa-eye-slash"></i> <i
						class="fa-regular fa-eye close"></i>
				</div>
				<div class="sign">
					<a href="#" class="register_account">Đăng ký?</a> <a href="#"
						class="fogot_pass">Quên mật khẩu ?</a>
				</div>
				<input type="submit" class="btn_login" value="Đăng nhập"></input>
				<!--thong bao trang thai dang nhap-->
				<div class="applogin_announce">
					<p style="visibility: hidden" id="applogin_announce_content">Không
						thành công !!!</p>
				</div>
			</form>
			<i class="fa-solid fa-xmark"></i>
		</div>
	</div>

	<!--đăg ký-->
	<div class="register_pass close">
		<div class="register_box">
			<h1 class="title_login">đăng ký</h1>
			<form action="" class="box_input">
				<div id="input_id">
					<input type="text" placeholder="Số CMND/CCCD"> <i
						class="fa-solid fa-user" id="loginuser"></i>
				</div>
				<div id="input_id">
					<input type="text" placeholder="Họ và tên"> <i
						class="fa-solid fa-user" id="loginuser"></i>
				</div>
				<div class="send_email">
					<div id="input_email">
						<input type="email" placeholder="Email"> <i
							class="fa-solid fa-envelope" id="loginuser"></i>
					</div>
					<button id="register_button_otp">Gửi OTP</button>
				</div>

				<div id="input_password">
					<input type="password" placeholder="Mật khẩu"> <i
						class="fa-solid fa-key" id="loginkey"></i> <i
						class="fa-regular fa-eye-slash"></i> <i
						class="fa-regular fa-eye close"></i>
				</div>
				<div id="input_id">
					<input type="text" placeholder="Mã OTP"> <i
						class="fa-solid fa-user" id="loginuser"></i>
				</div>
				<input type="submit" class="btn_login" value="Đăng ký"></input>
				<!--thong bao trang thai dang nhap-->
				<div class="applogin_announce">
					<p id="applogin_announce--content">Không thành công !!!</p>
				</div>
			</form>
			<i class="fa-solid fa-xmark"></i>
		</div>
	</div>
	<!--quên mật khẩu-->
	<div class="forgot_pass close">
		<div class="forgot_box">
			<h1 class="title_login">quên mật khẩu</h1>
			<form action="" class="box_input">
				<div id="input_id">
					<input type="text" placeholder="Số CMND/CCCD"> <i
						class="fa-solid fa-user" id="loginuser"></i>
				</div>

				<div class="send_email">
					<div id="input_email_2">
						<!-- <input type="email" placeholder="Email">
                        <i class="fa-solid fa-envelope" id="loginuser"></i> -->
					</div>
					<button id="forgot_button_otp">Gửi OTP</button>
				</div>
				<div id="input_id">
					<input type="text" placeholder="Mã OTP"> <i
						class="fa-solid fa-user" id="loginuser"></i>
				</div>
				<div id="input_password">
					<input type="password" placeholder="Nhập mật khẩu mới"> <i
						class="fa-solid fa-key" id="loginkey"></i> <i
						class="fa-regular fa-eye-slash"></i> <i
						class="fa-regular fa-eye close"></i>
				</div>
				<input type="submit" class="btn_login" value="Xác nhận"></input>
				<!--thong bao trang thai dang nhap-->
				<div class="applogin_announce">
					<p id="applogin_announce--content">Không thành công !!!</p>
				</div>
			</form>
			<i class="fa-solid fa-xmark"></i>
		</div>
	</div>
	<!-- SECTION -->
	<!--  <div class="section"></div>-->
	<!-- container -->
	<!-- <div class="container formInput">
		row
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-7">
				Billing Details
				<form action="indexProcess" method="get" class="billing-details">
					<div class="section-title">
						<h3 class="title">Sign In Page</h3>
					</div>
					<div class="form-group">
						<input class="input" type="text" name="userName"
							placeholder="User Name" required>
					</div>
					<div class="form-group">
						<input class="input" type="email" name="email" placeholder="Email">
					</div>
					<div class="form-group">
						<input class="input" type="tel" name="tel" placeholder="Telephone">
					</div>
					<div class="form-group">
						<input class="input" type="password" name="password"
							placeholder="Enter Your Password" required>
					</div>
					<button type="submit" class="primary-btn order-submit"
						style="float: right;">Sign In</button>
				</form>
				<div class="sign">
					Not a member? <a href="registerProcess">&nbsp;Signup</a>
				</div>
			</div>
			/row
		</div>
		/container
	</div> -->
	<!-- /SECTION -->

	<footer>
		<div class="container"
			style="background: none; position: relative; top: 15px; text-align: center;">
			<h1>CÔNG AN PHƯỜNG THANH BÌNH</h1>
			<img src="img/logo.png" alt="Logo Công an phường Thanh Bình">
		</div>
		<div class="contact" style="text-align: center;">
			<div></div>
			<p>Địa chỉ: 12 Ông Ích Khiêm, Thanh Bình, Hải Châu, Đà Nẵng</p>
			<p>Điện thoại: (0234) 567 890</p>
			<p>Email: thanhbinh@cadanang.gov.vn</p>
		</div>
	</footer>


</body>

</html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
	var hide = $('#hide').val();
	if (hide == 1) {
		var loginbox = document.querySelector('.applogin');
		loginbox.classList.remove('close');
		var show = $('#applogin_announce_content');
		show.css('visibility', 'visible'); // Set visibility using jQuery
		console.log("Sai mat khau!")
	}
</script>
<!-- jQuery Plugins -->
<script src="js/index/jquery.min.js"></script>
<script src="js/index/bootstrap.min.js"></script>
<script src="js/index/slick.min.js"></script>
<script src="js/index/nouislider.min.js"></script>
<script src="js/index/jquery.zoom.min.js"></script>
<script src="js/index/main.js"></script>

</body>
</html>
