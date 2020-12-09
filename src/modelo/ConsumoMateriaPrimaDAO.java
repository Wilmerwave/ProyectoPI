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
public class ConsumoMateriaPrimaDAO {
    
    //CONSTRUCTOR
    public ConsumoMateriaPrimaDAO(){}
    
    
    //METODOS CRUD
    
    
 ////////////////////// INSERT //////////////////////////////////////////////////    
    
    
    /**
     * 
     * @param consumo Objeto de la clase ConsumoMateriaPrima a insertar en la BBDD
     * @return rs resultado de la operación INSERT
     */
    
    public int agregarConsumo(ConsumoMateriaPrima consumo){ 
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "INSERT INTO producto_materiax12 values (?,?,?)";
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, consumo.getIdProducto());
            pstm.setString(2, consumo.getIdMaterial());
            pstm.setInt(3, consumo.getCantidadConsumida());
            rs = pstm.executeUpdate();  
            
            JOptionPane.showMessageDialog(null, "SE REGISTRO UN CONSUMO CON EXITO");
            
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
     * @param consumo Objeto de la clase ConsumoMateriaPrima a modificar en la BBDD
     * @return rs resultado de la operación UPDATE
     */
    
    
    public int modificarConsumo(ConsumoMateriaPrima consumo){    
        
        Connection con = null;
        PreparedStatement pstm;
        pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "UPDATE producto_materiax12 " +
                         "SET idMateriaPrima=?, cantidadConsumo=? "
                    +    "WHERE idProducto=?";
            
            pstm = con.prepareStatement(sql);            
            pstm.setString(1, consumo.getIdMaterial());
            pstm.setInt(2, consumo.getCantidadConsumida());
            pstm.setString(3, consumo.getIdProducto());
            rs = pstm.executeUpdate();  
            
            JOptionPane.showMessageDialog(null, "SE ACTUALIZO EL CONSUMO CON EXITO");
            
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
    
    
    
 ////////////////////// DELETE  //////////////////////////////////////////////////    
    
    
    
    /**
     * 
     * @param idProducto código del producto a borrar
     * @param idMateria código de la materia prima a borrar
     * @return rs resultado de la operación DELETE
     */
    
    public int eliminarConsumo(String idProducto, String idMateria){   
        
        Connection con = null;
        PreparedStatement pstm = null;
        int rs = 0;
        
        try{
            con = Fachada.getConnection();
            String sql = "DELETE FROM producto_materiax12 WHERE idProducto=? AND idMateriaPrima=?";
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idProducto); 
            pstm.setString(2, idMateria);
            rs = pstm.executeUpdate(); 
            
            JOptionPane.showMessageDialog(null, "SE ELIMINO EL CONSUMO CON EXITO");
            
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
    
  
 ////////////////////// DOCENAS QUE SE CONSUMIERON PARA HACER CANT DE PRODUCTOS ///////////////////////////////////
    
    
    /**
     * @param idProducto id del producto al cual veremos su consumo
     * @param cant cantidad total de consumo de docenas que se producieron
     * Se listaran todos los consumos de determinado producto
     * @return ArrayList, lista de objetos MateriaPrima
     */
    public ArrayList<MateriaPrima> consumoDocenaX(String idProducto, int cant){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<MateriaPrima> listado = new ArrayList<>();
        
        try{
            
            con = Fachada.getConnection();
            
            String sql=" ";
            sql = "SELECT idMateriaPrima, cantidadConsumo FROM producto_materiax12 WHERE idProducto=?";            
                                   
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idProducto); 
            rs = pstm.executeQuery();

            while(rs.next()){
                MateriaPrima materiaPrima = new MateriaPrima();
                materiaPrima.setId(rs.getString("idMateriaPrima"));
                materiaPrima.setNombre(" ");
                materiaPrima.setCantidad(rs.getInt("cantidadConsumo")*cant);
                listado.add(materiaPrima);
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
    
    
  
 ////////////////////// MEDIAS DOCENAS QUE SE CONSUMIERON PARA HACER CANT DE PRODUCTOS /////////////////////////
    
    
    
    /**
     * @param idProducto id del producto al cual veremos su consumo
     * @param cant cantidad total de consumo de medias docenas que se producieron
     * Se listaran todos los consumos por x cantidad de media docena de determinado producto 
     * @return ArrayList, lista de objetos MateriaPrima
     */
    public ArrayList<MateriaPrima> consumoMediaDocenaX(String idProducto, int cant){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<MateriaPrima> listado = new ArrayList<>();
        
        try{
            
            con = Fachada.getConnection();
            
            String sql=" ";
            sql = "SELECT idMateriaPrima, cantidadConsumo FROM producto_materiax12 WHERE idProducto=?";            
                                   
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idProducto); 
            rs = pstm.executeQuery();

            while(rs.next()){
                MateriaPrima materiaPrima = new MateriaPrima();
                materiaPrima.setId(rs.getString("idMateriaPrima"));
                materiaPrima.setNombre(" ");
                materiaPrima.setCantidad((rs.getInt("cantidadConsumo")/2)*cant);
                listado.add(materiaPrima);
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
    
    
    
    
    
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    
    
     /**
     * @param idProducto id del producto al cual veremos su consumo
     * Se listaran todos los consumos de determinado producto
     * @return ArrayList, lista de objetos MateriaPrima
     */
    public ArrayList<MateriaPrima> listadoDocena(String idProducto){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<MateriaPrima> listado = new ArrayList<>();
        
        try{
            
            con = Fachada.getConnection();
            
            String sql=" ";
            sql = "SELECT idMateriaPrima, cantidadConsumo FROM producto_materiax12 WHERE idProducto=?";            
                                   
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idProducto); 
            rs = pstm.executeQuery();

            while(rs.next()){
                MateriaPrima materiaPrima = new MateriaPrima();
                materiaPrima.setId(rs.getString("idMateriaPrima"));
                materiaPrima.setNombre(" ");
                materiaPrima.setCantidad(rs.getInt("cantidadConsumo"));
                listado.add(materiaPrima);
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
     * @param idProducto id del producto al cual veremos su consumo
     * Se listaran todos los consumos por media docena de determinado producto
     * @return ArrayList, lista de objetos MateriaPrima
     */
    public ArrayList<MateriaPrima> listadoMediaDocena(String idProducto){
        
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ArrayList<MateriaPrima> listado = new ArrayList<>();
        
        try{
            
            con = Fachada.getConnection();
            
            String sql=" ";
            sql = "SELECT idMateriaPrima, cantidadConsumo FROM producto_materiax12 WHERE idProducto=?";            
                                   
            pstm = con.prepareStatement(sql);
            pstm.setString(1, idProducto); 
            rs = pstm.executeQuery();

            while(rs.next()){
                MateriaPrima materiaPrima = new MateriaPrima();
                materiaPrima.setId(rs.getString("idMateriaPrima"));
                materiaPrima.setNombre(" ");
                materiaPrima.setCantidad(rs.getInt("cantidadConsumo") / 2);
                listado.add(materiaPrima);
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
