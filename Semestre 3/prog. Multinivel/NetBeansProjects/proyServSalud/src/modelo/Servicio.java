/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.text.NumberFormat;

public abstract class Servicio {
    protected String codigo,
                     descripcion;
    protected double valor;

    public Servicio(String codigo, String descripcion, double valor) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.valor = valor;
    }
    
    public Servicio() {
        this.codigo = "S- "+ Math.round(100 + Math.random()*999);
        this.descripcion = "";
        this.valor = 0;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public abstract double valorPago();
    
    @Override
    public String toString() {
        NumberFormat nf = NumberFormat.getInstance();
        return "Codigo servicio: " + nf.format(codigo) + 
               "\nDescripcion:" + descripcion +
                "\nValor: " + nf.format(valor);
    }
}
