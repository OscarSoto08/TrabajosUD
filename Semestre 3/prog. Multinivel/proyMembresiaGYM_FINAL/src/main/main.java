package main;
import control.*;
/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */

/**
 * Clase principal que inicia la aplicación.
 * Esta clase contiene el método main que inicializa el controlador principal.
 */
public class main {

     /**
     * Método principal que inicia la aplicación.
     * @param args Argumentos de línea de comandos (no se utilizan en este caso).
     */
    public static void main(String[] args) {
        // Inicializa el controlador principal
        Controlador_MDI controlador = new Controlador_MDI();
        controlador.iniciar();
    }
}
    

