/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
package modelo;

/**
 * Clase que define un tipo de membresía "A".
 * Hereda de la clase Membresia y establece un valor de pago fijo.
 */
public class TipoA extends Membresia{

    /**
     * Constructor por defecto que establece la categoría como "A".
     */
    public TipoA() {
        super("A");
    }

    /**
     * Constructor que establece la categoría como "A" y el valor de pago.
     * 
     * @param categoria La categoría de la membresía
     * @param valor El valor de pago de la membresía
     */
    public TipoA(String categoria) {
        super.categoria = categoria;
    }
    
    /**
     * Retorna el valor de pago fijo para la membresía tipo A.
     * 
     * @return El valor de pago para la membresía tipo A
     */
    @Override
    public double valorPago() {
        return 65000;
    }

    /**
     * Retorna una representación en cadena del objeto.
     * 
     * @return Una representación en cadena del objeto
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
