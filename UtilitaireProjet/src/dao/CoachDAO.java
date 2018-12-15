/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import divers.Colonne;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;
import jdbc.AccesBase;
import jdbc.JeuResultat;
import tables.Coach;

/**
 *
 * @author User
 */
public class CoachDAO {
    
// ==========================================================================
// PROPRIETES
// ==========================================================================
// --------------------------------------------------------------------------
// Acces a la base de donnees liee a la table SECTEUR
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
    public CoachDAO(AccesBase accesBase)
    {
        this.accesBase = accesBase;
    }
 public void lire(Coach coach) throws SQLException
    {
        int rowCount;

        String select;
        Vector ligne;

        select = "SELECT * FROM VERSEMENT WHERE NUMERO = "
            + coach.getId();

        jeuResultat = accesBase.executeQuery(select);

        rowCount = (jeuResultat.getLignes()).size();

// --------------------------------------------------------------------------
// Si le executeQuery retourne 0 ligne, il n'y a pas SQLException. C'est la
// raison de la creation d'une SQLException particuliere.
// --------------------------------------------------------------------------
        if (rowCount == 1)
        {
            ligne = (jeuResultat.getLignes()).elementAt(0);

            coach.setNom((String) ligne.elementAt(1));
            coach.setPrenom((String) ligne.elementAt(2));
            coach.setEmail((String) ligne.elementAt(3));
        }
        else 
        {
            if (rowCount == 0)
            {
                throw new SQLException(
                    "Coach " + coach.getId()+ " inconnu");
            }
            else
            {
                throw new SQLException(
                    "Clef " + coach.getId() + " en double !");
            }
        }
    }

// --------------------------------------------------------------------------
// Creation (insert) d'un objet Versement
// --------------------------------------------------------------------------
    public int creer(Coach coach) throws SQLException
    {
        int rowCount;
        String insert;

        //Integer numero = coach.getId();
        String nom = coach.getNom();
        String prenom = coach.getPrenom();
        String email = coach.getEmail();

        

        insert = "INSERT INTO COACH VALUES("
            //+ numero + ", "
            + nom + ", "
            + prenom + ", "
            + email + ")";

        rowCount = accesBase.executeUpdate(insert);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Modification (update) d'un objet Versement
// --------------------------------------------------------------------------
    public int modifier(Coach coach) throws SQLException
    {
        int rowCount;
        String update;

        Integer numero = coach.getId();
        String nom = coach.getNom();
        String prenom = coach.getPrenom();
        String email = coach.getEmail();
        
      
        update = "UPDATE coach SET "
            + "Nom = " + nom + ", "
            + "prenom = " + prenom + ", "
            + "email= " + email+ " "
            + "WHERE NUMERO = " + numero;

        rowCount = accesBase.executeUpdate(update);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Destruction (delete) d'un objet Versement
// --------------------------------------------------------------------------
    public int detruire(Coach coach) throws SQLException
    {
        int rowCount;
        String delete;

        Integer numero = coach.getId();

        delete = "DELETE FROM coach WHERE NUMERO = " + numero;

        rowCount = accesBase.executeUpdate(delete);

        return rowCount;
    }

// --------------------------------------------------------------------------
// Liste des versements pour un contact donne
// --------------------------------------------------------------------------
    /*  public Vector<Versement> lireListe(Contact contact) throws SQLException
    {
        Vector<Versement> listeVersements;
        Versement versement;

        String select
            = "SELECT * FROM VERSEMENT WHERE NUMERO_CONTACT = ";
        select += contact.getNumero();

        int nombreDeVersements;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeVersements = new Vector<Versement>();
        nombreDeVersements = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeVersements; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            versement = new Versement();
            versement.setNumero((Integer) ligne.elementAt(0));
            versement.setDate((Date) ligne.elementAt(1));
            versement.setMontant((BigDecimal) ligne.elementAt(2));
            versement.setNumeroContact((Integer) ligne.elementAt(3));

            versement.setContact(contact);
            listeVersements.addElement(versement);
        }

        return listeVersements;
    }
*/
// --------------------------------------------------------------------------
// Liste des versements
// --------------------------------------------------------------------------
    public Vector<Coach> lireListe() throws SQLException
    {
        Vector<Coach> listeCoach;
        Coach coach;

        String select = "SELECT * FROM coach_sportif";

        int nombreDeVersements;
        Vector ligne;
        int i;

        jeuResultat = accesBase.executeQuery(select);

        listeCoach = new Vector<Coach>();
        nombreDeVersements = (jeuResultat.getLignes()).size();

        for (i = 0; i < nombreDeVersements; i++)
        {
            ligne = (jeuResultat.getLignes()).elementAt(i);

            coach = new Coach();
            coach.setId((Integer) ligne.elementAt(0));
            coach.setNom((String) ligne.elementAt(1));
            coach.setPrenom((String) ligne.elementAt(2));
            coach.setEmail((String) ligne.elementAt(3));

            listeCoach.addElement(coach);
        }

        return listeCoach;
    }

// --------------------------------------------------------------------------
// Liste des colonnes de la table VERSEMENT
// --------------------------------------------------------------------------
    public Vector<Colonne> getListeColonnes()
    {
        return jeuResultat.getColonnes();
    }
}