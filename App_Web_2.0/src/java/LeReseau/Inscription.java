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

/**
 * Page Inscription qui permet a un utilisateur sans compte de se créer un
 * compte utilisateur
 */
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

            // Affichage de la page (le code HTML) de la page inscription
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
            out.println(" <li><a href=\"http://localhost:8084/App_Web_2.0/Panier\">  Panier  </a></li>\n"
                    + "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Historique\">  Historique  </a></li>\n"
                    + "                </ul>\n");
            if (session.getAttribute("UserName") != null) {
                out.println("<p style=\"text-align:left\">" + session.getAttribute("UserName") + "</p>");
            }
            out.println("            </div>\n"
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

    // Belle fonction qui va chercher une image aleatoire pour la banniere d'entete
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

    // Affichage du formulaire d'inscription qui prend un Flag en parametre parce que si l'utilisateur a mal entré qque chose il va afficher une erreur 
    private void BoxInscription(PrintWriter out, boolean FlagErreurInscription) {

        out.println("<div style=\"padding-top:15px; margin: 0 auto; text-align:center;\">");
        if (FlagErreurInscription) {
            out.println("<p style=\"color:red;\"><b> Erreur dans les paramètres d'inscription </b></p>");

        }
        out.println("<div class=\"container\" style=\" margin: 0 auto;\">\n"
                + "     <form role=\"form\" action=\"Inscription\" method=\"post\" id=\"login-form\" autocomplete=\"off\">\n"
                + "     <div style=\"width:230px;  margin: 0 auto;\"> "
                + "         <div class=\"form-group\">\n"
                + "             <input type=\"text\" name=\"Username\" maxlength=\"20\" class=\"form-control\" placeholder=\"Nom d'usager\">\n"
                + "         </div>\n"
                + "         <div class=\"form-group\">\n"
                + "             <input type=\"password\" name=\"Password\" maxlength=\"20\" class=\"form-control\" placeholder=\"Mot de passe\">\n"
                + "         </div>\n"
                + "         <div class=\"form-group\">\n"
                + "             <input type=\"text\" name=\"Adresse\" maxlength=\"100\" class=\"form-control\" placeholder=\"Adresse\">\n"
                + "         </div>\n"
                + "         <div class=\"form-group\">\n"
                + "             <input type=\"text\" name=\"Telephone\" maxlength=\"10\" class=\"form-control\" placeholder=\"Telephone\" onkeypress=\"return isNumber(event)\">\n"
                + "         </div>\n");
        out.println("           <span class=\"input-group-btn\" style=\"padding-top:5px; width:250px;\" >\n"
                + "             <button style=\"width:230px; \" class=\"btn btn-info\" type=\"submit\" >\n"
                + "                 S'inscrire "
                + "             </button>\n"
                + "         </span>"
                + "     </div>");
        out.println("       </form>\n"
                + "         </div> ");
        out.println("</div>");

    }

    // GetClientID va chercher le id du client selon son username puisque ce username est unique
    private Integer GetClientID(String Username) {
        Integer LeID = null;
        OpenConnection();
        ResultSet rst;
        try {
            // Pas en callable statement parce qu,on a pas eu le temps de le changer 
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

  // OpenConnection ouvre la connexion à la BD 
    // On l'apelle toujours avant les requetes a la BD 
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

  // CloseConnection ferme la connexion a la BD 
    // On l'apelle toujours apres les requetes a la BD 
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

            // get le contenu des textbox 
            Username = request.getParameter("Username");
            Password = request.getParameter("Password");
            Adresse = request.getParameter("Adresse");
            Telephone = request.getParameter("Telephone");

            // si l'utilisateur essaie de se connecter avec des informations vides ca ne fonctionnera pas 
            if (Username != "" && Password != "" && Adresse != "" && Telephone != "") {
                // si l'inscription est reussi on renvoit a Connection pour que l'utilisateur se connecte sinon on met un flag
                if (InscriptionClient(Username, Password, Adresse, Telephone)) {
                    response.sendRedirect("ConnectionOracle");
                } else {
                    FlagErreurInscription = true;
                    processRequest(request, response);
                }
            } else {
                FlagErreurInscription = true;
                processRequest(request, response);
            }
        }
    }

    // InscriptionClient permet de creer le compte utilisateur dans la BD pour qu'il puisse pse connecter et acheter des billets 
    private boolean InscriptionClient(String Username1, String Password, String Adresse, String Telephone) {
        boolean InscriptionReussie = false;
        try {
            OpenConnection();
            // Verifie si l'utilisateur a choisi un nom qui existe deja dans la BD 
            try (CallableStatement CheckUsername = conn.prepareCall("{ call GESTIONUSAGER.USAGEREXISTE(?, ?)}")) {
                CheckUsername.setString(1, Username1);
                CheckUsername.registerOutParameter(2, OracleTypes.CURSOR);
                CheckUsername.execute();
                ResultSet rst = (ResultSet) CheckUsername.getObject(2);
                if (rst.next()) {
                    if (rst.getString(1) != Username1) {
                        // Envoit les informations a la BD pour s'incrire 
                        try (CallableStatement InscriptionStm = conn.prepareCall("{call GESTIONUSAGER.AUTHENTIFICATI0N(?,?,?,?)}")) {
                            InscriptionStm.setString(1, Adresse);
                            InscriptionStm.setString(2, Telephone);
                            InscriptionStm.setString(3, Username1);
                            InscriptionStm.setString(4, Password);
                            InscriptionStm.executeUpdate();
                            InscriptionReussie = true;

                            InscriptionStm.clearParameters();
                            InscriptionStm.close();
                        }
                    }
                }

                CheckUsername.clearParameters();
                CheckUsername.close();
                rst.close();
            }
        } catch (SQLException ez) {

        } finally {
            CloseConnection();
        }
        return InscriptionReussie;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
