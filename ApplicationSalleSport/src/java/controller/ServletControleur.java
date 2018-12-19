/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdbc.BaseDeDonnees;

/**
 *
 * @author User
 */
public class ServletControleur extends HttpServlet {

  private BaseDeDonnees base;
  private TraitementAccueil traitementAccueil;
  private TraitementResponsable traitementResponsable;
  private TraitementCreation traitementCreation;
  private TraitementModification traitementModification;
  
  @Override
    public void init()
    {
        try
        {
            Class.forName(getInitParameter("driverJDBCSqlServer"));
        }
        catch (ClassNotFoundException e)
        {
        }

        base = new BaseDeDonnees(getInitParameter("BDDSqlServer"));
        base.setFormatDate(getInitParameter("formatDateSqlServer"));

        traitementAccueil = new TraitementAccueil(base);
        traitementResponsable = new TraitementResponsable(base);
        traitementCreation = new TraitementCreation(base);
        traitementModification = new TraitementModification(base);
    }
  
  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
// --------------------------------------------------------------------------
// contexte   : ServletContext pour utiliser le dispatcher.
// dispatcher : pour acceder aux jsp d'affichage.
// --------------------------------------------------------------------------
        ServletContext contexte;
        RequestDispatcher dispatcher;

// --------------------------------------------------------------------------
// idEcran    : identifiant de l'ecran reçu.
// jsp        : jsp a afficher (retournee par les methodes de Traitement.
// choixAction : action choisie sur l'ecran .
// --------------------------------------------------------------------------
        Integer idEcran;
        String jsp = null;
        String choixAction;
        HttpSession session;

// --------------------------------------------------------------------------
// Indication du codage pour l'interpretation des caracteres recus par la
// requete.
// --------------------------------------------------------------------------
        request.setCharacterEncoding("UTF-8");

// --------------------------------------------------------------------------
// Recuperation du SerletContext pour dispatcher...
// --------------------------------------------------------------------------
        contexte = getServletContext();

// --------------------------------------------------------------------------
// Lecture de l'identifiant de l'ecran (champ cache ou parametre d'index.jsp)
// --------------------------------------------------------------------------
  
        
        String numeroEcran = request.getParameter("idEcran");
        idEcran = new Integer(numeroEcran);

// --------------------------------------------------------------------------
// Divers branchements suivant l'ecran qui vient d'appeler ServletControleur
// --------------------------------------------------------------------------
        switch (idEcran)
        {

// --------------------------------------------------------------------------
// On vient de l'ecran jspAccueil
// --------------------------------------------------------------------------
            case 1:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("Cours") == 0)
                {
                    jsp = traitementAccueil.traitementListeCours(request);
                }
                else
                {
                    if (choixAction.compareTo("Evenement") == 0)
                    {
                        jsp = traitementAccueil.traitementListeEvenement(request);
                    }
                    else
                    {
                        if (choixAction.compareTo("Login") == 0)
                    {
                        jsp = "/jspLogin.jsp";
                    }
                    else
                    {
                        jsp = "/jspAccueil.jsp";
                    }
                    }
                }
                break;

// --------------------------------------------------------------------------
// On vient de l'ecran cours
// --------------------------------------------------------------------------
                  case 2:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("Planning") == 0)
                {
                     jsp="/jspCoursPlanning.jsp";
                }
               else
                {
                    if (choixAction.compareTo("Description") == 0)
                    {
                        jsp = "/jspDescription.jsp";
                    }
                    else
                    {
                        jsp = "/jspAccueil.jsp";
                    }
                }
                break;
                
// --------------------------------------------------------------------------
// On vient de l'ecran PLANNING
// --------------------------------------------------------------------------
  
                  case 3:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("Envoyer") == 0)
                {
                    jsp = traitementAccueil.traitementPlanning(request);
             
                }
               else
                {
                  
                        jsp = "/jspAccueil.jsp";
                    
                }
                break;
// --------------------------------------------------------------------------
// On vient de l'ecran PLANNING
// --------------------------------------------------------------------------
  
                  case 4:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("ResponsableCours") == 0)
                {
                    jsp = traitementResponsable.traitementListeCours(request);
             
                }
               else
                {
                  
                       if (choixAction.compareTo("ResponsableAdherent") == 0)
                    {
                        jsp = traitementResponsable.traitementListeAdherent(request);
                    }
                    else
                    {
                        jsp = "/jspAccueil.jsp";
                    }
                    
                }
                break;
                
                case 5:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("ResponsableCoursAjouter") == 0)
                {
                    jsp = traitementResponsable.traitementListeCours(request);
             
                }
               else
                {
                    if (choixAction.compareTo("ResponsableCoursModifier") == 0)
                    {
                        jsp="/jspResponsableCoursModifier.jsp";
                    }
                    else
                    {
                        jsp = "/jspAccueil.jsp";
                    }
                }
                break;
                
                   case 6:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("Envoyer") == 0)
                {
                    jsp = traitementResponsable.traitementModifCours(request);
             
                }
               else
                {
                  
                        jsp = "/jspErreur.jsp";
                    
                }
                break;
                
                case 7:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("ResponsableAdherentAjouter") == 0)
                {
                    jsp = "/jspResponsableAdherentAjouter.jsp";
             
                }
               else
                {
                    if (choixAction.compareTo("ResponsableAdherentModifier") == 0)
                    {
                        jsp="/jspResponsableAdherentModifier.jsp";
                    }
                    else
                    {
                        jsp = "/jspAccueil.jsp";
                    }
                }
                break;
                
                 case 8:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("Enregistrer") == 0)
                {
                    jsp = traitementCreation.enregCreationAdherent(request);
                    //jsp = traitementCreation.annulationAjout(request);
                }
                else
                {
                    jsp = "/jspErreur.jsp";
                }
                break;
                
                case 9:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("Enregistrer") == 0)
                {
                    jsp = traitementModification.enregModifCours(request);
                    //jsp = traitementCreation.annulationAjout(request);
                }
                else
                {
                    jsp = "/jspErreur.jsp";
                }
                break;
                
                case 10:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("Envoyer") == 0)
                {
                    jsp = traitementResponsable.traitementModifAdherent(request);
             
                }
               else
                {
                  
                        jsp = "/jspErreur.jsp";
                    
                }
                
                break;
                
                case 11:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("Enregistrer") == 0)
                {
                    jsp = traitementModification.enregModifAdherent(request);
                    //jsp = traitementCreation.annulationAjout(request);
                }
                else
                {
                    jsp = "/jspErreur.jsp";
                }
                break;
                
                 case 12:
                choixAction = request.getParameter("choixAction");

                if (choixAction.compareTo("Login") == 0)
                {
                    jsp = traitementAccueil.traitementLogin(request);
                    
                }
                else
                {
                    jsp = "/jspErreur.jsp";
                }
                break;
                
                
                 default:
                session = request.getSession();
                session.setAttribute("message", "");
                session.setAttribute("libelleJour", " ");
                session.setAttribute("choixAction", " ");
                session.setAttribute("nomCours"," ");
                jsp = "/jspAccueil.jsp";
        }

        dispatcher = contexte.getRequestDispatcher(jsp);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
               
	}
   

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
         processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
