package modelo;

import java.util.ArrayList;

public class Recaudo {
    private ArrayList<Formulario> listaF;

    public Recaudo(ArrayList<Formulario> listaF) {
        this.listaF = listaF;
    }

    public Recaudo() {
        this.listaF = new ArrayList<>();
    }
    
    public ArrayList<Formulario> getListaF() {
        return listaF;
    }

    public void setListaF(ArrayList<Formulario> listaF) {
        this.listaF = listaF;
    }
    
    public String datos()
    {
        String listado = "";
        for (Formulario formulario : listaF) {
            listado += formulario.toString()+"\n";
        }
        return listado;
    }

    public double totalRecaudo()
    {
        double valor = 0;
        for (Formulario formulario : listaF) {
            valor += formulario.valorPago();
        }
        return valor;
    }

    public int cantAutos()
    {
        int cant = 0;
        for (Formulario formulario : listaF) {
            for (Vehiculo objV : formulario.getListaV()) {
                if(objV instanceof Auto)
                    cant+=1;
            }
        }
        return cant;
    }
    
    
    public int cantMotos()
    {
        int cant = 0;
        for (Formulario formulario : listaF) {
            for (Vehiculo objV : formulario.getListaV()) {
                if(objV instanceof Moto)
                    cant+=1;
            }
        }
        return cant;
    }
    
    @Override
    public String toString() {
        return "Listado recaudo: " + datos();
    }
    
    
}
