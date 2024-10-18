package modelo;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(int cilindraje, String placa, String marca, int modelo, double valor) {
        super(placa, marca, modelo, valor);
        this.cilindraje = cilindraje;
    }

    public Moto() {
        super();
        this.cilindraje = 0;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
    @Override
    public double impuesto() {
        if(cilindraje<=125)
            return this.valor*0.05;
        else
            return 0;
    }

    @Override
    public String toString() {
        return super.toString() + "cilindraje=" + cilindraje;
    }
}
