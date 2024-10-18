/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.awt.event.*;
import javax.swing.*;
import vista.*;
/**
 *
 * @author nailu
 */
public class ControladorMDI implements ActionListener{
    MDIinicio frmI;

    public ControladorMDI() {
        this.frmI = new MDIinicio();
    }
    
    public void iniciar(){
        this.frmI.getMnuNuevoF().addActionListener(this);
        this.frmI.getMnuSalir().addActionListener(this);
        this.frmI.getBtnNuevoF().addActionListener(this);
        this.frmI.getBtnRecaudo().addActionListener(this);
        this.frmI.getBtnSalir().addActionListener(this);
        
        frmI.setTitle("Registro de Vehiculos: ");
        frmI.setLocationRelativeTo(null);
        frmI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmI.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==frmI.getMnuSalir() || e.getSource()==frmI.getBtnSalir()){
            int resp = JOptionPane.showConfirmDialog(frmI, "Desea terminar la ejecucion?..");
            if(resp==JOptionPane.YES_OPTION){
                frmI.dispose();
            }
        }
        if(e.getSource()==frmI.getMnuNuevoF() || e.getSource() == frmI.getBtnNuevoF()){
            JIFrmVehiculo frmV = new JIFrmVehiculo();
            frmI.getEscritorio().add(frmV); 
            ControladorJIFRM controlJI = new ControladorJIFRM(frmV);
            controlJI.iniciar();
        }
    }
}
