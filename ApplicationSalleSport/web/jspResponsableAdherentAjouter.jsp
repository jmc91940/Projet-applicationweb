<%@page contentType="text/html" pageEncoding="utf-8"%>
<%@page import="java.util.Vector, divers.*, tables.*" %>

<!DOCTYPE html>

<% 
    String message = (String) session.getAttribute("message");
    String valueInput ="";  
 
%>

<html>
    <head>
        <title>Création d'un adherent</title>
        <meta http-equiv="Content-Type"
              content="text/html; charset=utf-8" />
        <link rel="stylesheet" 
              type="text/css"
              href="miseEnPage.css" />
    </head>

    <body>
        <div>  <jsp:include page="jspBandeauResponsableAdherent.jsp"/> </div>
        <div id="imageResponsable">
        <form action="ServletControleur?idEcran=8" method="post">
            <fieldset>
                <legend style="background-color: #DDFFFF">
                    Création d'un adherent
                </legend>

                <div class="divSaisieModif">
                   
                    <label for="nom">Nom *:</label>
                    <input type="text"
                           required
                           name="nom" 
                           value="<%=valueInput%>" 
                           size="20" 
                           maxlength="20" 
                           id="nom" />
                </div>

                <div class="divSaisieModif">
                   
                    <label for="prenom">prenom *:</label>
                    <input type="text" 
                           required
                           name="prenom" 
                           value="<%=valueInput%>"
                           size="30" 
                           maxlength="30" 
                           id="prenom" />                
                </div>
                <div class="divSaisieModif">
                    
                    <label for="email">email :</label>
                    <input type="email" 
                           name="email" 
                           value="<%=valueInput%>"
                           size="30" 
                           maxlength="30" 
                           id="email" />                
                </div>
                           
                    <div class="divSaisieModif">
                    
                    <label for="telephone">telephone :</label>
                    <input type="text" 
                           name="telephone" 
                           value="<%=valueInput%>"
                           size="30" 
                           maxlength="30" 
                           id="telephone" />                
                </div>
                           <div class="divSaisieModif">
                   
                    <label for="adresse">adresse *:</label>
                    <input type="text"
                           required
                           name="adresse" 
                           value="<%=valueInput%>"
                           size="30" 
                           maxlength="30" 
                           id="adresse" />                
                </div>

                    <div class="divSaisieModif">
                   
                    <label for="codePostal">code postale *:</label>
                    <input type="text" 
                           required
                           name="codePostal" 
                           value="<%=valueInput%>"
                           size="30" 
                           maxlength="30" 
                           id="codePostal" />                
                </div>
                  <div class="divSaisieModif">
                   
                    <label for="ville">ville *:</label>
                    <input type="text"
                           required
                           name="ville" 
                           value="<%=valueInput%>"
                           size="30" 
                           maxlength="30" 
                           id="ville" />                
                </div>
                        
                           <p >les champs précédés d'une * sont obligatoires</p>

                           <p><%=message%></p>
  
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
            
            
        </div>
                        </div>
    </body>
</html>
