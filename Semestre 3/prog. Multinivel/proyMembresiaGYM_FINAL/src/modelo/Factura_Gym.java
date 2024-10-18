package modelo;
/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */

/**
 * La clase Factura_Gym representa una factura de gimnasio e incluye información sobre la membresía adquirida, la fecha de emisión y los datos del cliente.
 */
public class Factura_Gym {
    /** Identificador único de la factura. */
    private String idFact;
    /** Objeto que representa la membresía adquirida. */
    private Membresia memb;
    /** Fecha de emisión de la factura. */
    private Fecha fechaF;
    /** Cliente al que se emite la factura. */
    private Persona cliente;

    /**
     *
     * @param idFact
     * @param memb
     * @param fechaF
     * @param cliente
     */
    public Factura_Gym(String idFact, Membresia memb, Fecha fechaF, Persona cliente) {
        this.idFact = idFact;
        this.memb = memb;
        this.fechaF = fechaF;
        this.cliente = cliente;
    }
    
    /**
     * Constructor de la clase Factura_Gym que inicializa todos los atributos de la factura.
     * Genera un identificador único para la factura, inicializa la fecha de emisión y crea un cliente y una membresía vacíos.
     */
    public Factura_Gym() {
    this.idFact = "F-" + Math.round(100 + Math.random() * 999);
    this.fechaF = new Fecha();
    this.cliente = new Persona();
    this.memb = null; 
    }

    /**
     * Método que devuelve el cliente al que se emite la factura.
     * @return El cliente al que se emite la factura.
     */
    public Persona getCliente() {
        return cliente;
    }
    /**
     * Método que establece el cliente al que se emite la factura.
     * @param propietario El nuevo cliente al que se emite la factura.
     */
    public void setCliente(Persona propietario) {
        this.cliente = propietario;
    }
    
    /**
     * Método que devuelve el identificador único de la factura.
     * @return El identificador único de la factura.
     */
    public String getIdFact() {
        return idFact;
    }
    /**
     * Método que establece el identificador único de la factura.
     * @param idFact El nuevo identificador único de la factura.
     */
    public void setIdFact(String idFact) {
        this.idFact = idFact;
    }
    /**
     * Método que devuelve la membresía adquirida.
     * @return La membresía adquirida.
     */
    public Membresia getMemb() {
        return memb;
    }
    /**
     * Método que establece la membresía adquirida.
     * @param memb La nueva membresía adquirida.
     */
    public void setMemb(Membresia memb) {
        this.memb = memb;
    }
    /**
     * Método que devuelve la fecha de emisión de la factura.
     * @return La fecha de emisión de la factura.
     */
    public Fecha getFechaF() {
        return fechaF;
    }
    /**
     * Método que establece la fecha de emisión de la factura.
     * @param fechaF La nueva fecha de emisión de la factura.
     */
    public void setFechaF(Fecha fechaF) {
        this.fechaF = fechaF;
    }  
    /**
     * Método que genera un registro de la factura para ser utilizado en una tabla u otra presentación similar.
     * @return Un arreglo de objetos que representa un registro de la factura.
     */
    public Object[] Registro(){
        String tipo = "";
        if (memb instanceof TipoA)
            tipo = "A";
        else if(memb instanceof TipoB)
            tipo = "B";
        else
            tipo = "C";
        Object[] reg = {
            cliente.getID(),
            cliente.getNombre(),
            tipo,
            memb.valorPago()
        };
        return reg;
    }
    

    /**
     * Método que devuelve una representación en forma de String de la factura.
     * @return Una representación en forma de String de la factura.
     */
    @Override
    public String toString() {
        return """
               |------------------------------------------------------|\nFactura:
               id_Factura:""" + idFact + 
                "\nFecha_Factura: " + fechaF + 
                "\nCliente: \n" + cliente.toString() +
                "\nValor Pago: " + memb.valorPago() +
                "\n|------------------------------------------------------|";
    }

    
}
