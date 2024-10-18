package Vista;

import java.util.Scanner;

public class Entrada {
    private Scanner ent;

    public Scanner getEnt() {
        return ent;
    }

    public void setEnt(Scanner ent) {
        this.ent = ent;
    }

    public Entrada() {
        this.ent = new Scanner(System.in);
    }

    public Entrada(Scanner ent) {
        this.ent = ent;
    }
    
    public int leerEntero(String msg)
    {
        System.out.println(msg);
        return(ent.nextInt());
    }
    
    public String leerTexto(String msg)
    {
        System.out.println(msg);
        return(ent.next());
    }
    
    public double leerDecimal(String msg)
    {
        System.out.println(msg);
        return (ent.nextDouble());
    }
    
    public void mostrar(String msg)
    {
        System.out.println(msg);
    }
    
    public boolean validar(String msg)
    {
        System.out.println(msg);
        char band = ent.next().charAt(0);
            return ((band == 's') || (band == 'S'));
    }
}
