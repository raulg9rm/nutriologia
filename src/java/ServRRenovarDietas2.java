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
@WebServlet(urlPatterns = {"/ServRRenovarDietas2"})
public class ServRRenovarDietas2 extends HttpServlet {
    ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int cont=0;
        String cedula, diet, usu, die, precio, diet2, cost, dura;
        
        public void init(ServletConfig config) throws ServletException{
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
            out.println("<title>Servlet ServRRenovarDietas2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRRenovarDietas2 at " + request.getContextPath() + "</h1>");
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
        PrintWriter out= response.getWriter();
        
        die=request.getParameter("id");
        
        String strComandoMachin3 = "select * from iniciosesion;";
        try {
            cdr = sentenciaSQL.executeQuery(strComandoMachin3);
            while(cdr.next()){
                usu = cdr.getString("usuario");
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServActRDatosNutriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String strComandoMachin2 = "select * from dieta where id_dieta="+die+";";
        try {
            cdr = sentenciaSQL.executeQuery(strComandoMachin2);
            while(cdr.next()){
                diet2 = cdr.getString("nombre");
                cost = cdr.getString("costo");
                cedula = cdr.getString("cedula");
                dura = cdr.getString("duracion");
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ServActRDatosNutriologo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        out.println("<!--================About Area =================-->\n" +
"                <center><div class=\"container\">\n" +
"                                <div class=\"row h_blog_item\">\n" +
"        				\n" +
"						<div class=\"col-lg-6\">\n" +
"							<div class=\"h_blog_text\">\n" +
"								<div class=\"h_blog_text_inner left\">\n" +
"									<h4>Renovar dieta</h4><h6>Tu dieta se renovara con "+dura+" meses mas</h6>\n" +
"                                                                        <h3>Usuario</h3>\n" +
"                                                                        <input type='text' id='userr1' value="+usu+" readonly='readonly'>\n" +
"                                                                        <h3>Dieta</h3>\n" +
"                                                                        <input type='text' id='dietaa1' value="+diet2+" readonly='readonly'>\n" +
"                                                                        <h3>Costo</h3>\n" +
"                                                                        <input type='text' id='costoo1' value="+cost+" readonly='readonly'>\n" +
"                                                                        <h3>Cedula de  nutri&oacutelogo</h3>\n" +
"                                                                        <input type='text' id='cedulaa1' value="+cedula+" readonly='readonly'>\n" +
                
"                                                                        <h3>No. de tarjeta</h3>\n" +
"                                                                        <input type='text' id='tarjetaa'><button id='btnTar2' onclick='consultarSaldo2();'>Consultar Saldo</button>\n" +
"                                                                        <div id=\"detalleTarjeta2\"></div>");

    
        
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
