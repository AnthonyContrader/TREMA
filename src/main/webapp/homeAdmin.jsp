<%@ page import="it.contrader.dto.*"%>


<link rel="stylesheet" href="css/css/bootstrap.min.css" >
<% UsersDTO utente = (UsersDTO) session.getAttribute("utente"); %>
<html>
<head>
<title>Menu Principale</title>
</head>
<style>
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