package Controlador;

import Vista.Entrada;
import Modelo.*;
public class control {
    private final Entrada ent;
    private final estudiant objE;

    public control() {
        objE = new estudiant();
        ent = new Entrada();
    }   
    
    public void iniciar()
    {
        ent.mostrar("Programa que calcula promedio");
        do
        {
            objE.setNombre(ent.leerTexto("Nombre: "));
            objE.setID(ent.leerTexto("Identificacion: "));
            for(int i = 0; i < objE.getNotas().length; i++)
            {
                objE.getNotas()[i] =  ent.leerDecimal("Nota: ");
            }
            objE.toString();
            objE.mostrarNotas();
            ent.mostrar("El promedio de sus notas es: " + objE.promedio());
        }while(ent.validar("Desea continuar? (s/n): "));
    }
}
