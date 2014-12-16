<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Not Found</title>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="<c:url value="/resource/css/styles.css" />"
	type="text/css">
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1 class="alert alert-danger">There is no product found with
					the Product id ${invalidProductId}.</h1>
			</div>
		</div>
	</section>
	<section>

		<div class="container">
			<p>${url}</p>
			<p>${exception}</p>
		</div>
		<div class="container">
			<p>
				<a href="<spring:url value="/products" />" class="btn btn-success">
					<span class="glyphicon-circle-arrow-left glyphicon"></span> back
				</a>
			</p>
		</div>
	</section>
</body>
</html>