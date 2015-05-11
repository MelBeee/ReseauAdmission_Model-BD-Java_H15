/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//div contain back color #BCD6DA
  //DIV RECHERCHE BACK COLOR #6E9DA3
package LeReseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author 201037629
 */
@WebServlet(name = "Acceuil", urlPatterns = {"/Acceuil"})
public class Acceuil extends HttpServlet {
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
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Acceuil</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n" +
                        "\n" +
                        "<!-- Optional theme -->\n" +
                        "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n" +
                        "\n" +
                        "<!-- Latest compiled and minified JavaScript -->\n" +
                        "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>");
             out.println("</head>");
             out.println("<body bgcolor=\"#95BABF\"");
             out.println("<div>");
             out.println(    "<img  src= \"Image/BanniereCirque.png;\"></img>" );
             out.println(    "<h1 >Reseau Admission </h1>");
             out.println("</div>");
             out.println("<div style= \"background-color=\"#587C81;\">"
                             +"<ul> "
                                 + "<a href=# style=\"text-decoration:none;\" <li> Acceuil  </li></a>"
                                 + "<a href=# style=\"text-decoration:none;\"<li> Connexion  </li></a>"
                                 + "<a href=# style=\"text-decoration:none;\"<li> Inscription  </li></a>"
                                 + "<a href=# style=\"text-decoration:none;\"<li> Panier  </li></a>"
                                 + "<a href=# style=\"text-decoration:none;\"<li> Historique D'achat  </li></a>"              
                            + "</ul>"
                     +  "</div>"
                      + "<div>"
                      + "<form action=\"\" method=\"post\">"
                      + "<input type=\"text\" name=\"artiste\"> "
                      +"<input type=\"submit\" value=\"Search\">"
                      +"</br>"
                     + "Salle:"
                         +"<select>\n" );
                        SetComboBox(out);
             out.println( "</select>" +
                       "</br>");
                       SetCheckBoxGroup(out);            
         out.println("<input type=\"submit\" value=\"Search\">"                     
                     +"</form>"
                      +"</div>"
                     +" <section class=\"col-xs-12 col-sm-6 col-md-12\">\n");
                     ResearchAll(out);
                     out.println( "</section>");                                                                                                         
             out.println("</body>");
             out.println("</html>");
                        
        }
    }
     
    private void ResearchAll(PrintWriter out){
      OpenConnection();
      try{
            CallableStatement Callist = conn.prepareCall("{ call  RECHERCHE.SelectAll(?)}");
            Callist.registerOutParameter(1,OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet)Callist.getObject(1);        
            while(rst.next()){
               
                 out.println("<article class=\"search-result row\">\n" +
                    "            <div class=\"col-xs-12 col-sm-12 col-md-3\">\n" +
                    "                <a href=\"#\" title=\"Lorem ipsum\" class=\"thumbnail\"><img src=\"http://lorempixel.com/250/140/people\" alt=\"Lorem ipsum\" /></a>\n" +
                    "            </div>\n" +
                    "            <div class=\"col-xs-12 col-sm-12 col-md-2\">\n" +
                    "                <ul class=\"meta-search\">\n" +
                    "                    <li><i class=\"glyphicon glyphicon-calendar\"></i> <span>"+rst.getString(3) +"</span></li>\n" +
                    "                    <li><i class=\"glyphicon glyphicon-time\"></i> <span>" +rst.getInt(1)+"$" +"</span></li>\n" +
                    "                    <li><i class=\"glyphicon glyphicon-tags\"></i> <span>"+rst.getString(4)+"</span></li>\n" +
                    "                </ul>\n" +
                    "            </div>\n" +
                    "            <div class=\"col-xs-12 col-sm-12 col-md-7 excerpet\">\n" +
                    "                <h3><a href=\"#\" title=\"\">"+rst.getString(2)+"</a></h3>\n" +
                    "                <p>"+rst.getString(6)+".</p>\n" +
                    "                <span class=\"plus\"><a href=\"#\" title=\"Lorem ipsum\"><i class=\"glyphicon glyphicon-plus\"></i></a></span>\n" +
                    "            </div>\n" +
                    "            <span class=\"clearfix borda\"></span>\n" +
                    "        </article>\n" );                
            }
          }
        catch(SQLException se){
         }
        finally{
        CloseConnection();
      }
     
    }
    private void SetComboBox(PrintWriter out){
     OpenConnection();
      try{
            CallableStatement Callist = conn.prepareCall("{ call  APPLOCALE.GETSALLE(?)}");
            Callist.registerOutParameter(1,OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet)Callist.getObject(1);        
            while(rst.next()){
               out.println( "  <option value=\"" + rst.getString(1)+"\">"+rst.getString(1)+"</option>\n");                     
            }
      }
      catch(SQLException se){
         }
        finally{
        CloseConnection();
      }     
    }
    private void SetCheckBoxGroup(PrintWriter out){
     OpenConnection();
      try{
            CallableStatement Callist = conn.prepareCall("{ call  APPLOCALE.GETCATEGORIE(?)}");
            Callist.registerOutParameter(1,OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet)Callist.getObject(1);        
            while(rst.next()){
               out.println(   " <input type=\"checkbox\" name=\"chk_group\" value=\"" + rst.getString(1)+"\" />"+rst.getString(1)+"<br />\n" );         
            }
      }
      catch(SQLException se){
         }
        finally{
        CloseConnection();
      }
    }
    
    
    
 /////////////Gestion Connection//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
