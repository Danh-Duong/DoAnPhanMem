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
		

		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Dashboard</h1>
					</div>
					<!-- /.col-lg-12 -->
				</div>
				<!-- /.row -->
				<div class="row">
					<div class="col-lg-3 col-md-6">
						<div class="panel panel-primary">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa-solid fa-people-roof"
											style="color: #ffffff;
    font-size: 57px;
    padding: 7px;"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">${numbProduct}</div>
										<div>Hộ khẩu</div>
									</div>
								</div>
							</div>
							<a href="products">
								<div class="panel-footer">
									<span class="pull-left">View Details</span> <span
										class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

									<div class="clearfix"></div>
								</div>
							</a>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="panel panel-green">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa-solid fa-user" style="color: #ffffff;
    font-size: 57px;
    padding: 7px;"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">${numbCatalog}</div>
										<div>Nhân khẩu</div>
									</div>
								</div>
							</div>
							<a href="catalogs">
								<div class="panel-footer">
									<span class="pull-left">View Details</span> <span
										class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

									<div class="clearfix"></div>
								</div>
							</a>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="panel panel-yellow">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa-solid fa-person" style="color: #ffffff;
    font-size: 57px;
    padding: 7px;"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">${numbBill}</div>
										<div>Khai sinh</div>
									</div>
								</div>
							</div>
							<a href="bills">
								<div class="panel-footer">
									<span class="pull-left">View Details</span> <span
										class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

									<div class="clearfix"></div>
								</div>
							</a>
						</div>
					</div>
					<div class="col-lg-3 col-md-6">
						<div class="panel panel-red">
							<div class="panel-heading">
								<div class="row">
									<div class="col-xs-3">
										<i class="fa fa-support fa-5x"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">${numbCustomer}</div>
										<div>Khai tử</div>
									</div>
								</div>
							</div>
							<a href="customers">
								<div class="panel-footer">
									<span class="pull-left">View Details</span> <span
										class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>

									<div class="clearfix"></div>
								</div>
							</a>
						</div>
					</div>
				</div>



				<div style="display: flex; margin-top: 20px">
					<div style="width: 50%">
						<canvas id="sale-revenue"></canvas>
					</div>

					<div style="width: 50%">
						<div>
							<select onchange="changePageSize(this)"
								name="dataTables-example_length"
								aria-controls="dataTables-example"
								class="form-control input-sm pageSize" style="width: 200px;  float: right;">
								<option ${year==2024?'selected':''} value="2024">2024</option>
								<option ${year==2023?'selected':''} value="2023">2023</option>
								<option ${year==2022?'selected':''} value="2022">2022</option>
								<option ${year==2021?'selected':''} value="2021">2021</option>
								<option ${year==2020?'selected':''} value="2020">2020</option>
							</select>
						</div>
						<script type="text/javascript">
												 function changePageSize(selectElement) {
												    var selectedValue = selectElement.value;																								     
											    	/* window.locatin.href = "admin?year=" + selectedValue;  */
												    $.ajax({
										    		    url: 'admin',
										    		    type: 'GET',
										    		    data: {
										    		        year: selectedValue
										    		    },
										    		    success: function(response) {											    		   
										    		    	$('body').html(response);
										    		    },
										    		    error: function(xhr, status, error) {
										    		        // Xử lý lỗi ở đây
										    		    }
										    		});
												} 
												

											 </script>
						<canvas id="sale-number"></canvas>
					</div>
				</div>
				<script
					src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.js">
		
	</script>
				<script>
				var chart = document.getElementById("sale-revenue").getContext("2d");
				var myChart = new Chart(chart,{
				    type: "line",
				    data:{
				        labels: ["2018","2019","2020","2021","2022","2023","2024"], 
				        datasets: [{
				            label: "Revenue",
				            data: [${requestScope.year18},${requestScope.year19},${requestScope.year20},${requestScope.year21},${requestScope.year22},${requestScope.year23},${requestScope.year24}],
				            backgroundColor: "rgba(0,156,255, .5)"
				        }]
				    },
				    
				    options : {
				        responsive : true
				    }
				});
				
				
				
 				var xValues = ["Nokia", "Iphone", "Oppo", "Xiaomi", "Vivo", "Htc", "Mobistar", "Realme", "Huawei", "Samsung"];
				var yValues = [${requestScope.Nokia},${requestScope.Iphone},${requestScope.Oppo},${requestScope.Xiaomi},${requestScope.Vivo},${requestScope.Htc},${requestScope.Mobistar},${requestScope.Realme},${requestScope.Huawei},${requestScope.Samsung}];
				
				var barColors = [
					  "#b91d47",
					  "#00aba9",
					  "#2b5797",
					  "#e8c3b9",
					  "#1e7145",
					  "#f0a30a",
					  "#8e44ad",
					  "#3498db",
					  "#f39c12",
					  "#16a085"
					]; 
					
/* 					var xValues = [];
					var yValues = [];

					<c:forEach var="entry" items="${requestScope.catalogData}">
					  <c:set var="catalogName" value="${entry.name}" />  <c:set var="productCount" value="${entry.numb}" />  xValues.push(catalogName);
					  yValues.push(productCount);
					</c:forEach> */

				new Chart("sale-number", {
				  type: "doughnut",
				  data: {
				    labels: xValues,
				    datasets: [{
				      backgroundColor: barColors,
				      data: yValues
				    }]
				  },
				  options: {
				    title: {
				      display: true,
				      text: "Số lượng bán hàng năm " + ${requestScope.year}
				    }
				  }
				});

				</script>







			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

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