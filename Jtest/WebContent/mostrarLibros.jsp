<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="dominio.Libro"%>
<%@ page import="java.util.ArrayList"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Libros</title>
</head>
<body>
	<table>
		<tr>
			<th>ISBN</th>
			<th>Titulo</th>
			<th>Categoria</th>
			<th>Eliminar</th>
			<th>Editar</th>
		</tr>	
		<c:forEach var="libro" items="${listaDeLibros}">
			<tr>
				<td>${libro.isbn}</td>
				<td>${libro.titulo}</td>
				<td>${libro.categoria}</td>
				<td><a href="eliminarLibro.html?isbn=${libro.isbn}">Eliminar</a></td>
				<td><a href="editarLibro.html?isbn=${libro.isbn}">Editar</a></td>
			</tr>
		</c:forEach>
	</table>
	<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
</body>
</html>