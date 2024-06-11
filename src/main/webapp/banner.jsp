<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="wrapper">

	<!-- Navigation -->
	<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"
		style="padding: 10px;">
		<div class="navbar-header">
			<img src="img/logo.png" style="width: 64px; float: left;"> <a
				class="navbar-brand" href="admin"
				style="margin-top: 3px; color: white;">Phường Thanh Bình - Hải
				Châu</a>
		</div>

		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target=".navbar-collapse">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
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
	<aside class="sidebar navbar-default" role="navigation"
		style="margin-top: 82px;">
		<div class="sidebar-nav navbar-collapse">
			<ul class="nav in" id="side-menu">
				<li class="sidebar-search">
					<div class="input-group custom-search-form">
						<input type="text" class="form-control" placeholder="Search...">
						<span class="input-group-btn">
							<button class="btn btn-primary" type="button"
								style="padding: 9px 12px;">
								<i class="fa fa-search"></i>
							</button>
						</span>
					</div> <!-- /input-group -->
				</li>
				<li><a href="admin"><i class="fa-solid fa-house"
						style="color: #337ab7; margin: 0 4px;"></i> Trang chủ</a></li>
				<li><a href="#"><i class="fa-regular fa-file-lines"
						style="color: #337ab7; margin: 0 8px 0 6px; font-size: 17px;"></i>
						Hồ sơ<span class="fa arrow"></span></a>
					<ul class="nav nav-second-level">
						<li><a href="duyetKhaiSinh">Đăng ký khai sinh</a></li>
						<li><a href="duyetKhaiTu">Đăng ký khai tử</a></li>
						<li><a href="duyetTamVang">Đăng ký tạm vắng</a></li>
						<li><a href="duyetTamTru">Đăng ký tạm trú</a></li>
					</ul> <!-- /.nav-second-level --></li>
				<li><a href="hokhau"><i class="fa-solid fa-people-roof"
						style="color: #337ab7; margin: 0 4px;"></i> Hộ khẩu</a></li>
				<li><a href="nhankhau"><i class="fa-solid fa-user"
						style="color: #337ab7; margin: 0 7px;"></i> Nhân khẩu</a></li>
				<li><a href="taikhoan"><i class="fa-solid fa-user"
						style="color: #337ab7; margin: 0 7px;"></i> Tài khoản</a></li>
			</ul>
		</div>
		<!-- /.sidebar-collapse -->
	</aside>
	<!-- /.sidebar -->
</div>