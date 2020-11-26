package modelo;

import Servicios.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author Camila
 */
public class ProductoDAO {
    
    //CONSTRUCTOR
    public ProductoDAO(){}
    
    
    /**
     * 
     * @param producto Objeto de la clase Producto a insertar en la BBDD
     * @return rs resultado de la operación INSERT
     */
    
    public int agregarProducto(Producto producto){ 
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO producto values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, producto.getId());
            pstm.setString(2, producto.getNombre());
            pstm.setInt(3,producto.getCantidadX6());
            pstm.setInt(4,producto.getCantidadX12()); 
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
    
    
    /**
     * 
     * @param producto Objeto de la clase Producto a modificar en la BBDD
     * @return rs resultado de la operación UPDATE
     */
    
    public int modificarProducto(Producto producto){    
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE producto " +
                         "SET nombre = ?, cantidad_x_6 = ?, cantidad_x_12 = ? "
                    +    "WHERE id_producto=?";
            
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, producto.getNombre());
            pstm.setInt(2,producto.getCantidadX6());
            pstm.setInt(3,producto.getCantidadX12());
             pstm.setString(4, producto.getId());
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
    
    
            
    /**
     * 
     * @param idProducto código del producto a borrar
     * @return rs resultado de la operación DELETE
     */
    
    public int eliminarProducto(String idProducto){   
        
        Connection con = null;
        PreparedStatement pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM producto WHERE id_producto = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idProducto); 
            rs = pstm.executeUpdate(); 
            return rs;
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
    
    
    /**
     * 
     * Se listaran todos los productos
     * @return ArrayList, lista de objetos Producto
     */
    public ArrayList<Producto> listadoProductos(){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<Producto> listado = new ArrayList<>();
        
        try{
            
            con = Fachada.getConnection();
            
            String sql=" ";
            sql = "SELECT * FROM producto ORDER BY id_producto";            
                                   
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()){
                Producto producto = new Producto();
                producto.setId(rs.getString("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                listado.add(producto);
            }
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
        return listado;
    }
    
    
    
    
}
    

