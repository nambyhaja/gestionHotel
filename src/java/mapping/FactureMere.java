/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

import formatage.Formater;
import java.sql.Date;
import java.text.ParseException;

/**
 *
 * @author nambi
 */
public class FactureMere {
    private int idfacturemere;
    private int idclient;
    private float tva;
    private Date dateecheancepaiement;
    //getters
    public int getIdfacturemere() {
        return idfacturemere;
    }

    public int getIdclient() {
        return idclient;
    }

    public float getTva() {
        return tva;
    }

    public Date getDateecheancepaiement() {
        return dateecheancepaiement;
    }
    //setters

    public void setIdfacturemere(int idfacturemere) {
        this.idfacturemere = idfacturemere;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public void setDateecheancepaiement(String date) throws ParseException {
        this.dateecheancepaiement = Formater.setDate(date);
    }
    
}
