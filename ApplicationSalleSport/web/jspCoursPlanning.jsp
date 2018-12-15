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
    String libelleJour =(String) session.getAttribute("libelleJour");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="miseEnPage.css" rel="stylesheet" type="text/css"/>
        <title>PLANNING</title>
    </head>
    <body>
            <div>  <jsp:include page="jspBandeauCours.jsp"/> </div>
            <div id="imageCours">

        <form action="ServletControleur?idEcran=3" method="post">
            <fieldset>
           <legend>Planning</legend>
           
            <div >
                        <label >Jour :</label>
                        <select name="libelleJour">
                            <option >Lundi</option>
                            <option>Mardi</option>
                            <option>Mercredi</option>
                            <option>Jeudi</option>
                            <option>Vendredi</option>
                         </select>
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
