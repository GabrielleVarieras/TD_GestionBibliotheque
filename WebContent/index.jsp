<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bibliothèque</title>
</head>
<body>

<table border="1" cellpadding="5">
			<caption><h2>Liste des livres</h2></caption>
			<tr>
				<th>Content</th>
			</tr>
			<c:forEach var="element" items="${listeLivre}">
				<tr>
					<td><c:out value="${element}" /></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		
		<table>
			<tr>
				<td><form action="ajout" method="POST">
						<input type="submit" value="Ajouter" />
					</form></td>
				<td><form action="modif" method="POST">
						<input type="submit" value="Modifier" />
					</form>
				</td>
				<td><form action="supr" method="POST">
						<input type="submit" value="Supprimer" />
					</form>
				</td>
			</tr>
		</table>



</body>
</html>