<%-- 
    Document   : jspCours
    Created on : 13 nov. 2018, 15:38:45
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector, divers.*, tables.*" %>

<!DOCTYPE html>
<% 
    String choixAction = (String) session.getAttribute("choixAction");
%>
<%-- ------------------------------------------------------------------- --%>
<%-- Vecteurs des cours et des colonnes                               --%>
<%-- ------------------------------------------------------------------- --%>
<%
    Vector<Cours> listeCours =
        (Vector)session.getAttribute("listeCours");

   
    Vector<Colonne> listeColonnes =
        (Vector)session.getAttribute("listeColonnes");
    Cours cours;
    Coach coach;
    
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste Cours</title>
        
    </head>
    <body>
    <div>  <jsp:include page="jspBandeauCours.jsp"/> </div>
    <div id="imageCours">
          <table >
            <caption>LISTE DES COURS</caption>
            <thead>
                <tr>
                    <%
                        for (int i = 0; i < listeColonnes.size(); i++)
                        {
                            if (listeColonnes.elementAt(i).getLongueur() < 16)
                            {
                    %>
                    <th class="petitTitreColonne">
                        <%
                        }
                        else
                        {
                        %>
                    <th>
                        <%
                            }
                        %>
                        <%=listeColonnes.elementAt(i).getNom()%>
                        
                    </th>
                    
                    <%
                        }
                    %>
                    
                </tr>
            </thead>

            <tbody>
                <%
                    for (int i = 0; i < listeCours.size(); i++)
                    {
                        cours = listeCours.elementAt(i);
                        
                %>
                <tr>
         

                    <td>
                        <% if (cours.getLibelle()!= null)
                      {%>
                        <%= cours.getLibelle()%>
                        <% } %>
                    </td>

                    <td>
                        <% if (cours.getDuree() != null)
                      {%>
                        <%= cours.getDuree()%>
                        <% } %>
                    </td>
          
                    <td>
                        <% if (cours.getCoach().getNom()!= null)
                      {%>
                        <%= cours.getCoach().getNom() %>
                        <% } %>
                    </td>
                    
                    <td>
                        <% if (cours.getSalle().getLibelle()!= null)
                      {%>
                        <%= cours.getSalle().getLibelle() %>
                        <% } %>
                    </td>
                   
                </tr>
               
                <%
                    }
                %>
                
                
            </tbody>
        </table> 
            <p>
            <a name="choixAction"  href="ServletControleur?idEcran=20">Retour au menu principale</a>
        </p>
    </div>
    </body>
</html>
