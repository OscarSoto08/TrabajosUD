/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
package modelo;
/**
 * Clase que define un tipo de membresía "B".
 * Hereda de la clase Membresia y establece un valor de pago fijo.
 */
public class TipoB extends Membresia{
    
    /**
     * Constructor por defecto que establece la categoría como "B".
     */
    public TipoB() {
        super("B");
    }

    /**
     * Constructor que establece la categoría como "B" y el valor de pago.
     * 
     * @param categoria La categoría de la membresía
     * @param valor El valor de pago de la membresía
     */
    public TipoB(String categoria) {
        super.categoria = categoria;
    }
    
    /**
     * Retorna el valor de pago fijo para la membresía tipo B.
     * 
     * @return El valor de pago para la membresía tipo B
     */
    @Override
    public double valorPago() {
        return 75000;
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
