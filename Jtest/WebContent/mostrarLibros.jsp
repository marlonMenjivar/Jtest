<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<%
	//Libro libro=new Libro();
	//ArrayList<Libro> lista=libro.getLista();
	ArrayList<Libro> lista=(ArrayList<Libro>)request.getAttribute("listaDeLibros");
	
	for (Libro elemento:lista) {
	%>
	<tr>
	<td><%=elemento.getIsbn()%></td>
	<td><%=elemento.getTitulo()%></td>
	<td><%=elemento.getCategoria()%></td>
	<td><a href="eliminarLibro.html?isbn=<%=elemento.getIsbn()%>">Eliminar</a></td>
	<td><a href="editarLibro.jsp?isbn=<%=elemento.getIsbn()%>">Editar</a>
	<%} %>
	</tr>
	</table>
	<a href="FormularioInsertarLibro.jsp">Insertar Libro</a>
</body>
</html>