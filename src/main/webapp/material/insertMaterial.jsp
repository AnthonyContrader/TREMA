<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2><center>------- INSERT MATERIAL -------</center></h2>
	<form action="CustomersServlet?richiesta=home" method="post">
		<input type="submit" value="HOME" name="richiesta">
	</form>

     <h3>Inserisci i dati del material</h3>
     <form action="CustomersServlet?richiesta=insertMaterial" method="post">
     	<h4>Tipo: <input type = "text" id = "tipo" name ="tipo" placeholder = "inserisci tipo"></h4>
     	<h4>Quantita: <input type = "text" id = "quantita" name ="quantita" placeholder = "inserisci la quantita"></h4>
     	<h4>ID HR: <input type = "text" id = "idhr" name ="idhr" placeholder = "inserisci el ID del Dependente"></h4>
		<input type="submit" value="Inserisci Material" name="richiesta">
		<input type="submit" value="Cancel" name="richiesta">
     </form>
</body>
</html>