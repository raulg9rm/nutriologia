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
@WebServlet(urlPatterns = {"/ServRRenovarFinal"})
public class ServRRenovarFinal extends HttpServlet {
    ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int cont=0;
        String us, di, ce, ta, co, saldofin, sa, id;
        String idpa, iddi;
        
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
            out.println("<title>Servlet ServRRenovarFinal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRRenovarFinal at " + request.getContextPath() + "</h1>");
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
        
        us=request.getParameter("user");
        di=request.getParameter("diet");
        ce=request.getParameter("cedu");
        ta=request.getParameter("card");
        co=request.getParameter("costoo");
        
        String strComando5="Select * from dieta where nombre='"+di+"';";
            try{
            cdr = sentenciaSQL.executeQuery(strComando5);
            while(cdr.next()){
            id=cdr.getString("id_dieta");
            }
           
                
        }catch(SQLException e){
            out.println("<h2>Ecepción SQL: " + e.getMessage()+"</h2>");
        }catch(NullPointerException e){
            out.println("<b>Apuntado SQL: " + e.getMessage()+"1</b>");
        }
        
        
        
            
            
        
        //out.println(us+di+ce+ta+co);
        String strComando2="UPDATE tarjeta set saldo=saldo-'"+co+"' where no_cuenta_tarjeta='"+ta+"';";
            try{
            sentenciaSQL.executeUpdate(strComando2);
           
                
        }catch(SQLException e){
            out.println("<h2>Ecepción SQL: " + e.getMessage()+"</h2>");
        }catch(NullPointerException e){
            out.println("<h1>Apuntado SQL: " + e.getMessage()+"</h1>");
        }
            
            
            
            
            String strComando4="UPDATE tarjeta set saldo=saldo+('"+co+"'*.10) where no_cuenta_tarjeta=3216549873216549;";
            try{
            sentenciaSQL.executeUpdate(strComando4);
           
                
        }catch(SQLException e){
            out.println("<h2>Ecepción SQL: " + e.getMessage()+"</h2>");
        }catch(NullPointerException e){
            out.println("<em>Apuntado SQL: " + e.getMessage()+"</em>");
        }
        
        
        
            String strComando="UPDATE infodieta set fecha_termino='2019-11-06' where id_dieta="+id+";";
            try{
            sentenciaSQL.executeUpdate(strComando);
           
                /*out.println("<br><br><center><h2>Dieta comprada correctamente</h2><br><br>");
                out.println("Dieta comprada: <input type='text' id='dietaa' value='"+di+"' readonly><br>");
                out.println("<br>Paciente: <input type='text' id='usuarioo' value='"+us+"' readonly><br>");
                out.println("<br>Tarjeta: <input type='text' id='tarjetaa' value='"+ta+"' readonly><br>");
                out.println("<br>Costo: <input type='text' id='costooo' value='"+co+"' readonly><br>");
                out.println("<br><br><br><br><br>");
                out.println("<img src=\"img/blog/cat-post/gracias.png\" height='750' width='620' alt=\"mensajeCompra\"><br><br>");
                */out.println("<h3>Se renovo correctamente tu dieta</h3>");
                out.println("<button class=\"main_btn2\" id='el128' onclick='preguntaPlanDieta();'>Aceptar</button></center><br><br><div id='comprobante'></div><br>");
                out.close();
                
        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
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
