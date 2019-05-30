<%@ page import="it.contrader.dto.*"%>

<link rel="stylesheet" href="css/css/bootstrap.min.css" >
<% UsersDTO utente = (UsersDTO) session.getAttribute("utente"); %>
<html>
<head>
<title allign="center">Menu Principale</title>
</head>
<body>
	<div><h1>Benvenuto: <%=utente.getUsername()%></h1></div>
	<h2>------- MENU PRINCIPALE -------</h2>

	<form action="manageUser" method="post">
		<button type="submit" class="btn btn-primary" name="richiesta">Visualizza Users</button>
	</form>
     <form action="insertUser" method="post">
     <button type="submit" class="btn btn-primary" name="richiesta">Aggiungi Users</button>
     </form>
     </form>
     <form action="updateUser" method="post">
     <button type="submit" class="btn btn-primary" name="richiesta">Modifica Users</button>
     </form>
     <form action="deleteUser" method="post">
     <button type="submit" class="btn btn-primary" name="richiesta">Cancella User</button>
     </form>
      <form action="LogoutServlet" method="post">
     <button type="submit" class="btn btn-primary" name="richiesta">Logout</button>
     </form>



</body>
</html>