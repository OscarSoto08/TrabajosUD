/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Estudiante
 */
public class Recaudo {
    private ArrayList<Formulario> listF;

    public Recaudo() {
        this.listF = new  ArrayList<Formulario>(); ;
    }

    public Recaudo(ArrayList<Formulario> listF) {
        this.listF = listF;
    }

    public ArrayList<Formulario> getListF() {
        return listF;
    }

    public void setListF(ArrayList<Formulario> listF) {
        this.listF = listF;
    }
    public int cantMotos(){
    int contM=0;
        for (Formulario formulario : listF) {// cada formulario 
            for (Vehiculo objV : formulario.getListaV()) {// lista vehiculos 
                if(objV instanceof Moto)
                    contM++;// busqueda por medio del polimorfismo 
            }
        }
        return contM;
    }
        public int cantAutos(){
    int contA=0;
        for (Formulario formulario : listF) {// cada formulario 
            for (Vehiculo objV : formulario.getListaV()) {// lista vehiculos 
                if(objV instanceof Auto)
                    contA++;// busqueda por medio del polimorfismo 
            }
        }
        return contA;
    }
    
  public double totalRecaudo() {
        double pagoForm=0;
        for (Formulario formulario : listF) {
            pagoForm+=formulario.valorPago();
            
        }
        return pagoForm;
    }
    @Override
    public String toString() {
        String datos="\n";
        for (Formulario formulario : listF) {
            datos+=formulario.toString()+"\n________________________\n";
            
        }
        return "\n Listado Formularios: " + datos;
    }
    
    
}
