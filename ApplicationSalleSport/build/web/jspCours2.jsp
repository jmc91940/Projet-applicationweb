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
    Vector<OntLieu> listeOntLieu =
        (Vector)session.getAttribute("listeOntLieu");

   
    Vector<Colonne> listeColonnes =
        (Vector)session.getAttribute("listeColonnes");
    OntLieu ontLieu;
    
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
            <caption>PLANNING DES COURS</caption>
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
                    for (int i = 0; i < listeOntLieu.size(); i++)
                    {
                        ontLieu = listeOntLieu.elementAt(i);
                        
                %>
                <tr>
         

                    <td>
                        <% if (ontLieu.getCours().getLibelle() != null)
                      {%>
                        <%= ontLieu.getCours().getLibelle()%>
                        <% } %>
                    </td>

                    <td>
                        <% if (ontLieu.getHeure()!= null)
                      {%>
                        <%= ontLieu.getHeure() %>
                        <% } %>
                    </td>
                   
                </tr>
               
                <%
                    }
                %>
                
                
            </tbody>
        </table> 
            <p>
            <a name="choixAction"  href="ServletControleur?idEcran=1&choixAction=Cours">Retour au menu cours</a>
        </p>
    </div>
    </body>
</html>
