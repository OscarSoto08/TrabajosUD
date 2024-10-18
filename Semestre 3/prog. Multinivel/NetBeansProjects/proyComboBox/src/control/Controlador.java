package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import modelo.*;
import vista.*;

public class Controlador implements ActionListener{
    frmVentana frmV;
    Medida objM;
    DecimalFormat df;

    public Controlador() {
        this.frmV = new frmVentana();
        this.objM = new Medida();
        this.df = new DecimalFormat("#0.0000");
        this.frmV.getBtnOpciones().addActionListener(this);
        this.frmV.getBtnEjecutar().addActionListener(this);
    }
    
    public void iniciar()
    {
        frmV.setTitle("");
        frmV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmV.setVisible(true);
        frmV.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frmV.getBtnEjecutar()))
        {
            
            if(!frmV.getTxtMedida().getText().equals(""))
            {
                objM.setValor(Double.parseDouble(frmV.getTxtMedida().getText()));
                frmV.getTxtAreaResp().setText("");
                switch(frmV.getBtnOpciones().getSelectedIndex())
                {
                    case 0:
                        frmV.getTxtAreaResp().append(objM.toString() + "\nEn centímetros: " + df.format(objM.convertirCM()));
                        break;
                    case 1: 
                        frmV.getTxtAreaResp().append(objM.toString() + "\nEn decímetros: " + df.format(objM.convertirDM()));
                        break;
                    case 2:
                        frmV.getTxtAreaResp().append(objM.toString() + "\nEn kilómetros: " + df.format(objM.convertirKM()));
                        break;
                }
            }
        }
    }    

}
