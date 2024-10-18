package modelo;

public class Empleado {
    
    private String nombre, id;
    private long salario;
    private Fecha fechaSis;
    private Fecha fechaNacimiento;
    private long Transportes;
    
    
    public Empleado( String nombre, String id, long salario, Fecha fechaSis,long Transportes) {
        
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.fechaSis = fechaSis;
        this.Transportes = Transportes;
    }
    
    
     public Empleado() {
        this.nombre  = "";
        this.id = "__" + Math.round(100+Math.random()*999);
        this.salario = 0;
        this.fechaSis = this.fechaNacimiento = new Fecha();
        this.Transportes = 162000;
     }
     
     
     
    public Fecha getFechaSis() {
        return fechaSis;
    }

    public void setFechaSis(Fecha fechaSis) {
        this.fechaSis = fechaSis;
    }

    public long getTransportes() {
        return Transportes;
    }

    public void setTransportes(long Transportes) {
        this.Transportes = Transportes;
    }

    
    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Fecha fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
   
    
    public Fecha getFechasSis() {
        return fechaSis;
    }

    public void setFechasSis(Fecha fechasSis) {
        this.fechaSis = fechasSis;
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

    public long getSalario() {
        return salario;
    }
    
    public void setSalario(long salario) {
        this.salario = salario; 
    }

    public int calcularEdad() {
        Fecha fechaNac = this.fechaNacimiento;
        Fecha fechaActual = this.fechaSis;

        int edad = fechaActual.getAa() - fechaNac.getAa();

        if (fechaActual.getMm() < fechaNac.getMm() || (fechaActual.getMm() == fechaNac.getMm() && fechaActual.getDd() < fechaNac.getDd())) {
            edad--;
        }
        return edad;
    }
    
    public long calcularValorSalud()
    {
        return (long) (salario*0.35);
    }
    
    public long calcularAportePension()
    {
        return (long) (salario*0.35);
    }
    
    
    
    @Override
    public String toString() {
        return "\n nombre=" + nombre + "\n id. Empleado =" + id + "\n salario =" + salario;
    }

    
}
