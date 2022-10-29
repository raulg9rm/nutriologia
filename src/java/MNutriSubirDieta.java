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
@WebServlet(urlPatterns = {"/MNutriSubirDieta"})
public class MNutriSubirDieta extends HttpServlet {

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
            out.println("<title>Servlet MNutriSubirDieta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet MNutriSubirDieta at " + request.getContextPath() + "</h1>");
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
        String nut,diet,cat1,cat2,cat3,cat4,alim1,alim2,alim3,alim4;
        try {
            idNot=request.getParameter("idNot");
            String c="SELECT * from notificacion where id_not="+idNot;
            cdr=sentenciaSQL.executeQuery(c);
            while(cdr.next()){
                idPa=cdr.getString("id_paciente");
                String dieta="select dieta.id_dieta,dieta.nombre,dieta.tipo from dieta inner join compradieta On compradieta.id_dieta=dieta.id_dieta where id_paciente="+idPa;
                cdr=sentenciaSQL.executeQuery(dieta);
                while(cdr.next()){
                    dietaa=cdr.getString("nombre");
                    tipoD=cdr.getString("tipo");
                    idDi=cdr.getString("id_dieta");
                    
            nut="select cedula from nutriologo where usuario=(select usuario from iniciosesion);";
            cdr=sentenciaSQL.executeQuery(nut);
            while(cdr.next()){
                ced=cdr.getString("cedula");
            }
            out.println("<br><br><center><h1>DIETA PERSONALIZADA</h1>");
            
            out.println("<br><label>Seleccione tipo de comida: </label>\n"
                    + "<select id=\"tipoc\">");
            out.println("<option>-Seleccionar-</option>");
                out.print("<option value=\"Desayuno\">Desayuno</option>");
                out.print("<option value=\"Comida\">Comida</option>");
                out.print("<option value=\"Colacion\">Colacion</option>");
                out.print("<option value=\"Cena\">Cena</option>");
            
            out.println("</select>\n");
            
            cat1="select * from catalimento;";
            cdr=sentenciaSQL.executeQuery(cat1);
            out.println("<br><br><label>Seleccione la categor&iacute;a: </label>\n"
                    + "<select id=\"cat1\" onchange=\"buscarOpcionMNutriSubirDieta2("+idNot+","+idDi+");\">");
            out.println("<option>-Seleccionar-</option>");
            while (cdr.next()) {
                out.print("<option value=" + cdr.getString("id_categoria") + ">"+ cdr.getString("categoria") + "</option>");
            }
            out.println("</select>\n");
            //out.println("<br><br><button class=\"main_btn2\" onclick=\"buscarOpcionMNutriSubirDieta2();\">Buscar alimento/comidas</button>");
            
            out.println("<br><br><div id=\"mensaje\" align=\"center\"></div><br><br>");
            out.println("</center>");
            }
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MNutriSubirDieta.class.getName()).log(Level.SEVERE, null, ex);
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
