<%-- 
    Document   : jspLogin
    Created on : 24 nov. 2018, 19:17:40
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="ServletControleur?idEcran=12" method="post">
           <fieldset>
            Identifiant:<input type="text" name="identifiant"/><br/><br/>
            Password:<input type="password" name="motDePasse"/><br/><br/>
            <input type="submit" name="choixAction" value="Login"/>
        </fieldset>  
        </form>
    </body>
</html>
