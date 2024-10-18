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
public class Formulario {
    private String CodF;
    private Fecha fN;
    private Persona Propietario;
     private ArrayList<Vehiculo> listaV;

    public Formulario(String CodF, Fecha fN, Persona Propietario, ArrayList<Vehiculo> listaV) {
        this.CodF = CodF;
        this.fN = fN;
        this.Propietario = Propietario;
        this.listaV = listaV;
    }

 
     public Formulario() {
        this.CodF =""+Math.random()*999;
        this.fN = new Fecha();
        this.Propietario = new Persona();
        this.listaV= new ArrayList<Vehiculo> ();
        
    }
     public String datos(){
     String lista="";
         for (Vehiculo objV : listaV) {
             lista+=objV.toString()+"\n Impuesto: "+objV.impuesto();
             
         }
         return lista;
     }
     public Object[] registro(){
         int posReg=this.getListaV().size()-1;
         String tipo=" ";      
         if(this.getListaV().get(posReg) instanceof Auto){
             tipo="Auto";
             
         }else{
         tipo="MOTO";
         }
         Object[] reg={CodF,this.fN.toString(),
         this.getPropietario().getId(),tipo,
         this.getListaV().get(posReg).getPlaca(),
         this.getListaV().get(posReg).impuesto()};
 
         return reg;
     }
        public double valorPago(){
     double pagoImpuesto=0;
         for (Vehiculo objV : listaV) {
             pagoImpuesto+=objV.impuesto();
             
         }
         return pagoImpuesto;
     }
     public Formulario(int tipoV) {
        this.CodF =""+Math.random()*999;
        this.fN = new Fecha();
        this.Propietario = new Persona();
        switch (tipoV){
            //polimorfismo por que auto se convierte e4n vehiculo  
         case 1 -> this.listaV.add(new Auto());
             //polimorfismo por que moto se convierte e4n vehiculo  
         case 2 -> this.listaV.add(new Moto());
     }
     }    
     
    public String getCodF() {
        return CodF;
    }

    public void setCodF(String CodF) {
        this.CodF = CodF;
    }

    public Fecha getfN() {
        return fN;
    }

    public void setfN(Fecha fN) {
        this.fN = fN;
    }

    public Persona getPropietario() {
        return Propietario;
    }

    public void setPropietario(Persona Propietario) {
        this.Propietario = Propietario;
    }

    public ArrayList<Vehiculo> getListaV() {
        return listaV;
    }

    public void setListaV(ArrayList<Vehiculo> listaV) {
        this.listaV = listaV;
    }


    @Override
    public String toString() {
        return " Datos Factura " + "\n Codigo Factura: " + CodF + "\n Fecha factura: " + fN.toString() + "\n Propietario: " + Propietario.toString() + "\n Vehiculo: \n" + datos();
    }
    
}
