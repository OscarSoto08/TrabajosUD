package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class Controlador_MDI implements ActionListener{
    vista_MDI ventanaMDI;
    Recaudo recaudo;

    public Controlador_MDI(vista_MDI ventanaMDI, Recaudo recaudo) {
        this.ventanaMDI = ventanaMDI;
        this.recaudo = recaudo;
    }
    
    public Controlador_MDI() {
        this.ventanaMDI = new vista_MDI();
        this.recaudo = new Recaudo();
    }

     public void iniciar(){        

        this.ventanaMDI.getBtnConsulta().addActionListener(this);
        this.ventanaMDI.getBtnMembresia().addActionListener(this);
        this.ventanaMDI.getBtnSalir().addActionListener(this);
        this.ventanaMDI.getBtnRecaudo().addActionListener(this);
        this.ventanaMDI.getBtnConsultaBD().addActionListener(this);

        this.ventanaMDI.getMenu_Consulta().addActionListener(this);
        this.ventanaMDI.getMenu_Membresia().addActionListener(this);
        this.ventanaMDI.getMenu_Salir().addActionListener(this);
        this.ventanaMDI.getMenu_Recaudo().addActionListener(this);   
        this.ventanaMDI.getMenu_ConsultaBD().addActionListener(this);
        
        ventanaMDI.setTitle("REGISTRO CLIENTES GIMNASIO: ");
        ventanaMDI.setLocationRelativeTo(null);
        ventanaMDI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        ventanaMDI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaMDI.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ventanaMDI.getMenu_Salir()||e.getSource()==ventanaMDI.getBtnSalir()){
            int resp = JOptionPane.showConfirmDialog(ventanaMDI, "¿Desea terminar la ejecución?", "Salida", JOptionPane.CLOSED_OPTION);
            if(resp==JOptionPane.YES_OPTION){
                ventanaMDI.dispose();
            }
        }
        if(e.getSource()==ventanaMDI.getMenu_Membresia()|| e.getSource()==ventanaMDI.getBtnMembresia()){
            vista_Membresia ventana_Membresia = new vista_Membresia();
            ventanaMDI.getEscritorio().add(ventana_Membresia); 
            Controlador_Membresia control_Memb= new Controlador_Membresia(ventana_Membresia);
            control_Memb.iniciar();
        }
        if(e.getSource().equals(ventanaMDI.getBtnConsulta()) || e.getSource().equals(ventanaMDI.getMenu_Consulta()))
        {
            vista_Consulta ventana_Consulta = new vista_Consulta();
            ventanaMDI.getEscritorio().add(ventana_Consulta);
            ventana_Consulta.setVisible(true);
            Controlador_Consulta consulta= new Controlador_Consulta();
            consulta.iniciar();
        }
        if(e.getSource().equals(ventanaMDI.getBtnConsultaBD()) || e.getSource().equals(ventanaMDI.getMenu_ConsultaBD()))
        {
            vista_ConsultaBD ventana_ConsultaBD = new vista_ConsultaBD();
            ventanaMDI.getEscritorio().add(ventana_ConsultaBD);
            ventana_ConsultaBD.setVisible(true);
            Controlador_ConsultaBD controlBD= new Controlador_ConsultaBD();
            controlBD.iniciar();
        }
    }
}
