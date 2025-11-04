<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.uit.model.Etudiant" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestion des Étudiants</title>
</head>
<body>
<div class="container">
    <h1> Gestion des Étudiants </h1>


    <div id="rechercher" class="tab-content active">
        <form action="<%= request.getContextPath() %>/rechercher" method="post">
            <div class="form-group">
                <label for="cinRecherche">CIN de l'étudiant</label>
                <input type="text"
                       name="cin"
                       id="cinRecherche"
                       placeholder="Entrez le CIN"
                       class="form-control"
                       value="<%= request.getParameter("cin") != null ? request.getParameter("cin") : "" %>"/>
            </div>
            <input type="submit" value=" Rechercher" class="btn btn-primary"/>
        </form>
    </div>


    <div id="ajouter" class="tab-content">
        <form action="<%= request.getContextPath() %>/ajouter" method="post">
            <div class="form-group">
                <label for="cinAjout">CIN</label>
                <input type="text"
                       name="cin"
                       id="cinAjout"
                       placeholder="CIN"
                       class="form-control"
                       value=""/>
            </div>
            <div class="form-group">
                <label for="nom">Nom</label>
                <input type="text"
                       name="nom"
                       id="nom"
                       placeholder="Nom"
                       class="form-control"
                       value=""/>
            </div>
            <div class="form-group">
                <label for="prenom">Prénom</label>
                <input type="text"
                       name="prenom"
                       id="prenom"
                       placeholder="Prénom"
                       class="form-control"
                       value=""/>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text"
                       name="email"
                       id="email"
                       placeholder="email@example.com"
                       class="form-control"
                       value=""/>
            </div>
            <input type="submit" value=" Ajouter l'étudiant" class="btn btn-primary"/>
        </form>
    </div>


    <div id="supprimer" class="tab-content">
        <form action="<%= request.getContextPath() %>/supprimer"
              method="post"
              onsubmit="return confirm('Êtes-vous sûr de vouloir supprimer cet étudiant ?');">
            <div class="form-group">
                <label for="cinSupprimer">CIN de l'étudiant à supprimer</label>
                <input type="text"
                       name="cin"
                       id="cinSupprimer"
                       placeholder="Entrez le CIN"
                       class="form-control"
                       value=""/>
            </div>
            <input type="submit" value=" Supprimer l'étudiant" class="btn btn-danger"/>
        </form>
    </div>


    <%
        Etudiant etudiant = (Etudiant) request.getAttribute("etudiant");
        if (etudiant != null) {
    %>
    <div class="result-card">
        <h3> Informations de l'étudiant</h3>
        <div class="result-item">
            <span class="result-label">CIN:</span>
            <span class="result-value"><%= etudiant.getCin() %></span>
        </div>
        <div class="result-item">
            <span class="result-label">Nom:</span>
            <span class="result-value"><%= etudiant.getNom() %></span>
        </div>
        <div class="result-item">
            <span class="result-label">Prénom:</span>
            <span class="result-value"><%= etudiant.getPrenom() %></span>
        </div>
        <div class="result-item">
            <span class="result-label">Email:</span>
            <span class="result-value"><%= etudiant.getEmail() %></span>
        </div>
    </div>
    <% } %>
</div>
</div>



</body>
</html>
