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
@WebServlet(urlPatterns = {"/ServActRDatosUsuarioWeb2"})
public class ServActRDatosUsuarioWeb2 extends HttpServlet {
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
            out.println("<title>Servlet ServActRDatosUsuarioWeb2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServActRDatosUsuarioWeb2 at " + request.getContextPath() + "</h1>");
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
        String identificador, correo, foto;
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        
        correo=request.getParameter("cor");
        
        
        strComandoMachin = "select * from iniciosesion;";
        try {
            cdr = sentenciaSQL.executeQuery(strComandoMachin);
            while(cdr.next()){
                usu = cdr.getString("usuario");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServActRDatosNutriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        strComandoMachin2 = "select * from usuarioweb where usuario='"+usu+"';";
        try {
            cdr = sentenciaSQL.executeQuery(strComandoMachin2);
            while(cdr.next()){
                cedu = cdr.getString("id_user_web");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServActRDatosNutriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try{
            String regresar="regresar", pag="ServActRDatosUsuarioWeb";
            String strComando2="UPDATE usuarioweb SET correo='"+correo+"' where id_user_web="+cedu+";";
            sentenciaSQL.executeUpdate(strComando2);
            out.println("Los datos se actualizaron correctamente");
            out.println("<br><br><button onclick=\"actualizarUsuarioWeb();\" class=\"main_btn2\">Aceptar</button>");
            
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
