/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.*;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class Control implements ActionListener{
    Conversion_Unidades objCU;
    Persona objP;
    MDIInicio frmI;
    FrmIMC frmIMC;
    FrmRegistro frmReg;
    
    public Control() {
        frmI = new MDIInicio();
        frmIMC = new FrmIMC();
        objCU = new Conversion_Unidades();
        objP = new Persona();
        frmReg = new FrmRegistro();
        
        SpinnerNumberModel spinTxtPeso = new SpinnerNumberModel();
        spinTxtPeso.setMaximum(530);
        spinTxtPeso.setMinimum(0);
        spinTxtPeso.setStepSize(10);
        frmIMC.getSpinPeso().setModel(spinTxtPeso);
        
        SpinnerNumberModel spinTxtAltura = new SpinnerNumberModel();
        spinTxtAltura.setMaximum(215);
        spinTxtAltura.setMinimum(0);
        spinTxtAltura.setStepSize(15);
        frmIMC.getSpinEstatura().setModel(spinTxtAltura);
    }
    

    public void iniciar()
    {
        frmI.getBtnBMI().addActionListener(this);
        frmI.getOpcRegistros().addActionListener(this);
        frmI.getOpcSalir().addActionListener(this);
        frmI.getOpcBMI().addActionListener(this);
        frmIMC.getBtnRegistrar().addActionListener(this);
        
        frmI.setTitle("IMC");
        frmI.setVisible(true);
        frmI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmI.setLocationRelativeTo(null);
    }
    
    
    public void agregarDatosTabla()
    {
        DecimalFormat df = new DecimalFormat("#0.00");
        DefaultTableModel plantilla = (DefaultTableModel) frmReg.getTblRegistro().getModel();
        Object[] datos = 
        {
            objP.getId(),
            objP.getNombre(),
            df.format(objP.getIMC()),
            objP.getEstado()
        };
        plantilla.addRow(datos);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource().equals(frmI.getBtnBMI()) || e.getSource().equals(frmI.getOpcBMI()))
       {
           if(frmIMC.isVisible())
               frmI.getEscritorio().remove(frmIMC);
           if(frmReg.isVisible())
               frmI.getEscritorio().remove(frmReg);
           
           frmI.getEscritorio().add(frmIMC);
           frmIMC.setVisible(true);
       }
       if(e.getSource().equals(frmI.getOpcRegistros()))
       {
           if(frmIMC.isVisible())
               frmI.getEscritorio().remove(frmIMC);
           if(frmReg.isVisible())
               frmI.getEscritorio().remove(frmReg);
           
           frmI.getEscritorio().add(frmReg);
           frmReg.setVisible(true);
       }
       if(e.getSource().equals(frmI.getOpcSalir()))
       {
           int salir = JOptionPane.showConfirmDialog(frmI, "¿Desea Salir?","Salir",JOptionPane.YES_NO_OPTION);
           if(salir == JOptionPane.YES_OPTION)
               frmI.dispose();
       }
       if(e.getSource().equals(frmIMC.getBtnRegistrar()))
       {
           DecimalFormat df = new DecimalFormat("#0.00");
           
            objP.setNombre(frmIMC.getTxtNombre().getText());
            objCU.setValorCM(((Integer) frmIMC.getSpinEstatura().getValue()).doubleValue());
            objP.setAltura(objCU.convertirValor());
            objP.setPeso(((Integer) frmIMC.getSpinPeso().getValue()).doubleValue());
            double IMC = objP.calcularIMC();
            objP.setIMC(IMC);
            if(IMC < 18.5)
                
                objP.setEstado("Bajo Peso");
            else if(IMC > 18.5 && IMC < 24.9)
                objP.setEstado("Peso normal");
            else if(IMC > 24.9 && IMC < 29.9)
                objP.setEstado("Sobrepeso");
            else if(IMC > 30)
                objP.setEstado("Obesidad");
            
            JOptionPane.showMessageDialog(frmIMC, "Su IMC es: " + df.format(IMC), "Atencion", JOptionPane.INFORMATION_MESSAGE);
            agregarDatosTabla();
            frmIMC.getTxtNombre().setText("");
            frmIMC.getSpinEstatura().setValue(0);
            frmIMC.getSpinPeso().setValue(0);
       }
    }
    
}
