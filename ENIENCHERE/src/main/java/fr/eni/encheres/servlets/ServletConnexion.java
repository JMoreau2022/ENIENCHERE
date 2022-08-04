package fr.eni.encheres.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dll.UtilisateurManager;
import fr.eni.encheres.messages.BusinessException;

/**
 * Servlet implementation class ServletConnexion
 */
@WebServlet("/Connexion")
public class ServletConnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**r
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/Connexion.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Utilisateur user = null;
		// récupération de l'identifiant et du mot de passe
		String identifiant = request.getParameter("identifiant").trim();
		String mdp = request.getParameter("mdp").trim();
		
		UtilisateurManager utilisateurManager = new UtilisateurManager(); 
		try {
			user = utilisateurManager.connexionUtilisateur(identifiant,mdp);
			
			// TODO : mettre l'utilisateur dans la session pour le retrouver dans les autres pages
			// on met l'objet en entier mais on aurait pu mettre seulement l'ID
			request.getSession().setAttribute("user", user);

			//HttpSession session = request.getSession();
			// Set dans la session l'attribut "utilisateur"
			//session.setAttribute("utilisateur", user);
			
			
			// Si la connexion est établie, on se redirige vers la page d'AcceuilConnectee
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/AccueilConnecte.jsp");
			rd.forward(request, response);
			
		} catch (BusinessException be) {
			request.setAttribute("listeDesErreurs", be.getListeCodesErreur());
			doGet(request, response);
		}

	}

}
