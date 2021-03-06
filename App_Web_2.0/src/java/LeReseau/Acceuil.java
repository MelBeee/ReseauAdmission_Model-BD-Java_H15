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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import oracle.jdbc.OracleTypes;
import oracle.jdbc.pool.OracleDataSource;

/**
 * Page accueil permet de faire des recherches de spectacle par categorie/par
 * salle et par artiste. Affiche les billets disponibles a l'achat
 */
@WebServlet(name = "Acceuil", urlPatterns = {"/Acceuil"})
public class Acceuil extends HttpServlet {

    Connection conn = null;
    Integer idclient = null;
    Cookie lastRecherche = null;
    Cookie gestionLastRecherche = null;
    boolean verif = false;

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
            out.println(" <li><a href=\"http://localhost:8084/App_Web_2.0/Panier\">  Panier  </a></li>\n"
                    + "                    <li><a href=\"http://localhost:8084/App_Web_2.0/Historique\">  Historique  </a></li>\n"
                    + "                </ul>\n");
            if (session.getAttribute("UserName") != null) {
                out.println("<p style=\"text-align:right; color:White; font-size:25px\">" + session.getAttribute("UserName") + "</p>");
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
                    + "    <h1 style=\"text-align:center; font-size:50px;\">Accueil</h1> \n"
                    + "</section>");

            out.println("<hr style=\"height: 2px; border: none; margin: 10px; color: gray; background-color: gray;\" />");

            // PAS TOUCHE ^ 
            out.println("<table style=\"margin-left:auto; margin-right:auto;\" >");
            out.println("<tr>");
            out.println("<td rowspan=\"5\" style=\"padding-right:60px;\">");
            // TEXTBOX DES ARTISTES 
            out.println("<div id=\"custom-search-input\" style=\"width:300px; padding-bottom:20px; \">\n"
                    + "                <div class=\"input-group col-md-12\">\n"
                    + "                    <input id=\"Rartiste\" type=\"text\" class=\"  search-query form-control\" placeholder=\"Chercher par artiste\" />\n"
                    + "                    <span class=\"input-group-btn\">\n"
                    + "                        <button class=\"btn btn-info\" type=\"button\" onclick=\"GestionRechercheArtiste();\">\n"
                    + "                            <span class=\" glyphicon glyphicon-search\"></span>\n"
                    + "                        </button>\n"
                    + "                    </span>\n"
                    + "                </div>\n"
                    + "            </div>");

            // COMBOBOX DES SALLES 
            out.println("<div style=\"padding-top:10px;\" >");
            out.println("<select id=\"combo\" class=\"form-control\" style=\"width:300px;  \">\n");
            SetComboBox(out);
            out.println("</select >");
            out.println(" <span class=\"input-group-btn\" style=\"padding-top:5px; \" >\n"
                    + "                           <button style=\"width:230px; \" class=\"btn btn-info\" type=\"button\" onclick=\"Gestion();\">\n"
                    + " Rechercher par salle "
                    + "                           </button>\n"
                    + "                       </span>");
            out.println("</div>");

            out.println("</td>");
            out.println("</tr>");

            // CHECKBOX DES CATEGORIES 
            out.println("<div style=\"padding-right:10px; padding-left:10px;\" >");
            SetCheckBoxGroup(out);
            out.println("<tr>");
            out.println("<td colspan=\"3\">");
            out.println("<span class=\"input-group-btn\" style=\"padding-top:5px; width:250px;\" >\n"
                    + "                           <button style=\"width:230px; \" class=\"btn btn-info\" type=\"button\" onclick=\"GestionCheckBox();\">\n"
                    + " Rechercher par catégorie "
                    + "                           </button>\n"
                    + "                       </span>");
            out.println("</td>");
            out.println("</tr>");
            out.println("</div>");
            out.println("</table>");

            out.println("<hr style=\"height: 2px; border: none; margin: 10px; color: gray; background-color: gray;\" />");

            out.println("<div class=\"container\">");
            out.println("<section class=\"col-xs-12 col-sm-6 col-md-12\">");
            SetResearch(request, out, response);
            out.println("</section>");
            out.println("</div>");

            SetSetting(request, out, response);

            AjoutDansPanier(request, response);

            out.println("</body>");
            out.println("</html>");

        }
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
            stmGetClientID.close();
        } catch (SQLException ez) {

        }
        CloseConnection();
        return LeID;
    }

    // fonctino qui permet de rechercher tout les spectacles 
    private void ResearchAll(PrintWriter out) {
        OpenConnection();
        try {
            CallableStatement Callist = conn.prepareCall("{ call  RECHERCHE.SelectAll(?)}");
            Callist.registerOutParameter(1, OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet) Callist.getObject(1);
            AfficherLesResultats(rst, out);
            Callist.close();
            rst.close();
        } catch (SQLException se) {
        } finally {
            CloseConnection();
        }

    }

    // fonction qui permet d,afficher chaque salle dans le combobox en allant les chercher dans la BD 
    private void SetComboBox(PrintWriter out) {
        OpenConnection();
        try {
            CallableStatement Callist = conn.prepareCall("{ call  APPLOCALE.GETSALLE(?)}");
            Callist.registerOutParameter(1, OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet) Callist.getObject(1);
            while (rst.next()) {
                out.println("  <option value=\"" + rst.getString(1) + "\">" + rst.getString(1) + "</option>\n");
            }
            Callist.close();
            rst.close();
        } catch (SQLException se) {
        } finally {
            CloseConnection();
        }
    }

    // fonction qui permet d'afficher chaque checkbox des categories 
    private void SetCheckBoxGroup(PrintWriter out) {
        OpenConnection();
        try {
            CallableStatement Callist = conn.prepareCall("{ call  APPLOCALE.GETCATEGORIE(?)}");
            Callist.registerOutParameter(1, OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet) Callist.getObject(1);
            int cpt = 0;
            while (rst.next()) {
                if (cpt == 3 || cpt == 6 || cpt == 9) {
                    out.println("</tr>");
                }
                if (cpt == 0 || cpt == 3 || cpt == 6) {
                    out.println("<tr>");
                }
                out.println("<td> <div class=\"checkbox\">"
                        + "   <label>"
                        + "       <input class=\"chk_group\" type=\"checkbox\" value=\"" + rst.getString(1) + "\">"
                        + rst.getString(1)
                        + "   </label>"
                        + " </div> </td>");
                cpt += 1;
            }
            Callist.close();
            rst.close();
        } catch (SQLException se) {
        } finally {
            CloseConnection();
        }
    }
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////elle verifie si un cookie existe si oui elle fait la recherche pour la premiere avec la valeur du cookie sinon elle
    //////////////verifie la valeur des parametres passer set la valeur du cookie et fait la recherche voulu si aucun parametre est 
    /////////////passé il fait une recherche de tout les spectacle///////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void SetResearch(HttpServletRequest request, PrintWriter out, HttpServletResponse response) {

        if (!verif) {
            int i = 0;
            Cookie[] tab = request.getCookies();
            for (Cookie cookie : tab) {
                if (cookie != null) {
                    if (cookie.getName().equals("Last")) {
                        if (cookie.getValue().substring(0, cookie.getValue().lastIndexOf(',')).equals("Salle")) {
                            SetResearchBySalle(out, cookie.getValue().substring(cookie.getValue().lastIndexOf(',') + 1, cookie.getValue().length()));
                        } else if (cookie.getValue().substring(0, cookie.getValue().lastIndexOf(',')).equals("Artiste")) {
                            SetResearchArtiste(out, cookie.getValue().substring(cookie.getValue().lastIndexOf(',') + 1, cookie.getValue().length()));
                        } else if (cookie.getValue().substring(0, i = cookie.getValue().indexOf(',')).equals("Categorie")) {
                            String value = "";
                            ResearchAll(out);
                        }
                    }
                }

            }
        } else if (request.getParameter("Salle") != null && !request.getParameter("Salle").isEmpty()) {

            if (lastRecherche == null) {
                lastRecherche = new Cookie("Last", "Salle," + request.getParameter("Salle"));
                lastRecherche.setMaxAge(2592000);

                response.addCookie(lastRecherche);
                SetResearchBySalle(out, request.getParameter("Salle"));
            } else {
                SetResearchBySalle(out, request.getParameter("Salle"));
                Cookie[] tab = request.getCookies();
                for (Cookie cookie : tab) {
                    if (cookie.getName().equals("Last")) {
                        cookie.setValue("Salle," + request.getParameter("Salle"));
                        response.addCookie(cookie);                     
                    }
                }
            }
        } else if (request.getParameter("Artiste") != null && !request.getParameter("Artiste").isEmpty()) {

            if (lastRecherche == null) {
                lastRecherche = new Cookie("Last", "Artiste," + request.getParameter("Artiste"));
                lastRecherche.setMaxAge(2592000);

                response.addCookie(lastRecherche);
                SetResearchArtiste(out, request.getParameter("Artiste"));
            } else {
                SetResearchArtiste(out, request.getParameter("Artiste"));
                Cookie[] tab = request.getCookies();
                for (Cookie cookie : tab) {
                    if (cookie.getName().equals("Last")) {
                        cookie.setValue("Artiste," + request.getParameter("Artiste"));
                        response.addCookie(cookie);                  
                    }
                }
            }

        } else if (request.getParameter("cat0") != null && !request.getParameter("cat0").isEmpty()) {
            //  SetResearchByCat(request,out);
            int i = 0;
            String value = "";
            while (request.getParameter("cat" + i) != null && !request.getParameter("cat" + i).isEmpty()) {
                value += "\"" + request.getParameter("cat" + i) + "\"" + ",";
                i++;
            }
            value = value.substring(1, value.length() - 2);
            if (lastRecherche == null) {
                lastRecherche = new Cookie("Last", "Categorie," + value);
                lastRecherche.setMaxAge(2592000);
                response.addCookie(lastRecherche);
                SetResearchByCat(request, out);
            } else {
                SetResearchByCat(request, out);
                Cookie[] tab = request.getCookies();
                for (Cookie cookie : tab) {
                    if (cookie.getName().equals("Last")) {
                        // if(cookie.getValue().substring(0,cookie.getValue().lastIndexOf(',')).equals("Artiste")){
                        cookie.setValue("Categorie," + value);
                        response.addCookie(cookie);
                        //  }                      
                    }
                }
            }
        } else {
            //if(verif )
            ResearchAll(out);
        }

    }

    // fonction qui permet de rechercher par artiste
    private void SetResearchArtiste(PrintWriter out, String Artiste) {

        OpenConnection();
        try {
            CallableStatement Callist = conn.prepareCall("{ call  RECHERCHE.SelectByArtiste(?,?)}");
            Callist.setString(1, "%" + Artiste + "%");
            Callist.registerOutParameter(2, OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet) Callist.getObject(2);
            AfficherLesResultats(rst, out);
            Callist.close();
            rst.close();
        } catch (SQLException se) {
        } finally {
            CloseConnection();
        }
    }

    // fonction qui permet de rechercher par salle 
    private void SetResearchBySalle(PrintWriter out, String Salle) {
        OpenConnection();
        try {
            CallableStatement Callist = conn.prepareCall("{ call  RECHERCHE.SelectBySalle(?,?)}");
            Callist.setString(1, Salle);
            Callist.registerOutParameter(2, OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet) Callist.getObject(2);
            AfficherLesResultats(rst, out);
            Callist.close();
            rst.close();
        } catch (SQLException se) {
        } finally {
            CloseConnection();
        }

    }

    // fonction qui permet la recherche avec multiple categorie donc va chercher chaque checkbox de categorie coché
    private void SetResearchByCat(HttpServletRequest request, PrintWriter out) {
        int i = 0;
        while (request.getParameter("cat" + i) != null && !request.getParameter("cat" + i).isEmpty()) {
            ResearchByCat(out, request.getParameter("cat" + i));
            i++;
        }
    }

    // fonction qui permet de rechercher par categorie 
    private void ResearchByCat(PrintWriter out, String cat) {
        OpenConnection();
        try {
            CallableStatement Callist = conn.prepareCall("{ call  RECHERCHE.SelectByCat(?,?)}");
            Callist.setString(1, cat);
            Callist.registerOutParameter(2, OracleTypes.CURSOR);
            Callist.execute();
            ResultSet rst = (ResultSet) Callist.getObject(2);
            AfficherLesResultats(rst, out);
            Callist.close();
            rst.close();
        } catch (SQLException se) {
        } finally {
            CloseConnection();
        }
    }

    // fonction qui permet d'afficher en code HTML chaque billet dans la page.
    private void AfficherLesResultats(ResultSet rst, PrintWriter out) {
        try {
            while (rst.next()) {
                out.println("<article class=\"search-result row\">\n"
                        + "   <div class=\"thumbnail col-xs-12 col-sm-12 col-md-3\" style=\"width:250px; height:100px; overflow:hidden;     background-repeat: no-repeat;\n"
                        + " background-position: center; background-image: url(Image/" + rst.getString(5) + ".png);\">\n"
                        + "   <img src=\"Image/" + rst.getString(5) + ".png\">"
                        + "   </div>\n"
                        + "   <div class=\"col-xs-12 col-sm-12 col-md-2\">\n"
                        + "       <ul class=\"meta-search list-unstyled \">\n"
                        + "           <li><i class=\"glyphicon glyphicon-star\"></i> <span>" + rst.getString(3) + "</span></li>\n"
                        + "           <li><i class=\"glyphicon glyphicon-usd\"></i> <span>" + rst.getString(1) + "$</span></li>\n"
                        + "           <li><i class=\"glyphicon glyphicon-home\"></i> <span>" + rst.getString(4) + "</span></li>\n"
                        + "           <li><i class=\"glyphicon glyphicon-calendar\"></i> <span>" + rst.getString(7) + "</span></li>\n"
                        + "           <li><i class=\"glyphicon glyphicon-tags\"></i> <span>" + rst.getString(9) + "</span></li>\n"
                        + "       </ul>\n"
                        + "   </div>\n"
                        + "   <div class=\"col-xs-12 col-sm-12 col-md-7 excerpet\">\n"
                        + "       <h3><b>" + rst.getString(2) + "</b></h3>\n"
                        + "       <p>" + rst.getString(6) + "</p>\n"
                        + "       <span class=\"input-group-btn\" style=\"padding-top:5px; width:250px;\">\n"
                        + "           <button id=\"" + rst.getString(8) + "\" style=\" width:230px; \" class=\"btn btn-info\" onclick=\"AjoutPanier(this)\">\n"
                        + "               Choisir\n"
                        + "           </button>\n"
                        + "       </span>\n"
                        + "   </div>\n"
                        + "   <span class=\"clearfix borda\"></span>\n"
                        + "</article>");
            }
            rst.close();
        } catch (SQLException ex) {

        }
    }

         //////////////////////////////////////////////////////////////////////////////////////////////
        ////verifie si on a un cookie si oui on envoir la valeur du cookie au fonction qui set l'etat pour la premiere recherche
        ////par la suite elle verifie la valeur des parametres pour pouvoir remettre l'etat des controles de la derniere recherche
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void SetSetting(HttpServletRequest request, PrintWriter out, HttpServletResponse response) {

        
        if (!verif) {   //verifie si on a un cookie si oui on set les setting de recherche a sa value        
            Cookie[] tab = request.getCookies();
            for (Cookie cookie : tab) {
                if (cookie.getName().equals("Last")) {
                    if (cookie.getName().equals("Last")) {
                        if (cookie.getValue().substring(0, cookie.getValue().lastIndexOf(',')).equals("Salle")) {
                            out.println("<script> GestionSetting(\"Salle\",\"" + cookie.getValue().substring(cookie.getValue().lastIndexOf(',') + 1, cookie.getValue().length()) + "\")</script>");
                        } else if (cookie.getValue().substring(0, cookie.getValue().lastIndexOf(',')).equals("Artiste")) {
                            out.println("<script> GestionSetting(\"Artiste\",\"" + cookie.getValue().substring(cookie.getValue().lastIndexOf(',') + 1, cookie.getValue().length()) + "\")</script>");
                        } else if (cookie.getValue().substring(0, cookie.getValue().indexOf(',')).equals("Categorie")) {
                            out.println("<script> GestionSetting(\"categorie\",\"" + cookie.getValue().substring(cookie.getValue().indexOf(',') + 1, cookie.getValue().length()) + "\")</script>");
                        }
                    }
                }
            }
            verif = true;
        }
        if (request.getParameter("Salle") != null && !request.getParameter("Salle").isEmpty()) {
            out.println("<script> GestionSetting(\"Salle\",\"" + request.getParameter("Salle") + "\")</script>");
        } else if (request.getParameter("Artiste") != null && !request.getParameter("Artiste").isEmpty()) {
            out.println("<script> GestionSetting(\"Artiste\",\"" + request.getParameter("Artiste") + "\")</script>");
        } else if (request.getParameter("cat0") != null && !request.getParameter("cat0").isEmpty()) {
            int i = 0;
            String value = "";
            while (request.getParameter("cat" + i) != null && !request.getParameter("cat" + i).isEmpty()) {
                value += "\"" + request.getParameter("cat" + i) + "\"" + ",";
                i++;
            }
            value = value.substring(1, value.length() - 2);
            out.println("<script> GestionSetting(\"categorie\",\"" + value + "\")</script>");
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

    // Ajouter dans Panier permet d,ajouter le billet qu,on a choisi dans le panier (Billet choisi = appuyer sur le bouton choisir approprié au billet que l'on veut 
    private void AjoutDansPanier(HttpServletRequest request, HttpServletResponse response) {

       
        if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
            OpenConnection();
            try {
                PrintWriter out = response.getWriter();
                 // si on est connecté ca redirige a la page de connexion parec qu'on ne peut pas acheter de bilelt sans etre connecté
                if (idclient == null) {
                    out.println("<script>  window.location = \"http://localhost:8084/App_Web_2.0/ConnectionOracle\"</script>");
                    //  response.sendRedirect("/App_Web_2.0/ConnectionOracle");
                } else {
                    CallableStatement Callist = conn.prepareCall("{ call   FACTURATION.AJOUTERPANIER(?,?,?)}");
                    Callist.setInt(1, idclient);
                    Callist.setInt(2, Integer.parseInt(request.getParameter("id")));
                    Callist.setInt(3, 1);
                    Callist.executeUpdate();
                    Callist.close();
                }
            } catch (IOException e) {
            } catch (SQLException se) {
            } finally {
                CloseConnection();
            }
        }
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
