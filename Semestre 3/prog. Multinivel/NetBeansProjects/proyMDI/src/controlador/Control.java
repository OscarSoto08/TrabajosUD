/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

/**
 *
 * @author FAMILIA
 */
public class Control implements ActionListener{
    frmPrincipal frmInicio;
    frmPotencia frmPotencia;
    frmSuma frmSuma;
    frmResta frmResta;
    Numero objNum;

    public Control() {
        frmInicio = new frmPrincipal();
        frmPotencia = new frmPotencia();
        frmSuma = new frmSuma();
        frmResta = new frmResta();
        objNum = new Numero();
        
       
    }
    
    public void iniciar()
    {
        frmInicio.setTitle("Ejercicio MDI");
        frmSuma.setTitle("Suma");
        frmPotencia.setTitle("Potencia");
        frmResta.setTitle("Resta");
        frmInicio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmInicio.setLocationRelativeTo(null);
        frmInicio.setVisible(true);
        
        frmInicio.getOpcPotencia().addActionListener(this);
        frmInicio.getOpcSuma().addActionListener(this);
        frmInicio.getOpcResta().addActionListener(this);
        frmInicio.getOpcSalir().addActionListener(this);
        frmSuma.getBtnSuma().addActionListener(this);
        frmPotencia.getBtnPotencia().addActionListener(this);
        frmResta.getBtnResta().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(frmInicio.getOpcSalir()))
        {
            int n  = JOptionPane.showConfirmDialog(frmInicio,"¿Desea salir?","Salir",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if(n == JOptionPane.YES_OPTION)
                frmInicio.dispose();
        }
        
        if(e.getSource().equals(frmInicio.getOpcSuma()))
        {
            frmInicio.getEscritorio().add(frmSuma);
            frmSuma.setVisible(true);
            if(frmPotencia.isVisible())
            {
                frmPotencia.setVisible(false);
                frmInicio.getEscritorio().remove(frmPotencia);
            }
            if(frmResta.isVisible())
            {
                frmResta.setVisible(false);
                frmInicio.getEscritorio().remove(frmResta);
            }
        }
        
        if(e.getSource().equals(frmInicio.getOpcPotencia()))
        {
            frmInicio.getEscritorio().add(frmPotencia);
            frmPotencia.setVisible(true);
            if(frmSuma.isVisible())
            {
                frmSuma.setVisible(false);
                frmInicio.getEscritorio().remove(frmSuma);
            }            
            if(frmResta.isVisible())
            {
                frmResta.setVisible(false);
                frmInicio.getEscritorio().remove(frmResta);
            }
        }
        
        if(e.getSource().equals(frmInicio.getOpcResta()))
        {
            frmInicio.getEscritorio().add(frmResta);
            frmResta.setVisible(true);
            if(frmPotencia.isVisible())
            {
                frmPotencia.setVisible(false);
                frmInicio.getEscritorio().remove(frmPotencia);
            }
            if(frmSuma.isVisible())
            {
                frmSuma.setVisible(false);
                frmInicio.getEscritorio().remove(frmSuma);
            }
        }
        
        if(e.getSource().equals(frmPotencia.getBtnPotencia()))
        {
            NumberFormat nf = NumberFormat.getInstance();
            objNum.setValor(Integer.parseInt(frmPotencia.getTxtBase().getText()));
            double resultado = (double) objNum.Potencia(Integer.parseInt(frmPotencia.getTxtExp().getText()));
            JOptionPane.showMessageDialog(frmPotencia, "El resultado de su operación es: "+ nf.format(resultado), "Resultado potencia", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(e.getSource().equals(frmSuma.getBtnSuma()))
        {
            NumberFormat nf = NumberFormat.getInstance();
            objNum.setValor(Integer.parseInt(frmSuma.getTxtNum1().getText()));
            double resultado = (double) objNum.Suma(Integer.parseInt(frmSuma.getTxtNum2().getText()));
            JOptionPane.showMessageDialog(frmSuma, "El resultado de su suma es: "+ nf.format(resultado),"Resultado suma", JOptionPane.INFORMATION_MESSAGE);
        }
        
        if(e.getSource().equals(frmResta.getBtnResta()))
        {
            NumberFormat nf = NumberFormat.getInstance();
            objNum.setValor(Integer.parseInt(frmResta.getTxtNum1().getText()));
            double resultado = (double) objNum.resta(Integer.parseInt(frmResta.getTxtNum2().getText()));
            JOptionPane.showMessageDialog(frmResta, "El resultado de su resta es: "+ nf.format(resultado), "Resta", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
