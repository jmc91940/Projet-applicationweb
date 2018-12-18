<%-- 
    Document   : jspRecapModifAdherent
    Created on : 17 déc. 2018, 14:14:52
    Author     : User
--%>

<%@page import="tables.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div>  <jsp:include page="jspBandeauResponsableCours.jsp"/> </div>
        <div id="imageResponsable">
            <fieldset>
        <h2>
          Modification de l'adherent  <%= adherent.getNom()%> <%= adherent.getPrenom()%>  effectué
        </h2>

        <br />
        
        <h2>
            Récapitulatif des données entrées
        </h2>
        <p>
            Nom : <%= adherent.getNom()%>
        </p>
         <p>
            Prénom :  <%= adherent.getPrenom()%>
        </p>
         <p>
             Email : <%= adherent.getEmail()%>
        </p>
         <p>
            Telephone : <%= adherent.getTelephone()%>
        </p>
         <p>
             Adresse : <%= adherent.getAdresse()%>
        </p>
         <p>
             Code postale : <%= adherent.getCodePostal()%>
        </p>
         <p>
             Ville : <%= adherent.getVille()%>
        </p>
         <p>
            <a href="ServletControleur?idEcran=20">Retour au menu principale Responsable</a>
        </p>
        </fieldset>
        </div>
    </body>
</html>
