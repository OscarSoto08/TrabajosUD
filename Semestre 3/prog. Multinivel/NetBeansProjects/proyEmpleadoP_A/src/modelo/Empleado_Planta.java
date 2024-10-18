package modelo;

import java.text.DecimalFormat;

public class Empleado_Planta extends Empleado{
    private double sueldo,
                            subsidioTransporte;
    private String cargo;

    public Empleado_Planta(double sueldo,double subsidioTransporte, String cargo, Fecha fechaEmpleado, String nombre, String id, String telefono) {
        super(fechaEmpleado, nombre, id, telefono);
        this.sueldo = sueldo;
        this.subsidioTransporte = subsidioTransporte;
        this.cargo = cargo;
    }

    public Empleado_Planta() {
        super();
        this.sueldo = 0;
        this.subsidioTransporte = 162000;
        this.cargo = "";
    }

    public double calcularAporteSalud()
    {
        return sueldo * 0.035;
    }
    
    public double calcularPension()
    {
        return  sueldo * 0.035;
    }
    
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getSubsidioTransporte() {
        return subsidioTransporte;
    }

    public void setSubsidioTransporte(double subsidioTransporte) {
        this.subsidioTransporte = subsidioTransporte;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
    @Override
    public double ValorPago()
    {
        return sueldo - (subsidioTransporte  + calcularAporteSalud() + calcularPension());
        
    }
    
    @Override
    public String toString()
    {
        DecimalFormat df = new DecimalFormat("#.00");
        return super.toString() +
                    "\nSueldo: " + df.format(sueldo) +
                    "\nValor Salud: " + df.format(calcularAporteSalud()) +
                    "\nValor Pensión: " + df.format(calcularPension()) +
                    "\nSubsidio de Transporte: " + subsidioTransporte +
                    "\n VALOR DE PAGO " +df.format(ValorPago()) +
                    "\n-----------------------------------------------------------";
    }
}
