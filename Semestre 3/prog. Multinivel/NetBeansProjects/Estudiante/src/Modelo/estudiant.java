
package Modelo;

public class estudiant {
    private double notas[];
    private String nombre;
    private String ID;

    public estudiant() {
        this.notas = new double[3];
        this.nombre = "";
        this.ID = "";
    }

    public estudiant(double notas[], String nombre, String ID) {
        this.notas = notas;
        this.nombre = nombre;
        this.ID = ID;
    }

    
    public double[] getNotas() {
        return notas;
    }
    
    public void setNotas(double[] notas) {
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "estudiante{ nombre=" + nombre + ", ID=" + ID + '}';
    }
    
    public double promedio()
    {
       int suma = 0;
       for(double i : notas)
       {
           suma += i;
       }
        return suma / notas.length;
    }
    
    public void mostrarNotas()
    {
        int j = 1;
        for(double i : notas)
        {
             System.out.println("Nota " + j + ": " + i);
            j+=1;
        }
           
            
    }
}
