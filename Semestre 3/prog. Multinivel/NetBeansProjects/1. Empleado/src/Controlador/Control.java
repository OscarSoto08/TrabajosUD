package Controlador;

import Modelo.Empleado;
import Vista.EntradaE;

public class Control {
    private EntradaE ent;
    private Empleado ObjE;

    public Control() {
        this.ent = new EntradaE();
        this.ObjE = new Empleado();
    }

    public Control(EntradaE ent, Empleado ObjE) {
        this.ent = ent;
        this.ObjE = ObjE;
    }
    
    public void iniciar()
    {
        ent.mostrar("Programa que calcula valor de pension y salud...");
        ObjE.setNombre(ent.leerTexto("Nombre: "));
        ObjE.setID(ent.leerTexto("ID: "));
        ObjE.setSueldo(ent.leerDecimal("Sueldo: "));
        ent.mostrar("Datos entregados: ");
        ent.mostrar(ObjE.toString());
        ent.mostrar("Valor de pago de pension (4%):  "+ ObjE.pagoCorresp(0.04));
        ent.mostrar("Valor de pago de salud (3.5%):  "+ ObjE.pagoCorresp(0.035));
    }
}
