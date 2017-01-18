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

public class Personnel {
   private long idpersonnel;
   private String matricule;
   private String nompersonnel;
   private String prenomspersonnel;
   private Date datenaissance;
   private Date dateentree;
   
   public java.util.Collection<Presence> presence;
   public java.util.Collection salairemetier;
   
   
   public java.util.Collection<Presence> getPresence() {
      if (presence == null)
         presence = new java.util.HashSet<Presence>();
      return presence;
   }
   
   public java.util.Iterator getIteratorPresence() {
      if (presence == null)
         presence = new java.util.HashSet<Presence>();
      return presence.iterator();
   }
   
   public void setPresence(java.util.Collection<Presence> newPresence) {
      removeAllPresence();
      for (java.util.Iterator iter = newPresence.iterator(); iter.hasNext();)
         addPresence((Presence)iter.next());
   }
   
   public void addPresence(Presence newPresence) {
      if (newPresence == null)
         return;
      if (this.presence == null)
         this.presence = new java.util.HashSet<Presence>();
      if (!this.presence.contains(newPresence))
         this.presence.add(newPresence);
   }
   
   public void removePresence(Presence oldPresence) {
      if (oldPresence == null)
         return;
      if (this.presence != null)
         if (this.presence.contains(oldPresence))
            this.presence.remove(oldPresence);
   }
   
   public void removeAllPresence() {
      if (presence != null)
         presence.clear();
   }

}