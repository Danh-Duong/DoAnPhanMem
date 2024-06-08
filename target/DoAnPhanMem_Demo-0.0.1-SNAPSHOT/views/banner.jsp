<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" href="css/style_banner.css">

<div id="banner">
    <ul>
        <li><a href="trangchu.jsp"><i class="fa fa-home"></i> Trang chủ</a></li>
        <li>
            <a href="#"><i class="fa fa-folder"></i> Hồ sơ</a>
            <ul>
                <li><a href="khai_sinh.jsp">Đăng ký khai sinh</a></li>
                <li><a href="khai_tu.jsp">Đăng ký khai tử</a></li>
                <li><a href="${pageContext.request.contextPath}/account/tamvang">Đăng ký tạm vắng</a></li>
                
            </ul>
        </li>
        <li><a href="hokhau.jsp"><i class="fa fa-home"></i> Hộ khẩu</a></li>
        <ul>
        <li><a href="${pageContext.request.contextPath}/account/list">Nhân khẩu</a></li>
        <!-- Các mục khác trong banner -->
    </ul>
    </ul>
</div>
