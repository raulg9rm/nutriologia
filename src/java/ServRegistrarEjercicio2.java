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
@WebServlet(urlPatterns = {"/ServRegistrarEjercicio2"})
public class ServRegistrarEjercicio2 extends HttpServlet {
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
            out.println("<title>Servlet ServRegistrarEjercicio2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRegistrarEjercicio2 at " + request.getContextPath() + "</h1>");
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
        PrintWriter out = response.getWriter();
        String id_ej = request.getParameter("id_ej");
        int tiempo = Integer.parseInt(request.getParameter("tiempo"));
        String id_user_web = null;
        int calorias_aquemar = 0, tiempo_minimo = 0;
        try {
      
           String resultado1 = "SELECT id_user_web\n"
                    + "FROM iniciosesion\n"
                    + "inner join usuarioWeb\n"
                    + "on usuarioWeb.usuario = iniciosesion.usuario;";
            cdr = sentenciaSQL.executeQuery(resultado1);

            while (cdr.next()) {
                id_user_web = cdr.getString("id_user_web");
            }
            
            String resultado3 = "SELECT * \n"
                    + "FROM ejercicio\n"
                    + "where id_ejercicio = " + id_ej + ";";
            cdr = sentenciaSQL.executeQuery(resultado3);

            while (cdr.next()) {
                calorias_aquemar = cdr.getInt("calorias_aquemar");
                tiempo_minimo = cdr.getInt("tiempo_minimo");
            
            }          
           
            String valor="INSERT INTO descejercicio VALUES (null," +
                    id_ej + ", " +
                    tiempo + ", " +
                    (tiempo * calorias_aquemar)/tiempo_minimo + ", " +
                    id_user_web + ", curdate());";
            sentenciaSQL.executeUpdate(valor);
            
            out.println("</br></br>Tu ejercicio se registr&oacute; con &eacute;xito<br><br>");
            
            
            
        } catch (NullPointerException e) {
            out.print("Apuntado SQL: " + e.getMessage());
         Logger.getLogger(ServRegistrarEjercicio2.class.getName()).log(Level.SEVERE,null, e);
        } catch (SQLException e) {
            
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
