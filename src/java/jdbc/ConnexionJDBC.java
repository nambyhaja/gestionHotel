/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

/**
 *
 * @author nambi
 */
import mapping.*;
import java.sql.*;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
// import maping.MapingArbre;

public class ConnexionJDBC
{
	public Connection getConnPostgre() throws Exception
	{
		Class.forName("org.postgresql.Driver");
		Connection conn =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotel","postgres", "namby");
		return conn;
	}
	public int getRows(String nomTable,Connection c)throws Exception
	{
		String req = "SELECT Count(*) FROM "+nomTable;
		Statement stmt = c.createStatement();
		ResultSet res = stmt.executeQuery(req);
		int val=0;
		Integer i;
		while(res.next())
		{
			i=Integer.parseInt(res.getString(1));
			val=i;
		}
		return val;
	}
        public int getIdByNomCategorie(String nomcat, Connection c)throws Exception
	{
		String req = "SELECT idcategorie FROM categorie where nomcategorie='"+nomcat+"'";
		Statement stmt = c.createStatement();
		ResultSet res = stmt.executeQuery(req);
		int val=0;
		Integer i;
		while(res.next())
		{
			i=Integer.parseInt(res.getString(1));
			val=i;
		}
		return val;
	}
        public int getIdByNumChambre(String num, Connection c)throws Exception
	{
		String req = "SELECT idchambre FROM chambre where numero='"+num+"'";
		Statement stmt = c.createStatement();
		ResultSet res = stmt.executeQuery(req);
		int val=0;
		Integer i;
		while(res.next())
		{
			i=Integer.parseInt(res.getString(1));
			val=i;
                }
                if(val==0)
                {
                    throw new Exception("Num&eacute;ro de chambre inexistante");
                }
		return val;
	}
        public int getMaxId(String nomTable,String nomColonneId,Connection c)throws Exception
        {  
            int val=0;
            String req = "SELECT max("+nomColonneId+") FROM "+nomTable;
            Statement stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            Integer i;
            while(res.next())
            {
                    i=Integer.parseInt(res.getString(1));
                     val=i; 
                   
            }
            return val+1;
        }   
       public int insertCategorie(Categorie cat,Connection c)throws Exception
        {
        int val=0;
        PreparedStatement preparar=null;
        try
        {
            String requete="insert into categorie (nomcategorie) values(?);";
            preparar=c.prepareStatement(requete);
            preparar.setString(1,cat.getNomcategorie());
            preparar.executeUpdate();
            return val;
        }
            catch(Exception e)
            {

            }
        return val;
        }
      
      
       public Categorie[] getCategories(Connection c) throws SQLException, Exception
       {
           
            int j=0;
            String req = "SELECT * FROM categorie";
            Statement stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            ConnexionJDBC con=new ConnexionJDBC();
            Categorie[] rep=new Categorie[con.getRows("categorie", c)];
            for(int i=0;i<rep.length;i++)
            {
                rep[i]=new Categorie();
            }
            while(res.next())
            {
                    rep[j].setIdcategorie(res.getLong(1));
                    rep[j].setNomcategorie(res.getString(2));
                    j++;
            }
            
            return rep;
       }
       public Categorie getCategorieById(Connection c, String id)throws Exception
       {
           Categorie rep=new Categorie();
           String req = "SELECT * FROM categorie where idcategorie="+id;
		Statement stmt = c.createStatement();
		ResultSet res = stmt.executeQuery(req);
		int val=0;
		while(res.next())
		{
			rep.setIdcategorie(res.getLong(1));
                        rep.setNomcategorie(res.getString(2));
                        val=1;
                }
                if(val==0)
                {
                    throw new Exception("Categorie inexistante");
                }
           return rep;
       }
       public int modifierCategorie(Connection c,String idcategorie,String nomcategorie) throws Exception
       {
        int val=0;
        int id=Integer.parseInt(idcategorie);
        PreparedStatement preparar2=null;
        ConnexionJDBC con=new ConnexionJDBC();
        try
        {
            String requete2="update categorie SET nomcategorie=? WHERE idcategorie=?;";
            preparar2=c.prepareStatement(requete2);
            preparar2.setString(1,nomcategorie);
            preparar2.setInt(2,id);
            preparar2.executeUpdate();
            return val;
        }
            catch(Exception e)
            {
                val=-1;
                throw new Exception("Erreur de modification");
                      
            }
        
       }
        public void appelInsertionCategorie(String nomcat)
       {
            ConnexionJDBC e=new ConnexionJDBC();
            try ( Connection c = e.getConnPostgre()) {
               Categorie cat= new Categorie(nomcat);
                int i=e.insertCategorie(cat, c);
                }
                catch (Exception e1)
                {
                }
       }
       public Categorie[] appelGetCateg()
       {
            ConnexionJDBC e=new ConnexionJDBC();
            try ( Connection c = e.getConnPostgre()) {
              Categorie[] cat = e.getCategories(c);
             
              return cat;
            }catch (Exception e1)
            {
                return null;
            }
            
       }
        public void deleteCategorie(String id,Connection c)throws Exception
        {
            int idcategorie=Integer.parseInt(id);
            PreparedStatement preparar1=null;
            try
            {
                String requete1="delete from categorie WHERE idcategorie=?";
                preparar1=c.prepareStatement(requete1);
                preparar1.setLong(1,idcategorie);
                preparar1.executeUpdate();
                
            }
            catch(Exception e)
            {
                  throw new Exception("Vous ne pouvez pas supprimer cette cat&eacute;gorie car des chambres y sont li&eacute;es");
            }
        }
      
       
                //<----------------------->//
//<--------------------MOMBA NY PRIX-----------------//
                 //<----------------------->//
       public Prix getPrixMaxDate(Connection c,long idChambre)throws Exception
       {
            Prix rep=new Prix();
           PreparedStatement preparar=null;
            String req = "select * from historiqueprix where idchambre=? order by date desc limit 1";
            preparar=c.prepareStatement(req);
            preparar.setLong(1, idChambre);
            ResultSet res = preparar.executeQuery();
            while(res.next())
            {
                    rep.setIdprix(res.getInt(1));
                    rep.setIdchambre(res.getInt(2));
                    rep.setDate(res.getDate(3));
                    rep.setPrix(res.getInt(4));
            }
            return rep;
       }
        public Prix getPrixByIdChambre(int idchambre,Connection c)throws Exception
        {
            Prix rep=new Prix();
           PreparedStatement preparar=null;
            String req = "select * from prixactuel where idchambre=?";
            preparar=c.prepareStatement(req);
            preparar.setLong(1, idchambre);
            ResultSet res = preparar.executeQuery();
            while(res.next())
            {
                    rep.setIdprix(res.getInt(1));
                    rep.setPrix(res.getInt(2));
                    rep.setIdchambre(res.getInt(3));
            }
            return rep;
            
        }
        public int insertPrix(int idchambre, Prix p,Connection c)throws Exception
        {
        int val=0;
        PreparedStatement preparar2=null;
        ConnexionJDBC con=new ConnexionJDBC();
        Prix pactuel=getPrixByIdChambre(idchambre, c);
        if(p.getPrix()==pactuel.getPrix())
        {
           System.out.println("mitov prix");
        }
        else
        {
            try
            {
                String requete2="insert into historiqueprix (idchambre,date,prix) values(?,NOW(),?);";
                preparar2=c.prepareStatement(requete2);
                preparar2.setLong(1,p.getIdchambre());
                preparar2.setFloat(2, p.getPrix());
                preparar2.executeUpdate();
                return val;
            }
            catch(Exception e)
            {
                      throw new Exception("Insertion non faite");
            }
        }
       return 1;
        }
        public int insertPrix(Prix p,Connection c)throws Exception
        {
        int val=0;
        PreparedStatement preparar2=null;
        ConnexionJDBC con=new ConnexionJDBC();
        
            try
            {
                String requete2="insert into historiqueprix (idchambre,date,prix) values(?,NOW(),?);";
                preparar2=c.prepareStatement(requete2);
                preparar2.setLong(1,p.getIdchambre());
                preparar2.setFloat(2, p.getPrix());
                preparar2.executeUpdate();
                return val;
            }
            catch(Exception e)
            {
                      throw new Exception("Insertion non faite");
            }
        }
       
        
        public int insertPrixActuel(Prix p,Connection c)throws Exception
        {
            int val=0;
            PreparedStatement preparar2=null;
            try
            {
                String requete2="insert into prixactuel (prixactuel,idchambre) values(?,?);";
                preparar2=c.prepareStatement(requete2);
                preparar2.setFloat(1, p.getPrix());
                preparar2.setLong(2,p.getIdchambre());
                preparar2.executeUpdate();
                return val;
            }
            catch(Exception e)
            {
                      throw new Exception("Insertion non faite");
            }
       
        }
        public int updatePrixActuel(Prix p,Connection c,int idChambre)throws Exception
        {
        int val=0;
        PreparedStatement preparar2=null;
        ConnexionJDBC con=new ConnexionJDBC();
        try
        {
            String requete2="update prixactuel SET prixactuel=? WHERE idchambre=?;";
            preparar2=c.prepareStatement(requete2);
            preparar2.setFloat(1,p.getPrix());
            preparar2.setLong(2,idChambre);
            preparar2.executeUpdate();
            return val;
        }
            catch(Exception e)
            {
                      e.printStackTrace();
                      val=-1;
            }
        return val;
        }
        public int modifierPrixByIdChambre(Prix p,Connection c,int idChambre)throws Exception
        {
        int val=0;
        PreparedStatement preparar2=null;
        ConnexionJDBC con=new ConnexionJDBC();
        try
        {
            String requete2="update historiqueprix SET prix=? WHERE idchambre=?;";
            preparar2=c.prepareStatement(requete2);
            preparar2.setFloat(1,p.getPrix());
            preparar2.setLong(2,idChambre);
            preparar2.executeUpdate();
            return val;
        }
            catch(Exception e)
            {
                      e.printStackTrace();
                      val=-1;
            }
        return val;
        }
         public int deletePrixActuel(int idChambre,Connection c)throws Exception
        {
            int val=0;
            PreparedStatement preparar1=null;
            try
            {
                String requete1="delete from prixactuel WHERE idchambre=?";
                preparar1=c.prepareStatement(requete1);
                preparar1.setLong(1,idChambre);
                preparar1.executeUpdate();
                return val;
            }
                catch(Exception e)
                {
                    e.printStackTrace();
                    val=-1;
                }
            return val;
        }
          public int deleteHistoriquePrix(int idChambre,Connection c)throws Exception
        {
            int val=0;
            PreparedStatement preparar1=null;
            try
            {
                String requete1="delete from historiqueprix WHERE idchambre=?";
                preparar1=c.prepareStatement(requete1);
                preparar1.setLong(1,idChambre);
                preparar1.executeUpdate();
                return val;
            }
                catch(Exception e)
                {
                    e.printStackTrace();
                    val=-1;
                }
            return val;
        }
       
                //<----------------------->//
//<--------------------MOMBA NY CHAMBRE-----------------//
                 //<----------------------->//
        public int insertChambre(Chambre ch,Connection c)throws Exception
        {
        int val=0;
        PreparedStatement preparar1=null;
        ConnexionJDBC con=new ConnexionJDBC();
        try
        {
            String requete1="insert into chambre (idcategorie,numero,lits,places) values(?,?,?,?);";
            preparar1=c.prepareStatement(requete1);
            preparar1.setLong(1,ch.getIdcategorie());
            preparar1.setString(2,ch.getNumero());
            preparar1.setInt(3,ch.getLits());
            preparar1.setInt(4,ch.getPlaces());
            preparar1.executeUpdate();
            return val;
        }
            catch(Exception e)
            {
                e.printStackTrace();
                val=-1;
            }
        return val;
        }
        public void appelInsertChambre(String numero,short lits,short places,String cat,String prix)throws Exception
       {
           ConnexionJDBC e=new ConnexionJDBC();
            Connection c = e.getConnPostgre();
              int idcat=e.getIdByNomCategorie(cat, c);
              Chambre ch=new Chambre( numero, lits, places, idcat);
              Prix pr;
               long p=Long.parseLong(prix);
              e.insertChambre(ch,c);
              int maxChambre=0;
              maxChambre=e.getMaxId("chambre","idchambre", c)-1;
              System.out.println(maxChambre);
               pr = new Prix(maxChambre,p);
              e.insertPrix(pr,c);
            
       }
        public void modifierChambre(Connection c,Chambre ch,String numAncient)throws Exception
       {
        int val=0;
        PreparedStatement preparar1=null;
        ConnexionJDBC con=new ConnexionJDBC();
        try
        {
            String requete1="update chambre SET idcategorie=?,numero=?,lits=?,places=? WHERE numero=?;";
            preparar1=c.prepareStatement(requete1);
            preparar1.setLong(1,ch.getIdcategorie());
            preparar1.setString(2,ch.getNumero());
            preparar1.setInt(3,ch.getLits());
            preparar1.setInt(4,ch.getPlaces());
             preparar1.setString(5,numAncient);
            preparar1.executeUpdate();
        }
            catch(Exception e)
            {
                throw new Exception("Il existe un chambre identique à celle-ci");
            }
        
       }
        public void appelModifierChambre(String numero,short lits,short places,String cat,String prix,String numAncient)throws Exception
       {
           ConnexionJDBC e=new ConnexionJDBC();
            Connection c = e.getConnPostgre();
            
              int idcat=e.getIdByNomCategorie(cat, c);
              Chambre ch=new Chambre( numero, lits, places, idcat);
              e.modifierChambre(c, ch, numAncient);
               int idchambre=e.getIdByNumChambre(numero, c);
              Prix pr;
             
              float p=Float.parseFloat(prix);
              System.out.println(p);
              pr = new Prix(idchambre,p);
              //System.out.println(idchambre);
              //int a=e.modifierPrixByIdChambre(pr,c,idchambre);
              e.insertPrix(idchambre,pr, c);
              e.updatePrixActuel(pr, c,idchambre);
       }
        public int deleteChambreCascade(int idChambre,Connection c)throws Exception
        {
            int val=0;
            PreparedStatement preparar1=null;
            try
            {
                String requete1="delete from chambre WHERE idchambre=?";
                preparar1=c.prepareStatement(requete1);
                preparar1.setLong(1,idChambre);
                preparar1.executeUpdate();
                return val;
            }
            catch(Exception e)
            {
                val=-1;
                throw new Exception("Vous ne pouvez pas supprimer cette chambre car d'autres données sont liées avec.");
            }
        }
        public int deleteChambre(int idChambre,Connection c)throws Exception
        {
            int val=0;
            PreparedStatement preparar1=null;
            try
            {
                String requete1="update chambre SET supprime=TRUE WHERE idchambre=?;";
                preparar1=c.prepareStatement(requete1);
                preparar1.setLong(1,idChambre);
                preparar1.executeUpdate();
                return val;
            }
            catch(Exception e)
            {
                val=-1;
                throw new Exception("Vous ne pouvez pas supprimer cette chambre car d'autres données sont liées avec.");
            }
        }
       public Chambre[] getChambres(Connection c) throws SQLException, Exception
       {
           
            int j=0;
            String req = "select chambre.idchambre,chambre.numero,categorie.nomcategorie,chambre.lits,chambre.places from chambre "
                    + "join categorie on categorie.idcategorie=chambre.idcategorie ";
            Statement stmt = c.createStatement();
            ResultSet res = stmt.executeQuery(req);
            ConnexionJDBC con=new ConnexionJDBC();
            Chambre[] rep=new Chambre[con.getRows("chambre", c)];
            for(int i=0;i<rep.length;i++)
            {
                rep[i]=new Chambre();
            }
            while(res.next())
            {
                     rep[j].setIdchambre(res.getInt(1));
                    rep[j].setNumero(res.getString(2));
                    rep[j].setNomcategorie(res.getString(3));
                    rep[j].setLits(res.getShort(4));
                    rep[j].setPlaces(res.getShort(5));
                    j++;
            }
            
            return rep;
       }
       public Chambre[] getChambresWithPrix(Connection c)throws Exception
       {
           int j=0;
            String req = "SELECT chambre.idchambre,chambre.numero,categorie.nomcategorie,chambre.lits,chambre.places,prixactuel.prixactuel FROM chambre "
                    + "join categorie on categorie.idcategorie=chambre.idcategorie join prixactuel on chambre.idchambre=prixactuel.idchambre where chambre.supprime=FALSE";
            PreparedStatement preparar=null;
            preparar=c.prepareStatement(req,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet res = preparar.executeQuery();
            res.last();
            int count = res.getRow();
            Chambre[] rep=new Chambre[count];
            for(int i=0;i<rep.length;i++)
            {
                rep[i]=new Chambre();
            }
            res.beforeFirst();
            while(res.next())
            {
                    rep[j].setIdchambre(res.getInt(1));
                    rep[j].setNumero(res.getString(2));
                    rep[j].setNomcategorie(res.getString(3));
                    rep[j].setLits(res.getShort(4));
                    rep[j].setPlaces(res.getShort(5));
                    rep[j].setPrix(res.getFloat(6));
                    j++;
            }
            return rep;
       }
       public Chambre getChambreByNumero(Connection c,String numero) throws SQLException, Exception
       {
           Chambre rep=new Chambre();
           PreparedStatement preparar=null;
            String req = "select chambre.idchambre,chambre.numero,categorie.nomcategorie,chambre.lits,chambre.places,historiqueprix.date,historiqueprix.prix from chambre "
                    + "join categorie on categorie.idcategorie=chambre.idcategorie "
                    + "join historiqueprix on chambre.idchambre=historiqueprix.idchambre where chambre.numero=? order by date ASC";
            preparar=c.prepareStatement(req);
            preparar.setString(1, numero);
            ResultSet res = preparar.executeQuery();
            while(res.next())
            {
                rep.setIdchambre(res.getInt(1));
                rep.setNumero(res.getString(2));
                rep.setNomcategorie(res.getString(3));
                rep.setLits(res.getShort(4));
                rep.setPlaces(res.getShort(5));
                rep.setDate(res.getDate(6));
                rep.setPrix(res.getInt(7));
            }
            
            return rep;
       }
       public int appelDeleteChambre(String chambre,Connection c)throws Exception
       {
           int val=0;
           int idChambre=0;
           ConnexionJDBC e=new ConnexionJDBC();
           idChambre=e.getIdByNumChambre(chambre, c);
           //val=e.deletePrixActuel(idChambre, c);
           //val=deleteHistoriquePrix(idChambre,c);
           val=e.deleteChambre(idChambre, c);
            return val;
            
       }
        public int appelDeleteChambreCascade(String chambre,Connection c)throws Exception
       {
           int val=0;
           int idChambre=0;
           ConnexionJDBC e=new ConnexionJDBC();
           idChambre=e.getIdByNumChambre(chambre, c);
           //val=e.deletePrixActuel(idChambre, c);
           //val=deleteHistoriquePrix(idChambre,c);
           val=e.deleteChambreCascade(idChambre, c);
            return val;
            
       }
        public Chambre[] appelGetChambres()
       {
            ConnexionJDBC e=new ConnexionJDBC();
            try ( Connection c = e.getConnPostgre()) {
                Chambre[] rep=new Chambre[e.getRows("chambre", c)];
                rep=e.getChambres(c);
                return rep;
                }
                catch (Exception e1)
                {
                    return null;
                }
       }
       public Chambre[] getChambresSearch(Connection c,String nomColonne,String valeur) throws SQLException, Exception
       {
           
            int j=0;
            String req="";
            
            if(nomColonne.compareTo("numero")==0)
            {
                 
            req = "select chambre.numero,categorie.nomcategorie,chambre.lits,chambre.places,prix.date,prix.prix from chambre "
                    + "join categorie on categorie.idcategorie=chambre.idcategorie "
                    + "join prix on chambre.idchambre=prix.idchambre where chambre.numero ilike '%"+valeur+"%'  ";
            }
             if(nomColonne.compareTo("nomcategorie")==0)
            {
             
            req = "select chambre.numero,categorie.nomcategorie,chambre.lits,chambre.places,prix.date,prix.prix from chambre "
                    + "join categorie on categorie.idcategorie=chambre.idcategorie "
                    + "join prix on chambre.idchambre=prix.idchambre where categorie.nomcategorie ilike '%"+valeur+"%' ";
            }
              if(nomColonne.compareTo("lits")==0)
            {
            req = "select chambre.numero,categorie.nomcategorie,chambre.lits,chambre.places,prix.date,prix.prix from chambre "
                    + "join categorie on categorie.idcategorie=chambre.idcategorie "
                    + "join prix on chambre.idchambre=prix.idchambre where chambre.lits="+valeur;
            }
               if(nomColonne.compareTo("places")==0)
            {
            req = "select chambre.numero,categorie.nomcategorie,chambre.lits,chambre.places,prix.date,prix.prix from chambre "
                    + "join categorie on categorie.idcategorie=chambre.idcategorie "
                    + "join prix on chambre.idchambre=prix.idchambre where chambre.places="+valeur;
            }
                if(nomColonne.compareTo("date")==0)
            {
            req = "select chambre.numero,categorie.nomcategorie,chambre.lits,chambre.places,prix.date,prix.prix from chambre "
                    + "join categorie on categorie.idcategorie=chambre.idcategorie "
                    + "join prix on chambre.idchambre=prix.idchambre where prix.date="+valeur;
            }
                 if(nomColonne.compareTo("prix")==0)
            {
            req = "select chambre.numero,categorie.nomcategorie,chambre.lits,chambre.places,prix.date,prix.prix from chambre "
                    + "join categorie on categorie.idcategorie=chambre.idcategorie "
                    + "join prix on chambre.idchambre=prix.idchambre where CAST(prix.prix as TEXT) like '%"+valeur+"%'" ;
            }
            Statement stmt = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            ResultSet res = stmt.executeQuery(req);
            res.last();
            int count = res.getRow();
            Chambre[] rep=new Chambre[count];
            for(int i=0;i<rep.length;i++)
            {
                rep[i]=new Chambre();
            }
            res.beforeFirst();
            while(res.next())
            {
                    rep[j].setNumero(res.getString(1));
                    rep[j].setNomcategorie(res.getString(2));
                    rep[j].setLits(res.getShort(3));
                    rep[j].setPlaces(res.getShort(4));
                    rep[j].setDate(res.getDate(5));
                    rep[j].setPrix(res.getFloat(6));
                    j++;
            }
            
            return rep;
       }
	public static void main(String[] x)
	{
		
			ConnexionJDBC e=new ConnexionJDBC();
			
                    try ( //Test Postgresql
                            Connection c = e.getConnPostgre()) {
                        ReservationJDBC r=new ReservationJDBC();
                         DetailReservation[] res;
                                  res=r.getDetailsReservationsById("1",c);
                                  for(int i=0;i<res.length;i++)
                        {
                                System.out.println("numero : "+res[i].getIddetaireservation());
                                System.out.println("nomcategorie :"+res[i].getChambre().getNumero());
                                System.out.println("lits : "+res[i].getChambre().getLits());
                                System.out.println("places : "+res[i].getChambre().getPlaces());
                                System.out.println("prix : "+res[i].getDateconfirmationdetail());
                                System.out.println("prix : "+res[i].getConfirme());
                                System.out.println(" -----------------------------------x-------------------------------------");
                                
                            
                        }
                        System.out.println("sdfgh");
                        //e.appelModifierChambre("D002", Short.parseShort("1"), Short.parseShort("2"),"double","80000.0","D005");
                       //e.modifierCategorie(c, "2", "doubless");
                      /* Prix p=e.getPrixMaxDate(c,16);
                       System.out.println(p.getIdchambre());
                       System.out.println(p.getDate());
                       System.out.println(p.getIdprix());
                       System.out.println(p.getPrix());*/
                        /*Prix pr;stem.out.println(p.getIdchambre()t);
                        long p=Long.parseLong("125000");
                             pr = new Prix(p);
                        e.modifierPrixByIdChambre(pr, c,6);*/
                        /* EXEMPLE POUR GETROWS ou taille
                        int i=e.getRows("test",c);
                        System.out.println(i);*/
                        
                        /* EXEMPLE POUR GETMAXID
                        int i=e.getMaxId("categorie","idcategorie",c);
                        System.out.println(i);*/
                        
                        /*int max=0;
                        max=e.getMaxId("categorie","idcategorie", c);
                        Categorie cat= new Categorie(max, "Grand familial");
                        int i=e.insertCategorie(cat, c);*/
                        /*int i=e.getIdByNomCategorie("double",c);
                        System.out.println(i);*/
                        
                        /*EXEMPLE INSERT CHAMBRE
                        e.appelInsertChambre("F004",Short.parseShort("2"),Short.parseShort("4"),"Familial","150000");
                        */
                        /*Chambre[] rep=e.getChambresSearch(c,"","");
                        for(int i=0;i<rep.length;i++)
                        {
                            System.out.println("numero : "+rep[i].getNumero());
                             System.out.println("nomcategorie :"+rep[i].getNomcategorie());
                              System.out.println("lits : "+rep[i].getLits());
                               System.out.println("places : "+rep[i].getPlaces());
                                System.out.println("prix : "+rep[i].getPrix());
                                System.out.println("prix : "+rep[i].getDate());
                                System.out.println(" -----------------------------------x-------------------------------------");
                                
                            
                        }*/
                        
                    }
			catch (Exception e1)
			{
				e1.printStackTrace();
			}
			
	}
}