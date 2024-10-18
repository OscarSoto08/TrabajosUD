package modelo;

import java.util.ArrayList;

public class Formulario {
    private String nroF;
    private Fecha fRegistro;
    private Persona propietario;
    private ArrayList<Vehiculo> listaV;

    public Formulario(String nroF, Fecha fRegistro, Persona propietario, ArrayList<Vehiculo> listaP) {
        this.nroF = nroF;
        this.fRegistro = fRegistro;
        this.propietario = propietario;
        this.listaV = listaP;
    }

    public Formulario() {
        this.nroF = "F--"+Math.round(100+Math.random()*999);
        this.fRegistro = new Fecha();
        this.propietario = new Persona();
        this.listaV = new ArrayList<>();
    }
    
    
    public String getNroF() {
        return nroF;
    }

    public void setNroF(String nroF) {
        this.nroF = nroF;
    }

    public Fecha getfRegistro() {
        return fRegistro;
    }

    public void setfRegistro(Fecha fRegistro) {
        this.fRegistro = fRegistro;
    }

    public Persona getPropietario() {
        return propietario;
    }

    public void setPropietario(Persona propietario) {
        this.propietario = propietario;
    }

    public ArrayList<Vehiculo> getListaV() {
        return listaV;
    }

    public void setListaV(ArrayList<Vehiculo> listaP) {
        this.listaV = listaP;
    }
    
    @Override
    public String toString() {
        return """
               Formulario Impuesto
               No.Formulario:  """ + nroF + 
                "\nFecha Registro: " + fRegistro.toString() + 
                "\n\tPropietario " + propietario.toString() + 
                "\n" + datos();
    }
    
    public double valorPago()
    {
        double totalPago = 0;
        for (Vehiculo vehiculo : listaV) {
            totalPago += vehiculo.impuesto();
        }
        return totalPago;
    }
    
    public String datos()
    {
        String listado = "";
        for (Vehiculo vehiculo : listaV) {
            listado += vehiculo.toString()+"\n";
        }
        return listado;
    }
}
