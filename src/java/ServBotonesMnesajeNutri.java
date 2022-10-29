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
@WebServlet(urlPatterns = {"/ServBotonesMnesajeNutri"})
public class ServBotonesMnesajeNutri extends HttpServlet {
    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    
        String usuarioPaciente;

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
            out.println("<title>Servlet ServBotonesMnesajeNutri</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServBotonesMnesajeNutri at " + request.getContextPath() + "</h1>");
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
        usuarioPaciente = request.getParameter("usuarioPaciente");
        
        out.println("<center><br><button class=\"main_btn2\" onclick=\"enviarMensajesNormal('"+usuarioPaciente+"');\">Mensaje</button><br><br>");
        out.println("<div id=\"MensajeNutrio\"></div><br><br><br>");
        out.println("<br><button class=\"main_btn2\" onclick=\"buscarOpcionMNutriEnviarApoyo2('"+usuarioPaciente+"');\">Mensaje de apoyo</button><br><br></center>");
        out.println("<div id=\"mensajes\"></div><br><br><br>");
        /*
        try {

            String strComando = "SELECT cedula\n"
                    + "FROM iniciosesion\n"
                    + "inner join nutriologo\n"
                    + "on nutriologo.usuario = iniciosesion.usuario;";
            cdr = sentenciaSQL.executeQuery(strComando);

            while (cdr.next()) {
                cedula = cdr.getString("cedula");
            }
            
            } catch (NullPointerException e) {
            out.print("Apuntado SQL: " + e.getMessage());
//           Logger.getLogger(servConsAviones.class.getName()).log(Level.SEVERE,null, e);
        } catch (SQLException e) {
            out.println("Error:" + e);
        }
        
        try{
            String strComando4 = "select usuario "
                    + "from nutriologo "
                    + "where cedula = " + cedula + ";";
            cdr = sentenciaSQL.executeQuery(strComando4);

            while (cdr.next()) {
                usuarioNutriologo = cdr.getString("usuario");
            }
            
            } catch (NullPointerException e) {
            out.print("Apuntado SQL: " + e.getMessage());
//           Logger.getLogger(servConsAviones.class.getName()).log(Level.SEVERE,null, e);
        } catch (SQLException e) {
            out.println("Error:" + e);
        }
        
        try{

            String strComando5 = "Select * from usuario\n"
                    + "where usuario.usuario = '" + usuarioNutriologo + "';";
            cdr = sentenciaSQL.executeQuery(strComando5);

            while (cdr.next()) {
                nombreN = cdr.getString("nombre");
                paternoN = cdr.getString("paterno");
                maternoN = cdr.getString("materno");
            }
            
            } catch (NullPointerException e) {
            out.print("Apuntado SQL: " + e.getMessage());
//           Logger.getLogger(servConsAviones.class.getName()).log(Level.SEVERE,null, e);
        } catch (SQLException e) {
            out.println("Error:" + e);
        }
            
            out.println("<center></br></br>De: Nutri&oacute;logo. " + nombreN + " " + paternoN + " " + maternoN);
         
            try{
            String strComando2 = "Select * from usuario\n"
                    + "where usuario.usuario = '" + usuarioPaciente + "';";
            cdr = sentenciaSQL.executeQuery(strComando2);

            while (cdr.next()) {
                nombre = cdr.getString("nombre");
                paterno = cdr.getString("paterno");
                materno = cdr.getString("materno");
            }
            
            
            } catch (NullPointerException e) {
            out.print("Apuntado SQL: " + e.getMessage());
//           Logger.getLogger(servConsAviones.class.getName()).log(Level.SEVERE,null, e);
        } catch (SQLException e) {
            out.println("Error:" + e);
        }
            
            try{
            String strComando3 = "Select id_paciente from paciente where usuario =  '" + usuarioPaciente + "';";
            cdr = sentenciaSQL.executeQuery(strComando3);

            while (cdr.next()) {
                id_paciente = cdr.getString("id_paciente");
            }

            out.println("</br></br>Para: " + nombre + " " + paterno + " " + materno);

            out.println("</br></br>Asunto: <input type=\"asunto\" id=\"asunto\">"
                    + "        </br></br><label>Mensaje: </label></br>\n"
                    + "        <textarea id=\"mensaje\" rows=\"10\" cols=\"50\"></textarea><br/><br/>"
                    + " <center><button id=\"button\"  onclick=\"enviarMensajesNutrioServ2(" + id_paciente + ", " + cedula + ");\">Enviar</button></center>");
            out.println("</center><div id=\"EnviarMensajeNutrio\"></div>");
        } catch (NullPointerException e) {
            out.print("Apuntado SQL: " + e.getMessage());
//           Logger.getLogger(servConsAviones.class.getName()).log(Level.SEVERE,null, e);
        } catch (SQLException e) {
            out.println("Error:" + e);
        }*/
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
