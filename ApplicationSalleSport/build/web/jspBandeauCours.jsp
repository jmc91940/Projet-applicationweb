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
            <ul>
                <li>   <img src="images/Capture.PNG" width="250" height="100" alt=""/></li>
                <li> <a name ="choixAction" href="ServletControleur?idEcran=2&choixAction=Planning">Planning</a></li>
                <li> <a name ="choixAction" href="ServletControleur?idEcran=2&choixAction=Description">Description</a></li>
            </ul>
        </div>
    </body>
</html>
