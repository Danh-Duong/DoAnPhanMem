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
	<form action="login" method="post">
		<div class="container">
			<h1>ĐĂNG NHẬP</h1>
			<div class="input-group">
				<i class="fa-regular fa-id-card icon"></i> <input type="text"
					placeholder="Số CMND/CCCD" name="cccd">
			</div>
			
			<div class="input-group">
				<i class="fa-solid fa-key icon"></i> <input type="password"
					placeholder="Mật khẩu" name="mk">
			</div>
			<a style="text-decoration: underline;
    color: #2d6791;" href="reset-pass">Quên mật khẩu</a>
			<div class="action">
				<button type="button" class="btn" onclick="dk()">Đăng ký</button>
				<button type="submit" class="btn" style="background-color: #2765ab;">Đăng
					nhập</button>
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
		
		function dk() {
			window.location.href = "register";
		}
	</script>
</body>

</html>