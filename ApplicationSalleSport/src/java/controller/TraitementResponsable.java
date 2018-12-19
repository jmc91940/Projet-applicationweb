/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import divers.Colonne;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jdbc.AccesBase;
import jdbc.BaseDeDonnees;
import tables.Adherent;
import tables.*;


/**
 *
 * @author User
 */
public class TraitementResponsable
{
        private BaseDeDonnees base;
        
        
       
    TraitementResponsable(BaseDeDonnees base) 
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
              listeCours = coursDAO.lireListeResponsableCours();
                
               listeColonnes = coursDAO.getListeColonnes();
                
            

                jspRetour = "/jspResponsableCours.jsp";
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
            /*   session.setAttribute("numeroContact", "");
            session.setAttribute("choixAction", "Cours");*/
        }
        return jspRetour;
    }
    
    public String traitementModifCours(HttpServletRequest request)
    {
        String jspRetour;

        Cours cours;
        String nomCours;
        Vector<Salle> vSalle;
         Vector<Coach> vCoach;

        HttpSession session = request.getSession();

        AccesBase accesBase;
        CoursDAO coursDAO;
        SalleDAO salleDAO;
        CoachDAO coachDAO;

        nomCours = request.getParameter("nomCours");

        accesBase = new AccesBase(base);

        try
        {
            accesBase.getConnection();
            coursDAO = new CoursDAO(accesBase);
            salleDAO = new SalleDAO(accesBase);
            coachDAO = new CoachDAO(accesBase);

            try
            {
              
                cours = new Cours();
                cours.setLibelle(nomCours);
                coursDAO.lire(cours);

                vSalle = salleDAO.lireListe();
                vCoach = coachDAO.lireListe();

                jspRetour = "/jspResponsableCoursModify.jsp";
                session.setAttribute("message", "");
                session.setAttribute("cours", cours);
                session.setAttribute("vSalle", vSalle);
                session.setAttribute("vCoach", vCoach);
            }
           
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/jspResponsableCoursModifier.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("nomCours", nomCours);
            session.setAttribute("choixAction", "modification");
        }

        return jspRetour;
    }
    public String traitementListeAdherent(HttpServletRequest request)
    {
        String jspRetour;
        
  
        Vector<Adherent> listeAdherent;
        Vector<Colonne> listeColonnes;
        
        HttpSession session = request.getSession();
        
        AccesBase accesBase;
        AdherentDAO adherentDAO;
       
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
        adherentDAO = new AdherentDAO(accesBase);
         

            try
            {
              listeAdherent = adherentDAO.lireListe();
                
               listeColonnes = adherentDAO.getListeColonnes();
                
            

                jspRetour = "/jspResponsableAdherent.jsp";
                session.setAttribute("listeAdherent", listeAdherent);
             
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
            /*   session.setAttribute("numeroContact", "");
            session.setAttribute("choixAction", "Cours");*/
        }
        return jspRetour;
    }
//      public String traitementListeAdherents(HttpServletRequest request)
//    {
//        String jspRetour;
//        
//  
//       Adherent adherent;
//        
//        HttpSession session = request.getSession();
//        
//        AccesBase accesBase;
//        AdherentDAO adherentDAO;
//       
//// --------------------------------------------------------------------------
//// L'objet CoursDAO est une variable locale de la methode. Elle est creee a
//// chaque appel (et liberee a la fin). Il s'agit d'eviter le melange de
//// donnees entre plusieurs utilisateurs. En effet, la ServletControleur est
//// instanciée une fois. La classe TraitementAccueil une fois également. Si
//// l'objet CoursDAO etait declare en propriete de la classe
//// TraitementAccueil, elle serait commune a tous les utilisateurs. Or, un
//// objet CoursDAO contient une propriete de type JeuResultat qui est
//// modifiee a chaque lecture dans la base.
//// --------------------------------------------------------------------------
//        accesBase = new AccesBase(base);
//        try
//        {
//            accesBase.getConnection();
//        adherentDAO = new AdherentDAO(accesBase);
//         
//
//            try
//            {
//             
//                adherent = new Adherent();
//            
//
//                jspRetour = "/jspResponsableAdherentAjouter.jsp";
//                session.setAttribute("adherent", adherent);
//             
//           
//            
//            }
//            finally
//            {
//                accesBase.closeConnection();
//            }
//        }
//        catch (SQLException e)
//        {
//            
//            jspRetour = "/jspErreur.jsp";
//            /*   session.setAttribute("numeroContact", "");
//            session.setAttribute("choixAction", "Cours");*/
//        }
//        return jspRetour;
//    }

    public String traitementModifAdherent(HttpServletRequest request)
    {
        String jspRetour;

        Adherent adherent;
        String nomAdherent;
        String prenomAdherent;
        

        HttpSession session = request.getSession();

        AccesBase accesBase;
        AdherentDAO adherentDAO;
        // SalleDAO salleDAO;
        //CoachDAO coachDAO;

        nomAdherent = request.getParameter("nomAdherent");
        prenomAdherent = request.getParameter("prenomAdherent");

        accesBase = new AccesBase(base);

        try
        {
            accesBase.getConnection();
            adherentDAO = new AdherentDAO(accesBase);
           // salleDAO = new SalleDAO(accesBase);
            //coachDAO = new CoachDAO(accesBase);

            try
            {
              
                adherent = new Adherent();
                adherent.setNom(nomAdherent);
                adherent.setPrenom(prenomAdherent);
                adherentDAO.lire(adherent);

//                vSalle = salleDAO.lireListe();
//                vCoach = coachDAO.lireListe();

                jspRetour = "/jspResponsableAdherentModify.jsp";
                session.setAttribute("message", "Les champs précédés d'une * sont obligatoires");
                session.setAttribute("adherent", adherent);

            }
           
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/jspResponsableAdherentModifier.jsp";
            session.setAttribute("message", e.getMessage());
            session.setAttribute("nomAdherent", nomAdherent);
            session.setAttribute("choixAction", "modification");
        }

        return jspRetour;
   }
}