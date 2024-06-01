<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Đăng ký khai sinh</title>
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
	<div class="content">
		<div class="nav">
			<i class="fa-solid fa-house"
				style="color: #A1A1A1; margin: 4px 4px 0 0;"></i> <span
				style="color: #A1A1A1;">Trang chủ ></span><span
				style="color: #3A3A3A; font-weight: 500; margin-left: 4px;">Đăng
				ký khai sinh</span>
		</div>
		<c:if test="${error!=null}">
			<div class="error">${error}</div>
		</c:if>
		        
		<div>
			<p class="title">TỜ KHAI ĐĂNG KÍ KHAI SINH</p>
			<form action="khaisinh" method="post">
				<div class="info">
					<p class="info-title">Họ, chữ đệm, tên người yêu cầu:</p>
					<input name="nguoiyeucau">
				</div>
				<!--                 <div class="info">
                    <p class="info-title">Giấy tờ tùy thân:</p>
                    <input>
                </div> -->
				<div class="info">
					<p class="info-title">Quan hệ với người được khai sinh:</p>
					<input name="quanHeNguoiKhaiSinh">
				</div>
				<div>
					<p style="margin-top: 10px;">Đề nghị cơ quan đăng ký khai sinh
						cho người dưới đây:</p>
					<div class="info-detail">
						<div class="row">
							<div class="col-md-6">
								<p class="info-title1">Họ, chữ đệm, tên</p>
								<input class="info-value" name="hoTen">
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

						<div class="row">
							<div class="col-md-4">
								<p class="info-title1">Giới tính:</p>
								<select class="form-select" aria-label="Default select example"
									name="gioiTinh">
									<option selected>Chọn giới tính</option>
									<option value="M">Nam</option>
									<option value="F">Nữ</option>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Dân tộc:</p>
								<select class="form-select" aria-label="Default select example"
									name="danToc">
									<c:forEach items="${ETHNIC}" var="e">
										<option value="${e}">${e}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Quốc tịch:</p>
								<select class="form-select" aria-label="Default select example"
									name="quocTich">
									<option selected="selected">-</option>
									<c:forEach items="${COUNTRY}" var="c">
										<option value="${c}">${c}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Quê quán:</p>
								<input class="info-value" name="queQuan">
							</div>
						</div>
					</div>


					<div class="info-detail">

						<div class="row">
							<div class="col-md-6">
								<p class="info-title1" style="width: 400px;">Họ, chữ đệm,
									tên mẹ:</p>
								<input class="info-value">
							</div>
							<div class="col-md-6">
								<p class="info-title1" style="width: 400px;">CCCD:</p>
								<input class="info-value" name="cccdMe">
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<p class="info-title1">Giới tính:</p>
								<select class="form-select" aria-label="Default select example">
									<option selected>Chọn giới tính</option>
									<option value="F">Nam</option>
									<option value="M">Nữ</option>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Dân tộc:</p>
								<select class="form-select" aria-label="Default select example">
									<c:forEach items="${ETHNIC}" var="e">
										<option value="${e}">${e}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Quốc tịch:</p>
								<select class="form-select" aria-label="Default select example">
									<c:forEach items="${COUNTRY}" var="c">
										<option value="${c}">${c}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Nơi cư trú:</p>
								<input class="info-value">
							</div>
						</div>
					</div>

					<div class="info-detail">

						<div class="row">
							<div class="col-md-6">
								<p class="info-title1" style="width: 400px;">Họ, chữ đệm,
									tên cha:</p>
								<input class="info-value">
							</div>
							<div class="col-md-6">
								<p class="info-title1" style="width: 400px;">CCCD:</p>
								<input class="info-value" name="cccdCha">
							</div>
						</div>

						<div class="row">
							<div class="col-md-4">
								<p class="info-title1">Giới tính:</p>
								<select class="form-select" aria-label="Default select example">
									<option selected>Open this select menu</option>
									<option value="1">Nam</option>
									<option value="0">Nữ</option>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Dân tộc:</p>
								<select class="form-select" aria-label="Default select example">
										<c:forEach items="${ETHNIC}" var="e">
										<option value="${e}">${e}</option>
									</c:forEach>
								</select>
							</div>
							<div class="col-md-4">
								<p class="info-title1">Quốc tịch:</p>
								<select class="form-select" aria-label="Default select example">
									<c:forEach items="${COUNTRY}" var="c">
										<option value="${c}">${c}</option>
									</c:forEach>
								</select>
							</div>
						</div>

						<div class="row">
							<div class="col-md-12">
								<p class="info-title1">Nơi cư trú:</p>
								<input class="info-value">
							</div>
						</div>
					</div>

					<!-- <div class="info-detail" style="display: flex; align-items: center; padding: 16px 15px 0;">
                        <p style="width: 200px;">Đính kèm file</p>
                        <div class="input-group mb-3">
                            <input type="file" class="form-control" id="inputGroupFile02">
                        </div>
                    </div> -->

					<div class="commit">
						<div class="form-check">
							<input class="form-check-input" type="checkbox" value=""
								id="flexCheckDefault"> <label class="form-check-label"
								for="flexCheckDefault"> Tôi cam đoan nội dung đề nghị
								đăng ký khai sinh trên đây là đúng sự thật, được sự thỏa thuận
								nhất trí của các bên liên quan theo quy định pháp luật. Tôi chịu
								hoàn toàn trách nhiệm trước pháp luật về nội dung cam đoan của
								mình. </label>
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