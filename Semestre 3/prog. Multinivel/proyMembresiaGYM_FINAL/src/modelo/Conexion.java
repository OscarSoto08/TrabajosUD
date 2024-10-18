package modelo;
/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 * @author Sonia Pinzon
 * @see control.Controlador_Consulta
 */

import java.io.*;

/*Clase que nos permite hacer la conexion de archivos 
para manipularlos en nuestro proyecto y utilizada en Controlador_Consulta
para traer datos de archivos .txt*/

/**
 *
 * @author PC
 */

public class Conexion {
    
    /*variable de bufEntrada que permite que los datos se traigan*/
    private BufferedReader bufEntrada;
    /* BufferedReader que permite leer datos desde un archivo
    pero no va a ser utilizada en el modelo ya que es una clase 
    recopilada de @author Sonia Pinzon*/
    
    /** PrintWriter que permite escribir datos en un archivo.
     * Esta funcionalidad no está siendo utilizada actualmente en el modelo.*/
    private PrintWriter bufSalida;
    
    
    /** FileReader que permite leer caracteres desde un archivo. */
    private FileReader flujoLee;
    
    /** FileWriter que permite escribir caracteres en un archivo. */
    private FileWriter flujoEscr;

    
    /**
     * Constructor de la clase Conexion.
     * @param bufEntrada BufferedReader para leer datos desde un archivo.
     * @param bufSalida PrintWriter para escribir datos en un archivo.
     * @param flujoLee FileReader para leer caracteres desde un archivo.
     * @param flujoEscr FileWriter para escribir caracteres en un archivo.
     */
    public Conexion(BufferedReader bufEntrada, PrintWriter bufSalida, FileReader flujoLee, FileWriter flujoEscr) {
        this.bufEntrada = bufEntrada;
        this.bufSalida = bufSalida;
        this.flujoLee = flujoLee;
        this.flujoEscr = flujoEscr;
    }
    
    /**
     * Constructor vacío de la clase Conexion.
     * Se inicializan los atributos en null.
     */
    public Conexion() {
        this.bufEntrada = null;
        this.flujoLee = null;
        this.flujoEscr = null;
        this.bufSalida = null;
    }
    
    
    /**
     * Método que lee los datos desde un archivo.
     * @param nombArchivo Nombre del archivo del cual leer los datos.
     * @return Los datos leídos del archivo en forma de String.
     * @throws IOException Si hay un error al leer el archivo.
     */
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
    
    /**
     * Método que escribe datos en un archivo.
     * @param nombArchivo Nombre del archivo en el cual escribir los datos.
     * @param datos Datos a escribir en el archivo.
     * @throws IOException Si hay un error al escribir en el archivo.
     */
    public void EscribeDatos(String nombArchivo,String datos) throws IOException{
        this.flujoEscr= new FileWriter(nombArchivo, true);
        this.bufSalida= new PrintWriter(flujoEscr);
        bufSalida.println(datos);
        bufSalida.close();
    }
}
