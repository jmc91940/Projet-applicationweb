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
        <form action="loginprocess.jsp" method="post">
            Login:<input type="text" name="login"/><br/><br/>
            Password<input type="password" name="motDePasse"/><br/><br/>
            <input type="submit" value="envoi"/>
        </form>
    </body>
</html>
