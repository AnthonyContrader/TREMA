<%@ page import="it.contrader.dto.*"%>


<link rel="stylesheet" href="css/css/bootstrap.min.css" >
<% UsersDTO utente = (UsersDTO) session.getAttribute("utente"); %>
<html>
<head>
<title>Menu Principale</title>
</head>
<body>
	<div><h1>Benvenuto: <%=utente.getUsername()%></h1></div>
	<h2>------- MENU PRINCIPALE -------</h2>

	<form  action="HumanResourceServlet?richiesta=HR_manager" method="post">
		<button type="submit" class="btn btn-primary" name="richiesta">Visualizza Dipendenti</button>
	</form>
      <form action="LogoutServlet" method="post">
     <button type="submit" class="btn btn-primary" name="richiesta">Logout</button>
     </form>



</body>
</html>