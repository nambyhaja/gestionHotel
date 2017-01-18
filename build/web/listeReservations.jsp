<script type="text/javascript" src="bootstrap/js/angular.min.js"></script>	
<%@page import="java.sql.Connection"%>
<%@page import="mapping.Chambre"%>
<%@ page import="jdbc.ConnexionJDBC" %>
<%@ page import="mapping.Categorie" %>
<jsp:include page="header.jsp" />
	
		
	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main" ng-app="myApp" ng-controller="myControl">	
		
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
                                
                            </div>
                        </form>
                        <table class="table table-striped">
                        <thead>
                          <tr>
                            <th>Id r&eacute;servation</th>
                            <th>Client</th>
                            <th>Date de réservation</th>
                            <th>Date de confirmation</th>
                            <th>Date de début</th>
                            <th>Date de fin</th>
                            <th>Confirmé</th>
                            <th>Facturé</th>
                            <th>Réservations</th>
                          </tr>
                        </thead>
                        <tbody ng-repeat="r in reservations | filter:filtreChambre">
                          <tr>
                              <td>{{r.idreservation}}</td>
                            <td>{{r.client.nomclient}} {{r.client.prenomsclient}}</td>
                            <td>{{r.datereservation}}</td>
                             <td>{{r.dateconfirmation}}</td>
                            <td>{{r.datedebut}}</td>
                            <td>{{r.datefin}}</td>
                            <td>{{r.confirmation}}</td>
                             <td>{{r.facture}}</td>
                            <td>
                                <a href="listeDetailsReservations.jsp?idreservation={{r.idreservation}}"> 
                                    <button type="button" class="btn btn-primary">
                                         Détails
                                    </button>
                                </a>
                            </td>
                          </tr>
                        </tbody>
                      </table>
                    </div>
		</div><!--/.row-->
                </br>
		<jsp:include page="footer.jsp" />
        <script>
            var app = angular.module('myApp',[]);
            app.controller('myControl',function customersController($scope,$http) {
			$http.get("reservations.jsp").success(function(response) {
				$scope.reservations = response;
				console.log($scope.names);
			});
		});
        </script>
</body>
</html>
