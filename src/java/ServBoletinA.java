/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Danny Delgadillo
 */
@WebServlet(urlPatterns = {"/ServBoletinA"})
public class ServBoletinA extends HttpServlet {

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
            out.println("<title>Servlet ServBoletinA</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServBoletinA at " + request.getContextPath() + "</h1>");
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
out.println("<head>\n" +
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
"        <script src=\"administrador.js\" type=\"text/javascript\"></script>\n" +
"        <!--================Header Menu Area =================-->\n" +
"        <div id=\"inicioAd\">\n" +
"        <header class=\"header_area\">\n" +
"            <div class=\"main_menu\">\n" +
"            	<nav class=\"navbar navbar-expand-lg navbar-light\">\n" +
"					<div class=\"container\">\n" +
"						<!-- Brand and toggle get grouped for better mobile display -->\n" +
"						<a class=\"navbar-brand logo_h\" href=\"principalRAdministrador.jsp\"><img src=\"img/logo.png\" alt=\"\"></a>\n" +
"						<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"							<span class=\"icon-bar\"></span>\n" +
"							<span class=\"icon-bar\"></span>\n" +
"							<span class=\"icon-bar\"></span>\n" +
"						</button>\n" +
"						<!-- Collect the nav links, forms, and other content for toggling -->\n" +
"						<div class=\"collapse navbar-collapse offset\" id=\"navbarSupportedContent\">\n" +
"							<ul class=\"nav navbar-nav menu_nav ml-auto\">\n" +
"                                                            \n" +
"								<li class=\"nav-item active\"><a class=\"nav-link\" href=\"principalRAdministrador.jsp\">Inicio</a></li> \n" +
"								<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"buscarOpcionMAdministradorSub();\">Subir alimentos</a></li> \n" +
"                                                               \n" +
"							 \n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Planes de Nutriólogo</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"buscarOpcionMAdministrador();\">Crear suscripci&oacute;n</a></li>\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"buscarOpcionMAdministrador2();\">Editar</a></li>\n" +
"                                                                                \n" +
"									</ul>\n" +
"								</li>\n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Ver</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"                                                                                 <li class=\"nav-item\"><a class=\"nav-link\" onclick=\"boletin();\" >Boletin</a></li>\n" +
"                                                                        </ul>\n" +
"								</li>\n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"                                                                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Admin</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"index.jsp\">Cerrar Sesión</a></li>\n" +
"									</ul>\n" +
"								</li> \n" +
"								\n" +
"								\n" +
"							</ul>\n" +
"						</div> \n" +
"					</div>\n" +
"            	</nav>\n" +
"            </div>\n" +
"        </header>\n" +
"        <!--================Header Menu Area =================-->\n" +
"      <br/><br/><br/><br/><br/>");

        out.println("<center>");
        out.println("<h1>¿Sabias qué?</h1>");
     
        out.println("<img src=\"sq1.jpg\" width=\"250\" height=\"350\">&nbsp;&nbsp;&nbsp;"
                + "<img src=\"sq2.jpg\" width=\"250\" height=\"350\"><br><br>"
                + "<img src=\"sq3.jpg\" width=\"250\" height=\"350\">&nbsp;&nbsp;&nbsp;"
                + "<img src=\"sq4.png\" width=\"250\" height=\"350\"><br><br>"
                + "<img src=\"sq5.jpg\" width=\"250\" height=\"300\">&nbsp;&nbsp;&nbsp;"
                + "<img src=\"sq6.jpg\" width=\"250\" height=\"300\"><br><br>");
        out.println("<h1>Un poco de humor!!</h1>");
        out.println("<img src=\"m1.jpg\" width=\"300\" height=\"300\">&nbsp;&nbsp;&nbsp;"
                + "<img src=\"m2.jpg\" width=\"300\" height=\"300\"><br><br>"
                + "<img src=\"m4.jpg\" width=\"300\" height=\"300\">&nbsp;&nbsp;&nbsp;"
                + "<img src=\"m3.png\" width=\"300\" height=\"300\"><br><br>"
                + "<img src=\"m5.jpg\" width=\"300\" height=\"300\">&nbsp;&nbsp;&nbsp;"
                + "<img src=\"m6.jpg\" width=\"300\" height=\"300\"><br><br>");
        out.println("</center>");
       
        
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
