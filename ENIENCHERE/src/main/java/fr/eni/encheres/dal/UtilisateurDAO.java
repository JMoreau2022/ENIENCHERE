package fr.eni.encheres.dal;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.messages.BusinessException;

public interface UtilisateurDAO {

	public void ajouterUtilisateur(Utilisateur utilisateur) throws BusinessException;
	
	public Utilisateur selectUserByPseudo(String pseudo) throws BusinessException;
	
	public Utilisateur selectUserByMail(String email) throws BusinessException;
	
	void testConnexion();

	public void ModifierUtilisateur(Utilisateur utilisateur) throws BusinessException;

	public Utilisateur recupererUtilisateurParId(Integer id) throws BusinessException;
					   
	 
}
