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
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(urlPatterns = {"/MUsuWebCita1"})
public class MUsuWebCita1 extends HttpServlet {
    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();

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
            out.println("<title>Servlet MUsuWebCita1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MUsuWebCita1 at " + request.getContextPath() + "</h1>");
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
            response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String fecha, hora, conF, con, ced, ingre, usu;
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
"        <!--================End Home Banner Area =================--><br><br><br><center><br><br>");
            fecha = request.getParameter("fecha");
            hora = request.getParameter("hora");
            ced = request.getParameter("ced");
            con = "SELECT status FROM nutriologo where cedula=" + ced;
            cdr = sentenciaSQL.executeQuery(con);
            while (cdr.next()) {
                if (cdr.getString("status").equalsIgnoreCase("disponible")) {
                    conF = "SELECT count(*) verFecha FROM cita where fecha='" + fecha + "' and hora='" + hora + "' and cedula=" + ced;
                    cdr = sentenciaSQL.executeQuery(conF);
                    while (cdr.next()) {
                        if (cdr.getInt("verFecha") > 0) {
                            out.println("<br><br><br><br><br><br><h2>La fecha u hora ya estas ocupados</h2><br><br><br>");
                            out.println("<button class=\"main_btn2\" onclick=\"buscarOpcionMUsuWebCitaAceptar();\">Regresar a la lista</button><br><br><br><br><br><br>");
                        } else {
                            usu = "Select id_user_web from usuarioweb where usuario=(select usuario from iniciosesion)";
                            cdr = sentenciaSQL.executeQuery(usu);
                            while (cdr.next()) {
                                ingre = "insert into cita values(null," + ced + "," + cdr.getString("id_user_web") + ",'" + fecha + "','" + hora + "')";
                                sentenciaSQL.executeUpdate(ingre);
                                out.println("<h1>Cita agendada</h1>");
                                String nom = "Select concat(nombre,' ',paterno) nombrenut from usuario where usuario=(select usuario from nutriologo where cedula=" + ced + ")";
                                cdr = sentenciaSQL.executeQuery(nom);
                                out.println("<br><br><br><table width=30% border=0>");
                                out.println("<tr>");
                                while (cdr.next()) {
                                    out.println("<th> Fecha   </th><th>Hora</th><th>Nutri&oacute;logo</th>");
                                    out.println("<tr>");
                                    out.println("<td width=30%>" + fecha + "</td>");
                                    out.println("<td width=20%>" + hora + "</td>");
                                    out.println("<td width=30%>" + cdr.getString("nombrenut") + "</td>");
                                }
                                out.println("</tr></table><br><br><br>");
                                //out.println("</br></br><button onclick=\"buscarOpcionMUsuWebCitaImpimir();\">Imprimir pdf</button>");
                                out.println("<button class=\"main_btn2\" onclick=\"buscarOpcionMUsuWebCitaAceptar();\">Aceptar</button>");
                                out.println("<button class=\"main_btn2\" onclick=\"buscarOpcionMUsuWebCitaCancelar();\">Cancelar cita</button>");
                                out.println("<div id=\"detalle3\" align=\"center\"></div><br><br><br><br><br><br><br></center><br>");
                            }
                        }
                    }
                } else {
                    out.println("<br><br><br><br><br><h2>El nutri&oacute;logo no esta disponible</h2><br><br><br>");
                    out.println("<button class=\"main_btn2\" onclick=\"buscarOpcionMUsuWebCitaAceptar();\">Regresar a la lista</button><br><br><br><br><br><br>");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MUsuWebCita1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
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
