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
import jdbc.JeuResultat;
import tables.Salle;

/**
 *
 * @author User
 */
public class SalleDAO {
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table Salle
// --------------------------------------------------------------------------
    private AccesBase accesBase;

// --------------------------------------------------------------------------
// Jeu de resultats lu par l'un des "executeQuery"
// Il contient toutes les donnees des lignes lues dans la table SECTEUR et
// les donnees relatives aux colonnes.
// --------------------------------------------------------------------------
    private JeuResultat jeuResultat;

// ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// Constructeur
// --------------------------------------------------------------------------
    public SalleDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }

// --------------------------------------------------------------------------
// Lecture d'un objet Secteur (dont la clef est renseignee)
// --------------------------------------------------------------------------
    public void lire(Salle salle) throws SQLException
    {
        int rowCount;

        String select;
        Vector<Object> ligne;

        select = "SELECT * FROM SECTEUR WHERE CODE = " + salle.getId();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            salle.setLibelle((String) ligne.elementAt(1));
        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Salle " + salle.getId()+ " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + salle.getId() + " en double !");
            }
        }
    }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet Secteur
// --------------------------------------------------------------------------
    public int creer(Salle salle) throws SQLException
    {
        int rowCount;
        String insert;

        Integer id = salle.getId();
        String libelle = salle.getLibelle();

        insert = "INSERT INTO SECTEUR VALUES("
            + id + ", "
            + Conversion.chaineSQL(libelle) + ")";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Secteur
// --------------------------------------------------------------------------
    public int modifier(Salle salle) throws SQLException
    {
        int rowCount;
        String update;

        Integer id = salle.getId();
        String libelle = salle.getLibelle();

        update = "UPDATE SALLE SET "
            + "LIBELLE = " + Conversion.chaineSQL(libelle) + " "
            + "WHERE CODE = " + id;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Secteur
// --------------------------------------------------------------------------
    public int detruire(Salle salle) throws SQLException
    {
        int rowCount;
        String delete;

        Integer id = salle.getId();

        delete = "DELETE FROM SECTEUR WHERE CODE = " + id;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Lecture d'un Secteur, pour un Contact donne
// --------------------------------------------------------------------------
  /*  public Secteur lireSecteur(Contact contact) throws SQLException
    {
        Secteur secteur = null;

        if (contact.getCodeSecteur() != null)
        {
            secteur = new Secteur();
            secteur.setCode(contact.getCodeSecteur());
            lire(secteur);
        }
        return secteur;
    }
*/
// --------------------------------------------------------------------------
// Liste des secteurs
// --------------------------------------------------------------------------
    public Vector<Salle> lireListe() throws SQLException
    {
        Vector<Salle> listeSalle;
        Salle salle;

        String select = "SELECT * FROM Salle";

        int nombreSecteurs;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeSalle = new Vector<Salle>();
        nombreSecteurs = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreSecteurs; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            salle = new Salle();
            salle.setId((Integer) ligne.elementAt(0));
            salle.setLibelle((String) ligne.elementAt(1));

            listeSalle.addElement(salle);
        }

        return listeSalle;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table SECTEUR
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
}
