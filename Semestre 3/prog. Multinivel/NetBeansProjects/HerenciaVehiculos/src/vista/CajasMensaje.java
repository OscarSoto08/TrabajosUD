package Vista;
import javax.swing.JOptionPane;

public class CajasMensaje {
        private String titulo;
        
    public CajasMensaje() {
          this.titulo = "";
    }
    
    public CajasMensaje(String titulo) {
        this.titulo = titulo;
    }
    
    public int leerEntero(String msj){
        return Integer.parseInt(JOptionPane.showInputDialog(null, 
                                            msj,
                                            titulo,
                                            JOptionPane.INFORMATION_MESSAGE));
    }
    
    public double leerDouble(String msj){
        return Double.parseDouble(JOptionPane.showInputDialog(null, 
                                            msj,
                                            titulo,
                                            JOptionPane.INFORMATION_MESSAGE));
    }
    public String leerTexto(String msj){
        return JOptionPane.showInputDialog(null, 
                                            msj,
                                            titulo,
                                            JOptionPane.INFORMATION_MESSAGE);
        
    }
    public void mostrar(String msj){
        JOptionPane.showMessageDialog(null, "" + msj);
    }

    @Override
    public String toString() {
        return "Titulo:" + titulo ;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public boolean validar(String msg){
            return JOptionPane.showConfirmDialog(null,msg, "Salida", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION; //verificar si le dió SI al boton
            //de lo contrario recoge los datos y saluda a la persona que haya puesto el nombre en el input
    }
}

