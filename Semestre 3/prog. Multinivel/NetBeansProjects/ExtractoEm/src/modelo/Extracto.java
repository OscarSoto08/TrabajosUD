package modelo;
public class Extracto {
    Fecha fecha;
    Empleado objE;
    String codEx;
    long Valor_a_pagar;
    
    public Extracto(Fecha fecha, Empleado objE, String codEx, long Valor_a_pagar) {
        this.fecha = fecha;
        this.objE = objE;
        this.codEx = codEx;
        this.Valor_a_pagar = Valor_a_pagar;
    }

    public Extracto() {
        this.fecha = new Fecha();
        this.objE = new Empleado();
        this.codEx = "XX-"+Math.round(100+Math.random()*999);
    }

    public String getCodEx() {
        return codEx;
    }

    public void setCodEx(String codEx) {
        this.codEx = codEx;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }
    
    public Empleado getObjE() {
        return objE;
    }

    public void setObjE(Empleado objE) {
        this.objE = objE;
    }   

    public long getValor_a_pagar() {
        return Valor_a_pagar;
    }

    public void setValor_a_pagar(long Valor_a_pagar) {
        this.Valor_a_pagar = Valor_a_pagar;
    }

    public String toString(int edad) {
        return  "\n Id extracto =" + codEx + "\n Fecha (DD/MM/AAAA): " + fecha.toString() + objE.toString() + "\n Edad: " + edad +"\n Valor_a_pagar=" + Valor_a_pagar  ;
    }
}
