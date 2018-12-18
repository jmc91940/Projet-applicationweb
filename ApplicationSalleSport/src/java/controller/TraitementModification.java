/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.*;
import java.sql.SQLException;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import jdbc.BaseDeDonnees;
import tables.*;
import javax.servlet.http.HttpSession;
import jdbc.AccesBase;

/**
 *
 * @author User
 */




public class TraitementModification
{
    private BaseDeDonnees base;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public TraitementModification(BaseDeDonnees base)
    {
        this.base = base;
    }

// --------------------------------------------------------------------------
// Traitement d’annulation de la modification
// --------------------------------------------------------------------------
    public String annulationModifCours(HttpServletRequest request)
    {
        String jspRetour;

        Cours cours;
        HttpSession session = request.getSession();

        cours = (Cours) session.getAttribute("cours");

        jspRetour = "/jspAccueil.jsp";
        session.setAttribute("message", "Modification annulée");
        session.setAttribute("nomCours", cours.getLibelle().toString());
        session.setAttribute("choixAction", "modification");

        return jspRetour;
    }

// --------------------------------------------------------------------------
// Enregistrement de la modification et affichage de l'ecran de confirmation
// de la modification
// --------------------------------------------------------------------------
    public String enregModifCours(HttpServletRequest request)
    {
        String jspRetour;

        Cours cours;
        Vector<Salle> vSalle;
        Vector<Coach> vCoach;

        HttpSession session = request.getSession();
        
        AccesBase accesBase;
        CoursDAO coursDAO;
        SalleDAO salleDAO;
        CoachDAO coachDAO;

        cours = (Cours) session.getAttribute("cours");
        vSalle = (Vector<Salle>) session.getAttribute("vSalle");
         vCoach = (Vector<Coach>) session.getAttribute("vCoach");

        String nom = request.getParameter("nom");
        nom = nom.trim();
        if (nom.compareTo("") == 0)
        {
            nom = null;
        }

        String stringDuree = request.getParameter("duree");
        Integer duree = null;
        if (stringDuree.compareTo("") != 0)
        {
            duree = new Integer(stringDuree);
        }
   
        String stringCoach = request.getParameter("coach");
        Integer coach = null;
        //Coach coach = null;
        if (stringCoach.compareTo("") != 0)
        {
            coach = new Integer(stringCoach);
        }
        
         String stringSalle = request.getParameter("salle");
        Integer salle = null;
        if (stringSalle.compareTo("") != 0)
        {
            salle= new Integer(stringSalle);
        }

// --------------------------------------------------------------------------
// Modification de l'objet contact
// --------------------------------------------------------------------------
        cours.setLibelle(nom);
        cours.setDuree(duree);
        cours.setIdCoach(coach);
      
        cours.setIdSalle(salle);
       

        accesBase = new AccesBase(base);

        try
        {
            accesBase.getConnection();
            coursDAO = new CoursDAO(accesBase);

            try
            {
                int retour = coursDAO.modifier(cours);
                if (retour != 0)
                {
                    jspRetour = "/jspRecapModifCours.jsp";
                    session.setAttribute("cours", cours);
                }
                else
                {
                    jspRetour = "/jspModif.jsp";
//                    session.setAttribute("message", "Le contact "
//                                         + contact.getNumero()
//                                         + " a été supprimé");
//                    session.setAttribute("contact", contact);
//                    session.setAttribute("vSect", vSect);
                }
            }
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/jspModif.jsp";
//            session.setAttribute("message", e.getMessage());
//            session.setAttribute("contact", contact);
//            session.setAttribute("vSect", vSect);
        }

        return jspRetour;
    }
    public String enregModifAdherent(HttpServletRequest request)
    {
        String jspRetour;

        Adherent adherent;
//        Vector<Salle> vSalle;
//        Vector<Coach> vCoach;

        HttpSession session = request.getSession();
        
        AccesBase accesBase;
        AdherentDAO adherentDAO;
//        SalleDAO salleDAO;
//        CoachDAO coachDAO;

        adherent = (Adherent) session.getAttribute("adherent");
//        vSalle = (Vector<Salle>) session.getAttribute("vSalle");
//         vCoach = (Vector<Coach>) session.getAttribute("vCoach");

        String nom = request.getParameter("nom");
        nom = nom.trim();
        if (nom.compareTo("") == 0)
        {
            nom = null;
        }
       String prenom = request.getParameter("prenom");
        prenom = prenom.trim();
        if (prenom.compareTo("") == 0)
        {
            prenom = null;
        }
         String email = request.getParameter("email");
        email = email.trim();
        if (email.compareTo("") == 0)
        {
            email = null;
        }
         String telephone = request.getParameter("telephone");
        telephone = telephone.trim();
        if (telephone.compareTo("") == 0)
        {
            telephone = null;
        }
         String adresse = request.getParameter("adresse");
        adresse = adresse.trim();
        if (adresse.compareTo("") == 0)
        {
            adresse = null;
        }
         String codePostal = request.getParameter("codePostal");
        codePostal = codePostal.trim();
        if (codePostal.compareTo("") == 0)
        {
            codePostal = null;
        }
       String ville = request.getParameter("ville");
        ville = ville.trim();
        if (ville.compareTo("") == 0)
        {
            ville = null;
        }
// --------------------------------------------------------------------------
// Modification de l'objet contact
// --------------------------------------------------------------------------
        adherent.setNom(nom);
        adherent.setPrenom(prenom);
        adherent.setEmail(email);
        adherent.setTelephone(telephone);
        adherent.setAdresse(adresse);
        adherent.setCodePostal(codePostal);
        adherent.setVille(ville);
       

        accesBase = new AccesBase(base);

        try
        {
            accesBase.getConnection();
            adherentDAO = new AdherentDAO(accesBase);

            try
            {
                int retour = adherentDAO.modifier(adherent);
                if (retour != 0)
                {
                    jspRetour = "/jspRecapModifAdherent.jsp";
                    session.setAttribute("adherent", adherent);
                }
                else
                {
                    jspRetour = "/jspModif.jsp";
//                    session.setAttribute("message", "Le contact "
//                                         + contact.getNumero()
//                                         + " a été supprimé");
//                    session.setAttribute("contact", contact);
//                    session.setAttribute("vSect", vSect);
                }
            }
            finally
            {
                accesBase.closeConnection();
            }
        }
        catch (SQLException e)
        {
            jspRetour = "/jspModif.jsp";
//            session.setAttribute("message", e.getMessage());
//            session.setAttribute("contact", contact);
//            session.setAttribute("vSect", vSect);
        }

        return jspRetour;
    }
}
