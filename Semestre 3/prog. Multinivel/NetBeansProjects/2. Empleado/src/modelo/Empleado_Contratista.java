package modelo;

import java.text.DecimalFormat;

public class Empleado_Contratista extends Empleado{
    private double
            valorTotalCont,
            valorAdelanto;
    private int cantidadPago;

    public Empleado_Contratista(double valorTotalCont, double valorAdelanto, int cantidadPago, Fecha fechaEmpleado, String nombre, String id, String telefono) {
        super(fechaEmpleado, nombre, id, telefono);
        this.valorTotalCont = valorTotalCont;
        this.valorAdelanto = valorAdelanto;
        this.cantidadPago = cantidadPago;
    }

    public Empleado_Contratista() {
        super();
        this.valorTotalCont = 0;
        this.valorAdelanto = 0;
        this.cantidadPago = 0;
    }

    
    public double getValorTotalCont() {
        return valorTotalCont;
    }

    public void setValorTotalCont(double valorTotalCont) {
        this.valorTotalCont = valorTotalCont;
    }

    public double getValorAdelanto() {
        return valorAdelanto;
    }

    public void setValorAdelanto(double valorAdelanto) {
        this.valorAdelanto = valorAdelanto;
    }

    public int getCantidadPago() {
        return cantidadPago;
    }

    public void setCantidadPago(int cantidadPago) {
        this.cantidadPago = cantidadPago;
    }

    @Override
    public double ValorPago()
    {
        double n = valorTotalCont - valorAdelanto;
        return n / cantidadPago;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return super.toString() + 
                   "\n Valor Total Contratación: " + df.format(valorTotalCont) + 
                   "\n Valor Adelanto: " + df.format(valorAdelanto) + 
                   "\n Cantidad de Pagos: " + df.format(cantidadPago) +
                   "\n VALOR DE PAGO: " + df.format(ValorPago()) + 
                    "\n-----------------------------------------------------------";
    }
}
