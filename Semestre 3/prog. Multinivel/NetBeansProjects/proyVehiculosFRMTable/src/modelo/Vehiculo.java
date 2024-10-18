package modelo;

import java.text.DecimalFormat;

public abstract class Vehiculo {
    protected String placa, marca;
    protected int modelo;
    protected double valor;
    protected String tipoVehiculo;

    public Vehiculo(String placa, String marca, int modelo, double valor, String tipoVehiculo) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Vehiculo() {
        this.placa = "";
        this.marca = "";
        this.modelo = 0;
        this.valor = 0;
        this.tipoVehiculo = "";
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
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

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat();
        return "\n\nTipo de vehiculo: " +  tipoVehiculo +
                "\nPlaca: " + placa + 
                "\nMarca:" + marca + 
                "\nModelo:" + modelo + 
                "\nValor:" + df.format(valor);
    }
    
    public abstract double impuesto();
    
}
