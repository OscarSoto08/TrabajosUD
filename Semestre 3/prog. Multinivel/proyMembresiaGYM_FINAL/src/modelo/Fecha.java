package modelo;
/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
import java.util.Calendar;

/**
 * La clase Fecha representa una fecha con día, mes y año.
 */
public class Fecha {
    /** El día de la fecha. */
    private int dia;
    /** El mes de la fecha. */
    private int mes;
    /** El año de la fecha. */
    private int año;

    
    /**
     * Constructor de la clase Fecha que inicializa los atributos día, mes y año.
     * @param dia El día de la fecha.
     * @param mes El mes de la fecha.
     * @param año El año de la fecha.
     */
    public Fecha(int dia, int mes, int año) {
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }
    /**
     * Constructor vacío de la clase Fecha que inicializa la fecha con la fecha del sistema.
     * Utiliza la fecha actual del sistema para inicializar los atributos día, mes y año.
     */
    public Fecha(){
        // Obtener la fecha actual del sistema
        Calendar fechaSis = Calendar.getInstance();
        // Inicializar los atributos día, mes y año con la fecha actual del sistema
        this.dia = fechaSis.get(Calendar.YEAR);
        this.mes = fechaSis.get(Calendar.MONTH);
        this.año = fechaSis.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * Método que devuelve el día de la fecha.
     * @return El día de la fecha.
     */
    public int getDia() {
        return dia;
    }
    /**
     * Método que establece el día de la fecha.
     * @param dia El nuevo día de la fecha.
     */
    public void setDia(int dia) {
        this.dia = dia;
    }
    /**
     * Método que devuelve el mes de la fecha.
     * @return El mes de la fecha.
     */
    public int getMes() {
        return mes;
    }
    /**
     * Método que establece el mes de la fecha.
     * @param mes El nuevo mes de la fecha.
     */
    public void setMes(int mes) {
        this.mes = mes;
    }
    /**
     * Método que devuelve el año de la fecha.
     * @return El año de la fecha.
     */
    public int getAño() {
        return año;
    }
    /**
     * Método que establece el año de la fecha.
     * @param año El nuevo año de la fecha.
     */
    public void setAño(int año) {
        this.año = año;
    }

    /**
     * Método que devuelve una representación en forma de String de la fecha.
     * @return Una cadena que representa la fecha en formato "dia/mes/año".
     */
    @Override
    public String toString() {
        return dia+"/"+mes+"/"+año;
    }
}
