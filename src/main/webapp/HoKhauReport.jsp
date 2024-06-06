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

<title>SmartPhone Store - Admin</title>

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

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<div class="navbar-header">
				<a class="navbar-brand" href="admin">Phường Thanh Bình - Hải
					Châu</a>
			</div>

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>


			<ul class="nav navbar-right navbar-top-links">
				<li class="dropdown navbar-inverse"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-bell fa-fw"></i>
						<b class="caret"></b>
				</a>
					<ul class="dropdown-menu dropdown-alerts">
						<li><a href="#">
								<div>
									<i class="fa fa-comment fa-fw"></i> New Comment <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li><a href="#">
								<div>
									<i class="fa fa-twitter fa-fw"></i> 3 New Followers <span
										class="pull-right text-muted small">12 minutes ago</span>
								</div>
						</a></li>
						<li><a href="#">
								<div>
									<i class="fa fa-envelope fa-fw"></i> Message Sent <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li><a href="#">
								<div>
									<i class="fa fa-tasks fa-fw"></i> New Task <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li><a href="#">
								<div>
									<i class="fa fa-upload fa-fw"></i> Server Rebooted <span
										class="pull-right text-muted small">4 minutes ago</span>
								</div>
						</a></li>
						<li class="divider"></li>
						<li><a class="text-center" href="#"> <strong>See
									All Alerts</strong> <i class="fa fa-angle-right"></i>
						</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
					data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
						admin <b class="caret"></b>
				</a>
					<ul class="dropdown-menu dropdown-user">
						<li><a href="#"><i class="fa fa-user fa-fw"></i> User
								Profile</a></li>
						<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="logout"><i class="fa fa-sign-out fa-fw"></i>
								Logout</a></li>
					</ul></li>
			</ul>
			<!-- /.navbar-top-links -->
		</nav>

		<jsp:include page="banner.jsp"></jsp:include>

		<div id="page-wrapper" style="min-height: 279px;">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h3 class="page-header">THÔNG TIN HỘ KHẨU</h3>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-12">
						<div class="panel panel-default">
							<div class="panel-heading" style="text-align: right">

								<button type="button" onclick="exportExcel()"
									class="btn btn-warning">
									<i class="fa-solid fa-file-csv"
										style="font-size: 20px; padding: 0 10px;"></i>
								</button>
								<button type="button" onclick="exportPdf()" class="btn btn-info">
									<i class="fa-solid fa-file-pdf"
										style="font-size: 20px; padding: 0 10px;"></i>
								</button>
							</div>

							<script type="text/javascript">
								function exportExcel() {
									var mahk = document.querySelector("#mahk");
									var tinhtrang = document
											.querySelector("#trangthai");
									var ngaybd = document
											.querySelector("#tungay");
									var ngaykt = document
											.querySelector("#denngay");

									window.location.href = "hokhau?export=excel&mahk="
											+ mahk.value
											+ "&tinhtrang="
											+ (tinhtrang == null ? ""
													: tinhtrang.value)
											+ "&ngaybd="
											+ (ngaybd == null ? null
													: ngaybd.value)
											+ "&ngaykt="
											+ (ngaykt == null ? null
													: ngaykt.value);
								}

								function exportPdf() {
									var mahk = document.querySelector("#mahk");
									var tinhtrang = document
											.querySelector("#trangthai");
									var ngaybd = document
											.querySelector("#tungay");
									var ngaykt = document
											.querySelector("#denngay");

									window.location.href = "hokhau?export=pdf&mahk="
											+ mahk.value
											+ "&tinhtrang="
											+ (tinhtrang == null ? ""
													: tinhtrang.value)
											+ "&ngaybd="
											+ (ngaybd == null ? null
													: ngaybd.value)
											+ "&ngaykt="
											+ (ngaykt == null ? null
													: ngaykt.value);
								}
							</script>

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
											style="display: flex; justify-content: space-between;">
											<!-- <div class="col-sm-6"> -->

											<!-- </div> -->
											<script type="text/javascript">
												function changePageSize(
														selectElement) {
													var mahk = document
															.querySelector("#mahk");
													var tinhtrang = document
															.querySelector("#trangthai");
													var ngaybd = document
															.querySelector("#tungay");
													var ngaykt = document
															.querySelector("#denngay");
													var selectedValue = selectElement.value;
													$
															.ajax({
																url : 'hokhau',
																type : 'GET',
																data : {
																	mahk : mahk.value,
																	tinhtrang : tinhtrang == null ? ""
																			: tinhtrang.value,
																	ngaybd : ngaybd == null ? null
																			: ngaybd.value,
																	ngaykt : ngaykt == null ? null
																			: ngaykt.value,
																	pageSize : selectedValue
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
												}
											</script>


											<div style="margin-left: -38px;">
												<p>Mã hộ khẩu</p>
												<input type="search" class="form-control input-sm" id="mahk"
													style="font-size: 15px;" name="mahk"
													onkeydown="searchProduct(event)" placeholder=""
													value="${mahk}" aria-controls="dataTables-example">
											</div>
											<div>
												<p>Trạng thái</p>
												<select id="trangthai" class="form-select" name="trangthai"
													style="padding: 5px 5px 6px; border-color: #c1c1c1; border-radius: 4px; width: 175px; height: 30px;">
													<option>Tất cả</option>
													<option value="1" ${trangthai=="1" ? "selected" : ""}>Đã
														phê duyệt</option>
													<option value="0" ${trangthai=="0" ? "selected" : ""}>Chờ
														phê duyệt</option>

												</select>
											</div>

											<div>
												<p>Từ ngày</p>
												<input type="date" class="form-control input-sm" id="tungay"
													value="${tungay}" name="tungay"
													onkeydown="searchProduct(event)" placeholder=""
													aria-controls="dataTables-example"
													style="width: 175px; height: 30px; font-size: 15px;">
											</div>

											<div>
												<p>Đến ngày</p>
												<input type="date" class="form-control input-sm"
													id="denngay" value="${denngay}" name="denngay"
													onkeydown="searchProduct(event)" placeholder=""
													aria-controls="dataTables-example"
													style="width: 175px; height: 30px; font-size: 15px;">
											</div>

											<div class="dataTables_length" id="dataTables-example_length">
												<p>Hiển thị</p>
												<select onchange="changePageSize(this)"
													style="font-size: 15px;" name="dataTables-example_length"
													aria-controls="dataTables-example"
													class="form-control input-sm pageSize">
													<option ${currentPageSize==5?'selected':''} value="5">5</option>
													<option ${currentPageSize==10?'selected':''} value="10">10</option>
													<option ${currentPageSize==15?'selected':''} value="15">15</option>
												</select>

											</div>

											<div>
												<button style="margin-top: 26px" type="button"
													class="btn btn-success timkiem" onclick="timkiem()">Tìm
													kiếm</button>
												<button style="margin-top: 26px" type="button"
													onclick="clearContent()" class="btn btn-danger">Xóa</button>
											</div>

											<!-- </div> -->

											<script type="text/javascript">
												function timkiem() {
													var mahk = document
															.querySelector("#mahk");
													var tinhtrang = document
															.querySelector("#trangthai");
													var ngaybd = document
															.querySelector("#tungay");
													var ngaykt = document
															.querySelector("#denngay");
													var pageSize = document
															.querySelector(".pageSize");

													$
															.ajax({
																url : 'hokhau',
																type : 'GET',
																data : {
																	mahk : mahk.value,
																	tinhtrang : tinhtrang == null ? ""
																			: tinhtrang.value,
																	ngaybd : ngaybd == null ? null
																			: ngaybd.value,
																	ngaykt : ngaykt == null ? null
																			: ngaykt.value,
																	pageSize : pageSize.value
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
												}

												function clearContent() {
													var mahk = document
															.querySelector("#mahk");
													var tinhtrang = document
															.querySelector("#tinhtrang");
													var ngaybd = document
															.querySelector("#tungay");
													var ngaykt = document
															.querySelector("#denngay");

													mahk.value = "";
													if (tinhtrang != null)
														tinhtrang.value = null;
													if (ngaybd != null)
														ngaybd.value = null;
													if (ngaykt != null)
														ngaykt.value = null;
													var pageSize = document
															.querySelector(".pageSize");
													$
															.ajax({
																url : 'hokhau',
																type : 'GET',
																data : {
																	mahk : mahk.value,
																	tinhtrang : tinhtrang == null ? ""
																			: tinhtrang.value,
																	ngaybd : ngaybd == null ? ""
																			: ngaybd.value,
																	ngaykt : ngaykt == null ? ""
																			: ngaykt.value,
																	pageSize : pageSize.value
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
												}
											</script>
											<!-- </div> -->
										</div>


										<table class="content-table" style="width: 100%;">
											<thead>
												<tr>
													<th>STT</th>
													<th>Mã hộ khẩu</th>
													<th>Địa chỉ thường trú</th>
													<th>Ngày đăng ký</th>
													<th>Trạng thái</th>
													<th>Số lượng</th>
												</tr>
											</thead>
											<tbody>

												<c:forEach items="${hokhaus}" var="hk" varStatus="loop">
													<tr class="gradeA odd" role="row">
														<td>${loop.index+1}</td>
														<td class="sorting_1">${hk.idHoKhau}</td>
														<td>${hk.diaChiThuongTru}</td>
														<td>${hk.ngayDangKi}</td>

														<c:if test="${hk.trangThai=='true'}">
															<td class="center">Đã phê duyệt</td>
														</c:if>
														<c:if test="${hk.trangThai!='true'}">
															<td class="center">Chờ phê duyệt</td>
														</c:if>

														<td class="center">${hk.soLuong}</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>

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
											<script type="text/javascript">
												function changePage(text) {
													var mahk = document
															.querySelector("#mahk");
													var tinhtrang = document
															.querySelector("#trangthai");
													var ngaybd = document
															.querySelector("#tungay");
													var ngaykt = document
															.querySelector("#denngay");
													var pageSize = document
															.querySelector(".pageSize");

													$
															.ajax({
																url : 'hokhau',
																type : 'GET',
																data : {
																	mahk : mahk.value,
																	tinhtrang : tinhtrang == null ? ""
																			: tinhtrang.value,
																	ngaybd : ngaybd == null ? null
																			: ngaybd.value,
																	ngaykt : ngaykt == null ? null
																			: ngaykt.value,
																	pageSize : pageSize.value,
																	page : text
																			.trim()
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
												}
											</script>
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