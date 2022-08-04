<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet"  href="<%=request.getContextPath()%>/css/mainPage.css">
	<title>Enchères ENI</title>
</head>
<body>

<!-- Barre de nav -->

	<nav class = "nav">
	<div>
		<a href = ""><h1>Enchères ENI</h1></a>
	</div>
	<div class = "sideNavBar">
		<a href = "">Enchères</a>
		<a href = "">Vendre un article</a>
		<a href = "<%=request.getContextPath()%>/Profil">Mon profil</a>
		<a href = "">Déconnexion</a>
	</div>
	</nav>

	<main>

<!-- Barre de recherche -->

		<div class = "container-1">

			<form action="" method="post">
			
			<div class = "box-1">

				<p><label for="disconnected-searchBar">
					Filtres : <input type = "text" class = "searchBar" >
				</label></p>

<!--  Liste déroulante de catégorie -->

				<p>Catégorie : 
					<select style="width: 100%;">
						<option value = "optionToutes">Toutes</option>
						<option value = "optionInformatique">Informatique</option>
						<option value = "optionAmeublement">Ameublement</option>
						<option value = "optionVêtement">Vêtement</option>
						<option value = "optionSport&Loisirs">SportsLoisirs</option>					
					</select>
				</p>
			
			</div>
			<div class = "box-2">
				<button>Rechercher</button>
			</div>
			
			<div class = "achatVente">
			
<!-- Bouton achat-->

				<p>
					<input type = "radio"
								name = "Achat"
								value = "optionAchat"  checked> Achats <br>
					<input type = "checkbox"
								name = "encheresOuvertes"
								value = "optionEncheresOuvertes"> enchères ouvertes <br>
					<input type = "checkbox"
								name = "encheresEnCours"
								value = "optionEncheresEnCours"> enchères en cours <br>
					<input type = "checkbox"
								name = "encheresRemportees"
								value = "optionEncheresRemportees"> enchères remportées <br>
				</p>
				<p>

					<input type = "radio"
								name = "ventes"
								value = "optionVentes"> Mes ventes <br>
					<input type = "checkbox"
								name = "ventesEnCours"
								value = "optionVentesEnCours"> mes ventes en cours <br>
					<input type = "checkbox"
								name = "ventesNonDebutees"
								value = "optionNonDebutees"> ventes non débutées <br>
					<input type = "checkbox"
								name = "ventesTerminees"
								value = "optionTerminees"> ventes terminées <br>

				</p>
								
			</div>
			
			</form>
		</div>
			
		<div class = "container-2">
		
<!-- Attribution des valeurs des paramètres-->
			<%
			String encheresEnCoursTitre = (String) request.getAttribute("enchereEnCoursPrix");
			String encheresEnCoursPrix = (String) request.getAttribute("enchereEnCoursPrix");
			String encheresEnCoursFinEnchere = (String) request.getAttribute("enchereEnCoursPrix");
			String encheresEnCoursNomVendeur = (String) request.getAttribute("enchereEnCoursPrix");
			%>
			
			<c:set var="test"  value ="encheresEnCoursTitre"/>
			<c:choose>
			
				<c:when test ="null" >
					<div>
					<p><%= encheresEnCoursTitre%></p>
					<p><%= encheresEnCoursPrix%></p>
					<p><%= encheresEnCoursFinEnchere%></p>
					<p><%= encheresEnCoursNomVendeur%></p>				
					</div>
				</c:when>
			
				<c:otherwise>
				<p>Aucune enchère en cours actuellement.</p>
				</c:otherwise>
				
			</c:choose>
			
		</div>
	</main>
</body>
</html>