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
@WebServlet(urlPatterns = {"/ServRVerExpediente"})
public class ServRVerExpediente extends HttpServlet {
    ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int cont=0;
        String idpa, usuu, minimo, maximo, maximoid, nombre, pat, mat;
        
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
            out.println("<title>Servlet ServRVerExpediente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRVerExpediente at " + request.getContextPath() + "</h1>");
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

            String strComando8="SELECT * FROM iniciosesion;";
            cdr = sentenciaSQL.executeQuery(strComando8);
            while(cdr.next()){
                usuu=cdr.getString("usuario");
            }

        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
        
        try{

            String strComando8="SELECT * FROM usuario where usuario='"+usuu+"';";
            cdr = sentenciaSQL.executeQuery(strComando8);
            while(cdr.next()){
                nombre=cdr.getString("nombre");
                pat=cdr.getString("paterno");
                mat=cdr.getString("materno");
            }

        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
        
        
        
        
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
             String strComando7="SELECT MIN(id_control_peso), peso FROM controlpeso where id_paciente='"+idpa+"';";
            cdr = sentenciaSQL.executeQuery(strComando7);
            while(cdr.next()){
                minimo=cdr.getString("peso");
            }
            }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
            }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
            }
            
            
            try{
             String strComando4="SELECT MAX(id_control_peso) id FROM controlpeso where id_paciente='"+idpa+"';";
            cdr = sentenciaSQL.executeQuery(strComando4);
            while(cdr.next()){
                maximoid=cdr.getString("id");
            }
            }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
            }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
            }
            
            
            try{
             String strComando11="SELECT * FROM controlpeso where id_control_peso='"+maximoid+"';";
            cdr = sentenciaSQL.executeQuery(strComando11);
            while(cdr.next()){
                maximo=cdr.getString("peso");
            }
            }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
            }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
            }
            
            
            
            
            try{
            String strComando="select * from expediente where id_paciente='"+idpa+"';";
            cdr = sentenciaSQL.executeQuery(strComando);
            /*out.println("<html><head><link href=\"CSS/ejemplo2.css\" rel=\"stylesheet\" type=\"text/css\"/>");
            out.println("<title>Control de Pilotos</title></head>");
            out.println("<body> <img src=\"img/avionlogo.png\" alt=\"\" height=\"50\" width=\"50\"/>");*/
            
            
            out.println("<!--================Feedback Area =================-->\n" +
"        <br><br><br><center><h1>Expediente del usuario: "+usuu+"</h1><section class=\"feedback_area pad_bt\">\n" +
"        	<div class=\"container\">\n" +
"        		<div >\n" +
"        			<div class=\"row\">\n" +
"        				<div class=\"col-lg-5\">\n" +
"        					<div /*class=\"feedback_text\">\n" +
"        						<center><div >\n" +
"								<br><center><img src=\"img/testimonials/testi-1.jpg\" alt=\"\"></center>\n" +
"							</div></center>\n" +
"								<div class=\"media-body\">\n");
            
            while(cdr.next()){
                out.println("<br><h3>Nombre: "+nombre+" "+pat+" "+mat+"</h3>");
                out.println("<h3>Altura: " + cdr.getString("altura")+"</h3>");
                out.println("<h3>Sexo: " + cdr.getString("sexo")+"</h3>");
                out.println("<h3>Edad: " + cdr.getString("edad")+"</h3>");
                out.println("<h3>Enfermedades: " + cdr.getString("enfermedades")+"</h3>");
                out.println("<h3>Alergias: " + cdr.getString("alergias")+"</h3>");
                
                
                out.println("<h3>Peso inicial: " +minimo+"</h3>");
                out.println("<h3>Peso actual: " +maximo+"</h3>");
                out.println("<h3>Peso meta: " + cdr.getString("peso_meta")+"</h3>");
                
                
            }

                out.println("</div>\n" +
"        					</div>\n" +
"        				</div>\n" +
"        				\n" +
"        			</div>\n" +
"        		</div>\n" +
"        	</div>\n" +
"        </section></center>\n" +
"        <!--================End Feedback Area=================-->");
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
