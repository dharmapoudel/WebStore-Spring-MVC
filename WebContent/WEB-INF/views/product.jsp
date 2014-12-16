<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product - ${product.name}</title>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href='<c:url value="/resource/css/styles.css" />' type="text/css" />
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src='<c:url value="/resource/js/controllers.js" />' ></script>
<script src='<c:url value="/resource/js/scripts.js" />' ></script>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Products</h1>
			</div>
		</div>
	</section>

	<section class="container" ng-app="cartApp">

		<div class="row">
			<div class="col-md-6">
				<img src='<c:url value="/resource/images/${product.imageSource}" />' class="single-img" alt="image" /> 
			</div>
			<div class="col-md-6">

				<h3>${product.name}</h3>
				<p>${product.description}</p>
				<p>
					<strong>Item Code : </strong><span class="label label-warning">${product.productId}</span>
				</p>
				<p>
					<strong>manufacturer</strong> : ${product.manufacturer}
				</p>
				<p>
					<strong>category</strong> : ${product.category}
				</p>
				<p>
					<strong>Availble units in stock </strong> : ${product.unitsInStock}
				</p>
				<h4>${product.unitPrice}USD</h4>
				<p ng-controller="cartController">
					<a href="<spring:url value="/products" />" class="btn btn-success">
						<span class="glyphicon-circle-arrow-left glyphicon"></span> back
					</a> 
					<a href="#" ng-click = "addToCart('${product.productId}')" class="btn btn-warning btn-large"> <span
						class="glyphicon-shopping-cart glyphicon"> </span> Order Now
					</a>
				</p>
			</div>
		</div>
	</section>
</body>
</html>