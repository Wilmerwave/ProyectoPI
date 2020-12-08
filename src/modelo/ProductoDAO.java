package modelo;

import Servicios.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Camila
 */
public class ProductoDAO {
    
    //CONSTRUCTOR
    public ProductoDAO(){}
    
    
    //METODOS CRUD
    
////////////////////// INSERT //////////////////////////////////////////////////
    
    
    /**
     * 
     * @param p Objeto de la clase Producto a insertar en la BBDD
     * @return rs resultado de la operación INSERT
     */
    
    public int agregarProducto(Producto p){ 
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO producto values (?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, p.getId());
            pstm.setString(2, p.getNombre());
            pstm.setInt(3, p.getCantidadX6());
            pstm.setInt(4, p.getCantidadX12());
            pstm.setInt(5, p.getPreciox6());
            pstm.setInt(6, p.getPreciox12());
            rs = pstm.executeUpdate();  
            
            JOptionPane.showMessageDialog(null, "PRODUCTO REGISTRADO CON EXITO");
            
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
    
    
    
    
////////////////////// UPDATE //////////////////////////////////////////////////    

    
    
    
    
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
                         "SET nombre=?, cantidad_x_6=?, cantidad_x_12=?, precio_6=?, precio_12=? "
                    +    "WHERE id_producto=?";
            
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, producto.getNombre());
            pstm.setInt(2, producto.getCantidadX6());
            pstm.setInt(3, producto.getCantidadX12());
            pstm.setInt(4, producto.getPreciox6());
            pstm.setInt(5, producto.getPreciox12());
            pstm.setString(6, producto.getId());
            rs = pstm.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "SE ACTUALIZO EL PRODUCTO CON EXITO");
            
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
    
    
    
////////////////////// DELETE //////////////////////////////////////////////////
    
            
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
            
            JOptionPane.showMessageDialog(null, "SE ELIMINO EL PRODUCTO CON EXITO");
            
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
    
    
    
    
////////////////////// SELECT //////////////////////////////////////////////////
    
    
    
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
            sql = "SELECT id_producto, nombre, cantidad_x_6, cantidad_x_12, precio_6, precio_12"
                    + " FROM producto ORDER BY id_producto";            
                                   
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()){
                Producto producto = new Producto();
                producto.setId(rs.getString("id_producto"));
                producto.setNombre(rs.getString("nombre"));
                producto.setCantidadX6(rs.getInt("cantidad_x_6"));
                producto.setCantidadX12(rs.getInt("cantidad_x_12"));
                producto.setPreciox6(rs.getInt("precio_6"));
                producto.setPreciox12(rs.getInt("precio_12"));
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
    
    
    
    
////////////////////// MUESTRA LA CANTIDAD DE DOCENAS DE UN PRODUCTO SEGUN SU ID//////////////////////////
    
    
    
    
    /**
     * 
     * @param id id del objeto Producto a mostrar la cantidad de docenas 
     * @return int cantidad de docenas que tiene el producto en la BBDD
     */
    
    public int muestraCantidadDocena(String id){    
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int cantidadDocena = 0;
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT cantidad_x_12 FROM producto WHERE id_producto=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                cantidadDocena = rs.getInt(1);
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
        
        return cantidadDocena;
    }    
    
    
    
    
////////////////////// MUESTRA LA CANTIDAD DE DOCENAS DE UN PRODUCTO SEGUN SU ID//////////////////////////
    
    
    
    
    /**
     * 
     * @param id id del objeto Producto a mostrar la cantidad de docenas 
     * @return int cantidad de docenas que tiene el producto en la BBDD
     */
    
    public int muestraCantidadMediaDocena(String id){    
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int cantidadMediaDocena = 0;
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT cantidad_x_6 FROM producto WHERE id_producto=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                cantidadMediaDocena = rs.getInt(1);
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
        
        return cantidadMediaDocena;
    }     
    
    
    
    
    
////////////////////// PRODUCCION DE DOCENAS //////////////////////////////////////////////////    
    
    
    
    
    /**
     * 
     * @param cant cantidad a sumar de docenas
     * @param id id objeto de Producto a modificar en la BBDD
     * @return rs resultado de la operación UPDATE
     */
    
    public int produccionDocena(String id, int cant){    
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE producto SET cantidad_x_12=? WHERE id_producto=?";
            
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, muestraCantidadDocena(id) + cant);
            pstm.setString(2, id);
            rs = pstm.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "PRODUCCION EXITOSA...SE ACTUALIZO LA CANTIDAD DE DOCENAS DEL PRODUCTO CON EXITO");
            
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
    
    
    
////////////////////// PRODUCCION DE MEDIAS DOCENAS //////////////////////////////////////////////////    
    
     
    
    /**
     * 
     * @param cant cantidad a sumar de docenas
     * @param id id del objeto de Producto a modificar en la BBDD
     * @return rs resultado de la operación UPDATE
     */
    
    public int produccionMediaDocena(String id, int cant){    
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE producto SET cantidad_x_6=? WHERE id_producto=?";
            
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, muestraCantidadMediaDocena(id) + cant);
            pstm.setString(2, id);
            rs = pstm.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "PRODUCCION EXITOSA...SE ACTUALIZO LA CANTIDAD DE MEDIAS DOCENAS DEL PRODUCTO CON EXITO");
            
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
    
    
    
    
////////////////////// VENTA DE DOCENAS //////////////////////////////////////////////////    
    
    
    
    
    /**
     * 
     * @param cant cantidad a restar de docenas
     * @param id id del objeto de Producto a modificar en la BBDD
     * @return rs resultado de la operación UPDATE
     */
    
    public int ventaDocena(String id, int cant){    
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE producto SET cantidad_x_12=? WHERE id_producto=?";
            
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, muestraCantidadDocena(id) - cant);
            pstm.setString(2, id);
            rs = pstm.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "VENTA EXITOSA...SE ACTUALIZO LA CANTIDAD DE DOCENAS DEL PRODUCTO CON EXITO");
            
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
    
    
    
////////////////////// VENTA DE MEDIAS DOCENAS //////////////////////////////////////////////////    
    
     
    
    /**
     * 
     * @param cant cantidad a restar de docenas
     * @param id id del objeto de Producto a modificar en la BBDD
     * @return rs resultado de la operación UPDATE
     */
    
    public int ventaMediaDocena(String id, int cant){    
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE producto SET cantidad_x_6=? WHERE id_producto=?";
            
            pstm = con.prepareStatement(sql);            
            pstm.setInt(1, muestraCantidadMediaDocena(id) - cant);
            pstm.setString(2, id);
            rs = pstm.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "VENTA EXITOSA...SE ACTUALIZO LA CANTIDAD DE MEDIAS DOCENAS DEL PRODUCTO CON EXITO");
            
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

    
    
    
    
/////////////METODO PARA LLENAR EL JCOMBOBOX CON LOS NOMBRES DE LOS PRODUCTOS
    
    public ArrayList<String> consultaProductos(){
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        ArrayList<String> productos = new ArrayList();
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT DISTINCTROW nombre FROM producto";      
                                   
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                productos.add(rs.getString(1));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return productos;
    }
    
    
    
///////////////METODO PARA DEVUELVER EL ID DE UN PRODUCTO DE ACUERDO A SU NOMBRE
    
    public String muestraID(String nombre){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String id = "";
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT id_producto FROM producto WHERE nombre=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, nombre);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                id = rs.getString(1);
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
        
        return id;
    }
    
    
///////////////METODO PARA DEVUELVER EL PRECIO DE UN PRODUCTO DE ACUERDO A SU NOMBRE Y CANTIDAD A VENDER
///////////////PARA DOCENAS
    
    public int precioDocena(String nombre, int cantidad){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int precioTotal = 0;
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT precio_12 FROM producto WHERE nombre=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, nombre);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                precioTotal = rs.getInt(1) * cantidad;
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
        
        return precioTotal;
    }
    
    
    
///////////////METODO PARA DEVUELVER EL PRECIO DE UN PRODUCTO DE ACUERDO A SU NOMBRE Y CANTIDAD A VENDER
///////////////PARA MEDIAS DOCENAS
    
    public int precioMediaDocena(String nombre, int cantidad){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        int precioTotal = 0;
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT precio_6 FROM producto WHERE nombre=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, nombre);
            rs = pstm.executeQuery();
            
            while(rs.next()){
                precioTotal = rs.getInt(1) * cantidad;
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
        
        return precioTotal;
    }    
    
    
    
    
}
    

