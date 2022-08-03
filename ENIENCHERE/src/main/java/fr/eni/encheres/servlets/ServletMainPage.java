package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.ListeEncheres;

/**
 * Servlet implementation class ServletMainPage
 */
@WebServlet("/DisconnectedMainPage")
public class ServletMainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/DisconnectedMainPage.jsp");
		rd.forward(request, response);
	}

	/**
	 * @param enchereEnCours 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//récupération des paramètres
		
		String titre = request.getParameter("titre".trim());
		String prix = request.getParameter("prix".trim());
		String finEnchere = request.getParameter("finEnchere".trim());
		String nomVendeur = request.getParameter("nomVendeur".trim());
		
		//attribution des paramètres
		
		request.setAttribute("enchereEnCoursTitre", titre);
		request.setAttribute("enchereEnCoursPrix", prix);
		request.setAttribute("enchereEnCoursFinEnchere", finEnchere);
		request.setAttribute("enchereEnCoursNomVendeur", nomVendeur);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/DisconnectedMainPage.jsp");
		rd.forward(request, response);
		doGet(request, response);
	}

}
