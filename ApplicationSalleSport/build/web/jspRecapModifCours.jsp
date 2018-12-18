<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="tables.*"%>

<!DOCTYPE html>

<% 
Cours cours = (Cours) session.getAttribute("cours");
%>

<html>
    <head>
        <title>Enregistrement de la modification</title>
        <meta http-equiv="Content-Type"
              content="text/html; charset=utf-8" />
        <link rel="stylesheet" 
              type="text/css"
              href="miseEnPage.css" />
    </head>

    <body>
        <div>  <jsp:include page="jspBandeauResponsableCours.jsp"/> </div>
        <div id="imageResponsable">
            <fieldset>
        <h2>
          Modification du cours <%= cours.getLibelle()%> effectué
        </h2>

        <br />
        
        <h2>
            Récapitulatif des données entrées
        </h2>
        <p>
            Nom du cours : <%= cours.getLibelle()%>
        </p>
         <p>
            Durée (en minute) :<%= cours.getDuree()%>
        </p>
         <p>
            Identifiant du coach: <%= cours.getIdCoach()%>
        </p>
         <p>
           Identifiant de la salle: <%= cours.getIdSalle()%>
        </p>
        
         <p>
            <a href="ServletControleur?idEcran=4">Retour au menu principal</a>
        </p>
        </fieldset>
        </div>
    </body>
</html>
