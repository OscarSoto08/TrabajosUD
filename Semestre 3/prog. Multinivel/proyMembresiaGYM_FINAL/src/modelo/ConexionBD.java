/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 * @author Sonia Pinzon
 */
package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sonia Pinzón
 */
/**
 * La clase ConexionBD permite establecer una conexión con una base de datos MySQL.
 * Se utiliza el controlador JDBC de MySQL para establecer la conexión.
 * 
 * La autora de esta clase es Sonia Pinzón.
 */
public class ConexionBD {
    /** Objeto Connection que representa la conexión con la base de datos. */
    private Connection conexion;
    /** Nombre de la base de datos a la que se desea conectar. */
    private String bd;
    /** Usuario de la base de datos. */
    private String usuario;
    /** Clave del usuario de la base de datos. */
    private String clave;
    /** Mensaje que indica el estado de la conexión. */
    private String mensaje;
    /**
     * Constructor de la clase ConexionBD.
     * Establece los valores predeterminados para la conexión a la base de datos.
     */
    public ConexionBD() {
        this.conexion = null;
        this.bd = "proymembresiagym";
        this.usuario = "root";
        this.clave = "123456";
        this.mensaje = "";
    }

    /**
     * Método que establece la conexión con la base de datos utilizando los valores proporcionados.
     */
    public void conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String ruta = "jdbc:mysql://127.0.0.1:3306/" + bd;
            System.out.println(ruta);
            conexion = DriverManager.getConnection(ruta, usuario, clave);
            if (conexion != null) {
                mensaje = "Conexion establecida con éxito...";
            } else {
                mensaje = "No se pudo establecer conexión...";
            }
        } catch (ClassNotFoundException ex) {
            mensaje = "No se pudo establecer conexión...";
        } catch (SQLException ex) {
            mensaje = "No se puede conectar con MySQL...";
        }
    }

    /**
     * Método que devuelve una representación en forma de String de la conexión.
     * @return Una representación en forma de String de la conexión.
     */
    @Override
    public String toString() {
        return "Conexion{" + "conexion=" + conexion + ", bd=" + bd + ", usuario=" + usuario + ", clave=" + clave + ", mensaje=" + mensaje + '}';
    }

    /**
     * Método que devuelve la conexión con la base de datos.
     * @return La conexión con la base de datos.
     */
    public Connection getConexion() {
        return conexion;
    }

    /**
     * Método que establece la conexión con la base de datos.
     * @param conexion La nueva conexión con la base de datos.
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * Método que devuelve el nombre de la base de datos.
     * @return El nombre de la base de datos.
     */
    public String getBd() {
        return bd;
    }

    /**
     * Método que establece el nombre de la base de datos.
     * @param bd El nuevo nombre de la base de datos.
     */
    public void setBd(String bd) {
        this.bd = bd;
    }

    /**
     * Método que devuelve el usuario de la base de datos.
     * @return El usuario de la base de datos.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Método que establece el usuario de la base de datos.
     * @param usuario El nuevo usuario de la base de datos.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Método que devuelve la clave del usuario de la base de datos.
     * @return La clave del usuario de la base de datos.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Método que establece la clave del usuario de la base de datos.
     * @param clave La nueva clave del usuario de la base de datos.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Método que devuelve el mensaje que indica el estado de la conexión.
     * @return El mensaje que indica el estado de la conexión.
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * Método que establece el mensaje que indica el estado de la conexión.
     * @param mensaje El nuevo mensaje que indica el estado de la conexión.
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }  
}
