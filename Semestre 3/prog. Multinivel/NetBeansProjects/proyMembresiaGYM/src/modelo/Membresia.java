/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package modelo;

/**
 *
 * @author FAMILIA
 */

public abstract class Membresia {
    protected String categoria;
    
    public Membresia(String categoria) {
        this.categoria = categoria;
    }

    public Membresia() {
        this.categoria = "X";
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    

    public abstract double valorPago();
    
    @Override
    public String toString() {
                return  "\nCategoria: " + categoria;
    }
}
