/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mapping.Client;

/**
 *
 * @author nambi
 */
public class ClientJDBC {
    public void insertClient(Client cl,Connection c)throws Exception
    {
        int val=0;
        PreparedStatement preparar1=null;
        try
        {
            String requete1="insert into client (nomclient,prenomsclient,adresse,cin) values(?,?,?,?);";
            preparar1=c.prepareStatement(requete1);
            preparar1.setString(1,cl.getNomclient());
            preparar1.setString(2,cl.getPrenomsclient());
            preparar1.setString(3,cl.getAdresse());
             preparar1.setString(4,cl.getCin());
            preparar1.executeUpdate();
            
        }
        catch(Exception e)
        {
            throw new Exception("Insertion non faite");
        }
    }
    public Client[] getClients(Connection c)throws Exception
    {
        
            int j=0;
            String req = "SELECT * from client";
            PreparedStatement preparar=null;
            preparar=c.prepareStatement(req,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet res = preparar.executeQuery();
            res.last();
            int count = res.getRow();
            Client[] rep=new Client[count];
            for(int i=0;i<rep.length;i++)
            {
                rep[i]=new Client();
            }
            res.beforeFirst();
            while(res.next())
            {
                    rep[j].setIdclient(res.getInt(1));
                    rep[j].setNomclient(res.getString(2));
                     rep[j].setPrenomsclient(res.getString(3));
                      rep[j].setAdresse(res.getString(4));
                       rep[j].setCin(res.getString(5));
                    j++;
            }
            return rep;
    }
}
