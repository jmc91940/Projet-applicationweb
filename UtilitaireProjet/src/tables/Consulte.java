/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.util.*;

/**
 *
 * @author User
 */
public class Consulte implements java.io.Serializable
{
    // ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer idAdherent;             // Clef primaire
    private Integer idCours;
  

// --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------
   
    private Cours cours;
    private Adherent adherent;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Consulte()
    {
    }

// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
    public void setIdCours(Integer idCours)
    {
        this.idCours = idCours;
    }

    public void setIdAdherent(Integer idAdherent)
    {
        this.idAdherent = idAdherent;
    }

    public void setCours(Cours cours)
    {
        this.cours = cours;
    }
    
    public void setAdherent(Adherent adherent)
    {
    this.adherent = adherent;
    }
// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getIdCours()
    {
        return idCours;
    }

    public Integer getIdAdherent()
    {
        return idAdherent;
    }

    public Adherent getAdherent()
    {
        return adherent;
    }
    
    public Cours getCours()
    {
        return cours;
    }
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "idAdherent              : " + idAdherent+ "\n";
        retour += "idCours                : " + idCours + "\n";

        return retour;
    }
}

