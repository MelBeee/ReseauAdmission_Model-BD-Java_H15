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
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;

@WebServlet(name = "Inscription", urlPatterns = {"/Inscription"})
public class Inscription extends HttpServlet {

    String url = "jdbc:oracle:thin:@205.237.244.251:1521:orcl";
    String Username;
    String Password;
    String Adresse;
    String Telephone;
    Integer idclient;
    Connection conn = null;
    boolean FlagErreurInscription = false;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            HttpSession session = request.getSession();

            idclient = GetClientID((String) session.getAttribute("UserName"));
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println(" <script src=\"GestionRecherche.js\"> </script> ");
            out.println("<title>Servlet Acceuil</title>");
            out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css\">\n"
                    + "\n"
                    + "<!-- Optional theme -->\n"
                    + "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css\">\n"
                    + "\n"
                    + "<!-- Latest compiled and minified JavaScript -->\n"
                    + "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js\"></script>");
            out.println("<style>");
            out.println(".jumbotron {\n"
                    + "    height:300px;\n"
                    + "    overflow:hidden;\n"
                    + "    background-size:cover;\n"
                    + "    background-image: url(Image/" + getImageAleatoire() + ".png); \n"
                    + "}");
            out.println("</style>");
            out.println("</head>");

            out.println("<div class=\"navbar navbar-inverse navbar-fixed-top\">\n"
                    + "        <div class=\"container\">\n"
                    + "            <div class=\"navbar-header\">\n"
                    + "                <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n"
                    + "                    <span class=\"icon-bar\"></span>\n"
                    + "                    <span class=\"icon-bar\"></span>\n"
                    + "                    <span class=\"icon-bar\"></span>\n"
                    + "                </button>\n"
                    + "                <p style=\"color:white; font-size:30px;\"> Reseau Admission </p> "
                    + "            </div>\n"
                    + "            <div class=\"navbar-collapse collapse\">\n"
                    + "                <ul class=\"nav navbar-nav\">\n"
                    + "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\">  Accueil  </a></li>\n");
            if (idclient == null) {
                out.println("<li><a href=\"http://localhost:8084/App_Web_2.0/ConnectionOracle\">  Connexion  </a></li>\n");
                out.println("<li><a href=\"http://localhost:8084/App_Web_2.0/Inscription\">  Inscription  </a></li>\n");
            } else {
                out.println("<li><a href=\"http://localhost:8084/App_Web_2.0/ConnectionOracle\">  Deconnection  </a></li>\n");
            }
            out.println(" <li><a href=\"http://localhost:8084/App_Web_2.0/Acceuil\">  Panier  </a></li>\n"
                    + "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Historique\">  Historique  </a></li>\n"
                    + "                </ul>\n"
                    + "            </div>\n"
                    + "        </div>\n"
                    + "    </div>");
            out.println("<div class=\"jumbotron\">\n"
                    + "</div>\n");

            out.println("<section style=\"  color: #000000;\n"
                    + "                   font-size: 18px;\n"
                    + "                   text-align: center;\n"
                    + "                   font-weight: bold;\">\n"
                    + "    <h1 style=\"text-align:center; font-size:50px;\">Inscription</h1> \n"
                    + "</section>");

            out.println("<hr style=\"height: 2px; border: none; margin: 10px; color: gray; background-color: gray;\" />");

            // PAS TOUCHE ^ 
            BoxInscription(out, FlagErreurInscription);
            FlagErreurInscription = false;

            out.println("</body>");
            out.println("</html>");
        }

    }
    
     private String getImageAleatoire() {
        int maximum = 7;
        int minimum = 1;
        Random rn = new Random();
        int range = maximum - minimum + 1;
        int randomNum = rn.nextInt(range) + minimum;
        String imageaAfficher = "BanniereCirque";

        switch (randomNum) {
            case 1:
                imageaAfficher = "BanniereCinema";
                break;
            case 2:
                imageaAfficher = "BanniereArts";
                break;
            case 3:
                imageaAfficher = "BanniereFestival";
                break;
            case 4:
                imageaAfficher = "BanniereMusique";
                break;
            case 5:
                imageaAfficher = "BanniereSport";
                break;
            case 6:
                imageaAfficher = "BanniereTheatre";
                break;
            case 7:
                imageaAfficher = "BanniereCirque";
                break;
            default:
                imageaAfficher = "BanniereCirque";
                break;
        }

        return imageaAfficher;
    }

    private void BoxInscription(PrintWriter out, boolean FlagErreurInscription) {
        if (FlagErreurInscription) {
            out.println("Erreur dans les paramètre d'inscription");
        }
        out.println("<form action=\"Inscription\" method=\"post\">");
        out.println("<table style=\"position:relative; left:40%;\">");
        out.println("<tr>");
        out.println("<td>");
        out.println("Username :");
        out.println("</td>");
        out.println("<td>");
        out.println("<input type=\"text\" maxlength=\"20\" name=\"Username\"><br>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>");
        out.println("Password :");
        out.println("</td>");
        out.println("<td>");
        out.println("<input type=\"Password\" maxlength=\"20\" name=\"Password\"><br>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>");
        out.println("Addresse :");
        out.println("</td>");
        out.println("<td>");
        out.println("<input type=\"text\" maxlength=\"100\" name=\"Adresse\"><br>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>");
        out.println("Telephone :");
        out.println("</td>");
        out.println("<td>");
        out.println("<input type=\"text\" maxlength=\"10\" value=\"\" id=\"Telephone\" name=\"Telephone\" onkeypress=\"return isNumber(event)\" /><br>");
        out.println("</td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td>");
        out.println("<span class=\"input-group-btn\" style=\"padding-top:5px; width:250px;\" >\n"
                + "                           <button style=\"width:230px; \" class=\"btn btn-info\" type=\"submit\" >\n"
                + " S'inscrire "
                + "                           </button>\n"
                + "                       </span>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");

    }

    private Integer GetClientID(String Username) {
        Integer LeID = null;
        OpenConnection();
        ResultSet rst;
        try {
            Statement stmGetClientID = conn.createStatement();
            stmGetClientID.execute("Select idclient from client where Username = '" + Username + "'");
            rst = stmGetClientID.getResultSet();
            while (rst.next()) {
                LeID = rst.getInt(1);
            }
        } catch (SQLException ez) {

        }

        CloseConnection();
        return LeID;
    }

    private void OpenConnection() {
        try {
            OracleDataSource ods = new OracleDataSource();
            ods.setURL("jdbc:oracle:thin:@205.237.244.251:1521:orcl");
            ods.setUser("BoucherM");
            ods.setPassword("ORACLE2");
            this.conn = ods.getConnection();
        } catch (SQLException se) {
        }

    }

    private void CloseConnection() {

        try {
            this.conn.close();
        } catch (SQLException se) {
        }
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
            Adresse = request.getParameter("Adresse");
            Telephone = request.getParameter("Telephone");
            
            if(Username != "" && Password != "" && Adresse != "" && Telephone != "")
            {
                if (InscriptionClient(Username, Password, Adresse, Telephone)) 
                {
                    response.sendRedirect("Acceuil");
                } else {
                    FlagErreurInscription = true;
                    processRequest(request, response);
                }
            }
            else
            {
                FlagErreurInscription = true;
                processRequest(request, response);
            }
        }
    }

    private boolean InscriptionClient(String Username1, String Password, String Adresse, String Telephone) {
        boolean InscriptionReussie = false;
        try {
            OpenConnection();
            try (CallableStatement CheckUsername = conn.prepareCall("{ call GESTIONUSAGER.USAGEREXISTE(?, ?)}")) {
                CheckUsername.setString(1, Username1);
                CheckUsername.registerOutParameter(2, OracleTypes.CURSOR);
                CheckUsername.execute();
                ResultSet rst = (ResultSet)CheckUsername.getObject(2);
                if(rst.next())
                {
                    if (rst.getString(1) != Username1)
                    {                      
                        try (CallableStatement InscriptionStm = conn.prepareCall("{call GESTIONUSAGER.AUTHENTIFICATI0N(?,?,?,?)}")) {
                            InscriptionStm.setString(1, Adresse);
                            InscriptionStm.setString(2, Telephone);
                            InscriptionStm.setString(3, Username1);
                            InscriptionStm.setString(4, Password);
                            InscriptionStm.executeUpdate();
                            InscriptionReussie = true;
                            
                            InscriptionStm.clearParameters();
                        }
                    }
                }
                
                CheckUsername.clearParameters();
            }
        } catch (SQLException ez) 
        {
            
        } 
        finally {
            CloseConnection();
        }
        return InscriptionReussie;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
