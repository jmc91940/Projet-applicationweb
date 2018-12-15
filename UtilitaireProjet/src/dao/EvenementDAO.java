/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author User
 */
import divers.Colonne;
import divers.Conversion;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import jdbc.AccesBase;
import jdbc.JeuResultat;
import tables.*;

/**
 *
 * @author User
 */
public class EvenementDAO {
   
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
    public EvenementDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }


// --------------------------------------------------------------------------
// Creation (insert) d'un objet Evenement
// --------------------------------------------------------------------------
    public int creer(Evenement evenement) throws SQLException
    {
        int rowCount;
        String insert;

        Integer id = evenement.getId();
        String libelle = evenement.getLibelle();
        Date date = evenement.getDate();
     

        insert = "INSERT INTO EVENEMENT VALUES("
            + id + ", "
            + Conversion.chaineSQL(libelle) + ", "
            + date + ")";
            

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Evenement
// --------------------------------------------------------------------------
    public int modifier(Evenement evenement) throws SQLException
    {
        int rowCount;
        String update;

               Integer id = evenement.getId();
               String libelle = evenement.getLibelle();
               Date date = evenement.getDate();

        update = "UPDATE EVENEMENT SET "
            + "Libelle = " + Conversion.chaineSQL(libelle) + ", "
            + "Date = " + date + ","    
            + "WHERE IdEvenement = " + id;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Evenement
// --------------------------------------------------------------------------
    public int detruire(Evenement evenement) throws SQLException
    {
        int rowCount;
        String delete;

        Integer id = evenement.getId();

        delete = "DELETE FROM EVENEMENT WHERE IdEvenement = " + id;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }


// --------------------------------------------------------------------------
// Liste des evenement
// --------------------------------------------------------------------------
    public Vector<Evenement> lireListe() throws SQLException
    {
        Vector<Evenement> listeEvenement;
        Evenement evenement;

        String select = "SELECT LIBELLE AS SOIREE,DATE FROM EVENEMENT";

        int nombreDeEvenement;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeEvenement = new Vector<Evenement>();
        nombreDeEvenement = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeEvenement; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);
            
            evenement = new Evenement();
            //evenement.setId((Integer) ligne.elementAt(0));
            evenement.setLibelle((String) ligne.elementAt(0));
            evenement.setDate((Date) ligne.elementAt(1));
            


            
            listeEvenement.addElement(evenement);
        }

        return listeEvenement;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table Evenement
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
}

