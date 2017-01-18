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
                        <form role="form" method="post" action="detailfacturation.jsp">
                            <h3>Facturation</h3>
                            <hr class="colorgraph">
                           
                             
                               
                            <div class="form-group">
                                <label>Client :</label>
                                <%
                                    ConnexionJDBC e=new ConnexionJDBC();
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
                                 <input type="text" name="prix" id="prix" class="form-control input-lg" value="20" required/>
                            </div>
                            <div class="form-group">
                                  <label>Date &eacute;ch&eacute;ance : </label>
                                 <input type="text" name="prix" id="prix" class="form-control input-lg" placeholder="dd-mm-yyyy" required/>
                            </div>
                            <div class="row">
                                    <div class="col-xs-12 col-sm-12 col-md-12">
                                            <input type="submit" id="buttoninscription" value="Facturer" class="btn btn-lg btn-primary btn-block">
                                    </div>
                            </div>
                        </form>
                    </div>
		</div><!--/.row-->
                </br>
		<jsp:include page="footer.jsp" />
</body>
</html>
