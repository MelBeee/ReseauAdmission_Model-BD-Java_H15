/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeReseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author Charlie
 */
@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {
    String url = "jdbc:oracle:thin:@205.237.244.251:1521:orcl";
String Username;
String Password;
String Adresse;
String Telephone;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
                out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<script language=\"javascript\">function isNumber(evt) {\n" +
                        "    evt = (evt) ? evt : window.event;\n" +
                        "    var charCode = (evt.which) ? evt.which : evt.keyCode;\n" +
                        "    if (charCode > 31 && (charCode < 48 || charCode > 57)) {\n" +
                        "        return false;\n" +
                        "    }\n" +
                        "    return true;\n" +
                        "} "+
                        "</script>");
            out.println("<title>Servlet Acceuil</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n" +
                        "\n" +
                        "<!-- Optional theme -->\n" +
                        "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n" +
                        "\n" +
                        "<!-- Latest compiled and minified JavaScript -->\n" +
                        "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>");
             out.println("</head>");
             out.println("<body style=\"background-color:#587C81;\">");         
             out.println("<div style= \"background-color=\"#587C81;\">");
             out.println("<img style=\"width:100%; height:200px\"  src= \"Image/BanniereCirque.png;\"></img>");
             out.println("</div>"); 
             out.println("<table style=\"border-collapse: separate;  border-spacing: 10px; position:relative; left:40%;\">");
             out.println("<tr>");
             out.println("<th colspan=\"6\"><h1>Réseau Admission</h1></th>");                            
             out.println("</tr>");              
             out.println("<tr>");
             out.println( "<td><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\" style=\"text-decoration:none;  color:Red;\">  Accueil  </a></td>");
             out.println( "<td><a href=\"http://localhost:8084/App_Web_2.0/ConnectionOracle\" style=\"text-decoration:none;  color:Red;\">   Connexion  </a></td>");
             out.println( "<td><a href=\"http://localhost:8084/App_Web_2.0/Inscription\" style=\"text-decoration:none;  color:Red;\"> Inscription  </a></td>");
             out.println("<td><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\" style=\"text-decoration:none;  color:Red;\">  Panier </a></td>");
             out.println("<td><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\" style=\"text-decoration:none;  color:Red;\">   Historique d'achat </a></td>");
             out.println( "</tr>");
             out.println("</table>");
             out.println("</br>");       
    

            out.println("<form action=\"Inscription\" method=\"post\">");
                out.println("<table>");
                    out.println("<tr>");
                        out.println("<td>");
                             out.println("Username :");
                        out.println("</td>");
                        out.println("<td>");
                             out.println("<input type=\"text\" name=\"Username\"><br>");
                        out.println("</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td>");
                             out.println("Password :");
                        out.println("</td>");
                        out.println("<td>");
                             out.println("<input type=\"Password\" name=\"Password\"><br>");
                        out.println("</td>");
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td>");
                             out.println("Addresse :");
                        out.println("</td>");
                        out.println("<td>");
                             out.println("<input type=\"text\" name=\"Adresse\"><br>");
                        out.println("</td>");          
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td>");
                             out.println("Telephone :");
                        out.println("</td>");
                        out.println("<td>");
                             out.println("<input type=\"text\" maxlength=\"10\" value=\"\" id=\"extra7\" name=\"extra7\" onkeypress=\"return isNumber(event)\" /><br>");
                        out.println("</td>");            
                    out.println("</tr>");
                    out.println("<tr>");
                        out.println("<td>");
                             out.println("<input type=\"submit\" value=\"Inscription\">");
                        out.println("</td>");           
                    out.println("</tr>");
                out.println("</table>");
            out.println("</form>");

            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try (PrintWriter out = response.getWriter()) {
       Username = request.getParameter("Username");
       Password = request.getParameter("Password");
       Adresse = request.getParameter("Adresse");
       Telephone = request.getParameter("Telephone");
       
       if(InscriptionClient(Username,Password,Adresse,Telephone))
       {
           response.sendRedirect("Acceuil");           
       }
       else
       {
            out.println("<h1 style =\"Color:Red\"> Votre nom d'utilisateur est déja utiliser ou certains champs sont mal remplient </h1>");
            processRequest(request, response);   
            
       }
       }
       
    }
    private boolean InscriptionClient(String Username,String Password,String Adresse, String Telephone)
    {
        boolean InscriptionReussie = false;
        try
        {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            Connection conn = DriverManager.getConnection(url,"BoucherM","ORACLE2");
            CallableStatement  CheckUsername = conn.prepareCall("{ ? = call GESTIONUSAGER.USERNAMEEXISTE(?)}");
            CheckUsername.registerOutParameter(1, OracleTypes.INTEGER);
            CheckUsername.setString(2, Username);
            CheckUsername.execute();
             if(CheckUsername.getInt(1)== 0)             
             {
                CallableStatement  InscriptionStm = conn.prepareCall("{call GESTIONUSAGER.AUTHENTIFICATI0N(?,?,?,?)}");
                
                InscriptionStm.setString(1, Adresse);
                InscriptionStm.setString(2, Telephone);
                InscriptionStm.setString(3, Username);
                InscriptionStm.setString(4, Password);                
                InscriptionStm.executeUpdate();                
                InscriptionReussie =true;
                
             }                  
             
            
        }catch(SQLException ez)
        {
            
        }
        return InscriptionReussie;
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
