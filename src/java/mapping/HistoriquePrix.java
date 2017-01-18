/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import java.sql.Date;

/**
 *
 * @author nambi
 */
public class HistoriquePrix {
    private int idprix;
    private int idchambre;
    private float prix;
    private Date dateeffectivite;
    //getters

    public int getIdprix() {
        return idprix;
    }

    public int getIdchambre() {
        return idchambre;
    }

    public float getPrix() {
        return prix;
    }

    public Date getDateeffectivite() {
        return dateeffectivite;
    }
    
    //setters
    public void setIdprix(int idprix) {
        this.idprix = idprix;
    }

    public void setIdchambre(int idchambre) {
        this.idchambre = idchambre;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setDateeffectivite(Date dateeffectivite) {
        this.dateeffectivite = dateeffectivite;
    }
    
}
