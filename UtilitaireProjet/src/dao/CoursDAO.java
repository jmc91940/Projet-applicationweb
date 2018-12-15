/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import divers.Colonne;
import divers.Conversion;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Vector;
import jdbc.AccesBase;
import jdbc.JeuResultat;
import tables.*;

/**
 *
 * @author User
 */
public class CoursDAO {
   
// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table COURS
// --------------------------------------------------------------------------
    private AccesBase accesBase;

// --------------------------------------------------------------------------
// Jeu de resultats lu par l'un des "executeQuery"
// Il contient toutes les donnees des lignes lues dans la table contact et
// les donnees relatives aux colonnes.
// --------------------------------------------------------------------------
    private JeuResultat jeuResultat;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public CoursDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }


// --------------------------------------------------------------------------
// Creation (insert) d'un objet Cours
// --------------------------------------------------------------------------
    public int creer(Cours cours) throws SQLException
    {
        int rowCount;
        String insert;

        Integer id = cours.getId();
        String libelle = cours.getLibelle();
        Integer duree = cours.getDuree();
        Integer idCoach = cours.getIdCoach();
        Integer idSalle = cours.getIdSalle();

        insert = "INSERT INTO COURS VALUES("
            
            + Conversion.chaineSQL(libelle) + ", "
            + duree + ","
            + idSalle + ","
            + idCoach + ")";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Cours
// --------------------------------------------------------------------------
    public int modifier(Cours cours) throws SQLException
    {
        int rowCount;
        String update;

               
               String libelle = cours.getLibelle();
               Integer duree  = cours.getDuree();
               Integer idCoach = cours.getIdCoach();
               Integer idSalle = cours.getIdSalle();

        update = "UPDATE COURS SET "
            + "Libelle = " + Conversion.chaineSQL(libelle) + ", "
            + "Duree = " + duree + ","    
            + "IdCoach= " + idCoach + ", "
            + "IdSalle= " + idSalle 
            + "WHERE Libelle = " + Conversion.chaineSQL(libelle);

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Cours
// --------------------------------------------------------------------------
    public int detruire(Cours cours) throws SQLException
    {
        int rowCount;
        String delete;

        Integer id = cours.getId();

        delete = "DELETE FROM COURS WHERE IdCours = " + id;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Liste des cours
// --------------------------------------------------------------------------
    /**
     * 
     * @return
     * @throws SQLException 
     */
   public Vector<Cours> lireListe() throws SQLException
    {
        Vector<Cours> listeCours;
        Cours cours;
        Coach coach;
     

        //String select = "SELECT LIBELLE,DUREE,IDCOACH FROM COURS";
            String select = "SELECT COURS.LIBELLE as Cours, COURS.DUREE as 'Durée en min', COACH_SPORTIF.Nom AS Coach "
                    + "FROM COURS INNER JOIN COACH_SPORTIF "
                    + "ON COURS.IDCOACH=COACH_SPORTIF.IDCOACH";
        int nombreDeCours;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeCours = new Vector<Cours>();
        nombreDeCours = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeCours; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);
            
            cours = new Cours();
            coach = new Coach();
           
            cours.setLibelle((String) ligne.elementAt(0));
            cours.setDuree((Integer) ligne.elementAt(1));
            coach.setNom((String)ligne.elementAt(2));
            cours.setCoach(coach);
           
          
            
            listeCours.addElement(cours);
        }

        return listeCours;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table COURS
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }

    // --------------------------------------------------------------------------
// Lecture d'un objet Contact (dont la clef est renseignee)
// --------------------------------------------------------------------------
    /* public void lire(Cours cours) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;
        
        select = "SELECT JOUR.Libelle,COURS.Libelle,ONT_LIEU.Heure "
                + "FROM ONT_LIEU "
                + "INNER JOIN COURS ON COURS.IDCOURS=ONT_LIEU.IDCOURS" 
                + "INNER JOIN JOUR ON JOUR.IdJour=ONT_LIEU.IdJour WHERE COURS.Libelle=" + cours.getLibelle()
                +"ORDER BY JOUR.IdJour ASC, ONT_LIEU.Heure";



        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            cours.setLibelle((String) ligne.elementAt(1));
            cours.setLibelleJour((String) ligne.elementAt(2));
            cours.setHeure((Time) ligne.elementAt(3));
            
        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Cours " + cours.getLibelle() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + cours.getId()+ " en double !");
            }
        }
    }*/
    
    /*public Vector<Cours> lireListe() throws SQLException
    {
        Vector<Cours> listeCours;
        Cours cours;
        Coach coach;
        Vector<OntLieu> listeLieu;
     

        //String select = "SELECT LIBELLE,DUREE,IDCOACH FROM COURS";
            String select = "SELECT JOUR.LIBELLE as Jour, COURS.LIBELLE as Cours,ONT_LIEU.HEURE as HEURE, COURS.DUREE as 'Durée en min', COACH_SPORTIF.Nom AS Coach "
                    + "FROM COURS INNER JOIN COACH_SPORTIF "
                    + "ON COURS.IDCOACH=COACH_SPORTIF.IDCOACH"
                    +"ONT_LIEU INNER JOIN COURS ON COURS.IDCOURS=ONT_LIEU.IDCOURS"
                    +"INNER JOIN JOUR ON JOUR.IdJour=ONT_LIEU.IdJour ORDER BY JOUR.IdJour ASC, ONT_LIEU.Heure";
        int nombreDeCours;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeCours = new Vector<Cours>();
       
        
        nombreDeCours = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeCours; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);
            listeLieu= new Vector<OntLieu>();
            cours = new Cours();
            coach = new Coach();
           // cours.setId((Integer) ligne.elementAt(0));
          listeLieu.equals((String) ligne.elementAt(0));
           cours.setListeLieu(listeLieu);
            cours.setLibelle((String) ligne.elementAt(1));
            cours.setDuree((Integer) ligne.elementAt(2));
            //
            //cours.setNOM((String) ligne.elementAt(2));
            coach.setNom((String)ligne.elementAt(3));
             cours.setCoach(coach);
           
            //coach.setNom((String) ligne.elementAt(2));
            
            listeCours.addElement(cours);
        }

        return listeCours;
    }*/
    public Vector<Cours> lireListeResponsableCours() throws SQLException
    {
        Vector<Cours> listeCours;
        Cours cours;
    
     

        
            String select = "SELECT * from cours";
        int nombreDeCours;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeCours = new Vector<Cours>();
        nombreDeCours = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeCours; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);
            
            cours = new Cours();
      
            cours.setId((Integer) ligne.elementAt(0));
            cours.setLibelle((String) ligne.elementAt(1));
            cours.setDuree((Integer) ligne.elementAt(2));
            cours.setIdCoach((Integer) ligne.elementAt(3));
           cours.setIdSalle((Integer) ligne.elementAt(4));
          
            
            listeCours.addElement(cours);
        }

        return listeCours;
    }
    
public void lire(Cours cours) throws SQLException
    {
         int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM COURS WHERE LIBELLE = '" + cours.getLibelle()+"'";

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);
            
            cours.setLibelle((String) ligne.elementAt(1));
            cours.setDuree((Integer) ligne.elementAt(2));
            cours.setIdCoach((Integer) ligne.elementAt(3));
            cours.setIdSalle((Integer) ligne.elementAt(4));
        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Cours " + cours.getLibelle() + " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + cours.getLibelle()+ " en double !");
            }
        }
    }
}
    



