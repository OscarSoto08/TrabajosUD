/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class TipoB extends Membresia{
    
    public TipoB() {
        super();
    }

    public TipoB(char categoria, Double valor) {
        super("B");
        valor = valorPago();
    }
    
    @Override
    public double valorPago() {
        return 250000;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
