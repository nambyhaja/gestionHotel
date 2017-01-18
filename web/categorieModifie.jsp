
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
                            
                                String idcategorie=request.getParameter("idcategorie");
                                String nomcategorie=request.getParameter("nomcategorie");
                                ConnexionJDBC e=new ConnexionJDBC();
                                e.modifierCategorie(e.getConnPostgre(),idcategorie,nomcategorie);
                               // e.appelModifierChambre(numero, nombrelits, nombreplaces,categorie,prix,numancient);
                                //e.appelModifierChambre("F007", Short.parseShort("2"), Short.parseShort("4"),"Familial","120","F001");
                                
                                %>
                                <h3>La cat&eacute;gorie a &eacute;t&eacute; modifi&eacute; correctement</h3>
                                <h3><a href="listeCategories.jsp">Voir la liste des cat&eacute;gories</a></h3>
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

