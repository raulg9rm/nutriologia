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
@WebServlet(urlPatterns = {"/servReporteCalorias1"})
public class servReporteCalorias1 extends HttpServlet {
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
            out.println("<title>Servlet servReporteCalorias1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet servReporteCalorias1 at " + request.getContextPath() + "</h1>");
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
        
        String fecha =  request.getParameter("fecha");
    response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
String  id_user_web = null;
        try {
            
            
           String resultado1 = "SELECT id_user_web\n"
                    + "FROM iniciosesion\n"
                    + "inner join usuarioWeb\n"
                    + "on usuarioWeb.usuario = iniciosesion.usuario;";
            cdr = sentenciaSQL.executeQuery(resultado1);

            while (cdr.next()) {
                id_user_web = cdr.getString("id_user_web");
            }
            
            String strComando="SELECT tipo, alimento, caloriasConsumidas "
                    + "FROM caloriascomida "
                    + "inner join alimento on"
                    + " caloriascomida.id_alimento=alimento.id_alimento "
                    + "where fecha='"+fecha+"' and id_user_web ="+id_user_web+""
                    + " order by tipo;";
            cdr=sentenciaSQL.executeQuery(strComando);
                    
            out.println("<center>");
            out.println("</br></br><table width=50% border=1>");
            out.println("<tr>");
            out.println("<th>Tipo de comida </th>");
            out.println("<th>Alimento</th>"
                    + "<th>Calorias consumidas por comida </th></tr>");
            while(cdr.next()){
                out.println("<tr>");
                out.println("<td width=10%>" +cdr.getString("tipo")+"</td>");
                out.println("<td width=20%>" +cdr.getString("alimento")+"</td>");
                out.println("<td width=20%>" +cdr.getString("caloriasConsumidas")+"</td>");
            }
            out.println("</tr></table>");
            
                        
            String strComando3="SELECT nombre_ejercico, duracion, calorias_quemadas"
                    + " FROM descejercicio "
                    + "inner join ejercicio "
                    + "on ejercicio.id_ejercicio=descejercicio.id_ejercicio "
                    + "where fecha='"+fecha+"' and id_user_web ="+id_user_web+" order by nombre_ejercico;";
            cdr=sentenciaSQL.executeQuery(strComando3);
                    
            
            out.println("</br></br><table width=50% border=1>");
            out.println("<tr>");
            out.println("<th>Nombre ejercicio </th>");
            out.println("<th>Duraci&oacute;n</th>"
                    + "<th>Calorias quemadas por ejercicio </th></tr>");
            while(cdr.next()){
                out.println("<tr>");
                out.println("<td width=10%>" +cdr.getString("nombre_ejercico")+"</td>");
                out.println("<td width=20%>" +cdr.getString("duracion")+ " minutos"+"</td>");
                out.println("<td width=20%>" +cdr.getString("calorias_quemadas")+"</td>");
            }
            out.println("</tr></table>");
          
            out.println("<table width=50% border=1>");
            out.println("<tr>");
            out.println("<th>Total de calorias consumidas</th>");
            out.println("</tr>");
            String resultado2 = "select SUM(caloriasConsumidas)"
                    + "  from caloriasComida"
                    + " where id_user_web="+id_user_web+" and fecha='"+fecha+"';";
            cdr = sentenciaSQL.executeQuery(resultado2);
            while(cdr.next()){
                out.println("<tr>");
                out.println("<td width=10%>" +cdr.getInt("SUM(caloriasConsumidas)")+"</td>");
                }
            out.println("</tr>");
            
            out.println("<tr>");
            out.println("</br></br><th>Total de calorias quemadas</th>");
            out.println("</tr>");            
            String resultado3 = "select SUM(calorias_quemadas)"
                    + " from descejercicio"
                    + " where id_user_web="+id_user_web+" and fecha='"+fecha+"';";
            cdr = sentenciaSQL.executeQuery(resultado3);
            while(cdr.next()){
                out.println("<tr>");
                out.println("<td width=10%>" +cdr.getInt("SUM(calorias_quemadas)")+"</td>");
                }
            out.println("</tr>");
            
//            out.println("<tr>");
//            out.println("<th>Total de calorias</th>");
//            out.println("</tr>");
//            out.println("<tr>");
//            out.println("<td> "+((cdr.getInt("SUM(caloriasConsumidas)"))-(cdr.getInt("SUM(calorias_quemadas)")))+" calorias</td>");
//            out.println("</tr>");
             out.println("</table>");
             out.println("</center><br><br><br>");
            out.close();
            } catch (SQLException ex) {
            Logger.getLogger(servReporteCalorias1.class.getName()).log(Level.SEVERE, null, ex);
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
