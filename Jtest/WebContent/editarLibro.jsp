<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Formulario Libro</title>
		<script type="text/javascript" src="js/script.js">
		</script>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<h1>Formulario de edici�n</h1>
		<form id=miformulario action="actualizarLibro.html">
			<fieldset>
				<legend>Formulario alta</legend>
				<p><label for="isbn">ISBN:</label>
				<input id="isbn" type="text" name="isbn" value="${libro.isbn}">
				</p>
				<p><label for="titulo">Titulo:</label>
				<input id="titulo" type="text" name="titulo" value="${libro.titulo}">
				</p>
				<p><label for="categoria">Categoria :</label>
				<input id="categoria" type="text" name="categoria" value="${libro.categoria}">
				</p>
				<p>
				<input type="button" value="Guardar" onclick="validacion()">
				</p>
			</fieldset>
		</form>
	</body>
</html>