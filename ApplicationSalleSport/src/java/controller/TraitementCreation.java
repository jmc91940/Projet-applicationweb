/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdherentDAO;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jdbc.AccesBase;
import jdbc.BaseDeDonnees;
import tables.Adherent;

/**
 *
 * @author User
 */




public class TraitementCreation
{
    private BaseDeDonnees base;

// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public TraitementCreation(BaseDeDonnees base)
    {
        this.base = base;
    }

// --------------------------------------------------------------------------
// Traitement d’annulation de la modification
// --------------------------------------------------------------------------
    public String annulationAjout(HttpServletRequest request)
    {
        String jspRetour;

        Adherent adherent;
        HttpSession session = request.getSession();

        adherent = (Adherent) session.getAttribute("adherent");

        jspRetour = "/jspAdherent.jsp";
        session.setAttribute("message", "Création annulée");
        session.setAttribute("choixAction", "modification");

        return jspRetour;
    }

// --------------------------------------------------------------------------
// Enregistrement de la modification et affichage de l'ecran de confirmation
// de la modification
// --------------------------------------------------------------------------
    public String enregCreationAdherent(HttpServletRequest request)
    {
        String jspRetour;

        Adherent adherent;
    adherent   =new Adherent();
        
        HttpSession session = request.getSession();
        
        AccesBase accesBase;
        AdherentDAO adherentDAO;

       

        String nom = request.getParameter("nom");
        nom = nom.trim();

        String prenom = request.getParameter("prenom");
        prenom = prenom.trim();

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

        String codePostal = request.getParameter("codePostal");
        codePostal = codePostal.trim();

        String ville = request.getParameter("ville");
        ville = ville.trim();
  

// --------------------------------------------------------------------------
// Modification de l'objet adherent
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
                int retour = adherentDAO.creer(adherent);
                if (retour == 1)
                {
                    jspRetour = "/jspRecapCreationAdherent.jsp";
                    session.setAttribute("adherent", adherent);
                            
                    
                }
                else
                {
                    jspRetour = "/jspResponsableAdherentAjouter.jsp";
                    session.setAttribute("adherent", adherent );
                    session.setAttribute("message", "!!Attention adhérent déjà existant" );
                    
                                         
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
            session.setAttribute("message", e.getMessage());
            session.setAttribute("adherent", adherent);
    
        }

        return jspRetour;
    }
}

