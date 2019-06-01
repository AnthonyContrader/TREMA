<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci il nuovo progetto</title>
<link rel="stylesheet" type="text/css" href="/TREMA/src/main/webapp/css/trema.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>
/*contenitore in cima dove c'è scritto "Login"*/
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
	color: white;
	text-align: center;
	font-size: 1.9em;
	font-family: arial;
	line-height: 2px;
}
</style>
</head>
<br>

<body>
	<div class="pre_contenitore">

		<p>New Project</p>

	</div>
	<br>
	<br>
	<br>
	<form method="POST" action="/JspApp/ProjectServlet?richiesta=insert">
		Name: <input type="text" size="40" maxlength="40" name="name" />
		Descrizione: <input type="text" size="40" maxlength="40" name="descrizione" />
		Tipo: <input type="text" size="40" maxlength="40" name="tipo" />
		<br>
		<br>
		<input type="SUBMIT" value="Add" >
		<br>
		<br>
		<a href="/JspApp/ProjectServlet?richiesta=project_manager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</form>
</body>
</html>