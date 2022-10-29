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
import javax.servlet.RequestDispatcher;
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
@WebServlet(urlPatterns = {"/ServRegRUsuarioWeb"})
public class ServRegRUsuarioWeb extends HttpServlet {
    ResultSet cdr=null;
    Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        
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
            out.println("<title>Servlet ServRegRUsuarioWeb</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRegRUsuarioWeb at " + request.getContextPath() + "</h1>");
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
        String usuario, contra, confir, nomb, pate, mate, tipo;
        String cedula, fot, colonia, call, house, descrip, status, correo;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        
        contra=request.getParameter("pass");
        confir=request.getParameter("confpass");
        usuario=request.getParameter("us");
        
        
        nomb=request.getParameter("nom");
        pate=request.getParameter("pat");
        mate=request.getParameter("mat");
        correo=request.getParameter("email");
        tipo="usuarioWeb";
        
        
        
        
        if(contra.equalsIgnoreCase(confir)){
        
                try{
        
        contra=request.getParameter("pass");
        confir=request.getParameter("confpass");
        nomb=request.getParameter("nom");
        pate=request.getParameter("pat");
        mate=request.getParameter("mat");
        tipo="usuarioWeb";
        
        correo=request.getParameter("email");
        
        
        
        
        
        
        
        
            
            String strComando="INSERT INTO usuario VALUES ('" + usuario + "','" + contra + "','" + tipo + "','" + nomb + "','" + pate + "','" + mate + "')";
            sentenciaSQL.executeUpdate(strComando);
            
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }   catch (SQLException ex) {
            out.println("Usuario ya existente");
            }
            
            
        
        
        
        
        try{
       
        correo=request.getParameter("email");
        
          
        
            /*String strComando3="SELECT * FROM usuario where usuario='"+usuario+"';";
            sentenciaSQL.executeQuery(strComando3);
            String user=cdr.getString("usuario");*/
            
        
        
            String strComando2="INSERT INTO usuarioWeb VALUES (null, '" + correo +"','" + usuario + "')";
            sentenciaSQL.executeUpdate(strComando2);
            
        
            out.println("Registro exitoso. Tu usuario de ingreso es: "+  usuario);
            
            
            out.println("<br><h2>***IMPORTANTE***</h2>");
            out.println("<h3>A continuación debes iniciar sesi&oacuten para gozar de los increibles beneficios de nuestro sitio</h3><br><br>");
            
            out.println("<br/><button class=\"main_btn2\" href=\"#\" onclick=\"DinamicoDiv('sesion');\">Continuar</button>");
            
            
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }   catch (SQLException ex) {
            
            
            out.println("No se pudo registrar el usuario" + ex.getMessage());
            
            }
        
        
        }else {
            out.println("La contraseña no coincide");
        
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
