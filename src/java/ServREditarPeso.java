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
@WebServlet(urlPatterns = {"/ServREditarPeso"})
public class ServREditarPeso extends HttpServlet {
    ResultSet cdr=null;
    Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        String pes, usuu, id, maximoid;
       
        
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
            out.println("<title>Servlet ServREditarPeso</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServREditarPeso at " + request.getContextPath() + "</h1>");
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
                    PrintWriter out= response.getWriter();
                    
                    pes=request.getParameter("peso");
                    
                try{
                    String strComando3="SELECT * FROM iniciosesion;";
                    cdr = sentenciaSQL.executeQuery(strComando3);
                    while(cdr.next()){
                        usuu=cdr.getString("usuario");
                    }
                    }catch(SQLException ex){
                        Logger.getLogger(ServRRegistrarPeso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                try{
                    String strComando4="SELECT * FROM paciente where usuario='"+usuu+"';";
                    cdr = sentenciaSQL.executeQuery(strComando4);
                    while(cdr.next()){
                        id=cdr.getString("id_paciente");
                        //out.println(" id_paciente: "+id);
                    }
                    }catch(SQLException ex){
                        out.println(" error: "+ex);
                    }
                    
                    
                    
                    try{
                        
                        String strComando="INSERT INTO controlpeso VALUES (null, '" + pes + "', curdate(), '" + id + "')";
                        sentenciaSQL.executeUpdate(strComando);
                        
                        
                        
                        out.println("Peso actualizado correctamente");
                        out.println("Puedes mirar los cambios en 'Ver expediente'");

                    }catch(NullPointerException e){
                        out.println("Apuntado SQL: " + e.getMessage());
                    }   catch (SQLException ex) {
                        out.println("<h2>Registro fallido</h2>"+ex);
                        
                        conecta.cerrar();
                        
                    }
                    
                    
                    try{
                        String strComando4="SELECT MAX(id_control_peso) id FROM controlpeso where id_paciente='"+id+"';";
                       cdr = sentenciaSQL.executeQuery(strComando4);
                       while(cdr.next()){
                           maximoid=cdr.getString("id");
                       }
                       }catch(SQLException e){
                       out.println("Ecepción SQL: " + e.getMessage());
                       }catch(NullPointerException e){
                       out.println("Apuntado SQL: " + e.getMessage());
                       }
                    
                    
                    try{
                        
                        String strComando="UPDATE expediente set id_control_peso='"+maximoid+"' where id_paciente='"+id+"';";
                        sentenciaSQL.executeUpdate(strComando);
                        
                        
                        
                        

                    }catch(NullPointerException e){
                        out.println("Apuntado SQL: " + e.getMessage());
                    }   catch (SQLException ex) {
                        out.println("<h2>Registro fallido</h2>"+ex);
                        
                        conecta.cerrar();
                        
                    }
                    
                    
                    //out.println("peso: "+pes+" id_paciente: "+id);
                
        
        
            
    }

        
        
    


    public void destroy(){
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
