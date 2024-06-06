<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://kit.fontawesome.com/e3729928c9.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link rel="stylesheet" href="css/thongbao.css">
</head>

<body>

    <div class="content">
        <div class="close"><i class="fa-solid fa-xmark"></i></div>
        <div class="image">
            <img src="img/green-tick.png" alt="">
        </div>
        <div class="info">
            <p style="font-size: 20px; font-weight: 500;">Chúc mừng</p>
            <p style="margin-bottom: 2px;">Bạn đã nộp hồ sơ đăng ký ${hoso} thành công</p>
            <p style="display: inline-block;">Mã hồ sơ của bạn là: </p>
            <span style="color: red;display: inline-block; font-size: 20px;">${madangky}</span>
            <p>
                Bạn sẽ nhận được thông báo của cơ quan ủy ban phường Thanh Bình qua email.
            </p>
            <div class="action">
                <button class="home">Về trang chủ</button>
            </div>
        </div>

    </div>

    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>

</html>