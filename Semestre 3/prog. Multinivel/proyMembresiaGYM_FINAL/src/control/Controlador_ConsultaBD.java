/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 * Controlador para la ventana de consulta de la base de datos.
 * Maneja eventos de botones y clics de ratón en las tablas.
 */
public class Controlador_ConsultaBD implements ActionListener, MouseListener {
    private vista_ConsultaBD frmC; // Ventana de consulta
    private Recaudo objR; // Objeto Recaudo
    private Factura_Gym objF; // Objeto Factura_Gym
    private Membresia objM; // Objeto Membresia
    Object objRegistro; // Objeto seleccionado en la tabla
    JTable tablaDatos; // Tabla de datos

    /**
     * Constructor por defecto.
     * Inicializa los objetos y la ventana de consulta.
     */
    public Controlador_ConsultaBD() {
        this.objR = new Recaudo();
        this.frmC = new vista_ConsultaBD();
        this.objF = new Factura_Gym();
        this.tablaDatos = new JTable();
    }

    /**
     * Constructor con parámetros.
     * @param form La ventana de consulta.
     * @param objR Objeto Recaudo.
     */
    public Controlador_ConsultaBD(JInternalFrame form, Recaudo objR) {
        this.objR = objR;
        this.frmC = (vista_ConsultaBD) form;
        this.objF = new Factura_Gym();
    }

    /**
     * Inicia la ventana y asigna los listeners a los botones y tablas.
     */
    public void iniciar() {
        this.frmC.getBtnBuscar().addActionListener(this);
        this.frmC.getBtnActualizar().addActionListener(this);
        this.frmC.getBtnEliminar().addActionListener(this);

        this.frmC.getTblDatos_Clientes().addMouseListener(this);
        this.frmC.getTblDatos_Fact().addMouseListener(this);
        this.frmC.getTblDatos_Membresias().addMouseListener(this);

        frmC.setTitle("Consulta BD");
        frmC.setLocation(50, 10);
        frmC.setVisible(true);
        BDTabla();
    }

    /**
     * Carga los datos de las tablas desde la base de datos.
     */
    public void BDTabla() {
        FacturaDAO objFDAO = new FacturaDAO();
        PersonaDAO objPDAO = new PersonaDAO();
        MembresiaDAO objMDAO = new MembresiaDAO(objM);
        
        
        this.frmC.getTblDatos_Fact().setModel(objFDAO.consultar());
        this.frmC.getTblDatos_Clientes().setModel(objPDAO.consultar());
        this.frmC.getTblDatos_Membresias().setModel(objMDAO.consultar());
    }

    /**
     * Procesa los datos seleccionados en la tabla y los envía al DAO correspondiente.
     * @param tabla La tabla de datos.
     * @return Mensaje de éxito o error.
     */
   public String enviarDatosDAO(JTable tabla) {
        String mensaje = "";

        tablaDatos = tabla;
        int fila = tabla.getSelectedRow();

        if (fila < 0) {
            mensaje = "No hay una fila seleccionada.";
            return mensaje;
        }

        String columna0 = tabla.getColumnName(0);
        String valor0 = tabla.getValueAt(fila, 0).toString();
        ClaseConversor conversor = new ClaseConversor();
        
        try {
            if (columna0.equals("Id_Membresia")) {
                // Procesamiento para la selección de membresía
                objRegistro = conversor.convertirStringAMembresia(valor0);
                
            } else if (columna0.equals("Id_Cliente")) {
                // Procesamiento para la selección de cliente
                
                String nombre = (String) tabla.getValueAt(fila, 1).toString();
                String telefono = (String) tabla.getValueAt(fila, 2).toString();
                String correo = (String) tabla.getValueAt(fila, 3).toString();
                String ciudad = (String) tabla.getValueAt(fila, 4).toString();
                String valorFecha = tabla.getValueAt(fila, 5).toString();
                
                Fecha FN = conversor.convertirStringAFecha(valorFecha);
                
                
                Persona objPersona = new Persona(valor0, nombre, telefono, correo, ciudad, FN);
                
                //Persona p = new Persona
                objRegistro = objPersona;
            } else if (columna0.equals("idFact")) {
                // Procesamiento para la selección de factura
                String idFact = tabla.getValueAt(fila, 0).toString();
                String tipoMembresia = tabla.getValueAt(fila, 3).toString();
                String fechaStr = tabla.getValueAt(fila, 1).toString();
                String idCliente = tabla.getValueAt(fila, 2).toString();
                
                Factura_Gym factura = new Factura_Gym();
                
                Membresia memb = conversor.convertirStringAMembresia(tipoMembresia);
                Fecha fecha = conversor.convertirStringAFecha(fechaStr);
                
                PersonaDAO objPDAO = new PersonaDAO();
                if(objPDAO.verificarPersona(idCliente) == null){
                    Persona cliente = new Persona();
                    cliente.setID(idCliente);
                    factura.setCliente(cliente);
                    eliminarFactura(factura);
                }
                
                Persona cliente = objPDAO.verificarPersona(idCliente);

                
                Factura_Gym objFactura = new Factura_Gym(idFact,memb,fecha,cliente);
                objRegistro = objFactura;
            } else {
                mensaje = "Columna desconocida: " + columna0;
                return mensaje;
            }
        } catch (NumberFormatException ex) {
            mensaje = "Error al convertir un valor a número: " + ex;
            return mensaje;
        } catch (ArrayIndexOutOfBoundsException ex) {
            mensaje = "Error: Acceso a columna fuera de límites: " + ex;
            return mensaje;
        } catch (ClassCastException ex) {
            mensaje = "Error de tipo de datos: " + ex;
            return mensaje;
        } catch (Exception ex) {
            mensaje = "Error general: " + ex;
            return mensaje;
        }

        mensaje = "Datos procesados correctamente.";
        return mensaje;
    }

   
    /**
     * Verifica si se desea realizar una acción sobre los datos seleccionados.
     * @param oper La operación a realizar.
     * @return true si se confirma, false si se cancela.
     */
    public boolean verificar(String oper) {
        
        try{
            int resp = JOptionPane.showConfirmDialog(frmC, objRegistro.toString() +
                "\n¿Está seguro de " + oper + " estos datos?", oper, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
            return resp == JOptionPane.YES_OPTION;
        }catch(java.lang.NullPointerException ex){
            JOptionPane.showMessageDialog(frmC, "Objeto nulo " + ex.getMessage());
        }
        return false;
    }

    /**
     * Maneja los eventos de botones.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
    int filaSeleccionada;
        if (e.getSource().equals(frmC.getBtnActualizar())) {
            // Actualización de datos en la base de datos
            if (tablaDatos == null) {
                JOptionPane.showMessageDialog(frmC, "No se ha seleccionado ninguna tabla.");
                return;
            }
            if (!verificar("Actualizar")) {
                JOptionPane.showMessageDialog(frmC, "Error desconocido");
            }    
            
            //DefaultTableModel plantilla = (DefaultTableModel) tablaDatos.getModel();
            filaSeleccionada = tablaDatos.getSelectedRow();

            if (filaSeleccionada < 0) {
                JOptionPane.showMessageDialog(frmC, "No se ha seleccionado ninguna fila.");
                return;
            }

            if (tablaDatos.equals(frmC.getTblDatos_Clientes()) && (objRegistro instanceof Persona)) 
                actualizarPersona((Persona) objRegistro);
            if (tablaDatos.equals(frmC.getTblDatos_Fact()) && (objRegistro instanceof Factura_Gym)) 
                actualizarFactura((Factura_Gym) objRegistro);
            BDTabla();
        
        }    
        if (e.getSource().equals(frmC.getBtnBuscar())) {
            // Consulta de datos en la base de datos
            BDTabla();
        }

        if (e.getSource().equals(frmC.getBtnEliminar())) {
            // Eliminación de datos en la base de datos
            if (tablaDatos == null) {
                JOptionPane.showMessageDialog(frmC, "No se ha seleccionado ninguna tabla.");
                return;
            }

            if (!verificar("Eliminar")) {
                
                JOptionPane.showMessageDialog(frmC, "Error desconocido");
            }    
            
            filaSeleccionada = tablaDatos.getSelectedRow();

            if (filaSeleccionada < 0) {
                JOptionPane.showMessageDialog(frmC, "No se ha seleccionado ninguna fila.");
                return;
            }
            
            if(objRegistro == null)
                JOptionPane.showMessageDialog(frmC, "Objeto registro es nulo");
            

            if (tablaDatos.equals(frmC.getTblDatos_Clientes()) && objRegistro instanceof Persona) 
                eliminarPersona((Persona) objRegistro);
            if (tablaDatos.equals(frmC.getTblDatos_Fact()) && objRegistro instanceof Factura_Gym)
                eliminarFactura((Factura_Gym) objRegistro);                
            BDTabla();
        }
    }

    //Metodos para eliminar
    
    /**
     *
     * @param factura
     */
    public void eliminarFactura(Factura_Gym factura){
        FacturaDAO objFDAO = new FacturaDAO();
        System.out.println(objFDAO.eliminarObjeto(factura));
    }
    
    public void eliminarPersona(Persona persona){
        PersonaDAO objPDAO = new PersonaDAO();
        System.out.println(objPDAO.eliminar(persona));
    }
    
    public void actualizarFactura(Factura_Gym factura){
        FacturaDAO objFDAO = new FacturaDAO();
        System.out.println(objFDAO.actualizarObjeto(factura));
    }
    
    public void actualizarPersona(Persona persona){
        PersonaDAO objPDAO = new PersonaDAO();
        System.out.println(objPDAO.actualizarPersona(persona));
    }
    /**
     * Maneja los eventos de clics de ratón en las tablas.
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(frmC.getTblDatos_Fact())) {
            enviarDatosDAO(frmC.getTblDatos_Fact());
        } else if (e.getSource().equals(frmC.getTblDatos_Clientes())) {
            enviarDatosDAO(frmC.getTblDatos_Clientes());
        } else if (e.getSource().equals(frmC.getTblDatos_Membresias())) {
            enviarDatosDAO(frmC.getTblDatos_Membresias());
        }
    }

    /**
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        // Implementación si es necesario
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseReleased(MouseEvent e) {
        // Implementación si es necesario
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseEntered(MouseEvent e) {
        // Implementación si es necesario
    }

    /**
     *
     * @param e
     */
    @Override
    public void mouseExited(MouseEvent e) {
        // Implementación si es necesario
    }

}
