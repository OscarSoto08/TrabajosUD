/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Membresia;
/**
 *
 * @author Sonia Pinzón
 */
public class FacturaDAO {
    Factura_Gym objF;

    public FacturaDAO(Factura_Gym objP) {
        this.objF = objP;
    }
     public FacturaDAO() {
        this.objF = new Factura_Gym();
    }

    public DefaultTableModel consultar(){
         DefaultTableModel plantilla= new DefaultTableModel();
         ConexionBD con= new ConexionBD();
        try {
           con.conectar();
           JOptionPane.showMessageDialog(null, con.getMensaje());
           Statement consulta= con.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from membresia");
            ResultSetMetaData campos=datos.getMetaData();
            for (int i = 1; i <= campos.getColumnCount(); i++) {
                plantilla.addColumn(campos.getColumnName(i));
            }
            while(datos.next()){
             Object fila[]=new Object[campos.getColumnCount()];
                for (int i = 0; i < campos.getColumnCount(); i++) {
                   fila[i]=datos.getObject(i+1);
                }
                plantilla.addRow(fila);
            }
            datos.close();
            con.getConexion().close();
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        return plantilla;
    }
    
    
    /*
    public String insertar(){
        String mensaje = "";
            try{
                ConexionBD conexion = new ConexionBD();
                Statement consulta = null;
                conexion.conectar();
                String comando = "";
                
                if(objF.getMemb() instanceof TipoA){
                    TipoA memb_A = (TipoA) Membresia;
                    comando = "insert into membresia values("+ objF.getMemb().getCategoria() + "," + objF.getMemb().valorPago() + ")";
                }else if(objF.getMemb() instanceof TipoB){
                    TipoB memb_B = (TipoB) Membresia;
                    comando = "insert into membresia values("+ objF.getMemb().getCategoria() + "," + objF.getMemb().valorPago() + ")";
                }else if(objF.getMemb() instanceof TipoC){
                    TipoC memb_C = (TipoC) Membresia;
                    comando = "insert into membresia values("+ objF.getMemb().getCategoria() + "," + objF.getMemb().valorPago() + ")";
                }
                consulta = conexion.getConexion().createStatement();
                consulta.execute(comando);
                mensaje = "Registro exitoso...";
                consulta.close();
                conexion.getConexion().close();
                
            }catch(SQLException ex){
                mensaje = "Error al intentar insertar...\n"+ex;
            }
        return mensaje;
    }
    */


    public String insertarPersona(){
        String mensaje = "";
        
        try{
            ConexionBD conexion = new ConexionBD();
            Statement consulta = null;
            conexion.conectar();
            
            String comando = "insert into persona(Id_Cliente, nombre, ciudad, correo, telefono, fechaNac) values ("+
                    objF.getPropietario().getID() + "," + objF.getPropietario().getNombre()+","+ objF.getPropietario().getCiudad() + "," 
                    + objF.getPropietario().getCorreo() + "," 
                    + objF.getPropietario().getTelefono() + "," + objF.getPropietario().getFechaNac() + ")";
            
            consulta = conexion.getConexion().createStatement();
            consulta.execute(comando);
            mensaje = "Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
     
        }catch(SQLException ex){
            mensaje = "Error al intentar insertar...\n"+ex;
        }
        return mensaje;
    }
    
    
    public String actualizarPersona(Object objAct){
        String mensaje = "";
        try{
            ConexionBD conexion = new ConexionBD();
            Statement consulta = null;
            conexion.conectar();
            
            String instruccion =            
                "update persona " + "set Id_Cliente=" + objF.getPropietario().getID() + 
                ", nombre=" + objF.getPropietario().getNombre() +", ciudad=" + objF.getPropietario().getCiudad() + 
                ", correo=" + objF.getPropietario().getCorreo() + ", telefono=" + objF.getPropietario().getTelefono() + 
                ", fechaNac=" + objF.getPropietario().getFechaNac() + 
                " where Id_Cliente= " + objF.getPropietario().getID();
            
            consulta = conexion.getConexion().createStatement();
            consulta.execute(instruccion);
            mensaje = "Actualización exitosa...";
            consulta.close();
            conexion.getConexion().close();
        }catch(SQLException ex){
        mensaje = "Error al intentar insertar...\n"+ex;
        }
        return mensaje;
    }
    
    public String eliminarPersona(Object objE){
        String mensaje = "";
        try{
            ConexionBD conexion = new ConexionBD();
            Statement consulta = null;
            conexion.conectar();
            String comando = "";
            if(objE instanceof Factura_Gym){
                comando = "delete from factura_gym " + "where idFact= ' " + 
                        ((Factura_Gym) objE).getIdFact() + "'";
                consulta = conexion.getConexion().prepareStatement(comando);
            }else if(objE instanceof Membresia){
                comando = "delete from membresia " + "where Id_Membresia= ' " + 
                        ((Membresia) objE).getCategoria()+ "'";
                consulta = conexion.getConexion().prepareStatement(comando);
            }else if(objE instanceof Persona){
                comando = "delete from persona " + "where Id_Cliente= ' " + 
                        ((Persona) objE).getID()+ "'";
                consulta = conexion.getConexion().prepareStatement(comando);
            }
            consulta.execute(comando);
            mensaje = "Se ha eliminado el registro...";
            consulta.close();
            conexion.getConexion().close();
            
        }catch(SQLException ex){
            mensaje = "Error al intentar eliminar...\n" + ex;
        }
        return mensaje;
    }
    
    public Factura_Gym getObjP() {
        return objF;
    }

    public void setObjP(Factura_Gym objP) {
        this.objF = objP;
    }

    @Override
    public String toString() {
        return objF.toString();
    }
     
}
