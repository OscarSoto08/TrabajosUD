/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author FAMILIA
 */
public class Recaudo {
    private ArrayList<Factura_Gym> listaF;

    public Recaudo(ArrayList<Factura_Gym> listaF) {
        this.listaF = listaF;
    }
    
    public Recaudo() {
        this.listaF = new ArrayList<>();
    }

    public ArrayList<Factura_Gym> getListaF() {
        return listaF;
    }

    public void setListaF(ArrayList<Factura_Gym> listaF) {
        this.listaF = listaF;
    }
    
    public String datos()
    {
        String datos = "";
            for (Factura_Gym factura : listaF) {
                datos += factura.toString();
        }
        return datos;
    }
    
    public double valorPago()
    {
        double datos = 0;
        
            for (Factura_Gym factura : listaF) {
                datos += factura.getMemb().valorPago();
        }
        return datos;
    }

    @Override
    public String toString() {
        return datos();
    }
    
}
