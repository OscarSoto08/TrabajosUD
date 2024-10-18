/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import Modelo.Agenda;
import Modelo.Conexion;
import Modelo.Persona;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author FAMILIA
 */
public class Controlador implements ActionListener{

    Agenda agenda;
    Ventana frmV;
    Conexion con;

    public Controlador(Agenda agenda, Ventana frmV, Conexion con) {
        this.agenda = agenda;
        this.frmV = frmV;
        this.con = con;
    }
    
    public Controlador() throws IOException{
        this.agenda = new Agenda();
        this.frmV = new Ventana();
        this.con = new Conexion();
    }
    
    public void iniciar()
    {
        frmV.getBtnAgregar().addActionListener(this);
        frmV.getBtnArch().addActionListener(this);
        
        frmV.setTitle("Agenda Contactos con Archivos");
        frmV.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(frmV.getBtnAgregar()))
        {
            try
            {
                Persona contacto = new Persona
                        (
                           frmV.getTxtNombre().getText(),
                           frmV.getTxtTel().getText(),
                           frmV.getTxtEmail().getText()
                        );
                agenda.getContactos().add(contacto);
                JOptionPane.showMessageDialog(frmV, "Datos registrados..\n" + contacto.toString());
                iniciarControles();
            }catch(IOException ex)
            {
                JOptionPane.showMessageDialog(frmV, "Error al abrir el archivo");
            }
        }
    }
    
}
