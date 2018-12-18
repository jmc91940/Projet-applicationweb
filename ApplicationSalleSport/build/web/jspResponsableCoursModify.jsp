<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="java.util.Vector, divers.*, tables.*" %>

<!DOCTYPE html>

<% Cours cours = (Cours) session.getAttribute("cours");
    Vector<Salle> vSalle = (Vector<Salle>) session.getAttribute("vSalle");
    Vector<Coach> vCoach = (Vector<Coach>) session.getAttribute("vCoach");
    String message = (String) session.getAttribute("message");
    String valueInput;
    Integer valueInputInt;
    
 
%>

<html>
    <head>
        <title  >Modification d'un cours</title>
        <meta http-equiv="Content-Type"
              content="text/html; charset=utf-8" />
        <link rel="stylesheet" 
              type="text/css"
              href="miseEnPage.css" />
    </head>

    <body>
        <div>  <jsp:include page="jspBandeauResponsableCours.jsp"/> </div>
        <div id="imageResponsable">
        <form action="ServletControleur?idEcran=9" method="post">
            <fieldset>
                <legend style="color:orange">
                    Modification du cours <%= cours.getLibelle()%>
                </legend>

                <div class="divSaisieModif">
                    <% valueInput = "";
                        if (cours.getLibelle()!= null)
                        {
                            valueInput = cours.getLibelle();
                        }
                    %>
                    <label for="nom">Nom :</label>
                    <input type="text" 
                           name="nom" 
                           value="<%=valueInput%>" 
                           size="20" 
                           maxlength="20" 
                           id="nom" />
                </div>

                <div class="divSaisieModif">
                    <% valueInputInt = 0;
                        if (cours.getDuree()!= null)
                        {
                            valueInputInt = cours.getDuree();
                        }
                    %>
                    <label for="duree">Duree :</label>
                    <input type="text" 
                           name="duree" 
                           value="<%=valueInputInt%>"
                           size="3" 
                           maxlength="4" 
                           id="duree" />                
                </div>

               
                

                <div class="divSaisieModif">
                    <label for="coach">Identifiant Coach :</label>
                    <select name="coach" id="coach">
                    <%  if (cours.getIdCoach()== null)
                        {
                    %>
                        <option selected="selected"></option>
                        <%
                            for (int i = 0; i < vCoach.size(); i++)
                            {
                        %>
                        <option><%= vCoach.get(i).getId()%></option>
                        <%
                            }
                        }
                        else
                        {
                        %>
                        <option></option>
                        <%
                            for (int i = 0; i < vCoach.size(); i++)
                            {
                                if(cours.getIdCoach().
                                        compareTo(vCoach.get(i).getId()) == 0)
                                {
                        %>
                        <option selected="selected">
                            <%= vCoach.get(i).getId()%>
                        </option>
                        <%
                                }
                                else
                                {
                        %>
                        <option><%= vCoach.get(i).getId()%></option>
                        <%
                                }
                            }
                        }
                        %>
                    </select>
                    
                    <div class="divSaisieModif">
                    <label for="salle">Identifiant Salle :</label>
                    <select name="salle" id="salle">
                     
                    <%  if (cours.getIdSalle()== null)
                        {
                    %>
                        <option selected="selected"></option>
                        <%
                            for (int i = 0; i < vSalle.size(); i++)
                            {
                        %>
                        <option><%= vSalle.get(i).getId()%></option>
                        <%
                            }
                        }
                        else
                        {
                        %>
                        <option></option>
                        <%
                            for (int i = 0; i < vSalle.size(); i++)
                            {
                                if(cours.getIdSalle().
                                        compareTo(vSalle.get(i).getId()) == 0)
                                {
                        %>
                        <option selected="selected">
                            <%= vSalle.get(i).getId()%>
                        </option>
                        <%
                                }
                                else
                                {
                        %>
                        <option><%= vSalle.get(i).getId()%></option>
                        <%
                                }
                            }
                        }
                        %>
                    </select>
                    
                </div>
            </fieldset>

            <div>
                <input type="submit" 
                       class="envoyer" 
                       name="choixAction" 
                       value="Enregistrer"/>
                <input type="submit" 
                       class="envoyer" 
                       name="choixAction" 
                       value="Annuler"/>
            </div>
        </form>


        <div>
            <br />
            <br />
            <br />
            <p id=message><%=message%></p>
        </div>
                        </div>
    </body>
</html>
