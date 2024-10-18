/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.awt.*;
import java.text.DecimalFormat;
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
public class ControladorFrm implements ActionListener{
    private frmVehiculo frmA;
    private Formulario objF;

    public ControladorFrm() {
        this.frmA = new frmVehiculo();
        this.objF = new Formulario();
        frmA.getBtnRegistrar().addActionListener(this);
        frmA.getCmbTipoV().addActionListener(this);
        frmA.getBtnAgregarV().addActionListener(this);
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
        DecimalFormat df= new DecimalFormat("#,###.00");
        if(e.getSource().equals(frmA.getCmbTipoV())){
            switch (frmA.getCmbTipoV().getSelectedIndex()) {
                case 0:
                    frmA.getPnlCil().setVisible(false);
                    break;
                 case 1:
                    frmA.getPnlCil().setVisible(true);
                    break;
            }
        
        }
        if(e.getSource().equals(frmA.getBtnAgregarV())){
            if(objF.getPropietario().getId()==""){
                
                objF.getPropietario().setId(frmA.getTxtId().getText());
                objF.getPropietario().setNom(frmA.getTxtNom().getText());
         
                String fecha[]=frmA.getTxtFnac().getText().split("/");
                objF.getPropietario().setfN(new Fecha(Integer.parseInt(fecha[0]),
                 Integer.parseInt(fecha[1]),
                 Integer.parseInt(fecha[2])));
            }
            
            switch (frmA.getCmbTipoV().getSelectedIndex()) {
                case 0:
                    Auto objA=new Auto();   
                objA.setPlaca(frmA.getTxtPlaca().getText());
                objA.setMarca(frmA.getTxtMarca().getText());
                objA.setModelo(Integer.parseInt(frmA.getTxtModel().getText()));
                objA.setValor(Double.parseDouble(frmA.getTxtValor().getText()));
                objF.getListaV().add(objA);
                
                break;
                 case 1:
                 Moto objM =new Moto();
                        // datos moto
                         
                        objM.setPlaca(frmA.getTxtPlaca().getText());
                        objM.setMarca(frmA.getTxtMarca().getText());
                        objM.setModelo(Integer.parseInt(frmA.getTxtModel().getText()));
                        objM.setValor(Double.parseDouble(frmA.getTxtValor().getText()));
                        objM.setCilindraje(Integer.parseInt(frmA.getTxtCilindraje().getText()));
                        objF.getListaV().add(objM);
                break;
            }
            JOptionPane.showMessageDialog(frmA, "Datos Registrado Del Vehiculo "+objF.toString()+
                                            "\n Valor Impuesto: "+df.format(objF.valorPago()));
            frmA.getTxtId().setEnabled(false);
            frmA.getTxtNom().setEnabled(false);
            frmA.getTxtTel().setEnabled(false);
            frmA.getTxtFnac().setEnabled(false);
            agregarVehiculos(frmA.getTblDatos(),objF);
        }
        if(e.getSource().equals(frmA.getBtnRegistrar())){
            frmA.getTxtId().setEnabled(true);
            frmA.getTxtNom().setEnabled(true);
            frmA.getTxtTel().setEnabled(true);
            frmA.getTxtFnac().setEnabled(true);
            iniciarControles(frmA.getContentPane().getComponents());
            
            
        }
    }
        public void iniciar (){
        frmA.setTitle("Proyecto Vehiculos ");
        frmA.setLocationRelativeTo(null);
        frmA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmA.getPnlCil().setVisible(false);
        frmA.setVisible(true);
        
    }
    
    
}
