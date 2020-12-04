package modelo;

import Servicios.Fachada;
import java.awt.Point;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila
 */
public class ClienteDAO {
    
    //CONSTRUCTOR
    public ClienteDAO(){}
    
    
    /**
     * 
     * @param cliente Objeto de la clase Cliente a insertar en la BBDD
     * @return rs resultado de la operación INSERT
     */
    
    public int agregarCliente(Cliente cliente){ 
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO cliente values (?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, cliente.getId());
            pstm.setString(2, cliente.getNombre());
            pstm.setString(3,cliente.getTelefono());
            pstm.setInt(4, cliente.getUbicacion().x);
            pstm.setInt(5, cliente.getUbicacion().y);
            rs = pstm.executeUpdate();  
            
            JOptionPane.showMessageDialog(null, "CLIENTE REGISTRADO CON EXITO");
            
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        
        return rs;
    }
    
    
    /*
    /**
     * 
     * @param cliente Objeto de la clase Cliente a modificar en la BBDD
     * @return rs resultado de la operación UPDATE
     */
    
    
    public int modificarCliente(Cliente cliente){    
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE cliente " +
                         "SET nombre_cliente=?, telefono=?, puntoX=?, puntoY=? "
                    +    "WHERE id_cliente=?";
            
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, cliente.getNombre());
            pstm.setString(2,cliente.getTelefono());
            pstm.setInt(3,cliente.getUbicacion().x);
            pstm.setInt(4, cliente.getUbicacion().y);
            pstm.setString(5, cliente.getId());
            rs = pstm.executeUpdate();  
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        
        finally{
            try{
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        return rs;
    }
    
    
    
     /*
    /**
     * 
     * @param id String con el id del cliente a quien queremos conocer su ubicacion(direccion)
     * @return punto de la clase Point resultado de la operación SELECT 
     */
    
    public Point muestraPunto(String idCliente){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Point punto = new Point(0,0);
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT puntoX, puntoY FROM cliente WHERE id_cliente=?";      
                                   
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idCliente);
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                //System.out.println(rs.getInt(1));
                punto.x = rs.getInt(1);
                punto.y = rs.getInt(2);
                //return punto;
            }
            rs.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        
        return punto;
        
    } 
    
    
    
    
    
    //RECIBE CLIENTE
    /*
    /**
     * 
     * @param cliente Objeto de la clase Cliente a quien queremos conocer su ubicacion(direccion)
     * @return punto de la clase Point resultado de la operación SELECT 
     */
    /*
    public Point muestraPuntoC(Cliente cliente){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        Point punto = new Point(0,0);
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT puntoX, puntoY FROM cliente WHERE id_cliente=?";      
                                   
            pstm = con.prepareStatement(sql);
            pstm.setString(1, cliente.getId());
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                //System.out.println(rs.getInt(1));
                punto.x = rs.getInt(1);
                punto.y = rs.getInt(2);
                //return punto;
            }
            rs.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pstm!=null) pstm.close();                
            }
            catch(SQLException ex){
                JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
            }
        }
        
        return punto;
        
    } 
       
    */    
        
    
    
}
