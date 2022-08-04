<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_user.css">
<title>Connexion</title>
</head>
<body>

	<h1>Se connecter</h1>

	<form method="post" action="<%=request.getContextPath()%>/Connexion">
	
	<div>
		<label for="identifiant">Identifiant : </label>
        <input type="text" placeholder="mail ou pseudo" name="identifiant">
    </div>
	<div>
		<label for="mdp">Mot de passe : </label>
        <input type="password" name="mdp">
    </div>

            <div>
                <button type="submit" class="button" id="buttonConnexion">Connexion</button>
            </div>
	</form>

		<c:if test="${!empty listeDesErreurs}">
			<div>
			  <strong>Erreur</strong>
			  <ul>
			  	<c:forEach var="code" items="${listeDesErreurs}">
			  		<li>${LecteurMessage.getMessageErreur(code)}</li>
			  	</c:forEach>
			  </ul>
			</div>
		</c:if>
            

</body>
</html>