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
public class FacturaDAO {
    Factura objF;

    public FacturaDAO(Factura objP) {
        this.objF = objP;
    }
     public FacturaDAO() {
        this.objF = new Factura();
    }

    public DefaultTableModel consultar(){
         DefaultTableModel plantilla= new DefaultTableModel();
         ConexionBD con= new ConexionBD();
        try {
           con.conectar();
           JOptionPane.showMessageDialog(null, con.getMensaje());
           Statement consulta= con.getConexion().createStatement();
            ResultSet datos= consulta.executeQuery("select * from vehiculo");
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
    }*/
    
    public String insertar2(){
        String mensaje=""; 
        try {
            ConexionBD conexion=new ConexionBD();
            PreparedStatement consulta = null;
            conexion.conectar();
            //previamente insert de propietarios y de factura
            
            //Insertando Propietario
            String comando= "insert into propietario values(?,?,?,?,?,?,?)";
            consulta = conexion.getConexion().prepareStatement(comando); 
            consulta.setString(1, objF.getNroF());
            consulta.setString(2, objF.getPropietario().getfNac().toString());
            consulta.setString(3, objF.getPropietario().getId());
            consulta.setString(4, objF.getPropietario().getTel());
            consulta.execute();
            
            mensaje="Registro exitoso...";
            /*for (Object vehiculo : objF.getListaV()) {
                if(vehiculo instanceof Auto){
                    Auto objA = (Auto) vehiculo;
                    consulta.setString(1,objA.getPlaca());
                    consulta.setString(2,objA.getTipoVehiculo());
                    consulta.setString(3, objA.getMarca());
                    consulta.setInt(4,objA.getModelo());
                    consulta.setInt(5,0);
                    consulta.setDouble(6, objA.getValor());
                    consulta.setString(7, (String) objF.getNroF());
                }
                if(vehiculo instanceof Moto){
                    Moto objM = (Moto) vehiculo;
                    consulta.setString(1,objM.getPlaca());
                    consulta.setString(2,objM.getTipoVehiculo());
                    consulta.setString(3, objM.getMarca());
                    consulta.setInt(4,objM.getModelo());
                    consulta.setInt(5,objM.getCilindraje());
                    consulta.setDouble(6, objM.getValor());
                    consulta.setString(7, (String) objF.getNroF());
                }*/
            
            consulta.execute();
            mensaje="Registro exitoso...";
            consulta.close();
            conexion.getConexion().close();
        } catch (SQLException ex) {
           mensaje="Error al intentar insertar...\n"+ex;
        }
      return mensaje;  
    }

    public Factura getObjF() {
        return objF;
    }

    public void setObjF(Factura objF) {
        this.objF = objF;
    }

    @Override
    public String toString() {
        return objF.toString();
    }
}
