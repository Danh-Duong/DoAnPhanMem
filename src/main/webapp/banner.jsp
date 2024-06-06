<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<aside class="sidebar navbar-default" role="navigation">
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
					<li><a href="#"><i
							class="fa-regular fa-file-lines"
							style="color: #337ab7; margin: 0 8px 0 6px; font-size: 17px;"></i>
							Hồ sơ<span class="fa arrow"></span></a>
						<ul class="nav nav-second-level">
							<li><a href="duyetKhaiSinh">Đăng
									ký khai sinh</a></li>
							<li><a href="morris.html">Đăng ký khai tử</a></li>
						</ul> <!-- /.nav-second-level --></li>
					<li><a href="hokhau"><i class="fa-solid fa-people-roof"
							style="color: #337ab7; margin: 0 4px;"></i> Hộ khẩu</a></li>
					<li><a href="catalogs"><i class="fa-solid fa-user"
							style="color: #337ab7; margin: 0 7px;"></i> Nhân khẩu</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</aside>
		<!-- /.sidebar -->