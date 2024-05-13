<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="javax.servlet.http.HttpSession"%>
 <%@page import="javax.servlet.http.HttpServletRequest"%>
 
 
 <%
 	HttpSession userSession = request.getSession();
 	String username = (String) userSession.getAttribute("username");
 	String contextPath = request.getContextPath();
 
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/header.css" />
<title>Insert title here</title>
</head>
<body>
	<header>

    <div class="logo">

        <img src="images/logo.png" alt="Logo" height="40px" width="40px">
        <div>Camera</div>

    </div>

    <nav class="navigation">

        <a href="<%=request.getContextPath()%>/Home">Home  </a>

        <a href="<%=request.getContextPath()%>/Register">Shop</a>
        <a href="<%=request.getContextPath()%>/AboutPage">About Us</a>

    </nav>

    <div class="actions">
        <button class="cart-button">Cart</button>


		<form action="<%=request.getContextPath()%>/Logout" method="post">
	<%
		if(username != null){
	%>
		
					<button type="submit"   class="login">Logout</button>
	
	<%
		} else {
	%>
        <a href="<%=request.getContextPath()%>/Register">
        	<button class="SignUp">Sign Up</button>
        </a>
        <span>|</span>
	<a href="<%=request.getContextPath()%>/Login">
        <button class="login">Login</button>
	</a>
	<%
		}
	%>
			</form>



<div>
<form action="<%=request.getContextPath()%>/Profile" method="post">
				    <input type="hidden" name="product_id" value="${customer.customer_id}">
				    <button class="cart-button" type="submit" class="action-button">Profile</button>
				</form>
</div>


    </div>

</header>
</body>
</html>