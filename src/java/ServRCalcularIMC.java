/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Raúl
 */
@WebServlet(urlPatterns = {"/ServRCalcularIMC"})
public class ServRCalcularIMC extends HttpServlet {

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
            out.println("<title>Servlet ServRCalcularIMC</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRCalcularIMC at " + request.getContextPath() + "</h1>");
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
        double peso, altura, imc;
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
        
        DecimalFormat formato1 = new DecimalFormat("#.00");
        
        
            peso= Double.parseDouble(request.getParameter("kil"));
            altura= Double.parseDouble(request.getParameter("metr"));
            imc = peso / (altura*altura);
            
            try{
            if(imc<18.5){
            out.println("<p style='color:orange;'>"+formato1.format(imc)+" *bajo peso*</p>");
            } else if (imc>=18.5 && imc<25){
                out.println("<p style='color:green;'>"+formato1.format(imc)+" *peso normal*</p>");
            }   else if (imc>=25 && imc<30){
                out.println("<p style='color:yellow;'>"+formato1.format(imc)+" *sobrepeso*</p>");
                }   else if (imc>=30 && imc<40){
                out.println("<p style='color:pink;'>"+formato1.format(imc)+" *obesidad*</p>");
                }   else if (imc>40){
                out.println("<p style='color:red;'>"+formato1.format(imc)+" *obesidad mórbida*</p>");
                }
            
            out.close();
            }finally{
            out.close();
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
