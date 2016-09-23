package utilidades;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseHelper {
	private static final String DRIVER="org.sqlite.JDBC";
	private static final String URL="jdbc:sqlite:C:\\Users\\mamenjivar\\Jtest.db";
	
	Connection conexion=null;
	Statement sentencia=null;
	
	public int modificarRegistro(String consultaSQL){
		int filasAfectadas=0;
		
		try{
			Class.forName(DRIVER);
			conexion=DriverManager.getConnection(URL);
			sentencia=conexion.createStatement();
			filasAfectadas=sentencia.executeUpdate(consultaSQL);
		}catch(ClassNotFoundException e){
			System.out.println("Error driver" + e.getMessage());
			throw new DataBaseException("Clase no encontrada",e);
		}catch(SQLException e){
			System.out.println("Error de SQL" + e.getMessage());
			throw new DataBaseException("Error de SQL",e);
		}finally{
			cerrarSentencia();
			cerrarConexion();
		}
		
		return filasAfectadas;
	}
	
	public ResultSet seleccionarRegistros(String consultaSQL){
		conexion = null;
		sentencia = null;
		ResultSet filas = null;
		try {
			Class.forName(DRIVER);
			conexion = DriverManager.getConnection(URL);
			sentencia = conexion.createStatement();
			filas = sentencia.executeQuery(consultaSQL);
		} catch (ClassNotFoundException e) {
			System.out.println("Error Driver" + e.getMessage());
		} catch (SQLException e) {
			System.out.println("Error de SQL " + e.getMessage());
		}finally{
			//cerrarSentencia();
			//cerrarConexion();
		}
		return filas;
	}
	
	private void cerrarSentencia() {
		if (sentencia != null) {
			try {
				sentencia.close();
			} catch (SQLException e) {

			}
		}
	}

	private void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {

			}
		}
	}
}
