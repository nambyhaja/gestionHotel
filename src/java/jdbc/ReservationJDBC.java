/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mapping.Chambre;
import mapping.Client;
import mapping.DetailReservation;
import mapping.Reservation;

/**
 *
 * @author nambi
 */
public class ReservationJDBC {
    public void insertReservation(Reservation r,Connection c)throws Exception
    {
        int val=0;
        PreparedStatement preparar1=null;
        try
        {
            String requete1="insert into reservation (idclient,datereservation,datedebut,datefin) values(?,?,?,?);";
            preparar1=c.prepareStatement(requete1);
            preparar1.setInt(1,r.getIdclient());
            preparar1.setDate(2,r.getDatereservation());
            preparar1.setDate(3,r.getDatedebut());
             preparar1.setDate(4,r.getDatefin());
            preparar1.executeUpdate();
            
        }
        catch(Exception e)
        {
            throw new Exception("Insertion non faite");
        }
    }
    public Reservation[] getReservationsConfirmes(Connection c)throws Exception
    {
        
            int j=0;
            String req = "SELECT r.idreservation,c.idclient,c.nomclient,c.prenomsclient,r.datereservation,r.datedebut,r.datefin,cr.confirme,cr.dateconfirmation,r.facture from reservation r join confirmationreservation cr on r.idreservation=cr.idreservation join client c on c.idclient=r.idclient where cr.confirme=TRUE";
            PreparedStatement preparar=null;
            preparar=c.prepareStatement(req,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet res = preparar.executeQuery();
            res.last();
            int count = res.getRow();
            Reservation[] rep=new Reservation[count];
            for(int i=0;i<rep.length;i++)
            {
                rep[i]=new Reservation();
            }
            Client client=new Client();
            res.beforeFirst();
            while(res.next())
            {
               
                    rep[j].setIdreservation(res.getInt(1));
                    rep[j].setIdclient(res.getInt(2));
                    client.setNomclient(res.getString(3));
                    client.setPrenomsclient(res.getString(4));
                    rep[j].setDatereservation(res.getDate(5));
                    rep[j].setDatedebut(res.getDate(6));
                    rep[j].setDatefin(res.getDate(7));
                    rep[j].setClient(client);
                    rep[j].setConfirmation(res.getString(8));
                    rep[j].setDateconfirmation(res.getDate(9));
                    rep[j].setFacture(res.getString(10));
                    
                    j++;
            }
            return rep;
    }
    public Client getClientByIdReserv(String idres, Connection c)throws Exception
    {
            int idreservation=Integer.parseInt(idres);
            String req = "select c.idclient,c.nomclient,c.prenomsclient,c.adresse,c.cin from client c join reservation r on r.idclient=c.idclient where r.idreservation=?";
            PreparedStatement preparar=null;
            preparar=c.prepareStatement(req,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            preparar.setInt(1,idreservation);
            ResultSet res = preparar.executeQuery();
            Client rep=new Client();
            while(res.next())
            {
               
                    rep.setIdclient(res.getInt(1));
                    rep.setNomclient(res.getString(2));
                    rep.setPrenomsclient(res.getString(3));
                    rep.setAdresse(res.getString(4));
                    rep.setCin(res.getString(5));
                    
            }
            return rep;
    }
   public DetailReservation[] getDetailsReservationsById(String idres, Connection c)throws Exception
    {
        int j=0;
        int idreservation=Integer.parseInt(idres);
        String req = "select dr.iddetailreservation,c.numero,c.lits,c.places,conf.dateconfirmationdetailres,conf.confirme from detailreservation dr join reservation r on r.idreservation=dr.idreservation join chambre c on c.idchambre=dr.idchambre join confirmationdetailres conf on conf.iddetailreservation=dr.iddetailreservation where r.idreservation=?";
        PreparedStatement preparar=null;
        preparar=c.prepareStatement(req,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
         preparar.setInt(1,idreservation);
        ResultSet res = preparar.executeQuery();
        res.last();
        int count = res.getRow();
        DetailReservation[] rep=new DetailReservation[count];
        for(int i=0;i<rep.length;i++)
        {
            rep[i]=new DetailReservation();
        }
        res.beforeFirst();
        
        while(res.next())
        {

                rep[j].setIddetaireservation(res.getInt(1));
                Chambre ch=new Chambre();
                ch.setNumero(res.getString(2));
                ch.setLits(res.getShort(3));
                ch.setPlaces(res.getShort(4));
                rep[j].setDateconfirmationdetail(res.getDate(5));
                rep[j].setConfirme(res.getString(6));
                rep[j].setChambre(ch);
                j++;
               
        }
        return rep;
    }
}
