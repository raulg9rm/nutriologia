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
@WebServlet(urlPatterns = {"/servContarCalorias1"})
public class servContarCalorias1 extends HttpServlet {
    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();

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
            out.println("<title>Servlet servContarCalorias1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servContarCalorias1 at " + request.getContextPath() + "</h1>");
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
            //processRequest(request, response);
       response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
       //String tipoComida = request.getParameter("tipoComida");
        
        
        try {
           
            String tipoComida = request.getParameter("tipoComida");
            
            String resultado = "SELECT * FROM catAlimento";
            cdr = sentenciaSQL.executeQuery(resultado);
            
           
            out.println("<label>Selecciona la catogoria del alimento: </label>\n"
                    + "<select id=\"categoria\" onchange=\"contarCaloriasServ2();\">");
            out.println("<option>-seleccionar-</option>");   
            while (cdr.next()) {
                
                out.print("<option value="+ cdr.getString("categoria")+">" + cdr.getString("categoria") + "</option>");

            }

            out.println("</select>\n");
            out.println("<div id=\"AlimentoServ\"></div>");
      
            
        } catch (SQLException e) {
            out.println("Excepcion SQL: " + e.getMessage());
        } catch (NullPointerException e) {
           Logger.getLogger(servContarCalorias1.class.getName()).log(Level.SEVERE,null, e);
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
