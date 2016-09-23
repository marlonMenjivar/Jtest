<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
	<head>
		<title>Formulario Libro</title>
		<script type="text/javascript" src="js/script.js">
		</script>
		<link href="css/style.css" rel="stylesheet" type="text/css"/>
	</head>
	<body>
		<h1>Formulario alta</h1>
		<form id=miformulario action="insertarLibro.html">
			<fieldset>
				<legend>Formulario alta</legend>
				<p><label for="isbn">ISBN:</label>
				<input id="isbn" type="text" name="isbn">
				</p>
				<p><label for="titulo">Titulo:</label>
				<input id="titulo" type="text" name="titulo">
				</p>
				<p><label for="categoria">Categoria :</label>
				<input id="categoria" type="text" name="categoria">
				</p>
				<p>
				<input type="button" value="Insertar" onclick="validacion()">
				</p>
			</fieldset>
		</form>
	</body>
</html>