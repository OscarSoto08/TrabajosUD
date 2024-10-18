/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Calendar;

public class Persona {
    private String nombre;
    private Fecha fechaNac;
    private String telefono;
    private String correo;
    private String ciudad;
    private String ID;

    public Persona(String nombre, String telefono, String correo, String ciudad, String ID) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudad = ciudad;
        this.ID = ID;
    }

    
    public Persona() {
        this.nombre = "";
        this.fechaNac = new Fecha();
        this.telefono = "";
        this.correo = "";
        this.ciudad = "";
        this.ID = "";
    }
    
    public String calcularEdad()
    {
        Calendar fechaSis = Calendar.getInstance();
        int años = fechaSis.get(Calendar.YEAR) - fechaNac.getAño();
        int meses = fechaSis.get(Calendar.MONTH) - fechaNac.getMes();
        int dias = fechaSis.get(Calendar.DAY_OF_MONTH) - fechaNac.getDia();
        String edad = "Años: " + años + "\nMeses:  " + meses + "\nDias"
                + "" +dias;
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    @Override
    public String toString() {
        return "Nombre: " + nombre + 
                "\nEdad: " + calcularEdad() + " años" + 
                "\nTelefono: " + telefono + 
                "\nCorreo: " + correo + 
                "\nCiudad" + ciudad + 
                "\nID: " + ID;
    }
}
