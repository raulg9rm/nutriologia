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
@WebServlet(urlPatterns = {"/DTodosVisualizacionRecetas"})
public class DTodosVisualizacionRecetas extends HttpServlet {
    ResultSet cdr=null;
    Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int horas, horas2, horas3;
        
        public void init(ServletConfig config) throws ServletException{
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
            out.println("<title>Servlet DTodosVisualizacionRecetas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DTodosVisualizacionRecetas at " + request.getContextPath() + "</h1>");
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
        String cons;
        
        try {
        cons = "select * from publicacion where tipo_publicacion= 'receta';";
            cdr = sentenciaSQL.executeQuery(cons);
            
             out.println("    <head>\n" +
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
"        <script src=\"scriptInicio3.js\" type=\"text/javascript\"></script>\n" +
"        <!--================Header Menu Area =================-->\n" +
"        <a href=\"index.jsp\" accesskey=\"i\"></a>\n" +
"        <a onclick=\"DinamicoDiv('imc');\" accesskey=\"l\"></a>\n" +
"            <a onclick=\"DinamicoDiv('sesion');\" accesskey=\"s\"></a>\n" +
"        <div id=\"inicio\">\n" +
"            \n" +
"        <header class=\"header_area\">\n" +
"            <div class=\"main_menu\">\n" +
"            	<nav class=\"navbar navbar-expand-lg navbar-light\">\n" +
"					<div class=\"container\">\n" +
"						<!-- Brand and toggle get grouped for better mobile display -->\n" +
"						<a class=\"navbar-brand logo_h\" href=\"index.jsp\"><img src=\"img/logo.png\" alt=\"\"></a>\n" +
"						<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"							<span class=\"icon-bar\"></span>\n" +
"							<span class=\"icon-bar\"></span>\n" +
"							<span class=\"icon-bar\"></span>\n" +
"						</button>\n" +
"						<!-- Collect the nav links, forms, and other content for toggling -->\n" +
"						<div class=\"collapse navbar-collapse offset\" id=\"navbarSupportedContent\">\n" +
"							<ul class=\"nav navbar-nav menu_nav ml-auto\">\n" +
"								<li class=\"nav-item active\"><a class=\"nav-link\" href=\"index.jsp\">Inicio</a></li> \n" +
"                                                                 \n" +
"								<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\" onclick=\"DinamicoDiv('imc');\">Calcular IMC</a></li> \n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Contacto</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"indexStarWeb.jsp\">Star Web</a></li>\n" +
"									</ul>\n" +
"								</li>\n" +
"								<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\" onclick=\"DinamicoDiv('preguntaNutri');\">¿Eres nutriólogo?</a></li>\n" +
"                                                                <li class=\"nav-item\"><a class=\"nav-link\" href=\"#\" onclick=\"DinamicoDiv('sesion');\">Inicio Sesión</a></li>\n" +
"							</ul>\n" +
"						</div> \n" +
"					</div>\n" +
"            	</nav>\n" +
"            </div>\n" +
"        </header>\n" +
"        \n" +
"        <!--================Header Menu Area =================-->\n" +
"        \n" +
"        <!--================Home Banner Area =================-->\n" +
"        \n" +
"        <section class=\"home_banner_area\">\n" +
"           	<div class=\"box_1620\">\n" +
"           		<div class=\"banner_inner d-flex align-items-center\">\n" +
"					<div class=\"container\">\n" +
"						<div class=\"banner_content text-center\">\n" +
"							<h3>Nutri Web<br />Mejora tu salud</h3>\n" +
"							<p>Deseas llevar un plan de nutrición de manera fácil y sencilla, pues regístrate y nosotros te contactamos con un nutriólogo especializado.</p>\n" +
"							<a class=\"main_btn\" href=\"#\" onclick=\"DinamicoDiv('pregunta');\">Regístrarse</a>\n" +
"						</div>\n" +
"					</div>\n" +
"				</div>\n" +
"            </div>\n" +
"        </section>\n" +
"        <!--================End Home Banner Area =================-->\n" +
"");
             out.println();
             while(cdr.next()){
             out.println("<center>"
                     + "<h1> "+ cdr.getString("titulo")+" <h1>"
                     + "<img src=\""+  cdr.getString("foto") +"\" width=\"600\" height=\"450\" align=\" center\" >"
                     + "<p> DESCRIPCIÓN:"+ cdr.getString("descripcion") +"</p>"
                     + "<p>La cedula del nutri&oacute;logo es:" + cdr.getString("cedula") +"</p>"
                     + "</center><br>");
             }
            out.println("<a href='DUsuariosInicioSesion.jsp'></a><center><u><b>REGRESAR<u><b></center>");
            out.println("</body></html>");
        } catch (SQLException e) {
            out.println("Excepción SQL: " + e.getMessage());
        } catch (NullPointerException e) {
            out.println("Apuntando SQL: " + e.getMessage());
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
