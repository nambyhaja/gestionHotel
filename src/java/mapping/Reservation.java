/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapping;

/**
 *
 * @author nambi
 */

import java.sql.*;

public class Reservation {
   private int idreservation;
   private int idclient;
   private Client client;
   private Date datereservation;
   private Date datedebut;
   private Date datefin;
   private Date dateconfirmation;
   private String confirmation;
   private String facture;
   //getters
    public int getIdreservation() {
        return idreservation;
    }

    public int getIdclient() {
        return idclient;
    }

    public Date getDatereservation() {
        return datereservation;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public Client getClient() {
        return client;
    }

    public Date getDateconfirmation() {
        return dateconfirmation;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public String getFacture() {
        return facture;
    }
    
    
    //setters   
    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }

    public void setIdclient(int idclient) {
        this.idclient = idclient;
    }

    public void setDatereservation(Date datereservation) {
        this.datereservation = datereservation;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDateconfirmation(Date dateconfirmation) {
        this.dateconfirmation = dateconfirmation;
    }

    public void setConfirmation(String confirmation) {
        if(confirmation.compareToIgnoreCase("t")==0)
        {
            this.confirmation = "confirmé";
        }
        else
        {
            this.confirmation = "non confirmé";
        }
    }

    public void setFacture(String facture) {
        if(facture.compareToIgnoreCase("t")==0)
        {
            this.facture = "facturé";
        }
        else
        {
            this.facture = "non facturé";
        }
    }
    
   
}
