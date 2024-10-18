package Vista;

import java.util.Scanner;

public class EntradaE {
    private Scanner ent;

    public EntradaE(Scanner ent) {
        this.ent = ent;
    }

    public EntradaE() {
        this.ent = new Scanner(System.in);
    }
    
    public double leerDecimal(String msj)
    {
        System.out.println(msj);
        return ent.nextDouble();
    }
    
    public String leerTexto(String msj)
    {
        System.out.println(msj);
        return ent.next();
    }
    
    public void mostrar(String msj)
    {
        System.out.println(msj);
    }
}
