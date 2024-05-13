<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/homePage.css" />
<title>Insert title here</title>
</head>
<body>
<%@include file="header.jsp" %>
	<div class="hero-section">
	<div class="overlay">
	
	<div class="tagline">
	
Every click tells a story.<br> Capture yours with clarity <br>and creativity.
	
	<a href="<%=request.getContextPath()%>/Shop">
		<button class="button">Shop Now</button>
	</a>
	</div>
	</div>
      

    </div>



    <section class="introduction">

        <h2 class="camera">OUR CAMERAS</h2>

        <p class="product-intro">Cameras are fascinating devices that capture moments frozen in time, preserving memories, documenting events, and allowing us to express our creativity visually. From the early pinhole cameras to the sophisticated digital cameras of today, photography has evolved significantly, becoming an integral part of our lives. One of the most remarkable aspects of cameras is their ability to bridge the gap between the past and the present. Through photographs, we can revisit cherished memories, relive special moments, and connect with loved ones who may be far away. In a single snapshot, a camera can encapsulate a myriad of emotions, from joy and laughter to nostalgia and melancholy. Cameras serve practical purposes, aiding in scientific exploration, medical diagnosis, surveillance, and security. They are indispensable tools in fields as diverse as astronomy, biology, archaeology, and forensics, enabling researchers to study phenomena beyond the reach of the naked eye and solve mysteries hidden in plain sight. In our digital age, cameras have become ubiquitous, integrated into smartphones, tablets, laptops, and other devices, democratizing photography and videography and empowering people of all ages and backgrounds to become visual storytellers.</p>

    </section>



    <section class="product-one">

        <h2 class="product-category">Our Cameras</h2>

        <div class="product-list">
        	<c:forEach var="product" items="${listOfProduct}">

	            <div class="product-card">

	                <div class="product-image">

						 <img class="image" src="${pageContext.request.contextPath}/images?productId=${product.product_id}" />

						 <button class="cart-btn">Add To Cart</button>

	                </div>

	                <div class="product-info">

	                    <h2 class="product-brand">${product.product_name}</h2>

	                    <span class="price">$${product.unit_price}</span>

	                </div>

	            </div>

	     	</c:forEach>

         </div>         

    </section>
</body>
</html>