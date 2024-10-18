package control;

import java.awt.Component;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

public class ControladorJIFRM implements ActionListener
{
    JIFrmVehi frmA;
    Formulario objF;
    Recaudo objR;
    
    public ControladorJIFRM() 
    {
        this.objR = new Recaudo();
        this.frmA = new JIFrmVehi();
        this.objF = new Formulario();
        
        this.frmA.getBtnRegistrar().setEnabled(false);
        this.frmA.getPnlCil().setVisible(false);
    }

    public ControladorJIFRM(JInternalFrame form, Recaudo objR) 
    {
        this.frmA = (JIFrmVehi) form;
        this.objF = new Formulario();
        this.objR = objR;
        
        this.frmA.getBtnRegistrar().setEnabled(false);
        this.frmA.getPnlCil().setVisible(false);
    }

    public void iniciar()
    {
        frmA.setTitle("Registro de vehiculos");
        frmA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmA.setLocation(200,200);
        
        SpinnerNumberModel spinModelo = new SpinnerNumberModel();
        Calendar fechaSis = Calendar.getInstance();
        spinModelo.setMaximum(fechaSis.get(Calendar.YEAR));
        spinModelo.setMinimum(1800);
        spinModelo.setStepSize(25);
        spinModelo.setValue(1800);
        this.frmA.getSpinModelo().setModel(spinModelo);
        this.frmA.getCmbVehiculo().addActionListener(this); 
        this.frmA.getBtnAgregar().addActionListener(this);                
        this.frmA.getBtnRegistrar().addActionListener(this);
    }
    
    public void iniciarControles(Component[] controles) 
    {
        for (Component control : controles) {
            if(control instanceof JTabbedPane)
            {
                int cantTab = ((JTabbedPane) control).getTabCount();
                for (int i = 0; i < cantTab; i++) {
                    Component panel = ((JTabbedPane) control).getComponent(i);
                    iniciarControles(((JPanel) panel).getComponents());
                }
            }
            else if(control instanceof JPanel)           
                iniciarControles(((JPanel) control).getComponents());    
            else if(control instanceof JTextField)
            {
                ((JTextField) control).setText("");
            }
        }
    }
    
    public void iniciarTabla(JTable control) 
    {
        DefaultTableModel model = (DefaultTableModel) control.getModel();
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    public void agregarVehiculo(Formulario formV,JTable tabla)
    {
        
        DefaultTableModel plantilla = (DefaultTableModel) tabla.getModel();
        
        plantilla.addRow(formV.registro());
    }
 
    @Override
    public void actionPerformed(ActionEvent e) 
    {
            if(e.getSource().equals(frmA.getCmbVehiculo()))
            {
                frmA.getBtnRegistrar().setEnabled(true);
                switch(frmA.getCmbVehiculo().getSelectedIndex())
                {
                    case 0 -> frmA.getPnlCil().setVisible(false);
                    case 1 -> frmA.getPnlCil().setVisible(true);
                }
            }
            if(e.getSource().equals(frmA.getBtnRegistrar()))
            {
                ArchPdf arch = new ArchPdf();
                arch.crear_PDF(objF);
                objR.getListaF().add(objF);
                iniciarControles(frmA.getContentPane().getComponents());
                iniciarTabla(frmA.getTblDatos());
            }
            if(e.getSource().equals(frmA.getBtnAgregar()))
            {
                try{
                    if(objF.getPropietario().getId().equals(""))
                    {
                        objF.getPropietario().setNom(frmA.getTxtNombre().getText());
                        objF.getPropietario().setId(frmA.getTxtID().getText());
                        objF.getPropietario().setTel(frmA.getTxtTel().getText());

                        //String fecha[]= frmA.getTxtFN().getText().split("/");
                        
                        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyy");
                        String fecha[]= df.format(frmA.getJdcFN().getDate()).split("/");
                        objF.getPropietario().setfNac(new Fecha(Integer.parseInt(fecha[0]),
                                                                                              Integer.parseInt(fecha[1]),
                                                                                              Integer.parseInt(fecha[2])));
                        
                    }
                    switch(frmA.getCmbVehiculo().getSelectedIndex())
                    {
                        case 0 -> 
                        {
                            Auto objA = new Auto();
                            objA.setTipoVehiculo("Carro");
                            objA.setPlaca(frmA.getTxtPlaca().getText());
                            objA.setMarca(frmA.getTxtMarca().getText());
                            objA.setModelo(Integer.parseInt(frmA.getSpinModelo().getValue().toString()));
                            objA.setValor(Double.parseDouble(frmA.getTxtValor().getText()));
                            objF.getListaV().add(objA);
                        }
                        case 1 -> 
                        {
                            Moto objM = new Moto();
                            objM.setTipoVehiculo("Moto");
                            objM.setPlaca(frmA.getTxtPlaca().getText());
                            objM.setMarca(frmA.getTxtMarca().getText());
                            objM.setModelo(Integer.parseInt(frmA.getSpinModelo().getValue().toString()));
                            
                            objM.setValor(Double.parseDouble(frmA.getTxtValor().getText()));
                            objM.setCilindraje((int)Integer.parseInt(frmA.getTxtCil().getText()));
                            objF.getListaV().add(objM);
                        }
                    }
                    
                    agregarVehiculo(objF, frmA.getTblDatos());
                    JOptionPane.showMessageDialog(frmA, "Datos agregados con exito!!","Atención",JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(frmA,this.objF.toString(), "Datos", JOptionPane.OK_OPTION);
                    iniciarControles(this.frmA.getPnlVehiculo().getComponents());
                }catch(NumberFormatException | FormatoEntradaException exc){
                    String[] valErr = exc.toString().split(":");
                    JOptionPane.showMessageDialog(frmA,"Error en el dato: " + valErr[2] + "\n Ingrese un valor númerico");    
            }
        }    
    }
} 

