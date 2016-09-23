package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import dominio.Libro;

public class ControladorLibros extends HttpServlet{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		RequestDispatcher despachador = null;
		String cadena=request.getServletPath();
		if (request.getServletPath().equals("/MostrarLibros.html")) {
			ArrayList<Libro> listaDeLibros = new Libro().getLista();
			request.setAttribute("listaDeLibros", listaDeLibros);
			despachador = request.getRequestDispatcher("mostrarLibros.jsp");
			despachador.forward(request, response);
			}
		else if(request.getServletPath().equals("/eliminarLibro.html")){
			String isbn=request.getParameter("isbn");
			Libro libro=new Libro();
			libro.setIsbn(isbn);
			libro.eliminarLibro();
			ArrayList<Libro> listaDeLibros = new Libro().getLista();
			request.setAttribute("listaDeLibros", listaDeLibros);
			despachador = request.getRequestDispatcher("mostrarLibros.jsp");
			despachador.forward(request, response);
		}
		else if(request.getServletPath().equals("/insertarLibro.html")){
			String isbn=request.getParameter("isbn");
			String titulo=request.getParameter("titulo");
			String categoria=request.getParameter("categoria");
			
			Libro libro= new Libro(isbn,titulo,categoria);
			libro.insertarLibro();

			ArrayList<Libro> listaDeLibros = new Libro().getLista();
			request.setAttribute("listaDeLibros", listaDeLibros);
			despachador = request.getRequestDispatcher("mostrarLibros.jsp");
			despachador.forward(request, response);
		}
		else if(request.getServletPath().equals("/actualizarLibro.html")){
			Libro libro= new Libro(
					request.getParameter("isbn"),
					request.getParameter("titulo"),
					request.getParameter("categoria")
					);
			libro.actualizarLibro();

			ArrayList<Libro> listaDeLibros = new Libro().getLista();
			request.setAttribute("listaDeLibros", listaDeLibros);
			despachador = request.getRequestDispatcher("mostrarLibros.jsp");
			despachador.forward(request, response);
		}
		else if(request.getServletContext().equals("/editarLibro.html")){
			Libro libro=new Libro();
			libro.setearDatos(request.getParameter("isbn"));
			request.setAttribute("libro", libro);
			despachador = request.getRequestDispatcher("editarLibro.jsp");
			despachador.forward(request, response);
		}
	}
}
