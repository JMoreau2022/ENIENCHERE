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

<!-- Barre de nav -->

	<nav class = "nav">
	<a href = "mainPageDisconnected.jsp"><h1>Enchères ENI</h1></a>
	<a href = "#">S'inscrire - Se connecter</a>
	</nav>

	<main>

		<h3 style="text-align: center; height: 3rem;">Liste des Enchères</h3>

<!-- Barre de recherche -->

		<div class = "container-1">

			<div>

				<form action="<%=request.getContextPath()%>/Recherche" method="post">
					<label for="filter">
						<input type = "text">
					</label>
				</form>

			</div>

			<div>

					<form action="" method="post">
						<select style="width: 100%;">
						<option value = "optionToutes">Toutes</option>
						<option value = "optionInformatique">Informatique</option>
						<option value = "optionAmeublement">Ameublement</option>
						<option value = "optionVêtement">Vêtement</option>
						<option value = "optionSport&Loisirs">Sports & Loisirs</option>
						</select>
					</form>

				</div>

			</div>
			
			<div class = "searchBtn">
				<form method="post">
					<input type = "submit" value = "Rechercher" class = "search_btn">
				</form>
			</div>

		</div>

		<div class = "container-2">
		</div>

	</main>
</body>
</html>