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

import java.util.*;
import java.util.logging.Logger;

public class Prix {
   private long idprix;
   private Date date;
   private long idchambre;
   private float prix;

    public Prix(long prix) {
        this.prix = prix;
    }

   
   //getters
    public long getIdprix() {
        return idprix;
    }

    public Date getDate() {
        return date;
    }

    public long getIdchambre() {
        return idchambre;
    }

    public float getPrix() {
        return prix;
    }

   
    
    //setters
    public void setIdprix(long idprix) {
        this.idprix = idprix;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setIdchambre(long idchambre) {
        this.idchambre = idchambre;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Prix(long idprix, Date date, long idchambre, float prix) {
        this.idprix = idprix;
        this.date = date;
        this.idchambre = idchambre;
        this.prix = prix;
    }

    public Prix(long idprix, long idchambre, float prix) {
        this.idprix = idprix;
        this.idchambre = idchambre;
        this.prix = prix;
    }

    public Prix(long idchambre, float prix) {
        this.idchambre = idchambre;
        this.prix = prix;
    }

   public Prix()
   {
       
   }
    
   

}