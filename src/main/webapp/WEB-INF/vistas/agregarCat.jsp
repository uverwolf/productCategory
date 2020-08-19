<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV" crossorigin="anonymous"></script>
<title>Agregar categorias</title>
</head>
<body>
 <div class="container-fluid">
        <div class="d-flex flex-row col-12 mx-auto my-5 bg bg-success border border-dark rounded text-center justify-content-center text-light">
	<form:form action="/products/${producto.id}" method="post" modelAttribute="catValida">
           <h1>Agregando a :<c:out value="${producto.name}"/></h1>
            <div class="form-group">
                <form:label path="name">Categoria: </form:label>
                
					<form:select path="id">
					<c:forEach items="${categorias}" var="cate">
						<option value="<c:out value="${cate.id}"/>"> <c:out value="${cate.name }"/>  </option>
						</c:forEach>
					</form:select>   
			
			<div class="bg bg-dark text-light">
			<h1 class="">Categorias Actuales</h1>
			<c:forEach items="${catAsociadas}" var="asociadas">
			<h1><c:out value="${asociadas.name }"/></h1>			
			
			</c:forEach>
			</div>    
            </div>
			<input type="submit" class="btn btn-dark" value="Crear">
        	<a href="/index" class="btn btn-success">Volver</a>
	</form:form>
	</div>
</div>
</body>
</html>