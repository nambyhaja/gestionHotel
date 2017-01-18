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
import mapping.Reservation;

/**
 *
 * @author nambi
 */
public class ChambreJDBC {
    private ConnexionJDBC con=new ConnexionJDBC();
   /* public Chambre[] getChambresReserves(Reservation r,Connection c)throws Exception
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
                       rep[j].setCin(res.getDouble(5));
                    j++;
            }
            return rep;
    }*/
}
