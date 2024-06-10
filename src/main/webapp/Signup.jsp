<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký tài khoản</title>
<link rel="stylesheet" href="css/dangky.css">
</head>
<body>
    <div class="header">
        <%@ include file="header.jsp" %>
    </div>

	<div class="container">
	<h2 class="register-title">Đăng Ký Tài Khoản</h2>
    <div class="register-container">
        
        <form class="register-form">
            <div class="input-group">
                <label for="fullname">Họ tên:</label>
                <input type="text" id="fullname" name="fullname" required>
            </div>
            <div class="input-group">
                <label for="cccd">Số CCCD:</label>
                <input type="text" id="cccd" name="cccd" required>
            </div>
            <div class="input-group">
                <label for="phone">Số điện thoại:</label>
                <input type="text" id="phone" name="phone" required>
            </div>
            <div class="input-group">
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="input-group">
                <label for="confirm-password">Xác nhận mật khẩu:</label>
                <input type="password" id="confirm-password" name="confirm-password" required>
            </div>
            <div class="input-group remember-me">
                <div class="checkbox-container">
                    <input type="checkbox" id="remember-me" name="remember-me">
                    <label for="remember-me">Nhớ mật khẩu</label>
                </div>
            </div>
            <button type="submit" class="register-button">Đăng Ký</button>
            <a href="Login.jsp" class="login-link">Bạn đã có tài khoản?</a>
        </form>
    </div>
</div>
    <div class="footer">
        <%@ include file="footer.jsp" %>
    </div>
</body>
</html>
