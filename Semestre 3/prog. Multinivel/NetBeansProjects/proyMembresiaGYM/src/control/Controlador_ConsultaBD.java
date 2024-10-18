package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class Controlador_ConsultaBD implements ActionListener, MouseListener {
        vista_ConsultaBD frmC;
        
        Recaudo objR;
        Factura_Gym objF;
        Membresia objM;
        
        Object objRegistro;
        JTable tablaDatos;
        
        public Controlador_ConsultaBD(){
            this.objR = new Recaudo();
            this.frmC = new vista_ConsultaBD();
            this.objF = new Factura_Gym();
            this.tablaDatos = new JTable();
            
            this.frmC.getBtnBuscar().addActionListener(this);
            this.frmC.getBtnActualizar().addActionListener(this);
            this.frmC.getBtnEliminar().addActionListener(this);
            this.frmC.getTblDatos_Clientes().addMouseListener(this);
            this.frmC.getTblDatos_Fact().addMouseListener(this);
            this.frmC.getTblDatos_Membresias().addMouseListener(this);
        }
        
        public Controlador_ConsultaBD(JInternalFrame form, Recaudo objR){
            this.objR = objR;
            this.frmC = (vista_ConsultaBD) form;
            this.objF = new Factura_Gym();
            
            this.frmC.getBtnBuscar().addActionListener(this);
            this.frmC.getBtnActualizar().addActionListener(this);
            this.frmC.getBtnEliminar().addActionListener(this);
        }

        
    public void iniciar(){
        frmC.setTitle("Consulta BD");
        frmC.setLocation(50,10);
        BDTabla();
        frmC.setVisible(true);
    }    
        
    public void BDTabla(){
        FacturaDAO objFBD = new FacturaDAO();
        this.frmC.getTblDatos_Fact().setModel(objFBD.consultar());
    }    
    
    public String enviarDatosDAO(JTable tabla) {
        String mensaje = "";

        // Guarda la referencia de la tabla en la variable miembro
        tablaDatos = tabla;

        // Obtiene la fila seleccionada
        int fila = tabla.getSelectedRow();

        // Verifica si hay una fila seleccionada
        if (fila < 0) {
            mensaje = "No hay una fila seleccionada.";
            return mensaje;
        }

        // Obtiene el nombre de la primera columna y el valor de la primera celda de la fila seleccionada
        String columna0 = tabla.getColumnName(0);
        String valor0 = tabla.getValueAt(fila, 0).toString();

        try {
            if (columna0.equals("Id_Membresia")) {
                // No es necesario pasar un valor, se usará el método valorPago en cada tipo
                switch (valor0.toUpperCase()) {
                    case "A":
                        TipoA A = new TipoA();
                        objRegistro = A;
                        break;
                    case "B":
                        TipoB B = new TipoB();
                        objRegistro = B;
                        break;
                    case "C":
                        TipoC C = new TipoC();
                        objRegistro = C;
                        break;
                    default:
                        mensaje = "Tipo de membresía no reconocido: " + valor0;
                        return mensaje;
                }
            } else if (columna0.equals("Id_Cliente")) {
                // Se asume que las columnas correspondientes existen y tienen valores válidos
                Persona objPersona = new Persona(
                        valor0,
                        tabla.getValueAt(fila, 1).toString(),
                        tabla.getValueAt(fila, 2).toString(),
                        tabla.getValueAt(fila, 3).toString(),
                        tabla.getValueAt(fila, 4).toString()
                );
                objRegistro = objPersona;
            } else if (columna0.equals("Id")) {
                // Se asume que las columnas correspondientes existen y tienen valores válidos
                
                Membresia objM = new Membresia(tabla.getValueAt(fila, 1).toString()) {
                    @Override
                    public double valorPago() {
                        if(objM.getCategoria() == "A")
                            return 65000;
                        if(objM.getCategoria() == "B")
                            return 250000;
                        if(objM.getCategoria() == "C")
                            return 300000;
                        else 
                            return 0;
                    }
                };
                
                SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
                    String fecha[] = df.format(tabla.getValueAt(fila, 2).toString()).split("/");
                    Fecha objF = new Fecha(Integer.parseInt(fecha[0]),
                            (Integer.parseInt(fecha[1])),
                            (Integer.parseInt(fecha[2])));
                    
                Factura_Gym objFactura = new Factura_Gym();
                objFactura.setIdFact(valor0);
                objFactura.setFechaF(objF);
                objFactura.setMemb(objM);
                objFactura.getPropietario().setNombre(tabla.getValueAt(fila, 3).toString());
                
                
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

        // Si todo va bien, devuelve un mensaje de éxito vacío o puedes asignar un mensaje de éxito
        mensaje = "Datos procesados correctamente.";
        return mensaje;
    }

    public boolean verificar(String oper){
        int resp = JOptionPane.showConfirmDialog(frmC, objRegistro.toString() + 
                "\n¿Está seguro de " + oper + " estos datos?", oper, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
                
        if(resp == JOptionPane.YES_OPTION){
            return true;
        }else{
            return false;
        }              
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
            FacturaDAO objFDAO = new FacturaDAO();
            //Boton Actualizar
            if(e.getSource().equals(frmC.getBtnActualizar())){
                if(verificar("Actualizar")){
                    JOptionPane.showMessageDialog(frmC, objFDAO.actualizarPersona(objRegistro));
                }else{
                    BDTabla();
                }
            }
            
            if(e.getSource().equals(frmC.getBtnEliminar())){
                if(verificar("Eliminar")){
                    //elimina el registro en BD
                    JOptionPane.showMessageDialog(frmC, objFDAO.eliminarPersona(objRegistro));
                    //elimina fila de la tabla
                    DefaultTableModel plantilla=(DefaultTableModel)tablaDatos.getModel();
                    plantilla.removeRow(tablaDatos.getSelectedRow());
                }else{
                    BDTabla();
                }
            }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(frmC.getTblDatos_Fact())){
            enviarDatosDAO(frmC.getTblDatos_Fact());
        }
        if(e.getSource().equals(frmC.getTblDatos_Clientes())){
            enviarDatosDAO(frmC.getTblDatos_Clientes());
        }
        if(e.getSource().equals(frmC.getTblDatos_Membresias())){
            enviarDatosDAO(frmC.getTblDatos_Membresias());
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
