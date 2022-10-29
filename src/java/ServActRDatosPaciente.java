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
@WebServlet(urlPatterns = {"/ServActRDatosPaciente"})
public class ServActRDatosPaciente extends HttpServlet {
    ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        String strComandoMachin, strComandoMachin2, cedu, usu;
        
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
            out.println("<title>Servlet ServActRDatosPaciente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServActRDatosPaciente at " + request.getContextPath() + "</h1>");
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
        PrintWriter out= response.getWriter();
        String id="4";
        
        strComandoMachin = "select * from iniciosesion;";
        try {
            cdr = sentenciaSQL.executeQuery(strComandoMachin);
            while(cdr.next()){
                usu = cdr.getString("usuario");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServActRDatosNutriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        strComandoMachin2 = "select * from paciente where usuario='"+usu+"';";
        try {
            cdr = sentenciaSQL.executeQuery(strComandoMachin2);
            while(cdr.next()){
                cedu = cdr.getString("id_paciente");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServActRDatosNutriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try{
            String strComando="select id_paciente, paciente.usuario, usuario.nombre, usuario.paterno, "
                    + "usuario.materno, foto, correo from paciente INNER JOIN usuario "
                    + "on usuario.usuario=paciente.usuario where id_paciente='"+cedu+"';";
            cdr = sentenciaSQL.executeQuery(strComando);
            out.println(" <header class=\"header_area\">\n" +
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
"        <!--================Home Banner Area =================-->\n" +
"        <section class=\"banner_area\">\n" +
"            <div class=\"box_1620\">\n" +
"				<div class=\"banner_inner d-flex align-items-center\">\n" +
"					<div class=\"container\">\n" +
"						<div class=\"banner_content text-center\">\n" +
"							<h2>Edita tus datos cada que lo necesites</h2>\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>\n" +
"				</div>\n" +
"            \n" +
"        </section>\n" +
"        <!--================End Home Banner Area =================-->");
            out.println("<!--================About Area =================-->\n" +
"            <section class=\"about_area pad_top\">\n" +
"                <div class=\"container\">\n" +
"                                <div class=\"row h_blog_item\">\n" +
"        				\n" +
"						<div class=\"col-lg-6\">\n" +
"							<div class=\"h_blog_text\">\n" +
"								<div class=\"h_blog_text_inner left\">\n" +
"									<h4>Actualiza tus datos</h4>\n" +
"                                                                        ");
            while(cdr.next()){
            out.println("<h3>Usuario</h3>\n" +
"                                                                        <input type='text' id='usu' value='"+cdr.getString("usuario")+"' disabled='disabled'>\n" +
"                                                                        <h3>Nombre</h3>\n" +
"                                                                        <input type='text' id='nom' value='"+cdr.getString("nombre")+"' disabled='disabled'>\n" +
"                                                                        <h3>Apellido paterno</h3>\n" +
"                                                                        <input type='text' id='pat' value='"+cdr.getString("paterno")+"' disabled='disabled'>\n" +
"                                                                        <h3>Apellido materno</h3>\n" +
"                                                                        <input type='text' id='mat' value='"+cdr.getString("materno")+"' disabled='disabled'>\n" +
"                                                                        <h3>Correo</h3>\n" +
"                                                                        <input type='text' id='cor' value='"+cdr.getString("correo")+"'>\n" +
"                                                                        <h3>Foto</h3>\n" +
"                                                                        <input type='file' id='fileFoto' value='"+cdr.getString("foto")+"'>\n" +
"                                                                        <br>\n" +
"                                                                        <br>\n" +
"                                                                        <button onclick=\"actDatosPaciente2();\" class=\"main_btn2\">Guardar cambios</button>\n" +
"                                                                        <div id='actPaciente'></div>");
            
        out.println("</div>\n" +
"							</div>\n" +
"						</div>\n" +
"                                                                        <div class=\"col-lg-6\">\n" +
"							<div class=\"h_blog_img\">\n" +
"								<img class=\"img-fluid\" src=\"img/home-blog/actualizar.png\" alt=\"\">\n" +
"							</div>\n" +
"						</div>\n" +
"        			</div>\n" +
"                </div>\n" +
"            </section>\n" +
"        <!--================End About Area =================-->");
            }
        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
        
    }
    
    public void destroy(){
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
