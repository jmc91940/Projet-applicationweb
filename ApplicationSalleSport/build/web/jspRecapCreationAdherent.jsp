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
            <fieldset>
        <h2 style>
           L'adhérent <%= adherent.getNom()%> <%= adherent.getPrenom()%> a bien été créé.
        </h2>

        <br />
        
        <h2>
            Récapitulatif des données entrées
        </h2>
        <p>
           Nom: <%= adherent.getNom() %>
        </p>
         <p>
            Prenom: <%= adherent.getPrenom() %>
        </p>
         <p>
            Email: <%= adherent.getEmail()%>
        </p>
         <p>
           Telephone: <%= adherent.getTelephone()%>
        </p>
        <p>
           Adresse: <%= adherent.getAdresse()%>
        </p>
        <p>
            Code Postale: <%= adherent.getCodePostal()%> 
        </p>
        <p>
            Ville: <%= adherent.getVille()%>
        </p>
        

        <p>
            <a href="ServletControleur?idEcran=22">Retour au menu principal</a>
        </p>
        </fieldset>
        </div>
    </body>
</html>
