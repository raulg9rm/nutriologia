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
@WebServlet(urlPatterns = {"/ServNotificacionesNutri2"})
public class ServNotificacionesNutri2 extends HttpServlet {
    ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int cont=0;
        String us, di, ce, ta, co;
        String idpa, iddi;
        
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
            out.println("<title>Servlet ServNotificacionesNutri2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServNotificacionesNutri2 at " + request.getContextPath() + "</h1>");
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
        
        
        di=request.getParameter("not");
        
        //out.println("Id de compra: "+di);
        
            try{

             String strComando3="UPDATE notificacion set status='vista' where id_not='"+di+"';";
            sentenciaSQL.executeUpdate(strComando3);
            
            out.println("<br><br><br><br><h1>Notificaci&oacute;n le&iacute;da</h1>");
            out.println("<a class=\"main_btn2\" onclick=\"buscarNotificaciones();\" >Aceptar</a><br><br><br>");
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
