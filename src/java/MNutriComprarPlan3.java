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
 * @author hp
 */
@WebServlet(urlPatterns = {"/MNutriComprarPlan3"})
public class MNutriComprarPlan3 extends HttpServlet {

     ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        
        int cont=0;
        String cedula, diet, usu, diet2, precio, dura,usua,ced,us;
        double saldo=0,pres=0;
        
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
            out.println("<title>Servlet MNutriComprarPlan3</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MNutriComprarPlan3 at " + request.getContextPath() + "</h1>");
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
        String id=request.getParameter("com");
        try{
            
        usua="select * from iniciosesion;";
            cdr=sentenciaSQL.executeQuery(usua);
            while(cdr.next()){
                us=cdr.getString("usuario");
            ced="select cedula,tarjeta.no_cuenta_tarjeta,CCV,saldo from tarjeta inner join nutriologo on nutriologo.no_cuenta_tarjeta=tarjeta.no_cuenta_tarjeta where nutriologo.usuario='"+us+"';";
            }
            try{
            cdr=sentenciaSQL.executeQuery(ced);
            while(cdr.next()){
            saldo=cdr.getDouble("saldo"); 
            }
            } catch (SQLException ex) {
            out.println("Errorrr "+ex);
        }
        } catch (SQLException ex) {
            out.println("Error "+ex);
        }
        try{
        String strComandoMachin2 = "select * from plansuscripcion where id_plan_suscripcion="+id+";";
//        try{
            cdr = sentenciaSQL.executeQuery(strComandoMachin2);
            while(cdr.next()){
                diet2 = cdr.getString("nombre");
                dura = cdr.getString("duracion");
                pres=cdr.getDouble("costo");
            }
            
            if(saldo<pres){
                        out.println("<br> Su saldo disponible es de: $"+saldo);
                        out.println("Saldo insuficiente");
                        
                    } else{   
            
//            
//        } catch (SQLException ex) {
//            Logger.getLogger(ServActRDatosNutriologo.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        out.println("<!--================About Area =================-->\n" +
"                <center><div class=\"container\">\n" +
"                                <div class=\"row h_blog_item\">\n" +
"        				\n" +
"						<div class=\"col-lg-6\">\n" +
"							<div class=\"h_blog_text\">\n" +
"								<div class=\"h_blog_text_inner left\">\n" +
"									<h4>Comprar dieta</h4>\n" +
"                                                                        <h3>Usuario</h3>\n" +
"                                                                        <label>"+us+"</label>" +
"                                                                        <h3>Plan</h3>\n" +
"                                                                        <label>"+diet2+"</label>" +
"                                                                        <h3>Duraci&oacute;n</h3>\n" +
"                                                                        <lable>"+dura+"</label>");
        out.println("<br><button onclick=\"buscarOpcionMNutriComprarPlan4("+id+");\">Comprar</button>"
                + "<br><div id='m'></div></center><br><br><br>");
        
            }
            } catch (SQLException e) {
            out.println("Error: "+e);
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
