/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.awt.event.*;
import javax.swing.*;
import modelo.*;
import vista.*;
/**
 *
 * @author nailu
 */
public class ControladorMDI implements ActionListener{
    MDIinicio frmI;
    Recaudo objR;
    
    public ControladorMDI() {
        this.frmI = new MDIinicio();
    }
    
    public void iniciar()
    {        
        this.frmI.getMnuNuevoF().addActionListener(this);
        this.frmI.getMnuSalir().addActionListener(this);
        this.frmI.getBtnNuevoF().addActionListener(this);
        this.frmI.getBtnRecaudo().addActionListener(this);
        this.frmI.getBtnSalir().addActionListener(this);
        this.frmI.getBtnConsulta().addActionListener(this);
        this.frmI.getMnuConsulta().addActionListener(this);
        
        frmI.setTitle("Registro de Vehiculos: ");
        frmI.setLocationRelativeTo(null);
        frmI.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frmI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmI.setVisible(true);
    }

         
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        if(e.getSource()==frmI.getMnuSalir()||e.getSource()==frmI.getBtnSalir()){
            int resp = JOptionPane.showConfirmDialog(frmI, "Desea terminar la ejecucion?..");
            if(resp==JOptionPane.YES_OPTION){
                frmI.dispose();
            }
        }
        if(e.getSource()==frmI.getMnuNuevoF() || e.getSource()==frmI.getBtnNuevoF()){
            JIFrmVehi frmV = new JIFrmVehi();
            frmI.getEscritorio().add(frmV); 
            ControladorJIFRM controlJI = new ControladorJIFRM(frmV,objR);
            frmV.setVisible(true);
            controlJI.iniciar();
        }
        if(e.getSource().equals(frmI.getBtnConsulta()) || e.getSource().equals(frmI.getMnuConsulta()))
        {
            JIFrmConsulta frmC = new JIFrmConsulta();
            frmI.getEscritorio().add(frmC);
            ControladorJIConsulta controlJIC = new ControladorJIConsulta(frmC, objR);
            controlJIC.iniciar();
        }
    }
}
