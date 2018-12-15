/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import divers.Colonne;
import divers.Conversion;



import java.sql.SQLException;

import java.util.Vector;

import jdbc.AccesBase;
import jdbc.BaseDeDonnees;
import jdbc.JeuResultat;
import tables.Adherent;


/**
 *
 * @author User
 */
public class AdherentDAO {
  
    // ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table COURS
// --------------------------------------------------------------------------
     private static AccesBase accesBase;
     private static BaseDeDonnees base; 

// --------------------------------------------------------------------------
// Jeu de resultats lu par l'un des "executeQuery"
// Il contient toutes les donnees des lignes lues dans la table contact et
// les donnees relatives aux colonnes.
// --------------------------------------------------------------------------
    private static JeuResultat jeuResultat;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public AdherentDAO(AccesBase accesBase)
    {
        this.accesBase=accesBase;
    }

    
    public static boolean validate(Adherent adherent) throws SQLException
    {
        
        boolean status = false;
        
               try {
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         } catch (ClassNotFoundException ex) {
             
         }
        base = new BaseDeDonnees("jdbc:sqlserver://localhost;user=util;password=x;databasename=SalleSport");
        //base.setFormatDate(getInitParameter("formatDateSqlServer"));
        accesBase = new AccesBase(base);


            accesBase.getConnection();
            String select = "SELECT NOM,PRENOM FROM ADHERENT WHERE LOGIN ";/*= '" ;
        select += adherent.getLogin(); select += "'AND MOTDEPASSE = '"; select += adherent.getMotDePasse(); select +="'";*/
    
        jeuResultat = accesBase.executeQuery(select);
        
        if (!jeuResultat.getLignes().isEmpty())
        {
            status = true;
        }

        accesBase.closeConnection();
        
        //System.out.println(jeuResultat);
        
        return status;
        }
    
// --------------------------------------------------------------------------
// Creation (insert) d'un objet Evenement
// --------------------------------------------------------------------------
    public int creer(Adherent adherent) throws SQLException
    {
        int rowCount;
        String insert;

        String nom = adherent.getNom();
        String prenom = adherent.getPrenom();
        String email = adherent.getEmail();
        String telephone = adherent.getTelephone();
        String adresse = adherent.getAdresse();
        String codePostale = adherent.getCodePostal();
        String ville = adherent.getVille();
        
   insert = "INSERT INTO ADHERENT VALUES("
            
            + Conversion.chaineSQL(nom) + ", "
            + Conversion.chaineSQL(prenom) + ", "
            + Conversion.chaineSQL(email) + ", "
            + Conversion.chaineSQL(telephone) + ", "
            + Conversion.chaineSQL(adresse) + ", "
            + Conversion.chaineSQL(codePostale) + ", "
            + Conversion.chaineSQL(ville) + ")";
    

//        insert = "INSERT INTO ADHERENT (Nom,Prenom,Telephone,Email ,Adresse,CodePostale,Ville)  VALUES('"
//            + Conversion.chaineSQL(nom) + "', '"
//            + Conversion.chaineSQL(prenom) + "', '"
//            + Conversion.chaineSQL(email) + "', '"
//            + Conversion.chaineSQL(telephone) + "',' "
//            + Conversion.chaineSQL(adresse) + "', '"
//            + Conversion.chaineSQL(codePostale) + "', '"
//            + Conversion.chaineSQL(ville) + "')";
//            + "Nom = " + Conversion.chaineSQL(nom) + ", "
//            + "Prenom = " + Conversion.chaineSQL(prenom) + ", "
//            + "Email = " + Conversion.chaineSQL(email) + ", "
//            + "Telephone = " + Conversion.chaineSQL(telephone) + ", "
//            + "Adresse = " + Conversion.chaineSQL(adresse) + ", "
//            + "CodePostale = " + Conversion.chaineSQL(codePostale) + ", "
//            + "Ville = " + Conversion.chaineSQL(ville) + ") ";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Evenement
// --------------------------------------------------------------------------
    public int modifier(Adherent adherent) throws SQLException
    {
        int rowCount;
        String update;
        
        Integer id= adherent.getId();
        String nom = adherent.getNom();
        String prenom = adherent.getPrenom();
        String email = adherent.getEmail();
        String telephone = adherent.getTelephone();
        String adresse = adherent.getAdresse();
        String codePostale = adherent.getCodePostal();
        String ville = adherent.getVille();

        update = "UPDATE adherent SET "
            + "nom = " + Conversion.chaineSQL(nom) + ", "
            + "prenom = " + Conversion.chaineSQL(prenom) + ", "
            + "email = " + Conversion.chaineSQL(email) + ", "
            + "telephone = " + Conversion.chaineSQL(telephone) + ", "
            + "adresse = " + Conversion.chaineSQL(adresse) + ", "
            + "codePostale = " + Conversion.chaineSQL(codePostale) + ", "
            + "ville = " + Conversion.chaineSQL(ville) + ", "
            + "WHERE nom = " + nom;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Evenement
// --------------------------------------------------------------------------
    public int detruire(Adherent adherent) throws SQLException
    {
        int rowCount;
        String delete;

        String nom = adherent.getNom();

        delete = "DELETE FROM adherent WHERE nom = " + nom;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }


// --------------------------------------------------------------------------
// Liste des evenement
// --------------------------------------------------------------------------
    public Vector<Adherent> lireListe() throws SQLException
    {
        Vector<Adherent> listeAdherent;
        Adherent adherent;

        String select = "SELECT nom,prenom,email,telephone,adresse,codepostale,ville FROM ADHERENT";

        int nombreDeAdherent;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeAdherent = new Vector<Adherent>();
        nombreDeAdherent = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeAdherent; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);
            
            adherent = new Adherent();
            //adherent.setId((Integer) ligne.elementAt(0));
            adherent.setNom((String) ligne.elementAt(0));
            adherent.setPrenom((String) ligne.elementAt(1));
            adherent.setEmail((String) ligne.elementAt(2));
            adherent.setTelephone((String) ligne.elementAt(3));
            adherent.setAdresse((String) ligne.elementAt(4));
            adherent.setCodePostal((String) ligne.elementAt(5));
            adherent.setVille((String)ligne.elementAt(6));
          


            
            listeAdherent.addElement(adherent);
        }

        return listeAdherent;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table Evenement
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
}



