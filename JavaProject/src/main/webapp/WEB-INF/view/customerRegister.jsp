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
		<div style="color:grey; margin-bottom:20px;">Make your account</div>
		<form action="#">
			<div class="row">
				<div class="col">
					<label for="username">Email</label> 
					<input class="input" type="text" id="username" name="username" placeholder="Enter your email" required="required">
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label for="password">Password</label> 
					<input class="input" type="password" id="password" name="password" placeholder="Enter your password" required>
				</div>
			</div>
			
			<button type="submit" class="login-button">Register</button>
			
			
		</form>
	</div>
	<div >
		<img class='image' alt="camera" src="images/camera2.jpg">
	</div>
</body>
</html>