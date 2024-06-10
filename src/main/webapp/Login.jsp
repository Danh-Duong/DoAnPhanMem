<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<link rel="stylesheet" href="css/dangnhap.css">

</head>
<body>
	<div class="header">
	<%@ include file="header.jsp" %>
	</div>
	<div class="container">
	<h2 class="login-title">Đăng Nhập</h2>
	<div class="login-container">
        
        <form class="login-form" action="dangnhap">
            <div class="input-group">
                <label for="cccd">Số CCCD:</label>
                <input type="text" id="cccd" name="cccd" required>
            </div>
            <div class="input-group">
                <label for="password">Mật khẩu:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="input-group remember-me">
                <div class="checkbox-container">
                    <input type="checkbox" id="remember-me" name="remember-me">
                    <label for="remember-me">Nhớ mật khẩu</label>
                </div>
                <a href="#" class="forgot-password" style="margin-left:50px">Bạn quên mật khẩu?</a>
            </div>
            
            <button type="submit" class="login-button">Đăng Nhập</button>
            <a href="Signup.jsp" class="signup-link">Bạn chưa có tài khoản?</a>
        </form>
    </div>
</div>
	<div class="footer">
	<%@ include file="footer.jsp" %>
	</div>
</body>
</html>