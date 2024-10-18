/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Ing. Sonia Pinzón
 */
public class Conexion {
    private BufferedReader bufEntrada;
    private FileReader flujoLee;
    private FileWriter flujoEscr;
    private PrintWriter bufSalida;

    public Conexion(BufferedReader bufEntrada, FileReader flujoLee, FileWriter flujoEscr, PrintWriter bufSalida) {
        this.bufEntrada = bufEntrada;
        this.flujoLee = flujoLee;
        this.flujoEscr = flujoEscr;
        this.bufSalida = bufSalida;
    }
    public Conexion() {
        this.bufEntrada = null;
        this.flujoLee = null;
        this.flujoEscr = null;
        this.bufSalida = null;
    }
    public String leerDatos() throws IOException{
        this.flujoLee= new FileReader("agenda.txt");
        bufEntrada= new BufferedReader(flujoLee);
        String datos="";
        String linea= this.bufEntrada.readLine();
        while(linea!=null){
          datos+=linea+"\n";
          linea=this.bufEntrada.readLine();
        }
        bufEntrada.close();
        return datos;
    }
    public void EscribeDatos(String datos) throws IOException{
     flujoEscr= new FileWriter("agenda.txt", true);
     bufSalida= new PrintWriter(flujoEscr);
     bufSalida.println(datos);
     bufSalida.close();
    }
}
