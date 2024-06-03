<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="">
<h2>Chi tiết nhân khẩu</h2> 
<div>
<a href="/demo/account/create">Thêm thông tin nhân khẩu mới</a>
</div>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">ID</th>
				<th scope="col">ID Hộ Khẩu</th>
				<th scope="col">Tên Công Nhân</th>
				<th scope="col">CNND</th>
				<th scope="col">Ngày Sinh</th>
				<th scope="col">Email</th>
				<th scope="col">Giới Tính</th>
				<th scope="col">SDT</th>
				<th scope="col">Thường Trú</th>
				<th scope="col">Nơi Ở Hiện Tại</th>
				<th scope="col">Nơi Sinh</th>
				<th scope="col">Quan Hệ</th>
				<th scope="col">Quốc Tịch</th>
				<th scope="col">Dân Tộc</th>
				<th scope="col">Nghề Nghiệp</th>
				<th scope="col">Tình Trạng Cư Trú</th>
				<th scope="col">Học Vấn</th>
				<th scope="col">Hôn Nhân</th>
				<th scope="col">Ngày Cập Nhật</th>
				<th scope="col">Ghi Chú</th>
				<th scope="col">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="x" items="${sessionScope.listUser}">
				<tr>
					<td>${x.idNhanKhau }</td>
					<td>${x.hoKhau.idHoKhau }</td>
					<td>${x.tenCongDan }</td>
					<td>${x.cccd }</td>
					<td>
						<fmt:formatDate pattern="yyyy-MM-dd" value="${x.ngaySinh }" />
					</td>
					<td>${x.email }</td>
					<td>${x.gioiTinh }</td>
					<td>${x.sdt }</td>
					<td>${x.diaChiThuongTru }</td>
					<td>${x.noiOHienTai }</td>
					<td>${x.noiSinh }</td>
					<td>${x.quanHe }</td>
					<td>${x.quocTich }</td>
					<td>${x.danToc }</td>
					<td>${x.ngheNghiep }</td>
					<td>${x.tinhTrangCuTru }</td>
					<td>${x.tinhTrangHocVan }</td>
					<td>${x.tinhTrangHonNhan }</td>
					<td>
						<fmt:formatDate pattern="yyyy-MM-dd" value="${x.ngayCapNhat }" />
					</td>
					<td>${x.ghiChu }</td>
					<td>
						<c:url value="/account/edit" var="edit">
							<c:param name="idNhanKhau" value="${x.idNhanKhau }" />
						</c:url>
						
						<c:url value="/account/delete" var="delete">
							<c:param name="idNhanKhau" value="${x.idNhanKhau }" />
						</c:url>
						<a href="${edit }">Chỉnh</a>
						<a href="${delete }">Xóa</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
