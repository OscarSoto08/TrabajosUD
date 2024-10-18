/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


/**
 *
 * @author FAMILIA
 */
public class Hospitalizacion extends Servicio{

    private int diasHosptalizacion;
    private String tipoHabitacion;

    public Hospitalizacion(int diasHosptalizacion, String tipoHabitacion, String codigo, String descripcion, double valor) {
        super(codigo, descripcion, valor);
        this.diasHosptalizacion = diasHosptalizacion;
        this.tipoHabitacion = tipoHabitacion;
    }

    public Hospitalizacion() {
        super();
        this.diasHosptalizacion = 0;
        this.tipoHabitacion = "";
    }

    public int getDiasHosptalizacion() {
        return diasHosptalizacion;
    }

    public void setDiasHosptalizacion(int diasHosptalizacion) {
        this.diasHosptalizacion = diasHosptalizacion;
    }

    public String getTipoHospitalizacion() {
        return tipoHabitacion;
    }

    public void setTipoHospitalizacion(String tipoHospitalizacion) {
        this.tipoHabitacion = tipoHospitalizacion;
    }
    
    
    @Override
    public double valorPago() {
        /*
            
        */
        return diasHosptalizacion * switch(tipoHabitacion)
        {
            case "Estandar" -> 1000;
            case "Semi-privada" -> 2000;
            case "Privada" -> 3000;
            default -> 1500;
        };
    }

    @Override
    public String toString() {
        return super.toString() + 
                "\nDias Hosptalizacion: " + diasHosptalizacion + 
                "\nTipo Habitacion: " + tipoHabitacion;
    }
}
