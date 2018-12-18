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
    Vector<Adherent> listeAdherent =
        (Vector)session.getAttribute("listeAdherent");

   
    Vector<Colonne> listeColonnes =
        (Vector)session.getAttribute("listeColonnes");
    Adherent adherent;
    
    
%>


<html>
    <head>
        <link href="../miseEnPage.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div><jsp:include page ="jspBandeauResponsableAdherent.jsp" /> </div>
        <div id="imageResponsable">
        <table >
            <caption>LISTE DES ADHERENT</caption>
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
                    for (int i = 0; i < listeAdherent.size(); i++)
                    {
                        adherent = listeAdherent.elementAt(i);
                        
                %>
                <tr>
                    

                    <td>
                        <% if (adherent.getNom()!= null)
                      {%>
                        <%= adherent.getNom()%>
                        <% } %>
                    </td>

                    <td>
                        <% if (adherent.getPrenom() != null)
                      {%>
                        <%= adherent.getPrenom()%>
                        <% } %>
                    </td>
          
                    <td>
                        <% if (adherent.getEmail()!= null)
                      {%>
                        <%= adherent.getEmail() %>
                        <% } %>
                    </td>
                     <td>
                        <% if (adherent.getTelephone()!= null)
                      {%>
                        <%= adherent.getTelephone() %>
                        <% } %>
                    </td>
                    <td>
                        <% if (adherent.getAdresse()!= null)
                      {%>
                        <%= adherent.getAdresse() %>
                        <% } %>
                    </td>
                    <td>
                        <% if (adherent.getCodePostal()!= null)
                      {%>
                      <%= adherent.getCodePostal()%>
                        <% } %>
                    </td>
                    <td>
                        <% if (adherent.getVille()!= null)
                      {%>
                        <%= adherent.getVille()%>
                        <% } %>
                    </td>
                </tr>
               
                <%
                    }
                %>
                
                
            </tbody>
        </table> 
            <p>
            <a name="choixAction"  href="ServletControleur?idEcran=22">Retour au menu cours</a>
        </p>
    </div>
    </body>
</html>
