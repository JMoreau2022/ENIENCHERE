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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		} catch (BusinessException be) {
			request.setAttribute("listeDesErreurs", be.getListeCodesErreur());
			doGet(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/CreationUtilisateur.jsp");
		rd.forward(request, response);
	}

}
