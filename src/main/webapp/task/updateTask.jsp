<%@ include file="/header.jsp"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Inserisci nuovo ordine</title>
	<link rel="stylesheet" type="text/css" href="/trema/css/style.css">
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
<%
	TaskDTO updateTask = (TaskDTO) request.getAttribute("taskUpdate");
%>
</head>
<body>
	<div class="center">
		<div class="pre_contenitore">
			<p>Task Update</p>
		</div>
		<form method="POST" action="/trema/TaskServlet?richiesta=update">
			<br>
			<br>
			<input type="hidden" name="task_id" value="<%=updateTask.getIdtask()%>" /> 
			Description: <input type="text" size="40" maxlength="40" name="task_description" value="<%=updateTask.getDescrizioneTask()%>" />
			<br>
			<br>
			<br>
			ID Project:: <input type="text" size="40" maxlength="40" name="task_idproject" value="<%=updateTask.getProjectDTO().getId() %>" />
			<br>
			<br>
			<br>
			ID HR: <input type="text" size="40" maxlength="40" name="task_idhr" value="<%=updateTask.getHRDTO().getId()%>" />
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		</form>
		<br>
		<br>
		<a href="/trema/TaskServlet?richiesta=TaskManager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

	</div>
</head>
</body>
</html>