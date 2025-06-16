<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulaire d'inscription</title>
    <link rel="stylesheet" href="views/style.css">
</head>
<body>

<div class="container">

	<div class="nav-bar">
		<div class="form-link form-link1">
			<a href="UserServlet?view=form">Inscrire un User</a>
		</div>
	
		<div class="form-link form-link2">
			<a href="UserServlet?view=list">Voir les Users</a>
		</div>
	</div>
	
    <h1><span class="highlight">Inscription</span> d’un nouvel utilisateur</h1>
    <p class="subtitle">Remplissez les informations ci-dessous :</p>
    
    <% 
    		HttpSession session2 = request.getSession();
    		String erreur = (String) session2.getAttribute("error");
    		if(erreur != null && !erreur.isBlank()){
    			
    	%>
    <p class="error"> <%= erreur %> </p>
	<% 
		session2.removeAttribute("error");
    		}
    	%>
	
    <form action="UserServlet" method="post" class="form-grid">
        <div class="form-group">
            <label for="nom">Nom :</label>
            <input type="text" id="nom" name="nom" required>
        </div>

        <div class="form-group">
            <label for="prenom">Prénom :</label>
            <input type="text" id="prenom" name="prenom" required>
        </div>

        <div class="form-group">
            <label for="email">Email :</label>
            <input type="email" id="email" name="email" required>
        </div>

        <div class="form-group">
            <label for="telephone">Téléphone :</label>
            <input type="text" id="telephone" name="telephone">
        </div>

        <div class="form-group">
            <label for="role">Rôle :</label>
            <select id="role" name="role">
                <option value="admin">Administrateur</option>
                <option value="user">Utilisateur</option>
                <option value="invite">Invité</option>
            </select>
        </div>

        <div class="form-submit">
            <button type="submit">Enregistrer</button>
        </div>
    </form>
</div>

</body>
</html>
