package modelo;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DrawInterface;
import java.awt.*;
import java.io.*;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ArchPdf{
    private File ruta_destino;

    public ArchPdf() {
        this.ruta_destino = new File(System.getProperty("user.dir") + File.separator + "Factura_GYM");
    }
    
    public void crear_PDF(Factura_Gym factura){
        try {
            Document myPdf = new Document();
            PdfWriter.getInstance(myPdf, new FileOutputStream(ruta_destino));
                myPdf.open();
            
            com.itextpdf.text.Font tituloFuente = FontFactory.getFont(FontFactory.HELVETICA,22,BaseColor.BLUE);
            //com.itextpdf.text.Font subtituloFuente = FontFactory.getFont(FontFactory.HELVETICA,18,BaseColor.CYAN);
            com.itextpdf.text.Font itemFuente = FontFactory.getFont(FontFactory.HELVETICA,12,BaseColor.BLACK);
            
            Fecha fechaActual = new Fecha();
            Paragraph fechaPDF = new Paragraph(fechaActual.toString());
            fechaPDF.setAlignment(Element.ALIGN_RIGHT);
            fechaPDF.setSpacingBefore(5);
                myPdf.add(fechaPDF);
                
            Paragraph titulo = new Paragraph("ID Factura: " + factura.getIdFact(), tituloFuente);
            titulo.setSpacingAfter(5);
            titulo.setSpacingBefore(10);
                myPdf.add(titulo);
            
            List detallesFactura = new List(List.UNORDERED);
            //detallesFactura.setListSymbol(new Chunk("\u2022"+itemFuente));
            
            detallesFactura.add(new ListItem(new Chunk("Fecha de factura: " + factura.getFechaF())));
            detallesFactura.add(new ListItem(new Chunk("ID propietario: " + factura.getCliente().getID())));
            detallesFactura.add(new ListItem(new Chunk("Nombre propietario: " + factura.getCliente().getNombre())));
            detallesFactura.add(new ListItem(new Chunk("Categoria: " + factura.getMemb().getCategoria())));
            detallesFactura.add(new ListItem(new Chunk("Valor Pago: " + factura.getMemb().valorPago())));
            
                myPdf.add(detallesFactura);
                myPdf.add(Chunk.NEWLINE);
                myPdf.close();
                
                Object[] opciones = {"Aceptar", "Cancelar", "Ayuda"};
                JOptionPane.showOptionDialog(
                    null, 
                    "PDF creado con éxito", 
                    "Atencion",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);
            
                abrirPDF();
        } catch (IOException ex) {
            Logger.getLogger(ArchPdf.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ArchPdf.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void abrirPDF(){
        
            try {
                if(Desktop.isDesktopSupported())
                    Desktop.getDesktop().open(ruta_destino);
                else
                    JOptionPane.showMessageDialog(null, "No se pudo abrir el PDF");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
                //Logger.getLogger(ArchPdf.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public ArchPdf(File ruta_destino) {
        this.ruta_destino = ruta_destino;
    }

    public File getRuta_destino() {
        return ruta_destino;
    }
}