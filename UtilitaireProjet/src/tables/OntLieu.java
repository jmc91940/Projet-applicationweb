/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.sql.Time;
import java.util.Vector;

/**
 *
 * @author User
 */
public class OntLieu implements java.io.Serializable
{
    // ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------

    private Integer idCours;             //clef primaire,etrangere
    private Integer idJour;             //clef primaire,etrangere
  
    
    private Time heure;
  

// --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------
   
    private Cours cours;
    private Jour jour;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public OntLieu()
    {
    }

// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
    public void setIdCours(Integer idCours)
    {
        this.idCours = idCours;
    }

    public void setIdJour (Integer idJour)
    {
        this.idJour = idJour;
    }


    public void setHeure (Time heure)
    {
        this.heure = heure;
    }
    public void setCours(Cours cours)
    {
        this.cours = cours;
    }
    
    
    public void setJour(Jour jour)
    {
      this.jour = jour;  
    }
// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getIdCours()
    {
        return idCours;
    }

    public Integer getIdJour()
    {
        return idJour;
    }

    
    
    public Time getHeure()
    {
        return heure;
    }

    public Cours getCours()
    {
        return cours;
    }
    

    
    public Jour getJour()
    {
        return jour;
    }
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "idCours              : " + idCours+ "\n";
        retour = "idJour              : " + idJour+ "\n";
        retour += "heure                : " + heure + "\n";

        return retour;
    }
}


