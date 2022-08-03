<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_user.css">
	<title>Enchères ENI</title>
</head>
<body>
	<nav class = "nav">
	<h1>Enchères ENI</h1>
	<a href = "#">S'inscrire - Se connecter</a>
	</nav>
	<main>
		<h3 style="text-align: center; height: 3rem;">Liste des Enchères</h3>
		<div class = "container-1">

			<div class = "categories">
				<section>Filtres :</section>
				<section><input type = "text" class = "filter"></section><br>

				<div class = "box-categories">

					<div>
						<div>Catégorie</div>
					</div>

					<div class = "categories">
					<select style="width: 100%;">
						<option value = "optionToutes">Toutes</option>
						<option value = "optionInformatique">Informatique</option>
						<option value = "optionAmeublement">Ameublement</option>
						<option value = "optionVêtement">Vêtement</option>
						<option value = "optionSport&Loisirs">Sports & Loisirs</option>
					</select>
					</div>

				</div>

			</div>
			<div class = "searchBtn">
				<input type = "submit" value = "Rechercher" class = "search_btn">
			</div>
		</div>
		<div class = "container-2">
			<div class = "encheres">

			</div>
		</div>
	</main>
</body>
</html>