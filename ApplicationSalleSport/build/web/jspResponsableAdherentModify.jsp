<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="java.util.Vector, divers.*, tables.*" %>

<!DOCTYPE html>

<% Adherent adherent = (Adherent) session.getAttribute("adherent");
    String message = (String) session.getAttribute("message");
    String valueInput;

    
 
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
        <form action="ServletControleur?idEcran=11" method="post">
            <fieldset>
                <legend style="color:orange">
                    Modification de l'adherent <%= adherent.getNom()%>  <%=adherent.getPrenom()%>
                </legend>

                <div class="divSaisieModif">
                    <% valueInput = "";
                        if (adherent.getNom()!= null)
                        {
                            valueInput = adherent.getNom();
                        }
                    %>
                    <label for="nom">Nom *:</label>
                    <input type="text" 
                           name="nom" 
                           value="<%=valueInput%>" 
                           size="20" 
                           maxlength="20" 
                           id="nom" />
                </div>
                           
                    <div class="divSaisieModif">
                    <% valueInput = "";
                        if (adherent.getPrenom()!= null)
                        {
                            valueInput = adherent.getPrenom();
                        }
                    %>
                    <label for="prenom">Prénom *:</label>
                    <input type="text" 
                           name="prenom" 
                           value="<%=valueInput%>" 
                           size="20" 
                           maxlength="20" 
                           id="prenom" />
                </div>
                  <div class="divSaisieModif">
                    <% valueInput = "";
                        if (adherent.getEmail()!= null)
                        {
                            valueInput = adherent.getEmail();
                        }
                    %>
                    <label for="email">Email :</label>
                    <input type="text" 
                           name="email" 
                           value="<%=valueInput%>" 
                           size="20" 
                           maxlength="20" 
                           id="email" />
                </div>
                           <div class="divSaisieModif">
                    <% valueInput = "";
                        if (adherent.getTelephone()!= null)
                        {
                            valueInput = adherent.getTelephone();
                        }
                    %>
                    <label for="telephone">Telephone :</label>
                    <input type="text" 
                           name="telephone" 
                           value="<%=valueInput%>" 
                           size="20" 
                           maxlength="20" 
                           id="telephone" />
                </div>
                           
                           <div class="divSaisieModif">
                    <% valueInput = "";
                        if (adherent.getAdresse()!= null)
                        {
                            valueInput = adherent.getAdresse();
                        }
                    %>
                    <label for="adresse">Adresse *:</label>
                    <input type="text" 
                           name="adresse" 
                           value="<%=valueInput%>" 
                           size="20" 
                           maxlength="20" 
                           id="adresse" />
                </div>
                           
               <div class="divSaisieModif">
                    <% valueInput = "";
                        if (adherent.getVille()!= null)
                        {
                            valueInput = adherent.getVille();
                        }
                    %>
                    <label for="ville">Ville *:</label>
                    <input type="text" 
                           name="ville" 
                           value="<%=valueInput%>" 
                           size="20" 
                           maxlength="20" 
                           id="ville" />
                </div>
                           <div class="divSaisieModif">
                    <% valueInput = "";
                        if (adherent.getCodePostal()!= null)
                        {
                            valueInput = adherent.getCodePostal();
                        }
                    %>
                    <label for="codePostal">Code Postale *:</label>
                    <input type="text" 
                           name="codePostal" 
                           value="<%=valueInput%>" 
                           size="20" 
                           maxlength="20" 
                           id="codePostal" />
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
