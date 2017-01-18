
<%@page import="java.sql.Connection"%>
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
                        <%
                             try
                             {
                        %>
                       
                       
                        <%
                            
                                String numero=request.getParameter("numchamb");
                                String categorie=request.getParameter("categorie");
                                String prix=request.getParameter("prix");
                                short nombrelits = Short.parseShort(request.getParameter("nombrelits")); 
                                short nombreplaces = Short.parseShort(request.getParameter("nombreplaces")); 
                                ConnexionJDBC e=new ConnexionJDBC();
                                e.appelInsertChambre(numero, nombrelits, nombreplaces, categorie,prix);
                                %>
                                <h3>Votre chambre a &eacute;t&eacute; ins&eacute;r&eacute;e correctement</h3>
                         <%
                             }catch(Exception e)
                             {
                        %>
                        <h3><% out.print(e.getMessage()); %></h3>
                        <%   }     %>
                    </div>
		</div><!--/.row-->
                </br>
		<jsp:include page="footer.jsp" />
</body>
</html>

