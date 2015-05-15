
package LeReseau;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import oracle.jdbc.pool.OracleDataSource;
import java.util.Random;
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleTypes;


@WebServlet(name = "Historique", urlPatterns = {"/Historique"})
public class Historique extends HttpServlet {

    Connection conn = null;
    boolean EstConnecte = true;

    Integer idclient;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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
                    + "    <h1 style=\"text-align:center; font-size:50px;\">Historique</h1> \n"
                    + "</section>");

            out.println("<hr style=\"height: 2px; border: none; margin: 10px; color: gray; background-color: gray;\" />");

            //pas touche ^
            out.println("<div style=\"height:600px; width:70%; overflow:auto; background-color:lightgrey; margin:auto;\">");
            out.println("<div style=\"width:95%;\">");

            if (idclient == null) {
                response.sendRedirect("/App_Web_2.0/ConnectionOracle");
            } else {
                GetFacture(out);
            }

            out.println("</div>");
            out.println("</div>");

            out.println("<div style=\"height:50px; width:100%; overflow:auto; background-color:white; margin:auto;\">");
            out.println("</div>");

            out.println("</body>");
            out.println("</html>");
        }
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

    private void GetFacture(PrintWriter out) {
        OpenConnection();

        try {
            CallableStatement Callist = conn.prepareCall("{call facturation.getlesfactures(?, ?) }");
            Callist.setInt(1, idclient);
            Callist.registerOutParameter(2, OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet) Callist.getObject(2);

            while (rst.next()) {
                out.println(" <article class=\"search-result row\">\n"
                        + "   <div class=\" col-md-2\">\n"
                        + "       <ul class=\"meta-search\" style=\"list-style-type: none; color:black; font-size:18px;\">\n"
                        + "           <li><i class=\"glyphicon glyphicon-barcode\"></i> <span>" + rst.getInt(1) + "</span></li>\n"
                        + "           <li><i class=\"glyphicon glyphicon-calendar\"></i> <span>" + rst.getString(2) + "</span></li>\n"
                        + "           <li><i class=\"glyphicon glyphicon-print\"></i> <span>" + AnalyseImprime(rst.getString(3)) + "</span></li>\n"
                        + "           <li><i class=\"glyphicon glyphicon-usd\"></i> <span>" + rst.getInt(4) + "</span></li>\n"
                        + "       </ul>\n"
                        + "   </div>");
                out.println("<div class=\"col-xs-12 col-sm-12 col-md-7 excerpet\" style=\"width:80%;\">\n"
                        + "   <table style=\"width: 100%; color: black; font-size: 15px;\">");
                out.println("<tr style=\"font-weight:bold;\"><td>Spectacle</td><td>Salle</td><td>Section</td><td>Date et Heure</td><td>Nombre</td><td>Prix/Billet</td></tr>");
                GetVenteBillet(rst.getInt(1), out);
                out.println("   </table>\n"
                        + "</div>");
                out.println(" </article>\n"
                        + " <hr style=\"height: 1px; border: none; margin: 0px; color: gray; background-color: gray;\" />");
            }
        } catch (SQLException se) {

        } finally {
            CloseConnection();
        }
    }

    private void GetVenteBillet(int idfacture, PrintWriter out) {
        OpenConnection();
        try {
            CallableStatement Callist = conn.prepareCall("{call facturation.getlesventes(?, ?) }");
            Callist.setInt(1, idfacture);
            Callist.registerOutParameter(2, OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet) Callist.getObject(2);

            int cpt = 1;
            while (rst.next()) {
                if (cpt % 2 == 0) {
                    out.println("<tr style=\"background-color:#C5CADE;\">");
                } else {
                    out.println("<tr style=\"background-color:#BACEDB;\">");
                }
                out.println("<td>" + cpt + ". " + rst.getString(2) + "</td>");
                out.println("<td> <span class=\"glyphicon glyphicons-google-maps\"></span> " + rst.getString(6) + "</td>");
                out.println("<td> " + rst.getString(7) + "</td>");
                out.println("<td> <span class=\"glyphicon glyphicons-calendar\"></span> " + rst.getString(4) + " </td>");
                out.println("<td> <span class=\"glyphicon glyphicons-sampler\"></span> " + rst.getInt(1) + " billets </td>");
                out.println("<td> <span class=\"glyphicon glyphicons-coins\"></span> " + rst.getInt(5) + "$ </td>");
                out.println("</tr>");
                cpt++;
            }
        } catch (SQLException se) {

        } finally {
            CloseConnection();
        }
    }

    private String AnalyseImprime(String imprime) {
        String imprimeoupas = "Imprime";

        if (imprime == "1") {
            imprimeoupas = "Pas Imprime";
        }

        return imprimeoupas;
    }

 /////////////Gestion Connection//////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
