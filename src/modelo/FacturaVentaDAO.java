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
 * @author Camila
 */
public class FacturaVentaDAO {
    
    //CONSTRUCTOR
    public FacturaVentaDAO(){}
    
    
    /**
     * 
     * @param factura Objeto de la clase FacturaVenta a insertar en la BBDD
     * @return rs resultado de la operación INSERT
     */
    
    public int agregarFactura(FacturaVenta factura){ 
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO factura_venta values (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, factura.getIdFactura());
            pstm.setDouble(2, factura.getValorVenta());
            pstm.setString(3, factura.getIdVenta());
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
     * @param factura Objeto de la clase FacturaVenta a modificar en la BBDD
     * @return rs resultado de la operación UPDATE
     */
    
    public int modificarFactura(FacturaVenta factura){    
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE factura_venta " +
                         "SET valor_venta=?, id_Venta=?"
                    +    "WHERE id=?";
            
            pstm = con.prepareStatement(sql);            
            pstm.setDouble(1, factura.getValorVenta());
            pstm.setString(2, factura.getIdVenta());
            pstm.setString(3, factura.getIdFactura());
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
     * @param idfactura código de la factura a borrar
     * @return rs resultado de la operación DELETE
     */
    
    public int eliminarFactura(String idFactura){   
        
        Connection con = null;
        PreparedStatement pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM factura_venta WHERE id=? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idFactura); 
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
     * Se listaran todas las factura_venta
     * @return ArrayList, lista de objetos Factura
     */
    public ArrayList<FacturaVenta> listadoFactura(){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<FacturaVenta> listado = new ArrayList<>();
        
        try{
            
            con = Fachada.getConnection();
            
            String sql=" ";
            sql = "SELECT * FROM factura_venta ORDER BY id";            
                                   
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()){
                FacturaVenta factura = new FacturaVenta(null,0,null);
                factura.setIdFactura(rs.getString("id"));
                factura.setValorVenta(rs.getDouble("valor_venta"));
                factura.setIdVenta(rs.getString("id_venta"));
                listado.add(factura);
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
    

