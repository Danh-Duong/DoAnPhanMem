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

<title>Admin</title>

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


		<div id="page-wrapper">
			<div class="container-fluid" style="margin-top:27px">
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
											style="color: #ffffff; font-size: 57px; padding: 7px;"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">${hokhaus}</div>
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
										<i class="fa-solid fa-user"
											style="color: #ffffff; font-size: 57px; padding: 7px;"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">${nhankhaus}</div>
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
										<i class="fa-solid fa-person"
											style="color: #ffffff; font-size: 57px; padding: 7px;"></i>
									</div>
									<div class="col-xs-9 text-right">
										<div class="huge">${khaisinhs}</div>
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
										<div class="huge">${khaitus}</div>
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
						<p style="    text-align: center;
    font-weight: 600;
    color: #838383;">Đăng ký tạm trú, tạm vắng năm ${year}</p>
						<canvas id="sale-revenue"></canvas>
					</div>

					<div style="width: 50%">
						<div>
							<select onchange="changePageSize(this)"
								name="dataTables-example_length"
								aria-controls="dataTables-example"
								class="form-control input-sm pageSize"
								style="width: 200px; float: right;">
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
/* 				var chart = document.getElementById("sale-revenue").getContext("2d");
				var xValues = ["Quý 1", "Quý 2", "Quý 3", "Quý 4"];
				var yValues = [${requestScope.tt1}, ${requestScope.tt2},${requestScope.tt3},${requestScope.tt4}];
				var barColors = ["red", "green","blue","orange"];
				
				var myChart = new Chart(chart,{
				    type: "line",
				    data:{
				        labels: xValues, 
				        datasets: [{
				            label: "Thống kê tạm trú",
				            data: yValues ,
				            backgroundColor: "rgba(0,156,255, .5)"
				        }]
				    },
				    
				    options : {
				        responsive : true,
				        scales: {
				            yAxes: [{ // Đối với phiên bản Chart.js 2.x
				                ticks: {
				                    stepSize: 1 // Chia tỉ lệ theo bước 1
				                }
				            }]
				        }
				    }
				}); */
				
				var chart = document.getElementById("sale-revenue").getContext("2d");
				var xValues = ["Quý 1", "Quý 2", "Quý 3", "Quý 4"];
				var yValuesTT = [${requestScope.tt1}, ${requestScope.tt2},${requestScope.tt3},${requestScope.tt4}];
				var yValuesTV = [${requestScope.tv1}, ${requestScope.tv2},${requestScope.tv3},${requestScope.tv4}];
			
				var myChart = new Chart(chart,{
				    type: "line",
				    data: {
				        labels: xValues,
				        datasets: [{
				        	label:"Tạm trú",
				          data: yValuesTT,
				          borderColor: "orange",
				          fill: false
				        },{
				        label:"Tạm vắng",
				          data: yValuesTV,
				          borderColor: "green",
				          fill: false
				        }]
				      },
				      options: {
				        legend: {display: true},
				        scales: {
				            yAxes: [{ // Đối với phiên bản Chart.js 2.x
				                ticks: {
				                    stepSize: 1 // Chia tỉ lệ theo bước 1
				                }
				            }]
				        }
				      }
				    });
				
				
				
 				var xValues = ["Khai sinh", "Khai tử"];
				var yValues = [${requestScope.ks},${requestScope.kt}];
				
				var barColors = [
					  "#00aba9",
					  "#b91d47"
					]; 
					

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
				      text: "Số lượng khai sinh, khai tử năm " + ${requestScope.year}
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