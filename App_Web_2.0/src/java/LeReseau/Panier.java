/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeReseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
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
import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;

/**
 *
 * @author Charlie
 */
@WebServlet(name = "Panier", urlPatterns = {"/Panier"})
public class Panier extends HttpServlet {
    Integer idclient;
    Integer prixTotal = 0;
    Connection conn = null;
    boolean FlagListeVide =true;
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
                        "                </ul>\n");
                        if(session.getAttribute("UserName")!=null)
                        out.println("<p style=\"text-align:right; color:White; font-size:25px\">"+session.getAttribute("UserName") +"</p>");
                        out.println("            </div>\n" +
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
            
            out.println("<div style=\"height:600px; width:70%; overflow:auto; background-color:lightgrey; margin:auto;\">");
            out.println("<div style=\"width:95%; margin:auto;\">");

            if (idclient == null) {
                response.sendRedirect("/App_Web_2.0/ConnectionOracle");
            } else {
                GetPanier(out);
            }

            out.println("</div>");
            out.println("</div>");

            out.println("<div style=\"height:50px; width:100%; overflow:auto; background-color:white; margin:auto;\">");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
            
        }
    }
    private void GetPanier(PrintWriter out)
    {
        FlagListeVide = true;
        OpenConnection();
        try {
             CallableStatement Callist = conn.prepareCall("{call facturation.SELECTPANIER(?, ?) }");
            Callist.setInt(1, idclient);
            Callist.registerOutParameter(2, OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet) Callist.getObject(2);
            out.println("<div style=\"margin:auto;\">");
            out.println("<form action =\"Panier\" method=\"post\">");
            
            out.println("<div style=\"margin:auto;\">");
            out.println("<table style=\"width:99%; margin:auto;\">");
            out.println("<tr>");
            out.println("<td><b></b></td>");
            out.println("<td><b>Spectacle</b></td>");
            out.println("<td><b>Salle</b></td>");
            out.println("<td><b>Section</b></td>");
            out.println("<td><b>Date et Heure</b></td>");
            out.println("<td><b>Nombre de billet</b></td>"); 
            out.println("<td><b>Prix unitaire</b></td>"); 
            out.println("<td><b>Prix du lot</b></td>");
            out.println(" </tr>");
            int cpt = 1;
            prixTotal = 0;
             while (rst.next()) {
                 FlagListeVide = false;                 
                if (cpt % 2 == 0) {
                    out.println("<tr style=\"background-color:#C5CADE;\">");
                } else {
                    out.println("<tr style=\"background-color:#BACEDB;\">");
                }
                cpt++;
                        out.println("<td  style=\"padding:5px; text-align:center;\">");
                            out.println("<input type=\"radio\" name=\"RB_Supp\"  value=\""+rst.getInt(7)+"\">" );
                        out.println("</td>");           
                        out.println("<td  style=\"\">");
                            out.println(rst.getString(1));
                        out.println("</td>");
                         out.println("<td  style=\"\">");
                            out.println(rst.getString(2));
                        out.println("</td>");
                         out.println("<td  style=\"\">");
                            out.println(rst.getString(3));
                        out.println("</td>");
                         out.println("<td  style=\"\">");
                            out.println(rst.getString(4));
                        out.println("</td>");
                          out.println("<td  style=\"\">");
                            out.println("<input type=\"number\" min=\"1\" max=\"100000\" name=\""+rst.getInt(7)+"\" value =\"" + rst.getString(5) + "\">" );
                        out.println("</td>");    
                          out.println("<td  style=\"\">");
                            out.println(rst.getString(6) + "$");
                        out.println("</td>");                            
                        out.println("<td>");
                            out.println(""+ Integer.parseInt(rst.getString(5))*Integer.parseInt(rst.getString(6)) + "$");
                            prixTotal += Integer.parseInt(rst.getString(5))*Integer.parseInt(rst.getString(6));
                        out.println("</td>");
                    out.println("</tr>");
                 
             }          
             Callist.close();
             rst.close();
            out.println("</table>");
            out.println("</div>"); 
            out.println("<div style=\"text-align:center; padding-top:15px;\">");
            out.println("<h4><b>Prix total : " + prixTotal + "$</b></h4>");
            out.println("</div>");
            out.println("<div style=\"margin:auto; padding-top:10px; padding-bottom:10px; text-align:center;\">");
            out.println("<input type=\"checkbox\" name=\"CB_Imp\"> <b>Cochez pour faire imprimer et envoyer les billets (20$ de frais)</b>");
                        out.println("</div>");
            out.println("<div style=\"margin: 0 auto; width:250px;\">");
            out.println("<span class=\"input-group-btn\" style=\"margin:auto; width:250px;\" >\n"
                    +   "   <button style=\"width:230px; \" class=\"btn btn-info\" type=\"submit\" name=\"action\" value=\"Mise a jour\" >\n"
                    +   "       Mettre à jour "
                    +   "   </button>\n"
                    +   "</span>");
            out.println("</br>");
            out.println("<span class=\"input-group-btn\" style=\"margin:auto; width:250px;\" >\n"
                    +   "   <button style=\"width:230px; \" class=\"btn btn-info\" type=\"submit\" name=\"action\" value=\"Supprimer\" >\n"
                    +   "       Supprimer "
                    +   "   </button>\n"
                    +   "</span>");
            out.println("</br>");
            out.println("<span class=\"input-group-btn\" style=\"margin:auto; width:250px;\" >\n"
                    +   "   <button style=\"width:230px; \" class=\"btn btn-info\" type=\"submit\" name=\"action\" value=\"Achat\" >\n"
                    +   "       Finaliser l'achat "
                    +   "   </button>\n"
                    +   "</span>");
            out.println("</div>");
            out.println("</form>");
            out.println("</div>");
        }
        catch(SQLException ex)
        {
            
        }
        finally
        {
            CloseConnection();
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
        
        PrintWriter out = response.getWriter();
        if(request.getParameter("action").equals("Mise a jour") && !FlagListeVide)
        {
            if(MettreAJour(request,out))
            {
                processRequest(request, response);
            }            
        }
        else  if(request.getParameter("action").equals("Achat") && !FlagListeVide)
        {            
            if(AchatBillet(request, out))
            {
                response.sendRedirect("/App_Web_2.0/Historique");                
            }
            
        }
        else  if(request.getParameter("action").equals("Supprimer") && request.getParameter("RB_Supp")!=null && !FlagListeVide)
        {
            if(SupprimerBillet(request))
            {
                processRequest(request, response);
            }                    
        }
        processRequest(request, response);
        
    }
    private String CheckCheckBox(HttpServletRequest request)
    {
        String imprimer;
        if(request.getParameter("CB_Imp") == null)
        {
           imprimer = "0";
        }else
        {
           imprimer = "1";
        }
        return imprimer;
    }
    private boolean AchatBillet(HttpServletRequest request, PrintWriter out)
    {
        boolean AchatBillet = false;
        OpenConnection();       
        try
        {
            MettreAJour(request, out);
             CallableStatement CallAchat = conn.prepareCall("{call facturation.AJOUTERFACTURE(?, ?)}");             
             CallAchat.setString(1,CheckCheckBox(request));            
             CallAchat.setInt(2, idclient);             
             CallAchat.executeUpdate();
             AchatBillet=true;
             CallAchat.close();
            
        }catch(SQLException ef)
        {
            System.out.println(ef);
            
        }finally
        {
            CloseConnection();
        }
        
        return AchatBillet;
    }
    private boolean SupprimerBillet(HttpServletRequest request)
    {
        boolean BilletSupprimer = false;
        OpenConnection();
        try
        {
            CallableStatement CallSupprimer = conn.prepareCall("{call facturation.SUPPRIMERPANIER(?, ?) }");
            CallSupprimer.setInt(1, idclient);            
            CallSupprimer.setInt(2, Integer.parseInt(request.getParameter("RB_Supp")));            
            CallSupprimer.execute();
            BilletSupprimer =true;
            CallSupprimer.close();                      
        }
        catch(SQLException eg)
        {
            
            
        }finally
        {
            CloseConnection();
        }
               
        
        return BilletSupprimer;
    }
    private boolean NombreDeBillet(int idbillet, int NbreDeBillet)
    {
        boolean NombreBillet = false;
        try
        {
           CallableStatement CallNbBillet = conn.prepareCall("{call facturation.GetNbrePlace(?, ?) }"); 
           CallNbBillet.setInt(1, idbillet);
           CallNbBillet.registerOutParameter(2, OracleTypes.CURSOR);
           CallNbBillet.execute();
           ResultSet rst = (ResultSet) CallNbBillet.getObject(2);
           if(rst.next())
           {
                  int nombre = rst.getInt(4);
                  if(rst.wasNull() || NbreDeBillet<=nombre)
                  {
                      NombreBillet = true;
                  }
                             
           }
           CallNbBillet.close();
           rst.close();
        }catch(SQLException ej)
        {
            
        }      
        
        return NombreBillet;
    }
    private boolean MettreAJour(HttpServletRequest request, PrintWriter out)
    {
        boolean MitAJour = false;       
        
                OpenConnection();
        try
        {
            CallableStatement CallSelectSimplePanier = conn.prepareCall("{call facturation.SELECTPANIERSIMPLE(?, ?) }");
            CallSelectSimplePanier.setInt(1, idclient);
            CallSelectSimplePanier.registerOutParameter(2, OracleTypes.CURSOR);
            CallSelectSimplePanier.execute();
            ResultSet rst = (ResultSet) CallSelectSimplePanier.getObject(2);          
            
            while(rst.next())
            {
                
                String nbbillet = request.getParameter(rst.getInt(2)+"");
                if(nbbillet == "")
                { 
                    nbbillet="1";
                }
                 if(NombreDeBillet(rst.getInt(2),Integer.parseInt(nbbillet)))
                {
                        CallableStatement CallMod = conn.prepareCall("{call facturation.MODIFIERPANIER(?, ?, ?) }");           
                        CallMod.setInt(1, idclient);                
                        int  IDbillet = rst.getInt(2);
                        CallMod.setInt(2, IDbillet);
                                                
                        CallMod.setInt(3, Integer.parseInt(nbbillet));
                        CallMod.execute();
                        CallMod.close();
                }
                else
                {
                    out.println("<script> alert(\"Il n'y a plus assez de billet\"); </script>");
                }
              
           
              
            }
            MitAJour = true;
            CallSelectSimplePanier.close();
            rst.close();
        }catch(SQLException eh)           
        {
            
        }
        finally
        {
            
            CloseConnection();
        }
        
        return MitAJour;
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
