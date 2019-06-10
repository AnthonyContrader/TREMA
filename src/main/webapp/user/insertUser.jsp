<%@ include file="../header.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags-->
    <!--===============================================================================================-->
    <meta charset="UTF-8">
    <!--===============================================================================================-->
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!--===============================================================================================-->
    <meta name="description" content="au theme template">
    <!--===============================================================================================-->

    <!-- Title Page-->
    <title>Dashboard</title>

    <!-- Fontfaces CSS-->
    <!--===============================================================================================-->
    <link href="/css/font-face.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->
    <link href="/vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
    <link href="/vendor/font-awesome-5/css/fontawesome-all.min.css" rel="stylesheet" media="all">
    <link href="/vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->

    <!-- Bootstrap CSS-->
    <!--===============================================================================================-->
    <link href="/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->

    <!-- Vendor CSS-->
    <link href="/vendor/animsition/animsition.min.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->
    <link href="/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->
    <link href="/vendor/wow/animate.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->
    <link href="/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->
    <link href="/vendor/slick/slick.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->
    <link href="/vendor/select2/select2.min.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->
    <link href="/vendor/perfect-scrollbar/perfect-scrollbar.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->
    <link href="/vendor/vector-map/jqvmap.min.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->

    <!-- Main CSS-->
    <!--===============================================================================================-->
    <link href="/css/theme.css" rel="stylesheet" media="all">
    <!--===============================================================================================-->

</head>

<body>
	<div class="page-wrapper">
		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar2">
			<div class="logo">
		<!--  		<a href="#"> <img src="/images/icon/wmeslogo2.png"
					alt="Cool Admin" />
				</a>-->
			</div>
			<div class="menu-sidebar2__content js-scrollbar1">
				<div class="account2">
					<h4 class="name">Admin</h4>
					<a href="/User/logout">Sign out</a>
				</div>
				<nav class="navbar-sidebar2">
					<ul class="list-unstyled navbar__list">
						<li><a href="/Home/homeAdmin"> <i
								class="fas fa-chart-bar"></i>Dashboard
						</a></li>

						<li><a href="/User/userManagement"> <i
								class="fas fa-user"></i>Users
						</a></li>

					</ul>
				</nav>
			</div>
		</aside>
		<!-- END MENU SIDEBAR-->

		<!-- PAGE CONTAINER-->
		<div class="page-container2">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop2">
				<div class="section__content section__content--p30">
					<div class="container-fluid">

					</div>
				</div>
			</header>

			<!-- END HEADER DESKTOP-->

			<!-- BREADCRUMB-->
			<section class="au-breadcrumb m-t-75">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-8">
								<div class="au-breadcrumb-content">
									<div class="au-breadcrumb-left">
										<span class="au-breadcrumb-span">You are here:</span>
										<ul class="list-unstyled list-inline au-breadcrumb__list">
											<li class="list-inline-item active"><a
												href="/Home/homeAdmin">Dashboard</a></li>
											<li class="list-inline-item seprate"><span>/</span></li>
											<li class="list-inline-item">Insert User</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- END BREADCRUMB-->

			<!-- START statistic -->
			<section>
				<div class="col-lg-6 center-block">
					<div class="card">
						<div class="card-header">NEW USER</div>
						<div class="card-body card-block">
							<form action="/User/insert" method="post">
								<div class="form-group">
									<label>Username</label> <input class="au-input au-input--full"
										type="text" name="user" placeholder="Username">
								</div>

								<div class="form-group">
									<label>Password</label> <input class="au-input au-input--full"
										type="password" name="password" placeholder="Password">
								</div>
								<div class="form-group">
									<label>Name</label> <input class="au-input au-input--full"
										type="text" name="name_user" placeholder="name_user">
								</div>
								<div class="form-group">
									<label>Surname</label> <input class="au-input au-input--full"
										type="text" name="surname_user" placeholder="surname_user">
								</div>
								<div class="form-group">
									<label>Azienda</label> <input class="au-input au-input--full"
										type="text" name="azienda" placeholder="azienda">
								</div>

								<div class="form-group">
									<label>UserType</label> <select class="form-control"
										name="usertype">
										<option value="admin">Admin</option>
										<option value="user">User</option>
									</select>
									<!-- <input class="au-input au-input--full" type="text" name="usertype" placeholder="UserType">
 -->
								</div>
								<div class="login-checkbox"></div>
								<button type="submit" class="btn btn-secondary btn-sm">Submit</button>
							</form>
						</div>

					</div>
				</div>
			</section>
			<!-- END Statistic -->
			<section>
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-xl-8"></div>
							<div class="col-xl-4"></div>
						</div>
					</div>
				</div>
			</section>

			<section>
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="row">
							<div class="col-xl-6"></div>
							<div class="col-xl-6"></div>
						</div>
					</div>
				</div>
			</section>

			<section>
				<div class="container-fluid">
					<div class="row">
						<div class="col-md-12">
							<div class="copyright">
								<p>Copyright � 2019 Trema. All rights reserved. Template by
									Trema</p>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- END PAGE CONTAINER-->
		</div>
	</div>

	  <!-- Jquery JS-->
    <script src="/vendor/jquery-3.2.1.min.js"></script>
    <!-- Bootstrap JS-->
    <script src="/vendor/bootstrap-4.1/popper.min.js"></script>
    <script src="/vendor/bootstrap-4.1/bootstrap.min.js"></script>
    <!-- Vendor JS       -->
    <script src="/vendor/slick/slick.min.js">
    </script>
    <script src="/vendor/wow/wow.min.js"></script>
    <script src="/vendor/animsition/animsition.min.js"></script>
    <script src="/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
    </script>
    <script src="/vendor/counter-up/jquery.waypoints.min.js"></script>
    <script src="/vendor/counter-up/jquery.counterup.min.js">
    </script>
    <script src="/vendor/circle-progress/circle-progress.min.js"></script>
    <script src="/vendor/perfect-scrollbar/perfect-scrollbar.js"></script>
    <script src="/vendor/chartjs/Chart.bundle.min.js"></script>
    <script src="/vendor/select2/select2.min.js">
    </script>
    <script src="/vendor/vector-map/jquery.vmap.js"></script>
    <script src="/vendor/vector-map/jquery.vmap.min.js"></script>
    <script src="/vendor/vector-map/jquery.vmap.sampledata.js"></script>
    <script src="/vendor/vector-map/jquery.vmap.world.js"></script>

    <!-- Main JS-->
    <script src="/js/main.js"></script>

</body>

</html>
<!-- end document-->