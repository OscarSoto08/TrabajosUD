package Vista;

import javax.swing.JOptionPane;


public class EntradaCD {
    private String title;

    public EntradaCD(String title) {
        this.title = title;
    }

    public EntradaCD() {
        this.title = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String leerTxt(String txt){
        return JOptionPane.showInputDialog(null, txt,title,JOptionPane.QUESTION_MESSAGE); 
    }
    
    public int leerEntero(String txt){
        return Integer.parseInt(JOptionPane.showInputDialog(null, txt,title,JOptionPane.QUESTION_MESSAGE)); 
    }
    
    public double leerDecimal(String txt){
        return Double.parseDouble(JOptionPane.showInputDialog(null, txt,title,JOptionPane.QUESTION_MESSAGE)); 
    }
    
    public long leerLong(String txt)
    {
        return Long.parseLong(JOptionPane.showInputDialog(null, txt,title,JOptionPane.QUESTION_MESSAGE)); 
    }
    public boolean validar(String txt)
    {
        return (JOptionPane.showConfirmDialog(null, txt, title, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    
    public void mostrar(String txt)
    {
        JOptionPane.showMessageDialog(null, txt, title, JOptionPane.INFORMATION_MESSAGE);
    }
}
