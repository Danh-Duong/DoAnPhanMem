<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm nhân khẩu mới</title>
<style>
table, th, td {
	border: 1px solid;
}
</style>
</head>
<body>
	<div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
		<div class="card border-0 shadow rounded-3 my-5">
			<div class="card-body p-4 p-sm-5">
				<h5 class="card-title text-center mb-5 fw-light fs-5">Tạo Nhân Khẩu</h5>
				<form action="/demo/account/add" autocomplete="off" method="post">
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="idNhanKhau" name="idNhanKhau"
							value="${edit.idNhanKhau }" required="required" placeholder="Id">
						<label for="idNhanKhau">ID</label>
					</div>
					<div class="mb-3">
						<select class="form-select" name="idHoKhau"
							aria-label="Default select example">
							<option disabled selected="selected">Chọn</option>
							<c:forEach var="x" items="${sessionScope.listHoKhau}">
								<option value="${x.idHoKhau }"
									${edit.hoKhau.idHoKhau.equals(x.idHoKhau) ?'selected="selected"' : ''}>${x.idHoKhau }</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="tenCongDan" name="tenCongDan"
							value="${edit.tenCongDan }" required="required" placeholder="Họ Tên">
						<label for="tenCongDan">Họ Tên</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="cccd" name="cccd"
							value="${edit.cccd}" required="required" placeholder="CCCD">
						<label for="cccd">CCCD</label>
					</div>
					<fmt:formatDate var="date" pattern="yyyy-MM-dd" value="${edit.ngaySinh }" />
					<div class="form-floating mb-3">
						<input type="date" class="form-control" id="ngaySinh" name="ngaySinh"
							value="${date}" required="required" placeholder="Ngày Sinh">
						<label for="ngaySinh">Ngày sinh</label>
					</div>
					<div class="form-floating mb-3">
						<input type="email" class="form-control" id="email" name="email"
							value="${edit.email }" required="required" placeholder="Email">
						<label for="email">Email</label>
					</div>


					<div class="mb-3">
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" id="admin" name="gioiTinh"
								<c:if test = "${edit.gioiTinh.equals('M')}">checked="checked"</c:if>
								value="M">
							<label class="form-check-label" for="admin">Nam</label>
						</div>
						<div class="form-check form-check-inline">
							<input class="form-check-input" type="radio" id="user" name="gioiTinh"
								<c:if test = "${edit.gioiTinh.equals('F')}">checked="checked"</c:if>
								value="F">
							<label class="form-check-label" for="user">Nữ</label>
						</div>
					</div>

					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="sdt" name="sdt"
							value="${edit.sdt }" required="required" placeholder="SDT">
						<label for="sdt">SDT</label>
					</div>

					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="diaChiThuongTru"
							name="diaChiThuongTru" value="${edit.diaChiThuongTru }"
							required="required" placeholder="Địa chỉ thường chú">
						<label for="diaChiThuongTru">Địa chỉ thường chú</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="noiOHienTai"
							name="noiOHienTai" value="${edit.noiOHienTai }" required="required"
							placeholder="Nơi ở hiện tại">
						<label for="noiOHienTai">Nơi ở hiện tại</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="noiSinh" name="noiSinh"
							value="${edit.noiSinh }" required="required" placeholder="Nơi sinh">
						<label for="noiSinh">Nơi sinh</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="quanHe" name="quanHe"
							value="${edit.quanHe }" required="required" placeholder="Quan Hệ">
						<label for="quanHe">Quan Hệ</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="quocTich" name="quocTich"
							value="${edit.quocTich }" required="required" placeholder="Quốc Tịch">
						<label for="quocTich">Quốc Tịch</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="danToc" name="danToc"
							value="${edit.danToc }" required="required" placeholder="Dân Tộc">
						<label for="danToc">Dân Tộc</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="ngheNghiep" name="ngheNghiep"
							value="${edit.ngheNghiep }" required="required" placeholder="Nghề Nghiệp">
						<label for="ngheNghiep">Nghề Nghiệp</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="tinhTrangCuTru"
							name="tinhTrangCuTru" value="${edit.tinhTrangCuTru }" required="required"
							placeholder="Tình trạng cư trú">
						<label for="tinhTrangCuTru">Tình trạng cư trú</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="tinhTrangHocVan"
							name="tinhTrangHocVan" value="${edit.tinhTrangHocVan }"
							required="required" placeholder="Tình trạng học vấn">
						<label for="tinhTrangHocVan">Tình trạng học vấn</label>
					</div>
					<div class="form-floating mb-3">
						<input type="text" class="form-control" id="tinhTrangHonNhan"
							name="tinhTrangHonNhan" value="${edit.tinhTrangHonNhan }"
							required="required" placeholder="Tình trạng hôn nhân">
						<label for="tinhTrangHonNhan">Tình trạng hôn nhân</label>
					</div>
					<textarea type="text" class="form-control" id="ghiChu" name="ghiChu"
						placeholder="Ghi Chú">${edit.ghiChu}
				</textarea>
					<label for="ghiChu">Ghi chú</label>
					<div class="d-flex justify-content-center">
						<button class="btn btn-primary btn-login text-uppercase m-2 fw-bold"
							type="submit">Tạo</button>
						<button formaction="/demo/account/update"
							class="btn btn-primary btn-login text-uppercase m-2 fw-bold"
							type="submit">Cập nhật</button>
					</div>
				</form>
				${mess }
			</div>
		</div>
	</div>
	<a href="/demo/account/list">Xem danh sách</a>
</body>
</html>
