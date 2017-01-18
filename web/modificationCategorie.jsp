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
                        <form role="form" method="post" action="categorieModifie.jsp">
                            <h3>Modification de cat&eacute;gorie</h3>
                            <hr class="colorgraph">
                            <%
                                    ConnexionJDBC e=new ConnexionJDBC();
                                    String idcategorie=request.getParameter("idcategorie");
                                    Categorie c = e.getCategorieById(e.getConnPostgre(),idcategorie);
                                %>
                                 <input type="hidden" name="idcategorie" id="numchamb" class="form-control input-lg" value="<% out.print(c.getIdcategorie()); %>" required/>
                            <div class="form-group">
                                <label>Cat&eacute;gorie de la chambre :</label>
                                 <input type="text" name="nomcategorie" id="numchamb" class="form-control input-lg" value="<% out.print(c.getNomcategorie()); %>" required/>
                            </div>
                            <div class="row">
                                    <div class="col-xs-12 col-sm-12 col-md-12">
                                            <input type="submit" id="buttonmodifier" value="Modifier" class="btn btn-lg btn-primary btn-block">
                                    </div>
                            </div>
                        </form>
                    </div>
		</div><!--/.row-->
                </br>
		<jsp:include page="footer.jsp" />
</body>
</html>
