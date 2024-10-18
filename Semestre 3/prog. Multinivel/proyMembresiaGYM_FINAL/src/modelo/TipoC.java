/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
package modelo;
/**
 * Clase que define un tipo de membresía "C".
 * Hereda de la clase Membresia y establece un valor de pago fijo.
 */
public class TipoC extends Membresia{
    
    /**
     * Constructor por defecto que establece la categoría como "C".
     */
    public TipoC() {
        super("C");
    }

    /**
     * Constructor que establece la categoría como "C" y el valor de pago.
     * 
     * @param categoria La categoría de la membresía
     * @param valor El valor de pago de la membresía
     */
    public TipoC(String categoria){
        super.categoria = categoria;
    }
    
    /**
     * Retorna el valor de pago fijo para la membresía tipo C.
     * 
     * @return El valor de pago para la membresía tipo C
     */
    @Override
    public double valorPago() {
        return 650000;
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
