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
@WebServlet(urlPatterns = {"/servRegistroRYC1"})
public class servRegistroRYC1 extends HttpServlet {
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
            out.println("<title>Servlet servRegistroRYC1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servRegistroRYC1 at " + request.getContextPath() + "</h1>");
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
            String titulo, descripcion;
        int tipo;

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
         String cedula = null;
        try {

            titulo = request.getParameter("titulo");
            descripcion = request.getParameter("descripcion");

            String[] radio = {"receta", "consejo"};
            tipo = Integer.parseInt(request.getParameter("est"));

            String strComando = "SELECT cedula\n"
                    + "FROM iniciosesion\n"
                    + "inner join nutriologo\n"
                    + "on nutriologo.usuario = iniciosesion.usuario;";
            cdr = sentenciaSQL.executeQuery(strComando);
            
            while(cdr.next()){
               cedula = cdr.getString("cedula");
            }

            String valor="INSERT INTO publicacion VALUES (null,"+ cedula+", null,"
                    +"'"+titulo+ "',"
                    +"'"+radio[tipo]+ "',"
                    +"'"+descripcion+"');";
            sentenciaSQL.executeUpdate(valor);
            //System.out.println(sentenciaSQL);
            out.println("Tu publicaci&oacute;n fue relizada con &eacute;xito");

        } catch (NullPointerException e) {
            out.print("Apuntado SQL: " + e.getMessage());
//           Logger.getLogger(servConsAviones.class.getName()).log(Level.SEVERE,null, e);
        } catch (SQLException e) {
            out.println("Error" + e);
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
