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
public class Participe implements java.io.Serializable
{
       // ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer idAdherent;             // Clef primaire,étrangère
    private Integer idEvenement;            //clef primaire,étrangère
  

// --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------
   
    private Evenement evenement;
    private Adherent adherent;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Participe()
    {
    }

// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
    public void setIdAdherent(Integer idAdherent)
    {
        this.idAdherent = idAdherent;
    }

    public void setIdEvenement(Integer idEvenement)
    {
        this.idEvenement = idEvenement;
    }

    public void setEvenement(Evenement evenement) {
        this.evenement = evenement;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }

  
// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getIdAdherent()
    {
        return idAdherent;
    }

    public Integer getIdEvenement()
    {
        return idEvenement;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public Adherent getAdherent() {
        return adherent;
    }

    
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "idAdherent              : " + idAdherent+ "\n";
        retour += "idEvenement                : " + idEvenement + "\n";

        return retour;
    }
}
