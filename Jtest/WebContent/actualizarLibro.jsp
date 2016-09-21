<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dominio.Libro"%>
<%
	Libro libro= new Libro(
			request.getParameter("isbn"),
			request.getParameter("titulo"),
			request.getParameter("categoria")
			);
	libro.actualizarLibro();
	response.sendRedirect("mostrarLibros.jsp");
%>