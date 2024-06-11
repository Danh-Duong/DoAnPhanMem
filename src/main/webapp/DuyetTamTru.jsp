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

<title>Hồ sơ khai sinh</title>

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

	<jsp:include page="banner.jsp"></jsp:include>

	<div id="page-wrapper" style="min-height: 279px;">
		<div class="container-fluid">
			<h4 class="page-header">Hồ sơ đăng ký tạm trú (${slhoso})</h4>
			<div style="width: 100%; height: 2px; background-color: #d19410;"></div>

			<div>
				<c:if test="${success!=null}">
					<div class="alert alert-success" style="margin-top: 13px">
						<button type="button" class="close" data-dismiss="alert"
							aria-hidden="true">×</button>
						${success}
					</div>

				</c:if>
				<div style="display: flex; align-items: center; margin-top: 14px;">
					<p style="margin: 0 10px 0 0;">Trạng thái</p>
					<select id="trangthai" class="form-select" name="trangthai"
						onchange="changeTrangthai(this)"
						style="padding: 5px 5px 6px; border-color: #c1c1c1; border-radius: 4px; width: 175px; height: 30px;">
						<option value="1" ${trangthai=="1" ? "selected" : ""}>Đã
							duyệt</option>
						<option value="0" ${trangthai=="0" ? "selected" : ""}>Chờ
							xét duyệt</option>
						<option value="-1" ${trangthai=="-1" ? "selected" : ""}>Đã
							hủy</option>

					</select>
				</div>
				<c:forEach items="${hoso}" var="hs" varStatus="loop">
					<c:if test="${trangthai=='1'}">
						<div class="alert alert-info" style="margin-top: 20px;">
							${loop.index+1}. Mã hồ sơ: ${hs.maTamTru} - CCCD:
							${hs.cccd} <a style="float: right;"
								href="duyetTamTru?mahs=${hs.maTamTru}"
								class="alert-link"> Chi tiết</a>
							<ul style="margin: 10px 0 0 0;">
								<li>Họ tên: ${hs.hoten}</li>
								<li style="margin: 5px 0 0;">Địa chỉ đăng ký: ${hs.diaChiDangKi}</li>
							</ul>

						</div>
					</c:if>

					<c:if test="${trangthai=='0'}">
						<div class="alert alert-warning" style="margin-top: 20px;">
							${loop.index+1}. Mã hồ sơ: ${hs.maTamTru} - CCCD:
							${hs.cccd} <a style="float: right;"
								href="duyetTamTru?mahs=${hs.maTamTru}"
								class="alert-link"> Chi tiết</a>
							<ul style="margin: 10px 0 0 0;">
								<li>Họ tên: ${hs.hoten}</li>
								<li style="margin: 5px 0 0;">Địa chỉ đăng ký: ${hs.diaChiDangKi}</li>
							</ul>
						</div>
					</c:if>

					<c:if test="${trangthai=='-1'}">
						<div class="alert alert-danger" style="margin-top: 20px;">
							${loop.index+1}. Mã hồ sơ: ${hs.maTamTru} - CCCD:
							${hs.cccd} <a style="float: right;"
								href="duyetTamTru?mahs=${hs.maTamTru}"
								class="alert-link"> Chi tiết</a>
							<ul style="margin: 10px 0 0 0;">
								<li>Họ tên: ${hs.hoten}</li>
								<li style="margin: 5px 0 0;">Địa chỉ đăng ký: ${hs.diaChiDangKi}</li>
							</ul>
						</div>
					</c:if>

				</c:forEach>
			</div>

			<script type="text/javascript">
				function changeTrangthai(selectElement) {
					var selectedValue = selectElement.value;
					console.log("Test: " + selectedValue);
					$.ajax({
						url : 'duyetTamTru',
						type : 'GET',
						data : {
							trangthai : selectedValue
						},
						success : function(response) {
							$('body').html(response);
						},
						error : function(xhr, status, error) {
							// Xử lý lỗi ở đây
						}
					});
				}
			</script>
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