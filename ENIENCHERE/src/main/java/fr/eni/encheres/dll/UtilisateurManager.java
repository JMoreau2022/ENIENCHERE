package fr.eni.encheres.dll;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;
import fr.eni.encheres.messages.BusinessException;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	public void ajouterUtilisateur() {
		this.utilisateurDAO.testConnexion();
		
	}
	
	/**
	 * Méthode de création d'un nouvelle utilisateur de la plateforme
	 * @param pseudo
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param telephone
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @param mdp
	 * @throws BusinessException 
	 */
	public void creationUtilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue, String codePostal, String ville, String mdp) throws BusinessException {
		
		Utilisateur utilisateur = null;
		BusinessException be = new BusinessException(); 
		// la validation de tous les champs sera à faire ici
		
		utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp, 500, 0);
		
		// teste la validité de toutes les données saisies dans le formulaire
		validationPseudo(utilisateur, be);
		validationNom(utilisateur, be);
		validationPrenom(utilisateur, be);
		validationEMail(utilisateur, be);
		validationTelephone(utilisateur, be);
		validationRue(utilisateur, be);
		validationCodePostal(utilisateur, be);
		validationVille(utilisateur, be);
		validationMDP(utilisateur, be);
		
		if (!be.hasErreurs()) {
			this.utilisateurDAO.ajouterUtilisateur(utilisateur);
		}
		else
		{
			throw be;
		}
	}
	
	private void validationPseudo(Utilisateur utilisateur, BusinessException be) {
		if (utilisateur.getPseudo() == null || utilisateur.getPseudo().isEmpty() || utilisateur.getPseudo().length() > 30) {
			be.ajouterErreur(CodesResultatBLL.USER_PSEUDO_ERREUR);
		}
	}
	private void validationNom(Utilisateur utilisateur, BusinessException be) {
		if (utilisateur.getNom() == null || utilisateur.getNom().isEmpty() || utilisateur.getNom().length() > 30) {
			be.ajouterErreur(CodesResultatBLL.USER_NOM_ERREUR);
		}
	}
	private void validationPrenom(Utilisateur utilisateur, BusinessException be) {
		if (utilisateur.getPrenom() == null || utilisateur.getPrenom().isEmpty() || utilisateur.getPrenom().length() > 30) {
			be.ajouterErreur(CodesResultatBLL.USER_PRENOM_ERREUR);
		}
	}
	private void validationEMail(Utilisateur utilisateur, BusinessException be) {
		if (utilisateur.getEmail() == null || utilisateur.getEmail().isEmpty() || utilisateur.getEmail().length() > 50 || (!utilisateur.getEmail().contains("@"))) {
			be.ajouterErreur(CodesResultatBLL.USER_EMAIL_ERREUR);
		}
	}
	private void validationTelephone(Utilisateur utilisateur, BusinessException be) {
		if (utilisateur.getTelephone() == null || utilisateur.getTelephone().isEmpty() || utilisateur.getTelephone().length() > 15) {
			be.ajouterErreur(CodesResultatBLL.USER_TEL_ERREUR);
		}
	}
	private void validationRue(Utilisateur utilisateur, BusinessException be) {
		if (utilisateur.getRue() == null || utilisateur.getRue().isEmpty() || utilisateur.getRue().length() > 30) {
			be.ajouterErreur(CodesResultatBLL.USER_RUE_ERREUR);
		}
	}
	private void validationCodePostal(Utilisateur utilisateur, BusinessException be) {
		if (utilisateur.getCode_postal() == null || utilisateur.getCode_postal().isEmpty() || utilisateur.getCode_postal().length() > 30) {
			be.ajouterErreur(CodesResultatBLL.USER_CODEPOSTAL_ERREUR);
		}
	}
	private void validationVille(Utilisateur utilisateur, BusinessException be) {
		if (utilisateur.getVille() == null || utilisateur.getVille().isEmpty() || utilisateur.getVille().length() > 50) {
			be.ajouterErreur(CodesResultatBLL.USER_VILLE_ERREUR);
		}
	}
	private void validationMDP(Utilisateur utilisateur, BusinessException be) {
		if (utilisateur.getMot_de_passe() == null || utilisateur.getMot_de_passe().isEmpty() || utilisateur.getMot_de_passe().length() > 30) {
			be.ajouterErreur(CodesResultatBLL.USER_MDP_ERREUR);
		}
	}
	
	
}
