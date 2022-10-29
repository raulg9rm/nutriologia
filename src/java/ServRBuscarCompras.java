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
@WebServlet(urlPatterns = {"/ServRBuscarCompras"})
public class ServRBuscarCompras extends HttpServlet {
    ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int cont=0;
        String cedula, usuu;
        
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
            out.println("<title>Servlet ServRBuscarCompras</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRBuscarCompras at " + request.getContextPath() + "</h1>");
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
        
        
        try{
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
"								<li class=\"nav-item active\"><a class=\"nav-link\" href=\"#\" onclick=\"DinamicoDiv('inicioPa');\">Inicio</a></li> \n" +
"								<li class=\"nav-item\"><a class=\"nav-link\" href=\"#\" onclick=\"DinamicoDiv('imc');\">Calcular IMC</a></li> \n" +
"                                                                <li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Dieta</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" onclick=\"buscarNutriologos();\">Comprar / Renovar</a>\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"actRStatusNutriologo.jsp\">Mirar</a></li>\n" +
"                                                                                <li class=\"nav-item\"><a class=\"nav-link\" href=\"actRStatusNutriologo.jsp\">Cancelar Plan</a></li>\n" +
"									</ul>\n" +
"								</li> \n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Editar</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"ServActRDatosPaciente\">Perfil</a>\n" +
"									</ul>\n" +
"								</li> \n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Mensajes</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"                                                                                <li class=\"nav-item\"><a class=\"nav-link\" href=\"DPacienteHistoriaExito.jsp\">Redactar</a></li>\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"DPacienteHistoriaExito.jsp\">Notificaciones</a></li>\n" +
"                                                                               \n" +
"									</ul>\n" +
"								</li> \n" +
"								<li class=\"nav-item submenu dropdown\">\n" +
"									<a href=\"#\" class=\"nav-link dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-haspopup=\"true\" aria-expanded=\"false\">Paciente</a>\n" +
"									<ul class=\"dropdown-menu\">\n" +
"										<li class=\"nav-item\"><a class=\"nav-link\" href=\"single-blog.html\">Mi cuenta</a></li>\n" +
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
"							<h2>Historial de compras</h2>\n" +
"							</div>\n" +
"						</div>\n" +
"					</div>\n" +
"				</div>\n" +
"            \n" +
"        </section>\n" +
"        <!--================End Home Banner Area =================-->");
            
            
             String strComando3="SELECT * FROM iniciosesion;";
            cdr = sentenciaSQL.executeQuery(strComando3);
            while(cdr.next()){
                usuu=cdr.getString("usuario");
                out.println("<br><br><center><h2>Dietas compradas por el usuario: "+cdr.getString("usuario")+"</h2></center>");
            }
            
            String strComando="select dieta.nombre, compradieta.costo, no_cuenta_tarjeta, fecha, estatus from compradieta "
                    + "INNER JOIN paciente on paciente.id_paciente=compradieta.id_paciente "
                    + "INNER JOIN dieta on dieta.id_dieta=compradieta.id_dieta where usuario='"+usuu+"';";
            cdr = sentenciaSQL.executeQuery(strComando);
            /*out.println("<html><head><link href=\"CSS/ejemplo2.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<title>Control de Pilotos</title></head>");
            out.println("<body> <img src=\"img/avionlogo.png\" alt=\"\" height=\"50\" width=\"50\"/>");*/
            
            
            out.println("<br>");
            out.println("<center><table width=50% border=1>");
            out.println("<tr>");
            
            out.println("<th>Dieta</th><th>Costo</th><th>No. de cuenta de tarjeta</th><th>Fecha</th><th>Estado</th>");
            out.println("</tr>");
            while(cdr.next()){
                cont++;
                out.println("<tr>");
                
                out.println("<td id='"+cont+"'width=10%>" + cdr.getString("nombre") + "</td>");
                out.println("<td id='"+cont+"'width=10%>" + cdr.getString("costo") + "</td>");
                out.println("<td id='"+cont+"'width=10%>" + cdr.getString("no_cuenta_tarjeta") + "</td>");
                out.println("<td id='"+cont+"'width=10%>" + cdr.getString("fecha") + "</td>");
                out.println("<td id='"+cont+"'width=10%>" + cdr.getString("estatus") + "</td>");
                out.println("</tr>");
                
            }
            cont=0;
            
            
            
                out.println("</center></table>");
                out.println("<br><br><br><br><br>");
                
                
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
