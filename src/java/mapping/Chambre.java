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


public class Chambre {
   private long idchambre;
   private String numero;
   private short lits;
   private short places;
   private long idcategorie;
   private float prix;
   private String nomcategorie;
   private Date date;
  
   
   //public java.util.Collection<Prix> prix;
   //public java.util.Collection<Detailreservation> detailreservation;

    public Chambre(String numero, short lits, short places, long idcategorie) {
        this.numero = numero;
        this.lits = lits;
        this.places = places;
        this.idcategorie = idcategorie;
    }
   
   
  
   
   //getters

    public long getIdchambre() {
        return idchambre;
    }

    public String getNumero() {
        return numero;
    }

    public short getLits() {
        return lits;
    }

    public short getPlaces() {
        return places;
    }

    public long getIdcategorie() {
        return idcategorie;
    }

    public float getPrix() {
        return prix;
    }

    public String getNomcategorie() {
        return nomcategorie;
    }

    public Date getDate() {
        return date;
    }
    
   
    //setters

    public void setIdchambre(long idchambre) {
        this.idchambre = idchambre;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setLits(short lits) {
        this.lits = lits;
    }

    public void setPlaces(short places) {
        this.places = places;
    }

    public void setIdcategorie(long idcategorie) {
        this.idcategorie = idcategorie;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setNomcategorie(String nomcategorie) {
        this.nomcategorie = nomcategorie;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
    //constructors

    public Chambre(long idchambre, String numero, short lits, short places, long idcategorie) {
        this.idchambre = idchambre;
        this.numero = numero;
        this.lits = lits;
        this.places = places;
        this.idcategorie = idcategorie;
    }
    public Chambre()
    {
        
    }

    public Chambre(String numero, short lits, short places, float prix, String nomcategorie, Date date) {
        this.numero = numero;
        this.lits = lits;
        this.places = places;
        this.prix = prix;
        this.nomcategorie = nomcategorie;
        this.date = date;
    }

    
    
    
    
}
