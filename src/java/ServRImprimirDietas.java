/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.io.FileOutputStream;
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
@WebServlet(urlPatterns = {"/ServRImprimirDietas"})
public class ServRImprimirDietas extends HttpServlet {
    ResultSet cdr=null;
        Statement sentenciaSQL=null;
        Conexion conecta=new Conexion();
        int cont=0;
        String us, nom, di, ce, ta, co, diet, nomdieta, descrip, fech;
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
            out.println("<title>Servlet ServRImprimirDietas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServRImprimirDietas at " + request.getContextPath() + "</h1>");
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
            // processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out= response.getWriter();
       
        fech = request.getParameter("fech");
        diet=request.getParameter("diet");
        
        String strComando3="SELECT usuario FROM iniciosesion;";
        try {
            cdr = sentenciaSQL.executeQuery(strComando3);
            while(cdr.next()){
                us=cdr.getString("usuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServRGenerarComprobante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        String strComando5="SELECT * FROM usuario where usuario='"+us+"';";
        try {
            cdr = sentenciaSQL.executeQuery(strComando5);
            while(cdr.next()){
                nom=cdr.getString("nombre")+" "+cdr.getString("paterno")+" "+cdr.getString("materno");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServRGenerarComprobante.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        try{
            
             String strComando4="SELECT * FROM dieta where id_dieta='"+diet+"';";
            cdr = sentenciaSQL.executeQuery(strComando4);
            while(cdr.next()){
                nomdieta=cdr.getString("nombre");
                descrip=cdr.getString("descripcion");
            }
            
            }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
            
        
       
       
        Document doc = new Document(PageSize.LETTER);  //Se crea un nuevo documento de la clase Document de iText, asignandole el tamaño de las páginas como carta (Contenedor virtual).
        try {   //Bloque try-catch para cachar algún error o excepción a la hora que la ejecución del método.
            
            PdfWriter.getInstance(doc, new FileOutputStream("C:\\Users\\Raúl\\Desktop\\dieta3.pdf")); //Crea una instancia de la clase PdfWriter, donde se le envía el documento y la ruta de la creación del archivo.pdf mediante un nuevo archivo de salida.
            doc.open(); //Bandera para decir que el documento será utilizado.
            Paragraph par0=new Paragraph("Tu dieta del día de hoy es...!!!");
            par0.setAlignment(Element.ALIGN_CENTER);
            doc.add(par0);
            try {
                Image logo = Image.getInstance("C:\\Users\\Raúl\\Desktop\\Proyecto chido\\nutriologia\\web\\img\\facturalogo.png");
                logo.scaleAbsoluteWidth(100);
                logo.scaleAbsoluteHeight(100);
                logo.setAlignment(Element.ALIGN_RIGHT);
                //logo.setAbsolutePosition(150, 150);
                doc.add(logo);
            } catch (BadElementException ex) {
                //Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                //Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
            Paragraph parrafo1=new Paragraph("**Nutri-Web**");
            parrafo1.setAlignment(Element.ALIGN_LEFT);
            
            doc.add(parrafo1);
            
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Te saludamos: "+nom+"...!!!"));
            doc.add(new Paragraph("Nombre de tu dieta: "+nomdieta));
            doc.add(new Paragraph("Descripción: "+descrip));
            doc.add(new Paragraph("Fecha: "+fech));//Se añade un nuevo párrafo que contiene un texto.
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph(" "));
            
            
            Paragraph par30=new Paragraph("Estos son los alimentos que debes consumir");
            par30.setAlignment(Element.ALIGN_CENTER);
            doc.add(par30);
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Desayuno:"));

            try{
            String strComando="select tipo, alimento from descdieta where id_dieta="+diet+" and fecha='"+fech+"' and tipo='desayuno'";
            cdr = sentenciaSQL.executeQuery(strComando);
            
            while(cdr.next()){
                doc.add(new Paragraph(cdr.getString("alimento")));
            }
        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
            
            
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Comida:"));

            try{
            String strComando="select tipo, alimento from descdieta where id_dieta="+diet+" and fecha='"+fech+"' and tipo='comida'";
            cdr = sentenciaSQL.executeQuery(strComando);
            
            while(cdr.next()){
                doc.add(new Paragraph(cdr.getString("alimento")));
            }
        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
            
            
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Cena:"));

            try{
            String strComando="select tipo, alimento from descdieta where id_dieta="+diet+" and fecha='"+fech+"' and tipo='cena'";
            cdr = sentenciaSQL.executeQuery(strComando);
            
            while(cdr.next()){
                doc.add(new Paragraph(cdr.getString("alimento")));
            }
        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
            
            
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Colación:"));

            try{
            String strComando="select tipo, alimento from descdieta where id_dieta="+diet+" and fecha='"+fech+"' and tipo='colacion'";
            cdr = sentenciaSQL.executeQuery(strComando);
            
            while(cdr.next()){
                doc.add(new Paragraph(cdr.getString("alimento")));
            }
        }catch(SQLException e){
            out.println("Ecepción SQL: " + e.getMessage());
        }catch(NullPointerException e){
            out.println("Apuntado SQL: " + e.getMessage());
        }
            doc.add(new Paragraph(" "));

                doc.add(new Paragraph("**********************************************************************************************************"));
                Paragraph pie=new Paragraph("Gracias por su confiar en NutriWeb");
                pie.setAlignment(Element.ALIGN_CENTER);
                doc.add(pie);
                Paragraph pie2=new Paragraph("Visitanos en Facebook e Instagram");
                pie2.setAlignment(Element.ALIGN_CENTER);
                doc.add(pie2);
                Paragraph pie3=new Paragraph("Brindandote calidad y servicios desde 2019");
                pie3.setAlignment(Element.ALIGN_CENTER);
                doc.add(pie3);
                Paragraph pie4=new Paragraph("Conoce los mejores planes de dieta que nuestros nutriólogos tienen para ti.");
                pie4.setAlignment(Element.ALIGN_CENTER);
                doc.add(pie4);
                
                doc.close();    //Dejo de trabajar con el documento, pues no se volverá a utilizar.
            
               // Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            
            out.println("<center><h2>Tu dieta esta lista...!!!</h2></center>");
            
            //abrirPdfConEncabezado(ruta);
            
            
        } catch (Exception ex) {    //Atrapa la excepción en caso de un error.
            out.println("error: "+ex);
            //ex.printStackTrace();   //Imprime el error para ser corregido. Método obsoleto que puede generar errores de ejecución.
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
    

