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
@WebServlet(urlPatterns = {"/servEnviarMensaje1"})
public class servEnviarMensaje1 extends HttpServlet {
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
            out.println("<title>Servlet servEnviarMensaje1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servEnviarMensaje1 at " + request.getContextPath() + "</h1>");
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
        String id_paciente, cedula, asunto, mensaje;

        id_paciente = request.getParameter("id_paciente");
        cedula = request.getParameter("cedula");
        asunto = request.getParameter("asunto");
        mensaje = request.getParameter("mensaje");
        String id_mensaje = null;
        try {
            
            String valor="INSERT INTO mensaje VALUES (null,"
                    + id_paciente +","
                    +cedula + ","
                    +"'solicitud', curdate(),"
                    +"'"+asunto+"',"
                    +"'" + mensaje+ "');";
            sentenciaSQL.executeUpdate(valor);
            //System.out.println(sentenciaSQL);
            out.println("Tu mensaje fue enviado con &eacute;xito");
           
            String strComando = "SELECT id_mensaje \n"
                    + "FROM mensaje\n"
                    + " where asunto= '" + asunto + "';";
            cdr = sentenciaSQL.executeQuery(strComando);
            
            while(cdr.next()){
                id_mensaje = cdr.getString("id_mensaje");
            }
            
            String valor1="INSERT INTO notificacionMensaje VALUES (null,"
                    + id_mensaje +","
                    +"'entregado');";
            sentenciaSQL.executeUpdate(valor1);
            
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
