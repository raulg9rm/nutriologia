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
@WebServlet(urlPatterns = {"/ServRBuscarSaldo2"})
public class ServRBuscarSaldo2 extends HttpServlet {
     ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int cont=0;
        String cuadro, saldo, banco, banco2, preciooo;
        
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
            out.println("<title>Servlet ServRBuscarSaldo2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRBuscarSaldo2 at " + request.getContextPath() + "</h1>");
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
            cuadro=request.getParameter("tarjet");
            preciooo=request.getParameter("prec");
            
        try {
            String strComando8="SELECT * FROM tarjeta where no_cuenta_tarjeta='"+cuadro+"';";
            cdr = sentenciaSQL.executeQuery(strComando8);
            while(cdr.next()){
                saldo=cdr.getString("saldo");
                banco=cdr.getString("id_banco");
            }
            } catch (SQLException ex) {
            Logger.getLogger(ServRBuscarSaldo.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            if(cuadro.length()<16){
                out.println("Tarjeta invalida *minimo 16 n&uacutemeros*");
                    
            } else{
                if(Double.parseDouble(saldo)<Double.parseDouble(preciooo)){
                        out.println("Banco: "+banco2+"<br> Su saldo disponible es de: $"+saldo);
                        out.println("Saldo insuficiente");
                        
                    } else { 
                
                
                
                try{
                    
                    String strComando2="SELECT * FROM tarjeta where no_cuenta_tarjeta='"+cuadro+"';";
                    cdr = sentenciaSQL.executeQuery(strComando2);
                    while(cdr.next()){
                        saldo=cdr.getString("saldo");
                        banco=cdr.getString("id_banco");
                    }
                    
                    
                    
                    
                    String strComando3="SELECT * FROM banco where id_banco='"+banco+"';";
                    cdr = sentenciaSQL.executeQuery(strComando3);
                    while(cdr.next()){
                        banco2=cdr.getString("nombre_banco");
                    }
                    out.println("Tarjeta valida");
                    out.println("Banco: "+banco2+"<br> Su saldo disponible es de: $"+saldo);
                    
                    out.println("<br>\n" +
"                                                                        <br>\n" +
"                                                                        <button class=\"main_btn2\" id='el' value='0' onclick='confirmarDieta8();'>Renovar</button>\n" +
"                                                                       \n" +
"                                                                        <br>\n" +
"                                                                        <br>\n"
                + "<div id=\"confirmarDieta8\" align=\"center\">\n" +
"                                            \n" +
"                                    </div>" +
"                                                                        \n" +
"                                                                        \n" +
"								</div>\n" +
"							</div>\n" +
"						</div>\n" +
"                                                                       \n" +
"        			</div>\n" +
"                </div></center>\n" +
"        <!--================End About Area =================-->");
                    
                    out.close();
                    
                }catch(SQLException e){
                    out.println("Tarjeta invalida");
                }catch(NullPointerException e){
                    out.println("Apuntado SQL: " + e.getMessage());
                }
                out.close();
                }
            }
        
        
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
