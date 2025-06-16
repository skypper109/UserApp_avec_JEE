package servlet;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter("/UserServlet") 
public class UserInsertionFilter implements Filter {


    @SuppressWarnings("unchecked")
	@Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) request;
		//On recupere la liste des users dans la session :
		HttpSession session = req.getSession();
		List<User> userList = (List<User>) session.getAttribute("userList");

        // Vérifier si c'est bien une requête POST pour insertion
        if ("POST".equalsIgnoreCase(req.getMethod())) {
            String nom = req.getParameter("nom");
            String email = req.getParameter("email");
            String telephone = req.getParameter("telephone");

            // Cas avec uniquement le Nom et Email : bloquer si nom ou email est vide
            if (nom == null || nom.isBlank() || email == null || email.isBlank()) {
            		//Pour l'affichage de l'erreur dans le console :
            		System.out.println("Erreur : Le nom et l'email sont obligatoires ! ");
            		//Pour l'enregistrement de l'erreur dans la session :
                session.setAttribute("error", "Le nom et l'email sont obligatoires !");
                request.getRequestDispatcher("/views/UserForm.jsp").forward(request, response);
                return;
            }
            
            if (userList == null) {
	    		    userList = new ArrayList<>();
	    		}
	
	    		// 3. Vérification des doublons
	    		boolean emailExists = false;
	    		boolean telephoneExists = false;
	
	    		for (User u : userList) {
	    		    if (email != null && email.equalsIgnoreCase(u.getEmail())) {
	    		        emailExists = true;
	    		    }
	    		    if (telephone != null && telephone.equalsIgnoreCase(u.getTelephone())) {
	    		        telephoneExists = true;
	    		    }
	    		}
	
	    		if (emailExists) {
            		//Pour l'affichage de l'erreur dans le console :
            		System.out.println("Erreur : Erreur. Cet Email existe déjà ! ");
            		//Pour l'enregistrement de l'erreur dans la session
	    		    session.setAttribute("error", "Erreur. Cet Email existe déjà !");
	            request.getRequestDispatcher("/views/UserForm.jsp").forward(request, response);
	    		    return;
	    		}
	
	    		if (telephoneExists) {
            		//Pour l'affichage de l'erreur dans le console :
            		System.out.println("Erreur : Erreur. Ce numéro de téléphone existe déjà ! ");
            		//Pour l'enregistrement de l'erreur dans la session
	    		    session.setAttribute("error", "Erreur. Ce numéro de téléphone existe déjà !");
	            request.getRequestDispatcher("/views/UserForm.jsp").forward(request, response);
	    		    return;
	    		}

            // Afficher dans le console la reussite de la tentative d'insertion d'utilisateur
            System.out.println("Tentative d'insertion utilisateur : " + nom + " | " + email+" Reussie avec succès !!!");
        }
        else if("GET".equalsIgnoreCase(req.getMethod())) {
        		//on verifie aussi la methode get si rien d'autre n'est envoyé a travers l'url a par le parametre view

	    		String route = request.getParameter("view");
	    		
	    		if(route == null) {
    				request.getRequestDispatcher("views/UserForm.jsp").forward(request, response);
    				return;
	    		}
	    		
	    		//On redirige en fonction de ce qui a ete recuperer a travers la methode get qui est stocké dans la variable route:
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
	    				request.getRequestDispatcher("Error404.jsp").forward(request, response);
	    		}
	    		if(request.getParameter("...") != null) {
	    			request.getRequestDispatcher("Error404.jsp").forward(request, response);
	    		}
        }
        // Continuer la chaîne normale
        chain.doFilter(request, response);
    }

}
