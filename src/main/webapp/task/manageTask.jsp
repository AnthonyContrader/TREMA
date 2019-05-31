<%@ include file="/header.jsp"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<%@ include file="/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.pre_contenitore {
	width: 320px;
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 4px 40px;
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
<%
	List<TaskDTO> allTask = (List<TaskDTO>) request.getAttribute("allTasks");
%>
</head>
<body>
	<div class="pre_contenitore">
		<p>Task Management</p>
	</div>
	<br>
	<br />
	<table>
		<tr>
			<th>Description</th>
			<th>Action</th>
			<th>Input</th>
			<th>Output</th>
			<th>Resource</th>
			<th>Time</th>
			<th>State</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (TaskDTO task : allTask) {
		%>
		<tr>
			<td><%=task.getDescrizioneTask()%></td>
			<td><%=task.getProjectDTO().getId()%></td>
			<td><%=task.getHRDTO().getId()%></td>
			<td><a href="/trema/TaskServlet?richiesta=updateRedirect&id=<%=task.getIdtask()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td><a href="/trema/TaskServlet?richiesta=delete&id=<%=task.getIdtask()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/trema/TaskServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Task</i></a>
	<br>
	<br>
	<a href="/trema/TaskServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
</body>
</html>