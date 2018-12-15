/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tables;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author User
 */
public class Cotisation {
    private Integer id;
    private Date date;
    private BigDecimal montant;
    private Integer idAdherent;
    
    private Adherent adherent;
    
    // ==========================================================================
// METHODES
// ==========================================================================
// --------------------------------------------------------------------------
// CONSTRUCTEUR
// -------------------------------------------------------------------------- 
public Cotisation()
{
}

// --------------------------------------------------------------------------
// SETTERS
// --------------------------------------------------------------------------

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMontant(BigDecimal montant) {
        this.montant = montant;
    }

    public void setIdAdherent(Integer idAdherent) {
        this.idAdherent = idAdherent;
    }

    public void setAdherent(Adherent adherent) {
        this.adherent = adherent;
    }
  
// --------------------------------------------------------------------------
// GETTERS
// --------------------------------------------------------------------------

    public Integer getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getMontant() {
        return montant;
    }

    public Integer getIdAdherent() {
        return idAdherent;
    }

    public Adherent getAdherent() {
        return adherent;
    }
  
    
    
}
