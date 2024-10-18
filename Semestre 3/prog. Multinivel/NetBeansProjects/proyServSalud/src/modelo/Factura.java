/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Estudiante
 */
public class Factura {
    private Fecha fechaFactura;
    private Servicio objS;
    private Paciente objP;

    public Factura(Fecha fechaFactura, Servicio objS, Paciente objP) {
        this.fechaFactura = fechaFactura;
        this.objS = objS;
        this.objP = objP;
    }
    
    public Factura() {
        this.fechaFactura = new Fecha();
        this.objP = new Paciente();
    }

    public Fecha getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(Fecha fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Servicio getObjS() {
        return objS;
    }

    public void setObjS(Servicio objS) {
        this.objS = objS;
    }

    public Paciente getObjP() {
        return objP;
    }

    public void setObjP(Paciente objP) {
        this.objP = objP;
    }

    @Override
    public String toString() {
        return "Fecha de Factura: " + fechaFactura + 
                objS.toString() + objP.toString();
    }    
}
