
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
import java.util.Random;
import oracle.jdbc.OracleDriver;
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;


@WebServlet(name = "ConnectionOracle", urlPatterns = {"/ConnectionOracle"})
public class ConnectionOracle extends HttpServlet {
    
    String url = "jdbc:oracle:thin:@205.237.244.251:1521:orcl";
    String Username ;
    String Password;
    Integer idclient;
    Connection conn = null;
    boolean FlagErreurConnection =false;
  

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session  = request.getSession(); 
            session.invalidate();   
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
                        "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\">  Accueil  </a></li>\n");                   
                            out.println("<li><a href=\"http://localhost:8084/App_Web_2.0/ConnectionOracle\">  Connexion  </a></li>\n");
                            out.println("<li><a href=\"http://localhost:8084/App_Web_2.0/Inscription\">  Inscription  </a></li>\n");                                          
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
                        "    <h1 style=\"text-align:center; font-size:50px;\">Connexion</h1> \n" +
                        "</section>"); 
            
            out.println("<hr style=\"height: 2px; border: none; margin: 10px; color: gray; background-color: gray;\" />");
          
            // PAS TOUCHE ^      
            
            
            //Connection de l'usager
            BoxConnection(out,FlagErreurConnection);
            FlagErreurConnection = false;
             
            
            out.println("</body>");
            out.println("</html>");
        }
    }
    private void BoxConnection(PrintWriter out, boolean FlagErreurConnection )
    {
        out.println("<div style=\"padding-top:15px; margin: 0 auto; text-align:center;\">");
        if(FlagErreurConnection)
            out.println("Erreur dans vos paremètre de connexion!");
        
        out.println(  "<div class=\"container\" style=\" margin: 0 auto;\">\n"
                    + "     <form role=\"form\" action=\"ConnectionOracle\" method=\"post\" id=\"login-form\" autocomplete=\"off\">\n"
                    + "     <div style=\"width:230px;  margin: 0 auto;\"> "
                    + "         <div class=\"form-group\">\n"
                    + "             <input type=\"text\" name=\"Username\" maxlength=\"20\" class=\"form-control\" placeholder=\"Nom d'usager\">\n"
                    + "         </div>\n"
                    + "         <div class=\"form-group\">\n"
                    + "             <input type=\"password\" name=\"Password\" maxlength=\"20\" class=\"form-control\" placeholder=\"Mot de passe\">\n"
                    + "         </div>\n");
        out.println("           <span class=\"input-group-btn\" style=\"padding-top:5px; width:250px;\" >\n"
                    + "             <button style=\"width:230px; \" class=\"btn btn-info\" type=\"submit\" >\n"
                    + "                 Se connecter "
                    + "             </button>\n"
                    + "         </span>"
                    + "     </div>");
        out.println("       </form>\n"
                + "         </div> ");
        out.println("</div>");
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
        try
        {
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
    
    public boolean ConnectionUsager(String Username, String Password)
    {      
        boolean ConnexionReussie = false;
        try
        {
             OpenConnection();
             CallableStatement  ConnexionStm = conn.prepareCall("{ ? = call GESTIONUSAGER.CONNEXION(?,?)}");         
             ConnexionStm.registerOutParameter(1, OracleTypes.INTEGER);
             ConnexionStm.setString(2, Username);
             ConnexionStm.setString(3, Password);
             ConnexionStm.execute();
             if(ConnexionStm.getInt(1)== 1)             
             {
                ConnexionReussie = true; 
             }            
             
        }catch(SQLException connEX)
        {           
            
        }
        finally
        {
            CloseConnection();
        }
        return ConnexionReussie;
        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
   
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        try (PrintWriter out = response.getWriter()) {            
         
       Username = request.getParameter("Username");
       Password = request.getParameter("Password");
      
        if(ConnectionUsager(Username, Password))
        {
            HttpSession session = request.getSession();
            session.setAttribute("UserName", Username);
            response.sendRedirect("Acceuil");
            
        }else
        {            
            FlagErreurConnection=true;
            processRequest(request, response);             
        }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
