<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng ký tạm trú</title>
<script src="https://kit.fontawesome.com/e3729928c9.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="css/dangkitamvang.css">
</head>

<body>
	<div class="header">
	<%@ include file="header.jsp" %>
	</div>
	<div class="content">
		<div class="nav">
			<i class="fa-solid fa-house"
				style="color: #A1A1A1; margin: 4px 4px 0 0;"></i> <span
				style="color: #A1A1A1;">Trang chủ ></span><span
				style="color: #3A3A3A; font-weight: 500; margin-left: 4px;">Đăng
				ký tạm trú</span>
		</div>
		<div>
			<h3 class="title">TỜ KHAI ĐĂNG KÍ TẠM TRÚ</h3>
			<form action="DangKyTamTru" method="post">
				<div class="section">
				<div class="info-detail">
                    <p class="subtitle">CƠ QUAN THỰC HIỆN</p>
                    <div class="line"></div>
                    <div class="row">
							<div class="col-md-4">
								<p class="info-title1">Tỉnh/Thành phố:</p>
								<input type="text" id="thanhpho" value="Đà Nẵng" name="thanhPho">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Quận/Huyện:</p>
								<select class="form-select" aria-label="Default select example"
									name="quanHuyen">									
										<option selected>Chọn quận/huyện</option>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Phường/Xã:</p>
								<select class="form-select" aria-label="Default select example"
									name="phuongXa">									
										<option selected>Chọn phường/xã</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Cơ quan thực hiện:</p>
								<input class="info-value" name="coQuanThucHien" type="text">
							</div>
						</div>
                </div>
                </div>
                <div class="section">
                <div class="info-detail">
                    <p class="subtitle">THÔNG TIN NGƯỜI KHAI BÁO TẠM TRÚ</p>
                    <div class="line"></div>
                    <div class="row">
							<div class="col-md-4">
								<p class="info-title1">Họ tên</p>
								<input class="info-value" name="hoTen" type="text">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Ngày, tháng, năm sinh</p>
								<input type="date" class="info-value" name="ngaySinh">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Giới tính:</p>
								<select class="form-select" aria-label="Default select example"
									name="gioiTinh">
									<option selected>Chọn giới tính</option>
									<option value="M">Nam</option>
									<option value="F">Nữ</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<p class="info-title1">Số CCCD:</p>
								<input class="info-value" name="cccd" type="text">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Quốc tịch:</p>
								<select class="form-select" aria-label="Default select example"
									name="quocTich">
									<option selected="selected">-</option>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Số điện thoại:</p>
								<input class="info-value" name="soDT" type="text">
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<p class="info-title1">Tỉnh/Thành phố:</p>
								<input type="text" id="thanhpho" value="Đà Nẵng" name="thanhPho">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Quận/Huyện:</p>
								<select class="form-select" aria-label="Default select example"
									name="quanHuyen">									
										<option selected>Chọn quận/huyện</option>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Phường/Xã:</p>
								<select class="form-select" aria-label="Default select example"
									name="phuongXa">									
										<option selected>Chọn phường/xã</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Địa chỉ cụ thể:</p>
								<input class="info-value" name="diaChiCuThe" type="text">
							</div>
						</div>
					</div>
					</div>
					<div class="section">
					<div class="info-detail">
                    <p class="subtitle">THÔNG TIN ĐĂNG KÍ TẠM VẮNG</p>
                    <div class="line"></div>
                    <div class="radio-select">
                    		<p>Trường hợp đăng kí:</p>
                    		
						  <div class="radio-item">
                <input type="radio" id="old" name="tamtru" value="old">
                <label for="old">Đăng kí tạm trú vào hộ đã có</label>
            </div>
            <div class="radio-item">
                <input type="radio" id="new" name="tamtru" value="new">
                <label for="new">Đăng kí lập hộ mới</label>
            </div>
                    </div>
                    <div class="row">
							<div class="col-md-4">
								<p class="info-title1">Tỉnh/Thành phố:</p>
								<input type="text" id="thanhpho" value="Đà Nẵng" name="thanhPho">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Quận/Huyện:</p>
								<select class="form-select" aria-label="Default select example"
									name="quanHuyen">									
										<option selected>Chọn quận/huyện</option>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Phường/Xã:</p>
								<select class="form-select" aria-label="Default select example"
									name="phuongXa">									
										<option selected>Chọn phường/xã</option>
								</select>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Địa chỉ cụ thể:</p>
								<input class="info-value" name="diaChiCuThe" type="text">
							</div>
						</div>
						<div class="row">
							<div class="col-md-4">
								<p class="info-title1">Họ tên chủ hộ:</p>
								<input class="info-value" name="hoTenChuHo" type="text">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Quan hệ với chủ hộ:</p>
								<input class="info-value" name="quanHeChuHo" type="text">
							</div>
							<div class="col-md-4">
								<p class="info-title1">Số CCCD chủ hộ:</p>
								<input class="info-value" name="socccdChuHo" type="text">
							</div>
						</div>
						
						</div>
                </div>		
					<div class="commit">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value=""
								id="flexCheckDefault"> <label class="form-check-label"
								for="flexCheckDefault"> Tôi cam đoan nội dung đề nghị
								đăng ký tạm vắng trên đây là đúng sự thật, được sự thỏa thuận
								nhất trí của các bên liên quan theo quy định pháp luật. Tôi chịu
								hoàn toàn trách nhiệm trước pháp luật về nội dung cam đoan của
								mình. </label>
						</div>
					</div>
					</form>
					</div>
					</div>
					

					<div class="action">
						<button class="cancel">Hủy đăng ký</button>
						<button type="submit" class="submit">Nộp tờ khai</button>
					</div>

	
	<%@ include file="footer.jsp" %>
</body>
</html>