/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author federicobarbetti
 */

import java.awt.*; 
import java.awt.geom.Dimension2D;
import javax.swing.*; 
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import static java.lang.System.arraycopy;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import javax.accessibility.AccessibleContext;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

public class Entorno_Distribucion_2_GUI extends JPanel 
{ 
    protected static Graphics2D fondoMapa;
    private static JFrame ventana;
    private ArrayList ubicaciones_X_cliente;
    private ArrayList ubicaciones_Y_cliente;
    private int topedeClientes;//5 es la maxima cantidad de clientes por ruta
    
    /*
    
    CONSTRUCTORES
    */

    public Entorno_Distribucion_2_GUI(ArrayList ubicaciones_X_cliente, ArrayList ubicaciones_Y_cliente, int topedeClientes) {
        this.ubicaciones_X_cliente = ubicaciones_X_cliente;
        this.ubicaciones_Y_cliente = ubicaciones_Y_cliente;
        this.topedeClientes = topedeClientes;
    }
    
    public Entorno_Distribucion_2_GUI() {
        ubicaciones_X_cliente = new ArrayList();
        ubicaciones_Y_cliente = new ArrayList();
        topedeClientes = 0;
        datosIniciales_X();
        datosIniciales_Y();
       // paintComponent();
    }

    
    //GETTERS & SETTERS

    public static Graphics2D getFondoMapa() {
        return fondoMapa;
    }

    public static void setFondoMapa(Graphics2D fondoMapa) {
        Entorno_Distribucion_2_GUI.fondoMapa = fondoMapa;
    }

    public static JFrame getVentana() {
        return ventana;
    }

    public static void setVentana(JFrame ventana) {
        Entorno_Distribucion_2_GUI.ventana = ventana;
    }

    public ArrayList getUbicaciones_X_cliente() {
        return ubicaciones_X_cliente;
    }

    public void setUbicaciones_X_cliente(ArrayList ubicaciones_X_cliente) {
        this.ubicaciones_X_cliente = ubicaciones_X_cliente;
    }

    public ArrayList getUbicaciones_Y_cliente() {
        return ubicaciones_Y_cliente;
    }

    public void setUbicaciones_Y_cliente(ArrayList ubicaciones_Y_cliente) {
        this.ubicaciones_Y_cliente = ubicaciones_Y_cliente;
    }

    public int getTopedeClientes() {
        return topedeClientes;
    }

    public void setTopedeClientes(int topedeClientes) {
        this.topedeClientes = topedeClientes;
    }
    
    

    

    protected void paintComponent(){ 
     
     JFrame frame = new JFrame(); // se instancia un JFrame denominado frame
     /*
     Se acondiciona el objeto JFrame
     */
     
     int [] renderizaBolita = new int[5];// candidad de renders del elemento.
     
     
     
     ImageIcon gif_inicial = new ImageIcon(" /Users/federicobarbetti/NetBeansProjects/__AArepositorio_final/ProyectoPI/src/iconos/inicial_movilRecuadro.gif");
     
     ImageIcon gif_final = new ImageIcon(" /Users/federicobarbetti/NetBeansProjects/__AArepositorio_final/ProyectoPI/src/iconos/final_movilRecuadro.gif");
     
     BufferedImage bolita_inicial = new BufferedImage(23, 23, 1); // dimensiones y modelo de color de "bolita"
     
     BufferedImage bolita_final = new BufferedImage(23, 23, 1);
     
 
     
     
}
     
 //====================== IMPLEMENTACION GRAFICA =============================
    
    public void Paint(Graphics2D g){
        
        g.drawOval(307, 282, 20, 20);
        
        g.setBackground(Color.yellow);
        
        
        
        BufferedImage fondo = new BufferedImage(WIDTH, HEIGHT, HEIGHT);
        
//        g.drawImage(gif, op, WIDTH, WIDTH);
        
        
    }
//     public void fillRect(int 307, int 282, int 20, int 20) {
//             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//         }        

    
    
    
    
    /*
    Metodo que nos entrega la coordenda en x; String -> entero
    
    */
    
    public Integer posicionX(String datox){
        
        int cordX = 0;
        cordX = Integer.parseInt(datox);
        return cordX; 
    }
    
    /*
    Metodo que nos entrega la coordenda en y; String -> entero
    
    */
    
    public Integer posicionY(String datoy){
        
        int cordY = 0;
        cordY = Integer.parseInt(datoy);
        return cordY; 
    }
    
    
     /*
    
    Metodo que inicia el arreglo de las coordenadas X con datos de clientes
    
    */
    
    public void datosIniciales_X(){
        
        ubicaciones_X_cliente.add(307);
        ubicaciones_X_cliente.add(193);
        ubicaciones_X_cliente.add(189);
        ubicaciones_X_cliente.add(202);
        ubicaciones_X_cliente.add(145);
        
    
      
    }
    
    /*
    
    Metodo que inicia al array de la coordenada Y con datos de clientes
    
    */
    public void datosIniciales_Y(){
        
        ubicaciones_Y_cliente.add(282);
        ubicaciones_Y_cliente.add(229);
        ubicaciones_Y_cliente.add(420);
        ubicaciones_Y_cliente.add(548);
        ubicaciones_Y_cliente.add(429);
        
    
      
    }
    

        
     /*
    Metodo para adicionar la posicion "X" de un nuevo cliente en un array de datos de X
    se pregunta si el array osea la ruta ya esta copada en su maximo "tope" de clientes.
    */
    

    
    /*
    
    Metodo que toma un Arraylist < x > y lo entrega como un arreglo de enteros de las
    coordenadas en X.
    
    */
    

    
    public void arrayX_Arreglox(){
        
        ArrayList array_datosX = new ArrayList();
        
        array_datosX = ubicaciones_X_cliente; //datosx = ubicaciones_X_cliente;
        
        int [] cadenaX = new int[5];// tope maximo de clientes por rutas
        
        for (int i = 0; i < array_datosX.size(); i++) {
            
            cadenaX [i] = Integer.parseInt(array_datosX.get(i).toString());
            
        }
        
        for (int i = 0; i < ubicaciones_X_cliente.size(); i++) {
            
           
            System.out.println("..ubicaciones_X_cliente es ; " + " \n dato " + i + " " + ubicaciones_X_cliente.get(i) );
            
        }
        
        for (int i = 0; i < cadenaX.length; i++) {
            
           System.out.println("..cadenaX es ; " + " \n dato " + i + " valor dela cadena " + cadenaX[i]  );
            
        }
        
    }



}