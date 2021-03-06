/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Servicios.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class ProveedorDAO {
    public int grabarProveedorDAO(Proveedor p){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO proveedores values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getID());
            pstm.setString(2, p.getNombre());
            pstm.setString(3,p.getId_MateriaPrima());
            pstm.setDouble(4, p.getPrecio());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    
    public int modificarProveedor(Proveedor p){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE proveedores " +
                         "SET nombre = ?, id_materiaPrima = ?, precio_gramo = ?"
                    +    "WHERE id_proveedor = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(4, p.getID());            
            pstm.setString(1, p.getNombre());
            pstm.setDouble(3, p.getPrecio());
            pstm.setString(2, p.getId_MateriaPrima());
            rtdo = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"id: " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    
    public int borrarProveedor(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM proveedores WHERE id_proveedor = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rtdo = pstm.executeUpdate(); 
            return rtdo;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        } 
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rtdo;
    }
    
    public ArrayList<Proveedor> listadoProveedor(){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Proveedor> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            sql = "SELECT * FROM proveedores ORDER BY id_proveedor";            
                                   
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
                        
            Proveedor proveedor = null;
            while(rs.next()){
                proveedor = new Proveedor();
                proveedor.setID(rs.getString("id_proveedor"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setId_MateriaPrima(rs.getString("id_materiaPrima"));
                proveedor.setPrecio(rs.getInt("precio_gramo"));
                listado.add(proveedor);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"id : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return listado;
    }
}
