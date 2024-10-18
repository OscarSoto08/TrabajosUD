package modelo;

public class Paciente {
    private String idPaciente,
                   nombre,
                   telefono;
    private Fecha fechaNac;

    public Paciente(String idPaciente, String nombre, String telefono, char categoria, Fecha fechaNac) {
        this.idPaciente = idPaciente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
    }

    public Paciente() {
        this.idPaciente = "P-" + Math.round(100+ Math.random()*999);
        this.nombre = "";
        this.telefono = "";
        this.fechaNac = new Fecha();
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(String idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    @Override
    public String toString() {
        return "id Paciente: " + idPaciente + 
               "\nNombre:" + nombre + 
               "\nTelefono:" + telefono + 
               "\nFecha Nacimiento:" + fechaNac.toString();
    }
}
