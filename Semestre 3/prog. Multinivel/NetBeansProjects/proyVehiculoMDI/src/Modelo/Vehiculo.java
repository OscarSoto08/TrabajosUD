/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.DecimalFormat;

/**
 *
 * @author User
 */
public abstract class Vehiculo {
    protected String placa,marca,tipo;
    protected int modelo;
    protected double valor;

    public Vehiculo(String placa, String marca,String tipo, int modelo, double valor) {
        this.placa = placa;
        this.marca = marca;
        this.tipo=tipo;
        this.modelo = modelo;
        this.valor = valor;
    }

    public Vehiculo() {
        this.placa="";
        this.marca="";
        this.tipo=" ";
        this.modelo=0;
        this.valor=0;
        
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public DecimalFormat getDf() {
        return df;
    }

    public void setDf(DecimalFormat df) {
        this.df = df;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    DecimalFormat df= new DecimalFormat("#,###.00");
    @Override
    public String toString() {
        return  "\n placa=" + placa + "\n marca=" + marca + "\n modelo=" + modelo + "\n valor=" +df.format( valor);
    }
public abstract double impuesto();

    
    
  
    
    
}
