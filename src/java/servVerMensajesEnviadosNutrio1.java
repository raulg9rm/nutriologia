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
@WebServlet(urlPatterns = {"/servVerMensajesEnviadosNutrio1"})
public class servVerMensajesEnviadosNutrio1 extends HttpServlet {
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
            out.println("<title>Servlet servVerMensajesEnviadosNutrio1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servVerMensajesEnviadosNutrio1 at " + request.getContextPath() + "</h1>");
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
            //processRequest(request, response);
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id_mensaje;
        id_mensaje = request.getParameter("id_mensaje");
        String id_paciente = null, cedula = null, fecha = null, asunto = null, mensaje = null, nombre = null, paterno = null, materno = null, usuario = null;
        String usuarioNutriologo = null, nombreN = null, paternoN = null, maternoN = null;
        try {            
            
           String strComando = "SELECT * \n"
                    + "FROM mensaje\n"
                    + " where id_mensaje= " + id_mensaje + " and tipoMensaje='respuesta';";
            cdr = sentenciaSQL.executeQuery(strComando);

            while (cdr.next()) {
                id_paciente = cdr.getString("id_paciente");
                cedula  = cdr.getString("cedula");
                fecha  = cdr.getString("fecha");
                asunto  = cdr.getString("asunto");
                mensaje  = cdr.getString("mensaje");
            }
            out.println("<header class=\"header_area\">\n" +
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
"								<li class=\"nav-item\"><a class=\"nav-link\" href=\"about-us.html\">Calcular IMC</a></li> \n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Plan de dieta</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"ServActRDatosNutriologo\">Crear</a>\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"actRStatusNutriologo.jsp\">Editar</a></li>\n" +
"									</ul>\n" +
"								</li>\n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Editar</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"ServActRDatosNutriologo\">Perfil</a>\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"actRStatusNutriologo.jsp\">Status</a></li>\n" +
"									</ul>\n" +
"								</li> \n" +
"								 <li class=\"nav-item\"><a class=\"nav-link\"  onclick=\"registraRYC();\">Publicar</a></li>\n" +
"                                                                 <li class=\"nav-item\"><a class=\"nav-link\" href=\"DNutriologoPublicacionRYC.jsp\">Mensajes</a></li>\n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"                                                                    <a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Nutri&oacute;logo</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"single-blog.html\">Cerrar Sesión</a></li>\n" +
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
"							<h2>Mensajes recibidos</h2>\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>\n" +
"				</div>\n" +
"            \n" +
"        </section>\n" +
"        <!--================Home Banner Area =================-->");    
            out.println("<center>");
            out.println("<h1>Mensaje</h1>");
            out.println("<");
            
            String strComando2 = "select paciente.usuario"
                    + " from paciente"
                    + " where id_paciente="+id_paciente+";";
            cdr = sentenciaSQL.executeQuery(strComando2);

            while (cdr.next()) {
                usuario = cdr.getString("paciente.usuario");
            }

            String strComando3 = "Select * from usuario\n"
                    + "where usuario.usuario = '" + usuario + "';";
            cdr = sentenciaSQL.executeQuery(strComando3);

            while (cdr.next()) {
                nombre = cdr.getString("nombre");
                paterno = cdr.getString("paterno");
                materno = cdr.getString("materno");
            }
            out.println("Para: "+ nombre +" "+ paterno +" "+ materno);
            
            
            String strComando4 = "select usuario "
                    + "from nutriologo "
                    + "where cedula = " + cedula + ";";
            cdr = sentenciaSQL.executeQuery(strComando4);

            while (cdr.next()) {
                usuarioNutriologo = cdr.getString("usuario");
            }

            String strComando5 = "Select * from usuario\n"
                    + "where usuario.usuario = '" + usuarioNutriologo + "';";
            cdr = sentenciaSQL.executeQuery(strComando5);

            while (cdr.next()) {
                nombreN = cdr.getString("nombre");
                paternoN = cdr.getString("paterno");
                maternoN = cdr.getString("materno");
            }

            out.println("</br></br>De : Nutri&oacute;logo. " + nombreN + " " + paternoN + " " + maternoN);
            out.println("</br></br>Fecha: " + fecha);
            out.println("</br></br>Asunto: " + asunto);
            out.println("</br></br>Mensaje: " + mensaje);
            
            out.println("<center><button id=\"button\" class=\"main_btn2\" onclick=\"verMensajesNutrio();\">Regresar</button></center></center><br><br><br>");
//                    + "<button id=\"button\"  onclick=\"enviarMensajes();\">Responder</button>");
            
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
