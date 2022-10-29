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
@WebServlet(urlPatterns = {"/ServRBuscarMisDietas"})
public class ServRBuscarMisDietas extends HttpServlet {
    ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int cont=0;
        String cedula, usuu, idpa;
        
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
            out.println("<title>Servlet ServRBuscarMisDietas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRBuscarMisDietas at " + request.getContextPath() + "</h1>");
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
"        \n" +
"        <!--================Home Banner Area =================-->\n" +
"        <section class=\"banner_area\">\n" +
"            <div class=\"box_1620\">\n" +
"				<div class=\"banner_inner d-flex align-items-center\">\n" +
"					<div class=\"container\">\n" +
"						<div class=\"banner_content text-center\">\n" +
"							<h2>Bienvenido Paciente...!!!</h2>\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>\n" +
"				</div>\n" +
"            \n" +
"        </section>\n" +
"        <!--================End Home Banner Area =================-->");
        //cedula=request.getParameter("id");
        try{
            
             String strComando3="SELECT * FROM iniciosesion;";
            cdr = sentenciaSQL.executeQuery(strComando3);
            while(cdr.next()){
                usuu=cdr.getString("usuario");
                out.println("<center><h2>Dietas disponibles del usuario: "+usuu+"</h2></center>");
            }
            
            }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
        
        
        try{
            
             String strComando3="SELECT * FROM paciente where usuario='"+usuu+"';";
            cdr = sentenciaSQL.executeQuery(strComando3);
            while(cdr.next()){
                idpa=cdr.getString("id_paciente");
                
            }
            
            }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
            
        
        try{
            String strComando="select dieta.id_dieta, dieta.nombre, descripcion, duracion, estatus from dieta INNER JOIN compradieta on compradieta.id_dieta=dieta.id_dieta  where id_paciente='"+idpa+"' and estatus='vigente' group by dieta.id_dieta";
            cdr = sentenciaSQL.executeQuery(strComando);
            /*out.println("<html><head><link href=\"CSS/ejemplo2.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<title>Control de Pilotos</title></head>");
            out.println("<body> <img src=\"img/avionlogo.png\" alt=\"\" height=\"50\" width=\"50\"/>");*/
            
            
            out.println("<br>");
            out.println("<center><table width=50% border=1>");
            out.println("<tr>");
            
            out.println("<th>Nombre</th><th>Descripcion</th><th>Duracion (meses)</th><th></th>");
            out.println("</tr>");
            while(cdr.next()){
                cont++;
                out.println("<tr>");
                
                out.println("<td id='"+cont+"'width=10%>" + cdr.getString("nombre") + "</td>");
                out.println("<td id='"+cont+"'width=10%>" + cdr.getString("descripcion") + "</td>");
                out.println("<td id='"+cont+"'width=10%>" + cdr.getString("duracion") + "</td>");
                out.println("<td width=10%><button id='el' value='0' class=\"main_btn2\" onclick='mostrarDieta("+cdr.getString("id_dieta")+");'>Seleccionar</button></td>");
                out.println("</tr>");
                
            }
            cont=0;
            
            
            
                out.println("</center></table>");
                out.println("<br><br>");
                
                out.println("<div id=\"detalleMisDieta\" align=\"center\">\n" +
"                                            \n" +
"                                    </div>");
                out.close();
                
        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
        out.close();
        
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
