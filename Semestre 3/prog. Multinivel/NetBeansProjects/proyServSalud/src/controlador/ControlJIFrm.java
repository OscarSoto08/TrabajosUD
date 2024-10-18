/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.awt.event.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import modelo.*;
import vista.*;

public class ControlJIFrm implements ActionListener{
    Factura objF;
    frmJIVentanaCB frmV;

    public ControlJIFrm() {
        this.objF = new Factura();
        this.frmV = new frmJIVentanaCB();
    } 
    
    public ControlJIFrm(frmJIVentanaCB frmV) {
        this.objF = new Factura();
        this.frmV = frmV;
    } 
    
    public void iniciar()
    {
        this.frmV.getCmbServicio().addActionListener(this);
        this.frmV.getBtnRegistrar().addActionListener(this);
        this.frmV.getCmbConsultaM().addActionListener(this);
        this.frmV.getCmbExamen().addActionListener(this);
        this.frmV.getCmbHosp().addActionListener(this);
        
        SpinnerNumberModel spin = new SpinnerNumberModel();
        spin.setMaximum(200);
        spin.setMinimum(1);
        spin.setValue(1);
        spin.setStepSize(1);
        
        this.frmV.getSpinnerDias().setModel(spin);
        this.frmV.getBtnRegistrar().setEnabled(false);
        this.frmV.getPnlConsultaM().setVisible(false);
        this.frmV.getPnlExamen().setVisible(false);
        this.frmV.getPnlHospitalizacion().setVisible(false);
        
        frmV.setTitle("Servicios de salud");
        frmV.setVisible(true);
        frmV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmV.setLocation(0,0);
    }
    
    public void RegistrarTbl()
    {
        //INVOCAR METODO DEL FRM
    }
    
    public void limpiarTxt()
    {
        //Metodo Lindo
    }
    
    public void leerDatos()
    {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String[] fechaNac = df.format(frmV.getDateFechaNac().getDate()).split("/");
        objF.getObjP().setFechaNac(new Fecha(Integer.parseInt(fechaNac[0]),Integer.parseInt(fechaNac[1]), Integer.parseInt(fechaNac[2])));
        objF.getObjP().setNombre(frmV.getTxtNombre().getText());
        objF.getObjP().setTelefono(frmV.getTxtTelefono().getText());
        objF.getObjS().setDescripcion(frmV.getTxtDescripcion().getText());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frmV.getCmbServicio()))
        {
            frmV.getBtnRegistrar().setEnabled(true);
            switch(frmV.getCmbServicio().getSelectedIndex())
            {
                case 0 -> {
                    this.frmV.getPnlExamen().setVisible(true);
                    this.frmV.getPnlConsultaM().setVisible(false);
                    this.frmV.getPnlHospitalizacion().setVisible(false);
                }
                case 1 -> {
                    this.frmV.getPnlExamen().setVisible(false);
                    this.frmV.getPnlConsultaM().setVisible(true);
                    this.frmV.getPnlHospitalizacion().setVisible(false);
                }
                case 2-> {
                    this.frmV.getPnlExamen().setVisible(false);
                    this.frmV.getPnlConsultaM().setVisible(false);
                    this.frmV.getPnlHospitalizacion().setVisible(true);
                }
            }
        }
        if(e.getSource().equals(frmV.getBtnRegistrar()))
        {
            leerDatos();
            
            if(frmV.getPnlExamen().isVisible()){
                Examen objS = new Examen();
                objS.setCategoria((char)(frmV.getCmbExamen().getSelectedItem()));
                objS.setValor(objS.valorPago());
                this.objF.setObjS(objS);
            }
            if(frmV.getPnlConsultaM().isVisible()){
                Consulta objS = new Consulta();
                objS.setTipoConsuta((String)(frmV.getCmbConsultaM().getSelectedItem()));
                objS.setValor(objS.valorPago());
                this.objF.setObjS(objS);
            }
            if(frmV.getPnlHospitalizacion().isVisible()){
                Hospitalizacion objS = new Hospitalizacion();
                objS.setDiasHosptalizacion((int)(frmV.getCmbConsultaM().getSelectedItem()));
                objS.setValor(objS.valorPago());
                this.objF.setObjS(objS);
            }
            RegistrarTbl();
            limpiarTxt();
        }
    }
}
