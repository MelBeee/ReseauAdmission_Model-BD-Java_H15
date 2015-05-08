/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeReseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import oracle.jdbc.OracleDriver;
import javax.servlet.http.HttpSession;

/**
 *
 * @author 201356187
 */
@WebServlet(name = "ConnectionOracle", urlPatterns = {"/ConnectionOracle"})
public class ConnectionOracle extends HttpServlet {
    
    String url = "jdbc:oracle:thin:@205.237.244.251:1521:orcl";
    String Username ;
    String Password;
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
            out.println("<title>Servlet Connection</title>");            
            out.println("</head>");            
            out.println("<body>");
            
            //Connection de l'usager
            out.println("<form action=\"ConnectionOracle\" method=\"post\">");
            out.println("<table>");
            out.println("<tr>");
            out.println("Username : <input type=\"text\" name=\"Username\" value=\"Nom d'utilisateur\"><br>");                           
            out.println("</tr>");
            out.println("<tr>");
            out.println("Password : <input type=\"Password\" name=\"Password\" value=\"Password\"><br>"); 
            out.println("</tr>");
            out.println("<tr>");
            out.println("<input type=\"submit\" value=\"Connecter\">"); 
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");           
            
             
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    public boolean ConnectionUsager(String Username, String Password)
    {      
        boolean ConnexionReussie = false;
        try
        {
             DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
             Connection conn = DriverManager.getConnection(url,"BoucherM","ORACLE2");
             Statement SelectStm = conn.createStatement();
             String StringConnectionUsager = "Select * from Client where Username = '"+Username+ "' AND LEPASSWORD = '"+Password+"'";
             if(SelectStm.execute(StringConnectionUsager))
             {
                ConnexionReussie = true; 
             }            
             
        }catch(SQLException connEX)
        {           
           ConnexionReussie = false;  
        }
        return ConnexionReussie;
        
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
            
       HttpSession session = request.getSession();    
       Username = request.getParameter("Username");
       Password = request.getParameter("Password");
      
        if(ConnectionUsager(Username, Password))
        {
            response.sendRedirect("Acceuil");
            session.setAttribute("UserName", Username);
        }else
        {
            out.println("<h1 style =\"Color:Red\"> Veuillez entrez un Nom d'usager ou un mot de passe valide </h1>");
            processRequest(request, response);
            
        }
        }
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
