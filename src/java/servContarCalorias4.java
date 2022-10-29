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
@WebServlet(urlPatterns = {"/servContarCalorias4"})
public class servContarCalorias4 extends HttpServlet {
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
            out.println("<title>Servlet servContarCalorias4</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servContarCalorias4 at " + request.getContextPath() + "</h1>");
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
        String alimento, categoria, tipoComida, id_user_web = null, id_calorias_usuario_dia = null, id_alimento = null;
        int gramosBase = 0, caloriasBase = 0, caloriasA, gramos;
        
        alimento = request.getParameter("alimento");
        categoria = request.getParameter("categoria");
        gramos =  Integer.parseInt(request.getParameter("gramos"));
        tipoComida = request.getParameter("tipoComida");

        try {

            String resultado1 = "SELECT id_user_web\n"
                    + "FROM iniciosesion\n"
                    + "inner join usuarioWeb\n"
                    + "on usuarioWeb.usuario = iniciosesion.usuario;";
            cdr = sentenciaSQL.executeQuery(resultado1);

            while (cdr.next()) {
                id_user_web = cdr.getString("id_user_web");
            }
                     
            String resultado3 = "SELECT *\n"
                    + "FROM alimento\n"
                    + "where alimento = '" + alimento + "';";
            cdr = sentenciaSQL.executeQuery(resultado3);

            while (cdr.next()) {
                id_alimento = cdr.getString("id_alimento");
                gramosBase = cdr.getInt("gramos");
                caloriasBase = cdr.getInt("calorias");
            
            }
            
            //caloriasA=(gramos * caloriasBase / gramosBase);
            
            String valor1 = "INSERT INTO caloriascomida VALUES (null, "
                    + "'"+tipoComida+"', "
                    + id_alimento + ", "
                    +(gramos * caloriasBase)/gramosBase+ ","
                    + id_user_web + ", "
                    + "curdate());";
            sentenciaSQL.executeUpdate(valor1);

            
            out.println("Tus calorias se registrarón con &eacute;xito<br><br><br>");
            
        } catch (SQLException e) {
            out.println("Excepcion SQL: " + e.getMessage());
        } catch (NullPointerException e) {
            Logger.getLogger(servContarCalorias1.class.getName()).log(Level.SEVERE, null, e);
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
