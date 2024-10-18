/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Estudiante
 */
public class ControladorMDI implements ActionListener{
    private MDIInicio frmI;
    private Formulario objF;

    public ControladorMDI() {
        this.frmI = new MDIInicio();
        this.objF = new Formulario();
        
    }

    public void agregarVehiculos(JTable tabla ,Formulario formV){
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        plantilla.addRow(formV.registro());
    }
    
    public void iniciarControles(Component [] controles){
        int cantTab=0;
        for (Component control : controles) {
            cantTab++;
            if(control instanceof JTabbedPane){
             cantTab= ((JTabbedPane) control).getTabCount();
                for (int i = 0; i <cantTab ; i++) {
                 Component panel=((JTabbedPane) control).getComponent(i);
                 if(panel instanceof JPanel){
                     //recursividad
                     iniciarControles(((JPanel) panel).getComponents());
                 }   
                }
            }else if (control instanceof JPanel){
            // recursivida
             iniciarControles(((JPanel) control).getComponents());          
            }else if(control instanceof JTextField){
            ((JTextField) control).setText("");
            }else if(control instanceof JTable){
              // se llena un obj aux model para traer el modelo del Jtable  
              DefaultTableModel model=(DefaultTableModel)((JTable) control).getModel();
             // boorrar todas las filas del JTable
                for (int i = ((JTable) control).getRowCount()-1; i >= 0; i++) {
                    model.removeRow(i);
                    //model.fireTableDataChanged();
                }
             
            }   
        }   
    }
    @Override
    public void actionPerformed(ActionEvent e) {
      if(e.getSource().equals(frmI.getMnuNuevoF()) || e.getSource().equals(frmI.getBtnNuevoF())){
          jIfrmVehiculo frmV= new jIfrmVehiculo();
          frmI.getJpdEscritorio().add(frmV);
          frmV.setVisible(true);
                
      }
      if(e.getSource().equals(frmI.getMnuSalir()) || e.getSource().equals(frmI.getBtnSalir())){
         int resp=JOptionPane.showConfirmDialog(frmI, " Desea terminar la ejecucion", " Salir ", JOptionPane.YES_NO_OPTION);
          if (resp == JOptionPane.YES_OPTION) {
              frmI.dispose();
          }
      }
    }
        public void iniciar (){
        frmI.setTitle("Proyecto Vehiculos ");
        frmI.setLocationRelativeTo(null);
        frmI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmI.setVisible(true);
        
        
        frmI.getMnuNuevoF().addActionListener(this);
        frmI.getMnuSalir().addActionListener(this);
        frmI.getBtnNuevoF().addActionListener(this);
        frmI.getBtnSalir().addActionListener(this);
        frmI.getBtnRecaudo().addActionListener(this);
    }
    
    
}
