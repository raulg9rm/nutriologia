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
@WebServlet(urlPatterns = {"/ServDPacienteHistoriaExito"})
public class ServDPacienteHistoriaExito extends HttpServlet {
    ResultSet cdr=null;
    Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int horas, horas2, horas3;
        
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
            out.println("<title>Servlet ServDPacienteHistoriaExito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServDPacienteHistoriaExito at " + request.getContextPath() + "</h1>");
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
            String titulo, historia, foto;
       String fecha = "curdate()";
       String usuario = "1";
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        try {
                    titulo = request.getParameter("titulo");
                    historia = request.getParameter("historia");
                    foto= request.getParameter("foto");                  
                                     
                    
                     sentenciaSQL.executeUpdate("INSERT INTO historia  VALUES (null,"+usuario+","
                                                                                + ""+fecha+","
                                                                                + "'"+titulo+"',"
                                                                                + "'"+foto+"',"
                                                                                + "'"+historia+"');");
                    
                    // insert into historia values(null,1,curdate(), 'ensalada', 'rnsd skjdbfjsdfjdbjdbfjdsh', 'sdf.png');
                    request.setAttribute("resp", "Se ha publicado con éxito");
                    RequestDispatcher rd = null;
                    rd = request.getRequestDispatcher("DPacienteHistoriaExito.jsp");
                    rd.forward(request, response);
                
            
        } catch (SQLException e) {
            out.println("Excepción SQL: " + e.getMessage());
        } catch (NullPointerException e) {
            out.println("Apuntando SQL: " + e.getMessage());
        }
    }

    public void destroy() {
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
