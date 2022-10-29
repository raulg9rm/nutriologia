/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import conexion.Conexion;
import conexion.validaciones;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danny Delgadillo
 */
@WebServlet(urlPatterns = {"/DInicioSesionValidacion"})
public class DInicioSesionValidacion extends HttpServlet {

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
   PrintWriter out = response.getWriter();
        
        try {
        Conexion conecta=new Conexion();
        conecta.conectar();
        String usuario = request.getParameter("nombre");
        String password = request.getParameter("clave");
       
        PreparedStatement pst5 = conecta.getConexion().prepareStatement("truncate iniciosesion;");
                                pst5.execute();
        validaciones co = new validaciones();
        HttpSession session = request.getSession(true);
            if(co.validarUsuario(usuario, password).equals("nutriologo")){
                                
                PreparedStatement pst = conecta.getConexion().prepareStatement("insert into iniciosesion values(null,?)");
                pst.setString(1, usuario);
                pst.execute();
                
                response.sendRedirect("principalRNutriologo.jsp");
                
            }else if(co.validarUsuario(usuario, password).equals("paciente")){
                
               PreparedStatement pst = conecta.getConexion().prepareStatement("insert into iniciosesion values(null,?)");
                pst.setString(1, usuario);
                pst.execute();
                
                response.sendRedirect("principalRPaciente.jsp");

            }else if(co.validarUsuario(usuario, password).equals("usuarioWeb")){
                
                PreparedStatement pst = conecta.getConexion().prepareStatement("insert into iniciosesion values(null,?)");
                pst.setString(1, usuario);
                pst.execute();
                
                response.sendRedirect("principalRUsuarioWeb.jsp");

            }else if (co.validarUsuario(usuario, password).equals("admin")){
                
                PreparedStatement pst = conecta.getConexion().prepareStatement("insert into iniciosesion values(null,?)");
                pst.setString(1, usuario);
                pst.execute();
                
                response.sendRedirect("principalRAdministrador.jsp");

            }else{
                 response.sendRedirect("index.jsp");
            }
        } catch (Exception ex) {
            response.sendRedirect("ServDUPrincipal");
            out.println("hola");
          //  Logger.getLogger(DInicioSesionValidacion.class.getName()).log(Level.SEVERE, null, ex);
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
