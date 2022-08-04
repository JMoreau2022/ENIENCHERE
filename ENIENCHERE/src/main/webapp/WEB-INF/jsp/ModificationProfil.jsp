<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="fr.eni.encheres.messages.LecteurMessage"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modification du profil</title>
</head>
<body>

	<h1>Mon profil</h1>
	
	
		<div>
		<form method="post" action="<%=request.getContextPath()%>/ModificationProfil">
		
			<div> 
				<div>
				
					<div>
					<label for="pseudo">Pseudo* : </label>
		            <input type="text" value="${user.pseudo}" name="pseudo">
		            </div>
		            
		            <div>
		            <label for="prenom">Prénom* : </label>
		            <input type="text" value="${user.prenom}" name="prenom">
		            </div>
		            
		            <div>
		            <label for="telephone">Téléphone : </label>
		            <input type="text" value="${user.telephone}" name="telephone">
		            </div>
		            
		            <div>
		            <label for="codepostal">Code postal* : </label>
		            <input type="text" value="${user.code_postal}" name="codepostal">
		            </div>
		            
		            <div>
		            <label for="mdp">Mot de passe* : </label>
		            <input type="password" value="${user.mot_de_passe}" name="mdp">
		            </div>
	            
				</div>
				
				<div>
				
					<div>
					<label for="nom">Nom* : </label>
		            <input type="text" value="${user.nom}" name="nom">
		            </div>
		            
		            <div>
		            <label for="email">Email* : </label>
		            <input type="text" value="${user.email}" name="email">
		            </div>
		            
		            <div>
		            <label for="rue">Rue* : </label>
		            <input type="text" value="${user.rue}" name="rue">
		            </div>
		            
		            <div>
		            <label for="ville">Ville* : </label>
		            <input type="text" value="${user.ville}" name="ville">
		            </div>
		            
		            <div>
		            <label for="confirmationMdp">Confirmation* : </label>
		            <input type="password" value="${user.mot_de_passe}" name="confirmationMdp">
		            </div>

					<div>
					<label for="credit">Crédit </label><label>${user.credit}</label>
					</div>	            
				</div>
			</div>	
			
			<p>* : ces champs sont obligatoires.</p>
			<div class="btnUser">
				<input type="submit" value="Modifier" name="boutonCreer">	
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