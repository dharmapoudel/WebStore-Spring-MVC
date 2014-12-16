<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!Doctype html>
<html>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href='<c:url value="/resource/css/styles.css" />' type="text/css" media="screen" />
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
<script src='<c:url value="/resource/js/controllers.js" />'></script>
<script src='<c:url value="/resource/js/scripts.js" />'></script>
<title>Products</title>
</head>
<body>
	<section>
	<div class="jumbotron">
		<div class="container">
		<a href="<spring:url value="/j_spring_security_logout " />" class="btn btn-default btn-mini pull-right" > <span class="glyphicon-log-out glyphicon"></span> logout</a>
		<a href='<c:url value="/products/add" />' class="btn btn-default pull-right"> <span class="glyphicon-plus-sign glyphicon"></span> add product</a> 
		<a href='<c:url value="/cart" />' class="btn btn-default pull-right"  > <span class="glyphicon-shopping-cart glyphicon"></span> view cart</a>
			<h1>Products</h1>
			<p>All the available products in our store</p>
		</div>
	</div>
	</section>
	<section class="container" ng-app="cartApp" >
	<div class="row">
	<c:forEach items="${products}" var="product" >
		<div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
			<div class="thumbnail">
				<div class="caption">
						<h3>${product.name}</h3>
						<a href='<spring:url value="/products/product?id=${product.productId}" />' >
						<img src='<c:url value="/resource/images/${product.imageSource}" />' alt="image" />
						</a>
						<p>${product.description}</p>
						<p>${product.unitPrice} USD</p>
						<p>${product.unitsInStock} units in stock</p>
						<p ng-controller="cartController">
					<a href="<spring:url value="/products/product?id=${product.productId }" />"  class="btn btn-primary" >
					<span class="glyphicon-info-sign glyphicon"> </span>  Details</a>
					<a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${product.productId}')"> 
				<span class="glyphicon-shopping-cart glyphicon"> </span> Order Now
					</a>
					</p>
				</div>
			</div>
		</div>
		</c:forEach>
	</div>
	</section>
</body>
</html>