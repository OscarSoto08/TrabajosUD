package modelo;
/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * Clase para generar y manejar documentos PDF relacionados con el recaudo del gimnasio.
 * Permite crear un documento PDF con el total recaudado y abrirlo automáticamente si es posible.
 */
public class RecaudoPDF {
    // Ruta de destino para guardar el PDF generado
    private File ruta_destino;

    /**
     * Constructor que establece la ruta de destino del PDF en el directorio actual con un nombre predeterminado.
     */
    public RecaudoPDF() {
        this.ruta_destino = new File(System.getProperty("user.dir") + File.separator + "Recaudo_GYM.pdf");
    }

    /**
     * Genera un documento PDF con el total recaudado por el gimnasio.
     * 
     * @param totalRecaudado El total recaudado por el gimnasio
     */
    public void generarRecaudo(double totalRecaudado) {
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(ruta_destino));
            document.open();

            // Contenido del PDF
            document.add(new Paragraph("RECAUDO DE GIMNASIO"));
            document.add(new Paragraph("Total Recaudado: " + totalRecaudado));

            document.close();
            JOptionPane.showMessageDialog(null, "Documento PDF creado");

        } catch (DocumentException e) {
            JOptionPane.showMessageDialog(null, "Error al crear el PDF: " + e.getMessage());
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al encontrar el archivo: " + e.getMessage());
        }
    }

    /**
     * Abre el documento PDF generado automáticamente, si es posible.
     */
    public void abrirPDF() {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(this.ruta_destino);
            } else {
                JOptionPane.showMessageDialog(null, "No se puede abrir el PDF automáticamente.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al abrir el PDF: " + ex.getMessage());
        }
    }

    /**
     * Obtiene la ruta de destino del PDF.
     * 
     * @return La ruta de destino del PDF
     */
    public File getRuta_destino() {
        return ruta_destino;
    }

    /**
     * Establece la ruta de destino del PDF.
     * 
     * @param ruta_destino La nueva ruta de destino del PDF
     */
    public void setRuta_destino(File ruta_destino) {
        this.ruta_destino = ruta_destino;
    }
}
