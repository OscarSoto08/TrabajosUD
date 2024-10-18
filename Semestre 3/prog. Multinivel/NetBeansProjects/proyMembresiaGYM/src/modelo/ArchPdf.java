package modelo;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ArchPdf {

    private File ruta_destino;

    public ArchPdf() {
        // Define la ruta del archivo PDF en la raíz del proyecto
        this.ruta_destino = new File(System.getProperty("user.dir") + File.separator + "documento.pdf");
    }

    /* Metodo que hace uso de la clase iText para manipular archivos PDF */
    public void crear_PDF(Recaudo objR) {
        if (this.ruta_destino != null) {
            try {
                // Se crea instancia del documento
                Document mipdf = new Document();
                // Se establece una instancia a un documento PDF
                PdfWriter.getInstance(mipdf, new FileOutputStream(this.ruta_destino));
                mipdf.open(); // Se abre el documento
                mipdf.addTitle("Datos Gimnasio");

                mipdf.add(new Paragraph("\tFacturas de Gimnasio\n"));

                mipdf.add(new Paragraph(objR.toString())); // Añade el contenido del PDF
                mipdf.close(); // Se cierra el PDF

                JOptionPane.showMessageDialog(null, "Documento PDF creado");

                // Abre el PDF automáticamente
                abrirPDF();

            } catch (DocumentException | FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
    }

    /* Metodo para abrir el PDF */
    public void abrirPDF() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(this.ruta_destino);
            } else {
                JOptionPane.showMessageDialog(null, "No se puede abrir el PDF automáticamente.");
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir el PDF: " + ex.getMessage());
        }
    }

    public File getRuta_destino() {
        return ruta_destino;
    }

    public void setRuta_destino(File ruta_destino) {
        this.ruta_destino = ruta_destino;
    }
}
