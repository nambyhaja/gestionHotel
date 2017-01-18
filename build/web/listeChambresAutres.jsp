<%@page import="java.sql.Connection"%>
<%@page import="mapping.Chambre"%>
<%@ page import="jdbc.ConnexionJDBC" %>
<%@ page import="mapping.Categorie" %>
<jsp:include page="header.jsp" />
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">	
		
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Tableau de bord</h1>
			</div>
		</div><!--/.row-->
		
		<div class="row">
                    <div class="col-xs-12 col-md-12 col-lg-12">
                        <form role="form" method="post" action="listeChambres.jsp">
                            <h3>Liste de chambres avec recherche</h3>
                            <hr class="colorgraph">
                           
                            <div class="form-group">
                                <label>Choix des critères</label>
                                <select class="form-control" name="type">
                                    <option class="form-control input-lg" value="nomcategorie">Categorie</option>
                                    <option class="form-control input-lg" value="numero">Num&eacute;ro de la chambre</option>
                                    <option class="form-control input-lg" value="lits">Nombre de lits</option>
                                    <option class="form-control input-lg" value="places">Nombre de places</option>
                                    <option class="form-control input-lg" value="prix">Prix</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Mots-clés</label>
                                <input type="text" name="motscles" id="numchamb" class="form-control input-lg" placeholder="" required/>
                            </div>
                            <div class="form-group">
                                <button type="submit" class="btn btn-default">Rechercher</button>
                            </div>
                        </form>
                        <table class="table table-striped">
                          
                                <%
                                    String nomColonne=request.getParameter("type");
                                    String motsCles=request.getParameter("motscles");
                                    out.print(nomColonne);
                                    out.print(motsCles);
                                    Chambre[] rep;
                                    ConnexionJDBC e=new ConnexionJDBC();
                                    try ( Connection c = e.getConnPostgre()) {
                                        
                                    if(nomColonne==null)
                                    {
                                        rep=e.getChambres(c);
                                    }
                                    else
                                    {
                                        rep=e.getChambresSearch(c,nomColonne,motsCles);
                                    }
                                        
                                        
                                %>
                           
                        <thead>
                          <tr>
                            <th>Numero de chambre</th>
                            <th>Nom de cat&eacute;gorie</th>
                            <th>Nombre de lits</th>
                            <th>Nombres de places</th>
                            <th>Date</th>
                            <th>Prix</th>
                          </tr>
                        </thead>
                        <tbody>
                            <%
                                for(int i=0;i<rep.length;i++)
                                {
                               %>
                          <tr>
                            <td><% out.print(rep[i].getNumero()); %></td>
                            <td><% out.print(rep[i].getNomcategorie()); %></td>
                            <td><% out.print(rep[i].getLits()); %></td>
                            <td><% out.print(rep[i].getPlaces()); %></td>
                            <td><% out.print(rep[i].getDate()); %></td>
                            <td><% out.print(rep[i].getPrix()); %></td>
                          </tr>
                          <%
                              }
                          %>
                        </tbody>
                      </table>
                        <%
                        }
                                        catch (Exception e1)
                                        {
                                            
                                        }
                           %>
                    </div>
		</div><!--/.row-->
                </br>
		<jsp:include page="footer.jsp" />
</body>
</html>
