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
@WebServlet(urlPatterns = {"/servVerMensajesRecibidosPaciente3"})
public class servVerMensajesRecibidosPaciente3 extends HttpServlet {
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
            out.println("<title>Servlet servVerMensajesRecibidosPaciente3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servVerMensajesRecibidosPaciente3 at " + request.getContextPath() + "</h1>");
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
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id_paciente = null;

        try {

            String strComando = "SELECT id_paciente, paciente.usuario\n"
                    + "FROM iniciosesion\n"
                    + "inner join paciente\n"
                    + "on paciente.usuario = iniciosesion.usuario;";
            cdr = sentenciaSQL.executeQuery(strComando);

            while (cdr.next()) {
                id_paciente = cdr.getString("id_paciente");
            }

            out.println("<center>");
            //out.println("<h1>Mensajes</h1>");
            out.println("</br></br><table width=50% border=1>");
            out.println("<tr>");
            out.println("<th>Asunto</th>");
            out.println("<th>Fecha</th>"
                    + "<th>Ver mensaje</th></tr>");

            String strComando1 = "Select * from mensaje\n"
                    + "inner join  notificacionMensaje on\n"
                    + "notificacionmensaje.id_mensaje= mensaje.id_mensaje\n"
                    + "where  id_paciente="+id_paciente+" and status='visto' and tipoMensaje='respuesta';";
            cdr = sentenciaSQL.executeQuery(strComando1);

            while (cdr.next()) {
                out.println("<tr>");
                out.println("<td width=20%>" + cdr.getString("asunto") + "</td>");
                out.println("<td width=10%>" + cdr.getString("fecha") + "</td>");
                out.println("<td width=20%><button id=\"button\" class=\"main_btn2\" onclick=\"verMensajesRecibidosPacienteServ2(" + cdr.getString("id_mensaje") + ");\">Ver</button></td>");
            }
            out.println("</tr></table>");

            out.close();
        } catch (SQLException ex) {
            //Logger.getLogger(servReporteCalorias1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
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
