package modelo;
public class Auto extends Vehiculo{

    public Auto(String placa, String marca, int modelo, double valor, String tipoVehiculo) {
        super(placa, marca, modelo, valor, tipoVehiculo);
    }
    
    public Auto() {
        super();
    }
    
    @Override   
    public double impuesto(){
        if(modelo<1990)
            return valor*0.05;
        else
            return valor*0.1;
    }

    @Override
    public String datosArch() {
        return
                "Auto;"+placa+";"+marca+";"+modelo+";0;"+valor;
    }
}
