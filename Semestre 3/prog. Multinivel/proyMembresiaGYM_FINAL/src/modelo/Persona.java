/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
package modelo;

import java.util.Calendar;

/**
 * La clase Persona representa a una persona con sus atributos básicos como nombre, fecha de nacimiento, teléfono, correo, ciudad y ID.
 */
public class Persona {
    /** El nombre de la persona. */
    /** La fecha de nacimiento de la persona. */
    /** El número de teléfono de la persona. */
    /** La dirección de correo electrónico de la persona. */
    /** La ciudad de residencia de la persona. */
    
    private String ID;
    private String nombre;
    private String telefono;
    private String correo;
    private String ciudad;
    private Fecha fechaNac;

    public Persona(String ID, String nombre, String telefono, String correo, String ciudad, Fecha fechaNac) {
        this.ID = ID;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudad = ciudad;
        this.fechaNac = fechaNac;
    }

    /**
     * Constructor de la clase Persona que inicializa sus atributos con valores predeterminados.
     */
    public Persona() {
        this.nombre = "";
        this.fechaNac = new Fecha();
        this.telefono = "";
        this.correo = "";
        this.ciudad = "";
        this.ID = "";
    }
    
    /**
     * Método que calcula la edad de la persona basándose en su fecha de nacimiento.
     * @return Una cadena que representa la edad de la persona en años, o un mensaje de error si ocurre alguna excepción.
     */
    public String calcularEdad() {
        try {
            Calendar fechaSis = Calendar.getInstance(); // Obtener fecha y año actual
            int añoActual = fechaSis.get(Calendar.YEAR);
            int añoNacimiento = fechaNac.getAño();

            int edad = añoActual - añoNacimiento;

            // Verificar si la persona tiene menos de 1 año
            if (edad <= 0) {
                return "La persona tiene menos de 1 año.";
            } else {
                return "Años: " + edad;
            }
        } catch (Exception e) {
            // Se muestra un mensaje de error si ocurre alguna excepción al calcular la edad
            e.printStackTrace();
            return "Error al calcular la edad.";
        }
    }

    
    /**
     * Devuelve el nombre de la persona.
     * @return El nombre de la persona.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la persona.
     * @param nombre El nuevo nombre de la persona.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la fecha de nacimiento de la persona.
     * @return La fecha de nacimiento de la persona.
     */
    public Fecha getFechaNac() {
        return fechaNac;
    }

    /**
     * Establece la fecha de nacimiento de la persona.
     * @param fechaNac La nueva fecha de nacimiento de la persona.
     */
    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * Devuelve el número de teléfono de la persona.
     * @return El número de teléfono de la persona.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono de la persona.
     * @param telefono El nuevo número de teléfono de la persona.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el correo electrónico de la persona.
     * @return El correo electrónico de la persona.
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo electrónico de la persona.
     * @param correo El nuevo correo electrónico de la persona.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve el identificador único de la persona.
     * @return El identificador único de la persona.
     */
    public String getID() {
        return ID;
    }

    /**
     * Establece el identificador único de la persona.
     * @param ID El nuevo identificador único de la persona.
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Devuelve la ciudad de residencia de la persona.
     * @return La ciudad de residencia de la persona.
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece la ciudad de residencia de la persona.
     * @param ciudad La nueva ciudad de residencia de la persona.
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    /**
     * Método que devuelve una representación en cadena de la persona, incluyendo todos sus atributos.
     * @return Una cadena que representa la información de la persona.
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + 
                "\nEdad: " + calcularEdad() + " años" + 
                "\nTelefono: " + telefono + 
                "\nCorreo: " + correo + 
                "\nCiudad: " + ciudad + 
                "\nID: " + ID;
    }
}
