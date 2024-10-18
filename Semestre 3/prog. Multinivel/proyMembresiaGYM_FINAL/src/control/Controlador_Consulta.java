/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 * Clase Controlador_Consulta que gestiona la lógica de consulta en la vista_Consulta.
 * Implementa la interfaz ActionListener para manejar eventos de botones.
 * Controla la agregación de datos desde archivos a las tablas de la interfaz.
 */
public class Controlador_Consulta implements ActionListener{
    
    vista_Consulta frmC; // Instancia de la vista_Consulta
    Recaudo objR; // Objeto Recaudo

    /**
     * Constructor que recibe la vista_Consulta y el objeto Recaudo.
     * 
     * @param frmC La instancia de la vista_Consulta
     * @param objR El objeto Recaudo
     */
    public Controlador_Consulta(vista_Consulta frmC, Recaudo objR) {
        this.frmC = frmC;
        this.objR = objR;
    }
    
    /**
     * Constructor por defecto que inicializa una instancia de la vista_Consulta.
     */
    public Controlador_Consulta() {
        this.frmC = new vista_Consulta();
    }
    
    /**
     * Método para iniciar la vista_Consulta y agregar el ActionListener al botón.
     */
    public void iniciar()
    {
        this.frmC.getBtnBuscar().addActionListener(this);
        this.frmC.setTitle("Consultas Formulario");
        this.frmC.setLocation(200,200);
        this.frmC.setVisible(true);
        
    }

    /**
     * Método para agregar datos de facturas desde un archivo a la tabla.
     * 
     * @param tabla La tabla de facturas
     */
    public void agregarArchFactura(JTable tabla)
    {
        // Leer datos del archivo de facturas y agregarlos a la tabla
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        Conexion con = new Conexion();
        try{    
            String []registros = con.leerDatos("DatosFactura.txt").split("\n");
            for (String registro : registros) {
                String []linea = registro.split(";");
                Object []reg = {linea[0],linea[1],linea[2],linea[3],linea[4]};
                plantilla.addRow(reg);
            }
            
        }catch(IOException error){
            JOptionPane.showMessageDialog(frmC,"Error al abrir el archivo...","Error",JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    /**
     * Método para agregar datos de clientes desde un archivo a la tabla.
     * 
     * @param tabla La tabla de clientes
     */
    public void agregarArchClientes(JTable tabla)
    {
        // Leer datos del archivo de clientes y agregarlos a la tabla
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        Conexion con = new Conexion();
        try{    
            String []registros = con.leerDatos("DatosClientes.txt").split("\n");
            for (String registro : registros) {
                String []linea = registro.split(";");
                Object []reg = {linea[0],linea[1],linea[2],linea[3],linea[4],linea[5]};
                plantilla.addRow(reg);
            }
            
        }catch(IOException error){
            JOptionPane.showMessageDialog(frmC,"Error al abrir el archivo...","Error",JOptionPane.ERROR_MESSAGE);
        }
    }   
    /**
     * Método para agregar datos de membresías desde un archivo a la tabla.
     * 
     * @param tabla La tabla de membresías
     */
    public void agregarArchMembresias(JTable tabla)
    {
        // Leer datos del archivo de membresías y agregarlos a la tabla
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        Conexion con = new Conexion();
        try{    
            String []registros = con.leerDatos("DatosMembresia.txt").split("\n");
            for (String registro : registros) {
                String []linea = registro.split(";");
                Object []reg = {linea[0],linea[1]};
                plantilla.addRow(reg);
            }
            
        }catch(IOException error){
            JOptionPane.showMessageDialog(frmC,"Error al abrir el archivo...","Error",JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    /**
     * Manejo de eventos de los botones. Si el evento es del botón de búsqueda,
     * se agregan los datos a las tablas correspondientes.
     * 
     * @param e El evento que se produce
     */
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(frmC.getBtnBuscar()))
      {
            agregarArchFactura(frmC.getTblDatos_Fact());
            agregarArchClientes(frmC.getTblDatos_Clientes());
            agregarArchMembresias(frmC.getTblDatos_Membresias());
      }
    }
}

