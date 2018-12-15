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
public class OntLieuDAO {
   
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
    public OntLieuDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }


// --------------------------------------------------------------------------
// Creation (insert) d'un objet Cours
// --------------------------------------------------------------------------
    public int creer(OntLieu lieu) throws SQLException
    {
        int rowCount;
        String insert;

        Integer idCours = lieu.getIdCours();
        Integer idJour = lieu.getIdJour();
        Time heure = lieu.getHeure();

        insert = "INSERT INTO ONT_LIEU VALUES("
            + idCours + ", "
            + idJour + ","
            + heure + ")";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Cours
// --------------------------------------------------------------------------
    public int modifier(OntLieu lieu) throws SQLException
    {
        int rowCount;
        String update;

                Integer idCours = lieu.getIdCours();
          Integer idJour = lieu.getIdJour();
        Time heure = lieu.getHeure();

        update = "UPDATE ONT_LIEU SET "
            + "IDCOURS = " + idCours + ", "
            + "IdJour= " + idJour + ", "
            + "WHERE IdCours = " + idCours;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Cours
// --------------------------------------------------------------------------
    public int detruire(OntLieu lieu) throws SQLException
    {
        int rowCount;
        String delete;

        Integer idCours = lieu.getIdCours();

        delete = "DELETE FROM ONT_LIEU WHERE IdCours = " + idCours;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }


// --------------------------------------------------------------------------
// Liste des cours pour un coach donne
// --------------------------------------------------------------------------
    /*  public Vector<Cours> lireListe(Coach coach) throws SQLException
    {
        Vector<Cours> listeCours;
        Cours cours;

        String select = "SELECT * FROM COURS WHERE IDCOACH = ";
        select += coach.getId();

        int nombreDeCours;
        Vector<Object> ligne;
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


            cours.setCoach(coach);
            listeCours.addElement(cours);
        }

        return listeCours;
    }*/

// --------------------------------------------------------------------------
// Liste des cours
// --------------------------------------------------------------------------
    public Vector<OntLieu> lireListe() throws SQLException
    {
        Vector<OntLieu> listeLieu;
        OntLieu ontLieu;
        Jour jour;
        Cours cours;

        String select = "SELECT JOUR.Libelle,COURS.Libelle,ONT_LIEU.Heure "
                + " FROM ONT_LIEU INNER JOIN COURS ON COURS.IDCOURS=ONT_LIEU.IDCOURS\n" 
                + "INNER JOIN JOUR ON JOUR.IdJour=ONT_LIEU.IdJour ORDER BY JOUR.IdJour ASC, ONT_LIEU.Heure";

        int nombreDeLieu;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeLieu = new Vector<OntLieu>();
        nombreDeLieu = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeLieu; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);
            
            jour =new Jour();
            cours = new Cours();
            ontLieu = new OntLieu();
            jour.setLibelle((String) ligne.elementAt(0));
            ontLieu.setJour(jour);
            cours.setLibelle((String) ligne.elementAt(1));
            ontLieu.setCours(cours);
            ontLieu.setHeure((Time) ligne.elementAt(2));


            
            listeLieu.addElement(ontLieu);
        }

        return listeLieu;
    }

    
// --------------------------------------------------------------------------
// Liste des colonnes de la table CONTACT
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
    public Vector<OntLieu> lireListe(Jour jour) throws SQLException
    {
        Vector<OntLieu> listeLieu;
        OntLieu ontLieu;
       // Jour jour;
        Cours cours;

        String select = "SELECT COURS.Libelle as Cours,ONT_LIEU.Heure "
                + " FROM ONT_LIEU INNER JOIN COURS ON COURS.IDCOURS=ONT_LIEU.IDCOURS\n" 
                + "INNER JOIN JOUR ON JOUR.IdJour=ONT_LIEU.IdJour where JOUR.Libelle= '"+ jour.getLibelle() +"' ORDER BY JOUR.IdJour ASC, ONT_LIEU.Heure";

        int nombreDeOntLieu;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeLieu = new Vector<OntLieu>();
        nombreDeOntLieu = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeOntLieu; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);
            
            //jour =new Jour();
            cours = new Cours();
            ontLieu = new OntLieu();
            //jour.setLibelle((String) ligne.elementAt(0));
            //ontLieu.setJour(jour);
            cours.setLibelle((String) ligne.elementAt(0));
            ontLieu.setCours(cours);
            ontLieu.setHeure((Time) ligne.elementAt(1));


            
            listeLieu.addElement(ontLieu);
        }

        return listeLieu;
}
}

