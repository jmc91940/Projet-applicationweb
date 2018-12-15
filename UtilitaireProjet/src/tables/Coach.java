/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

/**
 *
 * @author User
 */
import java.util.*;

public class Coach implements java.io.Serializable
{
       
// ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer id;             // Clef primaire
    private String nom;
    private String prenom;
    private String email;

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
    public Coach()
    {
    }

// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------
    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setNom(String nom)
    {
        this.nom = nom;
    }

    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setListeCours(Vector<Cours> listeCours)
    {
        this.listeCours = listeCours;
    }

// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------
    public Integer getId()
    {
        return id;
    }

    public String getNom()
    {
        return nom;
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getEmail() {
        return email;
    }
    

    public Vector<Cours> getListeCours()
    {
        return listeCours;
    }

// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "Numero              : " + id+ "\n";
        retour += "nom                : " + nom + "\n";
        retour += "Prenom           : " + prenom+ "\n";
     
       

        return retour;
    }

 
} 
    

