/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.util.Vector;

/**
 *
 * @author User
 */
public class Salle implements java.io.Serializable
{
       // ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer id;             // Clef primaire
    private String libelle;
  

// --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------
   
   
    private Vector<Cours> listeCours;
 

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Salle()
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

    public void setListeCours(Vector<Cours> listeCours) {
        this.listeCours = listeCours;
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

    public Vector<Cours> getListeCours() {
        return listeCours;
    }


 
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "idJour              : " + id+ "\n";
        retour += "libelle                : " + libelle + "\n";

        return retour;
    }
             
}
