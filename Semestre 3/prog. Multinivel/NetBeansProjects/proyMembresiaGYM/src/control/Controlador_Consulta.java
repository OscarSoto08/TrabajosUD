/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

public class Controlador_Consulta implements ActionListener{
    
    vista_Consulta frmC;
    Recaudo objR;

    public Controlador_Consulta(vista_Consulta frmC, Recaudo objR) {
        this.frmC = frmC;
        this.objR = objR;
    }
    
    public Controlador_Consulta() {
        this.frmC = new vista_Consulta();
    }
    
    public void iniciar()
    {
        this.frmC.getBtnBuscar().addActionListener(this);
        this.frmC.setTitle("Consultas Formulario");
        this.frmC.setLocation(200,200);
        this.frmC.setVisible(true);
    }

    public void agregarArchTabla(JTable tabla)
    {
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        Conexion con = new Conexion();
        try{    
            String []registros = con.leerDatos("DatosFactura.txt").split("\n");
            for (String registro : registros) {
                String []linea = registro.split(";");
                Object []reg = {linea[0],linea[1],linea[2],linea[3],linea[4],linea[5]};
                plantilla.addRow(reg);
            }
            
        }catch(IOException error){
            JOptionPane.showMessageDialog(frmC,"Error al abrir el archivo...","Error",JOptionPane.ERROR_MESSAGE);
        }
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(frmC.getBtnBuscar()))
      {
            agregarArchTabla(frmC.getTblDatos_Fact());
      }
    }
}

