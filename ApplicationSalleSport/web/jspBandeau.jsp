<%-- 
    Document   : jspBandeau
    Created on : 11 nov. 2018, 16:10:11
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% 
    String choixAction = (String) session.getAttribute("choixAction");
%>
<html>
    <head>
        <link href="miseEnPage.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>

    <body>
        <div id="bandeau">
            <div>
            <ul>
                <li>  <img src="images/Capture.PNG" width="250em" height="100em" alt=""/> </li>
                <li > <a name= "choixAction" value = "Cours" href="ServletControleur?idEcran=1&choixAction=Cours">Cours</a></li>
                <li> <a  name= "choixAction" value = "Evenement" href="ServletControleur?idEcran=1&choixAction=Evenement">Evenements</a></li>
                <li> <a href="">Contact</a></li>
             <div id="connect">
                 <a href="">Login</a>
            </div>
             </ul>
           
            </div>  
            
                      
                        
                    
            
        </div>
    </body>
</html>
