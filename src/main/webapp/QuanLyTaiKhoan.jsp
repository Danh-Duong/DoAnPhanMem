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

<title>Quản lý tài khoản</title>

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

<link rel="stylesheet" href="css/gioHang.css">
<script src="js/giohang.js"></script>

<link rel="stylesheet" href="css/switch.css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
</head>

<body>

	<jsp:include page="banner.jsp"></jsp:include>

	<div id="page-wrapper" style="min-height: 279px;">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-12">
					<h2 style="margin: 34px 0 20px;" class="page-header">Quản lí tài khoản</h2>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">Thông tin tài khoản</div>
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

									<div class="row">
										<div class="col-sm-12">
											<table
												class="table table-striped table-bordered table-hover dataTable no-footer"
												id="dataTables-example" role="grid"
												aria-describedby="dataTables-example_info">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1" aria-sort="ascending"
															aria-label="Rendering engine: activate to sort column descending"
															style="width: 40px;">STT</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="Browser: activate to sort column ascending"
															style="width: 150px;">CCCD</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="Platform(s): activate to sort column ascending"
															style="width: 150px;">Họ tên</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="Engine version: activate to sort column ascending"
															style="width: 172.2px;">Email</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="CSS grade: activate to sort column ascending"
															style="width: 127px;">Mã quyền</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="CSS grade: activate to sort column ascending"
															style="width: 127px;">Ngày cấp</th>
														<th class="sorting" tabindex="0"
															aria-controls="dataTables-example" rowspan="1"
															colspan="1"
															aria-label="CSS grade: activate to sort column ascending"
															style="width: 127px;">Hành động</th>
													</tr>
												</thead>
												<tbody>

													<c:forEach items="${taikhoans}" var="tk" varStatus="loop">
														<tr class="gradeA odd" role="row">
															<td>${loop.index+1}</td>
															<td class="sorting_1">${tk.cccd}</td>
															<td class="sorting_1">${tk.hoten}</td>
															<td class="sorting_1">${tk.email}</td>
															<td>${tk.maQuyen}</td>
															<td class="center">${tk.ngayCapStr}</td>
															<td style="width: 15%"><label class="switch">
																	<!--   <input type="checkbox" checked> --> <input
																	type="checkbox" ${tk.trangThai ? 'checked' : ''}
																	onchange="updateTk('${tk.cccd}',this.checked)">
																	<span class="slider round"></span>
															</label> 
															<%-- <i onclick="removeCustomer(${tk.cccd})"
																class="fa-solid fa-trash-can"></i> --%>
																<img onclick="deleteTk('${tk.cccd}')" style="width: 30px;
    position: relative;
    top: 9px;
    left: 5px; cursor: pointer;" src="./img/delete.png">
																</td>
														</tr>
													</c:forEach>

													<script>		
			
			function deleteTk(matk) {
		        // Gửi yêu cầu xóa khách hàng bằng AJAX
		        $.ajax({
		            url: "taikhoan",
		            type: "GET",
		            data: { action: "delete", matk: matk },
		            success: function(response) {
						$('body')
						.html(
								response);
		            },
		            error: function(xhr, status, error) {
		                // Xử lý lỗi nếu có
		            }
		        });
		    }

		    function updateTk(matk, checked) {
		    	console.log("Danh: " + matk);
		        var type = checked ? 1 : 0;
		        // Gửi yêu cầu cập nhật trạng thái của khách hàng bằng AJAX
		        $.ajax({
		            url: "taikhoan",
		            type: "GET",
		            data: { action: "update", matk: matk, type: type },
		            success: function(response) {
		                // Xử lý kết quả nếu cần
		            },
		            error: function(xhr, status, error) {
		                // Xử lý lỗi nếu có
		            }
		        });
		    }
			
			
		</script>
												</tbody>
											</table>
										</div>
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