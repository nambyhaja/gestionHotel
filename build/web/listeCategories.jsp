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
                            <h3>Liste des cat&eacute;gories avec recherche</h3>
                            <hr class="colorgraph">
                           
                            <div class="form-group">
                                <label>Rechercher nom :</label>
                            </div>
                            <div class="form-group">
                                <label>Nom de cat&eacute;gorie</label>
                                <input type="text" ng-model='filtreCategorie.nomcategorie' name="motscles" id="numchamb" class="form-control input-lg" placeholder="" required/>
                            </div>
                        </form>
                        <table class="table table-striped">
                        <thead>
                          <tr>
                            <th>ID Cat&eacute;gorie</th>
                            <th>Nom de cat&eacute;gorie</th>
                            <th>Modification</th>
                            <th>Suppression</th>
                          </tr>
                        </thead>
                        <tbody ng-repeat="c in categories | filter:filtreCategorie">
                          <tr>
                            <td>{{c.idcategorie}}</td>
                            <td>{{c.nomcategorie}}</td>
                            <td><a href="modificationCategorie.jsp?idcategorie={{c.idcategorie}}">Modifier</a></td>
                            <td><a href="categorieSupprime.jsp?idcategorie={{c.idcategorie}}">Supprimer</a></td>
                            
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
			$http.get("categories.jsp").success(function(response) {
				$scope.categories = response;
				//console.log($scope.names);
			});
		});
        </script>
</body>
</html>
