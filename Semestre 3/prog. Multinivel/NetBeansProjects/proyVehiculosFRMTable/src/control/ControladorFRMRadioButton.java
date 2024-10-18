/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.Component;
import java.awt.Container;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 *
 * @author Estudiante
 */
public class ControladorFRMRadioButton implements ActionListener
{
    frmVehiculoRadioButon frmA;
    Formulario objF;
    
    public ControladorFRMRadioButton() 
    {
        this.frmA = new frmVehiculoRadioButon();
        this.objF = new Formulario();
        this.frmA.getBtngTipoV().add(this.frmA.getRdbAuto());
        this.frmA.getBtngTipoV().add(this.frmA.getRdbMoto());
        
        this.frmA.getBtnRegistrar1().setEnabled(false);
        this.frmA.getPnlCil().setVisible(false);
    }

    
    public void iniciar()
    {
        frmA.setTitle("Registro de vehiculos");
        frmA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmA.setVisible(true);
        frmA.setLocationRelativeTo(null);
        
        this.frmA.getRdbAuto().addActionListener(this);
        this.frmA.getRdbMoto().addActionListener(this);
        this.frmA.getBtnAgregar().addActionListener(this);                
        this.frmA.getBtnRegistrar1().addActionListener(this);//agregele el action listener de este gestor de eventos
    }
    
    public void agregarVehiculo(JTable tabla, Formulario formV)
    {
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
                
                //Cast entre tipos de datos
                /*  
                    double d = 12.5;
                    int i = 0;
                    i = (int)d;
                */
        plantilla.addRow(formV.registro());
    }
    
    public static void iniciarControles(Component[] controles) 
    {
        for (Component control : controles) {
            
            if(control instanceof JPanel)
            {
                iniciarControles(((JPanel) control).getComponents());
            }
            else if(control instanceof JTabbedPane)
            {
                int cantTab = ((JTabbedPane) control).getTabCount();
                for (int i = 0; i < cantTab; i++) {
                    Component panel = ((JTabbedPane) control).getComponent(i);
                    iniciarControles(((JPanel) panel).getComponents());
                }
            }
            else if(control instanceof JTextField)
            {
                ((JTextField) control).setText("");
            }
            else if (control instanceof JTable) {
                DefaultTableModel model = (DefaultTableModel) ((JTable) control).getModel();
                int rowCount = model.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    model.removeRow(i);
                }
            }else if (control instanceof Container) {
                iniciarControles(((Container) control).getComponents());
            }
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() instanceof JRadioButton)
        {
            frmA.getBtnRegistrar1().setEnabled(true);
            if(frmA.getRdbAuto().isSelected())
            {
                frmA.getPnlCil().setVisible(false);
            }else if(frmA.getRdbMoto().isSelected())
            {
                frmA.getPnlCil().setVisible(true);
            }
        }
        if(e.getSource().equals(frmA.getBtnRegistrar1()))
        {
            iniciarControles(frmA.getContentPane().getComponents());
        }
        if(e.getSource().equals(frmA.getBtnAgregar()))//si el boton registrar que esta en la ventana es igual que la fuente del evento
        {
            if(objF.getPropietario().getId().equals(""))
            {
                objF.getPropietario().setNom(frmA.getTxtNom().getText());
                objF.getPropietario().setId(frmA.getTxtId().getText());
                objF.getPropietario().setTel(frmA.getTxtTel().getText());

                String fecha[]= frmA.getTxtFN().getText().split("/");
                objF.getPropietario().setfNac(new Fecha(Integer.parseInt(fecha[0]),
                                                                                      Integer.parseInt(fecha[1]),
                                                                                      Integer.parseInt(fecha[2])));
            }
            
            if(frmA.getRdbAuto().isSelected())
            {
                Auto objA = new Auto();

                objA.setTipoVehiculo("Carro");
                objA.setPlaca(frmA.getTxtPlaca().getText());
                objA.setMarca(frmA.getTxtMarca().getText());
                objA.setModelo(Integer.parseInt(frmA.getTxtModelo().getText()));
                objA.setValor(Double.parseDouble(frmA.getTxtValor().getText()));
                objF.getListaV().add(objA);//polimorfismo
                //append = añadir
                //int cant = objF.getListaV().size();
//                frmA.getTxtArea().append(objF.getListaV().get(cant-1).toString() +
//                                            "\nTotal pago: " + df.format(objF.valorPago()));

            }
            else if(frmA.getRdbMoto().isSelected())
            {
                Moto objM = new Moto();
                objM.setTipoVehiculo("Moto");
                objM.setPlaca(frmA.getTxtPlaca().getText());
                objM.setMarca(frmA.getTxtMarca().getText());
                objM.setModelo(Integer.parseInt(frmA.getTxtModelo().getText()));
                objM.setValor(Double.parseDouble(frmA.getTxtValor().getText()));
                objM.setCilindraje(Integer.parseInt(frmA.getTxtCil().getText()));
                objF.getListaV().add(objM);//polimorfismo
                //append = añadir

                //int cant = objF.getListaV().size();
//                frmA.getTxtArea().append(objF.getListaV().get(cant-1).toString() +
//                                            "\nTotal pago: " + df.format(objF.valorPago()));
            }

             agregarVehiculo(frmA.getTblDatos(),objF);
//                    JTextField[] camposVehiculo = {frmA.getTxtPlaca(), frmA.getTxtMarca(), frmA.getTxtModelo(), frmA.getTxtValor(), frmA.getTxtCil()};
//                    for (JTextField campo : camposVehiculo) {
//                        campo.setText("");
//                    }
        }
    }    
}
