package control;

import java.awt.Component;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class Controlador_Membresia implements ActionListener
{
    vista_Membresia ventana_Membresia;
    Factura_Gym factura;
    Recaudo recaudo;

    public Controlador_Membresia(vista_Membresia ventana_Membresia, Factura_Gym factura, Recaudo recaudo) {
        this.ventana_Membresia = ventana_Membresia;
        this.factura = factura;
        this.recaudo = recaudo;
    }

    public Controlador_Membresia(JInternalFrame frame) {
        this.ventana_Membresia = (vista_Membresia) frame;
        this.factura = new Factura_Gym();
        this.recaudo = new Recaudo();
    }    

    public void iniciar()
    {
        this.ventana_Membresia.getBtnRegistrar().addActionListener(this);
        this.ventana_Membresia.getRbtn_Memb_A().addActionListener(this);
        this.ventana_Membresia.getRdbtn_Memb_B().addActionListener(this);
        this.ventana_Membresia.getRdbtn_Memb_C().addActionListener(this);
        this.ventana_Membresia.getBtnPdf().addActionListener(this);
        this.ventana_Membresia.getSpinner_Ciudad().getModel().setValue("Bogotá");
        
        ventana_Membresia.setTitle("REGISTRO CLIENTES GIMNASIO");
        ventana_Membresia.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana_Membresia.setVisible(true);
        ventana_Membresia.setLocation(200,200);
    }
    
    public void iniciarControles(Component[] controles) 
    {
        for (Component control : controles) {
            if(control instanceof JTabbedPane)
            {
                int cantTab = ((JTabbedPane) control).getTabCount();
                for (int i = 0; i < cantTab; i++) {
                    Component panel = ((JTabbedPane) control).getComponent(i);
                    iniciarControles(((JPanel) panel).getComponents());
                }
            }
            else if(control instanceof JPanel)           
                iniciarControles(((JPanel) control).getComponents());    
            else if(control instanceof JTextField)
            {
                ((JTextField) control).setText("");
            }
        }
    }
    
    public void iniciarTabla(JTable control) 
    {
        DefaultTableModel model = (DefaultTableModel) control.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    public void agregarClientes(Factura_Gym factura,JTable tabla)
    {  
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();  
        plantilla.addRow(factura.Registro());
    }
    
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(ventana_Membresia, "Error: " + mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
            try{
            if (e.getSource().equals(ventana_Membresia.getBtnRegistrar())) {
                if(factura.getPropietario().getID().equals(""))
                {
                    
                    factura.getPropietario().setNombre(ventana_Membresia.getTxtNombre().getText());
                    factura.getPropietario().setTelefono(ventana_Membresia.getTxtTelefono().getText());
                    factura.getPropietario().setCorreo(ventana_Membresia.getTxtCorreo().getText());
                    factura.getPropietario().setCiudad(ventana_Membresia.getSpinner_Ciudad().getValue().toString());
                    factura.getPropietario().setID(ventana_Membresia.getTxtId().getText());
                    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    String fecha[] = df.format(ventana_Membresia.getCalendarioFN().getDate()).split("/");
                    factura.getPropietario().setFechaNac(new Fecha(Integer.parseInt(fecha[0]),
                            (Integer.parseInt(fecha[1])),
                            (Integer.parseInt(fecha[2]))));
                }
                if (ventana_Membresia.getRbtn_Memb_A().isSelected()) {
                    TipoA memb_A= new TipoA();                    
                    factura.setMemb(memb_A);
                } else if (ventana_Membresia.getRdbtn_Memb_B().isSelected()) {
                    TipoB memb_B= new TipoB();                    
                    factura.setMemb(memb_B);                    
                }else if (ventana_Membresia.getRdbtn_Memb_C().isSelected()) {
                    TipoC memb_C= new TipoC();                    
                    factura.setMemb(memb_C);
                }
                recaudo.getListaF().add(factura);
                JOptionPane.showMessageDialog(ventana_Membresia, factura.getMemb().toString()
                            + "\n TOTAL PAGO:   " + recaudo.valorPago());
                agregarClientes(factura, ventana_Membresia.getTblDatos());
                
                //Agregar a la Base de datos
                FacturaDAO objFDAO = new FacturaDAO();
                objFDAO.setObjP(factura);
                JOptionPane.showMessageDialog(ventana_Membresia, objFDAO.insertarPersona());
                recaudo.getListaF().add(factura);        
                
                //iniciar los controles una vez terminado el proceso
                iniciarControles(ventana_Membresia.getContentPane().getComponents());
            }
            if(e.getSource().equals(ventana_Membresia.getBtnPdf()))
            {
                ArchPdf arch = new ArchPdf();
                arch.crear_PDF(recaudo);
                arch.abrirPDF();
                iniciarTabla(ventana_Membresia.getTblDatos());
            }
        }catch (NumberFormatException excepcion) {
            mostrarError("Error de formato de número: " + excepcion.getMessage());
        } catch (IllegalArgumentException excepcion) {
            mostrarError("Error en la entrada de fecha: " + excepcion.getMessage());
        } catch (Exception excepcion) {
            mostrarError("Error desconocido: " + excepcion.getMessage());
        }
}
}
            
    


