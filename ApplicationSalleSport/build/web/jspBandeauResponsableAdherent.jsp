<%-- 
    Document   : jspBandeauResponsableCours
    Created on : 9 déc. 2018, 19:23:01
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="miseEnPage.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <div id="bandeau">
            <ul>
                <li>   <img src="images/Capture.PNG" width="250" height="100" alt=""/></li>
                <li> <a name ="choixAction" href="ServletControleur?idEcran=7&choixAction=ResponsableAdherentAjouter">Ajouter</a></li>
                <li> <a name ="choixAction" href="ServletControleur?idEcran=7&choixAction=ResponsableAdherentModifier">Modifier</a></li>
                <li> <a name ="choixAction" href="">Supprimer</a></li>
                
            </ul>
        </div>
    </body>
</html>
