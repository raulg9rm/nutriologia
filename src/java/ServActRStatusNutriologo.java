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
@WebServlet(urlPatterns = {"/ServActRStatusNutriologo"})
public class ServActRStatusNutriologo extends HttpServlet {
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
            out.println("<title>Servlet ServActRStatusNutriologo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServActRStatusNutriologo at " + request.getContextPath() + "</h1>");
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
        String id, status;
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        
        status=request.getParameter("sta");
        
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
            
            
            
            String strComando2="UPDATE nutriologo SET status='"+status+"' where cedula='"+cedu+"';";
            sentenciaSQL.executeUpdate(strComando2);
            request.setAttribute("conff", "El status se actualizo correctamente<br>");
            RequestDispatcher rd=null;
            rd=request.getRequestDispatcher("actRStatusNutriologo.jsp");
            rd.forward(request, response);
            
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
