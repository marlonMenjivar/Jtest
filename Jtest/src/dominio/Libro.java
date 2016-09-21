package dominio;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import utilidades.DataBaseHelper;

public class Libro {
	private String isbn;
	private String titulo;
	private String categoria;
	
	public Libro(String isbn, String titulo, String categoria){
		this.isbn=isbn;
		this.categoria=categoria;
		this.titulo=titulo;
	}
	public Libro(){
		
	}
	
	public ArrayList<Libro> getLista(){
		DataBaseHelper db=new DataBaseHelper();
		String consultaSQL="select * from libros";
		ResultSet rs=db.seleccionarRegistros(consultaSQL);
		ArrayList<Libro> libros=new ArrayList<Libro>();
		try {
			while(rs.next()){
				libros.add(new Libro(rs.getString("isbn"),rs.getString("titulo"),rs.getString("categoria")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
	}
	public void insertarLibro(){
		DataBaseHelper db=new DataBaseHelper();
		String query="INSERT INTO LIBROS(isbn,titulo,categoria) VALUES('"+getIsbn()+"','"+getTitulo()+"','"+getCategoria()+"')";
		db.modificarRegistro(query);
	}
	public void eliminarLibro(){
		DataBaseHelper db=new DataBaseHelper();
		String query="DELETE FROM LIBROS WHERE ISBN='"+getIsbn()+"'";
		db.modificarRegistro(query);
	}
	
	public void setearDatos(String isbn) throws SQLException{
		DataBaseHelper db=new DataBaseHelper();
		String query="SELECT * from LIBROS where isbn='"+isbn+"'";
		ResultSet rs=db.seleccionarRegistros(query);
		rs.next();
		setIsbn(isbn);
		setCategoria(rs.getString("categoria"));
		setTitulo(rs.getString("titulo"));
	}
	public void actualizarLibro(){
		DataBaseHelper db=new DataBaseHelper();
		String query="UPDATE LIBROS SET categoria='"+getCategoria()+"',titulo='"+getTitulo()+"' WHERE isbn='"+getIsbn()+"'";
		db.modificarRegistro(query);
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
