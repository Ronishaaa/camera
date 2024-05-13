<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/userProfile.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="user-image m-b-25">
            <span>PARIKSHA ADHIKARI</span>
        </div>
        <section class="user-details">
            <h2>Personal Information</h2>
            
            <form action="${pageContext.request.contextPath}/ProductUpdate" method="post">
                <label for="name">First name:</label><br>
                <input type="text" id="name" name="name" placeholder="Enter your name" required><br>

<label for="name">Last name</label><br>
                <input type="text" id="name" name="name" placeholder="Enter your name" required><br>

<label for="name">User name:</label><br>
                <input type="text" id="name" name="name" placeholder="Enter your name" required><br>


                <label for="email">Email:</label><br>
                <input type="email" id="email" name="email" placeholder="Enter your email" required><br>

                <label for="address">Address:</label><br>
                <input type="" name="" id="address" name="address" placeholder="Enter your address" rows="4" required></input><br>

                <label for="phone">Phone:</label><br>
                <input type="tel" id="phone" name="phone" placeholder="Enter your phone number" required><br>
            </form>
            <a href="#">Edit Profile</a>
        </section>
        
</body>
</html>