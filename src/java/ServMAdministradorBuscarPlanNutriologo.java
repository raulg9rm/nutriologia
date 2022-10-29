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
@WebServlet(urlPatterns = {"/ServMAdministradorBuscarPlanNutriologo"})
public class ServMAdministradorBuscarPlanNutriologo extends HttpServlet {

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
            out.println("<title>Servlet ServMAdministradorBuscarPlanNutriologo</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServMAdministradorBuscarPlanNutriologo at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
          response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String cons;
        
        try {
            cons = "SELECT descripcion FROM plansuscripcion;";
            cdr = sentenciaSQL.executeQuery(cons);
            out.println("<html>\n"
                    + "    <head>\n"
                    + "    <title>JSP Page</title>"
                    + "    </head>\n"
                    + "    <body>\n"
                    + "    <form action=\"ServMAdministradorEditaPlanNutriologo\" method=\"get\">\n"
                    + "    <h1>BUSCAR PLAN NUTRI&Oacute;LOGO</h1>");           
            out.println("<br><h2>Buscar:</h2>\n"
                    + "<BR>\n"
                    + "<select name=\"descrip\">\n");
            out.println("<option>Selecciona</option>");
            while (cdr.next()) {
                out.println("<option>" + cdr.getString("descripcion") + "</option>");
            }
            out.println("</select><br>");
            out.println("<br><br><input type=\"submit\" value=\"Ver\">\n"
                    + " </center>\n"
                    + " </form>\n"
                    + "    </body>\n"
                    + "</html>");
        } catch (SQLException ex) {
            Logger.getLogger(ServMAdministradorBuscarPlanNutriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
    
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
