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
@WebServlet(urlPatterns = {"/MPacienEvaluar"})
public class MPacienEvaluar extends HttpServlet {
    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    String usuu, id_paciente;
    String  usuario = null, nombre = null, paterno = null, materno = null, cedula = null;
        String usuarioNutriologo = null, nombreN = null, paternoN = null, maternoN = null;

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
            out.println("<title>Servlet MPacienEvaluar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MPacienEvaluar at " + request.getContextPath() + "</h1>");
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
        
            out.println("<header class=\"header_area\">\n" +
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
"							<h2>¡Bienvenido Paciente!</h2>\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>\n" +
"				</div>\n" +
"            \n" +
"        </section>\n" +
"        <!--================End Home Banner Area =================-->");
            out.println("<center><br><br><h1>Nutri&oacute;logo</h1>");
            //out.println("<form action=\"\" method=\"post\">");
            
        
        try{
        String strComando3 = "select * from iniciosesion;";
            cdr = sentenciaSQL.executeQuery(strComando3);

            while (cdr.next()) {
                usuu = cdr.getString("usuario");
            }
            
            } catch (SQLException ex) {
             out.println("Error"+ex);
         }
        
        
        
        try{
        String strComando3 = "select * from paciente where usuario='"+usuu+"';";
            cdr = sentenciaSQL.executeQuery(strComando3);

            while (cdr.next()) {
                id_paciente = cdr.getString("id_paciente");
            }
            
            } catch (SQLException ex) {
             out.println("Error"+ex);
         }
        
        
        
        try{
        String strComando3 = "select cedula"
                    + " from compradieta "
                    + "where id_paciente = " + id_paciente + ";";
            cdr = sentenciaSQL.executeQuery(strComando3);

            while (cdr.next()) {
                cedula = cdr.getString("cedula");
            }
            
            } catch (SQLException ex) {
             out.println("Error"+ex);
         }
        
        try{
            String strComando4 = "select usuario "
                    + "from nutriologo "
                    + "where cedula = " + cedula + ";";
            cdr = sentenciaSQL.executeQuery(strComando4);

            while (cdr.next()) {
                usuarioNutriologo = cdr.getString("usuario");
            }
            
            } catch (SQLException ex) {
             out.println("Error"+ex);
         }

        try{
            String strComando5 = "Select * from usuario\n"
                    + "where usuario.usuario = '" + usuarioNutriologo + "';";
            cdr = sentenciaSQL.executeQuery(strComando5);

            while (cdr.next()) {
                nombreN = cdr.getString("nombre");
                paternoN = cdr.getString("paterno");
                maternoN = cdr.getString("materno");
            }

            out.println("</br></br>Para: Nutri&oacute;logo. <h3>" + nombreN + " " + paternoN + " " + maternoN+"</h3>");
        
            out.println("");
            out.println("<br>Evaluar a nutri&oacute;logo: ");
            out.println("  <br><p class=\"clasificacion\"><br><br>\n"
                    + "    <input id=\"radio1\" type=\"radio\" name=\"estrellas\" value=\"2\"><!--\n"
                    + "    --><label for=\"radio1\">No fue de mi agrado.</label><!--\n"
                    + "    --><br><input id=\"radio2\" type=\"radio\" name=\"estrellas\" value=\"4\"><!--\n"
                    + "    --><label for=\"radio2\">No atiende bien.</label><!--\n"
                    + "    --><br><input id=\"radio3\" type=\"radio\" name=\"estrellas\" value=\"6\"><!--\n"
                    + "    --><label for=\"radio3\">Le doy un 6.</label><!--\n"
                    + "    --><br><input id=\"radio4\" type=\"radio\" name=\"estrellas\" value=\"8\"><!--\n"
                    + "    --><label for=\"radio4\">Está bien pero aun le falta.</label><!--\n"
                    + "    --><br><input id=\"radio5\" type=\"radio\" name=\"estrellas\" value=\"10\"><!--\n"
                    + "    --><label for=\"radio5\">Muy bueno Excelente Servicio.</label>\n"
                    + "  </p>");
            out.println("<br>Comentario: <input type=\"text\" id=\"com\"><br>");
            out.println("<br/><br><button class=\"main_btn2\" onclick=\"buscarOpcionMPacienEvaluar1("+cedula+");\">Evaluar nutri&oacute;logo</button><br>");
            out.println("<div id=\"mensaje\" align=\"center\"></div><br><br></center>");
            //out.println("</form>");
        }catch (SQLException ex) {
             out.println("Error"+ex);
         }
    }
        
         

    

    public void destroy() {
        conecta.cerrar();
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
