/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class TipoA extends Membresia{

    public TipoA() {
        super();
    }

    public TipoA(String categoria, Double valor) {
        super("A");
        valor = valorPago();
    }
    
    @Override
    public double valorPago() {
        return 65000;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
