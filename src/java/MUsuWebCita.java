/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conexion.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(urlPatterns = {"/MUsuWebCita"})
public class MUsuWebCita extends HttpServlet {
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    String cedula;

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
            out.println("<title>Servlet MUsuWebCita</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MUsuWebCita at " + request.getContextPath() + "</h1>");
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
        //String ced;
        try {
            out.println("<header class=\"header_area\">\n" +
"            <div class=\"main_menu\">\n" +
"            	<nav class=\"navbar navbar-expand-lg navbar-light\">\n" +
"					<div class=\"container\">\n" +
"						<!-- Brand and toggle get grouped for better mobile display -->\n" +
"						<a class=\"navbar-brand logo_h\" href=\"principalRUsuarioWeb.jsp\"><img src=\"img/logo.png\" alt=\"\"></a>\n" +
"						<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"							<span class=\"icon-bar\"></span>\n" +
"							<span class=\"icon-bar\"></span>\n" +
"							<span class=\"icon-bar\"></span>\n" +
"						</button>\n" +
"						<!-- Collect the nav links, forms, and other content for toggling -->\n" +
"						<div class=\"collapse navbar-collapse offset\" id=\"navbarSupportedContent\">\n" +
"							<ul class=\"nav navbar-nav menu_nav ml-auto\">\n" +
"								<li class=\"nav-item active\"><a class=\"nav-link\" href=\"principalRUsuarioWeb.jsp\">Inicio</a></li> \n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Ver</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"                                                                                 <li class=\"nav-item\"><a class=\"nav-link\" onclick=\"boletinUW();\" >Boletin</a></li>\n" +
"                                                                        </ul>\n" +
"								</li>\n" +
"								<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"DinamicoDiv('imc1');\">Calcular IMC</a></li> \n" +
"								\n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"                                                                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Cita con nutri&oacute;logo</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"buscarOpcionMUsuWebCita();\">Agendar</a>\n" +
"                                                                                    <li class=\"nav-item\"><a class=\"nav-link\" onclick=\"buscarOpcionMUsuWebCancelarCita();\">Cancelar</a>\n" +
"                                                                                        <li class=\"nav-item\"><a class=\"nav-link\" onclick=\"buscarOpcionMUsuaRecordadCita();\">Recordatorios</a>\n" +
"										\n" +
"									</ul>\n" +
"								</li> \n" +
"								\n" +
"                                                                <li class=\"nav-item\"><a class=\"nav-link\" onclick=\"actualizarUsuarioWeb();\">Editar Datos</a></li> \n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Usuario Web</a>\n" +
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
"        <!--================End Home Banner Area =================--><br><br><br><br><br>");
            //ced="Select cedula from nutriologo where usuario=(select usuario from iniciosesion)";
            cedula=request.getParameter("cedula");
            out.println("<center><h1>Agendar cita</h1>\n"
                    + "Cedula:\n"
                    + "<input type=\"text\" id=\"ced\" value="+cedula+" readonly>\n"
                    + "</br></br>\n"
                    + "Fecha:\n"
                    + "<input type=\"date\" id=\"fecha\">\n"
                    + "</br></br>\n"
                    + "Hora:");
            out.println("<select id=\"hora\" onchange=\"buscarOpcionMNutriVerHis2();\">");
            out.println("<option>-Hora-</option>");
            out.println("<option value=\"09:00:00\">09:00:00</option>");
            out.println("<option value=\"09:30:00\">09:30:00</option>");
            out.println("<option value=\"10:00:00\">10:00:00</option>");
            out.println("<option value=\"10:30:00\">10:30:00</option>");
            out.println("<option value=\"11:00:00\">11:00:00</option>");
            out.println("<option value=\"11:30:00\">11:30:00</option>");
            out.println("<option value=\"12:00:00\">12:00:00</option>");
            out.println("<option value=\"12:30:00\">12:30:00</option>");
            out.println("<option value=\"13:00:00\">13:00:00</option>");
            out.println("<option value=\"13:30:00\">13:30:00</option>");
            out.println("<option value=\"15:00:00\">15:00:00</option>");
            out.println("<option value=\"15:30:00\">15:30:00</option>");
            out.println("</select>\n");
                    //+ "<input type=\"time\" id=\"hora\"> \n"
                   // + "<input type=\"radio\" id=\"hora\">09:00 \n"
            out.println("</br></br>\n"
                    + "<br/><br><button class=\"main_btn2\" onclick=\"buscarOpcionMUsuWebCita1();\">Agendar cita</button><br><br>");
            out.println("<div id=\"detalle3\" align=\"center\"></div></center><br><br><br><br><br>");
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
