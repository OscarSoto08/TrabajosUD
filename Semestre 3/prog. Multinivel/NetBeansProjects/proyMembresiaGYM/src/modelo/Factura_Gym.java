package modelo;

public class Factura_Gym {
    private String idFact;
    private Membresia memb;
    private Fecha fechaF;
    private Persona cliente;

    public Factura_Gym(String idFact, Membresia memb, Fecha fechaF, Persona cliente) {
        this.idFact = idFact;
        this.memb = memb;
        this.fechaF = fechaF;
        this.cliente = cliente;
    }
    
    public Factura_Gym() {
        this.idFact = "F-" + Math.round(100+Math.random()*999);
        this.fechaF = new Fecha();
        this.cliente = new Persona();
    }

    public Persona getPropietario() {
        return cliente;
    }

    public void setPropietario(Persona propietario) {
        this.cliente = propietario;
    }
    
    public String getIdFact() {
        return idFact;
    }

    public void setIdFact(String idFact) {
        this.idFact = idFact;
    }

    public Membresia getMemb() {
        return memb;
    }

    public void setMemb(Membresia memb) {
        this.memb = memb;
    }

    public Fecha getFechaF() {
        return fechaF;
    }

    public void setFechaF(Fecha fechaF) {
        this.fechaF = fechaF;
    }
    
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
    
    @Override
    public String toString() {
        return """
               |------------------------------------------------------|\nFactura:
               id_Factura:""" + idFact + 
                "\nFecha_Factura: " + fechaF + 
                "\t\nCliente: \n" + cliente.toString() +
                "\nValor Pago: " + memb.valorPago() +
                "\n|------------------------------------------------------|";
    }
}
