/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeReseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Charlie
 */
@WebServlet(name = "Panier", urlPatterns = {"/Panier"})
public class Panier extends HttpServlet {
    Integer idclient;
    Connection conn = null;
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
             HttpSession session  = request.getSession();              
             idclient = GetClientID((String) session.getAttribute("UserName")); 
            
                       
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
                        "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\">  Accueil  </a></li>\n");        
                        if(idclient == null)
                        {
                            out.println("<li><a href=\"http://localhost:8084/App_Web_2.0/ConnectionOracle\">  Connexion  </a></li>\n");
                            out.println("<li><a href=\"http://localhost:8084/App_Web_2.0/Inscription\">  Inscription  </a></li>\n"); 
                        }
                        else
                        {
                            out.println("<li><a href=\"http://localhost:8084/App_Web_2.0/ConnectionOracle\">  Deconnection  </a></li>\n");
                        }                   
                        out.println(" <li><a href=\"http://localhost:8084/App_Web_2.0/Panier\">  Panier  </a></li>\n" +
                        "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Historique\">  Historique  </a></li>\n" +
                        "                </ul>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </div>");
            out.println("<div class=\"jumbotron\">\n" +
                        "</div>\n");
              
            out.println("<section style=\"  color: #000000;\n" +
                        "                   font-size: 18px;\n" +
                        "                   text-align: center;\n" +
                        "                   font-weight: bold;\">\n" +
                        "    <h1 style=\"text-align:center; font-size:50px;\">Panier</h1> \n" +
                        "</section>"); 
            
            out.println("<hr style=\"height: 2px; border: none; margin: 10px; color: gray; background-color: gray;\" />");
            //Pas touche ^
            
               if (idclient == null) {
                response.sendRedirect("/App_Web_2.0/ConnectionOracle");
            } else {
                //Fonction faire apparaitre panier
            }

            out.println("</div>");
            out.println("</div>");

            out.println("<div style=\"height:50px; width:100%; overflow:auto; background-color:white; margin:auto;\">");
            out.println("</div>");
            
            
            
            out.println("</body>");
            out.println("</html>");
            
        }
    }
      private Integer GetClientID(String Username)
    {
        Integer LeID = null;
        OpenConnection();
        ResultSet rst;
        try
        {
            Statement stmGetClientID = conn.createStatement();
            stmGetClientID.execute("Select idclient from client where Username = '"+Username+"'");
            rst = stmGetClientID.getResultSet();
            while(rst.next())
            {
                LeID = rst.getInt(1);
            }            
        }catch(SQLException ez)
        {
            
        }
        
        CloseConnection();
        return LeID;
    }
    
    private void OpenConnection(){    
        try{
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:@205.237.244.251:1521:orcl");
        ods.setUser("BoucherM");
        ods.setPassword("ORACLE2");
        this.conn = ods.getConnection();       
        }
        catch(SQLException se){       
        }
        
    }
    
    private void CloseConnection(){
    
     try{
         this.conn.close();
     }
     catch(SQLException se){
     }
    }
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
        processRequest(request, response);
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
