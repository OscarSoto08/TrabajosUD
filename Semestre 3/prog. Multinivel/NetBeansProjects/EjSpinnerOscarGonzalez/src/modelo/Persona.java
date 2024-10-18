/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author FAMILIA
 */
public class Persona {
    private String
            nombre,
            id,
            estado;
    private double peso, 
                           altura,
                            IMC;

    public Persona(String nombre, String id, String estado, double peso, double altura, double IMC) {
        this.nombre = nombre;
        this.id = id;
        this.estado = estado;
        this.peso = peso;
        this.altura = altura;
        this.IMC = IMC;
    }
    
    public Persona() {
        this.nombre = this.estado = "";
        this.id = ""+ Math.round(100+Math.random()*999);
        this.peso = this.altura = this.IMC = 0;
    }

    public double getIMC() {
        return IMC;
    }

    public void setIMC(double IMC) {
        this.IMC = IMC;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularIMC()
    {
        return peso/(altura*altura);
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + 
                "\nIdentificación: " + id + 
                "\nPeso: " + peso + 
                "\nAltura (CM): " + altura;
    }
}
