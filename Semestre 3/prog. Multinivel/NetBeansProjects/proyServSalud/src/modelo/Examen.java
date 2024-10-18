/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 *
 * @author Estudiante
 */

public class Examen extends Servicio{

    private char categoria;
    
    public Examen(String codigo, String descripcion, char categoria, double valor) {
        super(codigo, descripcion,valor);
        this.categoria = categoria;
    }

    public Examen() {
        super();
        categoria = 'X';
    }
    
    @Override
    public double valorPago() { 
        return switch (categoria) {
            case 'a', 'A' -> 5000;
            case 'b', 'B' -> 8000;
            case 'c', 'C' -> 15000;
            default -> 20000;
        };
    }

    public char getCategoria() {
        return categoria;
    }

    public void setCategoria(char categoria) {
        this.categoria = categoria;
    }
    
    
    @Override
    public String toString()
    {
        return super.toString() + "\nCategoria: " + categoria;
    }
}
