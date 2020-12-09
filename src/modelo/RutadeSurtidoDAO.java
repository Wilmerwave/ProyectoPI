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
public class RutadeSurtidoDAO {
    
    //CONSTRUCTOR
    public RutadeSurtidoDAO(){}
    
    
    /**
     * 
     * @param ruta  Objeto de la clase RutadeSurtido a insertar en la BBDD
     * @return rs resultado de la operación INSERT
     */
    
    public int agregarRuta(RutadeSurtido ruta){ 
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO ruta_cliente values (?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, ruta.getId_cliente());
            pstm.setString(2, ruta.getId_ruta());
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
     * @param ruta Objeto de la clase RutadeSurtido a modificar en la BBDD
     * @return rs resultado de la operación UPDATE
     */
    
    public int modificarRuta(RutadeSurtido ruta){    
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE ruta_cliente " +
                         "SET Id_cliente=?, id_ruta=?"
                    +    "WHERE id=?";
            
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, ruta.getId_cliente());
            pstm.setString(2, ruta.getId_ruta());
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
     * @param id_ruta código de la ruta a borrar
     * @return rs resultado de la operación DELETE
     */
    
    public int eliminarRuta(String idRuta){   
        
        Connection con = null;
        PreparedStatement pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM ruta_cliente WHERE id=? ";
            pstm = con.prepareStatement(sql);
            pstm.setString(2, idRuta); 
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
     * Se listaran todas las rutas
     * @return ArrayList, lista de objetos RutadeSurtido
     */
    public ArrayList<RutadeSurtido> listadoRutas(){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<RutadeSurtido> listado = new ArrayList<>();
        
        try{
            
            con = Fachada.getConnection();
            
            String sql=" ";
            sql = "SELECT * FROM ruta_cliente ORDER BY id";            
                                   
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();

            while(rs.next()){
                RutadeSurtido ruta = new RutadeSurtido(null,null);
                ruta.setId_cliente(rs.getString("id_cliente"));
                ruta.setId_ruta(rs.getString("id_ruta"));
                
                listado.add(ruta);
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
    
    
    
     /**
     * 
     * Se listaran todas las rutas que tengan ese id (como el id es unico devolvera una sola ruta)
     * @return ArrayList, lista de objetos RutadeSurtido
     */
    public ArrayList<RutadeSurtido> MuestraUnaRuta(String id){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<RutadeSurtido> listado = new ArrayList<>();
        
        try{
            
            con = Fachada.getConnection();
            
            String sql=" ";
            sql = "SELECT * FROM ruta_cliente WHERE id=? ORDER BY id";            
            pstm = con.prepareStatement(sql);
            pstm.setString(1, id);
            rs = pstm.executeQuery();

            while(rs.next()){
                RutadeSurtido ruta = new RutadeSurtido();
                ruta.setId_cliente(rs.getString("id_cliente"));
                ruta.setId_ruta(rs.getString("id_ruta"));
                listado.add(ruta);
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
    

