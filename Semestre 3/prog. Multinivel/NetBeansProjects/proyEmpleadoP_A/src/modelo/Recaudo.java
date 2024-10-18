package modelo;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class Recaudo {
    private ArrayList<Extracto> ListaEx;

    public Recaudo(ArrayList<Extracto> ListaEx) {
        this.ListaEx = ListaEx;
    }
    
    public Recaudo() {
        this.ListaEx = new ArrayList<>();
    }

    public ArrayList<Extracto> getListaEx() {
        return ListaEx;
    }

    public void setListaEx(ArrayList<Extracto> ListaEx) {
        this.ListaEx = ListaEx;
    }
    
    public double totalRecaudo()
    {
        double suma = 0;
        for(Extracto objE : ListaEx)
        {
            suma += objE.getObjE().ValorPago();
        }
        return suma;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return "\n-----------------------------------------------------------"+
                    datos() + 
                "\n\n-----------------------------------------------------------"+
                "\n-) Recaudo TOTAL: " + df.format(totalRecaudo())+
                "\n-----------------------------------------------------------";
    }
    
    public String datos()
    {
        String dato = "";
        for(Extracto obj: ListaEx)
        {
            dato += obj.toString();
        }
        return dato;
    }
}
