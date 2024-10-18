package controlador;

import modelo.*;
import vista.*;

public class Control1Rec {
        EntradaCM objE;

    public Control1Rec() {
        this.objE = new EntradaCM();
    }
    
    public void ingresarDatosEmpleado(Empleado objEm)
    {
        objEm.setNombre(objE.leerTexto("Nombre: "));
        objEm.setTelefono(objE.leerTexto("Telefono: "));
            String[] fechaE = objE.leerTexto("Fecha de ingreso.\n(DD/MM/AAAA)").split("/");
        objEm.setFechaEmpleado(new Fecha(Integer.parseInt(fechaE[0]),
                                                                            Integer.parseInt(fechaE[1]),
                                                                            Integer.parseInt(fechaE[2])));
    }
    
    public void ingresarDatosPlanta(Empleado_Planta objEm)
    {
        objEm.setCargo(objE.leerTexto("Cargo: "));
        objEm.setSueldo(objE.leerDecimal("Ingrese sueldo: "));
    }
    
    public void ingresarDatosContratista(Empleado_Contratista objEm)
    {
        objEm.setValorTotalCont(objE.leerDecimal("Ingrese el valor total del contrato"));
        objEm.setValorAdelanto(objE.leerDecimal("Ingrese el valor de adelanto"));
        objEm.setCantidadPago(objE.leerEntero("Ingrese la cantidad de pagos del contrato"));
    }
    
    public void iniciar()
    {
        objE.setTitulo("Extracto de empleados");
        Recaudo objRec = new Recaudo();
        do
        {
            
            do{
                Extracto objEx = new Extracto();
                //ingresarDatosEmpleado(objEx.getObjE());
                int op = objE.leerEntero("""
                                                     Seleccione un empleado:
                                                     \n1. Empleado de planta
                                                     \n2. Contratista""");
                switch(op)
                {
                    case 1 -> {
                        Empleado_Planta objEmP = new Empleado_Planta();
                        ingresarDatosEmpleado(objEmP);
                        ingresarDatosPlanta(objEmP);
                        objEx.setObjE(objEmP);//POLIMORFISMO
                        objRec.getListaEx().add(objEx);
                    }
                case 2 -> {
                        Empleado_Contratista objEmC = new Empleado_Contratista();
                        ingresarDatosEmpleado(objEmC);
                        ingresarDatosContratista(objEmC);
                        objEx.setObjE(objEmC);//POLIMORFISMO
                        objRec.getListaEx().add(objEx);
                    }
                default -> {
                        objE.mostrar("Error Mensaje no encontrado");
                    }
                }
           }while(objE.validar("¿Desea agregar a otro empleado?"));
            
            objE.mostrar("Datos ingresados satisfactoriamente");
            objE.mostrar(objRec.toString());
            
        }while(!objE.validar("¿Desea terminar el programa"));
    }
}
