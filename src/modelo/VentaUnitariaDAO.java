package modelo;

import Servicios.Fachada;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Wil
 */
public class VentaUnitariaDAO {
   public VentaUnitariaDAO() {
    }
    
    public int grabarVentaUnitaria(VentaUnitaria p){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO venta values (?,?,?,?,?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getIdVenta());
            pstm.setDate(2, p.getFecha());
            pstm.setString(3, p.getIdProducto());
            pstm.setString(4, p.getPresentacion());
            pstm.setInt(5,p.getCantidad());
            pstm.setString(7, p.getIdVendedor());
            pstm.setString(8, p.getIdCliente());
            
            
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
    
     
    public int modificarVentaUnitaria(VentaUnitaria p){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE venta " +
                         "SET  fecha= ?,id_producto = ?, paquete = ?,cantidad = ?,valor_producto= ?,id_vendedor = ?, id_cliente = ?,"
                    +    "WHERE id_venta = ?";
            pstm = con.prepareStatement(sql);            
            
            pstm.setDate(2, p.getFecha());
            pstm.setString(3, p.getIdProducto());
            pstm.setString(4, p.getPresentacion());
            pstm.setInt(5,p.getCantidad());
            pstm.setString(7, p.getIdVendedor());
            pstm.setString(8, p.getIdCliente());
            pstm.setString(1, p.getIdVenta());
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
            
    
    public int borrarVentaUnitaria(String idVenta){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM venta WHERE id_venta = ? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idVenta);
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

    public ArrayList<VentaUnitaria> listadoVentaUnitaria(String idVenta){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<VentaUnitaria> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(idVenta.equalsIgnoreCase("0")){
                sql = "SELECT * FROM venta ORDER BY id_venta";            
            }else{
                sql = "SELECT * FROM venta where id_venta = ? "
                    + "ORDER BY id_venta";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(idVenta != "0"){
                pstm.setString(1, idVenta);
            }
            
            rs = pstm.executeQuery();
                        
            VentaUnitaria venta = null;
            while(rs.next()){
                venta = new VentaUnitaria();
                venta.setIdVenta(rs.getString("id_venta"));
                venta.setFecha(Date.valueOf(rs.getString("fecha_venta")));
                venta.setHora(rs.getString("hora_venta"));
                venta.setIdProducto(rs.getString("id_producto"));
                venta.setPresentacion(rs.getString("paquete"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setIdVendedor(rs.getString("id_vendedor"));
                venta.setIdCliente(rs.getString("id_cliente"));
                venta.setTipoVenta(rs.getString("tipo_venta"));
                listado.add(venta);
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
    
    
    ///MUESTRA VENTAS POR MOSTRADOR
    
    public ArrayList<VentaUnitaria> muestraVentaMostrador(){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<VentaUnitaria> listado = new ArrayList<>();
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT * FROM venta where tipo_venta = 'Mostrador'  ORDER BY id_venta";      
                                   
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
                        
            VentaUnitaria venta = null;
            while(rs.next()){
                venta = new VentaUnitaria();
                venta.setIdVenta(rs.getString("id_venta"));
                venta.setFecha(Date.valueOf(rs.getString("fecha_venta")));
                venta.setHora(rs.getString("hora_venta"));
                venta.setIdProducto(rs.getString("id_producto"));
                venta.setPresentacion(rs.getString("paquete"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setIdVendedor(rs.getString("id_vendedor"));
                venta.setIdCliente(rs.getString("id_cliente"));
                venta.setTipoVenta("Mostrador");
                listado.add(venta);
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
    
    
    
    ///MUESTRA VENTAS EXTERIORES
    
    public ArrayList<VentaUnitaria> muestraVentaExterior(){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<VentaUnitaria> listado = new ArrayList<>();
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT * FROM venta where tipo_venta = 'Exterior'  ORDER BY id_venta";      
                                   
            pstm = con.prepareStatement(sql);
            
            rs = pstm.executeQuery();
                        
            VentaUnitaria venta = null;
            while(rs.next()){
                venta = new VentaUnitaria();
                venta.setIdVenta(rs.getString("id_venta"));
                venta.setFecha(Date.valueOf(rs.getString("fecha_venta")));
                venta.setHora(rs.getString("hora_venta"));
                venta.setIdProducto(rs.getString("id_producto"));
                venta.setPresentacion(rs.getString("paquete"));
                venta.setCantidad(rs.getInt("cantidad"));
                venta.setIdVendedor(rs.getString("id_vendedor"));
                venta.setIdCliente(rs.getString("id_cliente"));
                venta.setTipoVenta("Exterior");
                listado.add(venta);
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
  

