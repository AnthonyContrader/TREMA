<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inserisci nuovo ordine</title>
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/TREMA/css/style.css">
	<style>
	/*contenitore in cima dove c'è scritto "Login"*/
	.pre_contenitore {
		width: 320px;
		margin-left: 600px;
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
<%
	TaskDTO updateTask = (TaskDTO) request.getAttribute("taskUpdate");
%>
</head>
<body>
	<div class="center">
		<div class="pre_contenitore">
			<p>Task Update</p>
		</div>
		<form method="POST" action="/JspApp/TaskServlet?richiesta=update">
			<br>
			<br>
			<input type="hidden" name="idtask" value="<%=updateTask.getIdtask()%>" /> 
			Description: <input type="text" size="40" maxlength="40" name="descrizione_task" value="<%=updateTask.getDescrizioneTask()%>" />
			<br>
			<br>
			<br>
			ID Project:: <input type="text" size="40" maxlength="40" name="idproject" value="<%=updateTask.getProjectDTO().getId() %>" />
			<br>
			<br>
			<br>
			ID HR: <input type="text" size="40" maxlength="40" name="idhr" value="<%=updateTask.getHRDTO().getId()%>" />
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		</form>
		<br>
		<br>
		<a href="/JspApp/TaskServlet?richiesta=project_manager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</div>
</head>
</body>
</html>