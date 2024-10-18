/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import javax.swing.JOptionPane;

public class EntradaDatos {
    private String titulo;

    public EntradaDatos() {
        this.titulo = "";
    }

    public EntradaDatos(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String leerTxt(String msg)
    {
        return JOptionPane.showInputDialog(null,msg,titulo,JOptionPane.QUESTION_MESSAGE);
    }
    
    public int leerEntero(String msg)
    {
        return Integer.parseInt(JOptionPane.showInputDialog(null,msg,titulo,JOptionPane.QUESTION_MESSAGE));
    }
    
    public double leerDouble(String msg)
    {
        return Double.parseDouble(JOptionPane.showInputDialog(null,msg,titulo,JOptionPane.QUESTION_MESSAGE));
    }
    
    /**
     *
     * @param msg
     * @return
     */
    public Boolean validar(String msg)
    {
        return JOptionPane.showConfirmDialog(null, msg, titulo, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
    
    public void mostrar(String msg)
    {
        JOptionPane.showMessageDialog(null,msg,titulo, JOptionPane.INFORMATION_MESSAGE);
    }
}
