﻿<%@ include file="header.jsp"%>
<%
	List<UserDTO> allUser = (List<UserDTO>) request.getAttribute("allUserDTO");
%>
<%!private String convertUserType(String userType) {
		if (userType.equals("admin"))
			return "<span class=\"role admin\">Admin</span>";
		else
			return "<span class=\"role user\">User</span>";
	}%>
	
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
                <a href="#">
                    <img src="/images/icon/TremaLogo.jpg" alt="Trema Project" />
                </a>
            </div>
            <div class="menu-sidebar2__content js-scrollbar1">
                <div class="account2">
                    <div class="image img-cir img-120">
                        <img src="/images/icon/avatar01.jpg" alt="Gianluca Di Nanna" />
                    </div>
                    <h4 class="name">Gianluca Di Nanna</h4>
                    <a href="/User/logout">Sign out</a>
                </div>
                <div class="menu-sidebar__content js-scrollbar1">
                    <div class="table table-top-campaign">
                        <table class="table">
                            <thead>
                                <tr>
                                    <td align="left">DASHBORD</td>
                                </tr>
                            </thead>
                       </table>
                        
                    </div>
                </div>
            </div>
        </aside>
        <div class="page-container2">
            <header class="header-desktop2">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                        <div class="header-wrap2">
                            <div class="logo d-block d-lg-none">
                                <a href="#">
                                    <img src="/images/icon/TremaLogo.jpg" alt="CoolAdmin" />
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
                                            <input class="au-input au-input--full au-input--h65" type="text" placeholder="Search for datas &amp; reports..." />
                                            <span class="search-dropdown__icon">
                                                <i class="zmdi zmdi-search"></i>
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
                                            <a href="#">
                                                <i class="zmdi zmdi-account"></i>Account</a>
                                        </div>
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-settings"></i>Setting</a>
                                        </div>
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-money-box"></i>Billing</a>
                                        </div>
                                    </div>
                                    <div class="account-dropdown__body">
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-globe"></i>Language</a>
                                        </div>
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-pin"></i>Location</a>
                                        </div>
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-email"></i>Email</a>
                                        </div>
                                        <div class="account-dropdown__item">
                                            <a href="#">
                                                <i class="zmdi zmdi-notifications"></i>Notifications</a>
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
                    <a href="#">
                        <img src="/images/icon/logo-white.png" alt="Cool Admin" />
                    </a>
                </div>
            </aside>
            
            <div class="main-content">
                <div class="section__content section__content--p30">
                    <div class="container-fluid">
                         <div class="row">
                            <div class="col-lg-12">
                            
                                <!-- USER DATA-->
                                <div class="user-data m-b-30">
                                    <h3 class="title-3 m-b-30">
                                        <i class="title-3 m-b-30"></i>user data</h3>
                                            	<a href="/User/insertRedirect"> <i class="fas fa-user"></i>Users</a>                                   
                                    <div class="table-responsive table-data">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <td>Name</td>
                                                    <td>Surname</td>
                                                    <td>Username</td>
                                                    <td>Password</td>    
                                                    <td>Role</td>
                                                </tr>
                                            </thead>
                                            <tbody>
                                               <%for (UserDTO userDTO: allUser) { %>
												<tr>
													<td>
														<div class="table-data__info">
															<h6><%=userDTO.getName_user() %></h6>

														</div>
													</td>
													<td>
														<div class="table-data__info">
															<h6><%=userDTO.getSurname_user() %></h6>

														</div>
													</td>
													<td>
														<div class="table-data__info">
															<h6><%=userDTO.getUser() %></h6>

														</div>
													</td>
													<td>
														<div class="table-data__info">
															<h6><%=userDTO.getPassword() %></h6>

														</div>
													</td>
													<td><%=convertUserType(userDTO.getUsertype()) %></td>
													  <td>
													  <div class="table-data-feature">
                                                        <a href="/User/updateRedirect?id=<%=userDTO.getIdUser()%>"
																class="item" data-toggle="tooltip" data-placement="top"
																title="Edit"> <i class="zmdi zmdi-edit"></i>
															</a> <a href="/User/delete?id=<%=userDTO.getIdUser()%>"
																class="item" data-toggle="tooltip" data-placement="top"
																title="Delete"> <i class="zmdi zmdi-delete"></i>
															</a>
                                                        </div>
                                                    </td>

												</tr>
												
												<% } %>
                                            </tbody>
                                        </table>
                                    </div>
                                    <div class="user-data__footer">
                                        <button class="au-btn au-btn-load">load more</button>
                                    </div>
                                </div>
                                <!-- END USER DATA-->
                            </div>
                        </div>
                    
                    </div>
                </div>
            </div>
            
        
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