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

public class Adherent {
   // ==========================================================================
// PROPRIETES
// ==========================================================================
// Toutes les colonnes de la table y compris les clefs etrangeres
// --------------------------------------------------------------------------
    private Integer id;             // Clef primaire
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
    private String codePostal;
    private String ville;
    
// --------------------------------------------------------------------------
// Proprietes de mapping
// --------------------------------------------------------------------------    
    private Vector<Cotisation> listeCotisation;
    private Vector<Consulte> listeConsulte;
    private Vector<Participe> listeParticipation;
// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// -------------------------------------------------------------------------- 
public Adherent()
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
    
    public void setPrenom (String prenom)
    {
        this.prenom = prenom;
    }
    
    public void setEmail (String email)
    {
        this.email = email;
    }

    public void setTelephone (String telephone)
    {
        this.telephone = telephone;
    }
    public void setAdresse(String adresse)
    {
        this.adresse = adresse;
    }

    public void setCodePostal(String codePostal)
    {
        this.codePostal = codePostal;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }

      public void setListeParticipation(Vector<Participe> listeParticipation)
    {
        this.listeParticipation = listeParticipation;
    }
       public void setListeConsulte(Vector<Consulte> listeConsulte)
    {
        this.listeConsulte = listeConsulte;
    }

    public void setListeCotisation(Vector<Cotisation> listeCotisation) 
    {
        this.listeCotisation = listeCotisation;
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
    
    public String getEmail()
    {
        return email;
    }
    
    public String getTelephone()
    {
        return telephone;
    }

    public String getAdresse()
    {
        return adresse;
    }

    public String getCodePostal()
    {
        return codePostal;
    }

    public String getVille()
    {
        return ville;
    }

 public Vector<Participe> getListeParticipation()
    {
        return listeParticipation;
    }

  public Vector<Consulte> getListeConsulte()
    {
        return listeConsulte;
    }

    public Vector<Cotisation> getListeCotisation() {
        return listeCotisation;
    }
  
  
// --------------------------------------------------------------------------
// AFFICHAGE DU CONTACT (POUR MISE AU POINT)
// --------------------------------------------------------------------------
    public String toString()
    {
        String retour;

        retour = "Numero              : " + id+ "\n";
        retour += "Nom                 : " + nom + "\n";
        retour += "Prenom               :" + prenom + "\n";
        retour += "Adresse             : " + adresse + "\n";
        retour += "Code Postal         : " + codePostal + "\n";
        retour += "Ville               : " + ville + "\n";
        

        return retour;
    }
}

