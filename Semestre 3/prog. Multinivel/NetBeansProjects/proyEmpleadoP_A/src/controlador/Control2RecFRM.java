package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
//import javax.swing.JOptionPane;
import modelo.*;
import vista.*;

public class Control2RecFRM implements ActionListener{
    DecimalFormat df;
    FRMEmpleado1 frmE;
    Recaudo objRec;
    public Control2RecFRM() {
        this.frmE = new FRMEmpleado1();
        this.objRec = new Recaudo();
        this.df = new DecimalFormat("#.00");
        this.frmE.getBtnRegistrar().addActionListener(this);
        this.frmE.getCmbEmpleado().addActionListener(this);
        this.frmE.getLblCantPagosEC().setVisible(false);
        this.frmE.getTxtCantPagosEC().setVisible(false);
        this.frmE.getBtnRegistrar().setEnabled(false);
    }
        
    
    public void iniciar()
    {
        frmE.setTitle("Extracto de empleados");
        frmE.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmE.setVisible(true);
        frmE.setLocationRelativeTo(null);
    }

    public void IngresarDatosEmpleado(Empleado objE)
    {
        objE.setNombre(frmE.getTxtNombre().getText());
        String fechaE[] = frmE.getTxtFecha().getText().split("/");
        objE.setTelefono(frmE.getTxtTelefono().getText());
        objE.setFechaEmpleado(new Fecha(Integer.parseInt(fechaE[0]),
                                                                  Integer.parseInt(fechaE[1]),
                                                                  Integer.parseInt(fechaE[2])));
    }
    
    public void registrarEP(Empleado_Planta objEP)
    {
        DefaultTableModel plantilla = (DefaultTableModel)frmE.getTblRecaudo().getModel();
        int cantE = objRec.getListaEx().size();
        Object[] registroEP = 
        {
            objRec.getListaEx().get(cantE-1).getIdExtracto(),
            objRec.getListaEx().get(cantE-1).getFechaEx(),
            objRec.getListaEx().get(cantE-1).getObjE().getId(),
            objRec.getListaEx().get(cantE-1).getObjE().getNombre(),
            objRec.getListaEx().get(cantE-1).getObjE().getTelefono(),
            objEP.getCargo(),
            df.format(objEP.getSueldo()),
            df.format(objRec.getListaEx().get(cantE-1).getObjE().ValorPago())
        };
        
        plantilla.addRow(registroEP);
        frmE.getTxtTotalValorPago().setText(df.format(objRec.totalRecaudo()));
    }
    
    
    
    public void registrarEC(Empleado_Contratista objEC)
    {
        DefaultTableModel plantilla = (DefaultTableModel)frmE.getTblRecaudo2().getModel();
        int cantE = objRec.getListaEx().size();
        Object[] registroEP = 
        {
            objRec.getListaEx().get(cantE-1).getIdExtracto(),
            objRec.getListaEx().get(cantE-1).getFechaEx(),
            objRec.getListaEx().get(cantE-1).getObjE().getId(),
            objRec.getListaEx().get(cantE-1).getObjE().getNombre(),
            objRec.getListaEx().get(cantE-1).getObjE().getTelefono(),
            df.format(objEC.getValorTotalCont()),
            df.format(objEC.getValorAdelanto()),
            df.format(objEC.getCantidadPago()),
            df.format(objRec.getListaEx().get(cantE-1).getObjE().ValorPago())
        };
        
        plantilla.addRow(registroEP);
        frmE.getTxtTotalValorPagoEC().setText(df.format(objRec.totalRecaudo()));
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource().equals(frmE.getCmbEmpleado()))
        {
            this.frmE.getBtnRegistrar().setEnabled(true);
            switch(frmE.getCmbEmpleado().getSelectedIndex())
            {
                case 0:
                    this.frmE.getLblCargo_ValorPago().setText("Cargo: ");
                    this.frmE.getLblSueldo_ValorAdelanto().setText("Sueldo: ");
                    this.frmE.getLblCantPagosEC().setVisible(false);
                    this.frmE.getTxtCantPagosEC().setVisible(false);
                        break;
                case 1:
                    this.frmE.getLblCargo_ValorPago().setText("Valor del Contrato: ");
                    this.frmE.getLblSueldo_ValorAdelanto().setText("Valor Adelanto: ");
                    this.frmE.getLblCantPagosEC().setVisible(true);
                    this.frmE.getTxtCantPagosEC().setVisible(true);
                        break;                
            }
            
        }if(e.getSource().equals(frmE.getBtnRegistrar()))
        {
            Extracto objEx = new Extracto();
            if(this.frmE.getTxtCantPagosEC().isVisible())
            {
                    Empleado_Contratista objEmC = new Empleado_Contratista();
                    objEmC.setValorTotalCont(Double.parseDouble(frmE.getTxtCargo_ValorC().getText()));
                    objEmC.setValorAdelanto(Double.parseDouble(frmE.getTxtSueldo_valorA().getText()));
                    objEmC.setCantidadPago(Integer.parseInt(frmE.getTxtCantPagosEC().getText()));
                    objEx.setObjE(objEmC);
                    IngresarDatosEmpleado(objEmC);
                    objRec.getListaEx().add(objEx);
                    registrarEC(objEmC);
            }else
            {
                Empleado_Planta objEmP = new Empleado_Planta();
                    objEmP.setCargo(frmE.getTxtCargo_ValorC().getText());
                    objEmP.setSueldo(Double.parseDouble(frmE.getTxtSueldo_valorA().getText()));
                    objEx.setObjE(objEmP);
                    IngresarDatosEmpleado(objEmP);
                    objRec.getListaEx().add(objEx);
                    registrarEP(objEmP);
            }
            
            //frmE.getTxtArea().append(objRec.toString());
            frmE.getTxtCantPagosEC().setText("");
            frmE.getTxtCargo_ValorC().setText("");
            frmE.getTxtFecha().setText("");
            frmE.getTxtNombre().setText("");
            frmE.getTxtSueldo_valorA().setText("");
            frmE.getTxtSueldo_valorA().setText("");
            frmE.getTxtTelefono().setText("");
        }
    }
}
