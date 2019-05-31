<%@ page import="trema.dto.MaterialDTO"%>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
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
	MaterialDTO updateMaterial = (MaterialDTO) request.getAttribute("materialUpdate");
%>
</head>
<br>
<body>
	<div class="center">



		<div class="pre_contenitore">

			<p>Material Update</p>

		</div>
		<form method="POST" action="/TREMA/MaterialServlet?richiesta=update">
			<br>

			<br>
			<input type="hidden" name="idmaterial" value="<%=updateMaterial.getIdMaterial()%>" /> Material Name: <input type="text" size="40" maxlength="40"
				idmaterial="Idmaterial" value="<%=updateMaterial.getIdMaterial()%>" />
			<br>
			<br>
			<br>
			<input type="SUBMIT" value="Update">
			<br>
			<br>
			<a href="/TREMA/MaterialServlet?richiesta=HR-manager"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>
		</form>

	</div>
</body>
</html>