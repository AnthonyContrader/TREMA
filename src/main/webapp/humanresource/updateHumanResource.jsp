<%@ include file="/header.jsp"%>
<%@ page import="it.contrader.dto.*"%>
<%@ page import="java.util.*"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/TREMA/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
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
	HumanResourceDTO updatehr = (HumanResourceDTO) request.getAttribute("HrUpdate");
%>
</head>
<br>
<body>
	<div class="center">



		<div class="pre_contenitore">

			<p>HR Update</p>

		</div>
		<form method="POST" action="HumanResourceServlet?richiesta=update">
			<br>

			<br>
			<input type="hidden" name="idHR" value="<%=updatehr.getId()%>" />
			Nome Dipendente: 		<input type="text" size="40" maxlength="40" name="name" value="<%=updatehr.getName()%>" />
			Cognome Dipendente:  	<input type="text" size="40" maxlength="40" name="surname" value="<%=updatehr.getSurname()%>" />
			<br>
			<br>
			<input type="SUBMIT" value="Update">
			<br>
			<br>
			<a href="HumanResourceServlet?richiesta=human_manager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
		</form>

	</div>
</body>
</html>