<%@ include file="/header.jsp"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page import="it.contrader.dao.*"%>
<%@ page import="it.contrader.model.*"%>
<%@ page import="it.contrader.service.*"%>
<%@ page import="it.contrader.servlets.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inserisci le nuova task</title>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/TREMA/css/style.css">
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
	
	<form method="POST" action="/JspApp/TaskServlet?richiesta=insert">
		Descrizione: <input type="text" size="40" maxlength="40" name="descrizione_task" />
		<br>
		<br>
		<!-- ID Project: <input type="text" size="40" maxlength="40" name="idproject" />
		<br>
		<br> -->
		Project:
		<%
			//RequestDispatcher rd= getServletContext().getRequestDispatcher("ProjectServlet?richiesta=project_manager"); 
			//List<ProjectDTO> allProjects = (List<ProjectDTO>) request.getAttribute("allProjects");
			
			//request.getRequestDispatcher("ProjectServlet?richiesta=project_manager").forward(request, response);
			//RequestDispatcher rd= request.getRequestDispatcher("ProjectServlet?richiesta=project_manager").forward(request, response);
			//List<ProjectDTO> allProjects = (List<ProjectDTO>) request.getAttribute("allProjects");
			
			ProjectDAO pdao = new ProjectDAO();
			pdao.getAllProject();
			ArrayList allProjects = (ArrayList) pdao.getAllProject();
		%>
		<select name="idproject" id="idproject">
            <option>Select project ...</option>
            <% for (int i = 0; i < allProjects.size(); i++) { %>
            <option value="<%=allProjects.get(i) %>"></option>
            <% } %>
        </select>
        <%-- 
		<select name="idproject" id="idproject">
            <option>Select project ...</option>
            <% for (ArrayList x : allProjects) { %>
            <option value="<%=allProjects.getprojectName() %>"></option>
            <% } %>
        </select> --%>
		<br>
		<br>
		ID HR: <input type="text" size="40" maxlength="40" name="idhr" />
		<br>
		<input type="SUBMIT" value="Add">
	</form>
	
	<br>
	<br>
	<a href="/JspApp/TaskServlet?richiesta=project_manager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
</body>
</html>