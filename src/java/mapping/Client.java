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
/***********************************************************************
 * Module:  Client.java
 * Author:  nambi
 * Purpose: Defines the Class Client
 ***********************************************************************/

import java.util.*;


public class Client {
   
   private long idclient;
   private String nomclient;
   private String prenomsclient;
   private String adresse;
   private String cin;
   //getters
    public long getIdclient() {
        return idclient;
    }

    public String getNomclient() {
        return nomclient;
    }

    public String getPrenomsclient() {
        return prenomsclient;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getCin() {
        return cin;
    }
    

   //setters

    public void setIdclient(long idclient) {
        this.idclient = idclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public void setPrenomsclient(String prenomsclient) {
        this.prenomsclient = prenomsclient;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
    
   
   
   
   

}
