/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.text.DecimalFormat;
import javax.swing.JFrame;
import modelo.*;
import vista.*;

/**
 *
 * @author Estudiante
 */
public class ControladorFRM implements ActionListener{
    FrmAuto frmA;
    Formulario objF;

    public ControladorFRM() {
        this.frmA = new FrmAuto();
        this.objF = new Formulario();
        
        this.frmA.getBtnRegistrar().addActionListener(this);//agregele el action listener de este gestor de eventos
        
    }

    
    public void iniciar()
    {
        frmA.setTitle("");
        frmA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmA.setVisible(true);
        frmA.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frmA.getBtnRegistrar()))//si el boton registrar que esta en la ventana es igual que la fuente del evento
        {
            objF.getPropietario().setNom(frmA.getTxtNom().getText());
            objF.getPropietario().setEmail("");
            objF.getPropietario().setId(frmA.getTxtId().getText());
            objF.getPropietario().setTel(frmA.getTxtTel().getText());
            
            String fecha[]= frmA.getTxtFN().getText().split("/");
            objF.getPropietario().setfNac(new Fecha(Integer.parseInt(fecha[0]),
                                                        Integer.parseInt(fecha[1]),
                                                        Integer.parseInt(fecha[2])));
        }

        Auto objA = new Auto();
        
        objA.setTipoVehiculo("Carro");
        objA.setPlaca(frmA.getTxtPlaca().getText());
        objA.setMarca(frmA.getTxtMarca().getText());
        objA.setModelo(Integer.parseInt(frmA.getTxtModelo().getText()));
        objA.setValor(Double.parseDouble(frmA.getTxtValor().getText()));
        objF.getListaV().add(objA);//polimorfismo
        
        //append = añadir
        frmA.getTxtArea().append(objF.toString() +
                                    "\nTotal pago: " + objF.valorPago());
    }
}
