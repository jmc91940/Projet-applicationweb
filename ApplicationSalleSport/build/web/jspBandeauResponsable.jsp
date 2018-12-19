<%-- 
    Document   : jspBandeauResponsable
    Created on : 9 déc. 2018, 18:11:14
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="miseEnPage.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Responsable</title>
    </head>
    
    <body>
         <div id="bandeau">
             <div>
               <ul>
                <li>   <img src="images/Capture.PNG" width="250" height="100" alt=""/></li>
                <li> <a name ="choixAction" href="ServletControleur?idEcran=4&choixAction=ResponsableAdherent">Adhérent</a></li>
                <li> <a name ="choixAction" href="ServletControleur?idEcran=4&choixAction=ResponsableCours">Cours</a></li>
                <li> <a name ="choixAction" href="">Evènement</a></li>
                <li> <a name ="choixAction" href=" ">Coach</a></li>
                
              </ul>
                 
                 
         </div>
        </div>
    </body>
  
</html>
