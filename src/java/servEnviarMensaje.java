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
@WebServlet(urlPatterns = {"/servEnviarMensaje"})
public class servEnviarMensaje extends HttpServlet {
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
            out.println("<title>Servlet servEnviarMensaje</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servEnviarMensaje at " + request.getContextPath() + "</h1>");
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
            // processRequest(request, response);

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id_paciente = null, usuario = null, nombre = null, paterno = null, materno = null, cedula = null;
        String usuarioNutriologo = null, nombreN = null, paternoN = null, maternoN = null;
        try {

            String strComando = "SELECT id_paciente, paciente.usuario\n"
                    + "FROM iniciosesion\n"
                    + "inner join paciente\n"
                    + "on paciente.usuario = iniciosesion.usuario;";
            cdr = sentenciaSQL.executeQuery(strComando);

            while (cdr.next()) {
                id_paciente = cdr.getString("id_paciente");
                usuario = cdr.getString("paciente.usuario");
            }

            String strComando2 = "Select * from usuario\n"
                    + "where usuario.usuario = '" + usuario + "';";
            cdr = sentenciaSQL.executeQuery(strComando2);

            while (cdr.next()) {
                nombre = cdr.getString("nombre");
                paterno = cdr.getString("paterno");
                materno = cdr.getString("materno");
            }
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
"        <script src=\"scriptPaciente10.js\" type=\"text/javascript\"></script>\n" +
"        <script src=\"scriptDanPaciente1.js\" type=\"text/javascript\"></script>\n" +
"        <!--================Header Menu Area =================-->\n" +
"        <a onclick=\"DinamicoDiv('mensajespaciente');\" accesskey=\"m\"></a>\n" +
"        <a href=\"principalRPaciente.jsp\" accesskey=\"i\"></a>\n" +
"        <a onclick=\"buscarMisDietas();\" accesskey=\"t\"></a>\n" +
"            <a onclick=\"DinamicoDiv('imc');\" accesskey=\"l\"></a>\n" +
"        <div id=\"inicioPa\">\n" +
"            \n" +
"        <header class=\"header_area\">\n" +
"            <div class=\"main_menu\">\n" +
"            	<nav class=\"navbar navbar-expand-lg navbar-light\">\n" +
"					<div class=\"container\">\n" +
"						<!-- Brand and toggle get grouped for better mobile display -->\n" +
"						<a class=\"navbar-brand logo_h\" href=\"principalRPaciente.jsp\"><img src=\"img/logo.png\" alt=\"\"></a>\n" +
"						<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n" +
"							<span class=\"icon-bar\"></span>\n" +
"							<span class=\"icon-bar\"></span>\n" +
"							<span class=\"icon-bar\"></span>\n" +
"						</button>\n" +
"						<!-- Collect the nav links, forms, and other content for toggling -->\n" +
"						<div class=\"collapse navbar-collapse offset\" id=\"navbarSupportedContent\">\n" +
"							<ul class=\"nav navbar-nav menu_nav ml-auto\">\n" +
"								<li class=\"nav-item active\"><a class=\"nav-link\" href=\"principalRPaciente.jsp\">Inicio</a></li> \n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Ver</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"                                                                                 <li class=\"nav-item\"><a class=\"nav-link\" onclick=\"boletinP();\" >Boletin</a></li>\n" +
"                                                                        </ul>\n" +
"								</li>\n" +
"								<li class=\"nav-item\"><a class=\"nav-link\"  onclick=\"DinamicoDiv('imc');\">Calcular IMC</a></li> \n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Dieta</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\" onclick=\"preguntaPlanDieta();\">Comprar / Renovar</a>\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\" onclick=\"buscarMisDietas();\">Mirar</a></li>\n" +
"                                                                                <li class=\"nav-item\"><a class=\"nav-link\" onclick=\"CancelarDieta();\">Cancelar Plan</a></li>\n" +
"									</ul>\n" +
"								</li> \n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Editar</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"actDatosPaciente();\">Perfil</a>\n" +
"									</ul>\n" +
"								</li> \n" +
"								<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"DinamicoDiv('mensajespaciente');\">Mensajes</a></li> \n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Paciente</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"single-blog.html\">Mi cuenta</a></li>\n" +
"                                                                                <li class=\"nav-item\"><a class=\"nav-link\" onclick=\"recomendarAmigoPA();\">Recomendar amigo</a></li>\n" +
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
"							<h2>Mensajes.</h2>\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>\n" +
"				</div>\n" +
"            \n" +
"        </section>\n" +
"        <!--================End Home Banner Area =================-->\n" +
"    ");
            out.println("<center>");
            out.println("<h1>Redactar Mensaje</h1>");
            
            out.println("</br></br>De: " + nombre + " " + paterno + " " + materno);

            String strComando3 = "select cedula"
                    + " from compradieta "
                    + "where id_paciente = " + id_paciente + ";";
            cdr = sentenciaSQL.executeQuery(strComando3);

            while (cdr.next()) {
                cedula = cdr.getString("cedula");
            }
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

            out.println("</br></br>Para: Nutri&oacute;logo. " + nombreN + " " + paternoN + " " + maternoN);
            out.println("</br></br>Asunto: <input type=\"asunto\" id=\"asunto\">"
                    + "        </br></br><label>Mensaje: </label></br>\n"
                    + "        <textarea id=\"mensaje\" rows=\"10\" cols=\"50\"></textarea><br/><br/>"
                    + " <center><button id=\"button\" class=\"main_btn2\" onclick=\"enviarMensajesServ1("+id_paciente+ ", "+cedula+");\">Enviar</button></center>");
            out.println("<div id=\"EnviarMensaje\"></div><br><br><br>");
            out.println("</center>");
        } catch (NullPointerException e) {
            out.print("Apuntado SQL: " + e.getMessage());
//           Logger.getLogger(servConsAviones.class.getName()).log(Level.SEVERE,null, e);
        } catch (SQLException e) {
            out.println("Error:" + e);
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
