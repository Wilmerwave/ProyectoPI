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
public class items_MateriaPrimaCompradaDAO {

    public items_MateriaPrimaCompradaDAO() {
    }
    
    
    public int grabaritems_MateriaPrimaCompradaDAO(MateriaPrima p) {
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO materia_prima values (?,?,?)";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, p.getId());
            pstm.setString(2, p.getNombre());
            pstm.setInt(3,p.getCantidad());
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
    
    
    public ArrayList<MateriaPrima> listadoitems_MateriaPrima(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<MateriaPrima> listado = new ArrayList<>();
        try{
            con = Fachada.getConnection();
            String sql="";
            if(id.equalsIgnoreCase("0")){
                sql = "SELECT * FROM materia_prima ORDER BY id";            
            }else{
                sql = "SELECT * FROM materia_prima where id = ? "
                    + "ORDER BY id";      
            }                        
            pstm = con.prepareStatement(sql);
            
            if(id != "0"){
                pstm.setString(1, id);
            }
            
            rs = pstm.executeQuery();
                        
            MateriaPrima materiaprima = null;
            while(rs.next()){
                materiaprima = new MateriaPrima();
                materiaprima.setId(rs.getString("id_materiaPrima"));
                materiaprima.setNombre(rs.getString("nombre"));
                materiaprima.setCantidad(rs.getInt("cantidad"));
                listado.add(materiaprima);
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
