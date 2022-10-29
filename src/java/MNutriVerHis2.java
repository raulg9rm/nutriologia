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
@WebServlet(urlPatterns = {"/MNutriVerHis2"})
public class MNutriVerHis2 extends HttpServlet {

    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    int cont=0;
    String idpa, usuu, minimo, maximo, maximoid, nombre, pat, mat;

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
            out.println("<title>Servlet MNutriVerHis2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MNutriVerHis2 at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String cons,idNot,co;
        String idp = null;
        try {
            idNot=request.getParameter("idNot");
            
            co="SELECT id_paciente FROM notificacion where id_not="+idNot+";";
            cdr=sentenciaSQL.executeQuery(co);
            while(cdr.next()){
            idp=cdr.getString("id_paciente");
            }
            cons = "SELECT controlpeso.peso,controlpeso.fecha,expediente.altura,expediente.edad,expediente.enfermedades,expediente.alergias,expediente.peso_meta,concat(usuario.nombre,' ',usuario.paterno,' ',usuario.materno) paciente FROM controlpeso INNER JOIN expediente on expediente.id_control_peso=controlpeso.id_control_peso INNER JOIN paciente ON paciente.id_paciente=expediente.id_paciente INNER JOIN usuario ON usuario.usuario=paciente.usuario where controlpeso.id_paciente="+idp;
            cdr = sentenciaSQL.executeQuery(cons);
            while(cdr.next()){
//            out.println("<table width=50% border=1>");
//            out.println("<tr>");
//            out.println("<th> Nombre del paciente </th><th> Peso actual </th><th> Altura </th><th> Edad </th><th> Enfermedades </th><th> Alergias </th><th> Peso meta </th>");
//            out.println("</tr>");
//            while (cdr.next()) {
//                out.println("<tr>");
//                out.println("<td width=20%>"+cdr.getString("paciente")+"</td>");
//                out.println("<td width=10%>"+cdr.getString("peso")+"</td>");
//                out.println("<td width=10%>"+cdr.getString("altura")+"</td>");
//                out.println("<td width=10%>"+cdr.getString("edad")+"</td>");
//                out.println("<td width=20%>"+cdr.getString("enfermedades")+"</td>");
//                out.println("<td width=20%>"+cdr.getString("alergias")+"</td>");
//                out.println("<td width=20%>"+cdr.getString("peso_meta")+"</td>");
//                out.println("</tr>");
//            }
//            out.println("</table><br><br>");
            //out.println("<div id=\"mensaje\" align=\"center\"></div>");
            
            out.println("<br><br><br><h2>Expediente</h2>");
            out.println("<br><label>Nombre del paciente: <h4>"+cdr.getString("paciente")+"</h4></label>");
            out.println("&nbsp;&nbsp;&nbsp;<label>Edad: <h4>"+cdr.getString("edad")+"</h4></label>");
            out.println("<label>Peso actual: <h4>"+cdr.getString("peso")+"</h4></label>");
            out.println("&nbsp;&nbsp;&nbsp;&nbsp;<label>Altura: <h4>"+cdr.getString("altura")+"</h4></label>");
            out.println("&nbsp;&nbsp;&nbsp;<label>Peso meta: <h4>"+cdr.getString("peso_meta")+"</h4></label>");
            out.println("<br><label>Enfermedades: <h4>"+cdr.getString("enfermedades")+"</h4></label>");
            out.println("&nbsp;&nbsp;&nbsp;<label>Alergias: <h4>"+cdr.getString("alergias")+"</h4></label>");
            out.println("<br><button onclick=\"buscarOpcionMNutriSubirDieta("+idNot+");\">Crear dieta</button><br><br>");
            out.println("<div id='mm'></div>");
            }
            out.close();
        } catch (SQLException ex) {
            Logger.getLogger(MNutriVerHis2.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }

    public void destroy() {
        conecta.cerrar();
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
