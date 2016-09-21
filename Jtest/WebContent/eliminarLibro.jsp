<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="dominio.Libro"%>
<%
	String isbn=request.getParameter("isbn");
	Libro libro=new Libro();
	libro.setIsbn(isbn);
	libro.eliminarLibro();
	response.sendRedirect("mostrarLibros.jsp");
%>