<%-- 
    Document   : jspCoursPlanning
    Created on : 8 déc. 2018, 15:25:24
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Vector, divers.*, tables.*" %>
<!DOCTYPE html>
<%
    String choixAction =(String) session.getAttribute("choixAction");
    String nomCours =(String) session.getAttribute("nomCours");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="miseEnPage.css" rel="stylesheet" type="text/css"/>
        <title>MODIFIER</title>
    </head>
    <body>
            <div>  <jsp:include page="jspBandeauResponsableCours.jsp"/> </div>
            <div id="imageResponsable">

        <form action="ServletControleur?idEcran=6" method="post">
            <fieldset>
           <legend>Modifier</legend>
           
            <div >
                        <label >Nom du cours :</label>
                        <input type="text" 
                               name="nomCours"
                               value="<%=nomCours%>"
                               />
                            
                        
                    </div>
            </fieldset>     
            <div>
                <input 
                    type="submit"
                    class="envoyer"
                    name="choixAction"
                    value="Envoyer" />
            </div>
                               
        </form>
            </div>  
         <p>
            <a name="choixAction"  href="ServletControleur?idEcran=2&choixAction=Planning">Retour au planning</a>
        </p>
    </body>
</html>
