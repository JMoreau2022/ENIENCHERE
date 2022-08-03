<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style_user.css">
<title>Création compte</title>
</head>
<body>
	
<%-- 	<h1>Test de connexion</h1>

	<form action="<%=request.getContextPath()%>/CreationUtilisateur" method="post">
	
		<label for="idNom">Nom : </label><input class="info" type="text" id="idNom" name="nom" value=""/>
		<br/>
		<label for="idPrenom">Prénom : </label><input class="info" type="text" id="idPrenom" name="prenom" value=""/>
		<br/>
		<input type="submit" value="Valider"/>
	</form>
 --%>	
	
	<h1>Mon profil</h1>

		<div>
		<form method="post" action="<%=request.getContextPath()%>/CreationUtilisateur">
		
			<div id="conteneur"> 
				<div id="user-gauche">
				
					<div>
					<label for="pseudo">Pseudo* : </label>
		            <input type="text" placeholder="pseudo (30 car. max)" name="pseudo">
		            </div>
		            
		            <div>
		            <label for="prenom">Prénom* : </label>
		            <input type="text"  placeholder="Prénom (30 car. max)" name="prenom">
		            </div>
		            
		            <div>
		            <label for="telephone">Téléphone : </label>
		            <input type="text" placeholder="0611223344 (15 car. max)" name="telephone">
		            </div>
		            
		            <div>
		            <label for="codepostal">Code postal* : </label>
		            <input type="text" placeholder="44000" name="codepostal">
		            </div>
		            
		            <div>
		            <label for="mdp">Mot de passe* : </label>
		            <input type="password" name="mdp">
		            </div>
	            
				</div>
				
				<div id="user-droite">
				
					<div>
					<label for="nom">Nom* : </label>
		            <input type="text" placeholder="Nom (30 car. max)" name="nom">
		            </div>
		            
		            <div>
		            <label for="email">Email* : </label>
		            <input type="text"  placeholder="monemail@gmail.com (50 car. max)" name="email">
		            </div>
		            
		            <div>
		            <label for="rue">Rue* : </label>
		            <input type="text" placeholder="rue de l'océan (30 car. max)" name="rue">
		            </div>
		            
		            <div>
		            <label for="ville">Ville* : </label>
		            <input type="text" placeholder="Nantes (30 car. max)" name="ville">
		            </div>
		            
		            <div>
		            <label for="confirmationMdp">Confirmation* : </label>
		            <input type="password" name="confirmationMdp">
		            </div>
	            
				</div>
			</div>	
			
			<p>* : ces champs sont obligatoires.</p>
			<div class="btnUser">
				<input type="submit" value="Créer" name="boutonCreer">	
				
				<a href="%=request.getContextPath()%>/Accueil"><input type="button" value="Annuler" name="boutonAnnuler"></a>			
			</div>
		
		</form>
		</div>
		
		<c:if test="${!empty listeDesErreurs}">
			<div>
			  <strong>Un ou plusieurs champs de saisie sont mal renseignés</strong>
			  <ul>
			  	<c:forEach var="code" items="${listeDesErreurs}">
			  		<li>${LecteurMessage.getMessageErreur(code)}</li>
			  	</c:forEach>
			  </ul>
			</div>
		</c:if>
		
		


</body>
</html>