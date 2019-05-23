<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="txt/html; charset=ISO-8859-1">
<title>Ajouter livre</title>
</head>
<body>
	<h1>Page d'ajout d'un livre</h1>
		
	<form action="form" method="POST">
		Titre : <input type="text" name="titre"><br />
		Auteur: <input type="text" name="auteur" /><br />
		prix : <input type="text" name="prix" />
		<input type="submit" value="Ajouter" />
	</form>

</body>
</html>