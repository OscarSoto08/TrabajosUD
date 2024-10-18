/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Calendar;

/**
 *
 * @author User
 */
public class Persona {
    private String Nom,Id;
    private Fecha fN;

     public Persona() {
        this.Nom = "";
        this.Id = "";
        this.fN = new Fecha();
    }
    
    public Persona(String Nom, String id, Fecha f) {
        this.Nom = Nom;
        this.Id = id;
        this.fN = f;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public Fecha getfN() {
        return fN;
    }

    public void setfN(Fecha fN) {
        this.fN = fN;
    }

    @Override
    public String toString() {
        return  "\n Identificacion: " + Id +"\n Nombre: " + Nom  +"\n fecha de nacimiento: " + fN.toString();
    }
    
    public int edad(){
   //completar codigo que incluya mes y dia de edad 
    return this.fN.CalcularAa(this.fN.getAa());    
    }
    
}