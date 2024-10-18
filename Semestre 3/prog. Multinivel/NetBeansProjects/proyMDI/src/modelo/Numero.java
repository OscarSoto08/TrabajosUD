/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author FAMILIA
 */
public class Numero {
    private int valor;

    public Numero(int valor) {
        this.valor = valor;
    }
    
    public Numero() {
        this.valor = 0;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public double Suma(int val)
    {
        return valor+val;
    }
    
    public double Potencia(int exp)
    {
        double resultado = 1;
        
        if(exp < 0)
        {
            while(exp < 0)
            {
                resultado *= valor;
                exp++;
            }
            return 1/resultado;
        }
        
        while(exp-- >0)
        {
            resultado *=  valor;
        }
        return resultado;
    }
    public double resta(int restando)
    {
        return valor - restando;
    }
    @Override
    public String toString() {
        return "Valor: " + valor;
    }
}
