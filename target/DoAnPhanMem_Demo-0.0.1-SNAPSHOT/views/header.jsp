<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_header.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
<script src="https://kit.fontawesome.com/e3729928c9.js" crossorigin="anonymous"></script>
<header>
    <div class="logo">
        <img src="<%=request.getContextPath()%>/img/logo.png" alt="Logo" />
        <h1>QUẢN LÝ NHÂN KHẨU, HỘ GIA ĐÌNH PHƯỜNG THANH BÌNH</h1>
    </div>
    <div class="header_top_right">
        <a class="login" href="#"><i class="fa-solid fa-right-to-bracket"></i> ĐĂNG NHẬP</a>
        <a class="signup" href="#"><i class="fa fa-user"></i> ĐĂNG KÍ</a>
    </div>
</header>
<main>
    <nav>
        <ul>
            <li><a href="#"><i class="fa-solid fa-house-user fa-2x"></i></a></li>
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
