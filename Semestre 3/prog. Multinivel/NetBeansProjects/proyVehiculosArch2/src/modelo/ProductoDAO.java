/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sonia Pinzón
 */
public class ProductoDAO {
    Producto objP;

    public ProductoDAO(Producto objP) {
        this.objP = objP;
    }
     public ProductoDAO() {
        this.objP = new Producto();
    }

    public DefaultTableModel consultar(){
         DefaultTableModel plantilla= new DefaultTableModel();
         ConexionBD con= new ConexionBD();
        try {
           con.conectar();
           JOptionPane.showMessageDialog(null, con.getMensaje());
           Statement consulta= con.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from productos");
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
    
    public String insertar()  {
      String mensaje="";  
        try {
            ConexionBD conexion=new ConexionBD();
            Statement consulta = null;
            conexion.conectar();
            String comando= "insert into productos values('"+objP.getCod()+
             "','"+ objP.getNom()+"',"+ objP.getPrecio()+","+objP.getCant()+")";
            consulta=conexion.getConexion().createStatement();
            consulta.execute(comando);
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
       return mensaje; 
    }
    public String insertar2(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            String comando= "insert into productos values(?,?,?,?)";
            consulta=conexion.getConexion().prepareStatement(comando);
            consulta.setString(1,objP.getCod());
            consulta.setString(2,objP.getNom());
            consulta.setDouble(3,objP.getPrecio());
            consulta.setInt(4,objP.getCant());
            consulta.execute();
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
      return mensaje;  
    }
    public Producto getObjP() {
        return objP;
    }

    public void setObjP(Producto objP) {
        this.objP = objP;
    }

    @Override
    public String toString() {
        return objP.toString();
    }
     
}
