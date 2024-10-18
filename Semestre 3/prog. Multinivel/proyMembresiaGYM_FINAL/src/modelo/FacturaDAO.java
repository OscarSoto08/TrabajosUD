package modelo;
/**
 * @author Daniel López Valderrama
 * @author Oscar Gonzalez Soto
 */
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * La clase FacturaDAO permite realizar operaciones de consulta, inserción, 
 * eliminación y actualización en la base de datos relacionadas con las 
 * facturas de gimnasio.
 */
public class FacturaDAO {
    /** Objeto Factura_Gym utilizado para operaciones de manipulación de datos. */
    private Factura_Gym objF;

    
    /**
     * Constructor de la clase FacturaDAO.
     * @param objP Objeto Factura_Gym utilizado para operaciones de manipulación de datos.
     */
    public FacturaDAO(Factura_Gym objP) {
        this.objF = objP;
    }
    
    /**
     * Constructor vacío de la clase FacturaDAO.
     * Se inicializa un nuevo objeto Factura_Gym.
     */
    public FacturaDAO() {
        this.objF = new Factura_Gym();
    }
    
    
    public boolean buscarFactura(String ID){
        String mensaje = "";
        try {
            ConexionBD con = new ConexionBD();
            con.conectar();
            System.out.println(con.getMensaje());
            
            String consultatxt = "DELETE FROM `proymembresiagym`.`factura_gym` as fg WHERE (`Id_Cliente` = '"+ID+"');";
            Statement st = con.getConexion().createStatement();
            boolean resultado = st.execute(consultatxt);
            con.getConexion().close();
            st.close();
        } catch (SQLException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * Método que realiza una consulta a la base de datos y devuelve los resultados en forma de DefaultTableModel.
     * @return Un DefaultTableModel que contiene los resultados de la consulta.
     */
    public DefaultTableModel consultar() {
        DefaultTableModel plantilla = new DefaultTableModel();
        ConexionBD con = new ConexionBD();
        try {
            con.conectar();
            JOptionPane.showMessageDialog(null, con.getMensaje());
            Statement consulta = con.getConexion().createStatement();
            ResultSet datos = consulta.executeQuery("SELECT * FROM factura_gym");
            ResultSetMetaData campos = datos.getMetaData();
            for (int i = 1; i <= campos.getColumnCount(); i++) {
                plantilla.addColumn(campos.getColumnName(i));
            }
            while (datos.next()) {
                Object fila[] = new Object[campos.getColumnCount()];
                for (int i = 0; i < campos.getColumnCount(); i++) {
                    fila[i] = datos.getObject(i + 1);
                }
                plantilla.addRow(fila);
            }
            
            consulta.close();
            con.getConexion().close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return plantilla;
    }

    /**
     * Método que inserta un nuevo registro en la base de datos.
     * @return Un mensaje indicando si la inserción fue exitosa o si ocurrió un error.
     */
    public String insertar() {
        String mensaje = "";
        try {
            ConexionBD conexion = new ConexionBD();
            Statement consulta = null;
            conexion.conectar();
            String categoria = "";
            if (objF.getMemb() instanceof TipoA) {
                categoria = "A";
            } else if (objF.getMemb() instanceof TipoB) {
                categoria = "B";
            } else {
                categoria = "C";
            }

            String comando = "INSERT INTO factura_gym (idFact, fechaF, Id_Cliente, Id_Membresia) VALUES ("
                    + "'" + objF.getIdFact() + "', "
                    + "'" + objF.getFechaF().toString() + "', "
                    + "'" + objF.getCliente().getID() + "', "
                    + "'" + categoria + "')";
            consulta = conexion.getConexion().createStatement();
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
     * Método que elimina un registro de la base de datos.
     * @param factura
     * @return Un mensaje indicando si la eliminación fue exitosa o si ocurrió un error.
     */
    
    
    public String eliminarObjeto(Factura_Gym factura){
        String mensaje = "";
        try{
           ConexionBD con = new ConexionBD();
           con.conectar();
           Statement stat = con.getConexion().createStatement();

           String consulta = "DELETE FROM `proymembresiagym`.`factura_gym` WHERE (`idFact` = '"+factura.getIdFact()+"');";
           ResultSet datos = stat.executeQuery(consulta);
           
           stat.close();
           con.getConexion().close();
        }catch(SQLException ex){
            mensaje = "Error al intentar eliminar..."+ex;
        }
        return mensaje;
    }
    
    /**
     * Método que actualiza un registro en la base de datos.
     * @param objAct Objeto con los datos actualizados.
     * @return Un mensaje indicando si la actualización fue exitosa o si ocurrió un error.
     */
    public String actualizarObjeto(Object objAct){
        String mensaje = "";
        try{
            ConexionBD conexion = new ConexionBD();
            Statement consulta = null;
            conexion.conectar();
            
            if(objAct instanceof Membresia){
                if(objAct instanceof TipoA){
                    TipoA tipo = (TipoA) objAct;
                }else if(objAct instanceof TipoB){
                    TipoB tipo = (TipoB) objAct;
                }else if(objAct instanceof TipoC){
                    TipoC tipo = (TipoC) objAct;
                }
                String instruccion = "update membresia " + 
                "set Valor_Pago=" + ((Membresia) objAct).valorPago() + 
                "where Id_Membresia= '" + ((Membresia) objAct).getCategoria()+"'";
                consulta = conexion.getConexion().createStatement();
                consulta.executeUpdate(instruccion);    
                mensaje = "La Membresia fue actualizada de valor correctamente...";
                consulta.close();
                conexion.getConexion().close();           
            }
            else if(objAct instanceof Persona){
                
                String instruccion = "update persona " + 
                "set nombre= '" + ((Persona) objAct).getNombre() + "'" + 
                ", ciudad= '" + ((Persona) objAct).getCiudad() + "'" + 
                ", correo= '" + ((Persona) objAct).getCorreo() + "'" + 
                ", telefono= '" + ((Persona) objAct).getTelefono() + "'" + 
                ", fechaNac= '" + ((Persona) objAct).getFechaNac() + "' " + 
                "where Id_Cliente= '" + ((Persona) objAct).getID()+"'";
                consulta = conexion.getConexion().createStatement();
                consulta.executeUpdate(instruccion);    
                mensaje = "El cliente fue actualizado correctamente...";
                consulta.close();
                conexion.getConexion().close();   
            }else if(objAct instanceof Factura_Gym){
                String categoria = null;
                if(objAct instanceof TipoA){
                    categoria = "A";
                }else if(objAct instanceof TipoB){
                    categoria = "B";
                }else if(objAct instanceof TipoC){
                    categoria = "C";
                }
                String instruccion = "update factura_gym " + 
                "set fechaF=" + ((Factura_Gym) objAct).getFechaF() + "'" + 
                ", Id_Cliente= " + ((Factura_Gym) objAct).getCliente().getID() + "'" + 
                ", Id_Membresia= " + categoria + "'" + 
                "where idFact= '" + ((Factura_Gym) objAct).getIdFact()+"'";
                consulta = conexion.getConexion().createStatement();
                consulta.executeUpdate(instruccion);    
                mensaje = "La factura fue actualizada correctamente...";
                consulta.close();
                conexion.getConexion().close();         
            }
            
        }catch(SQLException ex){
            mensaje = "No se pudo actualizar el dato..." + ex;
        }
        return mensaje;
    }
    
    /**
     * Método que devuelve el objeto Factura_Gym utilizado en la clase.
     * @return El objeto Factura_Gym.
     */
    public Factura_Gym getObjF() {
        return objF;
    }
    
    /**
     * Método que establece el objeto Factura_Gym a utilizar en la clase.
     * @param objF El nuevo objeto Factura_Gym.
     */
    public void setObjF(Factura_Gym objF) {
        this.objF = objF;
    }
    
    /**
     * Método que devuelve una representación en forma de String del objeto FacturaDAO.
     * @return Una representación en forma de String del objeto FacturaDAO.
     */
    @Override
    public String toString() {
        return objF.toString();
    }
    
    
}
