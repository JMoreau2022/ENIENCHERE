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

		// La connexion se faisant par le pseudo ou le mail, on va tester l'unicité de chacun des 2 avant d'ajouter un utilisateur
		if (this.utilisateurDAO.selectUserByPseudo(pseudo)!=null) {
			be.ajouterErreur(CodesResultatBLL.USER_PSEUDO_DEJA_EXISTANT);
		}
		if (this.utilisateurDAO.selectUserByMail(email)!=null) {
			be.ajouterErreur(CodesResultatBLL.USER_MAIL_DEJA_EXISTANT);
		}
		
		// création d'un ojet Utilisateur
		utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp, 100, 0);
		
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
		else
		if (!utilisateur.getPseudo().matches("^[a-zA-Z0-9]*$")) {
			be.ajouterErreur(CodesResultatBLL.USER_PSEUDO_FORMAT_INVALIDE);
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

	/**
	 * Méthode renvoyant l'utilisateur si celui-ci est trouvé en base de données selon son identifiant et son mot de passe
	 * @param identifiant
	 * @param mdp
	 * @return
	 * @throws BusinessException
	 */
	public Utilisateur connexionUtilisateur(String identifiant, String mdp) throws BusinessException {
		Utilisateur utilisateur = null;
		BusinessException be = new BusinessException(); 
		
		// on peut se connecter soit par le pseudo soit par le mail
		if (identifiant.contains("@")) {
			utilisateur = this.utilisateurDAO.selectUserByMail(identifiant);
		}
		else {
			utilisateur = this.utilisateurDAO.selectUserByPseudo(identifiant);
		}
			
		// Si l'utilisateur existe et que le mot de passe est correcte, on retourne l'utilisateur, sinon on renvoi une erreur
		if (utilisateur!=null && utilisateur.getMot_de_passe().equals(mdp)) {
			return utilisateur;
		}
		else {
			be.ajouterErreur(CodesResultatBLL.USER_IDENTIFIANT_MDP_INVALIDE);
			throw be;
		}
	}

	public Utilisateur modificationUtilisateur(Integer id, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String mdp) throws BusinessException {
		Utilisateur utilisateur = null;
		BusinessException be = new BusinessException(); 

		System.out.println(id);
		
		// récupération de l'utilisateur id (celui qui est connecté) pour après tester le mail et pseudo que si les nouvelles saisies sont différentes
		Utilisateur userConnecte = null;
		userConnecte = this.utilisateurDAO.recupererUtilisateurParId(id);
		System.out.println(userConnecte.toString());
		// Si ce n'est pas le mot pseudo, on teste son unicité
		if (!userConnecte.getPseudo().equals(pseudo) && this.utilisateurDAO.selectUserByPseudo(pseudo)!=null) {
			be.ajouterErreur(CodesResultatBLL.USER_PSEUDO_DEJA_EXISTANT); 
		}
		// idem avec l'email
		if  (!userConnecte.getEmail().equals(email) && this.utilisateurDAO.selectUserByMail(email)!=null) {
			be.ajouterErreur(CodesResultatBLL.USER_MAIL_DEJA_EXISTANT); 
		}
			 		  
		  // création d'un ojet Utilisateur 
		  utilisateur = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, mdp, 100, 0);
		  
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
			this.utilisateurDAO.ModifierUtilisateur(utilisateur);
			return utilisateur;
		}
		else
		{
			throw be;
		}
		
	}
	
	
}
