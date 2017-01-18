
<%@page import="jdbc.ReservationJDBC"%>
<%@page import="mapping.Client"%>
<script type="text/javascript" src="bootstrap/js/angular.min.js"></script>	
<%@page import="java.sql.Connection"%>
<%@page import="mapping.Chambre"%>
<%@ page import="jdbc.ConnexionJDBC" %>
<%@page import="mapping.DetailReservation"%>
<%@ page import="mapping.Categorie" %>
<jsp:include page="header.jsp" />

		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main" ng-app="myApp" ng-controller="myControl">	
		<% 
                                    String idreservation=request.getParameter("idreservation");
                                    ConnexionJDBC e=new ConnexionJDBC();
                                    ReservationJDBC r=new ReservationJDBC();
                                    try ( Connection c = e.getConnPostgre()) {
                                        Client cl=new Client();
                                        cl=r.getClientByIdReserv(idreservation,c);
                                        DetailReservation[] rep;
                                        rep=r.getDetailsReservationsById(idreservation, c);

%>
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header">Tableau de bord</h1>
			</div>
		</div><!--/.row-->
		
		<div class="row">
                    <div class="col-xs-12 col-md-12 col-lg-12">
                        <form role="form" method="post" action="listeChambres.jsp">
                            <h3>Liste de r&eacute;servations</h3>
                            <div class="form-group">
                                <label>Détail de reservation pour le client : <% out.print(cl.getNomclient()); %> <% out.print(cl.getPrenomsclient()); %></label>
                                <label>CIN : <% out.print(cl.getCin()); %></label>
                            </div>
                            
                        </form>
                        <table class="table table-striped">
                        <thead>
                          <tr>
                            <th>Id detail</th>
                            <th>Numéro de chambre</th>
                            <th>Nombres de lits</th>
                            <th>Nombre de places</th>
                            <th>Date de confirmation</th>
                            <th>Confirmé</th>
                          </tr>
                        </thead>
                        <tbody >
                            <% for(int i=0; i<rep.length;i++)
                            {
                                
%>
                          <tr>
                              
                              <td><% out.print(rep[i].getIddetaireservation()); %></td>
                              <td><% out.print(rep[i].getChambre().getNumero()); %></td>
                              <td><% out.print(rep[i].getChambre().getLits()); %></td>
                              <td><% out.print(rep[i].getChambre().getPlaces()); %></td>
                              <td><% out.print(rep[i].getDateconfirmationdetail()); %></td>
                               <td><% out.print(rep[i].getConfirme()); %></td>
                          </tr>
                          <% 
                          }
                        }catch(Exception ex)
                        {
                                out.print(ex.getMessage());
                                 ex.printStackTrace();
                        }
%>
                        </tbody>
                      </table>
                    </div>
		</div><!--/.row-->
                </br>
		<jsp:include page="footer.jsp" />
</body>
</html>
