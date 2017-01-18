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


public class Categorie {
  
   private long idcategorie;
   private String nomcategorie;
   public java.util.Collection<Chambre> chambre;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Chambre> getChambre() {
      if (chambre == null)
         chambre = new java.util.HashSet<Chambre>();
      return chambre;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorChambre() {
      if (chambre == null)
         chambre = new java.util.HashSet<Chambre>();
      return chambre.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newChambre */
   public void setChambre(java.util.Collection<Chambre> newChambre) {
      removeAllChambre();
      for (java.util.Iterator iter = newChambre.iterator(); iter.hasNext();)
         addChambre((Chambre)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newChambre */
   public void addChambre(Chambre newChambre) {
      if (newChambre == null)
         return;
      if (this.chambre == null)
         this.chambre = new java.util.HashSet<Chambre>();
      if (!this.chambre.contains(newChambre))
         this.chambre.add(newChambre);
   }
   
   /** @pdGenerated default remove
     * @param oldChambre */
   public void removeChambre(Chambre oldChambre) {
      if (oldChambre == null)
         return;
      if (this.chambre != null)
         if (this.chambre.contains(oldChambre))
            this.chambre.remove(oldChambre);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllChambre() {
      if (chambre != null)
         chambre.clear();
   }
   //getters 
    public long getIdcategorie() {
        return idcategorie;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }
   //setters

    public void setIdcategorie(long idcategorie) {
        this.idcategorie = idcategorie;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }
    //constructeurs
    public Categorie(long idcategorie, String nomcategorie) {
        this.idcategorie = idcategorie;
        this.nomcategorie = nomcategorie;
    }
    public Categorie()
    {
        
    }

    public Categorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }
    
}
