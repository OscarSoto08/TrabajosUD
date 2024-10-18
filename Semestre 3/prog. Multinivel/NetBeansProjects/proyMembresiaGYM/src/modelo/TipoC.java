/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class TipoC extends Membresia{
    
    public TipoC() {
        super();
    }

    public TipoC(char categoria, Double valor) {
        super("C");
        valor = valorPago();
    }
    
    @Override
    public double valorPago() {
        return 300000;
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
