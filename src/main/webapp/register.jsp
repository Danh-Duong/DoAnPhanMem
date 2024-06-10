<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng ký tài khoản</title>
<script src="https://kit.fontawesome.com/e3729928c9.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="css/register.css">
</head>

<body>
	<form action="register" method="post">
		<div class="container">
			<h1>ĐĂNG KÝ TÀI KHOẢN</h1>
			<div class="input-group">
				<i class="fa-regular fa-id-card icon"></i> <input type="text"
					placeholder="Số CMND/CCCD" name="cccd">
			</div>
			<div class="input-group">
				<i class="fa-solid fa-user icon" style="left: 13px;"></i> <input
					type="text" placeholder="Họ và tên" name="ten">
			</div>
			<div class="input-group">
				<i class="fa-solid fa-envelope icon"></i> <input type="email"
					placeholder="Email" name="email">
				<button type="button" class="otp" onclick="getOTP()">Gửi
					OTP</button>
			</div>
			<div class="input-group">
				<i class="fa-solid fa-key icon"></i> <input type="password"
					placeholder="Mật khẩu" name="mk">
			</div>
			<div class="input-group">
				<i class="fa-solid fa-key icon"></i> <input type="password"
					placeholder="Nhập lại mật khẩu" name="rmk">
			</div>
			<div class="input-group">
				<i class="fa-solid fa-lock icon"></i> <input type="text"
					placeholder="Mã OTP" name="otp">
			</div>
			<div class="action">
				<button class="btn">Quay lại</button>
				<button type="submit" class="btn" style="background-color: #2765ab;">Đăng
					ký</button>
			</div>
			<c:if test="${error!=null}">
				<p>${error}</p>
			</c:if>
		</div>
	</form>

	<script src="js/report/jquery.min.js"></script>

	<script type="text/javascript">
		function getOTP() {
			const emailInput = document
					.querySelector('.input-group input[name="email"]');
			$.ajax({
				url : 'register',
				type : 'GET',
				data : {
					otp : "true",
					email : emailInput.value
				},
				success : function(response) {
				},
				error : function(xhr, status, error) {
					// Xử lý lỗi ở đây
				}
			});
		}
	</script>
</body>

</html>