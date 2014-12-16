<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resource/css/styles.css" />" type="text/css" >

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src="<c:url value="/resource/js/scripts.js" />" type="text/javascript"></script>

<title>Products</title>
</head>
<body>

	<section>
		<div class="jumbotron">
			<div class="container">
				<a href="<spring:url value="/j_spring_security_logout " />" class="btn btn-danger btn-mini pull-right" >logout</a> 
				<a href='<c:url value="/products" />' class="btn btn-success pull-right">products</a>

				<div class="pull-right" style="padding-right: 50px">
					<a href="?lang=en">English</a>|<a href="?lang=nl">Dutch</a>
				</div>
				<h1>Products</h1>
				<p>Add products</p>
			</div>
		</div>
	</section>
	<section class="container">
		<form:form modelAttribute="newProduct" enctype="multipart/form-data" class="form-horizontal">
			<fieldset>
				<legend>Add new product</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="addProduct.form.productId.label" /></label>
					<div class="col-lg-10">
						<form:input id="productId" path="productId" type="text" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name"><spring:message code="addProduct.form.name.label" /></label>
					<div class="col-lg-10">
						<form:input id="name" type="text" path="name" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitPrice"><spring:message code="addProduct.form.unitPrice.label" /></label>
					<div class="col-lg-10">
						<form:input type="text" id="unitPrice" path="unitPrice" class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="unitsInStock"><spring:message code="addProduct.form.unitsInStock" /></label>
					<div class="col-lg-10">
						<form:input type="text" id="unitsInStock" path="unitsInStock" class="form:input-large" />
					</div>
				</div>
				<!-- Similarly bind form:input tag for name,unitPrice,manufacturer,category,unitsInStock and unitsInOrder fields-->
				<div class="form-group">
					<label class="control-label col-lg-2" for="description">Description</label>
					<div class="col-lg-10">
						<form:textarea id="description" path="description" rows="2" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">Manufacturer</label>
					<div class="col-lg-10">
						<form:input type="text" class="form:input-large" id="manufacturer" path="manufacturer" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="productId">Category</label>
					<div class="col-lg-10">
						<form:input type="text" class="form:input-large" id="category" path="category" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2" for="condition">Condition</label>
					<div class="col-lg-10">
						<form:radiobutton path="condition" value="New" />
						New
						<form:radiobutton path="condition" value="Old" />
						Old
						<form:radiobutton path="condition" value="Refurbished" />
						Refurbished
					</div>
				</div>
				<div class="form-group">
					<a href="#" class="fileUploadHandler">toggle file upload</a>
				</div>
				<div class="form-group fileUploadHandle">
					<label class="control-label col-lg-2 col-lg-2" for="productImage"><spring:message code="addProduct.form.productImage.label" /></label>
					<div class="col-lg-10">
						<form:input type="file" class="form:input-large" id="productImage" path="productImage" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd" class="btn btn-primary"
							value="Add Product" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>

</body>
</html>