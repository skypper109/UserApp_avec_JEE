package servlet;
import model.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 List<User> userList = new ArrayList<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().println("Hello world !!!");
		
		//Pour le multi-Routage :
		/*String route = request.getParameter("view");
		switch (route) {
			case "":{
				request.getRequestDispatcher("views/UserForm.jsp").forward(request, response);
				break;
			}
			case "form": {
				request.getRequestDispatcher("views/UserForm.jsp").forward(request, response);
				break;
			}
			case "list":{
			    request.setAttribute("userList", userList);
				request.getRequestDispatcher("views/UserDetails.jsp").forward(request, response);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + route);
		}*/
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//Récupération des données du formulaire : 
		String nom = req.getParameter("nom");
		String prenom = req.getParameter("prenom");
		String email = req.getParameter("email");
		String telephone = req.getParameter("telephone");
		String role = req.getParameter("role");

		User newUser = new User(nom, email, prenom, telephone, role);

		// Récupération de la session + liste existante
		HttpSession session = req.getSession();
		List<User> userList = (List<User>) session.getAttribute("userList");

		if(userList == null) {
			userList = new ArrayList<User>();
		}

		// Ajout et sauvegarde a la fois dans la liste et dans la session : 
		userList.add(newUser);
		session.setAttribute("userList", userList);

		//redirection Pour l'affichage : 
		req.getRequestDispatcher("views/UserDetails.jsp").forward(req, resp);

		
	}

}
