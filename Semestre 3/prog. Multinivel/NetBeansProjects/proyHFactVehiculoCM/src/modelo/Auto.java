package modelo;

public class Auto extends Vehiculo {
    

    public Auto(int cilindraje, String placa, String marca, int modelo, double valor) {
        super(placa, marca, modelo, valor);
    }

    public Auto() {
        super();
    }

    
    @Override
    public double impuesto() {
        if(modelo>1990)
            return this.valor*0.05;
        else
            return this.valor*0.1;
    }
}
