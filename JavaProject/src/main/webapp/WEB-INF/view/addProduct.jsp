<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/Css/addProduct.css" />
<title>Insert title here</title>
</head>
<body>

<div class="container">
<div class="form">

	<h1>Add New Product</h1>

<form action="${pageContext.request.contextPath}/AddNewProduct" method="post" enctype="multipart/form-data">
   
   <div class="input-field">
    <label for="productName">Product Name:</label>
    <input type="text" id="productName" name="productName" required>
   </div>

<div class="input-field">
    <label for="productImage">Product Image:</label>
    <input type="file" id="productImage" accept="image/*" name="productImage" required>
   </div>
   
<div class="input-field">
    <label for="productDescription">Product Description:</label>
    <textarea id="productDescription" name="productDescription" required></textarea>
</div>


<div class="input-field">
    <label for="unitPrice">Unit Price:</label>
    <input type="number" id="unitPrice" name="unitPrice" required>
</div>

<div class="input-field">

    <label for="stock">Stock:</label>
    <input type="number" id="stock" name="stock" required>
</div>

    <button type="submit" value="Submit">Submit</button>
</form>
</div>
</div>
</body>
</html>