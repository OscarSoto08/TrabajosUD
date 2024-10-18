package modelo;
/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
import java.util.ArrayList;

/**
 * Clase para calcular y mantener registros del recaudo generado por las membresías del gimnasio.
 * Permite obtener información detallada sobre las facturas generadas y el total recaudado.
 */
public class Recaudo {
    // Lista de facturas de membresía
    private ArrayList<Factura_Gym> listaF;
    // Totales general recaudado
    private double TotalRecaudado;
    
    /**
     * Constructor que inicializa la lista de facturas.
     * 
     * @param listaF Lista de facturas de membresía
     */
    public Recaudo(ArrayList<Factura_Gym> listaF) {
        this.listaF = listaF;
    }

    
    /**
     * Constructor que inicializa una lista de facturas vacía.
     */
    public Recaudo() {
        this.listaF = new ArrayList<>();
    }

    /**
     * Obtiene la lista de facturas de membresía.
     * 
     * @return La lista de facturas de membresía
     */
    public ArrayList<Factura_Gym> getListaF() {
        return listaF;
    }

    /**
     * Establece la lista de facturas de membresía.
     * 
     * @param listaF La lista de facturas de membresía a establecer
     */
    public void setListaF(ArrayList<Factura_Gym> listaF) {
        this.listaF = listaF;
    }

    
    /**
     * Obtiene los datos detallados de las facturas de membresía.
     * 
     * @return Una cadena con los datos detallados de las facturas de membresía
     */
    public String datos() {
        StringBuilder datos = new StringBuilder();
        for (Factura_Gym factura : listaF) {
            datos.append(factura.toString()).append("\n");
        }
        return datos.toString();
    }

    /**
     * Calcula el total recaudado por todas las membresías.
     * 
     * @return El total recaudado por todas las membresías
     */
    public double valorPago() {
        double total = 0;
        for (Factura_Gym factura : listaF) {
            total += factura.getMemb().valorPago();
        }
        return total;
    }

    /**
     * Obtiene el total recaudado por todas las membresías.
     * 
     * @return El total recaudado por todas las membresías
     */
    public double getTotalRecaudado() {
        double total = 0;
        for (Factura_Gym factura : listaF) {
            total += factura.getMemb().valorPago();
        }
        return total;
    }
    
    /**
     * Retorna una representación en cadena de texto de los datos detallados de las facturas de membresía.
     * 
     * @return Una representación en cadena de texto de los datos detallados de las facturas de membresía
     */
    @Override
    public String toString() {
        return datos();
    }
}
