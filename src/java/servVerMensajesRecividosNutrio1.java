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
@WebServlet(urlPatterns = {"/servVerMensajesRecividosNutrio1"})
public class servVerMensajesRecividosNutrio1 extends HttpServlet {
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
            out.println("<title>Servlet servVerMensajesRecividosNutrio1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servVerMensajesRecividosNutrio1 at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String id_mensaje;
        id_mensaje = request.getParameter("id_mensaje");
        String id_paciente = null, cedula = null, fecha = null, asunto = null, mensaje = null, nombre = null, paterno = null, materno = null, usuario = null;
        String usuarioNutriologo = null, nombreN = null, paternoN = null, maternoN = null;
        try {            
            
           String strComando = "SELECT * \n"
                    + "FROM mensaje\n"
                    + " where id_mensaje= " + id_mensaje + " and tipoMensaje='solicitud';";
            cdr = sentenciaSQL.executeQuery(strComando);

            while (cdr.next()) {
                id_paciente = cdr.getString("id_paciente");
                cedula  = cdr.getString("cedula");
                fecha  = cdr.getString("fecha");
                asunto  = cdr.getString("asunto");
                mensaje  = cdr.getString("mensaje");
            }
                 
            out.println("<center>");
            out.println("<h1>Mensaje</h1>");
            out.println("</center>");
            
            String strComando2 = "select paciente.usuario"
                    + " from paciente"
                    + " where id_paciente="+id_paciente+";";
            cdr = sentenciaSQL.executeQuery(strComando2);

            while (cdr.next()) {
                usuario = cdr.getString("paciente.usuario");
            }

            String strComando3 = "Select * from usuario\n"
                    + "where usuario.usuario = '" + usuario + "';";
            cdr = sentenciaSQL.executeQuery(strComando3);

            while (cdr.next()) {
                nombre = cdr.getString("nombre");
                paterno = cdr.getString("paterno");
                materno = cdr.getString("materno");
            }
            out.println("De: "+ nombre +" "+ paterno +" "+ materno);
            
            
            String strComando4 = "select usuario "
                    + "from nutriologo "
                    + "where cedula = " + cedula + ";";
            cdr = sentenciaSQL.executeQuery(strComando4);

            while (cdr.next()) {
                usuarioNutriologo = cdr.getString("usuario");
            }

            String strComando5 = "Select * from usuario\n"
                    + "where usuario.usuario = '" + usuarioNutriologo + "';";
            cdr = sentenciaSQL.executeQuery(strComando5);

            while (cdr.next()) {
                nombreN = cdr.getString("nombre");
                paternoN = cdr.getString("paterno");
                maternoN = cdr.getString("materno");
            }

            out.println("</br></br>Para: Nutri&oacute;logo. " + nombreN + " " + paternoN + " " + maternoN);
            out.println("</br></br>Fecha: " + fecha);
            out.println("</br></br>Asunto: " + asunto);
            out.println("</br></br>Mensaje: " + mensaje);
            
            String valor1="Update notificacionMensaje set status='visto' where id_mensaje="+id_mensaje+";";
            sentenciaSQL.executeUpdate(valor1);
            out.println("<center><button id=\"button\"  onclick=\"verMensajesRecibidosNutrio();\">Regresar</button></center>");
            
            
            
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
