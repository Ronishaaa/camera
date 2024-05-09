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
		<form action="<%=request.getContextPath() %>/Register" method="post">
			<div class="row">
				<div class="col">
					<label for="first_name">First Name</label> 
					<input class="input" type="text" id="first_name" name="first_name" placeholder="Enter your first name" required="required">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="last_name">Last Name</label> 
					<input class="input" type="text" id="last_name" name="last_name" placeholder="Enter your last name" required="required">
				</div>
			</div>
			<div class="row">
				<div class="col">
					<label for="username">username</label> 
					<input class="input" type="text" id="username" name="username" placeholder="Enter your username" required="required">
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label for="username">address</label> 
					<input class="input" type="text" id="address" name="address" placeholder="Enter your address" required="required">
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label for="phone_number">Phone number</label> 
					<input class="input" type="text" id="phone_number" name="phone_number" placeholder="Enter your phone number" required="required">
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label for="email">email</label> 
					<input class="input" type="text" id="email" name="email" placeholder="Enter your email" required="required">
				</div>
			</div>
			
			<div class="row">
				<div class="col">
					<label for="password">Password:</label> <input type="password"
						id="password" name="password" required>
				</div>
				<div class="col">
					<label for="retypePassword">Retype Password:</label> <input
						type="password" id="retypePassword" name="retypePassword" required>
						<%
						    if(request.getAttribute("error")!=null)
						    {
						    	%><p style="color:red" <%=request.getAttribute("error") %>></p>
						   
						   <%  }
						
						
						%>
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