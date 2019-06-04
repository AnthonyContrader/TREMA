<%@ page import="it.contrader.dto.*"%>


<link rel="stylesheet" href="css/css/bootstrap.min.css" >
<% UsersDTO utente = (UsersDTO) session.getAttribute("utente"); %>
<html>
<head>
<title>Menu Principale</title>
</head>
<style>
body {
	background-image:
		url("https://i1.wp.com/www.deteched.com/wp-content/uploads/2017/10/Space-Vortex-4K-Abstract-Wallpapers.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
}
h1 {
	position: center;
	text-align: center;
	size: 300%;
	font-family: sans-serif;
	color: #660033;
}

h2 {
	position: center;
	text-align: center;
	size: 300%;
	font-family: sans-serif;
	color: #660033;
}


</style>

<body>
	<div><h1>Benvenuto: <%=utente.getUsername()%></h1></div>
	<h2>------- MENU PRINCIPALE -------</h2>

	<form  action="UsersServlet?richiesta=admin" method="post">
		<button type="submit" class="btn btn-primary" name="richiesta">Visualizza Users</button>
	</form>
      <form action="LogoutServlet" method="post">
     <button type="submit" class="btn btn-primary" name="richiesta">Logout</button>
     </form>



</body>
</html>