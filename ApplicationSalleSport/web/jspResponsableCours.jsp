<%-- 
    Document   : jspResponsableCours
    Created on : 9 déc. 2018, 19:31:58
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
    
    
%>


<html>
    <head>
        <link href="../miseEnPage.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page ="jspBandeauResponsableCours.jsp" /> </div>
        <div id="imageResponsable">
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
                            <%= cours.getId()%>
                    </td>

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
                        <% if (cours.getIdCoach()!= null)
                      {%>
                        <%= cours.getIdCoach() %>
                        <% } %>
                    </td>
                    <td>
                        <% if (cours.getIdSalle()!= null)
                      {%>
                        <%= cours.getIdSalle() %>
                        <% } %>
                    </td>
                </tr>
               
                <%
                    }
                %>
                
                
            </tbody>
        </table> 
            <p>
            <a name="choixAction"  href="ServletControleur?idEcran=6">Retour au menu cours</a>
        </p>
    </div>
    </body>
</html>
