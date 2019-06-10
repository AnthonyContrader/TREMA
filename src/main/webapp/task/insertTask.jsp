<%@ include file="../header.jsp"%>
<%
	List<TaskDTO> resourceList = (List<TaskDTO>) request.getAttribute("resourceList");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">
<meta name="author" content="Hau Nguyen">
<meta name="keywords" content="au theme template">

<!-- Title Page-->
<title>Insert Task</title>

<!-- Fontfaces CSS-->
<link href="/css/font-face.css" rel="stylesheet" media="all">
<link href="/vendor/font-awesome-4.7/css/font-awesome.min.css"
	rel="stylesheet" media="all">
<link href="/vendor/font-awesome-5/css/fontawesome-all.min.css"
	rel="stylesheet" media="all">
<link href="/vendor/mdi-font/css/material-design-iconic-font.min.css"
	rel="stylesheet" media="all">

<!-- Bootstrap CSS-->
<link href="/vendor/bootstrap-4.1/bootstrap.min.css" rel="stylesheet"
	media="all">

<!-- Vendor CSS-->
<link href="/vendor/animsition/animsition.min.css" rel="stylesheet"
	media="all">
<link
	href="/vendor/bootstrap-progressbar/bootstrap-progressbar-3.3.4.min.css"
	rel="stylesheet" media="all">
<link href="/vendor/wow/animate.css" rel="stylesheet" media="all">
<link href="/vendor/css-hamburgers/hamburgers.min.css" rel="stylesheet"
	media="all">
<link href="/vendor/slick/slick.css" rel="stylesheet" media="all">
<link href="/vendor/select2/select2.min.css" rel="stylesheet"
	media="all">
<link href="/vendor/perfect-scrollbar/perfect-scrollbar.css"
	rel="stylesheet" media="all">
<link href="/vendor/vector-map/jqvmap.min.css" rel="stylesheet"
	media="all">

<!-- Main CSS-->
<link href="/css/theme.css" rel="stylesheet" media="all">

</head>

<body>
	<div class="page-wrapper">
		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar2">
			<div class="logo">
				<a href="#"> <img src="/images/icon/wmeslogo2.png"
					alt="Cool Admin" />
				</a>
			</div>
			<div class="menu-sidebar2__content js-scrollbar1">
				<div class="account2">
					<div class="image img-cir img-120">
						<img src="/images/icon/avatarBo.jpg" alt="Business Owner" />
					</div>
					<h4 class="name">Business Owner</h4>
					<a href="/User/logout">Sign out</a>
				</div>
				<nav class="navbar-sidebar2">
					<ul class="list-unstyled navbar__list">
						<li><a href="/Home/homeBO"> <i class="fas fa-chart-bar"></i>Dashboard
						</a></li>
						<li><a href="/Client/clientManagement"> <i
								class="fas fa-user"></i>Clients
						</a></li>
						<li><a href="/Resource/resourceManagement"> <i
								class="fas fa-user"></i>Resources
						</a></li>
						<li><a href="/Order/orderManagement"> <i
								class="fas fa-boxes"></i>Orders
						</a></li>
						<li><a href="/Project/projectManagement"> <i
								class="fas fa-sitemap"></i>Projects
						</a></li>
						<li><a href="/ProjectTemplate/projectTemplateManagement">
								<i class="fas fa-chart-pie"></i>Project Templates
						</a></li>
						<li><a href="/Task/taskManagement"> <i
								class="fas fa-tasks"></i>Tasks
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
												href="/Home/homeBO">Dashboard</a></li>
											<li class="list-inline-item seprate"><span>/</span></li>
											<li class="list-inline-item">Insert Task</li>
										</ul>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- END BREADCRUMB-->
			<section>
				<div class="col-lg-6 center-block">
					<div class="card">
						<div class="card-header">NEW TASK</div>
						<div class="card-body card-block">
							<form action="/Task/insert" method="post" class="">
								<div class="form-group">
									<label>Description</label> <input
										class="au-input au-input--full" type="text"
										name="task_description" placeholder="Description">
								</div>
								<div class="form-group">
									<label>Action</label> <input class="au-input au-input--full"
										type="text" name="task_action" placeholder="Action">
								</div>
								<div class="form-group">
									<label>Input</label> <input class="au-input au-input--full"
										type="text" name="task_input" placeholder="Input">
								</div>
								<div class="form-group">
									<label>Output</label> <input class="au-input au-input--full"
										type="text" name="task_output" placeholder="Output">
								</div>
								<div class="form-group">
									<label>Resource</label> <select class="form-control"
										name="resource_id">
										<%
											for (TaskDTO resourceDTO : resourceList) {
										%>
										<option value="<%=resourceDTO.getIdTask()%>"><%=resourceDTO.getTask()%></option>
										<%
											}
										%>
									</select>
								</div>
								<div class="form-group">
									<label>Time</label> <input class="au-input au-input--full"
										type="number" name="task_time" placeholder="Time">
								</div>
								<div class="form-group">
									<label>State</label> <select class="au-input au-input--full"
										type="radio" name="task_state" placeholder="State">
										<option value="0">Pending</option>
										<option value="1">In progress</option>
										<option value="2">Completed</option>
									</select>

								</div>
								<div class="form-actions form-group">
									<button type="submit" class="btn btn-secondary btn-sm">Submit</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</section>
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
									Trema Team</p>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- END PAGE CONTAINER-->
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
		<script
			src="/vendor/bootstrap-progressbar/bootstrap-progressbar.min.js">
			
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