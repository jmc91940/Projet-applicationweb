  <%-- 
    Document   : loginprocess
    Created on : 24 nov. 2018, 19:42:02
    Author     : User
--%>
<%@page import="dao.AdherentDAO"%>

<jsp:useBean id="adherent" scope="session" class="tables.Adherent"/>

<jsp:setProperty property="login" name="adherent"/>
<jsp:setProperty property="motDePasse" name="adherent"/>

 

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    boolean status = AdherentDAO.validate(adherent);
          if(status){
              //String redirectURL = "/jspAccueil.jsp";
        
            //response.sendRedirect(redirectURL);
            %>
     <jsp:include page="/ServletControleur?idEcran=0"></jsp:include> 
       <%      
          session.setAttribute("session","TRUE");
          }
          else
          {
              out.println("ERROR");
          
    %>

<jsp:include page="jspErreur.jsp"></jsp:include>  
<%  
}  
%>  