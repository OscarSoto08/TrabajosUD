package Modelo;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Persona> contactos;

    public Agenda(ArrayList<Persona> contactos) {
        this.contactos = contactos;
    }
    
    public Agenda() {
        this.contactos = new ArrayList<>();
    }

    public ArrayList<Persona> getContactos() {
        return contactos;
    }

    public void setContactos(ArrayList<Persona> contactos) {
        this.contactos = contactos;
    }

    @Override
    public String toString() {
        String datos = "";
        for (Persona contacto : contactos) {
            datos += "\n"+contacto.toString();
        }
        return datos;
    }
}
