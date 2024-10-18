package modelo;

public abstract class Vehiculo {
    protected String placa, marca;
    protected int modelo;
    protected double valor;

    public Vehiculo(String placa, String marca, int modelo, double valor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
    }

    public Vehiculo() {
        this.placa = this.marca = "";
        this.modelo = 0;
        this.valor = 0;
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
    
    public abstract double impuesto();

    @Override
    public String toString() {
        return "placa =" + placa + ", marca =" + marca + ", modelo =" + modelo + ", valor =" + valor;
    }
    
    
}
