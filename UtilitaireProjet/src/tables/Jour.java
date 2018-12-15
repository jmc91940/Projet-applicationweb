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
public class Jour implements java.io.Serializable
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
   
    private Vector<OntLieu> listeOntLieu;
 

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
    public Jour()
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

    public void setListeOntLieu(Vector<OntLieu> listeOntLieu)
    {
        this.listeOntLieu = listeOntLieu;
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

    public Vector<OntLieu> getListeOntLieu()
    {
        return listeOntLieu;
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
