package modelo;

import java.text.DecimalFormat;

public class Extracto {
    private String idExtracto;
    private Fecha fechaEx;
    private Empleado objE;

    public Extracto(String idExtracto, Fecha fechaEx, Empleado objE) 
    {
        this.idExtracto = idExtracto;
        this.fechaEx = fechaEx;
        this.objE = objE;
    }
    
    public Extracto() 
    {
        this.idExtracto = "EX - " + Math.round(100+Math.random()*999);
        this.fechaEx = new Fecha();
    }

    public String getIdExtracto() {
        return idExtracto;
    }

    public void setIdExtracto(String idExtracto) {
        this.idExtracto = idExtracto;
    }

    public Fecha getFechaEx() {
        return fechaEx;
    }

    public void setFechaEx(Fecha fechaEx) {
        this.fechaEx = fechaEx;
    }

    public Empleado getObjE() {
        return objE;
    }

    public void setObjE(Empleado objE) {
        this.objE = objE;
    }

    @Override
    public String toString() {
        return "\nID Extracto: " + idExtracto + 
                   "\nFecha Extracto: " + fechaEx + 
                    objE.toString();
    }
}
