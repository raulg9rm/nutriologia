/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raúl
 */
@WebServlet(urlPatterns = {"/ServNotificacionesNutri"})
public class ServNotificacionesNutri extends HttpServlet {
     ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    String usuu, cedu, numero;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        conecta.conectar();
        sentenciaSQL = conecta.getSentenciaSQL();
    }

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
            out.println("<title>Servlet ServNotificacionesNutri</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServNotificacionesNutri at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            
       response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id_paciente = null;
        out.println(" <head>\n" +
"        <!-- Required meta tags -->\n" +
"        <meta charset=\"utf-8\">\n" +
"        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n" +
"        <link rel=\"icon\" href=\"img/favicon.png\" type=\"image/png\">\n" +
"        <title>Nutri Web</title>\n" +
"        <!-- Bootstrap CSS -->\n" +
"        <link rel=\"stylesheet\" href=\"css/bootstrap.css\">\n" +
"        <link rel=\"stylesheet\" href=\"vendors/linericon/style.css\">\n" +
"        <link rel=\"stylesheet\" href=\"css/font-awesome.min.css\">\n" +
"        <link rel=\"stylesheet\" href=\"vendors/owl-carousel/owl.carousel.min.css\">\n" +
"        <link rel=\"stylesheet\" href=\"vendors/lightbox/simpleLightbox.css\">\n" +
"        <link rel=\"stylesheet\" href=\"vendors/nice-select/css/nice-select.css\">\n" +
"        <link rel=\"stylesheet\" href=\"vendors/animate-css/animate.css\">\n" +
"        <link rel=\"stylesheet\" href=\"vendors/popup/magnific-popup.css\">\n" +
"        <!-- main css -->\n" +
"        <link rel=\"stylesheet\" href=\"css/style.css\">\n" +
"        <link rel=\"stylesheet\" href=\"css/responsive.css\">\n" +
"    </head>\n" +
"    <body>\n" +
"        \n" +
"        <script src=\"scriptNutrioogo4.js\" type=\"text/javascript\"></script>\n" +
"        <!--================Header Menu Area =================-->\n" +
"        <a href=\"principalRNutriologo.jsp\" accesskey=\"i\"></a>\n" +
"            <a onclick=\"DinamicoDiv('mensajes');\" accesskey=\"m\"></a>\n" +
"            <a onclick=\"DinamicoDiv('imc');\" accesskey=\"l\"></a>\n" +
"            <a onclick=\"registraRYC();\" accesskey=\"p\"></a>\n" +
"        <div id=\"inicioNu\">\n" +
"        <header class=\"header_area\">\n" +
"            <div class=\"main_menu\">\n" +
"            	<nav class=\"navbar navbar-expand-lg navbar-light\">\n" +
"					<div class=\"container\">\n" +
"						<!-- Brand and toggle get grouped for better mobile display -->\n" +
"						<a class=\"navbar-brand logo_h\" href=\"principalRNutriologo.jsp\"><img src=\"img/logo.png\" alt=\"\"></a>\n" +
"						<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"							<span class=\"icon-bar\"></span>\n" +
"							<span class=\"icon-bar\"></span>\n" +
"							<span class=\"icon-bar\"></span>\n" +
"						</button>\n" +
"						<!-- Collect the nav links, forms, and other content for toggling -->\n" +
"						<div class=\"collapse navbar-collapse offset\" id=\"navbarSupportedContent\">\n" +
"							<ul class=\"nav navbar-nav menu_nav ml-auto\">\n" +
"								<li class=\"nav-item active\"><a class=\"nav-link\" href=\"principalRNutriologo.jsp\">Inicio</a></li> \n" +
"								<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\" onclick=\"DinamicoDiv('imc');\">Calcular IMC</a></li> \n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Plan de dieta</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"buscarOpcionMNutri();\">Crear</a>\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"buscarOpcionMNutriEditarPlanDieta();\">Editar</a></li>\n" +
"                                                                                <li class=\"nav-item\"><a class=\"nav-link\" onclick=\"buscarOpcionMNutriComprarPlan();\">Comprar Plan</a></li>\n" +
"                                                                        </ul>\n" +
"								</li>\n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Editar</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"actPerfilNutri();\">Perfil</a>\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"actRStatusNutriologo.jsp\">Status</a></li>\n" +
"									</ul>\n" +
"								</li> \n" +
"                                                                \n" +
"								 <li class=\"nav-item\"><a class=\"nav-link\"  onclick=\"registraRYC();\">Publicar</a></li>\n" +
"                                                                 <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\" onclick=\"DinamicoDiv('mensajes');\">Mensajes</a></li>\n" +
"                                                                 <li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Suscripción</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"ServActRDatosNutriologo\">Comprar</a>\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"actRStatusNutriologo.jsp\">Renovar</a></li>\n" +
"									</ul>\n" +
"								</li> \n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Ver</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"                                                                                 <li class=\"nav-item\"><a class=\"nav-link\" onclick=\"boletinN();\" >Boletin</a></li>\n" +
"                                                                        </ul>\n" +
"								</li>\n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"                                                                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Nutri&oacute;logo</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"index.jsp\">Cerrar Sesión</a></li>\n" +
"									</ul>\n" +
"								</li> \n" +
"								\n" +
"							</ul>\n" +
"						</div> \n" +
"					</div>\n" +
"            	</nav>\n" +
"            </div>\n" +
"        </header>\n" +
"        <!--================Header Menu Area =================-->\n" +
"        \n" +
"        <!--================Home Banner Area =================-->\n" +
"        <section class=\"banner_area\">\n" +
"            <div class=\"box_1620\">\n" +
"				<div class=\"banner_inner d-flex align-items-center\">\n" +
"					<div class=\"container\">\n" +
"						<div class=\"banner_content text-center\">\n" +
"							<h2>Bienvenido...!!!</h2>\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>\n" +
"				</div>\n" +
"            \n" +
"        </section>\n" +
"        \n" +
"        <!--================End Home Banner Area =================-->\n" +
"   ");
        try {

             String strComando = "SELECT * from iniciosesion";
            cdr = sentenciaSQL.executeQuery(strComando);

            while (cdr.next()) {
                usuu = cdr.getString("usuario");
            }

            
        } catch (SQLException ex) {
            out.println(ex);
        }
        
        
        try {

             String strComando = "SELECT * from nutriologo where usuario='"+usuu+"';";
            cdr = sentenciaSQL.executeQuery(strComando);

            while (cdr.next()) {
                cedu = cdr.getString("cedula");
            }

            
        } catch (SQLException ex) {
            out.println(ex);
        }
        
        
        try {

             String strComando = "SELECT count(id_not) num from notificacion where cedula='"+cedu+"' and status='enviada';";
            cdr = sentenciaSQL.executeQuery(strComando);

            while (cdr.next()) {
                numero = cdr.getString("num");
            }

            
        } catch (SQLException ex) {
            out.println(ex);
        }
        
        out.println("<center>");
            out.println("<br><br><h1>Notificaciones: "+numero+"</h1>");
            out.println("</br></br><table width=50% border=1>");
            out.println("<tr>");
            out.println("<th>Notificaci&oacute;n</th>");
            out.println("<th>Paciente</th>"
                    + "<th>Fecha</th><th></th></tr>");
            
        try {


            

           String strComando1 = "Select id_not, notificacion, concat(usuario.nombre,' ',usuario.paterno,' ',usuario.materno) "
                     + "paciente,fecha from notificacion "
                     + "INNER JOIN paciente on paciente.id_paciente=notificacion.id_paciente "
                     + "INNER JOIN usuario on usuario.usuario=paciente.usuario where cedula='"+cedu+"' and status='enviada';";
            cdr = sentenciaSQL.executeQuery(strComando1);

            while (cdr.next()) {
                out.println("<tr>");
                out.println("<td width=20%>" + cdr.getString("notificacion") + "</td>");
                out.println("<td width=10%>" + cdr.getString("paciente") + "</td>");
                out.println("<td width=10%>" + cdr.getString("fecha") + "</td>");
                //out.println("<td width=20%><button id=\"button\" class=\"main_btn2\" onclick=\"verNotificacionesNutri(" + cdr.getString("id_not") + ");\">Marcar como leido</button></td>");
            out.println("<td width=20%><button id=\"button\" class=\"main_btn2\" onclick=\"buscarOpcionMNutriVerHis2(" + cdr.getString("id_not") + ");\">Ver expedente</button></td>");
            }
            out.println("</tr></table><br><div id='men'></div><br><br>");

            out.close();
        } catch (SQLException ex) {
            //Logger.getLogger(servReporteCalorias1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
       
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
