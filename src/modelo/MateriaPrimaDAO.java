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
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Wil
 */
public class MateriaPrimaDAO {
   public MateriaPrimaDAO() {
    }
    
    public int grabarMateriaPrimaDAO(MateriaPrima p){      
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
    
     
    public int modificarMateriaPrima(MateriaPrima p){      
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE materia_prima " +
                         "SET  nombre = ?, cantidad = ?"
                    +    "WHERE id_materiaPrima = ?";
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, p.getNombre());
            pstm.setDouble(3, p.getCantidad());
            pstm.setString(4, p.getId());
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
            
    
    public int borrarMateriaPrima(String id){      
        Connection con = null;
        PreparedStatement pstm = null;
        int rtdo;
        rtdo = 0;
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM materia_prima WHERE id = ? ";
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

    public ArrayList<MateriaPrima> listadoMateriaPrima(String id){      
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
    
    
    
//METODO PARA LLENAR EL JCOMBOBOX
    public ArrayList<String> consultaMaterial(){
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;
        ArrayList<String> materiaPrima = new ArrayList();
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT DISTINCTROW nombre FROM materia_prima";      
                                   
            stm = con.createStatement();
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                materiaPrima.add(rs.getString(1));
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Código : " + 
                        ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return materiaPrima;
    }
    
    

//METODO PARA DEVUELVE EL ID DE UNA MATERIA PRIMA DE ACUERDO A SU NOMBRE
    public String muestraID(String nombre){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        String id = "";
        
        try{
            con = Fachada.getConnection();
            String sql="";
            
            sql = "SELECT id_materiaPrima FROM materia_prima WHERE nombre=?";
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
        
    
    
    
}  



