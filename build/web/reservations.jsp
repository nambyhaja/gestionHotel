<%-- 
    Document   : chambres.jsp
    Created on : 22 nov. 2016, 19:38:15
    Author     : nambi
--%>

<%@page import="jdbc.ReservationJDBC"%>
<%@page import="mapping.Reservation"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="jdk.nashorn.internal.ir.debug.JSONWriter"%>
<%@page import="mapping.Chambre"%>
<%@page import="java.sql.Connection"%>
<%@page import="jdbc.ConnexionJDBC"%>

        <%
         ReservationJDBC e=new ReservationJDBC();
         ConnexionJDBC con=new ConnexionJDBC();
                                    try ( Connection c = con.getConnPostgre()) {
                                        Reservation[] rep;
                                        rep=e.getReservationsConfirmes(c);
                                        String json = new Gson().toJson(rep);
                                        response.setContentType("application/json");
                                        response.setCharacterEncoding("UTF-8");
                                        response.getWriter().write(json);
                                      
                                    }   
                                    catch(Exception ex)
                                    {
                                        
                                    }
                               
                                 %>
