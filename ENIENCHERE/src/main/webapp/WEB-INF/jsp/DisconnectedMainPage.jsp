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
	<a href = ""><h1>Enchères ENI</h1></a>
	<a href = "<%=request.getContextPath()%>/ServletConnexion.java">S'inscrire - Se connecter</a>
	</nav>

	<main>

		<h3 style="text-align: center; height: 3rem;">Liste des Enchères</h3>

<!-- Barre de recherche -->

		<div class = "container-1">

			<form action="<%=request.getContextPath()%>/Recherche" method="post">
			<div>

					<p><label for="disconnected-search-filter">
						Filtre : <input type = "text">
					</label></p>

				<p>
					<label for="search-categorie">Catégorie : </label>
					<select style="width: 100%;">
						<option value = "optionToutes">Toutes</option>
						<option value = "optionInformatique">Informatique</option>
						<option value = "optionAmeublement">Ameublement</option>
						<option value = "optionVêtement">Vêtement</option>
						<option value = "optionSport&Loisirs">Sports & Loisirs</option>
					</select>
				</p>

				<div class = "searchBtn">
					<button></button>
				</div>

			</div>

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