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

public class DetailReservation {
   private int iddetaireservation;
   private int idreservation;
   private Chambre chambre;
   private Date dateconfirmationdetail;
   private String confirme;
   
   //getters
    public int getIddetaireservation() {
        return iddetaireservation;
    }

    public Chambre getChambre() {
        return chambre;
    }

    public Date getDateconfirmationdetail() {
        return dateconfirmationdetail;
    }

    public String getConfirme() {
        return confirme;
    }

    public int getIdreservation() {
        return idreservation;
    }
    
    //setters
    public void setIddetaireservation(int iddetaireservation) {
        this.iddetaireservation = iddetaireservation;
    }

    public void setChambre(Chambre chambre) {
        this.chambre = chambre;
    }

    public void setDateconfirmationdetail(Date dateconfirmationdetail) {
        this.dateconfirmationdetail = dateconfirmationdetail;
    }

    public void setConfirme(String confirme) {
       if(confirme.compareToIgnoreCase("t")==0)
        {
            this.confirme = "confirmé";
        }
        else
        {
            this.confirme = "non confirmé";
        }
    }

    public void setIdreservation(int idreservation) {
        this.idreservation = idreservation;
    }
   
    
    
}