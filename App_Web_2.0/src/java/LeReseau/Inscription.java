/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeReseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Random;
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

 private String getImageAleatoire()
    {
        int maximum = 7;
        int minimum = 1;
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum =  rn.nextInt(range) + minimum;
        String imageaAfficher = "BanniereCirque";
        
        switch(randomNum)
        {
            case 1: imageaAfficher = "BanniereCinema";
                break;
            case 2: imageaAfficher = "BanniereArts";
                break;
            case 3: imageaAfficher = "BanniereFestival";
                break;
            case 4: imageaAfficher = "BanniereMusique";
                break;
            case 5: imageaAfficher = "BanniereSport";
                break;
            case 6: imageaAfficher = "BanniereTheatre";
                break;
            case 7: imageaAfficher = "BanniereCirque";
                break;
            default: imageaAfficher = "BanniereCirque";
                break;
        }
        
        
        return imageaAfficher;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
     out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <script src=\"GestionRecherche.js\"> </script> ");
            out.println("<title>Servlet Acceuil</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n" +
                        "\n" +
                        "<!-- Optional theme -->\n" +
                        "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n" +
                        "\n" +
                        "<!-- Latest compiled and minified JavaScript -->\n" +
                        "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>");
            out.println("<style>");
            out.println(".jumbotron {\n" +
                        "    height:300px;\n" +
                        "    overflow:hidden;\n" +
                        "    background-size:cover;\n" +
                        "    background-image: url(Image/" + getImageAleatoire() + ".png); \n" +
                        "}");
            out.println("</style>");
             out.println("</head>"); 
             
             out.println("<div class=\"navbar navbar-inverse navbar-fixed-top\">\n" +
                        "        <div class=\"container\">\n" +
                        "            <div class=\"navbar-header\">\n" +
                        "                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n" +
                        "                    <span class=\"icon-bar\"></span>\n" +
                        "                    <span class=\"icon-bar\"></span>\n" +
                        "                    <span class=\"icon-bar\"></span>\n" +
                        "                </button>\n" +
                        "                <p style=\"color:white; font-size:30px;\"> Reseau Admission </p> " +
                        "            </div>\n" +
                        "            <div class=\"navbar-collapse collapse\">\n" +
                        "                <ul class=\"nav navbar-nav\">\n" +
                        "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\">  Accueil  </a></li>\n" +
                        "                    <li><a href=\"http://localhost:8084/App_Web_2.0/ConnectionOracle\">  Connexion  </a></li>\n" +
                        "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Inscription\">  Inscription  </a></li>\n" +
                        "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\">  Panier  </a></li>\n" +
                        "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Historique\">  Historique  </a></li>\n" +
                        "                </ul>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </div>");
            out.println("<div class=\"jumbotron\">\n" +
                        "</div>\n");
            
            out.println("<section style=\"  color: #1fa67b;\n" +
                        "                   font-size: 18px;\n" +
                        "                   text-align: center;\n" +
                        "                   font-weight: bold;\">\n" +
                        "    <h1 style=\"text-align:center; font-size:50px;\">Inscription</h1> \n" +
                        "</section>"); 
            
            out.println("<hr style=\"height: 2px; border: none; margin: 10px; color: gray; background-color: gray;\" />");
    

            out.println("<form action=\"Inscription\" method=\"post\">");
                out.println("<table style=\"position:relative; left:40%;\">");
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
