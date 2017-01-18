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
public class Paiement {
    private int idpaiement;
    private int idfacture;
    private int idmodepaiement;
    private float montant;
    //getters
    public int getIdpaiement() {
        return idpaiement;
    }

    public int getIdfacture() {
        return idfacture;
    }

    public int getIdmodepaiement() {
        return idmodepaiement;
    }

    public float getMontant() {
        return montant;
    }
    //setters

    public void setIdpaiement(int idpaiement) {
        this.idpaiement = idpaiement;
    }

    public void setIdfacture(int idfacture) {
        this.idfacture = idfacture;
    }

    public void setIdmodepaiement(int idmodepaiement) {
        this.idmodepaiement = idmodepaiement;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
    
}
