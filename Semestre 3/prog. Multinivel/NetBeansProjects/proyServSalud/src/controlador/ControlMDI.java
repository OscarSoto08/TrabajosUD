package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import vista.frmJIVentanaCB;
import vista.frmPrincipal;

public class ControlMDI implements ActionListener{
    frmPrincipal frmI;

    public ControlMDI() {
        this.frmI = new frmPrincipal();   
    }
    
    public void iniciar(){
        this.frmI.getBtnConsulta().addActionListener(this);
        this.frmI.getBtnNuevoServicio().addActionListener(this);
        this.frmI.getBtnSalir().addActionListener(this);
        this.frmI.getMnuConsulta().addActionListener(this);
        this.frmI.getMnuNuevoS().addActionListener(this);
        this.frmI.getMnuSalida().addActionListener(this);
        
        this.frmI.setTitle("Servicios de salud");
        this.frmI.setLocationRelativeTo(null);
        this.frmI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.frmI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frmI.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frmI.getBtnConsulta()) || e.getSource().equals(frmI.getMnuConsulta())){
            
        }
        if(e.getSource().equals(frmI.getBtnNuevoServicio()) || e.getSource().equals(frmI.getMnuNuevoS())){
            frmJIVentanaCB frmV = new frmJIVentanaCB();
            frmI.getEscritorio().add(frmV);
            ControlJIFrm objControl = new ControlJIFrm(frmV);
            objControl.iniciar();
        }
        if(e.getSource().equals(frmI.getBtnSalir()) || e.getSource().equals(frmI.getMnuSalida())){
            
        }
    }
}
