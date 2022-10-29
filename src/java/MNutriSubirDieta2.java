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
@WebServlet(urlPatterns = {"/MNutriSubirDieta2"})
public class MNutriSubirDieta2 extends HttpServlet {

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
            out.println("<title>Servlet MNutriSubirDieta2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MNutriSubirDieta2 at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        String nut,ced,alim1;
        String idDi,cat1,tipoc,idNot;
        try {
            idNot=request.getParameter("idNot");
            idDi=request.getParameter("idDi");
            tipoc=request.getParameter("tipoc");
            cat1=request.getParameter("cat1");
            alim1="select * from alimento where id_categoria="+cat1;
            cdr=sentenciaSQL.executeQuery(alim1);
            out.println("<br><label>Seleccione la comida: </label>\n"
                    + "<select id=\"alim1\">");
            out.println("<option>-Seleccionar-</option>");
            while (cdr.next()) {
                out.print("<option value=" + cdr.getString("alimento") + ">"+ cdr.getString("alimento") + "</option>");
            }
            out.println("</select>\n");
            
            out.println("<br><br><label>Fecha: </label><input type='date' id='fecha'>");
            
            out.println("<br><button class=\"main_btn2\" onclick=\"MNutriSubirDieta3("+idNot+","+idDi+",'"+tipoc+"');\">Siguiente</button>");
            
            out.println("<br><button class=\"main_btn2\" onclick=\"buscarOpcionMNutriSubirDieta4("+idDi+");\">Finalizar</button>");
            //out.println("<br><button class=\"main_btn2\" onclick=\"buscarOpcionMNutriSubirDieta();\">Cancelar</button>");
            out.println("<br><br>Presiona 'siguiente' para continuar");
            out.println("<div id=\"me\" align=\"center\"></div>");
            
        } catch (SQLException ex) {
            Logger.getLogger(MNutriSubirDieta2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
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
