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
@WebServlet(urlPatterns = {"/MNutriEditarPlanDieta2"})
public class MNutriEditarPlanDieta2 extends HttpServlet {

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
            out.println("<title>Servlet MNutriEditarPlanDieta2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MNutriEditarPlanDieta2 at " + request.getContextPath() + "</h1>");
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
        String edi;
        try {
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
"        <center><br><br><br>");
            edi=request.getParameter("edi");
            String strComando="SELECT * FROM dieta WHERE id_dieta="+edi;
            cdr=sentenciaSQL.executeQuery(strComando);
            
            while(cdr.next()){
                out.println("<br><br><h1>Actualizando "+cdr.getString("nombre")+"</h1>");
            out.println("ID:  <input id=\"idDieta\" type=\"text\" value="+cdr.getString("id_dieta")+" readonly>");
            out.println("<br><br><label>Nombre de dieta: </label> <input id=\"nom\" type=\"text\" value="+cdr.getString("nombre")+"><br><br>");
            //out.println("<br><br><label>Foto: </label> <input id=\"foto\" type=\"file\" value="+cdr.getString("foto")+"><br><br>");
            out.println("<br>Tipo de dieta: ");
            out.println("<select id=\"tipoD\">");
            out.println("<option value="+cdr.getString("tipo")+">"+cdr.getString("tipo")+"</option>");
            out.println("<option value=\"vegetariana\">Vegetariana</option>");
            out.println("<option value=\"normal\">Normal</option>");
            out.println("</select>\n");
            out.println("<br><br><label> Descripci&oacute;n: </label><textarea id=\"desc\">"+cdr.getString("descripcion")+"</textarea></h4></label><br>");
            out.println("<label> Duraci&oacute;n: </label> <input id=\"dura\" type=\"text\" value="+cdr.getString("duracion")+"  meses ><br><br>");
            out.println("<label> Costo:  $</label><input id=\"cos\" type=\"text\" value="+cdr.getString("costo")+"><br><br>"
                    + "<button id=\"button\" class=\"main_btn2\" onclick=\"buscarOpcionMNutriEditarPlanDieta3();\">Actualizar</button><br><br>");
            out.println("<br><br>");
            }
            out.println("<div id=\"mensaje\" align=\"center\"></div><br><br><br></center><br>");
            out.close();
            } catch (SQLException ex) {
            Logger.getLogger(MNutriEditarPlanDieta2.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            out.close();
        }
    }
    public void destroy(){
        conecta.cerrar();
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
