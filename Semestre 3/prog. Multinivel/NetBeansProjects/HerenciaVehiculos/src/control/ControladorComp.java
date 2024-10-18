package control;
import modelo.*;
import Vista.*;

public class ControladorComp {
    private Formulario objF;
    private CajasMensaje mensaje;

    public ControladorComp(Formulario objFormulario, CajasMensaje mensaje) {
        this.objF = objFormulario;
        this.mensaje = mensaje;
    }
    
    public ControladorComp() {
        objF = new Formulario();
        mensaje = new CajasMensaje();
    }
    
   
    
    private void ingresarDatosPropietario() {
        objF.getPropietario().setNom(mensaje.leerTexto("Nombre: "));
        objF.getPropietario().setId(mensaje.leerTexto("Id: "));
        objF.getPropietario().setTel(mensaje.leerTexto("Telefono: "));
        objF.getPropietario().setEmail(mensaje.leerTexto("Email: "));
        String fecha[]= mensaje.leerTexto("Fecha del Registro (dd/mm/aa): ").split("/");
        objF.getPropietario().setfNac(new Fecha(Integer.parseInt(fecha[0]),
                                                    Integer.parseInt(fecha[1]),
                                                    Integer.parseInt(fecha[2])));
    }
    
    
    public void iniciar(){
        
        do {
           mensaje.setTitulo("DATOS PROPIETARIO");
           ingresarDatosPropietario();
           mensaje.setTitulo("DATOS VEHICULO");
           
           int op = mensaje.leerEntero("Indique el tipo de vehiculo \n1.Auto\n2.Moto");
            switch (op) {
                case 1:
                    Auto objA = new Auto();
                    objA.setPlaca(mensaje.leerTexto("Placa: "));
                    objA.setMarca(mensaje.leerTexto("Marca: "));
                    objA.setModelo(mensaje.leerEntero("Modelo: "));
                    objA.setValor(mensaje.leerDouble("Valor: "));
                    objF.getListaV().add(objA);//polimorfismo
                    break;
                    
                case 2:
                    Moto objM = new Moto();
                    objM.setPlaca(mensaje.leerTexto("Placa: "));
                    objM.setPlaca(mensaje.leerTexto("Marca: "));
                    objM.setModelo(mensaje.leerEntero("Modelo: "));
                    objM.setCilindraje(mensaje.leerEntero("Cilindraje: "));
                    objM.setValor(mensaje.leerDouble("Valor: "));
                    
                    objF.getListaV().add(objM);
//objF.setObjV(objM);//polimorfismo
                    
                    break;
                    
                default:
                    mensaje.mostrar("Error: Tipo no encontrado...");
            }
           mensaje.mostrar("Datos registrados");
           mensaje.mostrar(objF.toString()+ "Valor impuesto:" + objF.valorPago());
                                                    
        } while(mensaje.validar("¿Desea terminar el programa?"));
        
        
    }
}
