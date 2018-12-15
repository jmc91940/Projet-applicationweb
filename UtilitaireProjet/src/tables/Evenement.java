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
public class Evenement implements java.io.Serializable
{
      // ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer id;             // Clef primaire
    private String libelle;
    private Date date;
  

// --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------
   
    private Vector<Participe> listeParticipation;
 

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Evenement()
    {
    }

// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public void setListeParticipation(Vector<Participe> listeParticipation)
    {
        this.listeParticipation = listeParticipation;
    }
//--------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getId()
    {
        return id;
    }

    public String getLibelle()
    {
        return libelle;
    }

    public Date getDate()
    {
        return date;
    }
    public Vector<Participe> getListeParticipation()
    {
        return listeParticipation;
    }
 
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;
        

        retour = "idEvenement              : " + id+ "\n";
        retour += "libelle                : " + libelle + "\n";
        retour += "date                     :" + date + "\n";

        return retour;
    }
              
}
