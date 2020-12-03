/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import Servicios.Fachada;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo
 */
public class ProductoPresentacionDAO {

    public ProductoPresentacionDAO() {
    }
    
    public int agregarProductoPresentacion(ProductoPresentacion producto){ 
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO producto values (?,?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setDouble(1, producto.getPrecio());
            //pstm.setString(2, producto.getNombre());
            pstm.setString(3,producto.getPaquete());
            pstm.setString(4,producto.getPaquete()); 
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
    
    
}
