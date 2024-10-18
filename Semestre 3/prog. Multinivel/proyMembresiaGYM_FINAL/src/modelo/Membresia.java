
package modelo;

/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */

/*Membresia es la clase abstracta utilizada para referirse al 
servicio de membresia que tiene el Gimnasio y a su vez tiene un metodo
valorPago() que va a varias dependiendo el tipo de membresia*/

public abstract class Membresia {
    /** La categoría de la membresía, representada por una cadena de texto. */
    protected String categoria;

    /**
     * Constructor de la clase Membresia que inicializa la categoría de la membresía.
     * @param categoria La categoría de la membresía.
     */
    public Membresia(String categoria) {
        this.categoria = categoria;
    }
    /**
     * Constructor vacío de la clase Membresia que inicializa la categoría de la membresía como una cadena vacía.
     */
    public Membresia() {
        this.categoria = "";
    }
    /**
     * Método que devuelve la categoría de la membresía.
     * @return La categoría de la membresía.
     */
    public String getCategoria() {
        return categoria;
    }
    /**
     * Método que establece la categoría de la membresía.
     * @param categoria La nueva categoría de la membresía.
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    /**
     * Método abstracto que calcula el valor del pago de la membresía.
     * Este método debe ser implementado por las clases concretas que extienden la clase Membresia.
     * @return El valor del pago de la membresía.
     */
    public abstract double valorPago();
    
    /**
     * Método que devuelve una representación en forma de String de la membresía.
     * @return Una cadena que representa la categoría de la membresía.
     */
    @Override
    public String toString() {
                return  "\nCategoria: " + categoria;
    }
}
