<%-- 
    Document   : jspActivité
    Created on : 15 nov. 2018, 11:01:28
    Author     : User
--%>

<%@page import="divers.Colonne ,java.util.Vector, tables.Evenement "%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%-- ------------------------------------------------------------------- --%>
<%-- Vecteurs des Evenement et des colonnes                               --%>
<%-- ------------------------------------------------------------------- --%>
<%
    Vector<Evenement> listeEvenement =
        (Vector)session.getAttribute("listeEvenement");
    Vector<Colonne> listeColonnes =
        (Vector)session.getAttribute("listeColonnes");
    Evenement evenement;
%>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page Evenement</title>
        
    </head>
    <body>
         <div>  
          <jsp:include page="jspBandeau.jsp"/>  
         </div>
         <div id="imageEvenement">
             <table >
            <caption>LISTE DES EVENEMENT</caption>
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
                    for (int i = 0; i < listeEvenement.size(); i++)
                    {
                        evenement= listeEvenement.elementAt(i);
                %>
                <tr>
                    
                    <td>
                        <% if (evenement.getLibelle() != null)
                      {%>
                        <%= evenement.getLibelle()%>
                        <% } %>
                    </td>

                    <td>
                        <% if (evenement.getDate() != null)
                      {%>
                        <%= evenement.getDate()%>
                        <% } %>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
            
            <p class="couleurEcriture">
            <a href="ServletControleur?idEcran=3">Retour au menu principal</a>
           </p>
         </div>
             
         
    </body>
</html>
