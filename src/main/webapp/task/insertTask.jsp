<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci nuovo task</title>
<link rel="stylesheet" type="text/css" href="trema/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>
.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 40px 40px;
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
</style>
</head>
<body>
	<div class="pre_contenitore">
		<p>Nuova Task</p>
	</div>
	<br>
	<br>
	<br>
	
	<form method="POST" action="/trema/TaskServlet?richiesta=insert">
		Descrizione: <input type="text" size="40" maxlength="40" name="task_description" />
		<br>
		<br>
		ID Project: <input type="text" size="40" maxlength="40" name="task_idproject" />
		<br>
		<br>
		ID HR: <input type="text" size="40" maxlength="40" name="task_idhr" />
		<br>
		<input type="SUBMIT" value="Add">
	</form>
	
	<br>
	<br>
	<a href="/trema/TaskServlet?richiesta=TaskManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
</body>
</html>