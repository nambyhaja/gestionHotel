/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import mapping.ModePaiement;
import mapping.Paiement;

/**
 *
 * @author nambi
 */
public class PaiementJDBC {
    private ConnexionJDBC con=new ConnexionJDBC();
    public void insertPaiement(Paiement p,Connection c)throws Exception
    {
        int val=0;
        PreparedStatement preparar1=null;
        ConnexionJDBC con=new ConnexionJDBC();
        try
        {
            String requete1="insert into paiement (idfacture,idmodepaiement,montantpaiement) values(?,?,?);";
            preparar1=c.prepareStatement(requete1);
            preparar1.setInt(1,p.getIdfacture());
            preparar1.setInt(2,p.getIdmodepaiement());
            preparar1.setDouble(3,p.getMontant());
            preparar1.executeUpdate();
            
        }
        catch(Exception e)
        {
            throw new Exception("Insertion non faite");
        }
    }
    public ModePaiement getModePaiementById(int id,Connection c)throws Exception
    {
        int j=0;
        ModePaiement rep=new ModePaiement();
        String req = "SELECT * from modepaiement where idpaiement=?";
        PreparedStatement preparar=null;
        preparar=c.prepareStatement(req,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        preparar.setInt(1, id);
        ResultSet res = preparar.executeQuery();
        while(res.next())
        {
                rep.setIdmodepaiement(res.getInt(1));
                rep.setDesignation(res.getString(2));
                j++;
        }
        return rep;
    }
    public int getIdByModes(String mode,Connection c)throws Exception
    {
        int rep=0;
        String req = "SELECT idmodepaiement from modepaiement where idpaiement=?";
        PreparedStatement preparar=null;
        preparar=c.prepareStatement(req,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        preparar.setString(1, mode);
        ResultSet res = preparar.executeQuery();
        while(res.next())
        {
               rep=res.getInt(1);
        }
        return rep;
    }
    public ModePaiement[] getModePaiements(Connection c)throws Exception
    {
            int j=0;
            String req = "SELECT * from modepaiement";
            PreparedStatement preparar=null;
            preparar=c.prepareStatement(req,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet res = preparar.executeQuery();
            res.last();
            int count = res.getRow();
            ModePaiement[] rep=new ModePaiement[count];
            for(int i=0;i<rep.length;i++)
            {
                rep[i]=new ModePaiement();
            }
            res.beforeFirst();
            while(res.next())
            {
                    rep[j].setIdmodepaiement(res.getInt(1));
                    rep[j].setDesignation(res.getString(2));
                    j++;
            }
            return rep;
    }
}
