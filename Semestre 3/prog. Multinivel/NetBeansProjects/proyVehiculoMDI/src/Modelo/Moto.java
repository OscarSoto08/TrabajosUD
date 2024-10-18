/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiante
 */
public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(int cilindraje, String placa, String marca, String tipo, int modelo, double valor) {
        super(placa, marca, tipo, modelo, valor);
        this.cilindraje = cilindraje;
    }
    
    

    public Moto() {
        super();//llamado al constructor basico del padre 
        this.cilindraje =0;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public String toString() {
        return  super.toString()+ "\n cilindraje: " + cilindraje;
    }

    
    @Override
    public double impuesto() {
        if (cilindraje >= 125)   
            return this.valor*0.05;
        else 
            return 0;
    }
    
    
    
}
