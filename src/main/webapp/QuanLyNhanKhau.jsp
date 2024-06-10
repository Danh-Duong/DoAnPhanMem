<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<script src="https://kit.fontawesome.com/e3729928c9.js"
	crossorigin="anonymous"></script>

<title>QUẢN LÝ NHÂN KHẨU</title>

<!-- Bootstrap Core CSS -->
<link href="css/report/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="css/report/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="css/report/dataTables/dataTables.bootstrap.css"
	rel="stylesheet">

<!-- DataTables Responsive CSS -->
<link href="css/report/dataTables/dataTables.responsive.css"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="css/report/startmin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="css/report/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link rel="stylesheet" href="css/report/table.css">
<link rel="stylesheet" href="css/report/index.css">
<link rel="stylesheet" href="css/QuanLyNhanKhau.css">

</head>

<body>
	<jsp:include page="banner.jsp"></jsp:include>

	<div id="page-wrapper" style="min-height: 279px;">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h3 class="page-header">THÔNG TIN NHÂN KHẨU</h3>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading" style="text-align: right">
							<a href="nhan-khau"><button type="button"
									class="btn btn-primary">Thêm mới nhân khẩu</button></a>
						</div>
						<!-- /.panel-heading -->
						<div class="panel-body">
							<div class="table-responsive">
								<div id="dataTables-example_wrapper"
									class="dataTables_wrapper form-inline dt-bootstrap no-footer">

									<c:if test="${error!=null}">
										<div class="alert alert-danger alert-dismissible">
											<button type="button" class="close" data-dismiss="alert"
												aria-hidden="true">×</button>
											${error}
										</div>
									</c:if>


									<c:if test="${success!=null}">
										<div class="alert alert-success alert-dismissible">
											<button type="button" class="close" data-dismiss="alert"
												aria-hidden="true">×</button>
											${success}
										</div>
									</c:if>

									<div class="row"
										style="display: flex; justify-content: flex-end;">
										<!-- <div class="col-sm-6"> -->

										<div
											style="margin-left: -20px; display: flex; align-items: center">
											<p style="margin: 0 10px">Mã nhân khẩu</p>
											<input type="search" class="form-control input-sm" id="mank"
												style="font-size: 15px;" name="mahk" placeholder=""
												value="${mank}" aria-controls="dataTables-example">
										</div>

										<!-- </div> -->

										<script type="text/javascript">
												
													var mank = document
															.querySelector("#mank");
													mank.addEventListener('keydown', function(event) {
											            // Kiểm tra nếu phím được nhấn là Enter
											            if (event.key === 'Enter') {
											                // Thực hiện hành động khi Enter được nhấn
											                $
															.ajax({
																url : 'nhankhau',
																type : 'GET',
																data : {
																	mank : mank.value
																},
																success : function(
																		response) {
																	$('body')
																			.html(
																					response);
																	// Xử lý phản hồi thành công ở đây
																	// Ví dụ: cập nhật giao diện người dùng với dữ liệu trả về
																},
																error : function(
																		xhr,
																		status,
																		error) {
																	// Xử lý lỗi ở đây
																}
															});
											                // Ngăn chặn hành vi mặc định của Enter nếu cần
											                event.preventDefault();
											            }
											        });
												
											</script>
										<!-- </div> -->
									</div>


									<table class="content-table" style="width: 100%;">
										<thead>
											<tr>
												<th>STT</th>
												<th>Mã nhân khẩu</th>
												<th>Tên công dân</th>
												<th>CCCD</th>
												<th>Ngày sinh</th>
												<th>Giới tính</th>
												<th>Hành động</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${nhankhaus}" var="nk" varStatus="loop">
												<tr class="gradeA odd" role="row">
													<td>${loop.index+1}</td>
													<td class="sorting_1">${nk.idNhanKhau}</td>
													<td>${nk.tenCongDan}</td>
													<td>${nk.cccd}</td>
													<td>${nk.ngaySinhStr}</td>
													<c:if test="${nk.gioiTinh=='F'}">
														<td class="center">Nữ</td>
													</c:if>
													<c:if test="${nk.gioiTinh=='M'}">
														<td class="center">Nam</td>
													</c:if>
													<!-- <td class="center">Nam</td> -->
													<td style="width: 15%"><i
														onclick="updateNhanKhau('${nk.idNhanKhau}')"
														class="fa-regular fa-pen-to-square"></i> <i
														onclick="deleteNhanKhau('${nk.idNhanKhau}')"
														class="fa-solid fa-trash-can"></i></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
									
																					<script>
	function updateNhanKhau(mank) {
		window.location.href = "nhan-khau?mank=" +mank;
	}
	
	function deleteNhanKhau(mank) {
		if(window.confirm('Bạn có chắc chắc xóa nhân khẩu ' + mank + ' ?'))
			window.location.href = "nhankhau?mank=" +mank+"&action=delete";
	}
</script>

									<div style="text-align: center;">
										<c:forEach var="pageNumber" begin="1" end="${totalPages}">
											<c:choose>
												<c:when test="${pageNumber == currentPage}">
													<button
														style="padding: 6px 14px; border-radius: 5px; border: none; background-color: #1a9f9b; color: white; font-weight: bold;">
														<c:out value="${pageNumber}" />
													</button>
												</c:when>
												<c:otherwise>
													<button onclick="changePage(this.textContent)"
														style="padding: 6px 14px; border-radius: 5px; border: none; background-color: #1a9f9b; color: white; opacity: 0.4;">
														<c:out value="${pageNumber}" />
													</button>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</div>

								</div>
							</div>
							<!-- /.table-responsive -->
						</div>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<!-- /.row -->
		</div>
		<!-- /.container-fluid -->
	</div>
	<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="js/report/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="js/report/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="js/report/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="js/report/dataTables/jquery.dataTables.min.js"></script>
	<script src="js/report/dataTables/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="js/report/startmin.js"></script>

	<!-- Page-Level Demo Scripts - Tables - Use for reference -->
	<script>
		$(document).ready(function() {
			$('#dataTables-example').DataTable({
				responsive : true
			});
		});
	</script>



</body>
</html>
