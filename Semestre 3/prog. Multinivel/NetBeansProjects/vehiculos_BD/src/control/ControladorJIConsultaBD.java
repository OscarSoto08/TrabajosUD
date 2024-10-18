package control;

import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class ControladorJIConsultaBD implements ActionListener{
    JIFrmConsultaBD frmC;
    Recaudo objR;
    
    public ControladorJIConsultaBD(JInternalFrame frmC, Recaudo objR) {
        this.frmC = (JIFrmConsultaBD) frmC;
        this.objR = objR;
    }
    
    public ControladorJIConsultaBD() {
        this.frmC = new JIFrmConsultaBD();
    }
    
    public void iniciar()
    {
        this.frmC.getBtnBuscar().addActionListener(this);
        BDTabla();
        this.frmC.setTitle("Consultas BD");
        this.frmC.setLocation(200,200);
        this.frmC.setVisible(true);
    }

    public void BDTabla(){
        FacturaDAO objF_BD = new FacturaDAO();
        this.frmC.getTblDatosV().setModel(objF_BD.consultar());
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