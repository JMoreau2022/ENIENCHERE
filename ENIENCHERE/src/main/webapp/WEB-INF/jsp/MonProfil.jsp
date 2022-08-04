<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Consultation de mon profil</title>
</head>
<body>

	<h1>Mon Profil</h1>

	<div>
	
		<form method="post" action="<%=request.getContextPath()%>/Profil">
	
		<table class="tabConsultationProfil">
			<tr>
				<td>Pseudo :</td>
				<td>${user.pseudo}</td>
			</tr>
			<tr>
				<td>Nom :</td>
				<td>${user.nom}</td>
			</tr>
			<tr>
				<td>Prénom :</td>
				<td>${user.prenom}</td>
			</tr>
			<tr>
				<td>E-mail :</td>
				<td>${user.email}</td>
			</tr>
			<tr>
				<td>Téléphone :</td>
				<td>${user.telephone}</td>
			</tr>
			<tr>
				<td>Rue :</td>
				<td>${user.rue}</td>
			</tr>
			<tr>
				<td>Code Postal :</td>
				<td>${user.code_postal}</td>
			</tr>
			<tr>
				<td>Ville :</td>
				<td>${user.ville}</td>
			</tr>
		</table>
		<input type="submit" value="Modifier" name="boutonModifier">
		</form>								  	
	</div>

</body>
</html>