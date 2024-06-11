<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Hồ sơ</title>
<script src="https://kit.fontawesome.com/e3729928c9.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/dangkykhaisinh.css">
</head>

<body>
	<div class="header">
		<%@ include file="header.jsp"%>
	</div>
	<div class="nav" style="width: 60%; margin: -16px auto 12px;">
		<i class="fa-solid fa-house"
			style="color: #A1A1A1; margin: 4px 4px 0 0;"></i> <span
			style="color: #A1A1A1;">Trang chủ ></span><span
			style="color: #3A3A3A; font-weight: 500; margin-left: 4px;">Nộp hồ sơ</span>
	</div>
	<div class="content">
		<div
			style="padding: 10px; background-color: antiquewhite; font-weight: 600;">Bộ
			thủ tục</div>
		<div style="display: flex; margin: 10px 0; align-items: center;">
			<i class="fa-regular fa-file-lines"></i> <a href="khaisinh"
				style="margin: 0 0 0 10px;text-decoration: none;">Đăng ký khai sinh</a>
		</div>
		<div style="display: flex; margin: 10px 0; align-items: center;">
			<i class="fa-regular fa-file-lines"></i> <a href="khaitu"
				style="margin: 0 0 0 10px;text-decoration: none;">Đăng ký khai tử</a>
		</div>
		
		<div style="display: flex; margin: 10px 0; align-items: center;">
			<i class="fa-regular fa-file-lines"></i> <a href="tamtru"
				style="margin: 0 0 0 10px;text-decoration: none;">Đăng ký tạm trú</a>
		</div>
		
		<div style="display: flex; margin: 10px 0; align-items: center;">
			<i class="fa-regular fa-file-lines"></i> <a href="tamvang"
				style="margin: 0 0 0 10px;text-decoration: none;">Đăng ký tạm vắng</a>
		</div>
		
		
	</div>

	<div class="footer">
		<%@ include file="footer.jsp"%>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
		integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
		crossorigin="anonymous"></script>
</body>

</html>