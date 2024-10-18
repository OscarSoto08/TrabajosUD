package modelo;
/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * La clase MembresiaDAO proporciona métodos para interactuar con la tabla de membresías en la base de datos.
 */
public class MembresiaDAO {
   /** El objeto de membresía asociado al DAO. */
   Membresia objM;

   /**
     * Constructor de la clase MembresiaDAO que inicializa el objeto de membresía asociado.
     * @param objM El objeto de membresía asociado al DAO.
     */
    public MembresiaDAO(Membresia objM) {
        this.objM = objM;
    }

    /**
     * Método que consulta todas las membresías en la base de datos y las devuelve en un objeto DefaultTableModel.
     * @return Un DefaultTableModel que contiene los datos de las membresías consultadas.
     */
    public DefaultTableModel consultar()
    {
        // Se crea una plantilla para almacenar los datos de las membresías
        DefaultTableModel plantilla = new DefaultTableModel();
        // Se establece una conexión a la base de datos
        ConexionBD con = new ConexionBD();
        
        try {
            // Se realiza la conexión a la base de datos
            con.conectar();
            // Se muestra un mensaje indicando el estado de la conexión
            JOptionPane.showMessageDialog(null, con.getMensaje());
            // Se crea una declaración para ejecutar consultas SQL
            Statement consulta = con.getConexion().createStatement();
            // Se ejecuta una consulta para seleccionar todas las membresías en la tabla 'membresia'
            ResultSet datos = consulta.executeQuery("select * from membresia");
            // Se obtiene información sobre los metadatos de los resultados de la consulta
            ResultSetMetaData campos = datos.getMetaData();
            
            // Se agregan columnas a la plantilla basándose en los metadatos de la consulta
            for(int i = 1; i <= campos.getColumnCount(); i++)
                plantilla.addColumn(campos.getColumnName(i));
            
            // Se determina la cantidad de columnas en los resultados de la consulta
            int cantidadColumnas = campos.getColumnCount();
            // Se itera sobre cada fila en los resultados de la consulta
            while(datos.next())
            {
                // Se crea un arreglo de objetos para almacenar los datos de una fila
                Object fila[] = new Object[cantidadColumnas];
                // Se itera sobre cada columna en la fila actual
                for(int i = 0; i < cantidadColumnas; i++)
                {
                    // Se obtiene el valor de la columna y se agrega al arreglo de fila
                    fila[i] = datos.getObject(i+1);
                }
                // Se agrega la fila a la plantilla
                plantilla.addRow(fila);
            }
            // Se cierran los recursos JDBC (ResultSets, Statements y conexiones)
            datos.close();
            con.getConexion().close();
        } catch (SQLException e) {
            // Se muestra un mensaje de error si ocurre una excepción SQL
            JOptionPane.showMessageDialog(null, e.toString());
        }
        // Se retorna la plantilla que contiene los datos de las membresías consultadas
        return plantilla;
    }    
    
    /**
     * Método que devuelve el objeto de membresía asociado al DAO.
     * @return El objeto de membresía asociado al DAO.
     */
    public Membresia getObjM() {
        return objM;
    }

    /**
     * Método que establece el objeto de membresía asociado al DAO.
     * @param objM El nuevo objeto de membresía asociado al DAO.
     */
    public void setObjM(Membresia objM) {
        this.objM = objM;
    }

    /**
     * Método que devuelve una representación en forma de String del MembresiaDAO.
     * @return Una cadena que representa el MembresiaDAO y su objeto de membresía asociado.
     */
    @Override
    public String toString() {
        return "MembresiaDAO{" + "objM=" + objM + '}';
    }
    
    
}

