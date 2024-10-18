/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author FAMILIA
 */
public class Conversion_Unidades {
    private double valorCM;

    public Conversion_Unidades(double valorCM) {
        this.valorCM = valorCM;
    }
    
    public Conversion_Unidades() {
        this.valorCM = 0;
    }

    public double getValorCM() {
        return valorCM;
    }

    public void setValorCM(double valorCM) {
        this.valorCM = valorCM;
    }
    
    public double convertirValor()
    {
        return valorCM / 100;
    }

    @Override
    public String toString() {
        return "Valor en metros: "+ convertirValor();
    }
}
