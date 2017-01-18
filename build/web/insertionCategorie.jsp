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
                        <form role="form" method="post" action="categorieInsere.jsp">
                            <h3>Insertion de cat&eacute;gorie</h3>
                            <hr class="colorgraph">
                            <div class="form-group">
                                <input type="text" name="nomcat" id="nomcat" class="form-control input-lg" placeholder="Nom de la cat&eacute;gorie" required/>
                            </div>
                            <div class="form-group">
                                    <div class="col-xs-12 col-sm-12 col-md-12">
                                            <input type="submit" id="buttoninscription" value="Ins&eacute;rer" class="btn btn-lg btn-primary btn-block">
                                    </div>
                            </div>
                        </form>
                    </div>
		</div><!--/.row-->
                </br>
		<jsp:include page="footer.jsp" />
</body>
</html>
