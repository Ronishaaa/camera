<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/userManagement.css" />
<title>Insert title here</title>
</head>
<body>

	<nav>
      <div class="sidebar-button">
        <i class='bx bx-menu sidebarBtn'></i>
        <span class="dashboard">Dashboard</span>
      </div>
      
      <div class="profile-details">
        <img src="images/profile.jpg" alt="">
        <span class="admin_name">Ronisha </span>
        <i class='bx bx-chevron-down' ></i>
      </div>
    </nav>
    
  <div class="sidebar">
    
      <ul class="nav-links">
        <li>
          <a href="#" class="sidebar-link" data-target="dashboard">
            <i class='bx bx-grid-alt' ></i>
            <span class="links_name">Dashboard</span>
          </a>
        </li>
        <li>
          <a href="#" class="sidebar-link" data-target="user">
            <i class='bx bx-box' ></i>
            <span class="links_name">User Management</span>
          </a>
        </li>
        <li>
          <a href="#" class="sidebar-link" data-target="product">
            <i class='bx bx-box' ></i>
            <span class="links_name">Product Management</span>
          </a>
        </li>
        <li>
          <a href="#" class="sidebar-link" data-target="orderlist">
            <i class='bx bx-list-ul' ></i>
            <span class="links_name">Order list</span>
          </a>
        </li>
        <li>
          <a href="#" class="sidebar-link" data-target="setting">
            <i class='bx bx-cog' ></i>
            <span class="links_name">Setting</span>
          </a>
        </li>
        <li class="log_out">
          <a href="#">
            <i class='bx bx-log-out'></i>
            <span class="links_name">Log out</span>
          </a>
        </li>
      </ul>
  </div>
  
  <section class="home-section">
    
    
    <div class="home-content" id="dashboardContent">
        <h2>dashboard Section</h2>
        <p>This is the Dashboard content.</p>
     </div>
     
    <div class="home-content" id="userContent">
    <h1>User Overview</h1>
    <div class="control">
    <input placeholder="search for product">
       
            
           <div class="add-button" >
    <a href="<%=request.getContextPath() %>/AddNewProduct">+ ADD PRODUCT</a>
           </div>
        
    </div>

    <table border="1">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Stock</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${listOfProduct}">
                <tr>
                    <td><c:out value="${product.product_name}"/></td>
                    <td><c:out value="${product.product_description}"/></td>
                    <td><c:out value="${product.unit_price}"/></td>
                    <td><c:out value="${product.stock}"/></td>
                    
                    
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
     
     
    <div class="home-content" id="productContent">
    <h1>Product Overview</h1>
    <div class="control">
    <input placeholder="search for product">
       
            
           <div class="add-button" >
    <a href="<%=request.getContextPath() %>/AddNewProduct">+ ADD PRODUCT</a>
           </div>
        
    </div>

    <table border="1">
        <thead>
            <tr>
                <th>Product Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Stock</th>
                <th/>
                <th/>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${listOfProduct}">
                <tr>
                    <td><c:out value="${product.product_name}"/></td>
                    <td><c:out value="${product.product_description}"/></td>
                    <td><c:out value="${product.unit_price}"/></td>
                    <td><c:out value="${product.stock}"/></td>
                    
                    <td><form action="<%=request.getContextPath()%>/ProductEdit" method="post">
    
				    <input type="hidden" name="product_id" value="${product.product_id }">
				    <button type="submit">Edit</button>
				</form>
				</td>
				    <td><form action="<%=request.getContextPath()%>/ProductDelete" method="post">
				    <input type="hidden" name="product_id" value="${product.product_id}">
				    <button type="submit">Delete</button>
				</form></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="home-content" id="orderListContent">
        <h2>Order List Section</h2>
        <p>This is the Order list content.</p>
     </div>
  </section>
  
      
<script>
  document.addEventListener("DOMContentLoaded", function() {
    // Get references to sidebar elements
    let sidebarLinks = document.querySelectorAll(".sidebar-link");
    let userContent = document.getElementById("userContent");
    let productContent = document.getElementById("productContent");
    let orderListContent = document.getElementById("orderListContent");
    let dashboardContent = document.getElementById("dashboardContent");
    let sidebar = document.querySelector(".sidebar");
    let sidebarBtn = document.querySelector(".sidebarBtn");

    // Hide product and order list content initially
    productContent.style.display = "block";
    orderListContent.style.display = "none";
    dashboardContent.style.display = "none"; // Display dashboard content initially
    userContent.style.display = "none";
    
    // Add click event listener to each sidebar link
    sidebarLinks.forEach(link => {
      link.addEventListener("click", function(e) {
        e.preventDefault(); // Prevent default link behavior

        // Get the target data attribute
        let target = this.getAttribute("data-target");

        // Hide all content sections
        productContent.style.display = "none";
        orderListContent.style.display = "none";
        dashboardContent.style.display = "none";
       userContent.style.display = "none";
        
        // Show the corresponding content based on the clicked link
        if (target === "product") {
          productContent.style.display = "block";
        } else if (target === "orderlist") {
          orderListContent.style.display = "block";
        } else if (target === "dashboard") {
          dashboardContent.style.display = "block";
        }else if (target === "user") {
          userContent.style.display = "block";
        }

        // Close sidebar after clicking a link (for mobile)
        sidebar.classList.remove("active");
        sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
      });
    });

    // Toggle sidebar visibility
    sidebarBtn.onclick = function() {
      sidebar.classList.toggle("active");
      if (sidebar.classList.contains("active")) {
        sidebarBtn.classList.replace("bx-menu", "bx-menu-alt-right");
      } else {
        sidebarBtn.classList.replace("bx-menu-alt-right", "bx-menu");
      }
    };
  });
</script>

</body>
</html>