package modelo;
/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * La clase PersonaDAO proporciona métodos para interactuar con la base de datos
 * y realizar operaciones relacionadas con la tabla "persona".
 */
public class PersonaDAO {
    /**
     * Objeto Persona asociado al DAO para realizar operaciones.
     */
    Persona objP;

    /**
     * Constructor que recibe un objeto Persona.
     * @param objP Objeto Persona.
     */
    public PersonaDAO(Persona objP) {
        this.objP = objP;
    }
    
    /**
     * Constructor predeterminado que inicializa un objeto Persona.
     */
    public PersonaDAO() {
        this.objP = new Persona();
    }
    
    
    public Persona verificarPersona(String ID) {
        ConexionBD con = new ConexionBD();
        try{
            con.conectar();
            System.out.println(con.getMensaje());
            
            Statement est = con.getConexion().createStatement();
            String consulta = "SELECT * "
                    + "FROM proymembresiagym.persona AS p "
                    + "WHERE p.Id_Cliente = '" + ID + "';";
            ResultSet datos = est.executeQuery(consulta);
            
            int cantidadColumnas = datos.getMetaData().getColumnCount();
            
            Object[] fila = new Object[cantidadColumnas];
            while(datos.next()){
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = datos.getObject(i+1);
                }
            }
            
            String Id_Cliente = (String) fila[0];
            String nombre = (String) fila[1];
            String telefono = (String) fila[2];
            String correo = (String) fila[3];
            String ciudad = (String) fila[4];
            String valorFN = (String) fila[5];
            
            
            ClaseConversor conversor = new ClaseConversor();
            Fecha fecha = conversor.convertirStringAFecha(valorFN);
            
            est.close();
            con.getConexion().close();
            
            return new Persona(Id_Cliente, nombre, telefono, correo, ciudad, fecha);
            
        }catch(SQLException | NullPointerException e){
            JOptionPane.showMessageDialog(null,"Excepcion de verificacion: "+ e.getMessage());
            return null;
        }
    }
    
    /**
     * Realiza una consulta a la base de datos y devuelve un DefaultTableModel
     * con los datos obtenidos de la tabla "persona".
     * @return DefaultTableModel con los datos de la tabla "persona".
     */
    public DefaultTableModel consultar() {
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD con = new ConexionBD();
        
        try {
            con.conectar();
            JOptionPane.showMessageDialog(null, con.getMensaje());
            
            Statement consulta = con.getConexion().createStatement();
            ResultSet datos = consulta.executeQuery("select * from persona");
            ResultSetMetaData campos = datos.getMetaData();
            
            for (int i  = 1; i <= campos.getColumnCount(); i++)
                plantilla.addColumn(campos.getColumnName(i));
           
            int cantidadColumnas = campos.getColumnCount();
            while (datos.next()) {
                Object[] fila = new Object[cantidadColumnas];
                for (int i = 0; i < cantidadColumnas; i++) {
                    fila[i] = datos.getObject(i+1);
                }
                plantilla.addRow(fila);
            }
            
            consulta.close();
            con.getConexion().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return plantilla;
    }
    
     /**
     * Inserta un nuevo registro en la tabla "persona".
     * @return Mensaje indicando el resultado de la operación.
     */
    public String insertar() {
        String mensaje = "";
        
        try {
            ConexionBD conexion = new ConexionBD();
            conexion.conectar();
            
            String comando = "insert into persona(Id_Cliente, nombre, ciudad, correo, telefono, fechaNac) values (" + 
                    " '" + objP.getID() + "', " + 
                    " '" + objP.getNombre() + "', " + 
                    " '" + objP.getCiudad() + "', " + 
                    " '" + objP.getCorreo()  + "', " + 
                    " '" + objP.getTelefono() + "', " + 
                    " '" + objP.getFechaNac().toString() + "')";
            
            Statement consulta = conexion.getConexion().createStatement();
            consulta.execute(comando);
            mensaje = "Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
     
        } catch (SQLException ex) {
            mensaje = "Error al intentar insertar...\n" + ex;
        }
        return mensaje;
    }

    
     /**
     * Elimina un registro de la tabla "persona" según el ID proporcionado.
     * @param persona Objeto Persona que contiene el ID del registro a eliminar.
     * @return Mensaje indicando el resultado de la operación.
     */
    public String eliminar(Persona persona) {
        String mensaje = "";

        try {
            ConexionBD conexion = new ConexionBD();
            conexion.conectar();

            String comando1 = "DELETE FROM `proymembresiagym`.`factura` WHERE Id_Cliente = '" + persona.getID() + "'";
            
            String comando2 = "DELETE FROM `proymembresiagym`.`persona` WHERE Id_Cliente = '" + persona.getID() + "'";

            Statement consulta = conexion.getConexion().createStatement();
            
            FacturaDAO fDao = new FacturaDAO();
            boolean filasAfectadas = false;
            
            if(fDao.buscarFactura(persona.getID()))
               filasAfectadas = consulta.execute(comando1);
            
            filasAfectadas = consulta.execute(comando2);
            
            if (filasAfectadas) {
                mensaje = "Eliminación exitosa.";
            } else {
                mensaje = "Error: No se encontró el registro a eliminar.";
            }

            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
            mensaje = "Error al intentar eliminar...\n" + ex;
        }

        return mensaje;
    }
    /**
     * Actualiza un registro de la tabla "persona".
     * @param persona Objeto Persona con los datos actualizados.
     * @return Mensaje indicando el resultado de la operación.
     */
    public String actualizarPersona(Persona persona) {
        String mensaje = "";
        try {
            ConexionBD conexion = new ConexionBD();
            conexion.conectar();

            String comando = "UPDATE persona SET "
                    + "nombre='" + persona.getNombre() + "', "
                    + "ciudad='" + persona.getCiudad() + "', "
                    + "correo='" + persona.getCorreo() + "', "
                    + "telefono='" + persona.getTelefono() + "', "
                    + "fechaNac='" + persona.getFechaNac().toString() + "' "
                    + "WHERE Id_Cliente='" + persona.getID() + "'";

            Statement consulta = conexion.getConexion().createStatement();
            int filasAfectadas = consulta.executeUpdate(comando);

            if (filasAfectadas > 0) {
                mensaje = "Actualización exitosa.";
            } else {
                mensaje = "Error: No se encontró el registro a actualizar.";
            }

            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
            mensaje = "Error al intentar actualizar...\n" + ex;
        }
        return mensaje;
    }
    /**
     * Devuelve el objeto Persona asociado al DAO.
     * @return Objeto Persona asociado al DAO.
     */
    public Persona getObjP() {
        return objP;
    }
    
    /**
     * Establece un nuevo objeto Persona al DAO.
     * @param objP Nuevo objeto Persona.
     */
    public void setObjP(Persona objP) {
        this.objP = objP;
    }

    
}
