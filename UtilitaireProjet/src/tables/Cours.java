/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.sql.Time;
import java.util.*;

/**
 *
 * @author User
 */
public class Cours implements java.io.Serializable
{
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer id;             // Clef primaire
    private String libelle;
    private Integer duree;
    
  
    private Integer idCoach;        // Clef etrangere vers Coach
    private Integer idSalle;         // Clef etrangere vers Salle  

// --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------
    private Salle salle;
    private Coach coach;  
    private Vector<Consulte> listeConsulte;
    private Vector<OntLieu> listeOntLieu;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// --------------------------------------------------------------------------
     public Cours()
    {
     
    }
     
/// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
    public void setId(Integer idCours)
    {
        this.id = idCours;
    }

    public void setLibelle(String libelle)
    {
        this.libelle = libelle;
    }

    public void setDuree(Integer duree)
    {
        this.duree = duree;
    }


    public void setIdCoach(Integer idCoach)
    {
        this.idCoach = idCoach;
    }

    public void setIdSalle(Integer idSalle) {
        this.idSalle = idSalle;
    }
    
    
    public void setSalle(Salle salle)
    {
        this.salle = salle;

    }

    public void setCoach(Coach coach)
    {
        this.coach = coach;

    }

    public void setListeInscrit(Vector<Consulte> listeInscrit)
    {
        this.listeConsulte = listeInscrit;
    }
public void setListeLieu(Vector<OntLieu> listeLieu)
{
    this.listeOntLieu = listeLieu;
}
// --------------------------------------------------------------------------
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

    public Integer getDuree()
    {
        return duree;
    }

    public Integer getIdCoach()
    {
        return idCoach;
    }

    public Integer getIdSalle() {
        return idSalle;
    }
    
    
  public Salle getSalle()
    {
        return salle;
    }
  
    public Coach getCoach()
    {
        return coach;
    }

    public Vector<Consulte> getListeInscrit()
    {
        return listeConsulte;
    }
    
    public Vector<OntLieu> getListeLieu()
    {
        return listeOntLieu;
    }
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "Numero              : " + id+ "\n";
        retour += "Libelle                : " + libelle + "\n";
        retour += "Duree            : " + duree + "\n";
        retour += "idCoach        : " + idCoach + "\n";
        retour += "idSalle          :"+ idSalle ;
       

        return retour;
    }
  
}


