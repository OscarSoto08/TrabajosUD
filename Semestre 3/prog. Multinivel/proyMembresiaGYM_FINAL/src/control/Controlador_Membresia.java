/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
package control;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser; // Se usa esta libreria para la fecha
import java.util.Calendar;
import modelo.*;
import vista.vista_Membresia;

/**
 * Controlador encargado de gestionar la lógica de la ventana de registro de membresía.
 * Este controlador implementa la interfaz ActionListener para manejar eventos de acción,
 * como hacer clic en botones.
 */
public class Controlador_Membresia implements ActionListener {
   /**
    * Ventana de membresía donde se realizarán las operaciones.
    */
   private vista_Membresia ventana_Membresia;

   /**
    * Instancia de la factura actual que se está procesando.
    */
   private Factura_Gym factura;

   /**
    * Instancia del objeto de recaudo utilizado para calcular el valor total de las membresías.
    */
   private Recaudo recaudo;

    /**
     * Constructor del controlador de membresía que recibe la vista, la factura y el recaudo.
     * 
     * @param ventana_Membresia La vista de membresía.
     * @param factura La instancia de Factura_Gym.
     * @param recaudo El objeto Recaudo.
     */
    public Controlador_Membresia(vista_Membresia ventana_Membresia, Factura_Gym factura, Recaudo recaudo) {
        this.ventana_Membresia = ventana_Membresia;
        this.factura = factura;
        this.recaudo = recaudo;
    }
    /**
     * Constructor del controlador de membresía que recibe solo la vista.
     * 
     * @param ventana_Membresia La vista de membresía.
     */
    public Controlador_Membresia(vista_Membresia ventana_Membresia) {
        this.ventana_Membresia = ventana_Membresia;
        this.factura = new Factura_Gym();
        this.recaudo = new Recaudo();
    }
    
    /**
     * Método para inicializar la vista y añadir los listeners a los componentes.
     */
    public void iniciar() {
        this.ventana_Membresia.getBtnRegistrar().addActionListener(this);
        this.ventana_Membresia.getRbtn_Memb_A().addActionListener(this);
        this.ventana_Membresia.getRdbtn_Memb_B().addActionListener(this);
        this.ventana_Membresia.getRdbtn_Memb_C().addActionListener(this);
        this.ventana_Membresia.getSpinner_Ciudad().getModel().setValue("Bogotá");

        ventana_Membresia.setTitle("REGISTRO CLIENTES GIMNASIO");
        ventana_Membresia.setVisible(true);
        ventana_Membresia.setLocation(200, 200);
    }
    /**
     * Método para validar los campos del formulario antes de realizar el registro.
     * 
     * @return true si todos los campos están completos y válidos, false de lo contrario.
     */
    private boolean validarCampos() {
        if (!ventana_Membresia.getRbtn_Memb_A().isSelected() &&
        !ventana_Membresia.getRdbtn_Memb_B().isSelected() &&
        !ventana_Membresia.getRdbtn_Memb_C().isSelected()) {
        mostrarError("No se ha seleccionado ninguna membresía.");
        return false;
    }
        if (ventana_Membresia.getTxtNombre().getText().trim().isEmpty()) {
            mostrarError("El campo Nombre está vacío.");
            return false;
        }
        if (ventana_Membresia.getTxtTelefono().getText().trim().isEmpty()) {
            mostrarError("El campo Teléfono está vacío.");
            return false;
        }
        if (ventana_Membresia.getTxtCorreo().getText().trim().isEmpty()) {
            mostrarError("El campo Correo está vacío.");
            return false;
        }
        if (ventana_Membresia.getTxtId().getText().trim().isEmpty()) {
            mostrarError("El campo ID está vacío.");
            return false;
        }
        if (ventana_Membresia.getCalendarioFN().getDate() == null) {
            mostrarError("El campo Fecha de Nacimiento está vacío.");
            return false;
        }
        return true;
    }

    /**
     * Método para limpiar todos los campos del formulario.
     */
    public void limpiarCampos() {
        ventana_Membresia.getTxtNombre().setText("");
        ventana_Membresia.getTxtId().setText("");
        ventana_Membresia.getTxtCorreo().setText("");
        ventana_Membresia.getTxtTelefono().setText("");
        ventana_Membresia.getSpinner_Ciudad().setValue("Bogotá");
        ventana_Membresia.getCalendarioFN().setDate(Calendar.getInstance().getTime());
        ventana_Membresia.getButtonGroup1().clearSelection(); // Limpiar la selección de los radio buttons
    }

    /**
     * Método para iniciar la tabla, eliminando todas las filas existentes.
     * @param control La tabla a reiniciar.
     */
    private void iniciarTabla(JTable control) {
        DefaultTableModel model = (DefaultTableModel) control.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    /**
     * Método para agregar los datos de la factura a la tabla.
     * 
     * @param factura La factura a agregar.
     * @param tabla La tabla donde se agregará la factura.
     */
    private void agregarClientes(Factura_Gym factura, JTable tabla) {
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        plantilla.addRow(factura.Registro());
    }

     /**
     * Método para mostrar un mensaje de error.
     * 
     * @param mensaje El mensaje de error a mostrar.
     */
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(ventana_Membresia, "Error: " + mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource().equals(ventana_Membresia.getBtnRegistrar())) {
                // Validar campos antes de proceder
                if (!validarCampos()) {
                    return; // Si hay campos vacíos, salir del método
                }

                // Crear una nueva instancia de Factura_Gym y Propietario
                factura = new Factura_Gym();
                Persona propietario = new Persona();
                factura.setCliente(propietario);

                propietario.setNombre(ventana_Membresia.getTxtNombre().getText());
                propietario.setTelefono(ventana_Membresia.getTxtTelefono().getText());
                propietario.setCorreo(ventana_Membresia.getTxtCorreo().getText());
                propietario.setCiudad(ventana_Membresia.getSpinner_Ciudad().getValue().toString());
                propietario.setID(ventana_Membresia.getTxtId().getText());
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                String[] fecha = df.format(ventana_Membresia.getCalendarioFN().getDate()).split("/");
                propietario.setFechaNac(new Fecha(
                    Integer.parseInt(fecha[0]),
                    Integer.parseInt(fecha[1]),
                    Integer.parseInt(fecha[2])
                ));
                if (ventana_Membresia.getRbtn_Memb_A().isSelected()) {
                    TipoA memb_A = new TipoA();
                    factura.setMemb(memb_A);
                } else if (ventana_Membresia.getRdbtn_Memb_B().isSelected()) {
                    TipoB memb_B = new TipoB();
                    factura.setMemb(memb_B);
                } else if (ventana_Membresia.getRdbtn_Memb_C().isSelected()) {
                    TipoC memb_C = new TipoC();
                    factura.setMemb(memb_C);
                }

                recaudo.getListaF().add(factura);
                
                JOptionPane.showMessageDialog(ventana_Membresia, factura.toString()
                    + "\n TOTAL PAGO:   " + recaudo.valorPago());
                agregarClientes(factura, ventana_Membresia.getTblDatos());
                
                                ArchPdf arch = new ArchPdf();
                                arch.crear_PDF(factura);

                                arch.abrirPDF();
                                        
                // Agregar a la Base de datos
                FacturaDAO objFDAO = new FacturaDAO();
                objFDAO.setObjF(factura);
                PersonaDAO objPDAO = new PersonaDAO();
                objPDAO.setObjP(propietario);
                
                JOptionPane.showMessageDialog(ventana_Membresia, objPDAO.insertar());
                JOptionPane.showMessageDialog(ventana_Membresia, objFDAO.insertar());


                recaudo.getListaF().add(factura);

                limpiarCampos();
            }

            
        } catch (NumberFormatException excepcion) {
            mostrarError("Error de formato de número: " + excepcion.getMessage());
        }
    }
}
