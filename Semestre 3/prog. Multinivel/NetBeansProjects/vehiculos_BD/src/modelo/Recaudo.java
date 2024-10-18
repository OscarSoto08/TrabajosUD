package modelo;

import java.util.ArrayList;

public class Recaudo {
    private ArrayList<Factura> listaF;

    public Recaudo(ArrayList<Factura> listaF) {
        this.listaF = listaF;
    }

    public Recaudo() {
        this.listaF = new ArrayList<>();
    }
    
    public ArrayList<Factura> getListaF() {
        return listaF;
    }

    public void setListaF(ArrayList<Factura> listaF) {
        this.listaF = listaF;
    }
    
    public String datos()
    {
        String listado = "";
        for (Factura formulario : listaF) {
            listado += formulario.toString()+"\n";
        }
        return listado;
    }

    public double totalRecaudo()
    {
        double valor = 0;
        for (Factura formulario : listaF) {
            valor += formulario.valorPago();
        }
        return valor;
    }

    public int cantAutos()
    {
        int cant = 0;
        for (Factura formulario : listaF) {
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
        for (Factura formulario : listaF) {
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
