package control;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class ControladorJIConsulta implements ActionListener{
    JIFrmConsulta frmC;
    Recaudo objR;
    
    public ControladorJIConsulta(JInternalFrame frmC, Recaudo objR) {
        this.frmC = (JIFrmConsulta) frmC;
        this.objR = objR;
    }
    
    public ControladorJIConsulta() {
        this.frmC = new JIFrmConsulta();
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
            String []registros = con.leerDatos("vehiculos.txt").split("\n");
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
            agregarArchTabla(frmC.getTblDatosV());
      }
    }
}