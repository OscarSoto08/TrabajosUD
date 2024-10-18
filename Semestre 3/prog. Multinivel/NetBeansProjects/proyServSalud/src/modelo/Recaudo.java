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
    private ArrayList<Factura> listaF;

    public Recaudo() {
        this.listaF = new ArrayList<>();
    }

    public Recaudo(ArrayList<Factura> listaF) {
        this.listaF = listaF;
    }

    public ArrayList<Factura> getListaF() {
        return listaF;
    }

    public void setListaF(ArrayList<Factura> listaF) {
        this.listaF = listaF;
    }
    
    public String datos()
    {
        String datos = "";
        for (Factura factura : listaF) {
            datos += factura.toString();
        }
        return datos;
    }
    
    public double valorPago()
    {
        double valor = 0;
        for (Factura factura : listaF) {
            valor += factura.getObjS().valorPago();
        }
        return valor;
    }

    @Override
    public String toString() {
        return datos();
    }
}
