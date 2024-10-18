/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.*;

/**
 *
 * @author FAMILIA
 */
public class Conexion {
    protected BufferedReader bufEntrada;
    protected FileReader flujoLee;
    protected FileWriter flujoEscr;
    protected PrintWriter bufSalida;

    public Conexion(BufferedReader bufEntrada, FileReader flujoLee, FileWriter flujoEscr, PrintWriter bufSalida) 
    throws IOException{
        this.bufEntrada = bufEntrada;
        this.flujoLee = flujoLee;
        this.flujoEscr = flujoEscr;
        this.bufSalida = bufSalida;
    }
    
    public Conexion() throws IOException{
        this.bufEntrada = null;
        this.flujoLee = null;
        this.flujoEscr = null;
        this.bufSalida = null;
    }
    
    public String leerDatos() throws IOException
    {
        this.flujoLee = new FileReader("Agenda.txt");
        bufEntrada = new BufferedReader(flujoLee);
        String datos = "";
        String linea = this.bufEntrada.readLine();
        while(linea != null)
        {
            datos += linea+"\n";
            linea = bufEntrada.readLine();
        }
        bufEntrada.close();
        return datos;
    }
    
    public void EscribeDatos(String datos) throws IOException
    {
        flujoEscr = new FileWriter("Agenda.txt",true);
        bufSalida = new PrintWriter(flujoEscr);
        bufSalida.println(datos);
        bufSalida.close();
    }
}
