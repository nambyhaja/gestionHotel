<%-- 
    Document   : chambres.jsp
    Created on : 22 nov. 2016, 19:38:15
    Author     : nambi
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="jdk.nashorn.internal.ir.debug.JSONWriter"%>
<%@page import="mapping.Chambre"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.ConnexionJDBC"%>

        <%
         ConnexionJDBC e=new ConnexionJDBC();
                                    try ( Connection c = e.getConnPostgre()) {
                                        Chambre[] rep;
                                        rep=e.getChambresWithPrix(c);
                                        String json = new Gson().toJson(rep);
                                        response.setContentType("application/json");
                                        response.setCharacterEncoding("UTF-8");
                                        response.getWriter().write(json);
                                      
                                    }   
                                    catch(Exception ex)
                                    {
                                        
                                    }
                               
                                 %>
