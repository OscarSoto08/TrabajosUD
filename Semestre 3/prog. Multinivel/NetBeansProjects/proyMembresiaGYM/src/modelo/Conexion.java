package modelo;

import java.io.*;

public class Conexion {
    
    private BufferedReader bufEntrada;
    private PrintWriter bufSalida;
    
    private FileReader flujoLee;
    private FileWriter flujoEscr;

    public Conexion(BufferedReader bufEntrada, PrintWriter bufSalida, FileReader flujoLee, FileWriter flujoEscr) {
        this.bufEntrada = bufEntrada;
        this.bufSalida = bufSalida;
        this.flujoLee = flujoLee;
        this.flujoEscr = flujoEscr;
    }
    
    public Conexion() {
        this.bufEntrada = null;
        this.flujoLee = null;
        this.flujoEscr = null;
        this.bufSalida = null;
    }
    
    public String leerDatos(String nombArchivo) throws IOException{ // El throw es porque el metodo se maneja unicamente si se puede
        this.flujoLee = new FileReader(nombArchivo);
        this.bufEntrada = new BufferedReader(flujoLee);
        String datos="";
        String linea= this.bufEntrada.readLine();
        while(linea!=null){
          datos+=linea+"\n";
          linea=this.bufEntrada.readLine();
        }
        bufEntrada.close();
        return datos;
    }
    
    public void EscribeDatos(String nombArchivo,String datos) throws IOException{
        this.flujoEscr= new FileWriter(nombArchivo, true);
        this.bufSalida= new PrintWriter(flujoEscr);
        bufSalida.println(datos);
        bufSalida.close();
    }
}
