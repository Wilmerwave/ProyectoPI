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
            String sql = "INSERT INTO cliente values (?,?,?,POINT(?,?))";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, cliente.getId());
            pstm.setString(2, cliente.getNombre());
            pstm.setString(3,cliente.getTelefono());
            //pstm.setObject(4, new Point(cliente.getUbicacion().x, cliente.getUbicacion().y));
            pstm.setInt(4, cliente.getUbicacion().x);
            pstm.setInt(5, cliente.getUbicacion().y);
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
    
    public void punto(Cliente cliente){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT direccion FROM cliente WHERE id_cliente=?";      
                                   
            pstm = con.prepareStatement(sql);
            pstm.setString(1, cliente.getId());
            
            rs = pstm.executeQuery();
                        
            while(rs.next()){
                Point punto = (rs.)
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
    } 
        
        
        
    
    
}
