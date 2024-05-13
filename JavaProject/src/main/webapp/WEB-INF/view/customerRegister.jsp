<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Camera shop</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/customerRegister.css" />
</head>
<body>
		
	<div class="login-box">
		<h1>Welcome To Camera</h1>
		<div style="color:grey; margin-bottom:20px;">Make your account</div>
		<form action="<%=request.getContextPath() %>/Register" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="input-field">
					<label for="first_name">First Name</label> 
					<input class="input" type="text" id="first_name" name="first_name" placeholder="Enter your first name" required="required">
				</div>
				<div class="input-field">
					<label for="last_name">Last Name</label> 
					<input class="input" type="text" id="last_name" name="last_name" placeholder="Enter your last name" required="required">
				</div>
			</div>
			<div class="row">
				<div class="input-field">
					<label for="username">Username</label> 
					<input class="input" type="text" id="username" name="username" placeholder="Enter your username" required="required">
				</div>
			
				<div class="input-field">
					<label for="username">Address</label> 
					<input class="input" type="text" id="address" name="address" placeholder="Enter your address" required="required">
				</div>
			</div>
			
			<div class="row">
				<div class="input-field">
					<label for="phone_number">Phone number</label> 
					<input class="input" type="text" id="phone_number" name="phone_number" placeholder="Enter your phone number" required="required">
				</div>
			
				<div class="input-field">
					<label for="email">Email</label> 
					<input class="input" type="email" id="email" name="email" placeholder="Enter your email" required="required">
				</div>
			</div>
			
				<div class="input-field">
					<label for="password">Password</label> 
					<input type="password" id="password" name="password"  placeholder="Enter your password" required>
				</div>
				<div class="input-field">
					<label for="retypePassword">Retype Password</label> <input
						type="password" id="retypePassword" name="retypePassword"  placeholder="Retype above password"required>
						<%
						    if(request.getAttribute("error")!=null)
						    {
						    	%><p style="color:red" <%=request.getAttribute("error") %>></p>
						   
						   <%  }
						
						
						%>
				</div>
				<div class="button-wrapper">
					<button type="submit" class="login-button">Register</button>
				
				</div>
			
			
		</form>
	</div>
	<div >
		<img class='image' alt="camera" src="images/camera2.jpg">
	</div>
</body>
</html>