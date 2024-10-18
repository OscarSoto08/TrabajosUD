/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiante
 */
public class Auto extends Vehiculo {

    public Auto(String placa, String marca, String tipo, int modelo, double valor) {
        super(placa, marca, tipo, modelo, valor);
    }

    public Auto() {
        super();//llamado al constructor basico del padre 
    }

    @Override
    public double impuesto() {// aplicando polimorfismo ya que el metodo cambia de forma en la clase hija  
    double impuesto=0;
    double total=0;
        if (modelo > 1990){
            impuesto=5;
        }else {
            impuesto=10;  
        }
        total=(valor*impuesto)/100;
        
    return total;
 }
    
    
    
}
