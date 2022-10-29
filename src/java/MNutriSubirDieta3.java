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
@WebServlet(urlPatterns = {"/MNutriSubirDieta3"})
public class MNutriSubirDieta3 extends HttpServlet {

    ResultSet cdr = null;
    Statement sentenciaSQL = null;
    Conexion conecta = new Conexion();
    String idNot,ced,idPa,dietaa,tipoD,idDi;


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
            out.println("<title>Servlet MNutriSubirDieta3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MNutriSubirDieta3 at " + request.getContextPath() + "</h1>");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nut,ced,diet,cat1,alim1,ins,fecha,tipoc;
        
        try {
           
            idNot=request.getParameter("idNot");
            idDi=request.getParameter("idDi");
            alim1=request.getParameter("alim1");
            fecha=request.getParameter("fecha");
            tipoc=request.getParameter("tipoc");
            ins="insert into descdieta values(null,'"+fecha+"',"+idDi+",'"+tipoc+"','"+alim1+"');";
            sentenciaSQL.executeUpdate(ins);
            out.println("<br><br>Siga llenando y la dieta se mostrara<br><br>");
            
            out.println("<br><br><table width=50% border=1>");
            out.println("<tr>");
            out.println("<th> Desayuno </th><th> D&iacute;a </th>");
            String verD="Select * from descdieta inner join compradieta on compradieta.id_dieta=descdieta.id_dieta inner join paciente on paciente.id_paciente=compradieta.id_paciente inner join notificacion on notificacion.id_paciente=paciente.id_paciente where descdieta.tipo='desayuno' and descdieta.id_dieta="+idDi+" and notificacion.id_not="+idNot;
            cdr=sentenciaSQL.executeQuery(verD);
            while(cdr.next()){
            out.println("</tr>");
            out.println("<td>"+cdr.getString("alimento")+"</td><td>"+cdr.getString("fecha")+"</td>");
            out.println("</tr>");
            }
            out.println("</table>");
            
            out.println("<br><br><table width=50% border=1>");
            out.println("<tr>");
            out.println("<th> Comida </th><th> D&iacute;a </th>");
            String verCo="Select * from descdieta inner join compradieta on compradieta.id_dieta=descdieta.id_dieta inner join paciente on paciente.id_paciente=compradieta.id_paciente inner join notificacion on notificacion.id_paciente=paciente.id_paciente where descdieta.tipo='comida' and descdieta.id_dieta="+idDi+" and notificacion.id_not="+idNot;
            cdr=sentenciaSQL.executeQuery(verCo);
            while(cdr.next()){
            out.println("</tr>");
            out.println("<td>"+cdr.getString("alimento")+"</td><td>"+cdr.getString("fecha")+"</td>");
            out.println("</tr>");
            }
            out.println("</table>");
            
            out.println("<br><br><table width=50% border=1>");
            out.println("<tr>");
            out.println("<th> Colacion </th><th> D&iacute;a </th>");
            String verCol="Select * from descdieta inner join compradieta on compradieta.id_dieta=descdieta.id_dieta inner join paciente on paciente.id_paciente=compradieta.id_paciente inner join notificacion on notificacion.id_paciente=paciente.id_paciente where descdieta.tipo='colacion' and descdieta.id_dieta="+idDi+" and notificacion.id_not="+idNot;
            cdr=sentenciaSQL.executeQuery(verCol);
            while(cdr.next()){
            out.println("</tr>");
            out.println("<td>"+cdr.getString("alimento")+"</td><td>"+cdr.getString("fecha")+"</td>");
            out.println("</tr>");
            }
            out.println("</table>");
            
            out.println("<br><br><table width=50% border=1>");
            out.println("<tr>");
            out.println("<th> Cena </th><th> D&iacute;a </th>");
            String verCe="Select * from descdieta inner join compradieta on compradieta.id_dieta=descdieta.id_dieta inner join paciente on paciente.id_paciente=compradieta.id_paciente inner join notificacion on notificacion.id_paciente=paciente.id_paciente where descdieta.tipo='cena' and descdieta.id_dieta="+idDi+" and notificacion.id_not="+idNot;
            cdr=sentenciaSQL.executeQuery(verCe);
            while(cdr.next()){
            out.println("</tr>");
            out.println("<td>"+cdr.getString("alimento")+"</td><td>"+cdr.getString("fecha")+"</td>");
            out.println("</tr>");
            }
            out.println("</table>");
            
        } catch (SQLException ex) {
            Logger.getLogger(MNutriSubirDieta3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
        }
    }
    
    public void destroy() {
        conecta.cerrar();
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
