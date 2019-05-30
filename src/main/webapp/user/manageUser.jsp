<%@ include file="/header.jsp"%>
<%!
//private String convertUsertype(String userType) {
	//	if (userType.equals("admin"))
		//	return "Admin";
	//	else
		//	return "Business Owner";
	//}%>

<!DOCTYPE html>
<html>
<head>
<title>Gestione Utenti</title>
<style>
body {
	background-image:
		url("https://i1.wp.com/www.deteched.com/wp-content/uploads/2017/10/Space-Vortex-4K-Abstract-Wallpapers.jpg");
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-size: cover;
	text-align: center;
	color: white;
}
</style>
<link rel="stylesheet" type="text/css" href="/wmesjsp/css/style.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css"
	integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">
<style>
/*contenitore in cima dove c'� scritto "Login"*/
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
<%
	List<UsersDTO> allUser = (List<UsersDTO>) request.getAttribute("allUser");
%>
</head>
<body>

	<div class="pre_contenitore">

		<p>User Management</p>

	</div>
	<br>



	<br />

	<table>
		<tr>
			<th>ID</th>
			<th>Username</th>
			<th>Password</th>
			<th>User Type</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			for (UsersDTO user : allUser) {
		%>
		<tr>
			<td><%=user.getIduser()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getPassword()%></td>
			<td><%=convertUsertype(user.getUsertype())%></td>
			<td class="center"><a href="/wmesjsp/UserServlet?richiesta=updateRedirect&id=<%=user.getId()%>"><i class="fas fa-edit" title="Update"></i></a></td>
			<td class="center"><a href="/wmesjsp/UserServlet?richiesta=delete&id=<%=user.getId()%>"><i class="fas fa-trash-alt" title="Delete"></i></a></td>

		</tr>
		<%
			}
		%>
	</table>
	<br>
	<br>
	<a href="/wmesjsp/UserServlet?richiesta=insertRedirect"><i class="fas fa-plus-circle fa-lg"> New User</i></a>

	<br>
	<br>
	<a href="/wmesjsp/UserServlet?richiesta=indietro"><i class="fas fa-arrow-alt-circle-left fa-lg"> Back</i></a>


</body>
</html>