/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author FAMILIA
 */
public class Persona {
    private String
            nom,
            tel,
            email;

    public Persona(String nom, String tel, String email) {
        this.nom = nom;
        this.tel = tel;
        this.email = email;
    }
    
    public Persona() {
        this.nom = this.tel = this.email = "";
    }

    @Override
    public String toString() {
        return "Nombre: " + nom +
                "\nTelefono: " + tel + 
                "\nE-Mail" + email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    
}
