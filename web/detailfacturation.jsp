<%@page import="jdbc.ClientJDBC"%>
<%@page import="mapping.Client"%>
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
                    <div class="col-xs-12 col-md-6 col-lg-6">
                        <form role="form" method="post" action="chambreInsere.jsp">
                            <h3>Facturation</h3>
                            <hr class="colorgraph">
                           
                            <div class="form-group">
                                <label>Chambre occup&eacute; :</label>
                                <%
                                    ConnexionJDBC e=new ConnexionJDBC();
                                   Chambre[] ch = e.getChambres(e.getConnPostgre());
                                %>
                                <select multiple class="form-control" name="categorie">
                                <% for(int i=0;i<ch.length;i++){ %>
                                    <option class="form-control input-lg" value="<% out.print(ch[i].getNumero()); %>"><% out.print(ch[i].getNumero()); %></option>
                                <% } %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Client :</label>
                                <%
                                    ClientJDBC cldb=new ClientJDBC();
                                   Client[] cl = cldb.getClients(e.getConnPostgre());
                                %>
                                <select class="form-control" name="categorie">
                                <% for(int i=0;i<cl.length;i++){ %>
                                    <option class="form-control input-lg" value="<% out.print(cl[i].getNomclient()+" "+cl[i].getPrenomsclient()); %>"><% out.print(cl[i].getNomclient()+" "+cl[i].getPrenomsclient()); %></option>
                                <% } %>
                                </select>        
                            </div>
                            <div class="form-group">
                                  <label>TVA : </label>
                                 <input type="text" name="prix" id="prix" class="form-control input-lg" value="0.02" required/>
                            </div>
                            <div class="form-group">
                                  <label>Date &eacute;ch&eacute;ance : </label>
                                 <input type="text" name="prix" id="prix" class="form-control input-lg" placeholder="dd-mm-yyyy" required/>
                            </div>
                            <div class="row">
                                    <div class="col-xs-12 col-sm-12 col-md-12">
                                            <input type="submit" id="buttoninscription" value="Ins&eacute;rer" class="btn btn-lg btn-primary btn-block">
                                    </div>
                            </div>
                        </form>
                         <table class="table table-striped">
                        <thead>
                          <tr>
                              <th>Id chambre</th>
                            <th>Numero de chambre</th>
                            <th>Nom de cat&eacute;gorie</th>
                            <th>Nombre de lits</th>
                            <th>Nombres de places</th>
                            <th>Prix</th>
                            <th>Modification</th>
                            <th>Suppression</th>
                          </tr>
                        </thead>
                        <tbody ng-repeat="c in chambres | filter:filtreChambre">
                          <tr>
                              <td>{{c.idchambre}}</td>
                            <td>{{c.numero}}</td>
                            <td>{{c.nomcategorie}}</td>
                            <td>{{c.lits}}</td>
                            <td>{{c.places}}</td>
                            <td>{{c.prix}}</td>
                            <td><a href="modificationChambre.jsp?numerochambre={{c.numero}}">Modifier</a></td>
                            <td><a href="chambreSupprime.jsp?numerochambre={{c.numero}}">Supprimer</a></td>
                            
                          </tr>
                        </tbody>
                      </table>       
                         
                    </div>
		</div><!--/.row-->
                </br>
		<jsp:include page="footer.jsp" />
</body>
</html>
