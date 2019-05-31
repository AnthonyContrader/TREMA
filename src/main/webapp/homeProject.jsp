<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project</title>
<link rel="stylesheet" type="text/css" href="css/css/bootstrap.min.css">
<style>
/*contenitore in cima dove c'� scritto "Login"*/
.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 0px 0px;
	background-color: rgba(0, 0, 0, 0.9);
	box-shadow: 20px 30px 20px #000000;
	padding: 20px;
}

.pre_contenitore p {
	color: orange;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}

body {
	background-image:
		url("https://i1.wp.com/www.deteched.com/wp-content/uploads/2017/10/Space-Vortex-4K-Abstract-Wallpapers.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
}

/*contenitore contenete il form */
.contenitore {
	border: 1px solid black;
	margin: auto;
	width: 320px;
	height: 190px;
	border-radius: 0px 0px 40px 40px;
	padding: 20px;
	background-color: rgba(0, 0, 0, 0.8);
	box-shadow: 20px 20px 20px #000000;
	color: orange;
}

.contenitore input {
	width: 100%;
	margin-bottom: 20px;
	border: none;
	border: 1px solid black;
	height: 30px;
}

.contenitore input[type="text"], input[type="password"]
	/* i css si riferiscono solo alla barra ditesto */ {
	border: none;
	border-bottom: 1px solid #fff;
	background: transparent;
	outline: none;
	height: 40px;
	color: #fff;
	font-size: 16px;
}

.contenitore p {
	
}

.contenitore input[type="submit"] {
	/* i css si riferiscono solo al pulsante */
	border-radius: 14px;
	height: 40px;
}

.contenitore input[type="submit"]:hover {
	background: lightblue;
}
</style>
</head>
<body>
	<div class="pre_contenitore">

		<p>Benvenute!</p>

	</div>
	<div class="contenitore">
		<a href="ProjectServlet?richiesta=project_manager"><span class="fs"> Project Management </span></a>
		<br>
		<br>
		<a href="TaskServlet?richiesta=TaskManager"><span class="fs"> Task Management </span></a>
		<br>
		<br>
		<p>
			<a href="LogoutServlet" target="self"><span class="fs"> Logout </span></a>
		</p>
	</div>
</body>
</html>