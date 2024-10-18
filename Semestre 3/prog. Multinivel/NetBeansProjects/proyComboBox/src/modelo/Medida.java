package modelo;

import java.text.DecimalFormat;

public class Medida {
    private double Valor;

    public Medida() {
    }

    public Medida(double Valor) {
        this.Valor = Valor;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    
    public double convertirCM(){
        return this.Valor * 10;
    }
    
    public double convertirDM(){
        return this.Valor * 100;
    }
    
    public double convertirKM(){
        return this.Valor / 1000;
    }
    
    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "Valor: " + df.format(Valor);
    }
    
    
}
