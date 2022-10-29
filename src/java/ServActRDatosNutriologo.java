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
@WebServlet(urlPatterns = {"/ServActRDatosNutriologo"})
public class ServActRDatosNutriologo extends HttpServlet {
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
            out.println("<title>Servlet ServActRDatosNutriologo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServActRDatosNutriologo at " + request.getContextPath() + "</h1>");
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
        
        strComandoMachin = "select * from iniciosesion;";
        try {
            cdr = sentenciaSQL.executeQuery(strComandoMachin);
            while(cdr.next()){
                usu = cdr.getString("usuario");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServActRDatosNutriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        strComandoMachin2 = "select * from nutriologo where usuario='"+usu+"';";
        try {
            cdr = sentenciaSQL.executeQuery(strComandoMachin2);
            while(cdr.next()){
                cedu = cdr.getString("cedula");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServActRDatosNutriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try{
            String strComando="select cedula, nutriologo.usuario, usuario.nombre, usuario.paterno, "
                    + "usuario.materno, foto, colonia, calle, no_casa, descripcion, no_cuenta_tarjeta,"
                    + "status from nutriologo INNER JOIN usuario on "
                    + "usuario.usuario=nutriologo.usuario where cedula='"+cedu+"';";
            cdr = sentenciaSQL.executeQuery(strComando);
            out.println(" <header class=\"header_area\">\n" +
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
"							<h2>Actualiza los datos cada que lo necesites.</h2>\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>\n" +
"				</div>\n" +
"            \n" +
"        </section>\n" +
"        \n" +
"        <!--================End Home Banner Area =================-->");
            out.println("<!--================About Area =================-->\n" +
"            <section class=\"about_area pad_top\">\n" +
"                <div class=\"container\">\n" +
"                                <div class=\"row h_blog_item\">\n" +
"        				\n" +
"						<div class=\"col-lg-6\">\n" +
"							<div class=\"h_blog_text\">\n" +
"								<div class=\"h_blog_text_inner left\">\n" +
"									<h4>Actualiza tus datos</h4>");
            while(cdr.next()){
            out.println("<h3>Usuario</h3>\n" +
"                                                                        <input type='text' id='usu' value='"+cdr.getString("usuario")+"' disabled='disabled'>\n" +
"                                                                        <h3>Status</h3>\n" +
"                                                                        <input type='text' id='sta' value='"+cdr.getString("status")+"' disabled='disabled'>\n" +
"                                                                        <h3>Nombre</h3>\n" +
"                                                                        <input type='text' id='nom' value='"+cdr.getString("nombre")+"' disabled='disabled'>\n" +
"                                                                        <h3>Apellido paterno</h3>\n" +
"                                                                        <input type='text' id='pat' value='"+cdr.getString("paterno")+"' disabled='disabled'>\n" +
"                                                                        <h3>Apellido materno</h3>\n" +
"                                                                        <input type='text' id='mat' value='"+cdr.getString("materno")+"' disabled='disabled'>\n" +
"                                                                        <h3>Colonia</h3>\n" +
"                                                                        <input type='text' id='col10' value='"+cdr.getString("colonia")+"'>\n" +
"                                                                        <h3>Calle</h3>\n" +
"                                                                        <input type='text' id='call10' value='"+cdr.getString("calle")+"'>\n" +
"                                                                        <h3>No. de Casa</h3>\n"+
"                                                                        <input type='text' id='cas10' value='"+cdr.getString("no_casa")+"'>\n" +
"                                                                        <h3>Foto</h3>\n" +
"                                                                        <input type='file' id='fileFoto10'>\n" +
"                                                                        <h3>No. de Tarjeta</h3>\n" +
"                                                                        <input type='text' id='tar' value='"+cdr.getString("no_cuenta_tarjeta")+"'>\n" +
"                                                                        <h3>Descripción</h3>\n" +
"                                                                        <textarea id='desc10' rows=\"10\" cols=\"50\" value='"+cdr.getString("descripcion")+"'>"+cdr.getString("descripcion")+"</textarea>\n" +

"                                                                        <br>\n" +
"                                                                        <br>\n" +
"                                                                        <button onclick=\"actPerfilNutri2();\" class=\"main_btn2\">Guardar cambios</button>\n" +
"                                                                        <br><br><div id='actuNutri'></div>");
            
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
