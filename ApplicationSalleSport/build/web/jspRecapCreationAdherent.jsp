<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="tables.*"%>

<!DOCTYPE html>

<% 
Adherent adherent = (Adherent) session.getAttribute("adherent");
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
        <div><jsp:include page ="jspBandeauResponsableAdherent.jsp" /> </div>
        <div id="imageResponsable">
        <h2>
            Enregistrement de l'adhrent <%= adherent.getNom()%> effectué
        </h2>

        <br />
        
        <h2>
            Récapitulatif des données entrées
        </h2>
        <p>
            <%= adherent.getNom() %>
        </p>
         <p>
            <%= adherent.getPrenom() %>
        </p>
         <p>
            <%= adherent.getEmail()%>
        </p>
         <p>
            <%= adherent.getTelephone()%>
        </p>
        <p>
            <%= adherent.getAdresse()%>
        </p>
        <p>
            <%= adherent.getCodePostal()%> 
        </p>
        <p>
            <%= adherent.getVille()%>
        </p>
        

        <p>
            <a href="ServletControleur?idEcran=4">Retour au menu principal</a>
        </p>
        </div>
    </body>
</html>
