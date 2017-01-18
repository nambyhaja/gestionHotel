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
public class ModePaiement {
    private int idmodepaiement;
    private String designation;
    //getters
    public int getIdmodepaiement() {
        return idmodepaiement;
    }

    public String getDesignation() {
        return designation;
    }
    //setters

    public void setIdmodepaiement(int idmodepaiement) {
        this.idmodepaiement = idmodepaiement;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
}
