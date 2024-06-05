<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký khai tử</title>
   
    <link rel="stylesheet" href="css/dangkykhaitu.css">
</head>
<body>
<div class="header">
	<%@ include file="header.jsp" %>
	</div>
<div class="content">
        <div class="nav">
            <i class="fa-solid fa-house" style="color: #A1A1A1; margin: 4px 4px 0 0;"></i> <span
                style="color: #A1A1A1;">Trang chủ ></span><span
                style="color: #3A3A3A; font-weight: 500; margin-left: 4px;">Đăng
                ký khai tử</span>
        </div>


        <div>
            <p class="title">TỜ KHAI ĐĂNG KÍ KHAI TỬ</p>
            <form action="khaitu" method="post">
                <div class="info">
                    <p class="info-title">Họ, chữ đệm, tên người yêu cầu:</p>
                    <input name="hoTenNguoiKhai">
                </div>
                <div class="info">
                    <p class="info-title">Nơi cư trú</p>
                    <input name="noiCuTruNguoiKhai">
                </div>
                <div class="info">
                    <p class="info-title">Quan hệ với người mất</p>
                    <input name="quanHeVoiNguoiMat">
                </div>
                <div>
                    <p style="margin-top: 10px;">Đề nghị cơ quan đăng ký khai tử
                        cho người dưới đây:</p>
                    <div class="info-detail">
                        <div class="row">
                            <div class="col-md-6">
                                <p class="info-title1">Họ, chữ đệm, tên</p>
                                <input class="info-value" name="hoTenNguoiMat">
                            </div>
                            <div class="col-md-6">
                                <p class="info-title1">Ngày, tháng, năm sinh</p>
                                <input type="date" class="info-value" name="ngaySinh">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <p class="info-title1">Nơi sinh:</p>
                                <input class="info-value" name="noiSinh">
                            </div>
                        </div>

                        <div class="row" style="display:flex; flex-direction:row; justify-content:space-between">
                            <div class="col-md-4">
                                <p class="info-title1">Giới tính:</p>
                                <select class="form-select" aria-label="Default select example" name="gioiTinh">
                                    <option selected>Chọn giới tính</option>
                                    <option value="M">Nam</option>
                                    <option value="F">Nữ</option>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <p class="info-title1" >Dân tộc:</p>
                                <select class="form-select" aria-label="Default select example" name="danToc" style="width:250px">

                                </select>
                            </div>
                            <div class="col-md-4">
                                <p class="info-title1" >Quốc tịch:</p>
                                <select class="form-select" aria-label="Default select example" name="quocTich" style="width:250px">
                                    <option selected="selected">-</option>

                                </select>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <p class="info-title1">Nơi cư trú cuối cùng:</p>
                                <input class="info-value" name="noiCuTruCuoiCung">
                            </div>
                        </div>

                        <div class="row">
                            <p class="info-title1" style="width: 400px;">Đã mất vào lúc</p>
                            <div class="col-md-6">
                                <p class="info-title1">Ngày</p>
                                <input class="info-value" type="date" name="ngayMat">                         
                            </div>
                            <div class="col-md-6">
                                <p class="info-title1">Giờ</p>
                                <input class="info-value" type="time" name="gioMat">                         
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <p class="info-title1">Nơi mất</p>
                                <input class="info-value" name="noiMat">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <p class="info-title1">Nguyên nhân</p>
                                <input class="info-value" name="nguyenNhan">
                            </div>
                        </div>

                    </div>
                    <div class="info-detail">
                        <div class="row">
                            <div class="col-md-12">
                                <p class="info-title1">Đăng kí khai tử tại</p>
                                <input class="info-value" name="noiDangKi">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-12">
                                <p class="info-title1">Ngày đăng kí</p>
                                <input class="info-value" type="date" name="ngayDangKi">
                            </div>
                        </div>
                    </div>

                   <div class="commit">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value=""
								id="flexCheckDefault"> 
							<label class="form-check-label"for="flexCheckDefault">
								Tôi cam đoan nội dung đề nghị đăng ký khai sinh trên đây là đúng sự thật, được sự thỏa thuận nhất trí của các bên 
								liên quan theo quy định pháp luật. Tôi chịu hoàn toàn trách nhiệm trước pháp luật về nội dung cam đoan của mình. 
							</label>
						</div>
					</div>


                    <div class="action">
                        <button class="cancel">Hủy đăng ký</button>
                        <button type="submit" class="submit">Nộp tờ khai</button>
                    </div>

                </div>
            </form>
        </div>
    </div>
<div class="footer">
<%@ include file="footer.jsp" %>
</div>
</body>
</html>