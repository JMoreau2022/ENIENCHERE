package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dll.CodesResultatBLL;
import fr.eni.encheres.dll.UtilisateurManager;
import fr.eni.encheres.messages.BusinessException;

/**
 * Servlet implementation class ServletModificationProfil
 */
@WebServlet("/ModificationProfil")
public class ServletModificationProfil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rq = request.getRequestDispatcher("WEB-INF/jsp/ModificationProfil.jsp");
		rq.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		Utilisateur userModifier = null;

		// recupération des paramêtres dans la requête
		String pseudo = request.getParameter("pseudo").trim();
		String nom = request.getParameter("nom").trim();
		String prenom = request.getParameter("prenom").trim();
		String email = request.getParameter("email").trim();
		String telephone = request.getParameter("telephone").trim();
		String rue = request.getParameter("rue").trim();
		String codePostal = request.getParameter("codepostal").trim();
		String ville = request.getParameter("ville").trim();
		String mdp = request.getParameter("mdp").trim();
		String confirmationMdp = request.getParameter("confirmationMdp").trim();

		// récupération de l'id de l'utilisateur connecté (en session) pour le passer à la méthode modificationUtilisateur
		Utilisateur userConnecte = (Utilisateur) request.getSession().getAttribute("user");
		Integer id = userConnecte.getNo_utilisateur();
		System.out.println("id de l'utilisateur connecté "+id);
		// si les mots de passe sont identiques, on essaie de modifier l'utilisateur après avoir testé la validation de tous les champs
		if (confirmationMdp.equals(mdp)) {
			UtilisateurManager utilisateurManager = new UtilisateurManager();
			try {
				System.out.println("id à modifier : "+id);	
				userModifier = utilisateurManager.modificationUtilisateur(id, pseudo, nom, prenom, email, telephone, rue, codePostal, ville,mdp);
			} catch (BusinessException e) {
				request.setAttribute("listeDesErreurs", e.getListeCodesErreur());
				doGet(request, response);
			}
			
			// si tout est ok, on supprime l'ancien user en session et on ajoute le nouveau utilisateurModifier
			if (userModifier!=null) {
				session = request.getSession();   			// Création d'une session
				session.removeAttribute("user");  			// Réinitialise l'attribut "user" dans la session
				session.setAttribute("user", userModifier); // Set l'attribut "user" dans la session
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AccueilConnecte.jsp");
			rd.forward(request, response);

		}
		// si les mots de passe ne sont pas identiques -> message d'erreur
		else {
			BusinessException be = new BusinessException();
			be.ajouterErreur(CodesResultatBLL.USER_MDP_DIFFERENT);
			request.setAttribute("listeDesErreurs", be.getListeCodesErreur());
			doGet(request, response);
		}

	}

}
