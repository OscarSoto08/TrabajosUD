/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import java.util.Scanner;

/**
 *
 * @author UD
 */
public class Entrada {
     private Scanner entrada;

    public Entrada( Scanner entrada) {
        this.entrada = entrada;
    }
     public Entrada() {
        this.entrada = new Scanner(System.in);
    }

    public Scanner getEntrada() {
        return entrada;
    }

    public void setEntrada(Scanner entrada) {
        this.entrada = entrada;
    }
     public int leerEntero(String msg){
         System.out.println(msg);
         return entrada.nextInt();
     }
     public double leerDecimal(String msg){
         System.out.println(msg);
         return entrada.nextDouble();
     }
     public String leerTexto(String msg){
         System.out.println(msg);
         return entrada.next();
     }
     public void mostrar(String msg){
         System.out.println(msg);
     }
     
}
