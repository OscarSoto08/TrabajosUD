package modelo;

public abstract class Empleado {
    private Fecha fechaEmpleado;
    private String nombre, id, telefono;

    public Empleado(Fecha fechaEmpleado, String nombre, String id, String telefono) {
        this.fechaEmpleado = fechaEmpleado;
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
    }

    public Empleado() {
        this.fechaEmpleado = new Fecha();
        this.nombre = "";
        this.id = "ID-"+Math.round(100 + Math.random()*999);
        this.telefono = "";
    }
    
    public abstract double ValorPago();

    public Fecha getFechaEmpleado() {
        return fechaEmpleado;
    }

    public void setFechaEmpleado(Fecha fechaEmpleado) {
        this.fechaEmpleado = fechaEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "\nFecha de ingreso: " + fechaEmpleado.toString() +
                   "\nNombre: " + nombre + 
                   "\nIdentificación: " + id + 
                   "\nTelefono: " + telefono;
    }
}
