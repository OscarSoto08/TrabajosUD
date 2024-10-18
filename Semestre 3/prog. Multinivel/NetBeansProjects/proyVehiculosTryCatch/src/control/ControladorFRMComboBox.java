package control;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelo.*;
import vista.*;

/**
 *
 * @author Estudiante
 */
public class ControladorFRMComboBox implements ActionListener{
    frmVehiculoComboBox frmA;
    
    
    public ControladorFRMComboBox() {
        this.frmA = new frmVehiculoComboBox();
        
        
        this.frmA.getCmbVehiculo().addActionListener(this);
        this.frmA.getBtnAgregar().addActionListener(this);                
        this.frmA.getBtnRegistrar().addActionListener(this);//agregele el action listener de este gestor de eventos
        this.frmA.getBtnRegistrar().setEnabled(false);
        this.frmA.getPnlCil().setVisible(false);
    }

    
    public void iniciar()
    {
        frmA.setTitle("Registro de autos");
        frmA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmA.setVisible(true);
        frmA.setLocationRelativeTo(null);
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
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(frmA.getCmbVehiculo()))
        {
            frmA.getBtnRegistrar().setEnabled(true);
            if(frmA.getCmbVehiculo().getSelectedIndex() == 0)
            {
                frmA.getPnlCil().setVisible(false);
            }
            if(frmA.getCmbVehiculo().getSelectedIndex() == 1)
            {
                frmA.getPnlCil().setVisible(true);
            }
        }
        if(e.getSource().equals(frmA.getBtnRegistrar()))
        {
            
        }
        if(e.getSource().equals(frmA.getBtnAgregar()))//si el boton registrar que esta en la ventana es igual que la fuente del evento
        {
            if(!frmA.getTxtMarca().getText().equals(""))
            {
                Formulario objF = new Formulario();
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
                    switch(frmA.getCmbVehiculo().getSelectedIndex())
                    {
                        case 0:
                            Auto objA = new Auto();

                            objA.setTipoVehiculo("Carro");
                            objA.setPlaca(frmA.getTxtPlaca().getText());
                            objA.setMarca(frmA.getTxtMarca().getText());
                            objA.setModelo(Integer.parseInt(frmA.getTxtModelo().getText()));
                            objA.setValor(Double.parseDouble(frmA.getTxtValor().getText()));
                            objF.getListaV().add(objA);
                            break;
                        case 1:
                            Moto objM = new Moto();
                            objM.setTipoVehiculo("Moto");
                            objM.setPlaca(frmA.getTxtPlaca().getText());
                            objM.setMarca(frmA.getTxtMarca().getText());
                            objM.setModelo(Integer.parseInt(frmA.getTxtModelo().getText()));
                            objM.setValor(Double.parseDouble(frmA.getTxtValor().getText()));
                            objM.setCilindraje(Integer.parseInt(frmA.getTxtCil().getText()));
                            objF.getListaV().add(objM);
                            break;
                    }
                    agregarVehiculo(frmA.getTblDatos(),objF);

                    JTextField[] camposVehiculo = {
                            frmA.getTxtPlaca(), 
                            frmA.getTxtMarca(),
                            frmA.getTxtModelo(), 
                            frmA.getTxtValor(), 
                            frmA.getTxtCil()
                };
                    for (JTextField campo : camposVehiculo) {
                        campo.setText("");
                    }
            }
        }
    }    
}
