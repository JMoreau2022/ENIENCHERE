<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Accueil connecté</h1>

	<h2>${user.nom}</h2>
	
			<nav>
			
				<div class="itemsNavAccueilConnecte"><p id="pseudoConnecte">${pseudoLog}, connecté(e)</p></div>
				<a href="" class="itemsNavAccueilConnecte">Enchères</a>
				<a href="<%=request.getContextPath()%>/Accueil" class="itemsNavAccueilConnecte">Accueil</a>
				<a href="<%=request.getContextPath()%>/VendreArticle?pseudoLog=${pseudoLog}" class="itemsNavAccueilConnecte">Vendre un article</a>
				<a href="<%=request.getContextPath()%>/Profil?pseudo=${pseudoLog}&pseudoLog=${pseudoLog}" class="itemsNavAccueilConnecte">Mon profil</a>
				<a href="<%=request.getContextPath()%>/Profil" class="itemsNavAccueilConnecte">TEST</a>
				<a href="<%=request.getContextPath()%>/Accueil" class="itemsNavAccueilConnecte">Déconnexion</a>
				
				
			
			</nav>
	
</body>
</html>