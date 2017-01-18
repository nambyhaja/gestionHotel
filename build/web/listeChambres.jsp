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
                            <h3>Liste de chambres avec recherche</h3>
                            <hr class="colorgraph">
                           
                            <div class="form-group">
                                <label>Choix des critères</label>
                            </div>
                            <div class="form-group">
                                <label>Num&eacute;ro de la Chambre</label>
                                <input type="text" ng-model='filtreChambre.numero' name="motscles" id="numchamb" class="form-control input-lg" placeholder="" required/>
                            </div>
                            <div class="form-group">
                                <label>Cat&eacute;gorie de la Chambre</label>
                                <input type="text" ng-model='filtreChambre.nomcategorie' name="motscles" id="numchamb" class="form-control input-lg" placeholder="" required/>
                            </div>
                            <div class="form-group">
                                <label>Nombre de lits</label>
                                <input type="text" ng-model='filtreChambre.lits' name="motscles" id="numchamb" class="form-control input-lg" placeholder="" required/>
                            </div>
                            <div class="form-group">
                                <label>Nombre de places</label>
                                <input type="text" ng-model='filtreChambre.places' name="motscles" id="numchamb" class="form-control input-lg" placeholder="" required/>
                            </div>
                            <div class="form-group">
                                <label>Prix</label>
                                <input type="text" ng-model='filtreChambre.prix' name="motscles" id="numchamb" class="form-control input-lg" placeholder="" required/>
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
                            <th>Suppression en cascade</th>
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
                            <td>
                                <a href="modificationChambre.jsp?numerochambre={{c.numero}}">
                                     <button type="button" class="btn btn-primary">
                                         Modifier
                                    </button>
                                </a>
                            </td>
                            <td>
                            <!-- Button trigger modal -->
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModal">
                                 Supprimer
                                </button>
                                  <!-- Modal -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                      <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                          <span aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">Attention ! </h4>
                                      </div>
                                      <div class="modal-body">
                                        Voulez-vous vraiment supprimer ceci ?
                                      </div>
                                      <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Non</button>
                                        <a href="chambreSupprime.jsp?numerochambre={{c.numero}}"><button type="button" class="btn btn-warning">Oui</button></a>
                                      </div>
                                    </div>
                                  </div>
                                </div>
                            </td>
                           
                             <td>
                                <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#myModalCascade">
                                 Supprimer en cascade
                                </button>
                                  <!-- Modal -->
                                 <div class="modal fade" id="myModalCascade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                      <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                          <span aria-hidden="true">&times;</span>
                                        </button>
                                        <h4 class="modal-title" id="myModalLabel">Attention ! </h4>
                                      </div>
                                      <div class="modal-body">
                                        Voulez-vous vraiment supprimer ceci en cascade?
                                      </div>
                                      <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Non</button>
                                        <a href="chambreSupprimeCascade.jsp?numerochambre={{c.numero}}"><button type="button" class="btn btn-warning">Oui</button></a>
                                      </div>
                                    </div>
                                  </div>
                                </div>
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
			$http.get("chambres.jsp").success(function(response) {
				$scope.chambres = response;
				console.log($scope.names);
			});
		});
        </script>
</body>
</html>
