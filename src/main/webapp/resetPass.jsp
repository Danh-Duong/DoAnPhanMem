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
<link rel="stylesheet" href="css/resetPass.css">
</head>

<body>
	<div class="container">
		<h1>QUÊN MẬT KHẨU</h1>
		<form action="reset-pass" method="post">
			<div class="input-group">
				<i class="fa-regular fa-id-card icon"></i> <input type="text"
					id="cccd" placeholder="Số CMND/CCCD" name="cccd">
			</div>
			<div style="text-align: right;">
				<button type="button" class="otp" onclick="getOTP()">Gửi
					OTP</button>
			</div>

			<div class="input-group">
				<i class="fa-solid fa-lock icon"></i> <input name="otp" type="text"
					placeholder="Mã OTP">
			</div>
			<div class="input-group">
				<i class="fa-solid fa-key icon"></i> <input name="mk" type="password"
					placeholder="Mật khẩu">
			</div>

			<div class="action">
				<button class="btn">Quay lại</button>
				<button type="submit" class="btn" style="background-color: #2765ab;">Xác
					nhận</button>
			</div>
		</form>
			<c:if test="${error!=null}">
				<p>${error}</p>
			</c:if>
	</div>

	<script src="js/report/jquery.min.js"></script>

	<script type="text/javascript">
		function getOTP() {
			const cccd = document.querySelector('#cccd');
			$.ajax({
				url : 'reset-pass',
				type : 'GET',
				data : {
					otp : "true",
					cccd : cccd.value
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