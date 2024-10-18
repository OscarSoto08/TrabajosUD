package Controlador;

import Modelo.Person;
import Vista.Entrada;

public class control {
    private Person objP;
    private Entrada ent;

    public control() {
        objP = new Person();
        ent = new Entrada();
    }
    
    public void iniciar()
    {
        ent.mostrar("Programa que calcula su edad en años, meses y dias");
        objP.setNombre(ent.leerTexto("Nombre: "));
        objP.setApellido(ent.leerTexto("Apellido: "));
        ent.mostrar("Fecha de nacimiento....");
        objP.setAño(ent.leerEntero("Año: "));
        objP.setMes(ent.leerEntero("Mes: "));
        objP.setDia(ent.leerEntero("Dia: "));
        objP.calcularEdad();
        ent.mostrar("Datos analizados: ");
        ent.mostrar(objP.toString());
    }
}
