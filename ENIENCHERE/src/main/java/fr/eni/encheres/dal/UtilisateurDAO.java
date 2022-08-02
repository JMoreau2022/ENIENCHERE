package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.messages.BusinessException;

public interface UtilisateurDAO {

	void ajouterUtilisateur(Utilisateur utilisateur) throws BusinessException;
	void testConnexion();
	
	 
}
