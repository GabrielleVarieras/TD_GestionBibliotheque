<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="txt/html; charset=ISO-8859-1">
<title>Modifier livre</title>
</head>
<body>
	
	<form action="formModif" method="POST">
		Titre du livre à modifier : <input type="text" name="titreModif"><br /> 
		Nouveau titre : <input type="text" name="nTitre"><br />
		Nouvel auteur: <input type="text" name="nAuteur" /><br />
		Nouveau prix : <input type="text" name="nPrix" />
		<input type="submit" value="Valider" />
	</form>

</body>
</html>