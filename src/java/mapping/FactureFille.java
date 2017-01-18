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
public class FactureFille {
    private int idfacturefille;
    private int idconfirmationdetailreservation;
     private int idchambre;
    private int idfacture;
    private int quantite;
    private float remise;
    //getters
    public int getIdfacturefille() {
        return idfacturefille;
    }

    public int getIdconfirmationdetailreservation() {
        return idconfirmationdetailreservation;
    }

    public int getIdfacture() {
        return idfacture;
    }

    public int getQuantite() {
        return quantite;
    }

    public float getRemise() {
        return remise;
    }

    public int getIdchambre() {
        return idchambre;
    }
    
    //setters
    public void setIdfacturefille(int idfacturefille) {
        this.idfacturefille = idfacturefille;
    }

    public void setIdconfirmationdetailreservation(int idconfirmationdetailreservation) {
        this.idconfirmationdetailreservation = idconfirmationdetailreservation;
    }

    public void setIdfacture(int idfacture) {
        this.idfacture = idfacture;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setRemise(float remise) {
        this.remise = remise;
    }

    public void setIdchambre(int idchambre) {
        this.idchambre = idchambre;
    }
    
    
}
