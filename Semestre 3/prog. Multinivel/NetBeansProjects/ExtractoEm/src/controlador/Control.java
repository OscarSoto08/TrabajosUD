package controlador;

import modelo.*;
import Vista.*;

public class Control {
    private Extracto objEx;
    private EntradaCD ent;

    public Control() {
        this.objEx = new Extracto();
        this.ent = new EntradaCD();
    }
    
    public void pedirDatosEmpleado()
    {
        objEx.getObjE().setNombre(ent.leerTxt("Nombre"));
        objEx.getObjE().setId(ent.leerTxt("Identificación"));
        String fecha[] = ent.leerTxt("Ingrese su fecha de nacimiento (DD/MM/AAAA): ").split("/");
        objEx.getObjE().setFechaNacimiento(new Fecha(Integer.parseInt(fecha[0]),Integer.parseInt(fecha[1]),Integer.parseInt(fecha[2])));
        objEx.getObjE().setSalario(ent.leerLong("Salario: "));
        
    }
    
    public void calcularDatosEmpleado()
    {
        objEx.setValor_a_pagar(objEx.getObjE().getSalario()+
                                                    objEx.getObjE().getTransportes() - (
                                                    objEx.getObjE().calcularAportePension() +
                                                    objEx.getObjE().calcularValorSalud()));
        
    }
    
    public void mostrarDatos()
    {
        ent.setTitle("Extracto del empleado " +  objEx.getObjE().getNombre());
        ent.mostrar(objEx.toString(objEx.getObjE().calcularEdad()));       
    }
    public void iniciar()
    {
        do
        {
            pedirDatosEmpleado();
            calcularDatosEmpleado();
            mostrarDatos();
        }while(ent.validar("¿Desea continuar? "));
    }
}
