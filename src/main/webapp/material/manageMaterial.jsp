<%@ include file="/header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Material</title>

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
</head>
<%
	List<MaterialDTO> allMaterial = (List<MaterialDTO>) request.getAttribute("allMaterial");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>Material Management</p>

	</div>
	<br>



	<br />
	<table>
		<tr>
			<th>Material ID</th>
			<th>Update</th>
			<th>Delete</th>

		</tr>
		<% 
			for (MaterialDTO material : allMaterial) {
		%>
		<tr>

			<td><%=material.getIdMaterial()%></td>


			<td><a href="../MaterialServlet?richiesta=updateRedirect&idmaterial=<%=material.getIdmaterial()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td><a href="../MaterialServlet?richiesta=delete&idmaterial=<%=material.getIdmaterial()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>
		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="../MaterialServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New Material</i></a>
	<br>
	<br>
	<a href="../MaterialServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>

</body>
</html>