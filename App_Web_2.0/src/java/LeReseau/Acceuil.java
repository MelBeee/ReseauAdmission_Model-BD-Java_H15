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
             out.println( "<td><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\" style=\"text-decoration:none; color:Red;\">  Accueil  </a></td>");
             out.println( "<td><a href=\"http://localhost:8084/App_Web_2.0/ConnectionOracle\" style=\"text-decoration:none;  color:Red;\">   Connexion  </a></td>");
             out.println( "<td><a href=\"http://localhost:8084/App_Web_2.0/Inscription\" style=\"text-decoration:none;  color:Red;\"> Inscription  </a></td>");
             out.println("<td><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\" style=\"text-decoration:none;  color:Red;\">  Panier </a></td>");
             out.println("<td><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\" style=\"text-decoration:none;  color:Red;\">   Historique d'achat </a></td>");
             out.println( "</tr>");
             out.println("</table>");
             out.println("</br>");    
                     
                     
             out.println("<div>"
                      + "<form action=\"\" method=\"post\">"
                      + "<input type=\"text\" name=\"artiste\" id=\"Rartiste\"> "
                      +"<button type=\"button\" onclick=\"GestionRechercheArtiste();\">Click Me!</button>"
                      +"</br>"
                     + "Salle:"
                         +"<select id=\"combo\">\n" );
                        SetComboBox(out);
             out.println( "</select>" 
                      +"<button type=\"button\" onclick=\"Gestion();\">Click Me!</button>"+
                       "</br>");
                       SetCheckBoxGroup(out);            
            out.println("<button type=\"button\" onclick=\"GestionCheckBox();\">Click Me!</button>"           
                     +"</form>"
                      +"</div>"
                     +" <section class=\"col-xs-12 col-sm-6 col-md-12\">\n");
                    SetResearch(request,out);
                     out.println( "</section>");  
                       SetSetting(request,out);
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
               out.println(   " <input type=\"checkbox\" class=\"chk_group\" value=\"" + rst.getString(1)+"\" />"+rst.getString(1)+"<br />\n" );         
            }
      }
      catch(SQLException se){
         }
        finally{
        CloseConnection();
      }
    }
     private void SetResearch(HttpServletRequest request,PrintWriter out){
      if(request.getParameter("Salle")!=null &&!request.getParameter("Salle").isEmpty() ){
           SetResearchBySalle(out,request.getParameter("Salle"));
      }
      else if( request.getParameter("Artiste")!=null&&!request.getParameter("Artiste").isEmpty()){
          SetResearchArtiste(out,request.getParameter("Artiste"));
      }
      else if( request.getParameter("cat0")!=null&&!request.getParameter("cat0").isEmpty()){
          SetResearchByCat(request,out);
      }
      else{
          ResearchAll(out);
      }
        
      }
       private void SetResearchArtiste(PrintWriter out,String Artiste){
       
         OpenConnection();
      try{
            CallableStatement Callist = conn.prepareCall("{ call  RECHERCHE.SelectByArtiste(?,?)}");
            Callist.setString(1,"%"+Artiste+"%");
            Callist.registerOutParameter(2,OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet)Callist.getObject(2);        
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
      private void SetResearchBySalle(PrintWriter out,String Salle){
       OpenConnection();
      try{
            CallableStatement Callist = conn.prepareCall("{ call  RECHERCHE.SelectBySalle(?,?)}");
            Callist.setString(1,Salle);
            Callist.registerOutParameter(2,OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet)Callist.getObject(2);        
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
      
      private void SetResearchByCat(HttpServletRequest request,PrintWriter out){    
          int i = 0;
           while(request.getParameter("cat"+i)!=null&&!request.getParameter("cat"+i).isEmpty()){
              ResearchByCat(out,request.getParameter("cat"+i));
              i++;
           }
          
          
      }
      
     private void ResearchByCat(PrintWriter out,String cat){
      OpenConnection();
      try{
            CallableStatement Callist = conn.prepareCall("{ call  RECHERCHE.SelectByCat(?,?)}");
            Callist.setString(1,cat);
            Callist.registerOutParameter(2,OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet)Callist.getObject(2);        
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
      
     private void SetSetting(HttpServletRequest request,PrintWriter out){
         
      if(request.getParameter("Salle")!=null &&!request.getParameter("Salle").isEmpty() ){
          out.println("<script> GestionSetting(\"Salle\",\""+request.getParameter("Salle")+"\")</script>");
      }
      else if( request.getParameter("Artiste")!=null&&!request.getParameter("Artiste").isEmpty()){
           out.println("<script> GestionSetting(\"Artiste\",\""+request.getParameter("Artiste")+"\")</script>");
      }
      else if( request.getParameter("cat0")!=null&&!request.getParameter("cat0").isEmpty()){
           int i = 0;
           String value ="";
           while(request.getParameter("cat"+i)!=null&&!request.getParameter("cat"+i).isEmpty()){
                 value+= request.getParameter("cat"+i);
               i++;
              }
               
            out.println("<script> GestionSetting(\"categorie\",\""+ value+"\")</script>");
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
