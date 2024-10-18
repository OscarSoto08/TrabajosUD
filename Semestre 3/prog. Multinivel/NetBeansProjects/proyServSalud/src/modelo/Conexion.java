/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.*;

/**
 *
 * @author FAMILIA
 */
public class Conexion {
    
    FileReader flujoLee;
    FileWriter flujoEscr;
    BufferedReader buffEntrada;
    PrintWriter buffSalida;

    public Conexion() {
        this.flujoLee = null;
        this.flujoEscr = null;
        this.buffEntrada = null;
        this.buffSalida = null;
    }
    
    public String leerDatos() throws IOException{
        this.flujoLee = new FileReader("Servicios.txt");
        this.buffEntrada = new BufferedReader(flujoLee);
        String datos = "";
        String linea = this.buffEntrada.readLine();
        while(linea != null)
        {
            datos += linea+"\n";
            linea = this.buffEntrada.readLine();
        }
        this.buffEntrada.close();
        return datos;
    }
    
    public void escribeDatos(String nombreArchivo, String datos) throws IOException
    {
        this.flujoEscr = new FileWriter(nombreArchivo, true);
        this.buffSalida = new PrintWriter(flujoEscr);
        this.buffSalida.println(datos);
        this.buffSalida.close();
    }
}
