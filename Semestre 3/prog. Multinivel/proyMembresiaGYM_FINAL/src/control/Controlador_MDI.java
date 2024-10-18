/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 * Controlador para la ventana principal de la aplicación.
 * Maneja eventos de botones y opciones de menú.
 */
public class Controlador_MDI implements ActionListener{
    vista_MDI ventanaMDI; // Ventana principal
    Recaudo recaudo; // Objeto Recaudo

    /**
     * Constructor con parámetros.
     * @param ventanaMDI La ventana principal.
     * @param recaudo Objeto Recaudo.
     */
    public Controlador_MDI(vista_MDI ventanaMDI, Recaudo recaudo) {
        this.ventanaMDI = ventanaMDI;
        this.recaudo = recaudo;
    }
    
    /**
     * Constructor por defecto.
     * Inicializa la ventana principal y el objeto Recaudo.
     */
    public Controlador_MDI() {
        this.ventanaMDI = new vista_MDI();
        this.recaudo = new Recaudo();
    }

    /**
     * Inicia la ventana principal y asigna los listeners a los botones y opciones de menú.
     */
     public void iniciar(){        
        // Agregar listeners a los botones
        this.ventanaMDI.getBtnConsulta().addActionListener(this);
        this.ventanaMDI.getBtnMembresia().addActionListener(this);
        this.ventanaMDI.getBtnSalir().addActionListener(this);
        this.ventanaMDI.getBtnRecaudo().addActionListener(this);
        this.ventanaMDI.getBtnConsultaBD().addActionListener(this);
        // Agregar listeners a las opciones de menú
        this.ventanaMDI.getMenu_Consulta().addActionListener(this);
        this.ventanaMDI.getMenu_Membresia().addActionListener(this);
        this.ventanaMDI.getMenu_Salir().addActionListener(this);
        this.ventanaMDI.getMenu_Recaudo().addActionListener(this);   
        this.ventanaMDI.getMenu_ConsultaBD().addActionListener(this);
        // Configuración de la ventana principal
        ventanaMDI.setTitle("REGISTRO CLIENTES GIMNASIO: ");
        ventanaMDI.setLocationRelativeTo(null);
        ventanaMDI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaMDI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaMDI.setVisible(true);
    }
    
     /**
     * Maneja los eventos de los botones y opciones de menú.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Acciones cuando se selecciona la opción de salida
        if(e.getSource()==ventanaMDI.getMenu_Salir()||e.getSource()==ventanaMDI.getBtnSalir()){
            int resp = JOptionPane.showConfirmDialog(ventanaMDI, "¿Desea terminar la ejecución?", "Salida", JOptionPane.CLOSED_OPTION);
            if(resp==JOptionPane.YES_OPTION){
                ventanaMDI.dispose();
            }
        }
        
        // Acciones cuando se selecciona la opción o botón de gestión de membresía
        if (e.getSource() == ventanaMDI.getMenu_Membresia() || e.getSource() == ventanaMDI.getBtnMembresia()) {
            // Comprobar si ya hay una instancia de vista_Membresia abierta
            boolean isMembresiaOpen = false;
            for (JInternalFrame frame : ventanaMDI.getEscritorio().getAllFrames()) {
                if (frame instanceof vista_Membresia) {
                    // Si ya está abierta, traerla al frente
                    frame.toFront();
                    try {
                        frame.setSelected(true); // Seleccionarla
                    } catch (java.beans.PropertyVetoException ex) {
                        ex.printStackTrace();
                    }
                    isMembresiaOpen = true;
                    break;
                }
            }

            // Si no está abierta, crear una nueva instancia
            if (!isMembresiaOpen) {
                vista_Membresia ventana_Membresia = new vista_Membresia();
                ventanaMDI.getEscritorio().add(ventana_Membresia);

                // Permitir el cierre del JInternalFrame
                ventana_Membresia.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

                // Agregar manejador de eventos para confirmar el cierre
                ventana_Membresia.addInternalFrameListener(new javax.swing.event.InternalFrameAdapter() {
                    @Override
                    public void internalFrameClosing(javax.swing.event.InternalFrameEvent e) {
                        int resp = JOptionPane.showConfirmDialog(ventanaMDI, "¿Desea cerrar esta ventana?", "Confirmar Cierre", JOptionPane.YES_NO_OPTION);
                        if (resp == JOptionPane.YES_OPTION) {
                            ventana_Membresia.dispose();
                        } else {
                            ventana_Membresia.setDefaultCloseOperation(JInternalFrame.DO_NOTHING_ON_CLOSE);
                        }
                    }
                });

                // Iniciar el controlador específico para la ventana
                Controlador_Membresia control_Memb = new Controlador_Membresia(ventana_Membresia);
                control_Memb.iniciar();
            }
        }

        // Acciones cuando se selecciona la opción o botón de consulta
        if(e.getSource().equals(ventanaMDI.getBtnConsulta()) || e.getSource().equals(ventanaMDI.getMenu_Consulta()))
        {
            vista_Consulta ventana_Consulta = new vista_Consulta();
            ventanaMDI.getEscritorio().add(ventana_Consulta);
            ventana_Consulta.setVisible(true);
            Controlador_Consulta consulta= new Controlador_Consulta(ventana_Consulta, recaudo);
            consulta.iniciar();
        }
        
        // Acciones cuando se selecciona la opción o botón de consulta a la base de datos
        if(e.getSource().equals(ventanaMDI.getBtnConsultaBD()) || e.getSource().equals(ventanaMDI.getMenu_ConsultaBD()))
        {           

            vista_ConsultaBD ventana_ConsultaBD = new vista_ConsultaBD();
            ventanaMDI.getEscritorio().add(ventana_ConsultaBD);
            ventana_ConsultaBD.setVisible(true);
            Controlador_ConsultaBD consultaBD = new Controlador_ConsultaBD(ventana_ConsultaBD, recaudo);
            consultaBD.iniciar();
        }
                
        // Acciones cuando se selecciona la opción o botón de recaudo
        if (e.getSource().equals(ventanaMDI.getBtnRecaudo()) || e.getSource().equals(ventanaMDI.getMenu_Recaudo())) {
            double totalRecaudado = 0;
            try {
                ConexionBD conexion = new ConexionBD();
                conexion.conectar();
                if (conexion.getConexion() != null) {
                    Statement consulta = conexion.getConexion().createStatement();

                    String queryTotal = "SELECT sum(memb.Valor_Pago) as Total FROM factura_gym fg join membresia memb on(memb.Id_Membresia = fg.Id_Membresia)";
                    ResultSet resultado = consulta.executeQuery(queryTotal);
                    if (resultado.next()) {
                        totalRecaudado = resultado.getDouble("Total");
                    }

                    consulta.close();
                    conexion.getConexion().close();
                } else {
                    JOptionPane.showMessageDialog(ventanaMDI, "No se pudo establecer la conexión a la base de datos", "Error de conexión", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(ventanaMDI, "Error al ejecutar la consulta: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }

            // Generar el recaudo PDF con el valor obtenido
            RecaudoPDF recaudoPDF = new RecaudoPDF();
            recaudoPDF.generarRecaudo(totalRecaudado);
            // Abrir el PDF automaáticamente
            recaudoPDF.abrirPDF();
        }


         
    }
        
    
}

