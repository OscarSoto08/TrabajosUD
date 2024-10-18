package modelo;
public class Moto extends Vehiculo{
    private int cilindraje;

    public Moto(int cilindraje, String placa, String marca, int modelo, double valor, String tipoVehiculo) {
        super(placa, marca, modelo, valor, tipoVehiculo);
        this.cilindraje = cilindraje;
    }

    public Moto() {
        super();
        cilindraje = 0;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
    @Override   
    public double impuesto(){
        if(cilindraje>=125)
            return valor*0.15;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "\ncilindraje: " + cilindraje;
    }
    
    
}
