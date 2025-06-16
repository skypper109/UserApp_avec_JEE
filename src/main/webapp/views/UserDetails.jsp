<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Utilisateurs</title>
    <link rel="stylesheet" href="views/style.css">
    <script type="text/javascript" src="views/script.js" async></script>
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
	
    <h1><span class="highlight">Utilisateurs enregistrés</span></h1>
    <p class="subtitle">Voici les informations des utilisateurs inscrits :</p>

    <%
    		HttpSession sess = request.getSession();
        List<User> userList = (List<User>) sess.getAttribute("userList");
        int count = 0;
    %>

    <div class="user-list">
        <%
            if (userList != null && !userList.isEmpty()) {
                for (User user : userList.reversed()) {
                    count++;
        %>
            <div class="user-card">
                <p><strong>Nom :</strong> <%= user.getNom() %></p>
                <p><strong>Prénom :</strong> <%= user.getPrenom() %></p>

                <div id="details-<%= count %>" style="display: none; margin-top: 10px;">
                    <p><strong>Email :</strong> <%= user.getEmail() %></p>
                    <p><strong>Téléphone :</strong> <%= user.getTelephone() %></p>
                    <p><strong>Rôle :</strong> <%= user.getRole() %></p>
                </div>

                <button  class="form-submit" onclick="changeDetails('<%= count %>')">Voir détails</button>
            </div>
        <%
                }
            } else {
            	response.sendRedirect("UserServlet?view=form");
            //	request.getRequestDispatcher("UserServlet?view=form").forward(request, response);
            }
        %>
    </div>
</div>

</body>
</html>
