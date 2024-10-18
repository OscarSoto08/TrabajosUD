package vista;

import javax.swing.JOptionPane;

public class EntradaCM {
    String title;

    public EntradaCM(String title) {
        this.title = title;
    }

    public EntradaCM() {
        this.title = "";
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public int leerEntero(String msg)
    {
        return Integer.parseInt(JOptionPane.showInputDialog(null,msg,title,JOptionPane.QUESTION_MESSAGE));
    }
    
    public double leerDecimal(String msg)
    {
        return Double.parseDouble(JOptionPane.showInputDialog(null,msg,title,JOptionPane.QUESTION_MESSAGE));
    }
    
    public String leerTexto(String msg)
    {
        return JOptionPane.showInputDialog(null,msg,title,JOptionPane.QUESTION_MESSAGE);
    }
    
    public boolean validar(String msg)
    {
        return (JOptionPane.showConfirmDialog(null,msg,title,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    public void mostrar(String msg)
    {
        JOptionPane.showMessageDialog(null, msg,title,JOptionPane.INFORMATION_MESSAGE);
    }
}
