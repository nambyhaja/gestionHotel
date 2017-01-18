/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import mapping.FactureFille;
import mapping.FactureMere;

/**
 *
 * @author nambi
 */
public class FactureJDBC {
    private ConnexionJDBC con=new ConnexionJDBC();
    public void insertFactureMere(FactureMere fm,Connection c)throws Exception
    {
        int val=0;
        PreparedStatement preparar1=null;
        ConnexionJDBC con=new ConnexionJDBC();
        try
        {
            String requete1="insert into facturemere (idclient,dateecheancepaiement,TVA) values(?,?,?);";
            preparar1=c.prepareStatement(requete1);
            preparar1.setInt(1,fm.getIdclient());
            preparar1.setDate(2,fm.getDateecheancepaiement());
            preparar1.setDouble(3,fm.getTva());
            preparar1.executeUpdate();
            
        }
        catch(Exception e)
        {
            throw new Exception("Insertion non faite");
        }
    }
    public void insertFactureFille(FactureFille f,Connection c)throws Exception
    {
        int val=0;
        PreparedStatement preparar1=null;
        ConnexionJDBC con=new ConnexionJDBC();
        try
        {
            String requete1="insert into facturefille (idchambre,idfacture,remise) values(?,?,1);";
            preparar1=c.prepareStatement(requete1);
            preparar1.setInt(1,f.getIdchambre());
            preparar1.setInt(2,f.getIdfacture());
            preparar1.setDouble(3,f.getRemise());
            preparar1.executeUpdate();
            
        }
        catch(Exception e)
        {
            throw new Exception("Insertion non faite");
        }
    }
}
