<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/customerLogin.css" />
</head>
<body>
	<div class="login-box">
		<h1>Welcome To Camera</h1>
		<div style="color:grey; margin-bottom:20px;">Sign in your account</div>

		<form action="<%=request.getContextPath() %>/Login" method="post">
			<div class="row">
				<div class="col">
					<label for="username">Username</label> 
					<input class="input" type="text" id="username" name="username" placeholder="Enter your username" required="required">
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label for="password">Password</label> 
					<input class="input" type="password" id="password" name="password" placeholder="Enter your password" required>
				</div>
			</div>
			
			<button type="submit" name="submit" class="login-button">Login</button>
			<div>
			Don't have an account ? 
			<a href="<%=request.getContextPath()%>/Register">Sign up</a>
			</div>
			<p style="color:red">${error}</p>
		</form>


	</div>
	<div >
		<img class='image' alt="camera" src="images/camera2.jpg">
	</div>
</body>
</html>
