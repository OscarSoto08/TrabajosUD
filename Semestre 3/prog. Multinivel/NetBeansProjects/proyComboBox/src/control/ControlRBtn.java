package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import modelo.Medida;
import vista.frmVentanaRadioButton;

public class ControlRBtn implements ActionListener{
    frmVentanaRadioButton frmV;
    Medida objM;
    DecimalFormat df;
    public ControlRBtn() {
        this.frmV = new frmVentanaRadioButton();
        this.objM = new Medida();
        this.df = new DecimalFormat("#0.0000");
        
        this.frmV.getBtnGrupo().add(this.frmV.getRbtnCms());
        this.frmV.getBtnGrupo().add(this.frmV.getRdbtnDms());
        this.frmV.getBtnGrupo().add(this.frmV.getRdbtnKms());
        this.frmV.getBtnConvertir().addActionListener(this);
    }
    
    public void iniciar()
    {
        this.frmV.setTitle("Conversión de unidades (Longitud)");
        this.frmV.setVisible(true);
        this.frmV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frmV.setLocationRelativeTo(null);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource().equals(frmV.getBtnConvertir()))
        {
            objM.setValor(Double.parseDouble(frmV.getTxtMedida().getText()));
            if(frmV.getRbtnCms().isSelected())
            {
                frmV.getTxtArea().setText("");
                frmV.getTxtArea().append("El valor de la medida en (CM) es: "+ df.format(objM.convertirCM()) + " cm");
            }
            else if(frmV.getRdbtnDms().isSelected())
            {
                frmV.getTxtArea().setText("");
                frmV.getTxtArea().append("El valor de la medida en (DM) es: "+ df.format(objM.convertirDM()) + " dm");
            }
            else if(frmV.getRdbtnKms().isSelected())
            {
                frmV.getTxtArea().setText("");
                frmV.getTxtArea().append("El valor de la medida en (KM) es: "+ df.format(objM.convertirKM()) + " km");
            }
        }
    }
}
