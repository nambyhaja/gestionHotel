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
                        <form role="form" method="post" action="chambreModifie.jsp">
                            <h3>Modification de chambre</h3>
                            <hr class="colorgraph">
                            <%
                                    ConnexionJDBC e=new ConnexionJDBC();
                                    String numeroChambre=request.getParameter("numerochambre");
                                    Chambre c = e.getChambreByNumero(e.getConnPostgre(),numeroChambre);
                                    Categorie[] cat = e.appelGetCateg();
                            %>
                                 <input type="hidden" name="numancient" id="numchamb" class="form-control input-lg" value="<% out.print(numeroChambre); %>" required/>
                            <div class="form-group">
                                <label>Cat&eacute;gorie de la chambre :</label>
                                 <select class="form-control" name="categorie">
                                    <option class="form-control input-lg" value="<% out.print(c.getNomcategorie()); %>">
                                        <% out.print(c.getNomcategorie()); %>
                                    </option>
                                     <% for(int i=1;i<cat.length;i++){
                                         if(c.getNomcategorie().compareTo(cat[i].getNomcategorie())!=0)
                                         {
                                     %>
                                    <option class="form-control input-lg" value="<% out.print(cat[i].getNomcategorie()); %>">
                                        <% out.print(cat[i].getNomcategorie()); %>
                                    </option>
                                <% }
                                } %>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>Num&eacute;ro de la chambre:</label>
                                <input type="text" name="numchamb" id="numchamb" class="form-control input-lg" value="<% out.print(c.getNumero()); %>" required/>
                            </div>
                            <div class="form-group">
                                 <label>Nombre de lits:</label>
                                <input type="text" name="nombrelits" id="nombrelits" class="form-control input-lg" value="<% out.print(c.getLits()); %>" required/>
                            </div>
                            <div class="form-group">
                                  <label>Nombre de places:</label>
                                <input type="text" name="nombreplaces" id="nombreplaces" class="form-control input-lg" value="<% out.print(c.getPlaces()); %>" required/>
                            </div>
                            <div class="form-group">
                                  <label>Prix:</label>
                                 <input type="text" name="prix" id="prix" class="form-control input-lg"value="<% out.print(c.getPrix()); %>" required/>
                            </div>
                            <div class="row">
                                    <div class="col-xs-12 col-sm-12 col-md-12">
                                            <input type="submit" id="buttoninscription" value="Modifier" class="btn btn-lg btn-primary btn-block">
                                    </div>
                            </div>
                        </form>
                    </div>
		</div><!--/.row-->
                </br>
		<jsp:include page="footer.jsp" />
</body>
</html>
