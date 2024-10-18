package Modelo;

public class Empleado {
    private String ID, nombre;
    private double sueldo;

    public Empleado() {
        this.ID =  this.nombre = "";
        this.sueldo = 0.0;
    }

    public Empleado(String ID, String nombre, double sueldo) {
        this.ID = ID;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                        + "\nID: " + ID 
                        + "\nSueldo: " + sueldo;
    }
    
        public double pagoCorresp(double n){
            double Pension = (sueldo * n);
            
            return Pension;
        }
}
