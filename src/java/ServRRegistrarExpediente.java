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
@WebServlet(urlPatterns = {"/ServRRegistrarExpediente"})
public class ServRRegistrarExpediente extends HttpServlet {
    ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int cont=0;
        String altura, sex, inicio, end, edad, enfermedades, alergias;
        String usuu, idpa, idco;
        
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
            out.println("<title>Servlet ServRRegistrarExpediente</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRRegistrarExpediente at " + request.getContextPath() + "</h1>");
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
        
        altura=request.getParameter("alt");
        sex=request.getParameter("sexo");
        
        inicio=request.getParameter("ini");
        end=request.getParameter("fin");
        edad=request.getParameter("edad");
        
        enfermedades=request.getParameter("enf");
        alergias=request.getParameter("alerg");
        
        
        try{
            String strComando2="SELECT * FROM iniciosesion;";
            cdr = sentenciaSQL.executeQuery(strComando2);
            while(cdr.next()){
                usuu=cdr.getString("usuario");
            }


        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
        
        
        try{
            
            String strComando2="SELECT * FROM paciente where usuario='"+usuu+"';";
            cdr = sentenciaSQL.executeQuery(strComando2);
            while(cdr.next()){
                idpa=cdr.getString("id_paciente");
            }
            
             String strComando3="SELECT * FROM controlpeso where peso='"+inicio+"' and id_paciente='"+idpa+"';";
            cdr = sentenciaSQL.executeQuery(strComando3);
            while(cdr.next()){
                idco=cdr.getString("id_control_peso");
            }
            
            String strComando="INSERT INTO expediente VALUES (null,'" + idpa + "','" + altura + "','" + sex + "','"+ edad +"','"+enfermedades+"','"+alergias+"','"+idco+"','"+end+"');";
            sentenciaSQL.executeUpdate(strComando);
           
                out.println("<br><br><center><h2>Expediente registrado correctamente</h2>");
                
                out.println("<a class=\"main_btn2\" href=\"principalRPaciente.jsp\">Aceptar</a>");
                
                out.close();
                
        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
        out.close();
        
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
