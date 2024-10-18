package vista;

import javax.swing.JOptionPane;

public class EntradaCM {
    private String titulo;

    public EntradaCM(String titulo) {
        this.titulo = titulo;
    }

    public EntradaCM() {
        this.titulo = "";
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public String leerTexto(String msj)
    {
        return JOptionPane.showInputDialog(null,msj,titulo,JOptionPane.QUESTION_MESSAGE);
    }

    public int leerEntero(String msj)
    {
        return Integer.parseInt(JOptionPane.showInputDialog(null,msj,titulo,JOptionPane.QUESTION_MESSAGE));
    }
    
    public double leerDecimal(String msj)
    {
        return Double.parseDouble(JOptionPane.showInputDialog(null,msj,titulo,JOptionPane.QUESTION_MESSAGE));
    }
    
    public void mostrar(String msj)
    {
        JOptionPane.showMessageDialog(null,msj,titulo,JOptionPane.INFORMATION_MESSAGE);
    }
    public boolean validar(String msj)
    {
        return
                JOptionPane.showConfirmDialog(null, msj,titulo,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
    }
}
