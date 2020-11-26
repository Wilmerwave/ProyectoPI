/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Wil
 */
public class Vendedor {
private String id;
private String nombre;
private double salario;
private String tipo;



/*
ruta de surtido (Objeto)
infoVenta Arraylist<VentaxProducto>
cliente (Objeto)

*/

    public Vendedor(String id, String nombre, double salario, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.salario = salario;
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    

}
