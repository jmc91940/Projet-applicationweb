/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import dao.CoursDAO;
import dao.EvenementDAO;
import dao.LoginDAO;
import dao.OntLieuDAO;

import divers.Colonne;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jdbc.AccesBase;
import jdbc.BaseDeDonnees;
import tables.Coach;
import tables.Cours;
import tables.Evenement;
import tables.Jour;
import tables.Login;
import tables.OntLieu;



/**
 *
 * @author User
 */
public class TraitementAccueil 
{
        private BaseDeDonnees base;
        
        
       
    TraitementAccueil(BaseDeDonnees base) 
    {
        this.base = base;
    }
    // --------------------------------------------------------------------------
// Traitement d'affichage des listes
// --------------------------------------------------------------------------
    public String traitementListeCours(HttpServletRequest request)
    {
        String jspRetour;
        
  
        Vector<Cours> listeCours;
        Vector<Colonne> listeColonnes;
        
        HttpSession session = request.getSession();
        
        AccesBase accesBase;
        CoursDAO coursDAO;
       
// --------------------------------------------------------------------------
// L'objet CoursDAO est une variable locale de la methode. Elle est creee a
// chaque appel (et liberee a la fin). Il s'agit d'eviter le melange de
// donnees entre plusieurs utilisateurs. En effet, la ServletControleur est
// instanciée une fois. La classe TraitementAccueil une fois également. Si
// l'objet CoursDAO etait declare en propriete de la classe
// TraitementAccueil, elle serait commune a tous les utilisateurs. Or, un
// objet CoursDAO contient une propriete de type JeuResultat qui est
// modifiee a chaque lecture dans la base.
// --------------------------------------------------------------------------
        accesBase = new AccesBase(base);
        try
        {
            accesBase.getConnection();
        coursDAO = new CoursDAO(accesBase);
         

            try
            {
              listeCours = coursDAO.lireListe();
                
               listeColonnes = coursDAO.getListeColonnes();
                
            

                jspRetour = "/jspCours.jsp";
                session.setAttribute("listeCours", listeCours);
             
               session.setAttribute("listeColonnes", listeColonnes);
            
            }
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            
            jspRetour = "/jspErreur.jsp";
            session.setAttribute("numeroContact", "");
            session.setAttribute("choixAction", "Cours");
        }
        return jspRetour;
    }
    
    
    public String traitementListeEvenement(HttpServletRequest request)
    {
        String jspRetour;
        
        Vector<Evenement> listeEvenement;
        Vector<Colonne> listeColonnes;
        HttpSession session = request.getSession();
        
        AccesBase accesBase;
        EvenementDAO evenementDAO;


        accesBase = new AccesBase(base);
        try
        {
            accesBase.getConnection();
            evenementDAO = new EvenementDAO(accesBase);

            try
            {
                listeEvenement= evenementDAO.lireListe();
                listeColonnes = evenementDAO.getListeColonnes();

                jspRetour = "/jspEvenement.jsp";
                session.setAttribute("listeEvenement", listeEvenement);
                session.setAttribute("listeColonnes", listeColonnes);
            }
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            
            jspRetour = "/jspErreur.jsp";
            session.setAttribute("numeroContact", "");

            session.setAttribute("choixAction", "Evenement");
        }
        return jspRetour;
    }
  
    
public String traitementLogin(HttpServletRequest request)
    {
        String jspRetour = null;
        String identifiant; 
        String motDePasse;
        
        HttpSession session = request.getSession();

        AccesBase accesBase;
        LoginDAO loginDAO;

        identifiant= request.getParameter("identifiant");
        motDePasse = request.getParameter("motDePasse");
        Login login;
        
         login = new Login();
         login.setIdentifiant(identifiant);
         login.setMotDePasse(motDePasse);
        accesBase = new AccesBase(base);

        try
        {
            accesBase.getConnection();
            loginDAO = new LoginDAO(accesBase);
            
            try
            {
        
       boolean status = loginDAO.validate(login);
                
          if(status)
                 {
            
                jspRetour = "/jspResponsable.jsp";
      
                 }
          else
          {
              jspRetour="/jspErreur.jsp";
          }
            }
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/jspErreur.jsp";
            session.setAttribute("message", e.getMessage());
            //session.setAttribute("numeroContact", chaineNumeroContact);
            //  session.setAttribute("choixAction", "modification");
        }

        return jspRetour;
    }


    
public String traitementPlanning(HttpServletRequest request)
    {
        String jspRetour;
        String libelleJour;  
        Vector<Colonne> listeColonnes;   
        Vector<OntLieu> listeOntLieu;
        HttpSession session = request.getSession();

        AccesBase accesBase;
        OntLieuDAO ontLieuDAO;

        libelleJour = request.getParameter("libelleJour");
        Jour jour;
        
        accesBase = new AccesBase(base);

        try
        {
            accesBase.getConnection();
            ontLieuDAO = new OntLieuDAO(accesBase);
            try
            {
               
                
                jour = new Jour();
                jour.setLibelle(libelleJour);
                listeOntLieu = ontLieuDAO.lireListe(jour);
            
                listeColonnes = ontLieuDAO.getListeColonnes();

                

                jspRetour = "/jspCours2.jsp";
             
                //session.setAttribute("libelleJour", libelleJour);
                session.setAttribute("listeOntLieu", listeOntLieu);
                session.setAttribute("listeColonnes", listeColonnes);
               
            }
            
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/jspErreur.jsp";
            session.setAttribute("message", e.getMessage());
            //session.setAttribute("numeroContact", chaineNumeroContact);
            //  session.setAttribute("choixAction", "modification");
        }

        return jspRetour;
    }
}
