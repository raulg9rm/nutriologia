/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

//import com.itextpdf.text.BadElementException;
//import com.itextpdf.text.BaseColor;
//import com.itextpdf.text.Document;
//import com.itextpdf.text.DocumentException;
//import com.itextpdf.text.Element;
//import com.itextpdf.text.Font;
//import com.itextpdf.text.Image;
//import com.itextpdf.text.Paragraph;
//import com.itextpdf.text.Rectangle;
//import com.itextpdf.text.pdf.PdfPCell;
//import com.itextpdf.text.pdf.PdfPTable;
//import com.itextpdf.text.pdf.PdfWriter;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.*;



/**
 *
 * @author Raúl
 */
public class ReporteCompra {
    /*Document documento=new Document();
    int cont=1;
    
    public static JFrame frame;
    
    public void reporteConEncabezado(){
        frame = new JFrame("ReporteCompra");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        try {
            String r=System.getProperty("user.dir")+("/src/facturas/");
            PdfWriter.getInstance(documento, new FileOutputStream(r+"FacturaCompra"+cont+".pdf"));
            documento.open();
            Paragraph par0=new Paragraph("FOLIO N°: 00"+cont);
            //par1.getFont().getColor(Color.BROWN);
            par0.setAlignment(Element.ALIGN_RIGHT);
            documento.add(par0);
            Paragraph par1=new Paragraph("Papelerias P@peli S.A. DE C.V.");
            //par1.getFont().getColor(Color.BROWN);
            par1.setAlignment(Element.ALIGN_CENTER);
            documento.add(par1);
            /*try {
                Image logo = Image.getInstance("E:/pape.jpg");
                logo.scaleAbsoluteWidth(160);
                logo.scaleAbsoluteHeight(110);
                logo.setAlignment(Element.ALIGN_RIGHT);
                //logo.setAbsolutePosition(150, 150);
                documento.add(logo);
            } catch (BadElementException ex) {
                Logger.getLogger(ReporteCompra.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReporteCompra.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            /*Paragraph parrafo1=new Paragraph("**P@PELI**");
            parrafo1.setAlignment(Element.ALIGN_LEFT);
            
            Paragraph parrafo2=new Paragraph("San Pedro");
            parrafo2.setAlignment(Element.ALIGN_LEFT);
            Paragraph parrafo3=new Paragraph("Humberto Lobo No. 540 B Col del Valle, San Pedro Garza García N.L.");
            parrafo3.setAlignment(Element.ALIGN_LEFT);
            Paragraph parrafo4=new Paragraph("Tel. 5572692900");
            parrafo4.setAlignment(Element.ALIGN_LEFT);
            documento.add(parrafo1);
            documento.add(parrafo2);
            documento.add(parrafo3);
            documento.add(parrafo4);
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            documento.add(new Paragraph(" "));
            
            documento.close();
            String ruta=System.getProperty("user.dir")+("/src/facturas/")+("/FacturaCompra"+cont+".pdf");
            abrirPdfConEncabezado(ruta);
            cont++;
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error al crear el documento");
        } catch (DocumentException ex) {
            Logger.getLogger(ReporteCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void abrirPdfConEncabezado(String ruta){
        File path=new File(ruta);
        try {
            
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            Logger.getLogger(ReporteCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
   
}
