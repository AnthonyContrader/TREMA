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
	margin: auto;
	height: 50px;
	border: 1px solid black;
	border-radius: 40px 40px 40px 40px;
	background-color: rgba(0, 0, 0, 0.9);
	box-shadow: 20px 30px 20px #00ff00;
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
	UsersDTO updateUser = (UsersDTO) request.getAttribute("userUpdate");
%>
</head>

<body>
	<div class="center">

		<div class="pre_contenitore">

			<p>User Update</p>

		</div>
		<br>
		<br>
		<form method="POST" action="UsersServlet?richiesta=update">

	

			User type: <select style="width: 270px;" name="usertype">

			<option value="admin">Admin</option>
			<option value="HR_manager">Hr manager</option>
			<option value="project_manager">Project manager</option>


			</select>
			<br>
			<input type="hidden" name="iduser" value="<%=updateUser.getId()%>" />
			<br>
			Username: <input type="text" size="40" maxlength="40" name="username" value="<%=updateUser.getUsername()%>" />
			<br>
			<br>
			Password: <input type="text" size="40" maxlength="40" name="password" value="<%=updateUser.getPassword()%>" />
			<br>
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
		

			<br>
			<br>
			<a href="UsersServlet?richiesta=admin"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

		</form>

	</div>
</body>
</html>