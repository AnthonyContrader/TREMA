<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
<link href="css/trema.css" rel="stylesheet">

<title>Login Trema</title>
</head>
<body>

	<div class="pre_contenitore">
		<p>Login</p>
	</div>
	<div class="contenitore">
		<form action="LoginServlet" method="post" class="login">
			<p>Enter your login details</p>
			<p>
				<br>
				<label>Username</label>
				<br>
				<input type="text" name="username" class="username" placeholder="Username">
			</p>
			<p>
				<label>Password</label>
				<br>
				<input type="Password" name="password" class="password" placeholder="Password">
			</p>
			<button type="submit" value="Login" class="btn btn-warning">Sign in</button>
		</form>
	</div>
</body>
</html>