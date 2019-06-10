<%@ include file="header.jsp"%>
<%
	List<ProjectDTO> allProject = (List<ProjectDTO>) request.getAttribute("allProjectDTO");	
	List<TaskDTO> allTask = (List<TaskDTO>) request.getAttribute("allTaskDTO");	
	/*  */List<DipendentiDTO> allDipendenti=(List<DipendentiDTO>) request.getAttribute("allDipendenti");
	/*  */List<MaterialDTO> allMaterial=(List<MaterialDTO>) request.getAttribute("allMaterial");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags-->
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="au theme template">

<!-- Title Page-->
<title>Dashboard 2</title>

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
<<<<<<< Updated upstream
    <div class="page-wrapper">
        <!-- MENU SIDEBAR-->
        <aside class="menu-sidebar2">
            <div class="logo">
                <a href="/User/login">
                    <img src="/images/icon/TremaLogo.jpg" alt="Trema Logo" />
                </a>
            </div>
            <div class="menu-sidebar2__content js-scrollbar1">
                <div class="account2">
                    <div class="image img-cir img-120">
                        <img src="/images/icon/avatarbig01.jpg" alt="Gianluca Di Nanna" />
                    </div>
                    <h4 class="name">User XXX</h4>
                    <a href="/User/logout">Sign out</a>
                </div>
                <div class="menu-sidebar__content js-scrollbar1">
                	<a href="/Project/insertRedirect">
                     	<button class="au-btn au-btn-icon au-btn--blue" title="Insert project"><i class="zmdi zmdi-plus"></i></button>
                     	</a>
                	<div class="table table-top-campaign">
                        <table class="table">
                            <thead>
                                <tr>
                                    <td align="left">PROJECTS</td>
                                </tr>
                            </thead>
	                        <tbody>
	                        	<% for (ProjectDTO projectDTO: allProject) { %>
	                                <tr>
	                                    <td>
	                                        <div class="table-data__info">
	                                            <h3><%=projectDTO.getProject() %></h3>
	                                            <h6>(<%=projectDTO.getTipologie() %>)</h6>
	                                        </div>
	                                    </td>
	                                    <td>
											<div class="table-data-feature">
                                            	<a href="/Project/updateRedirect?id=<%=projectDTO.getIdProject()%>" class="item" 
                                            	data-toggle="tooltip" data-placement="top" title="Edit project"> 
                                            	<i class="zmdi zmdi-edit"></i></a>
                                            	<a href="/Project/delete?id=<%=projectDTO.getIdProject()%>" class="item" 
                                            	data-toggle="tooltip" data-placement="top" title="Delete project"> 
                                            	<i class="zmdi zmdi-delete"></i></a>
                                            </div>
                                        </td>
	                                </tr>
	                            <% } %>
	                        </tbody>
                        </table>
                    </div>
                </div>
               
            </div>
        </aside>
        <!-- END MENU SIDEBAR-->
=======
	<div class="page-wrapper">
		<!-- MENU SIDEBAR-->
		<aside class="menu-sidebar2">
			<div class="logo">
				<a href="/User/login"> <img src="/images/icon/TremaLogo.png"
					alt="Trema Logo" />
				</a>
			</div>
			<div class="menu-sidebar2__content js-scrollbar1">
				<div class="account2">
					<div class="image img-cir img-120">
						<img src="/images/icon/avatar-big-01.jpg" alt="John Doe" />
					</div>
					<h4 class="name">User XXX</h4>
					<a href="/User/logout">Sign out</a>
				</div>
				<div class="menu-sidebar__content js-scrollbar1">
					<button class="au-btn au-btn-icon au-btn--blue"
						title="Insert project">
						<i class="zmdi zmdi-plus"></i>
					</button>
					<div class="table table-top-campaign">
						<table class="table">
							<thead>
								<tr>
									<td align="left">PROJECTS</td>
								</tr>
							</thead>
							<tbody>
								<% for (ProjectDTO projectDTO: allProject) { %>
								<tr>
									<td>
										<div class="table-data__info">
											<h3><%=projectDTO.getProject() %></h3>
											<h6><%=projectDTO.getTipologie() %>)</h6>
										</div>
									</td>
									<td>
										<div class="table-data-feature">
											<a
												href="/Project/updateRedirect?id=<%=projectDTO.getIdProject()%>"
												class="item" data-toggle="tooltip" data-placement="top"
												title="Edit project"> <i class="zmdi zmdi-edit"></i></a> <a
												href="/Project/delete?id=<%=projectDTO.getIdProject()%>"
												class="item" data-toggle="tooltip" data-placement="top"
												title="Delete project"> <i class="zmdi zmdi-delete"></i></a>
										</div>
									</td>
								</tr>
								<% } %>
							</tbody>
						</table>
					</div>
				</div>
>>>>>>> Stashed changes

			</div>
		</aside>
		<!-- END MENU SIDEBAR-->

		<!-- PAGE CONTAINER-->
		<div class="page-container2">
			<!-- HEADER DESKTOP-->
			<header class="header-desktop2">
				<div class="section__content section__content--p30">
					<div class="container-fluid">
						<div class="header-wrap2">
							<div class="logo d-block d-lg-none">
								<a href="#"> <img src="/images/icon/logo-white.png"
									alt="CoolAdmin" />
								</a>
							</div>
							<div id=”ombra”>
								<h1>TREMA</h1>
							</div>
							<div class="header-button2">
								<div class="header-button-item js-item-menu">
									<i class="zmdi zmdi-search"></i>
									<div class="search-dropdown js-dropdown">
										<form action="">
											<input class="au-input au-input--full au-input--h65"
												type="text" placeholder="Search for datas &amp; reports..." />
											<span class="search-dropdown__icon"> <i
												class="zmdi zmdi-search"></i>
											</span>
										</form>
									</div>
								</div>
								<div class="header-button-item has-noti js-item-menu">
									<i class="zmdi zmdi-notifications"></i>
									<div class="notifi-dropdown js-dropdown">
										<div class="notifi__title">
											<p>You have 3 Notifications</p>
										</div>
										<div class="notifi__item">
											<div class="bg-c1 img-cir img-40">
												<i class="zmdi zmdi-email-open"></i>
											</div>
											<div class="content">
												<p>You got a email notification</p>
												<span class="date">April 12, 2018 06:50</span>
											</div>
										</div>
										<div class="notifi__item">
											<div class="bg-c2 img-cir img-40">
												<i class="zmdi zmdi-account-box"></i>
											</div>
											<div class="content">
												<p>Your account has been blocked</p>
												<span class="date">April 12, 2018 06:50</span>
											</div>
										</div>
										<div class="notifi__item">
											<div class="bg-c3 img-cir img-40">
												<i class="zmdi zmdi-file-text"></i>
											</div>
											<div class="content">
												<p>You got a new file</p>
												<span class="date">April 12, 2018 06:50</span>
											</div>
										</div>
										<div class="notifi__footer">
											<a href="#">All notifications</a>
										</div>
									</div>
								</div>
								<div class="header-button-item mr-0 js-sidebar-btn">
									<i class="zmdi zmdi-menu"></i>
								</div>
								<div class="setting-menu js-right-sidebar d-none d-lg-block">
									<div class="account-dropdown__body">
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-account"></i>Account
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-settings"></i>Setting
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-money-box"></i>Billing
											</a>
										</div>
									</div>
									<div class="account-dropdown__body">
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-globe"></i>Language
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-pin"></i>Location
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-email"></i>Email
											</a>
										</div>
										<div class="account-dropdown__item">
											<a href="#"> <i class="zmdi zmdi-notifications"></i>Notifications
											</a>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</header>
			<aside class="menu-sidebar2 js-right-sidebar d-block d-lg-none">
				<div class="logo">
					<a href="#"> <img src="/images/icon/logo-white.png"
						alt="Cool Admin" />
					</a>
				</div>
			</aside>
			<!-- END HEADER DESKTOP-->

			<div class="main-content">
				<div class="section__content section__content--p30">
					<div class="container-fluid">

						<div class="row">
							<div class="col-lg-4">
								<div class="user-data m-b-30">
									<h5 class="title-3 m-b-30">
										<i class="title-3 m-b-30"></i>Task
									</h5>
									<div class="table-data-feature">
										<button class="item" data-toggle="tooltip"
											data-placement="top" title="Send">
											<i class="zmdi zmdi-mail-send"></i>
										</button>
										<button class="item" data-toggle="tooltip"
											data-placement="top" title="More">
											<i class="zmdi zmdi-more"></i>
										</button>
									</div>
									<table class="table">
										<thead>
											<tr>
												<td><h6>Task /<br>Objectives</h6></td>
												<td><h6>Data inizio</h6></td>
												<td><h6>Data fine</h6></td>
											</tr>
										</thead>
										<tbody>
											<% for (TaskDTO taskDTO: allTask) {%>
											<tr>
												<td>
													<div class="table-data__info">
														<h6><strong><%=taskDTO.getTask() %>)</strong></h6><br>
														<h6><%=taskDTO.getObjective() %>)</h6><br>
													</div>
												</td>
												<td>
													<h6><%=taskDTO.getData_inizio() %>)</h6>
												</td>
												<td>
													<div class="table-data__info">
														<h6><%=taskDTO.getData_fine() %>)</h6>
													</div>
													<div class="table-data-feature">
														<button class="item" data-toggle="tooltip"
															data-placement="top" title="Edit">
															<i class="zmdi zmdi-edit"></i>
														</button>
														<button class="item" data-toggle="tooltip"
															data-placement="top" title="Delete">
															<i class="zmdi zmdi-delete"></i>
														</button>
													</div>
												</td>
											</tr>
											<% } %>
										</tbody>
									</table>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="user-data m-b-30">
                                    <h5 class="title-3 m-b-30">
                                        <i class="title-3 m-b-30"></i>Dipendenti</h5>
                                    <div class="table-data-feature">
                                                        <button
											class="item" data-toggle="tooltip" data-placement="top"
											title="Send">
                                                            <i
												class="zmdi zmdi-mail-send"></i>
                                                        </button>                                       
                                                        <button
											class="item" data-toggle="tooltip" data-placement="top"
											title="More">
                                                            <i
												class="zmdi zmdi-more"></i>
                                                        </button>
                                                    </div>
                                    <table class="table">
                                        <thead>
                                                <tr>
                                                    <td>Dipendenti</td>
                                                    <td>Task</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>
                                                        Gianluca Di Nanna
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Define User</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Adrian Papuc
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Define Features</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Ali Tavakkoli
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Finalais Journey User</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                            
										<tbody>
                                                <tr>
                                                    <td>
                                                        Angel Mata
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Bollire l'acqua</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                       Giuseppe Macchia
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Calare la pasta</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Salvatore Iurlo
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Vedere se è cotta</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                
                                            </tbody>
                                           
                                            <tbody>
                                                <tr>
                                                    <td>
                                                        Gianni Girone
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Define User</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Babba Tartuga
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Define Features</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Carletto Mazzone
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Finalais Journey User</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                
                                            
										<tbody>
                                                <tr>
                                                    <td>
                                                        Federico Mari
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Bollire l'acqua</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Carlo Misa
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Calare la pasta</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Maurizio Petagna
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Vedere se è cotta</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                
                                            </tbody>
                                        </table>
                                </div>
                            </div>
                            <div class="col-lg-4">
                                <div class="user-data m-b-30">
                                    <h5 class="title-3 m-b-30">
                                        <i class="title-3 m-b-30"></i>Materiali</h5>
                                    <div class="table-data-feature">
                                                        <button
											class="item" data-toggle="tooltip" data-placement="top"
											title="Send">
                                                            <i
												class="zmdi zmdi-mail-send"></i>
                                                        </button>                                       
                                                        <button
											class="item" data-toggle="tooltip" data-placement="top"
											title="More">
                                                            <i
												class="zmdi zmdi-more"></i>
                                                        </button>
                                                    </div>
                                    <table class="table">
                                        <thead>
                                                <tr>
                                                    <td>Materiali</td>
                                                    <td>Task</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr>
                                                    <td>
                                                       Martello
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Define User</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Cazzola
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Define Features</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Pressa
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Finalais Journey User</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                            
										<tbody>
                                                <tr>
                                                    <td>
                                                        Scolapasta
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Bollire l'acqua</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Colino
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Calare la pasta</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                       Mestolo
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Vedere se è cotta</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                
                                            </tbody>
                                             
                                            <tbody>
                                                <tr>
                                                    <td>
                                                       Martellp
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Define User</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Cemento
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Define Features</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                       Cazzola
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Finalais Journey User</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                
                                            
										<tbody>
                                                <tr>
                                                    <td>
                                                        Trapano
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Bollire l'acqua</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                       Casco
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Calare la pasta</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                <tr>
                                                    <td>
                                                        Sughero
                                                        <div
														class="table-data-feature">
                                                         <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Edit">
                                                            <i
																class="zmdi zmdi-edit"></i>
                                                        </button>
                                                        <button
															class="item" data-toggle="tooltip" data-placement="top"
															title="Delete">
                                                            <i
																class="zmdi zmdi-delete"></i>
                                                        </button>
                                                    </div>
                                                    </td>
                                                    <td>
                                                        <div
														class="table-data__info">
                                                            <h6>Vedere se è cotta</h6>
                                                        </div>
                                                    </td>
                                                </tr>
                                                
                                            </tbody>
                                        </table>
                                </div>
                            </div>
                        </div>
              
                        <div class="row">
                            <div class="col-md-12">
                                <div class="copyright">
                                    <p>Copyright © 2019 Trema. All rights reserved. Template by <a
											href="https://trema.com">Trema</a>.</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

          
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
    <script src="js/main.js"></script>

</body>

</html>
<!-- end document-->