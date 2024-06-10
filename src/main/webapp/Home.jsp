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
<title>Cổng dịch vụ công - Bộ Công an</title>
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
<link href="css/report/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">


</head>
<body>
<div class="header">
  <div class="logo">
      <img src="img/logoDN.png" alt="Resized Image" width="300" height="200">
      <div class="logo-text">
      <p>CỔNG DỊCH VỤ CÔNG</p>
      <p>BỘ CÔNG AN</p>
    </div>
  </div>
  <div class="navbar">
    <ul class="navbar-nav">
      <li><a href="login.jsp">Đăng nhập</a></li>
    </ul>
  </div>
</div>
  <div class="sidebar">
    <ul class="list-group">
      <li class="list-group-item"><a href="#">Thủ tục hành chính</a></li>
      <li class="list-group-item"><a href="#">Tra cứu hồ sơ</a></li>
      <li class="list-group-item"><a href="#">Nộp hồ sơ trực tuyến</a></li>
      <li class="list-group-item"><a href="#">Phản ảnh - Kiến nghị</a></li>
      <li class="list-group-item"><a href="#">Đánh giá</a></li>
      <li class="list-group-item"><a href="#">Văn bản</a></li>
      <li class="list-group-item"><a href="#">Hỏi đáp</a></li>
      <li class="list-group-item"><a href="#">Hỗ trợ</a></li>
    </ul>
      </div>
<div class="main-content">
  <div class="content">
    <div class="text-and-search">
      <div class="text-section">
        <p class="highlight">6 ĐIỀU BÁC HỒ DẠY CÔNG AN NHÂN DÂN<br>
          Đối với tự mình, phải cần, kiệm, liêm, chính<br>
          Đối với đồng sự, phải thân ái giúp đỡ<br>
          Đối với Chính phủ, phải tuyệt đối trung thành<br>
          Đối với nhân dân, phải kính trọng, lễ phép<br>
          Đối với công việc, phải tận tụy<br>
          Đối với địch, phải cương quyết khôn khéo.
        </p>
      </div>
      <div class="search-section">
        <form class="form-inline">
          <div class="form-group">
            <input type="text" class="form-control" id="search" placeholder="Nhập thông tin tìm kiếm">
          </div>
        </form>
      </div>
    </div>

  </div>
</div>
  </div>
</div>
<div class="custom-list-container">
      <ul class="custom-list-group">
        <li class="custom-list-group-item"><a href="DangKiTamTru.jsp">Đăng ký tạm trú</a></li>
         <li class="custom-list-group-item"><a href="DangkyKhaiSinh.jsp">Đăng ký khai sinh</a></li>
        <li class="custom-list-group-item"><a href="DangKiTamVang.jsp">Đăng ký tạm vắng</a></li>
        <li class="custom-list-group-item">Xóa đăng ký thường trú</li>
        <li class="custom-list-group-item">Khai báo tạm vắng</li>        
        <li class="custom-list-group-item">Đăng ký thường trú</li>
        <li class="custom-list-group-item">Khai báo thông tin về cư trú đối với người chưa đủ điều kiện đăng ký thường trú, đăng ký tạm trú</li>
        <li class="custom-list-group-item">Tách hộ</li>
        <li class="custom-list-group-item">Xác nhận thông tin về cư trú</li>
        <li class="custom-list-group-item">Xóa đăng ký tạm trú</li>
        <li class="custom-list-group-item">Điều chỉnh thông tin về cư trú trong cơ sở dữ liệu về cư trú</li>
        <li class="custom-list-group-item">Cấp thẻ Căn cước công dân</li>
        <li class="custom-list-group-item">Đổi thẻ Căn cước công dân</li>
        <li class="custom-list-group-item">Cấp lại thẻ Căn cước công dân</li>
        <li class="custom-list-group-item">Xác nhận số CMND, số CCCD</li>
      </ul>
    </div>
<div class="footer">
  <p>&copy; 2024 Bộ Công an phường Thanh Bình-Hải Châu-Đà Nẵng. All rights reserved.</p>
</div>
</body>
</html>

<style>
html, body {
  height: 100%;
  margin: 0;
  font-family: Arial, sans-serif;
  display: flex;
  flex-direction: column;
}
p{
    font-size: 15px;
}
body {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
}

.header {
  background: linear-gradient(135deg, rgba(84, 99, 95, 1) 20%, rgba(25, 187, 45, 100) 100%);
  padding: 10px 20px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.logo {
  display: flex;
  align-items: center;
}

.logo img {
  width: 100px; /* Adjust the width as needed */
  height: auto; /* Maintains the aspect ratio */
  margin-right: 10px; /* Space between image and text */
}

.logo-text {
   font-weight: bold; /* Make text bold */
  font-size: 15px;
  color: #5cb85c;
}

.logo-text p {
  margin: 0;
  text-align: center;
}

.navbar-nav {
  font-size: 20px;
  list-style: none;
  margin: 0;
  padding: 0;
  display: flex;
}

.navbar-nav li {
  margin-right: 20px;
}

.navbar-nav a {
  color: #fff;
  text-decoration: none;
}

.navbar-nav a:hover {
  color: #ff0000;
}

.main-content {
   olor: #5cb85c;
  flex: 1;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 30px;
  margin-right: 350px;
  margin-left: 250px;
}

.sidebar {
  width: 100%;
  padding: 10px;
  background: linear-gradient(135deg,rgba(25, 187, 45, 100) 20%, rgba(84, 99, 95, 1) 100%);
  color: white;
  font-size: 13px;
  margin-bottom: -45px;
}
.list-group {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  width: 100%;
  padding: 0;
  margin: 0;
  list-style: none;
}

.list-group-item {
  flex: 1;
  padding:0px;
  text-align: center; 
  color: white; 
  background: linear-gradient(135deg, rgba(84, 99, 95, 1) 20%, rgba(25, 187, 45, 100) 100%);
  border: none;
}

.list-group-item a {
  color: white; 
  text-decoration: none;
}

.list-group-item:hover {
  color: #fff; 
}

.list-group-item a:hover {
  background: #125acd;
  color: #fff; 
}

.content {
  width: 100%;
  padding: 20px;
  display: flex;
  flex-direction: column;
}

.content > div {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.content h2, .content p {
  margin-bottom: 0;
}

.footer {
  background-color: #f1f1f1;
  padding: 10px;
  text-align: center;
}

.form-control {
  height: 30px; 
  width: 300px;
  font-size: 16px;
}

.custom-list-container {
  width: 100%;
  margin-top:0px;
  padding: 10px;
  background-color: #e0f7fa; /* Background color for the custom list section */
  border: 1px solid #ddd;
  border-radius: 8px;
}

.custom-list-group {
  list-style: none;
  padding: 0;
  margin: 0;
}

.custom-list-group-item {
  padding: 10px;
  background-color: #ffffff;
  border: 1px solid #ddd;
  margin-bottom: 10px;
  text-align: left;
}

.custom-list-group-item:hover {
  background-color: #f1f1f1;
}
    </style>